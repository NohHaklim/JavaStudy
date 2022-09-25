package _01;

import java.util.Scanner;
import java.util.ArrayList;

/*
 * 		@ 학생의 이름을 찾아 학번을 출력하시오.
 * 
 */
public class Main {
	public static void main(String[] args) {
		Student stu1 = new Student("학생1", "1");
		Student stu2 = new Student("학생2", "2");
		Student stu3 = new Student("학생3", "3");
		Scanner scan = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();

		list.add(stu1);
		list.add(stu2);
		list.add(stu3);

		while (true) {
			System.out.println("계속 검색을 하고 싶으면 y, 종료하고 싶다면 n");
			String input = scan.next();
			boolean flag = false;

			if (input.equals("y")) {
				System.out.println("학생 이름을 입력해주세요.");
				String name = scan.next();

				for (Student stu : list) {
					if (stu.getName().equals(name)) {
						System.out.println(stu.getName() + "의 학번은 " + stu.getSid() + "입니다.");
						flag = true;
					}
				}
				if (flag == false) {
					System.out.println("없는 이름입니다.");
				}
			} else if (input.equals("n")) {
				break;
			}
		}
		System.out.println("종료합니다.");
		scan.close();
	}
}
