package defpackage;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qw1 extends h20 {
    @Override // defpackage.k0
    public final boolean j(int i, int i2) {
        if (i < 256) {
            return k(i, i2);
        }
        return false;
    }

    @Override // defpackage.k0
    public int t(int i, byte[] bArr, ue2 ue2Var, int i2, byte[] bArr2) {
        int i3 = ue2Var.b;
        byte b = bArr[i3];
        if (b != -33 || (i & Pow2.MAX_POW2) == 0) {
            bArr2[0] = this.y0[b & 255];
            ue2Var.b = i3 + 1;
            return 1;
        }
        bArr2[0] = 115;
        bArr2[1] = 115;
        ue2Var.b = i3 + 1;
        return 2;
    }
}
