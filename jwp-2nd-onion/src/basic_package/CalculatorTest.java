package basic_package;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/* @TestInstance
 *
 * JUnit���� @TestInstance �� '�׽�Ʈ �ν��Ͻ��� ����������Ŭ'�� ������ �� ����Ѵ�.
	 - PER_METHOD : Test �޼��� �� �ν��Ͻ��� ����
	 - PER_CLASS : TestŬ���� �� �ν��Ͻ��� ����
 *
 * ����������Ŭ�� Ŭ���������� �����س����� @BeforeAll/@AfterAll ���� static�� �ƴ� �޼��忡���� ����� �� �ִ�
 * (����: https://awayday.github.io/2017-11-12/junit5-05/)
 * */

//@TestInstance(Lifecycle.PER_METHOD) -- �� ǥ���� ȿ���� ����?
//@TestInstance(Lifecycle.PER_CLASS) // Ŭ���� ������ �ν��Ͻ� �����ֱ⸦ �����ϸ� non static �޼��忡���� @BeforeAll/@AfterAll �� �ٷ� �����ִ�.
class CalculatorTest {

	private Calculator cal;

	@BeforeEach
	public void init() {
		cal = new Calculator();
		System.out.println("init cal!");
	}

	@AfterEach
	public void finish() {
		cal = null;
		System.out.println("finish cal!");
	}

	// @BeforeAll/@AfterAll �� �⺻������ static �޼��忡 ���� �� �ִ�.
	// static�� �ƴ� ������ ���̰� �ʹٸ� �ش� �׽�ƮŬ������ @TestInstance(Lifecycle.PER_CLASS) ó���� �̷����� �Ѵ�.
	@BeforeAll
	public static void all_before() {
		System.out.println("========= The Start =========");
	}

	@AfterAll
	public static void all_finish() {
		System.out.println("========= The End =========");
	}


	@Test
	public void test_add() {
		assertEquals(5, cal.add(2,3));
		System.out.println("test add...");
	}

	@Test
	public void test_divide() {
		assertEquals(2, cal.divide(6,3));
		System.out.println("test divide...");
	}

}
