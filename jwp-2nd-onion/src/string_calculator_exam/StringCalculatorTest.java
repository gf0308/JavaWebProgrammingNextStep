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
public class StringCalculatorTest {

	public static void main(String[] args) {

		int sum = 0;
		String str = "12;34,56/78";
		String[] strSplitArr = str.split(";|,|/"); // split() �޼���� ���ڿ� ������ �����ڸ� ������ ����ϰ��� �� ��, �Ķ���Ϳ��� |(���������� ��ȣ)�� ������ ������ �����ָ� �ȴ�.
													// ex) str.split(";|,|/| ");  - ����, �����ݷ�, ������, ������ �����ڷ� �־���.
		for(String st : strSplitArr) {
			sum += Integer.parseInt(st);
		}

		System.out.println("sum: " + sum);
	}

}
