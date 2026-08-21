package defpackage;

import android.os.Build;
import io.netty.channel.AbstractEventLoop;
import io.netty.channel.AbstractEventLoopGroup;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.ThreadPerChannelEventLoopGroup;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.AbstractEventExecutorGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.NonStickyEventExecutorGroup;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.concurrent.UnorderedThreadPoolEventExecutor;
import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SNIHostName;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class l0 {
    public static /* synthetic */ SNIHostName a(String str) {
        return new SNIHostName(str);
    }

    public static /* synthetic */ SNIHostName b(byte[] bArr) {
        return new SNIHostName(bArr);
    }

    public static /* synthetic */ void c() {
    }

    public static void d(yn0 yn0Var) {
        if ((Build.VERSION.SDK_INT <= 23 || yn0Var != ForkJoinPool.commonPool()) && !yn0Var.b.isTerminated()) {
            yn0Var.shutdown();
            throw null;
        }
    }

    public static /* synthetic */ void e(xq1 xq1Var) {
        if (Build.VERSION.SDK_INT <= 23 || xq1Var != ForkJoinPool.commonPool()) {
            xq1Var.shutdown();
            throw null;
        }
    }

    public static /* synthetic */ void f(AbstractEventLoop abstractEventLoop) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || abstractEventLoop != ForkJoinPool.commonPool()) && !(zIsTerminated = abstractEventLoop.isTerminated())) {
            abstractEventLoop.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = abstractEventLoop.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        abstractEventLoop.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void g(AbstractEventLoopGroup abstractEventLoopGroup) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || abstractEventLoopGroup != ForkJoinPool.commonPool()) && !(zIsTerminated = abstractEventLoopGroup.isTerminated())) {
            abstractEventLoopGroup.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = abstractEventLoopGroup.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        abstractEventLoopGroup.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void h(MultithreadEventLoopGroup multithreadEventLoopGroup) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || multithreadEventLoopGroup != ForkJoinPool.commonPool()) && !(zIsTerminated = multithreadEventLoopGroup.isTerminated())) {
            multithreadEventLoopGroup.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = multithreadEventLoopGroup.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        multithreadEventLoopGroup.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void i(SingleThreadEventLoop singleThreadEventLoop) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || singleThreadEventLoop != ForkJoinPool.commonPool()) && !(zIsTerminated = singleThreadEventLoop.isTerminated())) {
            singleThreadEventLoop.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = singleThreadEventLoop.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        singleThreadEventLoop.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void j(ThreadPerChannelEventLoopGroup threadPerChannelEventLoopGroup) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || threadPerChannelEventLoopGroup != ForkJoinPool.commonPool()) && !(zIsTerminated = threadPerChannelEventLoopGroup.isTerminated())) {
            threadPerChannelEventLoopGroup.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = threadPerChannelEventLoopGroup.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        threadPerChannelEventLoopGroup.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void k(AbstractEventExecutor abstractEventExecutor) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || abstractEventExecutor != ForkJoinPool.commonPool()) && !(zIsTerminated = abstractEventExecutor.isTerminated())) {
            abstractEventExecutor.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = abstractEventExecutor.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        abstractEventExecutor.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void l(AbstractEventExecutorGroup abstractEventExecutorGroup) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || abstractEventExecutorGroup != ForkJoinPool.commonPool()) && !(zIsTerminated = abstractEventExecutorGroup.isTerminated())) {
            abstractEventExecutorGroup.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = abstractEventExecutorGroup.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        abstractEventExecutorGroup.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void m(GlobalEventExecutor globalEventExecutor) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || globalEventExecutor != ForkJoinPool.commonPool()) && !(zIsTerminated = globalEventExecutor.isTerminated())) {
            globalEventExecutor.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = globalEventExecutor.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        globalEventExecutor.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void n(NonStickyEventExecutorGroup nonStickyEventExecutorGroup) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || nonStickyEventExecutorGroup != ForkJoinPool.commonPool()) && !(zIsTerminated = nonStickyEventExecutorGroup.isTerminated())) {
            nonStickyEventExecutorGroup.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = nonStickyEventExecutorGroup.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        nonStickyEventExecutorGroup.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void o(SingleThreadEventExecutor singleThreadEventExecutor) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || singleThreadEventExecutor != ForkJoinPool.commonPool()) && !(zIsTerminated = singleThreadEventExecutor.isTerminated())) {
            singleThreadEventExecutor.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = singleThreadEventExecutor.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        singleThreadEventExecutor.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void p(UnorderedThreadPoolEventExecutor unorderedThreadPoolEventExecutor) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || unorderedThreadPoolEventExecutor != ForkJoinPool.commonPool()) && !(zIsTerminated = unorderedThreadPoolEventExecutor.isTerminated())) {
            unorderedThreadPoolEventExecutor.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = unorderedThreadPoolEventExecutor.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        unorderedThreadPoolEventExecutor.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void q(String str) {
        new SNIHostName(str);
    }

    public static /* synthetic */ void r(ExecutorService executorService) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(zIsTerminated = executorService.isTerminated())) {
            executorService.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        executorService.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ SNIHostName s(String str) {
        return new SNIHostName(str);
    }

    public static /* synthetic */ SNIHostName t(byte[] bArr) {
        return new SNIHostName(bArr);
    }

    public static /* synthetic */ void u(ExecutorService executorService) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(zIsTerminated = executorService.isTerminated())) {
            executorService.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        executorService.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static List v(Collection collection) {
        return (List) Collection.EL.stream(collection).filter(new sm(8)).collect(Collectors.toList());
    }

    public static List w(java.util.Collection collection) {
        return (List) Collection.EL.stream(collection).filter(new sm(7)).map(kt3.P0).collect(Collectors.toList());
    }
}
