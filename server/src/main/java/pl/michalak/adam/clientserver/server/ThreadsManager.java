package pl.michalak.adam.clientserver.server;

import java.util.concurrent.ExecutorService;

class ThreadsManager {
    private final ExecutorService executorService;

    ThreadsManager(ExecutorService executorService) {
        this.executorService = executorService;
    }

    void execute(Runnable runnable) {
        executorService.execute(runnable);
    }
}