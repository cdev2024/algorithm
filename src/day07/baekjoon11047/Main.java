package day07.baekjoon11047;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 동전 종류 개수
        int K = sc.nextInt(); // 만들어야하는 금액

        int[] coins = new int[N]; // 동전 종류 저장
        for(int i=0; i<N; i++){
            coins[i] = sc.nextInt();
        }

        int count = 0; //필요한 동전 개수
        for(int i=N-1; i>=0; i--){ // 가장 큰 단위 동전부터
            if(K >= coins[i]) { // 현재 동전으로 K를 만들수 있음
                count += K/coins[i]; //해당 동전 최대한 사용
                K %= coins[i]; // 만들고 남은 금액 업데이트
            }
        }

        System.out.println(count); // 필요한 동전 개수 출력

        sc.close();
    }
}
