package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 	//[만족해야할 조건들]
	// 빈 문자열또는 null갑을 입력할 경우 0을 반환해야 함
	// 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다
	// 숫자 두개를 쉼표 구분자로 입력할 경우 두 숫자의 합을 반환한다
	// 구분자를 쉼표 이외에 콜론을 사용할수있다
	// "//" 와 "\n" 문자 사이에 커스텀 수분자를 지정할 수 있다.
	// 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외처리를 한다.

 *
 * 다음 3가지 원칙을 고려해서 리팩토링 하기
 * - 1) 한 메서드는 하나의 책임만 갖기-V
 * - 2) 인덴트(indent) 의 깊이(depth)는 2이상되지 않도록 하기-V
 * - 3) else 문은 사용하지 않기-V
 *
 * */

public class StringCalculator {

	// 문자열숫자 총합 계산 수행 메서드
	public int calculateStrNumSum(String param) {
		String[] arrs = null;

		if(param.isEmpty() || param == null) {
			return 0;
		}

		if(param.length() == 1 && Character.isDigit(param.charAt(0)) ) {
			return Integer.parseInt(param);
		}

		if(param.length() != 1 && isStrAllNum(param)) {
			return Integer.parseInt(param);
		}

		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(param);
		if(matcher.find()) { // 커스텀구분자로 오는 문자열값은 구분자 외의 값은 순수하게 숫자뿐인가?
			arrs = getNumsByCustomDivider(param, matcher);
		}

		if(param.contains(",") || param.contains(":")) {
			arrs = getNumsByBasicDivider(param);
		}

		isThereNegativeNumber(arrs);

		return sumNumbers(arrs);
	}


	// 커스텀구분자 기준으로 구분하여 숫자들 얻기
	public String[] getNumsByCustomDivider(String param, Matcher matcher) {
		String customDelimeter = matcher.group(1);
		String targetStr = matcher.group(2);
		return targetStr.split(customDelimeter);
	}

	// 기본구분자 기준으로 구분하여 숫자들 얻기
	public String[] getNumsByBasicDivider(String param) {
		return param.split(",|:");
	}

	// 음수가 존재한는지 확인
	public void isThereNegativeNumber(String[] strNums) {
		for(String strNum : strNums) {
			if(Integer.parseInt(strNum) < 0) throw new RuntimeException();
		}
	}

	// 숫자들 전부 더한값 얻기
	public int sumNumbers(String[] strNums) {
		int sum = 0;
		for(String strNum : strNums) {
			sum += Integer.parseInt(strNum);
		}
		return sum;
	}

	// 문자열 값이 전부 숫자값인지 확인하기
	public boolean isStrAllNum(String strVal) {
		boolean allNumFlag = true;
		for(int i=0; i<strVal.length(); i++) {
			if( !(Character.isDigit(strVal.charAt(i))) ) allNumFlag = false;
		}
		return allNumFlag;
	}

}




/*
	// 커스텀구분자 기준으로 구분하여 숫자들 얻기
	public String[] getNumsByCustomDivider(String param) {
		int leftMarkIndex = param.lastIndexOf("//");
		int rightMarkIndex = param.lastIndexOf("\n");
		String customDivider = param.substring(leftMarkIndex+2, rightMarkIndex);
		String cleanedParam = param.substring(rightMarkIndex+1);
		return cleanedParam.split(customDivider);
	}
 */