package dev.jaaj.fx.control;

import dev.jaaj.event.EventInvoker;
import dev.jaaj.event.JaaJEventListener;
import dev.jaaj.fx.control.event.PauseEvent;
import dev.jaaj.fx.control.event.StartEvent;
import dev.jaaj.fx.control.event.UpdateEvent;
import dev.jaaj.fx.control.worker.BackgroundExecutor;
import dev.jaaj.fx.control.worker.UpdaterExecutor;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Control;

import java.util.concurrent.*;

public abstract class JaaJControl extends Control {
    private final EventInvoker<UpdateEvent> updater = new EventInvoker<>();
    private final EventInvoker<PauseEvent> pauseEventInvoker = new EventInvoker<>();
    private final EventInvoker<StartEvent> startEventInvoker = new EventInvoker<>();
    private ScheduledFuture<?> scheduledUpdate;
    private int delayUpdate;
    private TimeUnit timeUnit;

    public JaaJControl() {//TODO CONFIG FILE
        this(5, TimeUnit.SECONDS);
    }

    public JaaJControl(int delayUpdate, TimeUnit timeUnit) {
        this.delayUpdate = delayUpdate;
        this.timeUnit = timeUnit;
        ChangeListener<Boolean> visibleChangeListener = (observable, oldValue, newValue) -> {
            if (newValue) {
                onStart();
            } else {
                onPause();
            }
        };
        this.visibleProperty().addListener(visibleChangeListener);
        this.skinProperty().addListener((observable, oldValue, newValue) -> {
            onStart();
        });
    }

    protected final void onUpdate() {
        System.out.println("OnUpdate");
        updater.invoke(new UpdateEvent(this));
    }

    public final void forceUpdate() {
        onUpdate();
    }

    public void setScheduledUpdateRate(int delay, TimeUnit timeUnit) {
        this.delayUpdate = delay;
        this.timeUnit = timeUnit;
        if (scheduledUpdate != null) {
            scheduledUpdate.cancel(false);
        }
        ScheduledExecutorService updaterService = UpdaterExecutor.getUpdaterService();
        scheduledUpdate = updaterService.scheduleAtFixedRate(this::onUpdate, delay, delay, timeUnit);
        //scheduledUpdate = updaterService.scheduleWithFixedDelay(this::onUpdate, delay, delay, timeUnit);
    }

    protected final void onStart() {
        System.out.println("onStart");
        setScheduledUpdateRate(delayUpdate, timeUnit);
        startEventInvoker.invoke(new StartEvent(this));
    }

    protected final void onPause() {
        System.out.println("OnPause");
        if (scheduledUpdate != null) {
            scheduledUpdate.cancel(false);
        }
        pauseEventInvoker.invoke(new PauseEvent(this));
    }

    public final void addStartListener(JaaJEventListener<StartEvent> eventListener) {
        startEventInvoker.addListener(eventListener);
    }

    public final void removeStartListener(JaaJEventListener<StartEvent> eventListener) {
        startEventInvoker.removeListener(eventListener);

    }

    public final void addPauseListener(JaaJEventListener<PauseEvent> eventListener) {
        pauseEventInvoker.addListener(eventListener);
    }

    public final void removePauseListener(JaaJEventListener<PauseEvent> eventListener) {
        pauseEventInvoker.removeListener(eventListener);
    }

    public Future<?> executeBackgroundTask(Callable<?> callable) {
        ExecutorService executorService = BackgroundExecutor.getExecutorService();
        return executorService.submit(callable);
    }

    public Future<?> executeBackgroundTask(Runnable runnable) {
        ExecutorService executorService = BackgroundExecutor.getExecutorService();
        return executorService.submit(runnable);
    }
}
