package defpackage;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public interface vx3 extends Closeable, Flushable {
    void a0(hp hpVar, long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    de4 i();
}
