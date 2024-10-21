package day04;

public class RecursionEx {
    public static void main(String[] args) {
        printCharReverse("Hello Java!");
    }

    // 문자열을 뒤집어 프린트하는 함수
    public static void printCharReverse(String str){
        // 반복문으로 구현
//        for(int i=str.length()-1; i>=0; i--){
//            System.out.print(str.charAt(i));
//        }

        // 재귀로 구현
        if (str.length()==0) // 1. base case (기저조건/종료조건)
            return;
        else { // 범위를 줄여서 자기 자신을 호출
            printCharReverse(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }
}
