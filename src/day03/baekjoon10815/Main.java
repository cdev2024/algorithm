package day03.baekjoon10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
* 이 코드 전체 시간 복잡도: O(N+M) : 선형시간
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 상근이가 가지고 있는 숫자카드 개수 N
        int N = Integer.parseInt(br.readLine());

        Set<Integer> cardSet = new HashSet<Integer>();
        // 상근이가 가지고 있는 숫자 카드 N개 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {   // N번 반복
            cardSet.add(Integer.parseInt(st.nextToken()));
        }

        // 확인해야할 숫자카드 개수 M
        int M = Integer.parseInt(br.readLine());

        // 확인해야할 숫자카드 M개 입력 받고 결과 출력
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){  // M번 반복
            // 해당 숫자 카드가 상근이가 가지고 있으면 1, 0을 출력
            if( cardSet.contains(Integer.parseInt(st.nextToken())) ){
                sb.append(1).append(" ");
            } else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
