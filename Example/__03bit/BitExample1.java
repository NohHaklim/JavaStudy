package __03bit;

public class BitExample1 {

	public static void main(String[] args) {

//		원소가 n개인 집합에서 부분 집합의 총 개수: 1 << n
		
		char[] data = { 'A', 'B', 'C', 'D' };
		printSubsets(data, 4);
		
	}
	
	static void printSubsets(char[] arr, int n) {
		for (int i = 0; i < (1 << n); i++) {
			System.out.print("{ ");
			for (int j = 0; j < n; j++) {
				if ((i & 1 << j) != 0)
					System.out.print(arr[j] + " ");
			}
			System.out.println("}");
		}
	}
}
