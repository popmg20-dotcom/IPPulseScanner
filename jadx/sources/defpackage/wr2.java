package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class wr2 extends u40 {
    public final /* synthetic */ int X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wr2(oy4 oy4Var, qd2 qd2Var, char[] cArr, int i, boolean z, int i2) {
        super(oy4Var, qd2Var, cArr, i, z);
        this.X = i2;
    }

    @Override // defpackage.u40
    public final sk0 n(qd2 qd2Var, char[] cArr, boolean z) throws IOException {
        byte bA;
        switch (this.X) {
            case 0:
                return new t60();
            default:
                long j = qd2Var.h;
                long j2 = qd2Var.g;
                byte[] bArr = new byte[12];
                s(bArr);
                ha1 ha1Var = new ha1(25);
                my4 my4Var = new my4();
                ha1Var.f = my4Var;
                if (cArr == null || cArr.length <= 0) {
                    throw new qy4("Wrong password!", 1);
                }
                my4Var.b(cArr, z);
                int i = 0;
                byte b = bArr[0];
                while (i < 12) {
                    i++;
                    if (i == 12 && (bA = (byte) (my4Var.a() ^ b)) != ((byte) (j >> 24)) && bA != ((byte) (j2 >> 8))) {
                        throw new qy4("Wrong password!", 1);
                    }
                    my4Var.c((byte) (my4Var.a() ^ b));
                    if (i != 12) {
                        b = bArr[i];
                    }
                }
                return ha1Var;
        }
    }
}
