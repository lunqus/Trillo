package gameApp;

public class Animate implements Runnable{

    BlockBreakerPanel blockBreaker;


    @Override
    public void run() {
        while(true) {
            blockBreaker.update();
        }

    }
}
