package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/29
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return numT(1 , n);
    }

    private int numT(int start , int end){
        if(start >= end){
            return 1;
        }else if(start == end - 1){
            return 2;
        }

        int result = 0;
        for(int i = start; i <= end ; i ++){
            result += numT(start , i - 1) * numT(i + 1 , end);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
    }
}
