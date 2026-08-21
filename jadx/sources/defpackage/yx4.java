package defpackage;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yx4 {
    public final gx4 a;
    public final Context b;
    public final String c;
    public final ih4 d;
    public final na0 e;
    public final n53 f;
    public final WorkDatabase g;
    public final jx4 h;
    public final mo0 i;
    public final ArrayList j;
    public final String k;
    public final x32 l;

    public yx4(uf4 uf4Var) {
        gx4 gx4Var = (gx4) uf4Var.f;
        this.a = gx4Var;
        this.b = (Context) uf4Var.b;
        String str = gx4Var.a;
        this.c = str;
        this.d = (ih4) uf4Var.c;
        this.e = (na0) uf4Var.a;
        this.f = (n53) uf4Var.d;
        WorkDatabase workDatabase = (WorkDatabase) uf4Var.e;
        this.g = workDatabase;
        this.h = workDatabase.x();
        this.i = workDatabase.s();
        ArrayList arrayList = (ArrayList) uf4Var.g;
        this.j = arrayList;
        this.k = fw.y(fw.D("Work [ id=", str, ", tags={ "), d70.j0(arrayList, ",", null, null, null, 62), " } ]");
        this.l = je.b();
    }

    public final void a(int i) {
        jx4 jx4Var = this.h;
        ww4 ww4Var = ww4.b;
        String str = this.c;
        jx4Var.h(ww4Var, str);
        jx4Var.g(System.currentTimeMillis(), str);
        jx4Var.f(this.a.v, str);
        jx4Var.e(-1L, str);
        jx4Var.i(i, str);
    }

    public final void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        jx4 jx4Var = this.h;
        String str = this.c;
        jx4Var.g(jCurrentTimeMillis, str);
        jx4Var.h(ww4.b, str);
        pl3 pl3Var = jx4Var.a;
        ((Number) ke0.r(pl3Var, false, true, new ko0(str, 18))).intValue();
        jx4Var.f(this.a.v, str);
        ke0.r(pl3Var, false, true, new ko0(str, 19));
        jx4Var.e(-1L, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(defpackage.ie0 r20) {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yx4.c(ie0):java.lang.Object");
    }

    public final void d(sc2 sc2Var) {
        String str = this.c;
        ArrayList arrayListL = e70.L(str);
        while (true) {
            boolean zIsEmpty = arrayListL.isEmpty();
            jx4 jx4Var = this.h;
            if (zIsEmpty) {
                di0 di0Var = ((pc2) sc2Var).a;
                di0Var.getClass();
                jx4Var.f(this.a.v, str);
                ke0.r(jx4Var.a, false, true, new gj(25, di0Var, str));
                return;
            }
            String str2 = (String) d70.p0(arrayListL);
            if (jx4Var.b(str2) != ww4.Y) {
                jx4Var.h(ww4.A, str2);
            }
            arrayListL.addAll(this.i.a(str2));
        }
    }
}
