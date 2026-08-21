package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d92 {
    public zt a;
    public final o91 b;
    public volatile nl2 c;
    public volatile zt d;
    public volatile boolean e;
    public final nl2 f;

    public d92(nl2 nl2Var, o91 o91Var, zt ztVar) {
        if (o91Var == null) {
            zo2.n("found null ExtensionRegistry");
            throw null;
        }
        this.b = o91Var;
        this.a = ztVar;
        this.f = nl2Var;
    }

    public final int a() {
        int size;
        if (this.d != null) {
            size = this.d.size();
        } else {
            zt ztVar = this.a;
            size = ztVar != null ? ztVar.size() : this.c != null ? this.c.h() : 0;
        }
        return q60.j(size) + size;
    }

    public final nl2 b() {
        nl2 nl2Var = this.f;
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    try {
                        if (this.a != null) {
                            m03 m03VarM = nl2Var.m();
                            zt ztVar = this.a;
                            o91 o91Var = this.b;
                            i1 i1Var = (i1) m03VarM;
                            i1Var.getClass();
                            m60 m60VarD = m60.d(ztVar.f, ztVar.e(), ztVar.size(), true);
                            nl2 nl2Var2 = (nl2) i1Var.a(m60VarD, o91Var);
                            m60VarD.a(0);
                            i1.b(nl2Var2);
                            this.c = nl2Var2;
                            this.d = this.a;
                        } else {
                            this.c = nl2Var;
                            this.d = zt.z;
                        }
                    } catch (s12 unused) {
                        this.e = true;
                        this.c = nl2Var;
                        this.d = zt.z;
                    }
                }
            }
        }
        return this.c;
    }

    public final boolean equals(Object obj) {
        return b().equals(obj);
    }

    public final int hashCode() {
        return b().hashCode();
    }

    public final String toString() {
        return b().toString();
    }
}
