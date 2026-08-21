package io.netty.util;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface Attribute<T> {
    boolean compareAndSet(T t, T t2);

    T get();

    @Deprecated
    T getAndRemove();

    T getAndSet(T t);

    AttributeKey<T> key();

    @Deprecated
    void remove();

    void set(T t);

    T setIfAbsent(T t);
}
