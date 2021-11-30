package basic_package;

import static org.junit.jupiter.api.Assertions.*;

/*import org.junit.After;
import org.junit.Before;*/
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest_tempChange {

	private Calculator cal;

	@BeforeEach		// junit5부턴 @Before -> @BeforeEach 로 바뀜
	public void setUp() { // 초기화 작업
		cal = new Calculator();
		System.out.println("setUp!!");
	}

	@Test
	public void add() {
		assertEquals(3, cal.add(2, 1));		// assertEquals(예상하는값, 실제결과)
		System.out.println("add!");
	}

	@Test
	public void divide() {
		assertEquals(3, cal.divide(9, 3));
		System.out.println("divide!");
	}

	@AfterEach	// junit5부턴 @After -> @AfterEach 로 바뀜
	public void teardown() { // 후처리 작업
		System.out.println("teardown!!");
	}

	// JUnit은 '전처리 작업/후처리 작업'을 별도로 두고 이를 각 테스트 마다 매번 수행되어지게 함으로써
	// '각 테스트 간의 독립성'을 보장하도록 하고 있다 (@BeforeEach, @AfterEach 등으로)

}

	// JUnit은 'Calculator cal = new Calculator();' 식으로 멤버필드를 직접 빼놓고 선언해놓는 것을 권하지 않는다, 이런 방식은 테스트에 있어서 위험성이 있다.
	// 예를 들어 위와 같은 방식은 CalculatorTest의 실행 시 Calculator객체 생성이 1번 이뤄지는데, 이를 여러 테스트메서드들(add,divide,,,)이 함께 공유해서 쓰게 된다.
	// -> 헌데 이러면 한 메서드(ex: add)가 작업 중 작업 결과가 cal객체 상태를 변경시킬 수 있다, 그리고 그렇게 되면 다른 객체가 cal객체를 이용할 때 test결과가 정상적으로 수행되지 않을 가능성이 있다.

	// 이러한 문제를 방지하고 안전한 초기화를 위하여, 대신 @Before라는 애너테이션을 지원하고 있다
	// @Before 를 단 메서드 제작해 사용 => '멤버필드의 초기화' 를 수행하는 테스트메서드를 만들어 쓰도록 권한다
	// -> 매 테스트 실행 시 마다 그때 그때 멤버필드 초기화를 매번 수행함

	// @Before 메서드를 통하여 , 각 테스트들이 실행되기 전(before) 마다 새로이 필요한 전처리(ex: Calculator 인스턴스 생성)를 매번 해주게 된다.
	// -> 이로 인해 각 테스트는 테스트 시 사용하는 준비물(ex: cal 객체 등)을 '독립적으로, 자기 전용으로' 얻어서 사용할 수 있다 (각 테스트 마다 자기가 사용하는 객체의 독립성을 보장하는 것)
	// -> 그럼으로써 각자의 테스트에 지장이나 영향이 가지 않도록 하고 정상적인 테스트 수행을 달성한다.

/*
 *
 * Junit에서 @Before나 setUp() 으로 객체 생성 초기화를 해주는 이유
 *
 * 1. Exception 발생 시 유용한 정보 습득을 위하여
 *   : setUp()에서 예외가 발생하면 JUnit이 유용한 스택트레이스 정보를 돌려주지만,
 *     생성자에서 예외가 발생하면 그냥 테스트 객체를 못 만드는 것이기 때문에 유용한 정보를 얻을 수 없음.
 *
 * 2. Best Practice이기 때문
 *   : 테스트하려는 클래스의 인스턴스는 테스트 또는 setUp()에서 생성하고, 테스트 대상이 아닌 속성들은
 *     필드에서 직접 new로 생성해도 상관없음
 *
 * 3. @RunWith, @Rule 같은 애너테이션을 사용하여 확장하는 기능을 이용하기 위해
 *   : "@Before 테스트 메서드 안에서만 @RunWith, @Rule에서 초기화 된 객체에 접근할 수 있다"는 제약사항이 있음.
 *    -> 따라서 가능한 @Before 테스트 메서드에서 초기화 작업을 하는 것이 추후 문제가 발생할 가능성을 없앨 수 있음.
 *
 * */

