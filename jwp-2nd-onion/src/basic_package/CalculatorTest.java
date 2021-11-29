package basic_package;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/* @TestInstance
 *
 * JUnit에서 @TestInstance 은 '테스트 인스턴스의 라이프사이클'을 설정할 때 사용한다.
	 - PER_METHOD : Test 메서드 당 인스턴스를 생성
	 - PER_CLASS : Test클래스 당 인스턴스를 생성
 *
 * 라이프사이클을 클래스단위로 지정해놓으면 @BeforeAll/@AfterAll 등을 static이 아닌 메서드에서도 사용할 수 있다
 * (참조: https://awayday.github.io/2017-11-12/junit5-05/)
 * */

//@TestInstance(Lifecycle.PER_METHOD) -- 요 표기의 효능은 뭐지?
//@TestInstance(Lifecycle.PER_CLASS) // 클래스 단위의 인스턴스 생명주기를 설정하면 non static 메서드에서도 @BeforeAll/@AfterAll 을 바로 쓸수있다.
class CalculatorTest {

	private Calculator cal;

	@BeforeEach
	public void init() {
		cal = new Calculator();
		System.out.println("init cal!");
	}

	@AfterEach
	public void finish() {
		cal = null;
		System.out.println("finish cal!");
	}

	// @BeforeAll/@AfterAll 은 기본적으로 static 메서드에 붙일 수 있다.
	// static이 아닌 곳에도 붙이고 싶다면 해당 테스트클래스에 @TestInstance(Lifecycle.PER_CLASS) 처리가 이뤄져야 한다.
	@BeforeAll
	public static void all_before() {
		System.out.println("========= The Start =========");
	}

	@AfterAll
	public static void all_finish() {
		System.out.println("========= The End =========");
	}


	@Test
	public void test_add() {
		assertEquals(5, cal.add(2,3));
		System.out.println("test add...");
	}

	@Test
	public void test_divide() {
		assertEquals(2, cal.divide(6,3));
		System.out.println("test divide...");
	}

}
