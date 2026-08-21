package defpackage;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class g42 implements tv2 {
    public zv2 a;
    public int b = -1;
    public t6 c;
    public final String d;
    public final th3 e;
    public final boolean f;

    public g42(String str, boolean z) {
        this.d = str;
        this.f = str.contains("\\G");
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        try {
            this.e = new th3(bytes.length, z ? 257 : 256, tk4.F0, bytes);
        } catch (s84 e) {
            throw new r94("Parsing regex pattern \"" + str + "\" failed with " + e, e);
        }
    }

    @Override // defpackage.tv2
    public final /* bridge */ /* synthetic */ uv2 a(zv2 zv2Var) {
        return c(zv2Var, 0);
    }

    public final t6 b(int i, int i2, byte[] bArr) {
        k70 ym2Var;
        int iS;
        th3 th3Var = this.e;
        th3Var.getClass();
        int length = bArr.length;
        vd3 vd3Var = th3Var.o;
        int i3 = th3Var.d;
        if (i3 == 0) {
            ym2Var = null;
        } else {
            int i4 = i3 + 1;
            if (i4 == 1) {
                ym2Var = new ox3((byte) 0, 7);
                if (i4 != 1) {
                    s53.k(dw2.A(i4, ""));
                    return null;
                }
            } else {
                ym2Var = new ym2(i4);
            }
        }
        vd3Var.getClass();
        st stVar = new st(th3Var, ym2Var, bArr, length);
        try {
            iS = stVar.s(i, i, i2);
        } catch (InterruptedException unused) {
            iS = -2;
        }
        if (iS == -1) {
            return null;
        }
        k70 ox3Var = stVar.y0;
        if (ox3Var == null) {
            ox3Var = new ox3(stVar.C0, stVar.D0);
        }
        return new t6(ox3Var);
    }

    public final t6 c(zv2 zv2Var, int i) {
        if (this.f) {
            return b(i, zv2Var.b, zv2Var.c);
        }
        synchronized (this) {
            try {
                t6 t6Var = this.c;
                if (this.a != zv2Var || this.b > i || (t6Var != null && t6Var.c(0) < i)) {
                    t6 t6VarB = b(i, zv2Var.b, zv2Var.c);
                    synchronized (this) {
                        this.a = zv2Var;
                        this.b = i;
                        this.c = t6VarB;
                    }
                    return t6VarB;
                }
                return t6Var;
            } finally {
            }
        }
    }

    @Override // defpackage.tv2
    public final String pattern() {
        return this.d;
    }

    public final String toString() {
        return m44.e(this, new dg(8, this));
    }
}
