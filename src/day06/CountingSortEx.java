package day06;

public class CountingSortEx {
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 2, 7, 5, 2};
        int[] sortedArr = countingSort(arr);

        for(int i: sortedArr)
            System.out.print(i + " ");
    }

    public static int[] countingSort(int[] arr) {
        int arrLength = arr.length;
        int[] output = new int[arrLength]; // 정렬된 배열을 저장

        // 가정: 입력된 숫자는 0~9까지의 정수이다.
        int[] count = new int[10]; // 각 숫자의 개수를 저장할 배열 : count ={0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

        // 각 숫자의 객수를 count : count = {0, 2, 2, 0, 1, 1, 0, 1, 0, 0}
        for(int i = 0; i< arrLength; i++){
            count[arr[i]]++;
        }

        // count 배열을 변경, 각 숫자 이하의 숫자들의 총 개수를 저장 (누적count) : count = {0, 2, 4, 4, 5, 6, 6, 7, 7, 7}
        for(int i=1; i<count.length; i++){
            count[i] += count[i-1];
        }

        // 출력 배열을 만듦 //2, 5, 7, 2, 1, 4, 1
        for(int i=arrLength-1; i>=0; i--){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--; // 다음 같은 숫자를 위해 count 값을 줄임
        }
        /*
        * Index(i)	arr[i]	count[arr[i]]	output
        *   6		  2			4				[0, 0, 0, 2, 0, 0, 0]
        *   5		  5			6				[0, 0, 0, 2, 0, 5, 0]
        *   4		  7			7				[0, 0, 0, 2, 0, 5, 7]
        *   3		  2			3				[0, 0, 2, 2, 0, 5, 7]
        *   2		  1			2				[0, 1, 2, 2, 0, 5, 7]
        *   1		  4			5				[0, 1, 2, 2, 4, 5, 7]
        *   0		  1			1				[1, 1, 2, 2, 4, 5, 7]
        * */

        return output;
    }
}
