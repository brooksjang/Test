package cn.asiainfo.futureTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> a  = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        List<Integer> b  = new ArrayList<Integer>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);

        int total = getTotal(a, b);
        System.out.println(total);
    }

    public static int getTotal(final List<Integer> a, final List<Integer> b) throws ExecutionException, InterruptedException {
        Future<Integer> future = Executors.newCachedThreadPool().submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int r = 0;
                for (int num : a) {
                    r += num;
                }
                return r;
            }
        });

        int r = 0;
        for (int num : b) {
            r += num;
        }
        return r + future.get();
    }
}
