package editor.cn;


import java.util.concurrent.Semaphore;

public class TheDiningPhilosophers{
    public static void main(String[] args) {
        //Solution solution = new TheDiningPhilosophers().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class DiningPhilosophers {

    Semaphore[] c = {new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
    };;

    public DiningPhilosophers() {
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        if((philosopher & 1) == 0){
            c[(philosopher + 1) % 5].acquire();
            c[philosopher].acquire();
        }else{
            c[philosopher].acquire();
            c[(philosopher + 1) % 5].acquire();
        }


        pickRightFork.run();
        pickLeftFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        c[philosopher].release();
        c[(philosopher + 1) % 5].release();

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}