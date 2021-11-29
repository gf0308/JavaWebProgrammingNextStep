package basic_package;

import static org.junit.jupiter.api.Assertions.*;

/*import org.junit.After;
import org.junit.Before;*/
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest_tempChange {

	private Calculator cal;

	@BeforeEach		// junit5���� @Before -> @BeforeEach �� �ٲ�
	public void setUp() { // �ʱ�ȭ �۾�
		cal = new Calculator();
		System.out.println("setUp!!");
	}

	@Test
	public void add() {
		assertEquals(3, cal.add(2, 1));		// assertEquals(�����ϴ°�, �������)
		System.out.println("add!");
	}

	@Test
	public void divide() {
		assertEquals(3, cal.divide(9, 3));
		System.out.println("divide!");
	}

	@AfterEach	// junit5���� @After -> @AfterEach �� �ٲ�
	public void teardown() { // ��ó�� �۾�
		System.out.println("teardown!!");
	}

	// JUnit�� '��ó�� �۾�/��ó�� �۾�'�� ������ �ΰ� �̸� �� �׽�Ʈ ���� �Ź� ����Ǿ����� �����ν�
	// '�� �׽�Ʈ ���� ������'�� �����ϵ��� �ϰ� �ִ� (@BeforeEach, @AfterEach ������)

}

	// JUnit�� 'Calculator cal = new Calculator();' ������ ����ʵ带 ���� ������ �����س��� ���� ������ �ʴ´�, �̷� ����� �׽�Ʈ�� �־ ���輺�� �ִ�.
	// ���� ��� ���� ���� ����� CalculatorTest�� ���� �� Calculator��ü ������ 1�� �̷����µ�, �̸� ���� �׽�Ʈ�޼����(add,divide,,,)�� �Բ� �����ؼ� ���� �ȴ�.
	// -> �嵥 �̷��� �� �޼���(ex: add)�� �۾� �� �۾� ����� cal��ü ���¸� �����ų �� �ִ�, �׸��� �׷��� �Ǹ� �ٸ� ��ü�� cal��ü�� �̿��� �� test����� ���������� ������� ���� ���ɼ��� �ִ�.

	// �̷��� ������ �����ϰ� ������ �ʱ�ȭ�� ���Ͽ�, ��� @Before��� �ֳ����̼��� �����ϰ� �ִ�
	// @Before �� �� �޼��� ������ ��� => '����ʵ��� �ʱ�ȭ' �� �����ϴ� �׽�Ʈ�޼��带 ����� ������ ���Ѵ�
	// -> �� �׽�Ʈ ���� �� ���� �׶� �׶� ����ʵ� �ʱ�ȭ�� �Ź� ������

	// @Before �޼��带 ���Ͽ� , �� �׽�Ʈ���� ����Ǳ� ��(before) ���� ������ �ʿ��� ��ó��(ex: Calculator �ν��Ͻ� ����)�� �Ź� ���ְ� �ȴ�.
	// -> �̷� ���� �� �׽�Ʈ�� �׽�Ʈ �� ����ϴ� �غ�(ex: cal ��ü ��)�� '����������, �ڱ� ��������' �� ����� �� �ִ� (�� �׽�Ʈ ���� �ڱⰡ ����ϴ� ��ü�� �������� �����ϴ� ��)
	// -> �׷����ν� ������ �׽�Ʈ�� �����̳� ������ ���� �ʵ��� �ϰ� �������� �׽�Ʈ ������ �޼��Ѵ�.

/*
 *
 * Junit���� @Before�� setUp() ���� ��ü ���� �ʱ�ȭ�� ���ִ� ����
 *
 * 1. Exception �߻� �� ������ ���� ������ ���Ͽ�
 *   : setUp()���� ���ܰ� �߻��ϸ� JUnit�� ������ ����Ʈ���̽� ������ ����������,
 *     �����ڿ��� ���ܰ� �߻��ϸ� �׳� �׽�Ʈ ��ü�� �� ����� ���̱� ������ ������ ������ ���� �� ����.
 *
 * 2. Best Practice�̱� ����
 *   : �׽�Ʈ�Ϸ��� Ŭ������ �ν��Ͻ��� �׽�Ʈ �Ǵ� setUp()���� �����ϰ�, �׽�Ʈ ����� �ƴ� �Ӽ�����
 *     �ʵ忡�� ���� new�� �����ص� �������
 *
 * 3. @RunWith, @Rule ���� �ֳ����̼��� ����Ͽ� Ȯ���ϴ� ����� �̿��ϱ� ����
 *   : "@Before �׽�Ʈ �޼��� �ȿ����� @RunWith, @Rule���� �ʱ�ȭ �� ��ü�� ������ �� �ִ�"�� ��������� ����.
 *    -> ���� ������ @Before �׽�Ʈ �޼��忡�� �ʱ�ȭ �۾��� �ϴ� ���� ���� ������ �߻��� ���ɼ��� ���� �� ����.
 *
 * */

