package com.chinalife.springmvc.proxy;

/**
 * Created by chinalife on 2018/2/8.
 */
public class BookFacadeImpl implements IBookFacade {
    public void addBook(String name ) {
        System.out.println("增加图书...."+name);
    }
}
