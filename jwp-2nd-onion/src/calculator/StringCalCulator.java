package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalCulator {

	public int add(String text) {
		if(isBlank(text)) {
			return 0;
		}

		return sum(toInts(split(text)));
		// 만약 이 코드를 처음보는 개발자라도, 이 부분만 보고도 이 코드 한 줄로 이 함수에서 일어나는 처리를 바로 이해 가능함.
		// => 아래의 구체적인 구현부에 관심을 가질 필요가 없음, 이 부분으로만 보고도 이해가 가능하므로 -> 이렇게 '이해가 바로 되는, 빨리 파악이 가능한 코드'가 좋은 코드이며 이렇게 코드를 만들기 위한 것이 리팩토링인 것이다.
	}


	private boolean isBlank(String text) {
		return text == null || text.isEmpty();
	}

	private String[] split(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if(m.find()) {
			String customDelimeter = m.group(1);
			return m.group(2).split(customDelimeter);
		}
		// else는 없어도 되는 경우, 꼭 필요하지 않은 경우에는 가급적 사용하지 않는 것이 가독성이 좋은 코드를 만드는데 좋다.
		// else 를 사용할 경우에 생길수있는 문제는 코드의 indent(인덴트)의 깊이(depth)가 깊어지기 쉽다는 것이다.
		// 인덴트의 깊이가 깊지 않을 수록 코드의 가독성이 높아진다.

		return text.split(",|:"); 	// 위 표현식에 부합하지 않는 텍스트인경우 -> 커스텀구분자 케이스가 아님 -> 일반구분자로 된 케이스
	}

	private int[] toInts(String[] values) { // strToInts : 모든 문자열을 숫자배열로 반환하는 메서드
		int[] numbers = new int[values.length];
		for(int i = 0; i < values.length; i++) {
			int number = toPositive(values[i]);
			numbers[i] = number;
		}
		return numbers;
	}


	private int toPositive(String value) {
		int number = Integer.parseInt(value);
		if(number < 0) {
			throw new RuntimeException();
		}
		return number;
	}

	// 깔끔하고 가독성 좋은 코드를 작성하는 기본 원칙 중 하나는, 한 메서드는 하나의 일만(책임만) 하게 한다는 것이다.
	// 이런 면에서 sum메서드는 지금 2가지 일을 하고 있는 것이다 : 숫자를 더해주기 / '문자를 숫자로 변환해주기' -> 이것까지 하고 있는 것이다..!
	private int sum(int[] numbers) {
		int sum = 0;
		for(int number : numbers) {
			sum += number;
		}
		return sum;
	}

}
