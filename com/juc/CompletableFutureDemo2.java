package com.juc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 该demo写两个耗时计算的例子，一个是串行执行，一个是用了CompletableFuture的并行执行
 */
public class CompletableFutureDemo2 {
    static List<String> tasks = Arrays.asList(
            "task1", "task2", "task3", "task4", "task5", "task6"
    );

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        serialExe();
        long end = System.currentTimeMillis();
        System.out.println("serial execute cost:" + (end - start));

        long start1 = System.currentTimeMillis();
        parallelExe();
        long end1 = System.currentTimeMillis();
        System.out.println("parallel execute cost:" + (end1 - start1));

        // actually the parallel stream is faster than stream+CompletableFuture
        long start2 = System.currentTimeMillis();
        parallelExe2();
        long end2 = System.currentTimeMillis();
        System.out.println("parallel execute cost:" + (end2 - start2));
    }

    private static void serialExe() {
        List<Integer> res = tasks.stream().map(CompletableFutureDemo2::getNum).collect(Collectors.toList());
        System.out.println(res);
    }

    private static void parallelExe() {
        List<Integer> res = tasks
                .stream()
                .map(task -> CompletableFuture.supplyAsync(() -> getNum(task)))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(res);
    }
    private static void parallelExe2() {
        List<Integer> res = tasks.parallelStream().map(CompletableFutureDemo2::getNum).collect(Collectors.toList());
        System.out.println(res);
    }
    private static int getNum(String task) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextInt(100);
    }
}












