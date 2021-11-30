package calculator;

public class StringCalculatorImpl {
	public static void main(String args[]) {

		StringCalculator sc = new StringCalculator();

//		String param = "12,23:34";
		String param = "//;\n1;2;3";
//		String param = "//;\n12;2;33";
//		String param = "//;\n12;2;-33";
//		String param = "12355";

		int resultSum = sc.calculateStrNumSum(param);


		System.out.println("resultSum: " + resultSum);
	}

}
