package test_211129;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Calculator01Test {

//	private Calculator01 cal = new Calculator01(); // 여러 테스트메서드에서 가져다 사용하다보면 cal 객체값에 영향이 가는 경우도 발생가능 -> 이러면 그 후 다른 테스팅메서드는 이를 사용시 테스트결과가 바뀔수있는 문제 발생 가능
	private Calculator01 cal;

	@BeforeEach
	public void setup() {
		cal = new Calculator01();
		System.out.println("setup..!");
	}

	@Test
	public void testAdd() {
		assertEquals(3, cal.add(2, 1));
		System.out.println("add....!");
	}

	@Test
	public void testDivide() {
		assertEquals(3, cal.divide(9, 3));
		System.out.println("divide....!");
	}

	@AfterEach
	public void teardown() {
		System.out.println("teardown..!");
	}


}
