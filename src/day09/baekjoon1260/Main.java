package day09.baekjoon1260;

import java.util.*;

class Node implements Comparable<Node>{
    int id;
    List<Node> links = new ArrayList<Node>();
    boolean visited = false;

    Node(int id){
        this.id = id;
    }

    void link(Node n){
        links.add(n);
    }

    @Override
    public int compareTo(Node other) {
        return this.id - other.id; // 정점 번호가 작은 것부터 방문하기 위해 정렬
    }
}

public class Main {
    static Node[] nodes;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 개수
        int V = sc.nextInt(); // 탐색을 시작할 정점 번호

        nodes = new Node[N+1];
        for(int i = 1; i <= N; i++){
            nodes[i] = new Node(i);
        }

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodes[a].link(nodes[b]);
            nodes[b].link(nodes[a]);
        }

        // 정점 번호가 작은것부터 방문?? => 인접 리스트를 오름차순으로 정렬
        for(int i=1; i<=N; i++){
            Collections.sort(nodes[i].links);
        }

        // DFS와 BFS 수행
        dfs(nodes[V]);

        //전체 노드의 visited를 다시 초기화
        for(int i=1; i<=N; i++){
            nodes[i].visited = false;
        }

        bfs(nodes[V]);

        // 탐색 결과 출력
        System.out.println(dfsResult.toString());
        System.out.println(bfsResult.toString());
    }//end of main()

    static void dfs(Node node){
        if(node.visited) return;
        node.visited = true;
        dfsResult.append(node.id).append(" ");
        for(Node n : node.links){
            dfs(n);
        }
    }

    static void bfs(Node start){
        Queue<Node> queue = new LinkedList<Node>();
        start.visited = true;
        queue.add(start);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            bfsResult.append(curr.id).append(" ");
            for(Node n : curr.links){
                if(!n.visited){
                    n.visited = true;
                    queue.add(n);
                }
            }
        }
    }
}
