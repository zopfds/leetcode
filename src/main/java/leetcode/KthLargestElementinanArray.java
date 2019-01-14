package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/10
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int[] buffer = new int[k * 2];
        int count = 0 , bufferSize = 0, thisMax = 0 , swap = 0;
        while(count < nums.length){
            //填充k个位置
            while(bufferSize < k && count < nums.length){
                if(nums[count] > nums[thisMax]){
                    thisMax = count;
                }
                buffer[bufferSize++] = nums[count++];
            }
            swap = buffer[thisMax];
            buffer[thisMax] = buffer[0];
            buffer[0] = swap;
            //填充剩下的k个位置
            while(bufferSize < buffer.length && count < nums.length){
                buffer[bufferSize++] = nums[count++];
            }
            //运用快排思想一次排序，将中位数归位
            bufferSize = quickSelect(buffer , k , 0 , bufferSize - 1) + 1;
        }
        return buffer[bufferSize - 1];
    }

    public int quickSelect(int[] arr, int k, int left, int right) {
        if(left == right){
            return left;
        }
        int posi = arr[left] , i = left , j = right;
        while(i < j){
            while(i < j && arr[j] >= posi){
                j--;
            }
            if(i >= j) {
                break;
            }else{
                arr[i++] = arr[j];
            }
            while(i < j && arr[i] <= posi) {
                i++;
            }
            if(i >= j){
                break;
            }else{
                arr[j--] = arr[i];
            }
        }
        arr[i] = posi;
        if(k == i - left + 1){
            return k - 1;
        }else if(k < i - left + 1){
            return quickSelect(arr , k , left , i - 1);
        }else{
            return quickSelect(arr , k - i + left - 1, i + 1 , right);
        }
    }

    public void swap(int a , int b){
        int middle = a;
        a = b;
        b = middle;
    }

    public static void main(String[] args){
        int[] nums = {3,2,4,2,6,5,4,3,4,1};
        System.out.println(new KthLargestElementinanArray().findKthLargest(nums , 1));
    }
}
