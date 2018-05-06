package leetcode.util;

public class Sort {

    public static void quickSort(int[] array , int start , int end){

        if(array == null){
            return;
        }

        int target = array[start];
        int i = start , j = end;
        while(i <= j){

            while(i < j && array[j] >= target) {
                j--;
            }

            if(j <= i){
                array[i] = target;
                break;
            }

            array[i++] = array[j];

            while(i < j && array[i] < target){
                i++;
            }

            if(i >= j){
                array[j] = target;
                break;
            }

            array[j--] = array[i];
        }

        if(start < i -1) {
            quickSort(array, start, i - 1);
        }

        if(i + 1 < end) {
            quickSort(array, i + 1, end);
        }

    }
}
