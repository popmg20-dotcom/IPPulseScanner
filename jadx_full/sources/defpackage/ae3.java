package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ae3 implements Closeable {
    public static final byte[] Y = {-85, -51, -17, 77, 97, 120, 77, 105, 110, 100, 46, 99, 111, 109};
    public final t60 A;
    public final ConcurrentHashMap X;
    public final int b;
    public final ul2 f;
    public final AtomicReference z;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ae3(ip ipVar, String str) throws a60 {
        t60 t60Var = t60.y0;
        this.z = new AtomicReference(ipVar);
        this.A = t60Var;
        ByteBuffer byteBufferDuplicate = ipVar.a.duplicate();
        int iCapacity = byteBufferDuplicate.capacity();
        int i = 0;
        int i2 = 0;
        while (i2 < iCapacity - 13) {
            for (int i3 = 0; i3 < 14; i3++) {
                if (byteBufferDuplicate.get(((iCapacity - i2) - i3) - 1) != Y[13 - i3]) {
                    break;
                }
            }
            int i4 = iCapacity - i2;
            mk0 mk0Var = new mk0(this.A, byteBufferDuplicate, i4, new ConcurrentHashMap());
            ByteBuffer byteBuffer = mk0Var.d;
            if (i4 >= byteBuffer.capacity()) {
                throw new a60("The MaxMind DB file's data section contains bad data: pointer larger than the database.");
            }
            byteBuffer.position(i4);
            ul2 ul2Var = (ul2) ul2.class.cast(mk0Var.a(ul2.class, null).a);
            this.f = ul2Var;
            if (ul2Var.f != 4) {
                int iG = 0;
                for (int i5 = 0; i5 < 96 && iG < ul2Var.h; i5++) {
                    iG = g(byteBufferDuplicate, iG, 0);
                }
                i = iG;
            }
            this.b = i;
            this.X = new ConcurrentHashMap();
            return;
        }
        throw new a60(ha0.o("Could not find a MaxMind DB metadata marker in this file (", str, "). Is this a valid MaxMind DB file?"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.z.set(null);
    }

    public final int g(ByteBuffer byteBuffer, int i, int i2) {
        ul2 ul2Var = this.f;
        int i3 = i * ul2Var.g;
        int i4 = ul2Var.i;
        if (i4 == 24) {
            byteBuffer.position((i2 * 3) + i3);
            return mk0.c(byteBuffer, 0, 3);
        }
        if (i4 == 28) {
            byte b = byteBuffer.get(i3 + 3);
            int i5 = i2 == 0 ? (b & 240) >>> 4 : b & 15;
            byteBuffer.position((i2 * 4) + i3);
            return mk0.c(byteBuffer, i5, 3);
        }
        if (i4 == 32) {
            byteBuffer.position((i2 * 4) + i3);
            return mk0.c(byteBuffer, 0, 4);
        }
        throw new a60("Unknown record size: " + ul2Var.i);
    }
}
