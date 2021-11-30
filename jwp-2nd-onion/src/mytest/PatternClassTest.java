package mytest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 정규표현식
 * (.) : 문자 1개를 의미 ex) , / # T 1 등 어떠한 문자 1개
 * (..) : 문자 2개를 의미 ex) ,, // 등 어떠한 문자 2개
 * (.*) : 문자 여러개를 의미 ex)  1235T1// .. 등
 *
 * * Pattern.matcher() 를 이용하면 Matcher객체를 얻을 수 있다, 그리고 Matcher객체는 정규표현식 기준으로 group을 구분해서 값을 얻어낼 수 있다.
 * */
public class PatternClassTest {

	public static void main(String[] args) {
//		String text = "//;\n1;2;3#?!;2";
//		Pattern pattern = Pattern.compile("//(.)\n(.*)#(..)");
//		Matcher matcher = pattern.matcher(text);
//		if(matcher.find()) {
//			System.out.println("matcher.group(0): "+matcher.group(0));
//			System.out.println("matcher.group(1): "+matcher.group(1));
//			System.out.println("matcher.group(2): "+matcher.group(2));
//			System.out.println("matcher.group(3): "+matcher.group(3));
//		}

		// 1;2;3 or 1,2,3
//		String text = "1;2;3";
		String text = "1,2,3";
		Pattern pattern = Pattern.compile("(.);(.);(.)|(.),(.),(.)");
//		Pattern pattern = Pattern.compile("[0-9];[0-9]");		// "1;2;3.....;n" 을 정규표현식으로 어떻게 표현하지?
		Matcher matcher = pattern.matcher(text);
		if(matcher.find()) {
			System.out.println("matcher.group(0): "+matcher.group(0));
		}




	}

}
