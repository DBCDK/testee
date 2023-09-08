/*
 * Copyright Dansk Bibliotekscenter a/s. Licensed under GPLv3
 * See license text in LICENSE.txt or at https://opensource.dbc.dk/licenses/gpl-3.0/
 */

package dk.dbc.testee;

import jakarta.enterprise.concurrent.ContextService;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.ws.rs.NotSupportedException;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

/**
 * A ManagedExecutorImplementation which delegates its operations to a
 * to a normal ExecutorService making it instantiable outside of a
 * Java EE container
 */
public class NonContainerManagedExecutorService implements ManagedExecutorService {
    private final ExecutorService executorService;

    public NonContainerManagedExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return executorService.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return executorService.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return executorService.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit)
            throws InterruptedException {
        return executorService.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return executorService.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return executorService.submit(task, result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return executorService.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
            throws InterruptedException {
        return executorService.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
            throws InterruptedException {
        return executorService.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
            throws InterruptedException, ExecutionException {
        return executorService.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        return executorService.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        executorService.execute(command);
    }


    @Override
    public <U> CompletableFuture<U> completedFuture(U u) {
        throw new NotSupportedException();
    }

    @Override
    public <U> CompletionStage<U> completedStage(U u) {
        throw new NotSupportedException();
    }

    @Override
    public <T> CompletableFuture<T> copy(CompletableFuture<T> completableFuture) {
        return completableFuture.copy();
    }

    @Override
    public <T> CompletionStage<T> copy(CompletionStage<T> completionStage) {
        throw new NotSupportedException();
    }

    @Override
    public <U> CompletableFuture<U> failedFuture(Throwable throwable) {
        throw new NotSupportedException();
    }

    @Override
    public <U> CompletionStage<U> failedStage(Throwable throwable) {
        throw new NotSupportedException();
    }

    @Override
    public ContextService getContextService() {
        throw new NotSupportedException();
    }

    @Override
    public <U> CompletableFuture<U> newIncompleteFuture() {
        throw new NotSupportedException();
    }

    @Override
    public CompletableFuture<Void> runAsync(Runnable runnable) {
        throw new NotSupportedException();
    }

    @Override
    public <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
        throw new NotSupportedException();
    }
}
