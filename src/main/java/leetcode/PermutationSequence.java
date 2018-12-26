package leetcode;

/**
 * 第k个排列
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/21
 */
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        char[] chars = new char[n + 1];
        boolean[] used = new boolean[n + 1];
        getP(n , k , 0 , 0 , chars , used);
        return new String(chars , 1 , n);
    }

    private static int getP(int n , int k , int time , Integer count , char[] chars , boolean[] used){
        if(time == n){
            return ++count;
        }
        String s = null;
        for(int i = 1 ; i <= n ; i ++){
            if(used[i]){
                continue;
            }
            chars[time + 1] = (char)('0' + i);
            used[i] = true;
            count = getP(n , k , time + 1 , count , chars , used);
            if(count == k){
                return count;
            }
            chars[time + 1] = '0';
            used[i] = false;
        }
        return count;
    }

    public static void main(String[] args){
        getPermutation(3 , 3);
    }
}
