package array;

public class BookArray {

	public static void main(String[] args) {
		
//		책을 담을 책장 공간을 5개 만든 것.
//		책을 5개 만든 게 아님. 책은 new Book()으로 따로 생성해야 함.
		Book[] library = new Book[5];
		
		for (int i = 0; i < library.length; i++) {
			System.out.println(library[i]);
		}
		
		library[0] = new Book("태백산맥", "조정래");
		library[1] = new Book("데미안", "헤르만 헤세");
		library[2] = new Book("어떻게 살 것인가", "유시민");
		library[3] = new Book("토지", "박경리");
		library[4] = new Book("어린왕자", "생택쥐페리");
		
		for (int i = 0; i < library.length; i++) {
			library[i].showBookInfo();
		}
	}

}
