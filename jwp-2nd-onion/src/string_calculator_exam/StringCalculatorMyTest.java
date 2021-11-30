package string_calculator_exam;

import java.util.Scanner;

/* 문자열 계산기 구현 요구사항
 *
 * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열 숫자들이 전달되면 구분자를 기준으로 값을 분리한 각 숫자값들의 합을 반환한다
 * ex) " " => 0
 *     "1,2" => 3
 *     "1,2,3" => 6
 *     "1,2:3" => 6
 *
 * 기본구분자(위 2가지) 외에 커스텀 구분자가 지정될 수 있다. 커스텀구분자는 문자열 앞부분에 "//"와 "\n"의 사이에 위치하는 문자가 커스텀 구분자다.
 * ex) "//;\n1;2;3" => (;가 커스텀구분자) => 6
 *
 * 문자열 계산기에 음수가 전달되는 경우 'RuntimeException'으로 예외처리가 되어져야 한다.
 * */
public class StringCalculatorMyTest {

	public static void main(String[] args) {

		int sum = 0;
		String str = "12;34,56/78";
		String[] strSplitArr = str.split(";|,|/"); // split() 메서드로 문자열 나눠줄 구분자를 여러개 사용하고자 할 떈, 파라미터에서 |(파이프라인 기호)로 나눠서 여러개 적어주면 된다.
													// ex) str.split(";|,|/| ");  - 반점, 세미콜론, 슬래시, 공백을 구분자로 주었다.
		for(String st : strSplitArr) {
			sum += Integer.parseInt(st);
		}

		System.out.println("sum: " + sum);
	}

}
