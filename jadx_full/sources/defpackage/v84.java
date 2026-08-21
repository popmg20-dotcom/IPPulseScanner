package defpackage;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v84 extends k70 {
    public final HashMap X;
    public final /* synthetic */ w84 Y;

    public v84(w84 w84Var) {
        super((byte) 0, 8);
        this.Y = w84Var;
        this.X = new HashMap();
    }

    @Override // defpackage.k70
    public final void P0(fu4 fu4Var) {
        ArrayList arrayList = this.Y.b;
        if ((fu4Var.a.d() & 519) != 0) {
            this.X.remove(fu4Var);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                h93 h93Var = (h93) arrayList.get(size);
                int i = h93Var.c;
                boolean z = i > 0;
                int i2 = i - 1;
                h93Var.c = i2;
                if (z && i2 == 0) {
                    ArrayList arrayList2 = h93Var.a;
                    int size2 = arrayList2.size() - 1;
                    if (size2 >= 0) {
                        throw qe4.r(arrayList2, size2);
                    }
                }
            }
        }
    }

    @Override // defpackage.k70
    public final void Q0(fu4 fu4Var) {
        ArrayList arrayList = this.Y.b;
        if ((fu4Var.a.d() & 519) != 0) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((h93) arrayList.get(size)).c++;
            }
        }
    }

    @Override // defpackage.k70
    public final bv4 R0(bv4 bv4Var, List list) {
        ArrayList arrayList = this.Y.b;
        RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
        for (int size = list.size() - 1; size >= 0; size--) {
            fu4 fu4Var = (fu4) list.get(size);
            Integer num = (Integer) this.X.get(fu4Var);
            if (num != null) {
                int iIntValue = num.intValue();
                float fA = fu4Var.a.a();
                if ((iIntValue & 1) != 0) {
                    rectF.left = fA;
                }
                if ((iIntValue & 2) != 0) {
                    rectF.top = fA;
                }
                if ((iIntValue & 4) != 0) {
                    rectF.right = fA;
                }
                if ((iIntValue & 8) != 0) {
                    rectF.bottom = fA;
                }
            }
        }
        t02.b(bv4Var.a.h(519), bv4Var.a.h(64));
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList2 = ((h93) arrayList.get(size2)).a;
            int size3 = arrayList2.size() - 1;
            if (size3 >= 0) {
                throw qe4.r(arrayList2, size3);
            }
        }
        return bv4Var;
    }

    @Override // defpackage.k70
    public final e24 S0(fu4 fu4Var, e24 e24Var) {
        if ((fu4Var.a.d() & 519) != 0) {
            t02 t02Var = (t02) e24Var.z;
            t02 t02Var2 = (t02) e24Var.f;
            int i = t02Var.a != t02Var2.a ? 1 : 0;
            if (t02Var.b != t02Var2.b) {
                i |= 2;
            }
            if (t02Var.c != t02Var2.c) {
                i |= 4;
            }
            if (t02Var.d != t02Var2.d) {
                i |= 8;
            }
            this.X.put(fu4Var, Integer.valueOf(i));
        }
        return e24Var;
    }
}
