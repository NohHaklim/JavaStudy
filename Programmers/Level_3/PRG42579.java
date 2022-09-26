package Level_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class PRG42579 {
	public int[] solution(String[] genres, int[] plays) {
        
		int[] answer = {};
//		장르 -> (노래 번호, 조회수) 리스트
		HashMap<String, ArrayList<MusicInfo>> map = new HashMap<>();
//		장르 -> 총 조회수
		HashMap<String, Integer> viewsMap = new HashMap<>();
		
//		해쉬맵 채우기
		for (int i = 0; i < genres.length; i++) {
			if (!map.containsKey(genres[i])) {
				map.put(genres[i], new ArrayList<MusicInfo>());
			}
        	map.get(genres[i]).add(new MusicInfo(i, plays[i]));
        	viewsMap.put(genres[i], viewsMap.getOrDefault(genres[i], 0) + plays[i]);
        }
		
//		장르별로 모아둔 노래 정보 리스트 정렬
		Iterator<String> keys = map.keySet().iterator();
		while (keys.hasNext()) {
			String genre = keys.next(); 
			Collections.sort(map.get(genre));
		}
		
//		장르 리스트를 총 조회수에 따라 정렬
		List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(viewsMap.entrySet());
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
//		장르별로 두 곡씩 뽑기.
		int musicCnt = 0;
		for (Entry<String, Integer> entry : entryList) {
			musicCnt += Math.min(map.get(entry.getKey()).size(), 2);
		}
		
		int j = 0;
		answer = new int[musicCnt];
		for (Entry<String, Integer> entry : entryList) {
            int size = map.get(entry.getKey()).size() > 2 ? 2 : map.get(entry.getKey()).size();
            for (int i = 0; i < size; i++) {
            	answer[j++] = map.get(entry.getKey()).get(i).id;
            }
        }
        return answer;
    }
}

class MusicInfo implements Comparable<MusicInfo>{
	int id;
	int views;
	
	public MusicInfo(int id, int views) {
		this.id = id;
		this.views = views;
	}
	
	@Override
	public int compareTo(MusicInfo o) {
		// 양수 의미가, 이 경우엔 바꾸겠다? 의미인 듯함.
		if (o.views > this.views) {
			return 1;
		} else if (o.views < this.views) {
			return -1;
		} else {
			if (o.id < this.id) {
				return 1;
			} else if (o.id > this.id){
				return -1;
			} else {
				return 0;
			}
		}
	}
}

//		비교 함수 사용법 헷갈리기 쉬움