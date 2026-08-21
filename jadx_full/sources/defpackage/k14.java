package defpackage;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class k14 extends k70 implements ThreadFactory {
    public final ThreadGroup X;
    public final AtomicInteger Y = new AtomicInteger(1);
    public final String Z;

    public k14(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.X = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.Z = ha0.o("sshd-", str.replace(' ', '-'), "-thread-");
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable runnable) {
        Thread thread;
        Runnable runnable2;
        we2 we2Var = (we2) this.f;
        try {
            if (System.getSecurityManager() != null) {
                thread = (Thread) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: j14
                    @Override // java.security.PrivilegedExceptionAction
                    public final Object run() {
                        k14 k14Var = this.a;
                        return new Thread(k14Var.X, runnable, k14Var.Z + k14Var.Y.getAndIncrement(), 0L);
                    }
                });
                runnable2 = runnable;
            } else {
                runnable2 = runnable;
                thread = new Thread(this.X, runnable2, this.Z + this.Y.getAndIncrement(), 0L);
            }
            if (!thread.isDaemon()) {
                thread.setDaemon(true);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            if (we2Var.isTraceEnabled()) {
                we2Var.trace("newThread({})[{}] runnable={}", this.X, thread.getName(), runnable2);
            }
            return thread;
        } catch (PrivilegedActionException e) {
            Exception exception = e.getException();
            if (exception instanceof RuntimeException) {
                throw ((RuntimeException) exception);
            }
            zo2.q(exception);
            return null;
        }
    }
}
