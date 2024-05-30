package BOJ_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            Queue<int[]> queue = new LinkedList<>();
            String[] importanceArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int importance = Integer.parseInt(importanceArr[j]);
                queue.add(new int[]{j, importance});
            }
            int cnt = 0;
            while (!queue.isEmpty()) {
                int[] nowDoc = queue.remove();
                boolean moreImportance = false;

                // 현재 문서의 중요도보다 높은 우선순위 문서가 있는지 검사
                for (int[] doc : queue) {
                    if (doc[1] > nowDoc[1]) {
                        moreImportance = true;
                        break;
                    }
                }

                // 높은 우선순위 문서가 있다면 현재 문서를 다시 큐에 넣음
                if (moreImportance) {
                    queue.add(nowDoc);
                } else {
                    cnt++;
                    // 찾고자 하는 문서가 출력되면 결과를 출력하고 종료
                    if (nowDoc[0] == m) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }
}
