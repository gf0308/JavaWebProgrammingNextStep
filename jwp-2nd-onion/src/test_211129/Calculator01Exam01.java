package test_211129;

/*
 * - 커스텀구분자는 투입문자열의 앞에 온다
 * - 일반구분자, 커스텀구분자로 구분되어 표현된 숫자문자열은 반드시 숫자값과 구분자로만 이루어진 채의 투입값으로 날라온다, 쓸데없는 잡코드는 섞여오지 않는다
 * */

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


	// 커스텀구분자로 숫자값 배열 얻기
	public String[] getNumsByCustomDivider(String param) {
		int leftMarkIndex = param.lastIndexOf("//");
		int rightMarkIndex = param.lastIndexOf("\n");
		String customDivider = param.substring(leftMarkIndex+2, rightMarkIndex);
		String cleanedParam = param.substring(rightMarkIndex+1); // 커스텀구분자를 기준으로 스플릿하기 전, 투입문자열값에서 구분자부분은 배제해주기
		return cleanedParam.split(customDivider);
	}

	// 기분구분자로 숫자값 배열 얻기
	public String[] getNumsByBasicDivider(String param) {
		return param.split(",|:");
	}

	// 음수여부 체크하기
	public void isThereNegativeNumber(String[] strNums) {
		for(String strNum : strNums) {
			if(Integer.parseInt(strNum) < 0) {
				throw new RuntimeException();
			}
		}
	}

	// 숫자값 총합 얻기
	public int sumNumbers(String[] strNums) {
		int sum = 0;
		for(String strNum : strNums) {
			sum += Integer.parseInt(strNum);
		}
		return sum;
	}

}
