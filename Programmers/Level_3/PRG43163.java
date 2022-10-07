package Level_3;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 		@ 게임 맵 최단거리
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/1844
 *		@
 *		@ 1. 현재 단어에서 변경이 가능한 단어들을 탐색
 *		@ 2. BFS를 이용해 꾸준히 변화
 *		@ 3. target 단어 발견 시 종료.
 */

public class PRG43163 {
	
	boolean[] visited;
	
	public int solution(String begin, String target, String[] words) {
        
		visited = new boolean[words.length];
        return BFS(begin, target, words);
    }
	
	public int BFS(String begin, String targegt, String[] words) {
		Queue<Word> q = new LinkedList<>();
		q.offer(new Word(begin, 0));
		
		while (!q.isEmpty()) {
			Word w = q.poll();
			
			if (w.word.equals(targegt))
				return w.cnt;
			
			for (int i = 0; i < words.length; i++) {
				if (visited[i] || !check(w.word, words[i]))
					continue;
				visited[i] = true;
				q.offer(new Word(words[i], w.cnt + 1));
			}
		}
		return 0;
	}
	
	public boolean check(String a, String b) {
		int cnt = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				cnt++;
		}
		return cnt == 1 ? true : false;
	}
}

class Word {
	String word;
	int cnt;
	
	public Word(String word, int cnt) {
		this.word = word;
		this.cnt = cnt;
	}
}
