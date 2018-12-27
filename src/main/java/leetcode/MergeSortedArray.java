package leetcode;

import leetcode.util.Println;

/**
 * 合并两个有序数组
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/27
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1 , j = n - 1;
        while(i >= 0 && j >= 0){
            while(j >= 0 && i >= 0 && nums1[i] >= nums2[j]){
                nums1[i + j + 1] = nums1[i];
                i--;
            }
            while(i >= 0 && j >= 0 && nums2[j] >= nums1[i]){
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }

        while(j >= 0){
            nums1[j] = nums2[j];
            j--;
        }
        return;
    }

    public static void main(String[] args){
        int[] test = {1,2,3,0,0,0};
        int[] test1 = {2,5,6};
        new MergeSortedArray().merge(test , 3 ,test1 , 3);
        Println.printArray(test);
    }
}
