package edu.AnastasiiaTkachuk.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class RocketDetail implements Runnable{
    private final RocketParts rocketDetail;
    private final CountDownLatch countDownLatch;

    public RocketDetail(RocketParts rocketDetail, CountDownLatch countDownLatch) {
        this.rocketDetail = rocketDetail;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Готовится деталь " + rocketDetail);
        try {
            Thread.sleep(1000L);
            System.out.println("Деталь готова " + rocketDetail);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
