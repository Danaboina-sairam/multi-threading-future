import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(3,3,1,
                TimeUnit.HOURS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        List<Integer> output=new ArrayList<>();
        Future<List<Integer>> futureObject=poolExecutor.submit(new BasicFuture4SupportMyRunnable(output),output);

                try{
                    futureObject.get();
                    //1 way
                    System.out.println(output.get(0));

                    //2 way
                    List<Integer> result=futureObject.get();

                    System.out.println(result.get(0));

                } catch (Exception e){

                }
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