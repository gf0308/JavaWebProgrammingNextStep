package test_211129;

/*
 * ����(Ȥ�� ���ڿ�)�� ���ڰ����� �Ǻ����ִ� �ڹ� api �޼���
 * - Character.isDigit(char val)
 *
 * */
public class Calculator01Exam01Impl {

	public static void main(String[] args) {
		String param = "12,23:34";
//		String param = "//;\n1;2;3";
//		String param = "//;\n12;2;33";
//		String param = "//;\n12;2;-33";

		Calculator01Exam01 cal = new Calculator01Exam01();

		int resultSum = cal.calculateStrNumSum(param);

		System.out.println("resultSum: " + resultSum);
	}

}
