package io.sentry;

import defpackage.fw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g2 {
    public final ArrayList a;

    public g2(List list) {
        this.a = new ArrayList(list == null ? new ArrayList(0) : list);
    }

    public b2 a() {
        ArrayList arrayList = this.a;
        if (arrayList.isEmpty()) {
            return null;
        }
        return (b2) fw.r(arrayList, 1);
    }

    public boolean b() {
        if (this.a.size() == 1) {
            return true;
        }
        b2 b2VarA = a();
        d();
        if (!(a() instanceof e2)) {
            if (!(a() instanceof c2)) {
                return false;
            }
            c2 c2Var = (c2) a();
            if (b2VarA == null || c2Var == null) {
                return false;
            }
            c2Var.a.add(b2VarA.getValue());
            return false;
        }
        e2 e2Var = (e2) a();
        d();
        d2 d2Var = (d2) a();
        if (e2Var == null || b2VarA == null || d2Var == null) {
            return false;
        }
        d2Var.a.put(e2Var.a, b2VarA.getValue());
        return false;
    }

    public boolean c(a2 a2Var) {
        Object objA = a2Var.a();
        if (a() == null && objA != null) {
            this.a.add(new f2(objA));
            return true;
        }
        if (a() instanceof e2) {
            e2 e2Var = (e2) a();
            d();
            ((d2) a()).a.put(e2Var.a, objA);
            return false;
        }
        if (!(a() instanceof c2)) {
            return false;
        }
        ((c2) a()).a.add(objA);
        return false;
    }

    public void d() {
        ArrayList arrayList = this.a;
        if (arrayList.isEmpty()) {
            return;
        }
        arrayList.remove(arrayList.size() - 1);
    }

    public g2() {
        this.a = new ArrayList();
    }
}
