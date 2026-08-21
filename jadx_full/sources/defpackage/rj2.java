package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class rj2 extends on2 {
    public final to3 l = new to3();

    @Override // defpackage.yc2
    public final void g() {
        Iterator it = this.l.iterator();
        while (true) {
            po3 po3Var = (po3) it;
            if (!po3Var.hasNext()) {
                return;
            }
            qj2 qj2Var = (qj2) ((Map.Entry) po3Var.next()).getValue();
            qj2Var.b.f(qj2Var);
        }
    }

    @Override // defpackage.yc2
    public final void h() {
        Iterator it = this.l.iterator();
        while (true) {
            po3 po3Var = (po3) it;
            if (!po3Var.hasNext()) {
                return;
            } else {
                ((qj2) ((Map.Entry) po3Var.next()).getValue()).a();
            }
        }
    }

    public void m(yc2 yc2Var, hu2 hu2Var) {
        Object obj;
        qj2 qj2Var = new qj2(yc2Var, hu2Var);
        to3 to3Var = this.l;
        qo3 qo3VarA = to3Var.a(yc2Var);
        if (qo3VarA != null) {
            obj = qo3VarA.f;
        } else {
            qo3 qo3Var = new qo3(yc2Var, qj2Var);
            to3Var.A++;
            qo3 qo3Var2 = to3Var.f;
            if (qo3Var2 == null) {
                to3Var.b = qo3Var;
                to3Var.f = qo3Var;
            } else {
                qo3Var2.z = qo3Var;
                qo3Var.A = qo3Var2;
                to3Var.f = qo3Var;
            }
            obj = null;
        }
        qj2 qj2Var2 = (qj2) obj;
        if (qj2Var2 != null && qj2Var2.f != hu2Var) {
            xe.k("This source was already added with the different observer");
        } else if (qj2Var2 == null && this.c > 0) {
            yc2Var.f(qj2Var);
        }
    }
}
