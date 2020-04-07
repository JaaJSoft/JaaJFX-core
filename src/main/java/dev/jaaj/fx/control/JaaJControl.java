package dev.jaaj.fx.control;

import dev.jaaj.fx.control.event.PauseEvent;
import dev.jaaj.fx.control.event.StartEvent;
import dev.jaaj.fx.control.event.UpdateEvent;
import dev.jaaj.fx.control.worker.BackgroundWorkerSingleton;
import dev.jaaj.fx.event.EventInvoker;
import dev.jaaj.fx.event.JaaJEventListener;
import javafx.scene.control.Control;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public abstract class JaaJControl extends Control {
    private EventInvoker<UpdateEvent> updater = new EventInvoker<>();
    private EventInvoker<PauseEvent> pauseEventInvoker = new EventInvoker<>();
    private EventInvoker<StartEvent> startEventInvoker = new EventInvoker<>();

    public JaaJControl() {
    }


    protected final void onUpdate() {
        updater.invoke(new UpdateEvent(this));
    }
    public final void forceUpdate(){
        onUpdate();
    }

    protected final void onStart() {
        startEventInvoker.invoke(new StartEvent(this));
    }

    protected final void onPause() {
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
        ExecutorService executorService = BackgroundWorkerSingleton.getExecutorService();
        return executorService.submit(callable);
    }

    public Future<?> executeBackgroundTask(Runnable runnable) {
        ExecutorService executorService = BackgroundWorkerSingleton.getExecutorService();
        return executorService.submit(runnable);
    }
}
