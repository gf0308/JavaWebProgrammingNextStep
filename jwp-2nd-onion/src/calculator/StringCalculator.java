package calculator;

public class StringCalculator {

	int add(String text) { // text�� �ݵ�� ���ڸ� �����ϸ�, �ݵ�� �⺻������ Ȥ�� Ŀ���ұ����ڸ� ������ ���ڿ��� ���Եȴ�
							// �����ڴ� �⺻�����ڸ� ���ų� or Ŀ���ұ����ڰ����̸� Ŀ���ұ����ڸ� ����ִ�

		// ���԰��� ���̰ų� null�ϰ�� : 0�� ��ȯ
		if(text == null || text.isEmpty()) { // text.isEmpty() = text.equals("") ����.
			return 0;
		}

		// ���� �⺻������(�� �������� , : �ΰ�)�� ���еǾ�������� �⺻�����ڸ� �������� ���� �и��ؼ� ���Ѵ�
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

		// Ŀ���� �����ڸ� ����ϰ� ���� ��� : Pattern.match Ȥ�� Pattern.complie �� �����Ѱ��� ������ ����� �Ǻ�


		// ������ ���ԵǾ��� ��� RuntimeException �� ��ȯ




//		return 0;
	}

}
