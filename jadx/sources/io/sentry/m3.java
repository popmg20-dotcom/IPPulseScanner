package io.sentry;

import java.io.Closeable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface m3 extends Closeable {
    void B0();

    TimeZone E(ILogger iLogger);

    String G();

    void H(boolean z);

    HashMap J(ILogger iLogger, x1 x1Var);

    Double O();

    String R();

    void V();

    Date Y(ILogger iLogger);

    Boolean b0();

    boolean hasNext();

    Float l0();

    Object m0(ILogger iLogger, x1 x1Var);

    double nextDouble();

    float nextFloat();

    int nextInt();

    long nextLong();

    Object o0();

    void p0();

    io.sentry.vendor.gson.stream.b peek();

    String q();

    void t();

    Integer u();

    void w(ILogger iLogger, AbstractMap abstractMap, String str);

    void w0();

    Long y();

    ArrayList y0(ILogger iLogger, x1 x1Var);
}
