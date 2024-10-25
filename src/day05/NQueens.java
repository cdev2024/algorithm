package day05;

/*N-Queens
* N개의 퀸을 NxN 체스판 위에 서로 공격할 수 없게 배치하는 모든 가능한 방법을 찾는 문제
* */
public class NQueens {
    private int[] board;
    private int solutions = 0;

    public NQueens(int N) {
        board = new int[N];
    }

    // 유망한지 확인하는 메서드
    private boolean isPromising(int row){
        for(int i=0; i<row; i++){
            // 같은 열이나 대각선에 다른 퀸이 있는지 확인
            if(board[i]==board[row] || Math.abs(board[row]-board[i]) == Math.abs(row-i)){
                return false;
            }
        }
        return true;
    }

    // N-Queens 문제를 해결하는 메서드
    public void solveNQueens(int row, int N) {
        for(int col=0; col<N; col++){
            board[row] = col; // 퀸을 배치
            if (isPromising(row)) {//놓을 수 있는 자리라면
                if (row == N - 1) { // 보드의 마지막 행 (base case)
                    solutions++;
                    //(확인하고 싶다면) 해결책 출력
                    printSolution(N);
                }
                else{
                    solveNQueens(row+1, N);
                }
            }
            // 유망하지 않은 경우: 퀸을 배치할 수 있는 자리가 없다면
            // 다음 열로 이동(가지치기 : 프루닝)
        }
    }

    private void printSolution(int N){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i]==j){
                    System.out.print("Q ");
                }else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        int N = 4; // 4x4 체스판, 퀸이 4개
        NQueens nQueen = new NQueens(N);

        //백트랙킹 메서드(재귀 함수) 호출
        nQueen.solveNQueens(0, N);

        //모든 가능한 방법 수 출력
        System.out.println("Total solutions: " + nQueen.solutions);
    }
}
