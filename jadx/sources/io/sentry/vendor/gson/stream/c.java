package io.sentry.vendor.gson.stream;

import defpackage.vp1;
import defpackage.xe;
import defpackage.zo2;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Closeable, Flushable {
    public static final String[] z0 = new String[128];
    public String A;
    public String X;
    public boolean Y;
    public String Z;
    public final Writer b;
    public int[] f;
    public final boolean y0;
    public int z;

    static {
        for (int i = 0; i <= 31; i++) {
            z0[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = z0;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        int[] iArrCopyOf = new int[8];
        this.f = iArrCopyOf;
        this.z = 0;
        if (iArrCopyOf.length == 0) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, 0);
            this.f = iArrCopyOf;
        }
        int i = this.z;
        this.z = i + 1;
        iArrCopyOf[i] = 6;
        this.X = ":";
        this.y0 = true;
        this.b = writer;
    }

    public final int C() {
        int i = this.z;
        if (i != 0) {
            return this.f[i - 1];
        }
        xe.q("JsonWriter is closed.");
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            java.io.Writer r6 = r6.b
            r0 = 34
            r6.write(r0)
            int r1 = r7.length()
            r2 = 0
            r3 = r2
        Ld:
            if (r2 >= r1) goto L3a
            char r4 = r7.charAt(r2)
            r5 = 128(0x80, float:1.8E-43)
            if (r4 >= r5) goto L1e
            java.lang.String[] r5 = io.sentry.vendor.gson.stream.c.z0
            r4 = r5[r4]
            if (r4 != 0) goto L2b
            goto L37
        L1e:
            r5 = 8232(0x2028, float:1.1535E-41)
            if (r4 != r5) goto L25
            java.lang.String r4 = "\\u2028"
            goto L2b
        L25:
            r5 = 8233(0x2029, float:1.1537E-41)
            if (r4 != r5) goto L37
            java.lang.String r4 = "\\u2029"
        L2b:
            if (r3 >= r2) goto L32
            int r5 = r2 - r3
            r6.write(r7, r3, r5)
        L32:
            r6.write(r4)
            int r3 = r2 + 1
        L37:
            int r2 = r2 + 1
            goto Ld
        L3a:
            if (r3 >= r1) goto L40
            int r1 = r1 - r3
            r6.write(r7, r3, r1)
        L40:
            r6.write(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.c.F(java.lang.String):void");
    }

    public final void I() {
        if (this.Z != null) {
            int iC = C();
            if (iC == 5) {
                this.b.write(44);
            } else if (iC != 3) {
                xe.q("Nesting problem.");
                return;
            }
            s();
            this.f[this.z - 1] = 4;
            F(this.Z);
            this.Z = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
        int i = this.z;
        if (i > 1 || (i == 1 && this.f[i - 1] != 7)) {
            vp1.i("Incomplete document");
        } else {
            this.z = 0;
        }
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.z != 0) {
            this.b.flush();
        } else {
            xe.q("JsonWriter is closed.");
        }
    }

    public final void g() {
        int iC = C();
        if (iC == 1) {
            this.f[this.z - 1] = 2;
            s();
            return;
        }
        Writer writer = this.b;
        if (iC == 2) {
            writer.append(StringUtil.COMMA);
            s();
            return;
        }
        if (iC == 4) {
            writer.append((CharSequence) this.X);
            this.f[this.z - 1] = 5;
            return;
        }
        if (iC != 6) {
            if (iC != 7) {
                xe.q("Nesting problem.");
                return;
            } else if (!this.Y) {
                xe.q("JSON must have only one top-level value.");
                return;
            }
        }
        this.f[this.z - 1] = 7;
    }

    public final void n(int i, int i2, char c) {
        int iC = C();
        if (iC != i2 && iC != i) {
            xe.q("Nesting problem.");
            return;
        }
        if (this.Z != null) {
            zo2.v(this.Z, "Dangling name: ");
            return;
        }
        this.z--;
        if (iC == i2) {
            s();
        }
        this.b.write(c);
    }

    public final void s() throws IOException {
        if (this.A == null) {
            return;
        }
        Writer writer = this.b;
        writer.write(10);
        int i = this.z;
        for (int i2 = 1; i2 < i; i2++) {
            writer.write(this.A);
        }
    }

    public final void x() {
        if (this.Z != null) {
            if (!this.y0) {
                this.Z = null;
                return;
            }
            I();
        }
        g();
        this.b.write("null");
    }
}
