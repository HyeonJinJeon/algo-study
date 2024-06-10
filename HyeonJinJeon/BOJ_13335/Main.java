package BOJ_13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 줄에서 n, w, l 읽기
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int w = Integer.parseInt(firstLine[1]);
        int l = Integer.parseInt(firstLine[2]);

        // 두 번째 줄에서 트럭들의 무게 읽기
        String[] secondLine = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(secondLine[i]));
        }

        int time = 0;
        int totalWeight = 0;
        while(!queue.isEmpty()){
            int truckCnt = 0;
            while(!queue.isEmpty() && totalWeight + queue.peek() <= l && truckCnt < w){
                totalWeight += queue.poll();
                truckCnt++;
            }
            if (!queue.isEmpty()){
                time += w+truckCnt-1;
            }else{
                time += w+truckCnt;
            }
        }
        System.out.println(time);
    }
}
