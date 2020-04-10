package gameApp;

public class Animate implements Runnable{

    BlockBreakerPanel blockBreaker;


    @Override
    public void run() {
        while(true) {
            blockBreaker.update();
            try {
                Thread.sleep(10);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
