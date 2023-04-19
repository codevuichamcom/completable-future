package com.funnycode.dev;

public class ComplexBusiness {
    public static int id = 1;

    public void highLatency(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateId(int newid) {
        System.out.println("[Sub Thread]: Begin Update ID...");
        // wait 5s
        highLatency(5);
        ComplexBusiness.id = newid;
        System.out.println("[Sub Thread]: Update ID Done...");
    }

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void countDown(int seconds) {
        while (seconds >= 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(seconds--);
        }
    }
}
