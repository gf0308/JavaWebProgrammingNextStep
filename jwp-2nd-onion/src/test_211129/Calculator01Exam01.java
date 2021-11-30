package test_211129;

/*
 * - Ŀ���ұ����ڴ� ���Թ��ڿ��� �տ� �´�
 * - �Ϲݱ�����, Ŀ���ұ����ڷ� ���еǾ� ǥ���� ���ڹ��ڿ��� �ݵ�� ���ڰ��� �����ڷθ� �̷���� ä�� ���԰����� ����´�, �������� ���ڵ�� �������� �ʴ´�
 * */

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


	// Ŀ���ұ����ڷ� ���ڰ� �迭 ���
	public String[] getNumsByCustomDivider(String param) {
		int leftMarkIndex = param.lastIndexOf("//");
		int rightMarkIndex = param.lastIndexOf("\n");
		String customDivider = param.substring(leftMarkIndex+2, rightMarkIndex);
		String cleanedParam = param.substring(rightMarkIndex+1); // Ŀ���ұ����ڸ� �������� ���ø��ϱ� ��, ���Թ��ڿ������� �����ںκ��� �������ֱ�
		return cleanedParam.split(customDivider);
	}

	// ��б����ڷ� ���ڰ� �迭 ���
	public String[] getNumsByBasicDivider(String param) {
		return param.split(",|:");
	}

	// �������� üũ�ϱ�
	public void isThereNegativeNumber(String[] strNums) {
		for(String strNum : strNums) {
			if(Integer.parseInt(strNum) < 0) {
				throw new RuntimeException();
			}
		}
	}

	// ���ڰ� ���� ���
	public int sumNumbers(String[] strNums) {
		int sum = 0;
		for(String strNum : strNums) {
			sum += Integer.parseInt(strNum);
		}
		return sum;
	}

}
