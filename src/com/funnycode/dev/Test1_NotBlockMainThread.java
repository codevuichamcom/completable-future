package com.funnycode.dev;

import java.util.concurrent.CompletableFuture;

public class Test1_NotBlockMainThread {
    public static void main(String[] args) {
        ComplexBusiness business = new ComplexBusiness();
        System.out.println("[Main Thread]: BEGIN");
        ComplexBusiness.countDown(3);
        System.out.println("[Main Thread]: ID before update: " + ComplexBusiness.id);
        CompletableFuture.runAsync(() -> {
            business.updateId(100);
        }).thenRun(() -> {
            System.out.println("[Sub Thread]: Current ID: " + ComplexBusiness.id);
        });
        System.out.println("[Main Thread]: Not blocked");
        business.highLatency(10);
        System.out.println("[Main Thread]: END");

    }
}
