package test_211129;

public class Calculator01Exam01 {

	// ���� ���� �޼���
	public int calculateStrNumSum(String param) {
		String[] arrs = null;

		if(param.contains("//") && param.contains("\n")) { // Ŀ���� �����ڷ� ���е� ���
			arrs = getNumsByCustomDivider(param);
		}

		if(param.contains(",") || param.contains(":")) { // �⺻ �����ڷ� ���е� ���
			arrs = getNumsByBasicDivider(param);
		}

		isThereNegativeNumber(arrs); // ��� �� ������ ���� �ִ��� Ȯ�� : true��� RuntimeException ��ȯ

		return sumNumbers(arrs); // ��ҵ��� �� ���Ѵ�
	}


	public String[] getNumsByCustomDivider(String param) {
		int leftMarkIndex = param.lastIndexOf("//");    // -�̰ɷ� �ǳ�?
		int rightMarkIndex = param.lastIndexOf("\n");  // -�̰ɷ� �ǳ�?
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
