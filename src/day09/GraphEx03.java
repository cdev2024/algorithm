package day09;

/*
* DFS
*
1: 2, 3
2: 1, 4
3: 1, 4, 5
4: 2, 3, 5
5: 4, 3
* */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphEx03 {
    public static void main(String[] args) {
        int[][] edge = {{1, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}, {3, 5}};
        int nodeNum = 5;

        // 인접 리스트 초기화
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        // 각 정점에 대해 빈 리스트를 추가해서 인접 리스트 초기화
        for(int i = 0; i <= nodeNum; i++) {
            adjList.add(new ArrayList<>());
        }

        // 인접 리스트에 간선 정보 추가
        for(int i=0; i<edge.length; i++) {
            adjList.get(edge[i][0]).add(edge[i][1]);
            adjList.get(edge[i][1]).add(edge[i][0]);
        }

        // 인접 리스트 출력
        for(int i=1; i<adjList.size(); i++) {
            System.out.print(i + "의 인접 정점 : ");
            for (int j = 0; j < adjList.get(i).size(); j++){
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        // DFS 실행
        System.out.println("============DFS===========");
        dfs(1, adjList);

        System.out.println();

        // BFS 실행
        System.out.println("============BFS===========");
        bfs(1, adjList);

    }

    /*
    * 인접리스트 사용하여 DFS를 수행하는 메서드
    *
    * @param start 시작 정점
    * @param adjList 그래프의 인접 리스트 (ArrayList<ArrayList<Integer>> 형식)
    * */
    public static void dfs(int start, ArrayList<ArrayList<Integer>> adjList){
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // 방문 여부를 기록
        int[] visited = new int[adjList.size() + 1];
        int current; // 탐색 중인 정점
        visited[start] = 1; // 시작 정점 방문 표시

        stack.push(start);

        // 스택이 비어있지 않은 동안 계속 탐색
        while(!stack.isEmpty()){
            current = stack.pop();
            System.out.print(current + " ");

            // 인접 리스트에서 연결된 모든 정점(가선) 검사
            for(int cur: adjList.get(current)){
                if (visited[cur] == 0){ // 방문하지 않은 정점이라면
                    stack.push(cur);  //스택(탐색 대기열)에 추가
                    visited[cur] = 1; // 방문표시
                }
            }
        }
    }


    /*
    * BFS(너비 우선 탐색)
    *
    * @param start 시작 정점
    * @param adjList 그래프의 인접 리스트 (ArrayList<ArraList<Integer>> 형식)
    * */
    public static void bfs(int start, ArrayList<ArrayList<Integer>> adjList){
        // 탐색 대기열을 queue를 사용
        Queue<Integer> queue = new LinkedList<>();

        int[] visited = new int[adjList.size() + 1];
        int current; // 현재 탐색 중인 점정 저장
        visited[start] = 1; // 시작정점을 방문 표시

        queue.offer(start); // 탐색 대기열에 시작 정점 추가

        //탐색 대기열이 비어있지 않는 동안 계속 탐색
        while(!queue.isEmpty()){
            current = queue.remove(); // 대기열에서 정점을 하나 꺼내서 탐색
            System.out.print(current + " ");

            //인접 리스트에서 현재 정점에 연결된 모든 정점 검사
            for(int cur: adjList.get(current)){
                if(visited[cur] == 0){ // 방문하지 않은 인접 노드이면
                    queue.offer(cur); // 탐색 대기열에 추가
                    visited[cur] = 1; // 방문표시
                }
            }

        }
    }

}

