package com.chinalife.springmvc.proxy;

/**
 * Created by chinalife on 2018/2/8.
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        IBookFacade bookFacade = new BookFacadeImpl();
        BookFacadeProxy proxy = new BookFacadeProxy();
        IBookFacade bookProxy = (IBookFacade) proxy.bind(bookFacade);
        bookProxy.addBook("xiyangyang");
        System.out.println(bookFacade.hashCode());
        System.out.println("111".hashCode());

    }

}
