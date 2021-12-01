package calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalCulatorTest {

	// 아래처럼 테스트코드, 즉 테스트 케이스들이 중요한 이유는 프로그램의 규모가 크고 포함하고 있는 기능이 정말 많을 때,
	// 어떤 기능을 추가하거나 수정하면 기존의 기능과 잘 호환되고 문제없이 잘 구동되는지 점검을 해야 할 것인데
	// 기능이 한두개도아니고 수백개가 넘어가기 시작하면 한기능 한기능 직접 테스트를 해보는 것은 불가능에 가까워진다(메인메서드에서 직접 실행해보고 하는 방식으로는 답이 없게 된다)
	// 게다가 이는 프로그램이 커지면 커질수록, 테스트할 기능이 수백 수천개가 될수록 더 답이 없어지게 된다.
	// 따라서 '테스트로서 실행했을 때 정상적으로 잘나와야할 체크작업'을 '미리' 케이스(case)로서 다 만들어 놓고, 필요할 때 마다 이용하면 일일이 테스팅을 위한 코드 작성 할 필요 없이 바로 '테스트해봐야할 전 기능을 일제히 실행해서 확인' 해 볼 수 있다.
	// 이 때문에 큰 회사일수록, 큰 시스템일수록 테스트를 해야 할 수천 수만개의 테스트케이스를 일제히 필요할때마다 실행해보고 원하는 결과를 확인해보는 것이 너무나도 유용하고 시간을 아낄수있게 되는 것인 것이다.

	private StringCalCulator cal;

	@BeforeEach
	public void setup() {
		cal = new StringCalCulator();
	}

	@Test
	public void add_null_또는_빈문자() {
		assertEquals(0, cal.add(null));
		assertEquals(0, cal.add(""));
	}

	@Test
	public void add_숫자하나() throws Exception {
		assertEquals(1, cal.add("1"));
	}

	@Test
	public void add_쉼표구분자() throws Exception {
		assertEquals(3,  cal.add("1,2"));
	}

	@Test
	public void add_쉼표_또는_콜론_구분자() throws Exception {
		assertEquals(6,  cal.add("1,2:3"));
	}

	@Test
	public void add_custom_구분자() throws Exception {
		assertEquals(6, cal.add("//;\n1;2;3"));
	}

	//@org.junit.Test(expected = RuntimeException.class) // JUnit4 경우
	@Test
	public void add_negative() throws Exception {
		// junit5에서 exception테스트를 하려면 assertThrows() 를 사용하면 된다.
//		assertThrows(RuntimeException.class, () -> cal.add("-1,2:3") ); // 이렇게 해도 되고
		assertThrows(RuntimeException.class, () -> {
			cal.add("-1,2:3");
		});
		// 이렇게 해도 된다.
	}

}
