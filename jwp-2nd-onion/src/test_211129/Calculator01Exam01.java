package test_211129;

/*
 * 다음 3가지 원칙을 고려해서 리팩토링 하기
 * - 1) 한 메서드는 하나의 책임만 갖기-V
 * - 2) 인덴트(indent) 의 깊이(depth)는 2이상되지 않도록 하기-V
 * - 3) else 문은 사용하지 않기-V
 *
 * */

public class Calculator01Exam01 {

	// 문자열숫자 총합 계산 수행 메서드
	public int calculateStrNumSum(String param) {
		String[] arrs = null;

		if(param.contains("//") && param.contains("\n")) {
			arrs = getNumsByCustomDivider(param);
		}

		if(param.contains(",") || param.contains(":")) {
			arrs = getNumsByBasicDivider(param);
		}

		isThereNegativeNumber(arrs);

		return sumNumbers(arrs);
	}

	// 커스텀구분자 기준으로 구분하여 숫자들 얻기
	public String[] getNumsByCustomDivider(String param) {
		int leftMarkIndex = param.lastIndexOf("//");
		int rightMarkIndex = param.lastIndexOf("\n");
		String customDivider = param.substring(leftMarkIndex+2, rightMarkIndex);
		String cleanedParam = param.substring(rightMarkIndex+1);
		return cleanedParam.split(customDivider);
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

}
