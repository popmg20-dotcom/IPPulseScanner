package defpackage;

import java.io.IOException;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class dj4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        boolean zI;
        BitSet bitSet = new BitSet();
        r62Var.B0();
        int iX = r62Var.X();
        int i = 0;
        while (iX != 2) {
            int iG = fw.G(iX);
            if (iG == 5 || iG == 6) {
                int iNextInt = r62Var.nextInt();
                if (iNextInt == 0) {
                    zI = false;
                } else {
                    if (iNextInt != 1) {
                        StringBuilder sbD = dw2.D("Invalid bitset value ", iNextInt, ", expected 0 or 1; at path ");
                        sbD.append(r62Var.x(true));
                        throw new l52(sbD.toString());
                    }
                    zI = true;
                }
            } else {
                if (iG != 7) {
                    throw new l52("Invalid bitset value type: " + ha0.B(iX) + "; at path " + r62Var.x(false));
                }
                zI = r62Var.I();
            }
            if (zI) {
                bitSet.set(i);
            }
            i++;
            iX = r62Var.X();
        }
        r62Var.w0();
        return bitSet;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        v72Var.B0();
        int length = bitSet.length();
        for (int i = 0; i < length; i++) {
            v72Var.U(bitSet.get(i) ? 1L : 0L);
        }
        v72Var.w0();
    }
}
