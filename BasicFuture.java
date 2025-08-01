import java.util.concurrent.*;

class BasicFuture {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(1,1,1,
                TimeUnit.HOURS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

            Future<?> futureObj=poolExecutor.submit(()->{
                System.out.println("This is the taks,which thread will execute");
            });

            System.out.println(futureObj.isDone());

    }

}
