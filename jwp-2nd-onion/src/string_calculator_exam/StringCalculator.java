package string_calculator_exam;

import java.util.Scanner;

/* ���ڿ� ���� ���� �䱸����
 *
 * ��ǥ(,) �Ǵ� �ݷ�(:)�� �����ڷ� ������ ���ڿ� ���ڵ��� ���޵Ǹ� �����ڸ� �������� ���� �и��� �� ���ڰ����� ���� ��ȯ�Ѵ�
 * ex) " " => 0
 *     "1,2" => 3
 *     "1,2,3" => 6
 *     "1,2:3" => 6
 *
 * �⺻������(�� 2����) �ܿ� Ŀ���� �����ڰ� ������ �� �ִ�. Ŀ���ұ����ڴ� ���ڿ� �պκп� "//"�� "\n"�� ���̿� ��ġ�ϴ� ���ڰ� Ŀ���� �����ڴ�.
 * ex) "//;\n1;2;3" => (;�� Ŀ���ұ�����) => 6
 *
 * ���ڿ� ���⿡ ������ ���޵Ǵ� ��� 'RuntimeException'���� ����ó���� �Ǿ����� �Ѵ�.
 * */
public class StringCalculator {

	public static void main(String[] args) {

		int sum = 0;
		String seperators = ",|:";
		Scanner sc = new Scanner(System.in);

		System.out.print("�����ڷ� ���е� ���ڰ� ���ڿ��� �����ϼ���\n: ");
		String inputStr = sc.next();
		sc.close();

		String customSeperator = null;
		// Ȥ�� ����inputStr ���� // �� \n ��ȣǥ���� ���ԵǾ� �ִ��� üũ
		//if(inputStr.contains("///") && inputStr.contains("\\n")) {
		if(inputStr.contains("&&") && inputStr.contains("$$")) { // �̰� �� ������ ����̰�, String.matches(regex)�� ����ǥ������ �̿��� "//Ŀ���ұ�ȣ\n" ���� ������ ���ԵǾ��ִ����� ��Ȯ�ϰ� �����ϴ� �ڵ� �ۼ��غ���
			customSeperator = inputStr.substring(inputStr.lastIndexOf("&&")+1, inputStr.lastIndexOf("$$")+1);
			seperators += "|" + customSeperator;
		}
		// ������Ѽ� ���鼭 �˾ƺ���

		String[] strSplitArr = inputStr.split(seperators);

		for(String st : strSplitArr) {
			sum += Integer.parseInt(st);
		}

		System.out.println("sum: "+sum);

		// �����ڿ� �ش��ϴ� ���� ������ ������(��)�� �������� �� ���� �и��س���
		// �Ƹ� .split() ���� �迭�� ��ü����� �������

		// �и��س��� ���� �� �� �������� ���� ����ȭ�ؼ� ���� ���� ���Ѵ�

		// ����


	}

}
