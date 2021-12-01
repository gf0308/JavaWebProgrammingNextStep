package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SplitTest {

	@Test
	public void split() {
		String[] values = "1".split(",");
		assertArrayEquals(new String[] {"1"}, values);
//		assertEquals(new String[] {"1"}, values);	// -> 결과값으로 배열인것을 테스트해볼때는 assertArrayEquals메서드를 사용해야 한다. 안그러면 에러가 발생한다

		values = "1,2".split(",");
		assertArrayEquals(new String[] {"1", "2"}, values);

		// 예상한 배열결과값으로 리턴되어짐을 확인할 수 있었다.

		// 이렇게, 특정 메서드에 대해서 더 자세히 알아보고 확인해볼 목적으로 테스트용메서드를 만들어서 사용해볼수도 있다..!(정말 편리함)
	}

}
