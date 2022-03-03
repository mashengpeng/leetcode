package editor.cn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


public class BuildingH2o{
    public static void main(String[] args) {
        //Solution solution = new BuildingH2o().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class H2O {
    Semaphore h;
    Semaphore o;
    CyclicBarrier c;
    public H2O() {
        h = new Semaphore(2);
        o = new Semaphore(1);
        c = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                h.release(2);
                o.release(1);
            }
        });
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.

        try {
            h.acquire();
            releaseHydrogen.run();
            c.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        try {
            o.acquire();
            releaseOxygen.run();
            c.await();
        } catch (BrokenBarrierException e){
            e.printStackTrace();
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)


}