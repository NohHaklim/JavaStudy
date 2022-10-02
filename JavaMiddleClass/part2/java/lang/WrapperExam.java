package part2.java.lang;

public class WrapperExam {
	int i1 = 5;
	
	Integer i2 = new Integer(5);	// Java9 이후 쓰이지 않는 방법
	Integer i3 = 5;					// 오토박싱: 기본 타입을 객체로 자동 변환
	
	int i4 = i3.intValue();
	int i5 = i3;					// 오토언박싱
	
}
