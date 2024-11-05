package day07;

import java.util.Scanner;

public class MagicGenie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int treasureBox = sc.nextInt();

        int left = 1; // 검색 범위 시작점
        int right = N; // 검색 범위 끝
        int attempts = 0; // 시도 횟수

        while(left <= right){
            int mid = (left + right) / 2; // 중간점 계산
            attempts++;

            if(mid == treasureBox){
                // 보물상자 찾음.
                System.out.println(attempts);
                break;
            } else if (mid < treasureBox) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        sc.close();
    }
}
