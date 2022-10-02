package part3.java.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("001", "kim");
		map.put("002", "lee");
		map.put("003", "choi");
		
//		map에서 중복된 key 삽입의 경우
		map.put("001", "kang");
		System.out.println(map.size());
		
//		System.out.println(map.get("001"));
//		System.out.println(map.get("002"));
//		System.out.println(map.get("003"));
		
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);
			System.out.println("{ " + key + ", " + value + " }");
		}
	}

}
