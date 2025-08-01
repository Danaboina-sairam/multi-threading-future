import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class BasicFuture5 {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(3,3,1,
                TimeUnit.HOURS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        Future<List<Integer>> futureObject=poolExecutor.submit(()->{
            //do some task
            List<Integer> output=new ArrayList<>();
            output.add(300);
            return output;
        });

        try{
            List<Integer> result=futureObject.get();
            System.out.println(result.get(0));
        } catch (Exception e){

        }

        CompletableFuture<> completableFuture;
    }
}


class BasicFuture4SupportMyRunnable implements Runnable {

    List<Integer> list;

    BasicFuture4SupportMyRunnable(List<Integer> list){
        this.list=list;
    }

    @Override
    public void run() {
        list.add(300);
        //it has to do some work
    }
}