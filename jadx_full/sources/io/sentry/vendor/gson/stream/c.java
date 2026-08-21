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
    */
    public final void F(String str) throws IOException {
        String str2;
        Writer writer = this.b;
        writer.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = z0[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        writer.write(str, i, i2 - i);
                    }
                    writer.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                }
                writer.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            writer.write(str, i, length - i);
        }
        writer.write(34);
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
