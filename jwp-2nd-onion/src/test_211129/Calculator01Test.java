package test_211129;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Calculator01Test {

//	private Calculator01 cal = new Calculator01(); // ���� �׽�Ʈ�޼��忡�� ������ ����ϴٺ��� cal ��ü���� ������ ���� ��쵵 �߻����� -> �̷��� �� �� �ٸ� �׽��ø޼���� �̸� ���� �׽�Ʈ����� �ٲ���ִ� ���� �߻� ����
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
