package io.netty.util.concurrent;

import defpackage.s53;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultPromise<V> extends AbstractFuture<V> implements Promise<V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final CauseHolder CANCELLATION_CAUSE_HOLDER;
    private static final StackTraceElement[] CANCELLATION_STACK;
    private final EventExecutor executor;
    private GenericFutureListener<? extends Future<?>> listener;
    private DefaultFutureListeners listeners;
    private boolean notifyingListeners;
    private volatile Object result;
    private short waiters;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultPromise.class);
    private static final InternalLogger rejectedExecutionLogger = InternalLoggerFactory.getInstance(DefaultPromise.class.getName().concat(".rejectedExecution"));
    private static final int MAX_LISTENER_STACK_DEPTH = Math.min(8, SystemPropertyUtil.getInt("io.netty.defaultPromise.maxListenerStackDepth", 8));
    private static final AtomicReferenceFieldUpdater<DefaultPromise, Object> RESULT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultPromise.class, Object.class, "result");
    private static final Object SUCCESS = new Object();
    private static final Object UNCANCELLABLE = new Object();

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class CauseHolder {
        final Throwable cause;

        public CauseHolder(Throwable th) {
            this.cause = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class LeanCancellationException extends CancellationException {
        private static final long serialVersionUID = 2794674970981187807L;

        private LeanCancellationException() {
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            setStackTrace(DefaultPromise.CANCELLATION_STACK);
            return this;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return CancellationException.class.getName();
        }
    }

    static {
        CauseHolder causeHolder = new CauseHolder(StacklessCancellationException.newInstance(DefaultPromise.class, "cancel(...)"));
        CANCELLATION_CAUSE_HOLDER = causeHolder;
        CANCELLATION_STACK = causeHolder.cause.getStackTrace();
    }

    public DefaultPromise(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    private void addListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>> genericFutureListener2 = this.listener;
        if (genericFutureListener2 != null) {
            this.listeners = new DefaultFutureListeners(genericFutureListener2, genericFutureListener);
            this.listener = null;
            return;
        }
        DefaultFutureListeners defaultFutureListeners = this.listeners;
        if (defaultFutureListeners == null) {
            this.listener = genericFutureListener;
        } else {
            defaultFutureListeners.add(genericFutureListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x008b A[Catch: all -> 0x0067, TryCatch #2 {all -> 0x0067, blocks: (B:38:0x005f, B:41:0x0069, B:56:0x008b, B:57:0x0092, B:52:0x0080, B:53:0x0087), top: B:64:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean await0(long r13, boolean r15) throws java.lang.InterruptedException {
        /*
            r12 = this;
            boolean r0 = r12.isDone()
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            r2 = 0
            int r0 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r0 > 0) goto L13
            boolean r12 = r12.isDone()
            return r12
        L13:
            if (r15 == 0) goto L26
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L1c
            goto L26
        L1c:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException
            java.lang.String r12 = r12.toString()
            r13.<init>(r12)
            throw r13
        L26:
            r12.checkDeadLock()
            long r4 = java.lang.System.nanoTime()
            monitor-enter(r12)
            r0 = 0
            r6 = r13
        L30:
            boolean r8 = r12.isDone()     // Catch: java.lang.Throwable -> L4b
            if (r8 != 0) goto L7a
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 <= 0) goto L7a
            r12.incWaiters()     // Catch: java.lang.Throwable -> L4b
            r8 = 1000000(0xf4240, double:4.940656E-318)
            long r10 = r6 / r8
            long r6 = r6 % r8
            int r6 = (int) r6     // Catch: java.lang.Throwable -> L4e java.lang.InterruptedException -> L50
            r12.wait(r10, r6)     // Catch: java.lang.Throwable -> L4e java.lang.InterruptedException -> L50
            r12.decWaiters()     // Catch: java.lang.Throwable -> L4b
            goto L57
        L4b:
            r13 = move-exception
            r1 = r0
            goto L89
        L4e:
            r13 = move-exception
            goto L76
        L50:
            r6 = move-exception
            if (r15 != 0) goto L75
            r12.decWaiters()     // Catch: java.lang.Throwable -> L73
            r0 = r1
        L57:
            boolean r6 = r12.isDone()     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L6b
            if (r0 == 0) goto L69
            java.lang.Thread r13 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L67
            r13.interrupt()     // Catch: java.lang.Throwable -> L67
            goto L69
        L67:
            r13 = move-exception
            goto L93
        L69:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L67
            return r1
        L6b:
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L4b
            long r6 = r6 - r4
            long r6 = r13 - r6
            goto L30
        L73:
            r13 = move-exception
            goto L89
        L75:
            throw r6     // Catch: java.lang.Throwable -> L4e
        L76:
            r12.decWaiters()     // Catch: java.lang.Throwable -> L4b
            throw r13     // Catch: java.lang.Throwable -> L4b
        L7a:
            boolean r13 = r12.isDone()     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L87
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L67
            r14.interrupt()     // Catch: java.lang.Throwable -> L67
        L87:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L67
            return r13
        L89:
            if (r1 == 0) goto L92
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L67
            r14.interrupt()     // Catch: java.lang.Throwable -> L67
        L92:
            throw r13     // Catch: java.lang.Throwable -> L67
        L93:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L67
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.DefaultPromise.await0(long, boolean):boolean");
    }

    private Throwable cause0(Object obj) {
        if (!(obj instanceof CauseHolder)) {
            return null;
        }
        CauseHolder causeHolder = CANCELLATION_CAUSE_HOLDER;
        if (obj == causeHolder) {
            LeanCancellationException leanCancellationException = new LeanCancellationException();
            AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
            CauseHolder causeHolder2 = new CauseHolder(leanCancellationException);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, causeHolder, causeHolder2)) {
                if (atomicReferenceFieldUpdater.get(this) != causeHolder) {
                    obj = this.result;
                }
            }
            return leanCancellationException;
        }
        return ((CauseHolder) obj).cause;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized boolean checkNotifyWaiters() {
        /*
            r1 = this;
            monitor-enter(r1)
            short r0 = r1.waiters     // Catch: java.lang.Throwable -> L9
            if (r0 <= 0) goto Lb
            r1.notifyAll()     // Catch: java.lang.Throwable -> L9
            goto Lb
        L9:
            r0 = move-exception
            goto L19
        Lb:
            io.netty.util.concurrent.GenericFutureListener<? extends io.netty.util.concurrent.Future<?>> r0 = r1.listener     // Catch: java.lang.Throwable -> L9
            if (r0 != 0) goto L16
            io.netty.util.concurrent.DefaultFutureListeners r0 = r1.listeners     // Catch: java.lang.Throwable -> L9
            if (r0 == 0) goto L14
            goto L16
        L14:
            r0 = 0
            goto L17
        L16:
            r0 = 1
        L17:
            monitor-exit(r1)
            return r0
        L19:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.DefaultPromise.checkNotifyWaiters():boolean");
    }

    private void decWaiters() {
        this.waiters = (short) (this.waiters - 1);
    }

    private void incWaiters() {
        short s = this.waiters;
        if (s != Short.MAX_VALUE) {
            this.waiters = (short) (s + 1);
        } else {
            s53.j(this, "too many waiters: ");
        }
    }

    private static boolean isCancelled0(Object obj) {
        return (obj instanceof CauseHolder) && (((CauseHolder) obj).cause instanceof CancellationException);
    }

    private static boolean isDone0(Object obj) {
        return (obj == null || obj == UNCANCELLABLE) ? false : true;
    }

    public static void notifyListener(EventExecutor eventExecutor, Future<?> future, GenericFutureListener<?> genericFutureListener) {
        notifyListenerWithStackOverFlowProtection((EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "eventExecutor"), (Future) ObjectUtil.checkNotNull(future, "future"), (GenericFutureListener) ObjectUtil.checkNotNull(genericFutureListener, "listener"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyListener0(Future future, GenericFutureListener genericFutureListener) {
        try {
            genericFutureListener.operationComplete(future);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + genericFutureListener.getClass().getName() + ".operationComplete()", th);
            }
        }
    }

    private static void notifyListenerWithStackOverFlowProtection(EventExecutor eventExecutor, final Future<?> future, final GenericFutureListener<?> genericFutureListener) {
        InternalThreadLocalMap internalThreadLocalMap;
        int iFutureListenerStackDepth;
        if (!eventExecutor.inEventLoop() || (iFutureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) >= MAX_LISTENER_STACK_DEPTH) {
            safeExecute(eventExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.2
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyListener0(future, genericFutureListener);
                }
            });
            return;
        }
        internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth + 1);
        try {
            notifyListener0(future, genericFutureListener);
        } finally {
            internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth);
        }
    }

    private void notifyListeners() {
        InternalThreadLocalMap internalThreadLocalMap;
        int iFutureListenerStackDepth;
        EventExecutor eventExecutorExecutor = executor();
        if (!eventExecutorExecutor.inEventLoop() || (iFutureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) >= MAX_LISTENER_STACK_DEPTH) {
            safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.this.notifyListenersNow();
                }
            });
            return;
        }
        internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth + 1);
        try {
            notifyListenersNow();
        } finally {
            internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth);
        }
    }

    private void notifyListeners0(DefaultFutureListeners defaultFutureListeners) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArrListeners = defaultFutureListeners.listeners();
        int size = defaultFutureListeners.size();
        for (int i = 0; i < size; i++) {
            notifyListener0(this, genericFutureListenerArrListeners[i]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListenersNow() {
        synchronized (this) {
            try {
                GenericFutureListener<? extends Future<?>> genericFutureListener = this.listener;
                DefaultFutureListeners defaultFutureListeners = this.listeners;
                if (!this.notifyingListeners && (genericFutureListener != null || defaultFutureListeners != null)) {
                    this.notifyingListeners = true;
                    if (genericFutureListener != null) {
                        this.listener = null;
                    } else {
                        this.listeners = null;
                    }
                    while (true) {
                        if (genericFutureListener != null) {
                            notifyListener0(this, genericFutureListener);
                        } else {
                            notifyListeners0(defaultFutureListeners);
                        }
                        synchronized (this) {
                            try {
                                genericFutureListener = this.listener;
                                if (genericFutureListener == null && this.listeners == null) {
                                    this.notifyingListeners = false;
                                    return;
                                }
                                defaultFutureListeners = this.listeners;
                                if (genericFutureListener != null) {
                                    this.listener = null;
                                } else {
                                    this.listeners = null;
                                }
                            } finally {
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyProgressiveListener0(ProgressiveFuture progressiveFuture, GenericProgressiveFutureListener genericProgressiveFutureListener, long j, long j2) {
        try {
            genericProgressiveFutureListener.operationProgressed(progressiveFuture, j, j2);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + genericProgressiveFutureListener.getClass().getName() + ".operationProgressed()", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyProgressiveListeners0(ProgressiveFuture<?> progressiveFuture, GenericProgressiveFutureListener<?>[] genericProgressiveFutureListenerArr, long j, long j2) {
        for (GenericProgressiveFutureListener<?> genericProgressiveFutureListener : genericProgressiveFutureListenerArr) {
            if (genericProgressiveFutureListener == null) {
                return;
            }
            notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j, j2);
        }
    }

    private synchronized Object progressiveListeners() {
        GenericFutureListener<? extends Future<?>> genericFutureListener = this.listener;
        DefaultFutureListeners defaultFutureListeners = this.listeners;
        if (genericFutureListener == null && defaultFutureListeners == null) {
            return null;
        }
        if (defaultFutureListeners == null) {
            if (genericFutureListener instanceof GenericProgressiveFutureListener) {
                return genericFutureListener;
            }
            return null;
        }
        int iProgressiveSize = defaultFutureListeners.progressiveSize();
        if (iProgressiveSize == 0) {
            return null;
        }
        int i = 0;
        if (iProgressiveSize == 1) {
            GenericFutureListener<? extends Future<?>>[] genericFutureListenerArrListeners = defaultFutureListeners.listeners();
            int length = genericFutureListenerArrListeners.length;
            while (i < length) {
                GenericFutureListener<? extends Future<?>> genericFutureListener2 = genericFutureListenerArrListeners[i];
                if (genericFutureListener2 instanceof GenericProgressiveFutureListener) {
                    return genericFutureListener2;
                }
                i++;
            }
            return null;
        }
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArrListeners2 = defaultFutureListeners.listeners();
        GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = new GenericProgressiveFutureListener[iProgressiveSize];
        int i2 = 0;
        while (i < iProgressiveSize) {
            GenericFutureListener<? extends Future<?>> genericFutureListener3 = genericFutureListenerArrListeners2[i2];
            if (genericFutureListener3 instanceof GenericProgressiveFutureListener) {
                int i3 = i + 1;
                genericProgressiveFutureListenerArr[i] = (GenericProgressiveFutureListener) genericFutureListener3;
                i = i3;
            }
            i2++;
        }
        return genericProgressiveFutureListenerArr;
    }

    private void removeListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        if (this.listener == genericFutureListener) {
            this.listener = null;
            return;
        }
        DefaultFutureListeners defaultFutureListeners = this.listeners;
        if (defaultFutureListeners != null) {
            defaultFutureListeners.remove(genericFutureListener);
            if (this.listeners.size() == 0) {
                this.listeners = null;
            }
        }
    }

    private void rethrowIfFailed() throws Throwable {
        Throwable thCause = cause();
        if (thCause == null) {
            return;
        }
        PlatformDependent.throwException(thCause);
    }

    private static void safeExecute(EventExecutor eventExecutor, Runnable runnable) {
        try {
            eventExecutor.execute(runnable);
        } catch (Throwable th) {
            rejectedExecutionLogger.error("Failed to submit a listener notification task. Event loop shut down?", th);
        }
    }

    private boolean setFailure0(Throwable th) {
        return setValue0(new CauseHolder((Throwable) ObjectUtil.checkNotNull(th, "cause")));
    }

    private boolean setSuccess0(V v) {
        if (v == null) {
            v = (V) SUCCESS;
        }
        return setValue0(v);
    }

    private boolean setValue0(Object obj) {
        AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
        while (true) {
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, obj)) {
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != null) {
                AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater2 = RESULT_UPDATER;
                Object obj2 = UNCANCELLABLE;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, obj)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        return false;
                    }
                }
            }
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: addListener */
    public Promise<V> addListener2(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, "listener");
        synchronized (this) {
            addListener0(genericFutureListener);
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: addListeners */
    public Promise<V> addListeners2(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners");
        synchronized (this) {
            try {
                for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
                    if (genericFutureListener == null) {
                        break;
                    }
                    addListener0(genericFutureListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: await */
    public Promise<V> await2() throws InterruptedException {
        if (isDone()) {
            return this;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        checkDeadLock();
        synchronized (this) {
            while (!isDone()) {
                try {
                    incWaiters();
                    try {
                        wait();
                        decWaiters();
                    } catch (Throwable th) {
                        decWaiters();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: awaitUninterruptibly */
    public Promise<V> awaitUninterruptibly2() {
        boolean z;
        if (!isDone()) {
            checkDeadLock();
            synchronized (this) {
                z = false;
                while (!isDone()) {
                    try {
                        incWaiters();
                        try {
                            wait();
                            decWaiters();
                        } catch (InterruptedException unused) {
                            decWaiters();
                            z = true;
                        } catch (Throwable th) {
                            decWaiters();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
        CauseHolder causeHolder = CANCELLATION_CAUSE_HOLDER;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, causeHolder)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                return false;
            }
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return cause0(this.result);
    }

    public void checkDeadLock() {
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor != null && eventExecutorExecutor.inEventLoop()) {
            throw new BlockingOperationException(toString());
        }
    }

    public EventExecutor executor() {
        return this.executor;
    }

    @Override // io.netty.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        V v = (V) this.result;
        if (!isDone0(v)) {
            if (!await(j, timeUnit)) {
                throw new TimeoutException();
            }
            v = (V) this.result;
        }
        if (v == SUCCESS || v == UNCANCELLABLE) {
            return null;
        }
        Throwable thCause0 = cause0(v);
        if (thCause0 == null) {
            return v;
        }
        if (thCause0 instanceof CancellationException) {
            throw ((CancellationException) thCause0);
        }
        throw new ExecutionException(thCause0);
    }

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        V v = (V) this.result;
        if ((v instanceof CauseHolder) || v == SUCCESS || v == UNCANCELLABLE) {
            return null;
        }
        return v;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return this.result == null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return isCancelled0(this.result);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return isDone0(this.result);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        Object obj = this.result;
        return (obj == null || obj == UNCANCELLABLE || (obj instanceof CauseHolder)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void notifyProgressiveListeners(final long j, final long j2) {
        Object objProgressiveListeners = progressiveListeners();
        if (objProgressiveListeners == null) {
            return;
        }
        final ProgressiveFuture progressiveFuture = (ProgressiveFuture) this;
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor.inEventLoop()) {
            if (objProgressiveListeners instanceof GenericProgressiveFutureListener[]) {
                notifyProgressiveListeners0(progressiveFuture, (GenericProgressiveFutureListener[]) objProgressiveListeners, j, j2);
                return;
            } else {
                notifyProgressiveListener0(progressiveFuture, (GenericProgressiveFutureListener) objProgressiveListeners, j, j2);
                return;
            }
        }
        if (objProgressiveListeners instanceof GenericProgressiveFutureListener[]) {
            final GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = (GenericProgressiveFutureListener[]) objProgressiveListeners;
            safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.3
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyProgressiveListeners0(progressiveFuture, genericProgressiveFutureListenerArr, j, j2);
                }
            });
        } else {
            final GenericProgressiveFutureListener genericProgressiveFutureListener = (GenericProgressiveFutureListener) objProgressiveListeners;
            safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.4
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j, j2);
                }
            });
        }
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: removeListener */
    public Promise<V> removeListener2(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, "listener");
        synchronized (this) {
            removeListener0(genericFutureListener);
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: removeListeners */
    public Promise<V> removeListeners2(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners");
        synchronized (this) {
            try {
                for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
                    if (genericFutureListener != null) {
                        removeListener0(genericFutureListener);
                    }
                }
            } finally {
            }
        }
        return this;
    }

    public Promise<V> setFailure(Throwable th) {
        if (setFailure0(th)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this, th);
    }

    public Promise<V> setSuccess(V v) {
        if (setSuccess0(v)) {
            return this;
        }
        s53.j(this, "complete already: ");
        return null;
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
        Object obj = UNCANCELLABLE;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, obj)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                Object obj2 = this.result;
                return (isDone0(obj2) && isCancelled0(obj2)) ? false : true;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: sync */
    public Promise<V> sync2() throws Throwable {
        await2();
        rethrowIfFailed();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: syncUninterruptibly */
    public Promise<V> syncUninterruptibly2() throws Throwable {
        awaitUninterruptibly2();
        rethrowIfFailed();
        return this;
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('@');
        sb.append(Integer.toHexString(hashCode()));
        Object obj = this.result;
        if (obj == SUCCESS) {
            sb.append("(success)");
            return sb;
        }
        if (obj == UNCANCELLABLE) {
            sb.append("(uncancellable)");
            return sb;
        }
        if (obj instanceof CauseHolder) {
            sb.append("(failure: ");
            sb.append(((CauseHolder) obj).cause);
            sb.append(')');
            return sb;
        }
        if (obj == null) {
            sb.append("(incomplete)");
            return sb;
        }
        sb.append("(success: ");
        sb.append(obj);
        sb.append(')');
        return sb;
    }

    public boolean tryFailure(Throwable th) {
        return setFailure0(th);
    }

    public boolean trySuccess(V v) {
        return setSuccess0(v);
    }

    public DefaultPromise() {
        this.executor = null;
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class StacklessCancellationException extends CancellationException {
        private static final long serialVersionUID = -2974906711413716191L;

        private StacklessCancellationException() {
        }

        public static StacklessCancellationException newInstance(Class<?> cls, String str) {
            return (StacklessCancellationException) ThrowableUtil.unknownStackTrace(new StacklessCancellationException(), cls, str);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        try {
            return await0(timeUnit.toNanos(j), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }

    @Override // io.netty.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        V v = (V) this.result;
        if (!isDone0(v)) {
            await2();
            v = (V) this.result;
        }
        if (v == SUCCESS || v == UNCANCELLABLE) {
            return null;
        }
        Throwable thCause0 = cause0(v);
        if (thCause0 == null) {
            return v;
        }
        if (thCause0 instanceof CancellationException) {
            throw ((CancellationException) thCause0);
        }
        throw new ExecutionException(thCause0);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j, TimeUnit timeUnit) {
        return await0(timeUnit.toNanos(j), true);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j) {
        return await0(TimeUnit.MILLISECONDS.toNanos(j), true);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }
}
