package defpackage;

import j$.util.DesugarCollections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rk3 implements j90 {
    public final Set a;
    public final Set b;
    public final Set c;
    public final Set d;
    public final Set e;
    public final Set f;
    public final j90 g;

    public rk3(x80 x80Var, j90 j90Var) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        Set<ho0> set = x80Var.c;
        Set set2 = x80Var.g;
        for (ho0 ho0Var : set) {
            int i = ho0Var.c;
            int i2 = ho0Var.b;
            boolean z = i == 0;
            fc3 fc3Var = ho0Var.a;
            if (z) {
                if (i2 == 2) {
                    hashSet4.add(fc3Var);
                } else {
                    hashSet.add(fc3Var);
                }
            } else if (i == 2) {
                hashSet3.add(fc3Var);
            } else if (i2 == 2) {
                hashSet5.add(fc3Var);
            } else {
                hashSet2.add(fc3Var);
            }
        }
        if (!set2.isEmpty()) {
            hashSet.add(fc3.a(vb3.class));
        }
        this.a = DesugarCollections.unmodifiableSet(hashSet);
        this.b = DesugarCollections.unmodifiableSet(hashSet2);
        this.c = DesugarCollections.unmodifiableSet(hashSet3);
        this.d = DesugarCollections.unmodifiableSet(hashSet4);
        this.e = DesugarCollections.unmodifiableSet(hashSet5);
        this.f = set2;
        this.g = j90Var;
    }

    @Override // defpackage.j90
    public final Set a(fc3 fc3Var) {
        if (this.d.contains(fc3Var)) {
            return this.g.a(fc3Var);
        }
        s53.l("Attempting to request an undeclared dependency Set<", fc3Var, ">.");
        return null;
    }

    @Override // defpackage.j90
    public final da3 b(Class cls) {
        return c(fc3.a(cls));
    }

    @Override // defpackage.j90
    public final da3 c(fc3 fc3Var) {
        if (this.b.contains(fc3Var)) {
            return this.g.c(fc3Var);
        }
        s53.l("Attempting to request an undeclared dependency Provider<", fc3Var, ">.");
        return null;
    }

    @Override // defpackage.j90
    public final Object d(fc3 fc3Var) {
        if (this.a.contains(fc3Var)) {
            return this.g.d(fc3Var);
        }
        s53.l("Attempting to request an undeclared dependency ", fc3Var, ".");
        return null;
    }

    public final Set e(Class cls) {
        return a(fc3.a(cls));
    }

    @Override // defpackage.j90
    public final Object get(Class cls) {
        if (!this.a.contains(fc3.a(cls))) {
            s53.l("Attempting to request an undeclared dependency ", cls, ".");
            return null;
        }
        Object obj = this.g.get(cls);
        if (!cls.equals(vb3.class)) {
            return obj;
        }
        return new qk3(this.f);
    }
}
