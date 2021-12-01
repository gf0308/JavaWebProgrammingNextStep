package calculator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

/*
 * Matcher와 Pattern 클래스의 기능을 테스트해보는 테스트 클래스
 * */
class MatcherTest {

	@Test
	void test() {
		String inputStr = "//;\n1;2;3";
		String regex = "//(.)\n(.*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputStr);

		if(matcher.find()) {
			assertEquals(";", matcher.group(1));
			assertEquals("1;2;3", matcher.group(2));
		} else {
			System.out.println("표현식에 부합하지 않는 값입니다");
		}

	}

}
