package defpackage;

import j$.util.Objects;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nt2 extends le {
    public final boolean X;
    public final nj4 Y;
    public final zj4 Z;
    public final b72 y0;
    public ke0 z0;

    public nt2(nt2 nt2Var, nm nmVar, zj4 zj4Var, b72 b72Var, Boolean bool) {
        super(nt2Var, nmVar, bool);
        this.Y = nt2Var.Y;
        this.Z = zj4Var;
        this.X = nt2Var.X;
        this.z0 = z83.e;
        this.y0 = b72Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // defpackage.le, defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b72 a(gt3 gt3Var, nm nmVar) {
        b72 b72VarD;
        nj4 nj4Var;
        Object objC;
        zj4 zj4Var = this.Z;
        zj4 zj4VarG = zj4Var != null ? zj4Var.g(nmVar) : zj4Var;
        if (nmVar != null) {
            c9 c9VarA = nmVar.a();
            b72VarD = (c9VarA == null || (objC = gt3Var.b.d().c(c9VarA)) == null) ? null : gt3Var.D(c9VarA, objC);
        }
        e52 e52VarK = l34.k(gt3Var, nmVar, this.b);
        Boolean boolB = e52VarK != null ? e52VarK.b(b52.b) : null;
        b72 b72Var = this.y0;
        if (b72VarD == null) {
            b72VarD = b72Var;
        }
        b72 b72VarJ = l34.j(gt3Var, nmVar, b72VarD);
        if (b72VarJ == null && (nj4Var = this.Y) != null && this.X && !nj4Var.j0()) {
            b72VarJ = gt3Var.i(nj4Var, nmVar);
        }
        b72 b72Var2 = b72VarJ;
        return (this.z == nmVar && b72Var2 == b72Var && zj4Var == zj4VarG && Objects.equals(this.A, boolB)) ? this : new nt2(this, nmVar, zj4VarG, b72Var2, boolB);
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((Object[]) obj).length == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // defpackage.b72
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) throws IOException {
        Object[] objArr = (Object[]) obj;
        if (objArr.length == 1) {
            Boolean bool = this.A;
            if (bool == null) {
                if (!gt3Var.b.h(dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
                }
                r(objArr, i52Var, gt3Var);
                return;
            }
        }
        i52Var.r0(objArr);
        r(objArr, i52Var, gt3Var);
        i52Var.I();
    }

    @Override // defpackage.hd0
    public final hd0 o(zj4 zj4Var) {
        return new nt2(this.Y, this.X, zj4Var, this.y0);
    }

    @Override // defpackage.le
    public final b72 q(nm nmVar, Boolean bool) {
        return new nt2(this, nmVar, this.Z, this.y0, bool);
    }

    @Override // defpackage.le
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void r(Object[] objArr, i52 i52Var, gt3 gt3Var) throws IOException {
        Object obj;
        Object obj2;
        ke0 ke0VarN;
        nj4 nj4Var = this.Y;
        int length = objArr.length;
        if (length == 0) {
            return;
        }
        int i = 0;
        b72 b72Var = this.y0;
        zj4 zj4Var = this.Z;
        if (b72Var != null) {
            int length2 = objArr.length;
            Object obj3 = null;
            while (i < length2) {
                try {
                    obj3 = objArr[i];
                    if (obj3 == null) {
                        gt3Var.h(i52Var);
                    } else if (zj4Var == null) {
                        b72Var.e(obj3, i52Var, gt3Var);
                    } else {
                        b72Var.f(obj3, i52Var, gt3Var, zj4Var);
                    }
                    i++;
                } catch (Exception e) {
                    l34.m(gt3Var, e, obj3, i);
                    throw null;
                }
            }
            return;
        }
        nm nmVar = this.z;
        if (zj4Var != null) {
            int length3 = objArr.length;
            try {
                ke0 ke0Var = this.z0;
                obj2 = null;
                while (i < length3) {
                    try {
                        obj2 = objArr[i];
                        if (obj2 == null) {
                            gt3Var.h(i52Var);
                        } else {
                            Class<?> cls = obj2.getClass();
                            b72 b72VarA = ke0Var.A(cls);
                            if (b72VarA == null && ke0Var != (ke0VarN = ke0Var.n(cls, (b72VarA = gt3Var.j(cls, nmVar))))) {
                                this.z0 = ke0VarN;
                            }
                            b72VarA.f(obj2, i52Var, gt3Var, zj4Var);
                        }
                        i++;
                    } catch (Exception e2) {
                        e = e2;
                        l34.m(gt3Var, e, obj2, i);
                        throw null;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                obj2 = null;
            }
        } else {
            try {
                ke0 ke0Var2 = this.z0;
                obj = null;
                while (i < length) {
                    try {
                        obj = objArr[i];
                        if (obj == null) {
                            gt3Var.h(i52Var);
                        } else {
                            Class<?> cls2 = obj.getClass();
                            b72 b72VarA2 = ke0Var2.A(cls2);
                            if (b72VarA2 == null) {
                                if (nj4Var.e0()) {
                                    v62 v62VarG = ke0Var2.g(gt3Var.e(nj4Var, cls2), gt3Var, nmVar);
                                    ke0 ke0Var3 = (ke0) v62VarG.z;
                                    if (ke0Var2 != ke0Var3) {
                                        this.z0 = ke0Var3;
                                    }
                                    b72VarA2 = (b72) v62VarG.f;
                                } else {
                                    b72VarA2 = gt3Var.j(cls2, nmVar);
                                    ke0 ke0VarN2 = ke0Var2.n(cls2, b72VarA2);
                                    if (ke0Var2 != ke0VarN2) {
                                        this.z0 = ke0VarN2;
                                    }
                                }
                            }
                            b72VarA2.e(obj, i52Var, gt3Var);
                        }
                        i++;
                    } catch (Exception e4) {
                        e = e4;
                        l34.m(gt3Var, e, obj, i);
                        throw null;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                obj = null;
            }
        }
    }

    public nt2(nj4 nj4Var, boolean z, zj4 zj4Var, b72 b72Var) {
        super(Object[].class);
        this.Y = nj4Var;
        this.X = z;
        this.Z = zj4Var;
        this.z0 = z83.e;
        this.y0 = b72Var;
    }
}
