package defpackage;

import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q70 {
    public final short a;
    public final short b;
    public final int c;

    public q70(short s, short s2, int i) {
        this.a = s;
        this.b = s2;
        this.c = i;
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(gb4.W(this.a));
        byteArrayOutputStream.write(gb4.W(this.b));
        byteArrayOutputStream.write(gb4.Q(this.c));
    }
}
