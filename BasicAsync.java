import java.util.concurrent.*;

class BasicAsync {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(1,1,1,
                TimeUnit.HOURS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

            poolExecutor.submit(()->{
                System.out.println("This is the taks,which thread will execute");
            });

    }

}
