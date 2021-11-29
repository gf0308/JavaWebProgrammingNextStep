package test_211129;

public class Calculator01Exam01Impl {

	public static void main(String[] args) {
		String param = "//;\n1;2;3";

		Calculator01Exam01 cal = new Calculator01Exam01();

		int resultSum = cal.calculateStrNumSum(param);

		System.out.println("resultSum: " + resultSum);

	}

}
