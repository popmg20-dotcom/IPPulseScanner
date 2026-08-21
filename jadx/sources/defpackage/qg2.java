package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qg2 extends ye {
    public LinkedHashMap g = new LinkedHashMap();
    public ArrayList h = null;
    public final pg2 i;

    public qg2(pg2 pg2Var) {
        this.i = pg2Var;
    }

    public final og2 X(ig2 ig2Var) {
        og2 og2Var = new og2(ig2Var, new LinkedHashMap());
        if (og2Var.h != 1) {
            if (og2Var.h == 2) {
                og2Var.i = og2Var.X(og2Var.j);
            }
            og2Var.j = null;
            og2Var.h = 1;
        }
        ng2 ng2Var = og2Var.i;
        for (Map.Entry entry : ((LinkedHashMap) Y()).entrySet()) {
            ng2Var.put(entry.getKey(), this.i.b((ql2) entry.getValue()));
        }
        og2Var.g = false;
        return og2Var;
    }

    public final Map Y() {
        LinkedHashMap linkedHashMap = this.g;
        if (linkedHashMap != null) {
            return linkedHashMap;
        }
        this.g = new LinkedHashMap(this.h.size());
        ArrayList<ig2> arrayList = new ArrayList(this.h.size());
        pg2 pg2Var = this.i;
        Class<?> cls = ((ql2) pg2Var.f().A).getClass();
        for (c1 c1Var : this.h) {
            ig2 ig2Var = (ig2) c1Var;
            if (cls.isInstance(ig2Var.A)) {
                arrayList.add(ig2Var);
            } else {
                gg2 gg2VarE = pg2Var.f().e();
                gg2VarE.v(c1Var);
                arrayList.add(gg2VarE.build());
            }
        }
        for (ig2 ig2Var2 : arrayList) {
            this.g.put(ig2Var2.z, (ql2) ig2Var2.A);
        }
        this.h = null;
        return this.g;
    }

    public final List Z() {
        ArrayList arrayList = this.h;
        if (arrayList != null) {
            return arrayList;
        }
        if (this.g == null) {
            throw null;
        }
        this.h = new ArrayList(this.g.size());
        for (Map.Entry entry : this.g.entrySet()) {
            ArrayList arrayList2 = this.h;
            pg2 pg2Var = this.i;
            gg2 gg2VarE = pg2Var.f().e();
            gg2VarE.f = entry.getKey();
            gg2VarE.A = true;
            gg2VarE.z = pg2Var.b((ql2) entry.getValue());
            gg2VarE.X = true;
            arrayList2.add(gg2VarE.build());
        }
        this.g = null;
        return this.h;
    }

    public final void a0(og2 og2Var) {
        Map mapY = Y();
        Map mapA0 = og2Var.a0();
        int i = rg2.f;
        LinkedHashMap linkedHashMap = new LinkedHashMap(((mapA0.size() * 4) / 3) + 1);
        for (Map.Entry entry : mapA0.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                value = Arrays.copyOf(bArr, bArr.length);
            }
            linkedHashMap.put(key, value);
        }
        mapY.putAll(linkedHashMap);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof qg2) {
            return rg2.c(Y(), ((qg2) obj).Y());
        }
        return false;
    }

    public final int hashCode() {
        return rg2.a(Y());
    }

    @Override // defpackage.ye
    public final List v() {
        return Z();
    }

    @Override // defpackage.ye
    public final ig2 x() {
        return this.i.f();
    }

    @Override // defpackage.ye
    public final List y() {
        return Z();
    }
}
