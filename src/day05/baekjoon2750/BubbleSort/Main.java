package day05.baekjoon2750.BubbleSort;

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

        // 버블 정렬
        bubbleSort(numbers);

        for(int number: numbers){
            System.out.println(number);
        }
    }

    // 버블 정렬 메서드
    public static void bubbleSort(int[] arr){
        int n = arr.length;

        //전체 배열 순회
        for(int i=0; i<n-1; i++){
            //정렬되지 않은 부분 순회
            for(int j=0; j<n-i-1; j++){
                //현재 원소가 다음 원소보다 크면 두 원소의 위치를 교환(오름차순)
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
