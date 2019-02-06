package pl.michalak.adam.clientserver.server;

import java.util.concurrent.ThreadFactory;


class ServerThreadsFactory implements ThreadFactory {
    private int counter = 0;
    private final String threadName;

    ServerThreadsFactory(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        counter++;
        return new Thread(r, String.format("%s%d", threadName, counter));
    }
}
