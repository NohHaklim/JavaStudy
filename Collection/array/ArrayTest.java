package array;

/*
 *	@ Array
 *		- 배열은 동일한 자료형을 순차적으로, 선형적으로 저장.
 *		- 중간에 자리가 빌 수 없음.
 *		- 미리 고정 길이로 선언해야 함.
 *		- C언어와 다르게 참조형임.
 *		- 자료형[] 변수명 = new 자료형[길이];
 *		- 자료형[] 변수명 = new 자료형[] { 변수1, 2, ... };
 *		- 자료형[] 변수명 = { 변수1, 2, ... }; -> 잘 안씀. 선언과 동시에만 가능한 문법
 *		- 초기화하지 않을 경우, 자료형에 따라 0, 0.0, null로 초기화.
 *		- 얕은 복사: 주소만 복사
 *		- 깊은 복사를 위해서는 객체를 따로 생성해서 그 객체를 가리켜야 함.
 */
public class ArrayTest {
	public static void main(String[] args) {

//		int[] numbers = new int[] { 0, 1, 2 };
//		System.out.println(numbers.length);

		int[] numbers = new int[3];
		numbers[0] = 0;
		numbers[1] = 1;
		numbers[2] = 2;

		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

//		-------------------------------------------------------

		double total = 1.0;
		double[] num = new double[5];
		num[0] = 10.0;
		num[1] = 20.0;
		num[2] = 30.0;

		for (int i = 0; i < num.length; i++) {
//			 num[3]과 num[4]가 0이라 total이 0이 됨
			total *= num[i];
		}
		System.out.println(total);

//		-------------------------------------------------------

		char[] alpha = new char[26];
		char ch = 'A';

		for (int i = 0; i < alpha.length; i++, ch++) {
			alpha[i] = ch;
		}

		for (char c : alpha) {
			System.out.print(c + " ");
		}
		System.out.print("\n");

//		-------------------------------------------------------

		int[] array1 = { 10, 20, 30, 40, 50 };
		int[] array2 = { 1, 2, 3, 4, 5 };
		
		System.arraycopy(array1, 0, array2, 1, 4);
		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
	}
}
