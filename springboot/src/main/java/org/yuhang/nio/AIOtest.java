package org.yuhang.nio;


import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** windows环境下异步IO的server端实现
 * Created by chinalife on 2018/7/23.
 */
public class AIOtest {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(executorService);

    }
}
