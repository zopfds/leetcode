package leetcode;

import java.util.stream.IntStream;

/**
 * 自旋锁实现
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/28
 */
public class SpinLockTest {
    private static final int LOCK = 1;
    private static final int UNLOCK = 0;

    private volatile int isLock;
    private volatile int lockCount;

    public boolean lock(){
        while(isLock == LOCK){
           Thread.currentThread().yield();
        }
        isLock = LOCK;
        int localLockCount  = lockCount;
        localLockCount++;
        lockCount = localLockCount;
        return true;
    }

    public void unlock(){
        isLock = UNLOCK;
    }

    public static void main(String[] args){
        final SpinLockTest spinLockTest = new SpinLockTest();
        IntStream.range(0 , 3).forEach(a -> {
            new Thread(() -> {
                spinLockTest.lock();
                System.out.println(Thread.currentThread().getName() + " get spin lock success!");
                spinLockTest.unlock();
            }).start();
        });
    }
}
