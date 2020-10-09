package com.zl.concurrent;

import java.util.concurrent.*;

/**
 * @author zhanglan
 * @description
 * @date 2020-08-09
 */
public class ForkJoinPoolSample {

    private static final class LongSum extends RecursiveTask<Long> {
        private static final int MAX_COUNT = 1000;
        private int from;
        private int to;

        public LongSum(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from <= MAX_COUNT) {
                long sum = 0;
                for (int i = from; i <= to; i++) {
                    sum += i;
                }
                return sum;
            } else {
                int mid = from + (to - from)/2;
                LongSum leftTask = new LongSum(from, mid);
                LongSum rightTask = new LongSum(mid + 1, to);
                leftTask.fork();
                rightTask.fork();
                long leftSum = leftTask.join();
                long rightSum = rightTask.join();
                return leftSum + rightSum;
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(4);
        LongSum task = new LongSum(1, 200000);
        ForkJoinTask<Long> ft = pool.submit(task);
        if (ft.isCompletedAbnormally()) {
            System.out.println("error: " + ft.getException());
        }
        System.out.println("result: " + ft.get());
        pool.shutdown();
    }

}
