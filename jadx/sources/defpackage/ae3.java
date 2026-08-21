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
        To view partially-correct add '--show-bad-code' argument
    */
    public ae3(defpackage.ip r8, java.lang.String r9) throws defpackage.a60 {
        /*
            r7 = this;
            t60 r0 = defpackage.t60.y0
            r7.<init>()
            java.util.concurrent.atomic.AtomicReference r1 = new java.util.concurrent.atomic.AtomicReference
            r1.<init>(r8)
            r7.z = r1
            r7.A = r0
            java.nio.ByteBuffer r8 = r8.a
            java.nio.ByteBuffer r2 = r8.duplicate()
            int r8 = r2.capacity()
            r6 = 0
            r0 = r6
        L1a:
            int r1 = r8 + (-13)
            if (r0 >= r1) goto L8e
            r1 = r6
        L1f:
            r3 = 14
            if (r1 >= r3) goto L3a
            int r3 = r8 - r0
            int r3 = r3 - r1
            int r3 = r3 + (-1)
            byte r3 = r2.get(r3)
            int r4 = 13 - r1
            byte[] r5 = defpackage.ae3.Y
            r4 = r5[r4]
            if (r3 == r4) goto L37
            int r0 = r0 + 1
            goto L1a
        L37:
            int r1 = r1 + 1
            goto L1f
        L3a:
            int r8 = r8 - r0
            mk0 r0 = new mk0
            t60 r1 = r7.A
            long r3 = (long) r8
            j$.util.concurrent.ConcurrentHashMap r5 = new j$.util.concurrent.ConcurrentHashMap
            r5.<init>()
            r0.<init>(r1, r2, r3, r5)
            java.nio.ByteBuffer r9 = r0.d
            int r1 = r9.capacity()
            if (r8 >= r1) goto L86
            r9.position(r8)
            r8 = 0
            java.lang.Class<ul2> r9 = defpackage.ul2.class
            o2 r8 = r0.a(r9, r8)
            java.lang.Object r8 = r8.a
            java.lang.Object r8 = r9.cast(r8)
            ul2 r8 = (defpackage.ul2) r8
            r7.f = r8
            int r9 = r8.f
            r0 = 4
            if (r9 != r0) goto L6a
            goto L7c
        L6a:
            r9 = r6
            r0 = r9
        L6c:
            r1 = 96
            if (r9 >= r1) goto L7b
            int r1 = r8.h
            if (r0 >= r1) goto L7b
            int r0 = r7.g(r2, r0, r6)
            int r9 = r9 + 1
            goto L6c
        L7b:
            r6 = r0
        L7c:
            r7.b = r6
            j$.util.concurrent.ConcurrentHashMap r8 = new j$.util.concurrent.ConcurrentHashMap
            r8.<init>()
            r7.X = r8
            return
        L86:
            a60 r7 = new a60
            java.lang.String r8 = "The MaxMind DB file's data section contains bad data: pointer larger than the database."
            r7.<init>(r8)
            throw r7
        L8e:
            a60 r7 = new a60
            java.lang.String r8 = "Could not find a MaxMind DB metadata marker in this file ("
            java.lang.String r0 = "). Is this a valid MaxMind DB file?"
            java.lang.String r8 = defpackage.ha0.o(r8, r9, r0)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ae3.<init>(ip, java.lang.String):void");
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
