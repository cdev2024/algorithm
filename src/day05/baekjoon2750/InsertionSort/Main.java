package day05.baekjoon2750.InsertionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        // 입력 받은 숫자들을 배열에 저장
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 삽입 정렬
        insertionSort(numbers);

        for(int number: numbers){
            System.out.println(number);
        }
    }

    public static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int current = arr[i];
            int j = i-1; // 이전 인덱스까지 이미 정렬된 배열

            while(j >= 0 && arr[j] > current){
                arr[j+1] = arr[j];
                j= j-1;
            }
            arr[j+1] = current;
        }
    }
}
