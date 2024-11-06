package day08;

/*
* 인접 행렬 실습
* */
public class GraphEx01 {
    public static void main(String[] args) {
        int[][] edge = {{1, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}, {3, 5}};
        int nodeNum = 5;

        // 인접 행렬 초기화 : 1부터 시작하는 인덱스 사용하기 위해 nodeNum +1
        int[][] matrix = new int[nodeNum+1][nodeNum+1];

        // 인접 행렬에 간선 정보를 추가
        for (int i = 0; i < edge.length; i++){
            int[] link = edge[i];

            // 양방향 그래프: (a, b), (b, a) 모두 연결
            matrix[link[0]][link[1]] = 1;
            matrix[link[1]][link[0]] = 1;
        }

        // 인접 행렬 출력
        for (int i=1; i<=nodeNum; i++){
            for (int j=1; j<=nodeNum; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/* 예상 출력:
0 1 1 0 0
1 0 0 1 0
1 0 0 1 1
0 1 1 0 1
0 0 1 1 0
*/
