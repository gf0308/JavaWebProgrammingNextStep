package test_211129;

public class Calculator01Exam01 {

	// 메인 수행 메서드
	public int calculateStrNumSum(String param) {
		String[] arrs = null;

		if(param.contains("//") && param.contains("\n")) { // 커스텀 구분자로 구분된 경우
			arrs = getNumsByCustomDivider(param);
		}

		if(param.contains(",") || param.contains(":")) { // 기본 구분자로 구분된 경우
			arrs = getNumsByBasicDivider(param);
		}

		isThereNegativeNumber(arrs); // 요소 중 음수인 값이 있는지 확인 : true라면 RuntimeException 반환

		return sumNumbers(arrs); // 요소들을 다 더한다
	}


	public String[] getNumsByCustomDivider(String param) {
		int leftMarkIndex = param.lastIndexOf("//");    // -이걸로 되나?
		int rightMarkIndex = param.lastIndexOf("\n");  // -이걸로 되나?
		String customDivider = param.substring(leftMarkIndex, rightMarkIndex-1);
		return param.split(customDivider);
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
