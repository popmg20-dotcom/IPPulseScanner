package defpackage;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zv2 {
    public static final AtomicLong e = new AtomicLong();
    public final String a;
    public final int b;
    public final byte[] c;
    public final long d = e.incrementAndGet();

    public zv2(String str, byte[] bArr) {
        this.a = str;
        this.c = bArr;
        this.b = bArr.length;
    }

    public static zv2 c(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return bytes.length == str.length() ? new yv2(str, bytes) : new xv2(str, bytes);
    }

    public abstract int a(int i);

    public abstract int b(int i);

    public final void d(int i, int i2, String str) {
        throw new ArrayIndexOutOfBoundsException(str + " index " + i + " is out of range 0.." + i2 + " of " + this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("[string=\"");
        return fw.y(sb, this.a, "\"]");
    }
}
