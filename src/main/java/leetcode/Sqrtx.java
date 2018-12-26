package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/24
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }

        return (int)binarySearchFirst(x , 1 , x);
    }

    public long binarySearchFirst(long x , long start , long end){
        while(start <= end){
            long middle = (start + end) / 2;
            long middle2 = middle * middle;
            if(middle2 <= x){
                if((middle + 1) * (middle + 1) > x){
                    return middle;
                }
                start = middle + 1;
            }else if(middle2 > x){
                end = middle - 1;
            }else{
                start = middle;
            }
        }
        return start;
    }

    public static void main(String[] args){
        System.out.println(new Sqrtx().mySqrt(8));
    }
}
