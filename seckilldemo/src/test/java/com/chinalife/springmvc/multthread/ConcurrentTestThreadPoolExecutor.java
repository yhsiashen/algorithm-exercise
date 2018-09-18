package com.chinalife.springmvc.multthread;




import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;


/**
 * Created by chinalife on 2018/4/20.
 */
public class ConcurrentTestThreadPoolExecutor {
    private  static int i=0;


    private  static  List<StringBuilder> list;

     static {
        try {
            InputStream in = new FileInputStream("D:\\Users\\chinalife\\Desktop\\init.txt");
            Reader reader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s = null;
            list = new ArrayList<StringBuilder>();
            while ((s= bufferedReader.readLine())!= null){
                System.out.println("s is :"+s);
                list.add(new StringBuilder(s));
            }
            System.out.println(list.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        List< Future<Map<String,Object>>>  result = new ArrayList<Future<Map<String, Object>>>();
        int i =0;
        //线程池执行任务
         while (!list.isEmpty()) {
             Callable myCallable = new MyCallable(list.get(0));
//             Runnable myRunnable = new MyRunnable(list.get(0));
//             executorService.execute(myRunnable);
             Future<Map<String,Object>>  future = executor.submit(myCallable);
             result.add(future);
             list.remove(0);
         }
        for (Future<Map<String,Object>> f: result) {
            System.out.println(f.get());
        }

    }
}
