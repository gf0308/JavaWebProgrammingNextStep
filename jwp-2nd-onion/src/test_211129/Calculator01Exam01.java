package test_211129;

/*
 * 다음 3가지 원칙을 고려해서 리팩토링 하기
 * - 1) 한 메서드는 하나의 책임만 갖기
 * - 2) 인덴트(indent) 의 깊이(depth)는 2이상되지 않도록 하기
 * - 3) else 문은 사용하지 않기
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


	public String[] getNumsByCustomDivider(String param) {
		int leftMarkIndex = param.lastIndexOf("//");
		int rightMarkIndex = param.lastIndexOf("\n");
		String customDivider = param.substring(leftMarkIndex+2, rightMarkIndex);
		String cleanedParam = param.substring(rightMarkIndex+1);
		return cleanedParam.split(customDivider);
	}

	public String[] getNumsByBasicDivider(String param) {
		return param.split(",|:");
	}

	public void isThereNegativeNumber(String[] strNums) {
		for(String strNum : strNums) {
			if(Integer.parseInt(strNum) < 0) {
				throw new RuntimeException();
			}
		}
	}

	public int sumNumbers(String[] strNums) {
		int sum = 0;
		for(String strNum : strNums) {
			sum += Integer.parseInt(strNum);
		}
		return sum;
	}

}
