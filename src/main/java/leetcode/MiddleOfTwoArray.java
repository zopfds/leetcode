package leetcode;

public class MiddleOfTwoArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length , length2 = nums2.length;

        int[] mergeArrays = new int[length1 + length2];

        int i = 0 , j = 0, k = 0;

        while(i < length1 && j < length2){
            if(nums1[i] < nums2[j]){
                mergeArrays[k] = nums1[i++];
            }else{
                mergeArrays[k] = nums2[j++];
            }
            k++;
        }

        while(i < length1){
            mergeArrays[k++] = nums1[i++];
        }

        while(j < length2){
            mergeArrays[k++] = nums2[j++];
        }

        if(length1 + length2 == 1){
            return mergeArrays[0];
        }else if(((length1 + length2) & 1) == 0){
            return (double) (mergeArrays[((length1 + length2) >> 1 ) - 1] + mergeArrays[((length1 + length2) >> 1 )]) / 2;
        }else{
            return (double)mergeArrays[(length1 + length2) >> 1];
        }

    }

    public static void main(String[] args){
        int[] nums1 = {1,2};

        int[] nums2 = {3,4};

        MiddleOfTwoArray middleOfTwoArray = new MiddleOfTwoArray();

        middleOfTwoArray.findMedianSortedArrays(nums1 , nums2);
    }
}
