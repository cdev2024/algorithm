package day04.baekjoon15651;

import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] sequence; // 수열 저장할 배열
    static StringBuilder sb = new StringBuilder(); // 출력 결과 저장할 StringBuilder

    // 백트랙킹으로 수열을 생성하는 메서드
    static void dfs(int depth){
        // 수열의 길이가 M이 되면 출력
        if(depth==M){ // base case
            for(int i=0; i<M; i++){
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 N까지의 모든 숫자를 중복해서 선택 가능
        for (int i=1; i<=N; i++){
            sequence[depth] = i; // 수열의 현재 위치에 숫자를 넣음
            dfs(depth+1); // 다음 깊이로 재귀 호출
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        sequence = new int[M]; //길이 M인 수열 저장할 배열

        // 백트래킹 시작
        dfs(0);

        // StringBuilder에 저장된 결과를 한 번에 출력
        System.out.println(sb);
    }
}
