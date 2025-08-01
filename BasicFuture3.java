import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class BasicFuture3 {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(3,3,1,
                TimeUnit.HOURS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        //UseCase1
        Future<?> futureObject1=poolExecutor.submit(()->{
            System.out.println("Task1 with Runnable");
        });

        try{
            Object object=futureObject1.get();
            System.out.println(object==null);
        } catch (Exception e){

        }

        //UseCase2
        List<Integer> output=new ArrayList<>();
        Future<List<Integer>> futureObject2=poolExecutor.submit(()->{
            output.add(100);
            System.out.println("Task2 with Runnable and Return object");
        },output);

        try{
            List<Integer> outputFromFutureObject2=futureObject2.get();
            System.out.println(outputFromFutureObject2.get(0));
        } catch (Exception e){

        }

        //UseCase3
        Future<List<Integer>> futureObject3=poolExecutor.submit(()->{
            System.out.println("Task3 with Callable");
            List<Integer> listObj=new ArrayList<>();
            listObj.add(200);
            return listObj;
        });

        try{
            List<Integer> outputFromFutureObject3=futureObject3.get();
            System.out.println(outputFromFutureObject3.get(0));
        } catch (Exception e){

        }

    }

}
