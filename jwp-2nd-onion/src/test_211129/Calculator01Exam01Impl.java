package test_211129;

/*
 * 문자(혹은 문자열)이 숫자값인지 판별해주는 자바 api 메서드
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
