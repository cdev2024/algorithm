package day06;

public class QuickSortEx {
    // 퀵정렬을 수행하는 메서드
    public static void quickSort(int[] arr, int start, int end){
        if(start >= end) return;

        //분할: 피벗을 기준으로 배열을 두 부분으로 나눔
        int pivot = partition(arr, start, end);

        // 피벗을 제외한 왼쪽 부분 배열(pivot보다 작거나 같은 요소) 다시 quickSort
        quickSort(arr, start, pivot - 1);
        // 피벗을 제외한 오른쪽 부분 배열(pivot보다 큰 요소) 다시 quickSort
        quickSort(arr, pivot + 1, end);
    }

    // 배열을 pivot 기준으로 분할하고, pivot의 최종 위치를 반환하는 메서드
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end]; // pivot을 배열의 마지막 요소로 선택
        int i = (start-1); // pivot보다 작은 요소들의 마지막 인덱스를 가리키는 포인터

        for(int j=start; j<end; j++){
            if(arr[j]<=pivot){
                i++; // pivot보다 작은 요소들을 가리키는 포인터를 한칸 오른쪽으로 이동

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // pivot을 i+1 위치로 pivot 최종 위치를 확정.
        int temp = arr[i+1];
        arr[i+1] = arr[end]; // arr[i+1] = pivot 값
        arr[end] = temp;

        // pivot 위치를 반환
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};

        // arr을 퀵 정렬로 실행
        quickSort(arr, 0, arr.length-1);

        // 정렬된 배열 출력
        System.out.println("Sorted array: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
