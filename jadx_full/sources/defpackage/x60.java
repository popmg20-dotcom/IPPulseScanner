package defpackage;

import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x60 extends se {
    public final boolean A0;

    public x60(nj4 nj4Var, boolean z, ak4 ak4Var, b72 b72Var) {
        super(Collection.class, nj4Var, z, ak4Var, b72Var);
        this.A0 = nj4Var.i0() || nj4Var.j0();
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((Collection) obj).isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r0 == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // defpackage.b72
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) throws IOException {
        Collection collection = (Collection) obj;
        if (collection.size() == 1) {
            Boolean bool = this.Y;
            if (bool == null) {
                if (!gt3Var.b.h(dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
                }
                q(collection, i52Var, gt3Var);
                return;
            }
        }
        i52Var.r0(collection);
        q(collection, i52Var, gt3Var);
        i52Var.I();
    }

    @Override // defpackage.hd0
    public final hd0 o(zj4 zj4Var) {
        return new x60(this, this.A, zj4Var, this.y0, this.Y);
    }

    @Override // defpackage.se
    public final se r(nm nmVar, zj4 zj4Var, b72 b72Var, Boolean bool) {
        return new x60(this, nmVar, zj4Var, b72Var, bool);
    }

    @Override // defpackage.se
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void q(Collection collection, i52 i52Var, gt3 gt3Var) throws IOException {
        nj4 nj4Var = this.z;
        i52Var.s(collection);
        int i = 0;
        zj4 zj4Var = this.Z;
        boolean z = this.A0;
        b72 b72Var = this.y0;
        if (b72Var != null) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (z && (collection instanceof EnumSet)) {
                    zj4Var = null;
                }
                do {
                    Object next = it.next();
                    if (next == null) {
                        try {
                            gt3Var.h(i52Var);
                        } catch (Exception e) {
                            l34.m(gt3Var, e, collection, i);
                            throw null;
                        }
                    } else if (zj4Var == null) {
                        b72Var.e(next, i52Var, gt3Var);
                    } else {
                        b72Var.f(next, i52Var, gt3Var, zj4Var);
                    }
                    i++;
                } while (it.hasNext());
                return;
            }
            return;
        }
        Iterator it2 = collection.iterator();
        if (it2.hasNext()) {
            ke0 ke0Var = this.z0;
            if (z && (collection instanceof EnumSet)) {
                zj4Var = null;
            }
            do {
                try {
                    Object next2 = it2.next();
                    if (next2 == null) {
                        gt3Var.h(i52Var);
                    } else {
                        Class<?> cls = next2.getClass();
                        b72 b72VarA = ke0Var.A(cls);
                        if (b72VarA == null) {
                            if (nj4Var.e0()) {
                                b72VarA = p(ke0Var, gt3Var.e(nj4Var, cls), gt3Var);
                            } else {
                                b72VarA = gt3Var.j(cls, this.A);
                                ke0 ke0VarN = ke0Var.n(cls, b72VarA);
                                if (ke0Var != ke0VarN) {
                                    this.z0 = ke0VarN;
                                }
                            }
                            ke0Var = this.z0;
                        }
                        if (zj4Var == null) {
                            b72VarA.e(next2, i52Var, gt3Var);
                        } else {
                            b72VarA.f(next2, i52Var, gt3Var, zj4Var);
                        }
                    }
                    i++;
                } catch (Exception e2) {
                    l34.m(gt3Var, e2, collection, i);
                    throw null;
                }
            } while (it2.hasNext());
        }
    }

    public x60(x60 x60Var, nm nmVar, zj4 zj4Var, b72 b72Var, Boolean bool) {
        super(x60Var, nmVar, zj4Var, b72Var, bool);
        this.A0 = x60Var.A0;
    }
}
