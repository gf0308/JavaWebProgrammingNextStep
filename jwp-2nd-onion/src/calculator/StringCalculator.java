package calculator;

public class StringCalculator {

	int add(String text) { // text는 반드시 숫자를 포함하며, 반드시 기본구분자 혹은 커스텀구분자를 포함한 문자열로 투입된다
							// 구분자는 기본구분자만 쓰거나 or 커스텀구분자가쓰이면 커스텀구분자만 담겨있다

		// 투입값이 빈값이거나 null일경우 : 0을 반환
		if(text == null || text.isEmpty()) { // text.isEmpty() = text.equals("") 동일.
			return 0;
		}

		// 값이 기본구분자(이 예제에선 , : 두개)로 구분되어있을경우 기본구분자를 기준으로 값을 분리해서 더한다
		String[] strArr = text.split(",|:");
		if(strArr.length < 2) {
			return Integer.parseInt(strArr[0]);
		} else {
			int sum = 0;
			for(int i=0; i<strArr.length; i++) {
				sum += Integer.parseInt(strArr[i]);
			}
			return sum;
		}

		// 커스텀 구분자를 사용하고 있을 경우 : Pattern.match 혹은 Pattern.complie 중 적당한것을 선택해 사용해 판별


		// 음수가 투입되었을 경우 RuntimeException 이 반환




//		return 0;
	}

}
