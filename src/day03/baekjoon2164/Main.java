package day03.baekjoon2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int N = sc.nextInt(); // 카ㅏ으의 개수 N

        // 큐에 1부터 N까지의 번호를 차례대로 넣습니다.
        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while(queue.size() > 1){
            queue.poll(); // 제일 위에 있는 카드 버림
            queue.add(queue.poll()); // 그 다음 위에 있는 카드 제일 아래로 옮김
        }

        // 마지막으로 남은 카드의 번호를 출력
        System.out.println(queue.poll());
    }
}
