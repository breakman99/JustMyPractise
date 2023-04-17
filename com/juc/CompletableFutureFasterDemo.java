package com.juc;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 主要讲CompletableFuture中的applyToEither的作用,<br/>
 * 可以比较两个thread谁更快拿到结果，然后就用该结果，见如下例子
 */
public class CompletableFutureFasterDemo {
    public static void main(String[] args) {
        CompletableFuture<String> playerA = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep((new Random().nextInt(400)) + 600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "playerA";
        });
        CompletableFuture<String> playerB = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep((new Random().nextInt(400)) + 600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "playerB";
        });

        CompletableFuture<String> result = playerA.applyToEither(playerB, f -> (f + " is a winner"));

        System.out.println(Thread.currentThread().getName() + " ----- "+result.join());
    }
}
