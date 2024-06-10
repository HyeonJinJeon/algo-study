package BOJ_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long answer = 0;
        for(int i = 0; i < t; i++) {
            String inputStr = br.readLine();
            int n = Integer.parseInt(inputStr.split(" ")[0]);
            int m = Integer.parseInt(inputStr.split(" ")[1]);
            answer = factorial(m) / (factorial(n) * factorial(m - n));
            System.out.println(answer);
        }
    }
    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
