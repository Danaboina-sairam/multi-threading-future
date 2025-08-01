import java.util.concurrent.*;

class BasicFuture2 {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(1,1,1,
                TimeUnit.HOURS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj1=poolExecutor.submit(()->System.out.println("something"));

        Future<Integer> futureObj2=poolExecutor.submit(()->{
            System.out.println("something");
            return 45;
        });


        System.out.println(futureObj1.isDone());
        System.out.println(futureObj2.isDone());

    }

}
