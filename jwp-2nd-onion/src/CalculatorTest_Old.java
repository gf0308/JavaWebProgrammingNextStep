
public class CalculatorTest_Old {

	//=================================================== JUnit을 적용하기 전===============================================================

	/*public static void main(String[] args) {
		Calculator cal = new Calculator();

		add(cal);
		subtract(cal);
		multiply(cal);
		divide(cal);
	}

	// 각 기능 메서드를 테스트해보는 테스트코드를 메서드 별로 분리
	private static void add(Calculator cal) {
		System.out.println(cal.add(9, 3));
	}

	private static void subtract(Calculator cal) {
		System.out.println(cal.subtract(9, 3));
	}

	private static void multiply(Calculator cal) {
		System.out.println(cal.multiply(9, 3));
	}

	private static void divide(Calculator cal) {
		System.out.println(cal.divide(9, 3));
	}*/

	/* 이 방식도 궁극적 해결책이 될 순 없음
	 * - 문제(1) : Calculator 클래스가 갖고 있는 모든 메서드를 테스트 해볼 수 밖에 없음 (그렇다고 테스트할 메서드만 남기고 다른 메서드들은 주석처리하는 것은 불합리한 작업임)
	 * - 문제(2) : 테스트 결과 출력되는 결과값을, 매번 콘솔창을 통해 직접 수동으로 확인해야 함 ( 만약 이 코드이 내용이 엄청 길고, 짠지 오랜 시간이 지난 후에 보게 된다면, 테스트결과 나와야 하는 값이 무엇인지 기억도 안날것이고 머리속으로 계산하더라도 공연히 시간을 소요할 것임)
	 *
	 * => 이런 문제를 해결하기 이해 나온 라이브러리가 'JUnit'
	 *   : 내가 테스트하고 싶은 메서드만 테스트를 할 수 있음
	 *    + 로직 실행 후 (예상)결과값이 맞는지 확인하는 작업을 자동화 할 수 있음(ex: assertEquals() 등의 기능으로)
	 *
	 * */

}
