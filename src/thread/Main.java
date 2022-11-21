package thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
//        try {
//            threadWaitTime();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            timeUnitWaitTime();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    private static void threadWaitTime() throws InterruptedException {
        System.out.println("Time before sleep: " + new Date() + "\n");

        Thread.sleep(5000);

        System.out.println("Time after sleep: " + new Date());
    }

    private static void timeUnitWaitTime() throws InterruptedException {
        System.out.println("Time before sleep: " + new Date() + "\n");

        TimeUnit.SECONDS.sleep(5);

        System.out.println("Time after sleep: " + new Date());
    }
//    private static void scheduleExecService() {
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//
//        service.schedule(message(), 5, TimeUnit.SECONDS);
//    }
//
//    private static Runnable message() {
//        System.out.println("Printed after some seconds of sleep.");
//        return null;
//    }
}
