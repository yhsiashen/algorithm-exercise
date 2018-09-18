package com.chinalife.springmvc.aspect;

import com.chinalife.springmvc.annotation.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * Created by chinalife on 2018/5/17.
 */
public class DynamicDataSourceAdvice {


    public void before(JoinPoint point){
        Class clazz = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        Class[] methodArgClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String datasource = null;
        try {
            Method method = clazz.getMethod(methodName,methodArgClass);
//            if(method.isAnnotationPresent(DynamicDataSource.class)){
                DynamicDataSource dynamicDataSource = method.getAnnotation(DynamicDataSource.class);
                 datasource = dynamicDataSource.value();
                System.out.println("通过注解的value得到的数据源为："+datasource);
//            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
       DynamicDataSourceContextHolder.setDataSource(datasource);

    }

    public void after(){
        DynamicDataSourceContextHolder.clearDataSource();
    }
}
