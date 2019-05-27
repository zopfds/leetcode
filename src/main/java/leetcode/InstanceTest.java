package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/5/7
 */
public class InstanceTest {
    private static class A{
        private int a = 1;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

    public static void main(String[] args){
        A a = new A();
        Object b = (Object) a;
        System.out.println(A.class.isInstance(b));
    }
}
