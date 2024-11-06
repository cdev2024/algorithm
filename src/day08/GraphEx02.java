package day08;

import java.util.ArrayList;

public class GraphEx02 {
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

    }
}

/* 예상 출력:
1의 인접 정점 :  2 3
2의 인접 정점 :  1 4
3의 인접 정점 :  1 4 5
4의 인접 정점 :  2 3 5
5의 인접 정점 :  3 4
*/
