package day09.baekjoon2606;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int id; // 컴퓨터 번호(노드번호)
    List<Node> links; // 연결된 노드
    boolean visited;

    public Node(int id) {
        this.id = id;
        links = new ArrayList<Node>();
    }

    public void link(Node n) {
        links.add(n);
    }
}

public class Main {
    static int result = 0; // 감연된 컴퓨터 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 컴퓨터 수(정점싀 수)
        int M = sc.nextInt(); // 연결된 컴퓨터 쌍의 수(간선의 수)

        Node[] computers = new Node[N+1];
        for (int i = 1; i <= N; i++) {
            computers[i] = new Node(i);
        }
        
        for (int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            computers[a].link(computers[b]);
            computers[b].link(computers[a]);
        }
        
        dfs(computers[1]);
        
        System.out.println(result-1); // 1번 컴퓨터제외하고 연결된 컴퓨터 수 출력
    } // end of main()
    
    // DFS method
    public static void dfs(Node n) {
        if (n.visited) return;
        
        n.visited = true;
        result++; // 감염된 컴퓨터 수 증가
        
        // 현재 정점에 연결된 모든 정점에 대해 dfs를 재귀적으로 실행
        for(Node link : n.links) {
            dfs(link);
        }
    }
}
