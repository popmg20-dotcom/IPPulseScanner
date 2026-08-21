package defpackage;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cm4 implements nl2 {
    public static final cm4 f = new cm4(new TreeMap());
    public static final bm4 z = new bm4();
    public final TreeMap b;

    public cm4(TreeMap treeMap) {
        this.b = treeMap;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return f;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        TreeMap treeMap = this.b;
        if (treeMap.isEmpty()) {
            return;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            am4 am4Var = (am4) entry.getValue();
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int i = 0;
            while (true) {
                ze2 ze2Var = am4Var.a;
                if (i >= ze2Var.z) {
                    break;
                }
                ze2Var.e(i);
                q60Var.A(iIntValue, ze2Var.f[i]);
                i++;
            }
            int i2 = 0;
            while (true) {
                x02 x02Var = am4Var.b;
                if (i2 >= x02Var.z) {
                    break;
                }
                int iF = x02Var.f(i2);
                q60Var.x(iIntValue, 5);
                q60Var.q(iF);
                i2++;
            }
            int i3 = 0;
            while (true) {
                ze2 ze2Var2 = am4Var.c;
                if (i3 >= ze2Var2.z) {
                    break;
                }
                ze2Var2.e(i3);
                long j = ze2Var2.f[i3];
                q60Var.x(iIntValue, 1);
                q60Var.r(j);
                i3++;
            }
            for (int i4 = 0; i4 < am4Var.d.size(); i4++) {
                q60Var.o(iIntValue, (zt) am4Var.d.get(i4));
            }
            for (int i5 = 0; i5 < am4Var.e.size(); i5++) {
                cm4 cm4Var = (cm4) am4Var.e.get(i5);
                q60Var.x(iIntValue, 3);
                cm4Var.d(q60Var);
                q60Var.x(iIntValue, 4);
            }
        }
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: e */
    public final ml2 u() {
        yl4 yl4VarP = yl4.p();
        yl4VarP.w(this);
        return yl4VarP;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cm4) {
            return this.b.equals(((cm4) obj).b);
        }
        return false;
    }

    @Override // defpackage.nl2
    public final zt g() {
        try {
            int iH = h();
            zt ztVar = zt.z;
            byte[] bArr = new byte[iH];
            q60 q60Var = new q60(bArr, iH);
            d(q60Var);
            q60Var.a();
            return new zt(bArr);
        } catch (IOException e) {
            zo2.o("Serializing to a ByteString threw an IOException (should never happen).", e);
            return null;
        }
    }

    @Override // defpackage.nl2
    public final int h() {
        TreeMap treeMap = this.b;
        if (treeMap.isEmpty()) {
            return 0;
        }
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            am4 am4Var = (am4) entry.getValue();
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int i2 = 0;
            int iH = 0;
            while (true) {
                ze2 ze2Var = am4Var.a;
                if (i2 >= ze2Var.z) {
                    break;
                }
                ze2Var.e(i2);
                iH += q60.k(iIntValue, ze2Var.f[i2]);
                i2++;
            }
            int i3 = 0;
            while (true) {
                x02 x02Var = am4Var.b;
                if (i3 >= x02Var.z) {
                    break;
                }
                x02Var.f(i3);
                iH += q60.h(iIntValue) + 4;
                i3++;
            }
            int i4 = 0;
            while (true) {
                ze2 ze2Var2 = am4Var.c;
                if (i4 >= ze2Var2.z) {
                    break;
                }
                ze2Var2.e(i4);
                long j = ze2Var2.f[i4];
                iH += q60.h(iIntValue) + 8;
                i4++;
            }
            for (int i5 = 0; i5 < am4Var.d.size(); i5++) {
                iH += q60.c(iIntValue, (zt) am4Var.d.get(i5));
            }
            for (int i6 = 0; i6 < am4Var.e.size(); i6++) {
                iH += ((cm4) am4Var.e.get(i6)).h() + (q60.h(iIntValue) * 2);
            }
            i += iH;
        }
        return i;
    }

    public final int hashCode() {
        TreeMap treeMap = this.b;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return treeMap.hashCode();
    }

    @Override // defpackage.nl2
    public final byte[] j() {
        try {
            int iH = h();
            byte[] bArr = new byte[iH];
            q60 q60Var = new q60(bArr, iH);
            d(q60Var);
            q60Var.a();
            return bArr;
        } catch (IOException e) {
            zo2.o("Serializing to a byte array threw an IOException (should never happen).", e);
            return null;
        }
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return yl4.p();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return z;
    }

    public final String toString() {
        boolean z2 = tb4.a;
        boolean z3 = sb4.e.c;
        try {
            StringBuilder sb = new StringBuilder();
            if (z3) {
                try {
                    sb.append((CharSequence) "");
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
            sb4.f(this, new cb0(sb, false), z3);
            return sb.toString();
        } catch (IOException e2) {
            zo2.q(e2);
            return null;
        }
    }
}
