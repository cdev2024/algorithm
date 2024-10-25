package day05.baekjoon2750.SelectionSort;

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

        // 선택 정렬
        selectionSort(numbers);

        for(int number: numbers){
            System.out.println(number);
        }
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            // 현재 순회중인 위치에 들어갈 최소값의 위치르 ㄹ찾음
            int min_idx = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min_idx]) min_idx = j;
            }

            // 찾은 최소값을 현재 순회중인 위치로 이동
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
