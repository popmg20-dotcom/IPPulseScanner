package defpackage;

import android.text.TextUtils;
import java.text.Bidi;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class md0 implements vd0 {
    public final t6[] b = new t6[64];
    public boolean f;

    public md0(ld0 ld0Var) {
        ld0Var.a(this);
    }

    @Override // defpackage.vd0
    public final synchronized void F(ld0 ld0Var, int i, int i2, int i3, int i4, CharSequence charSequence) {
        int i5 = i3 - i;
        int i6 = 0;
        while (true) {
            try {
                t6[] t6VarArr = this.b;
                if (i6 < t6VarArr.length) {
                    t6 t6Var = t6VarArr[i6];
                    if (t6Var != null) {
                        int i7 = t6Var.f;
                        if (i7 > i) {
                            t6Var.f = i7 + i5;
                        } else if (i7 == i) {
                            t6VarArr[i6] = null;
                        }
                    }
                    i6++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.vd0
    public final synchronized void Q(ld0 ld0Var, int i, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        int i6 = i3 - i;
        int i7 = 0;
        while (true) {
            try {
                t6[] t6VarArr = this.b;
                if (i7 < t6VarArr.length) {
                    t6 t6Var = t6VarArr[i7];
                    if (t6Var != null && (i5 = t6Var.f) >= i) {
                        if (i5 > i3) {
                            t6Var.f = i5 - i6;
                        } else {
                            t6VarArr[i7] = null;
                        }
                    }
                    i7++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final bv0 b(int i, ud0 ud0Var) {
        bv0 bv0Var;
        char c = 0;
        long jM = ez4.M(0, 0);
        if (!this.f) {
            return new bv0(new long[]{jM}, ud0Var.f);
        }
        synchronized (this) {
            int i2 = 0;
            while (true) {
                try {
                    t6[] t6VarArr = this.b;
                    if (i2 >= t6VarArr.length) {
                        int i3 = ud0Var.f;
                        if (ud0Var.z > 0) {
                            char[] cArrS = gb4.S(i3);
                            TextUtils.getChars(ud0Var, 0, i3, cArrS, 0);
                            Bidi bidi = new Bidi(cArrS, 0, null, 0, ud0Var.f, -2);
                            int runCount = bidi.getRunCount();
                            long[] jArr = new long[runCount];
                            for (int i4 = 0; i4 < runCount; i4++) {
                                jArr[i4] = ez4.M(bidi.getRunStart(i4), bidi.getRunLevel(i4));
                            }
                            gb4.U(cArrS);
                            bv0Var = new bv0(jArr, i3);
                        } else {
                            bv0Var = new bv0(new long[]{jM}, i3);
                        }
                        synchronized (this) {
                            t6[] t6VarArr2 = this.b;
                            System.arraycopy(t6VarArr2, 0, t6VarArr2, 1, t6VarArr2.length - 1);
                            t6[] t6VarArr3 = this.b;
                            t6 t6Var = new t6(c, 2);
                            t6Var.z = bv0Var;
                            t6Var.f = i;
                            t6VarArr3[0] = t6Var;
                        }
                        return bv0Var;
                    }
                    t6 t6Var2 = t6VarArr[i2];
                    if (t6Var2 != null && t6Var2.f == i) {
                        return (bv0) t6Var2.z;
                    }
                    i2++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // defpackage.vd0
    public final void I(ld0 ld0Var) {
    }

    @Override // defpackage.vd0
    public final void a(ld0 ld0Var) {
    }
}
