package day11;

public class Fibo {

    // 일반 재귀 방식 피보나치 수열의 n번째 값을 계산하는 메서드
    public static int FiboRecur(int num){
        if (num == 0) return 0;
        if (num<2) return 1;
        // 재귀호출
        return FiboRecur(num-1) + FiboRecur(num-2);
    }

    // Tabulation : top-down
    public static int FiboOne(int num){
        // DP테이블 초기화: 0부터 num까지의 값을 저장
        int[] fiboArray = new int[num+1];
        // 1번째 피보나치 수는 1
        if(fiboArray.length>1) fiboArray[1] = 1;

        // 각 n번째 피보나치 수를 계산해서 배열에 저장
        for(int i=2; i<=num; i++){
            fiboArray[i] = fiboArray[i-1]+fiboArray[i-2];
        } //(반복문)

        return fiboArray[num];
    }

    // memoization : bottom-up (재귀방식)
    static int[] fiboDP = new int[1000]; // 계산된 피보나치 수를 저장할 DP 테이블
    public static int FiboTwo(int num){
        if(num==0) return 0;
        if(num<2) return 1;

        // 이미 계산된 값이면 DP 테이블에서 값을 가져옴
        if(fiboDP[num]!=0) return fiboDP[num];

        // 아직 계산되지 않았으면 재귀 호출을 통해 값을 계산하고, DP테이블에 저장
        fiboDP[num] = FiboTwo(num-1) + FiboTwo(num-2);
        return fiboDP[num];
    }

    public static void main(String[] args) {
        // 세 가지 방법으로 10번째 피보나치 수를 계산하고 결과를 출력
        System.out.println(FiboRecur(10)); // 일반 재귀
        System.out.println(FiboOne(10)); // 타뷸레이션
        System.out.println(FiboTwo(10)); // 메모이제이션
    }
}
