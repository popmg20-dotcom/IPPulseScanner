package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kk4 {
    public static final ThreadLocal d = new ThreadLocal();
    public final int a;
    public final iv1 b;
    public volatile int c = 0;

    public kk4(iv1 iv1Var, int i) {
        this.b = iv1Var;
        this.a = i;
    }

    public final int a(int i) {
        xl2 xl2VarB = b();
        int iA = xl2VarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) xl2VarB.A;
        int i2 = iA + xl2VarB.b;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final xl2 b() {
        ThreadLocal threadLocal = d;
        xl2 xl2Var = (xl2) threadLocal.get();
        if (xl2Var == null) {
            xl2Var = new xl2();
            threadLocal.set(xl2Var);
        }
        yl2 yl2Var = (yl2) this.b.f;
        int iA = yl2Var.a(6);
        if (iA != 0) {
            int i = iA + yl2Var.b;
            int i2 = (this.a * 4) + ((ByteBuffer) yl2Var.A).getInt(i) + i + 4;
            int i3 = ((ByteBuffer) yl2Var.A).getInt(i2) + i2;
            ByteBuffer byteBuffer = (ByteBuffer) yl2Var.A;
            xl2Var.A = byteBuffer;
            if (byteBuffer != null) {
                xl2Var.b = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                xl2Var.f = i4;
                xl2Var.z = ((ByteBuffer) xl2Var.A).getShort(i4);
                return xl2Var;
            }
            xl2Var.b = 0;
            xl2Var.f = 0;
            xl2Var.z = 0;
        }
        return xl2Var;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        xl2 xl2VarB = b();
        int iA = xl2VarB.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) xl2VarB.A).getInt(iA + xl2VarB.b) : 0));
        sb.append(", codepoints:");
        xl2 xl2VarB2 = b();
        int iA2 = xl2VarB2.a(16);
        if (iA2 != 0) {
            int i2 = iA2 + xl2VarB2.b;
            i = ((ByteBuffer) xl2VarB2.A).getInt(((ByteBuffer) xl2VarB2.A).getInt(i2) + i2);
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(Integer.toHexString(a(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
