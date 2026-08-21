package io.netty.util.internal.shaded.org.jctools.queues;

import defpackage.dw2;
import defpackage.xe;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class MessagePassingQueueUtil {
    public static <E> void drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        E eRelaxedPoll;
        if (consumer == null) {
            xe.k("c is null");
            return;
        }
        if (waitStrategy == null) {
            xe.k("wait is null");
            return;
        }
        if (exitCondition == null) {
            xe.k("exit condition is null");
            return;
        }
        while (true) {
            int iIdle = 0;
            while (exitCondition.keepRunning()) {
                eRelaxedPoll = messagePassingQueue.relaxedPoll();
                if (eRelaxedPoll == null) {
                    iIdle = waitStrategy.idle(iIdle);
                }
            }
            return;
            consumer.accept(eRelaxedPoll);
        }
    }

    public static <E> void fill(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        if (waitStrategy == null) {
            xe.k("waiter is null");
            return;
        }
        if (exitCondition == null) {
            xe.k("exit condition is null");
            return;
        }
        while (true) {
            int iIdle = 0;
            while (exitCondition.keepRunning()) {
                if (messagePassingQueue.fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                    iIdle = waitStrategy.idle(iIdle);
                }
            }
            return;
        }
    }

    public static <E> int fillBounded(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier) {
        return fillInBatchesToLimit(messagePassingQueue, supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH, messagePassingQueue.capacity());
    }

    public static <E> int fillInBatchesToLimit(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier, int i, int i2) {
        long j = 0;
        do {
            int iFill = messagePassingQueue.fill(supplier, i);
            if (iFill == 0) {
                return (int) j;
            }
            j += (long) iFill;
        } while (j <= i2);
        return (int) j;
    }

    public static <E> int fillUnbounded(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier) {
        return fillInBatchesToLimit(messagePassingQueue, supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH, 4096);
    }

    public static <E> int drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer) {
        int i = 0;
        if (consumer == null) {
            xe.k("c is null");
            return 0;
        }
        while (true) {
            E eRelaxedPoll = messagePassingQueue.relaxedPoll();
            if (eRelaxedPoll == null) {
                return i;
            }
            i++;
            consumer.accept(eRelaxedPoll);
        }
    }

    public static <E> int drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer, int i) {
        int i2 = 0;
        if (consumer == null) {
            xe.k("c is null");
            return 0;
        }
        if (i < 0) {
            xe.k(dw2.A(i, "limit is negative: "));
            return 0;
        }
        if (i == 0) {
            return 0;
        }
        while (i2 < i) {
            E eRelaxedPoll = messagePassingQueue.relaxedPoll();
            if (eRelaxedPoll == null) {
                break;
            }
            consumer.accept(eRelaxedPoll);
            i2++;
        }
        return i2;
    }
}
