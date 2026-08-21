package defpackage;

import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tx1 implements rt3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ tx1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.rt3
    public final void a(tt3 tt3Var) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                xx1 xx1Var = (xx1) obj;
                if (xx1Var.c() != null) {
                    sa4 sa4Var = xx1Var.v;
                    sa4Var.getClass();
                    co4.h();
                    sa4Var.A = true;
                    xx1Var.D(true);
                    String strE = xx1Var.e();
                    yx1 yx1Var = (yx1) xx1Var.g;
                    ih ihVar = xx1Var.h;
                    ihVar.getClass();
                    pt3 pt3VarE = xx1Var.E(strE, yx1Var, ihVar);
                    xx1Var.t = pt3VarE;
                    Object[] objArr = {pt3VarE.c()};
                    ArrayList arrayList = new ArrayList(1);
                    Object obj2 = objArr[0];
                    Objects.requireNonNull(obj2);
                    arrayList.add(obj2);
                    xx1Var.C(DesugarCollections.unmodifiableList(arrayList));
                    xx1Var.p();
                    sa4 sa4Var2 = xx1Var.v;
                    sa4Var2.getClass();
                    co4.h();
                    sa4Var2.A = false;
                    sa4Var2.c();
                    break;
                }
                break;
            case 1:
                cm2 cm2Var = (cm2) obj;
                cm2Var.z = cm2Var.l();
                sw swVar = (sw) cm2Var.Y;
                if (swVar != null) {
                    ex exVar = swVar.f;
                    try {
                    } catch (InterruptedException | ExecutionException e) {
                        e = e;
                    }
                    try {
                        if (((Boolean) fx3.m(new sw(exVar, 4)).f.get()).booleanValue()) {
                            cm2 cm2Var2 = exVar.R0;
                            exVar.z.execute(new uw(exVar, ex.z(cm2Var2), (tt3) cm2Var2.z, (bm2) cm2Var2.A, null, Collections.singletonList(on4.Y), 0));
                            break;
                        }
                    } catch (ExecutionException e2) {
                        e = e2;
                        zo2.o("Unable to check if MeteringRepeating is attached.", e);
                        return;
                    }
                }
                break;
            case 2:
                j43 j43Var = (j43) obj;
                if (j43Var.c() != null) {
                    j43Var.F((k43) j43Var.g, j43Var.h);
                    j43Var.p();
                    break;
                }
                break;
            default:
                Iterator it = ((st3) obj).n.iterator();
                while (it.hasNext()) {
                    ((rt3) it.next()).a(tt3Var);
                }
                break;
        }
    }
}
