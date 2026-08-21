package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class og2 extends ye {
    public ng2 i;
    public final wn1 k;
    public volatile boolean g = true;
    public volatile int h = 1;
    public ArrayList j = null;

    public og2(ig2 ig2Var, Map map) {
        this.k = new wn1(4, ig2Var);
        this.i = new ng2(this, map);
    }

    public final ng2 X(List list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ig2 ig2Var = (ig2) ((c1) it.next());
            linkedHashMap.put(ig2Var.z, ig2Var.A);
        }
        return new ng2(this, linkedHashMap);
    }

    public final ArrayList Y(ng2 ng2Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((mg2) ng2Var.entrySet()).iterator();
        while (true) {
            Iterator it2 = (Iterator) ((gr1) it).z;
            if (!it2.hasNext()) {
                return arrayList;
            }
            Map.Entry entry = (Map.Entry) it2.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            gg2 gg2VarW = ((ig2) this.k.f).k();
            gg2VarW.f = key;
            gg2VarW.A = true;
            gg2VarW.z = value;
            gg2VarW.X = true;
            arrayList.add(new ig2(gg2VarW.b, key, value));
        }
    }

    public final void Z() {
        if (this.g) {
            return;
        }
        vp1.q();
    }

    public final Map a0() {
        if (this.h == 2) {
            synchronized (this) {
                try {
                    if (this.h == 2) {
                        this.i = X(this.j);
                        this.h = 3;
                    }
                } finally {
                }
            }
        }
        return DesugarCollections.unmodifiableMap(this.i);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof og2) {
            return rg2.c(a0(), ((og2) obj).a0());
        }
        return false;
    }

    public final int hashCode() {
        return rg2.a(a0());
    }

    @Override // defpackage.ye
    public final List v() {
        if (this.h == 1) {
            synchronized (this) {
                try {
                    if (this.h == 1) {
                        this.j = Y(this.i);
                        this.h = 3;
                    }
                } finally {
                }
            }
        }
        return DesugarCollections.unmodifiableList(this.j);
    }

    @Override // defpackage.ye
    public final ig2 x() {
        return (ig2) this.k.f;
    }

    @Override // defpackage.ye
    public final List y() {
        if (this.h != 2) {
            if (this.h == 1) {
                this.j = Y(this.i);
            }
            this.i = null;
            this.h = 2;
        }
        return this.j;
    }
}
