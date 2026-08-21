package io.netty.util.internal;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface LongCounter {
    void add(long j);

    void decrement();

    void increment();

    long value();
}
