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
public class StringCalculator {

	public static void main(String[] args) {

		int sum = 0;
		String seperators = ",|:";
		Scanner sc = new Scanner(System.in);

		System.out.print("구분자로 구분된 숫자값 문자열을 투입하세요\n: ");
		String inputStr = sc.next();
		sc.close();

		String customSeperator = null;
		// 혹시 투입inputStr 내에 // 와 \n 기호표식이 포함되어 있는지 체크
		//if(inputStr.contains("///") && inputStr.contains("\\n")) {
		if(inputStr.contains("&&") && inputStr.contains("$$")) { // 이건 좀 대충한 방식이고, String.matches(regex)로 정규표현식을 이용해 "//커스텀기호\n" 식의 내용이 포함되어있는지를 정확하게 진단하는 코드 작성해보기
			customSeperator = inputStr.substring(inputStr.lastIndexOf("&&")+1, inputStr.lastIndexOf("$$")+1);
			seperators += "|" + customSeperator;
		}
		// 디버거켜서 찍어보면서 알아보기

		String[] strSplitArr = inputStr.split(seperators);

		for(String st : strSplitArr) {
			sum += Integer.parseInt(st);
		}

		System.out.println("sum: "+sum);

		// 구분자에 해당하는 값이 있으면 구분자(들)을 기준으로 각 값을 분리해낸다
		// 아마 .split() 으로 배열로 전체결과가 얻어질것

		// 분리해내서 얻은 각 값 모음들을 전부 정수화해서 더해 합을 구한다

		// 리턴


	}

}
