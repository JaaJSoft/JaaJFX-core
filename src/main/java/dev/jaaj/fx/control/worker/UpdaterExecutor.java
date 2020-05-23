package dev.jaaj.fx.control.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class UpdaterExecutor {
    private static ScheduledExecutorService updaterExecutorService;

    public static ScheduledExecutorService getUpdaterService() {
        if (updaterExecutorService == null) {
            updaterExecutorService = Executors.newScheduledThreadPool(4);//TODO config file
        }
        return updaterExecutorService;
    }
}
