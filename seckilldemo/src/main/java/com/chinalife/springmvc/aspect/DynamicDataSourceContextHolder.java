package com.chinalife.springmvc.aspect;

/**
 * Created by chinalife on 2018/5/22.
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> dataSource = new ThreadLocal<String>();

    public static void setDataSource(String dataType){
        System.out.println("set data source :"+dataType);
        dataSource.set(dataType);
    }

    public static void clearDataSource(){
        dataSource.remove();
    }

    public static String getDataSource(){
        System.out.println("get data source:"+dataSource.get());
        return dataSource.get();
    }


}
