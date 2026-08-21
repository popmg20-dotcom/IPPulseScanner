package defpackage;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yf extends l34 implements ee0 {
    public final zj4 A;
    public final Object A0;
    public final Object B0;
    public final b72 X;
    public final nm Y;
    public final nj4 Z;
    public final boolean y0;
    public final /* synthetic */ int z = 1;
    public transient ke0 z0;

    /* JADX WARN: Illegal instructions before constructor call */
    public yf(yf yfVar, nm nmVar, zj4 zj4Var, b72 b72Var, boolean z) {
        Class cls = yfVar.b;
        super(cls == null ? Object.class : cls);
        this.A0 = (c9) yfVar.A0;
        this.Z = yfVar.Z;
        this.A = zj4Var;
        this.X = b72Var;
        this.Y = nmVar;
        this.y0 = z;
        this.B0 = (Set) yfVar.B0;
        this.z0 = z83.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0172 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f8  */
    @Override // defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b72 a(gt3 gt3Var, nm nmVar) {
        b72 b72VarD;
        t52 t52VarD;
        s52 s52Var;
        Object obj;
        boolean z;
        boolean zF;
        Object objC;
        int i = this.z;
        Object obj2 = this.B0;
        nm nmVar2 = this.Y;
        b72 b72Var = this.X;
        zj4 zj4VarG = this.A;
        nj4 nj4Var = this.Z;
        boolean z2 = this.y0;
        switch (i) {
            case 0:
                bt3 bt3Var = gt3Var.b;
                zj4 zj4VarG2 = zj4VarG != null ? zj4VarG.g(nmVar) : zj4VarG;
                Object objB = null;
                if (nmVar != null) {
                    c9 c9VarA = nmVar.a();
                    b72VarD = (c9VarA == null || (objC = bt3Var.d().c(c9VarA)) == null) ? null : gt3Var.D(c9VarA, objC);
                }
                if (b72VarD == null) {
                    if (b72Var != null) {
                        b72VarD = gt3Var.u(b72Var, nmVar);
                    } else if (!nj4Var.j0()) {
                        if (Modifier.isFinal(nj4Var.L0.getModifiers()) || nj4Var.P0) {
                            zF = true;
                            if (!zF) {
                            }
                        } else {
                            cu2 cu2VarD = bt3Var.d();
                            if (nmVar != null && nmVar.a() != null) {
                                y62 y62VarH = cu2VarD.H(nmVar.a());
                                if (y62VarH != y62.f) {
                                    if (y62VarH == y62.b) {
                                        zF = false;
                                    }
                                    b72VarD = !zF ? gt3Var.m(nj4Var, nmVar) : b72Var;
                                }
                                zF = true;
                                if (!zF) {
                                }
                            }
                            zF = bt3Var.f(ah2.USE_STATIC_TYPING);
                            if (!zF) {
                            }
                        }
                    }
                }
                b72 b72VarJ = l34.j(gt3Var, nmVar, b72VarD);
                yf yfVar = (nmVar2 == nmVar && zj4VarG == zj4VarG2 && b72Var == b72VarJ) ? this : new yf(this, nmVar, zj4VarG2, b72VarJ, (po2) this.A0, this.B0, this.y0);
                if (nmVar != null && (t52VarD = nmVar.d(bt3Var, this.b)) != null && (s52Var = t52VarD.f) != s52.X) {
                    int iOrdinal = s52Var.ordinal();
                    if (iOrdinal == 1) {
                        obj = objB;
                        z = true;
                        if (obj2 == obj) {
                        }
                        return new yf(yfVar, yfVar.Y, yfVar.A, yfVar.X, (po2) yfVar.A0, obj, z);
                    }
                    s52 s52Var2 = s52.z;
                    if (iOrdinal != 2) {
                        if (iOrdinal == 3) {
                            obj = s52Var2;
                            z = true;
                            if (obj2 == obj) {
                            }
                            return new yf(yfVar, yfVar.Y, yfVar.A, yfVar.X, (po2) yfVar.A0, obj, z);
                        }
                        if (iOrdinal != 4) {
                            if (iOrdinal == 5) {
                                objB = gt3Var.w(t52VarD.A);
                                zX = objB != null ? gt3Var.x(objB) : false;
                            }
                            z = zX;
                            obj = objB;
                            if (obj2 == obj || z2 != z) {
                                return new yf(yfVar, yfVar.Y, yfVar.A, yfVar.X, (po2) yfVar.A0, obj, z);
                            }
                        } else {
                            objB = tj4.B(nj4Var);
                            if (objB != null && objB.getClass().isArray()) {
                                objB = ji0.s(objB);
                            }
                        }
                    } else if (nj4Var.B()) {
                        objB = s52Var2;
                    }
                    obj = objB;
                    z = true;
                    if (obj2 == obj) {
                    }
                    return new yf(yfVar, yfVar.Y, yfVar.A, yfVar.X, (po2) yfVar.A0, obj, z);
                }
                return yfVar;
            default:
                if (zj4VarG != null) {
                    zj4VarG = zj4VarG.g(nmVar);
                }
                if (b72Var != null) {
                    return q(nmVar, zj4VarG, gt3Var.u(b72Var, nmVar), z2);
                }
                if (!gt3Var.b.f(ah2.USE_STATIC_TYPING) && !Modifier.isFinal(nj4Var.L0.getModifiers())) {
                    return nmVar != nmVar2 ? q(nmVar, zj4VarG, b72Var, z2) : this;
                }
                b72 b72VarM = gt3Var.m(nj4Var, nmVar);
                Set set = (Set) obj2;
                if (b72VarM != null && !set.isEmpty()) {
                    b72VarM = b72VarM.i(set);
                }
                Class cls = nj4Var.L0;
                if (!cls.isPrimitive() ? cls == String.class || cls == Integer.class || cls == Boolean.class || cls == Double.class : cls == Integer.TYPE || cls == Boolean.TYPE || cls == Double.TYPE) {
                    zX = n50.q(b72VarM);
                }
                return q(nmVar, zj4VarG, b72VarM, zX);
        }
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        int i = this.z;
        b72 b72VarO = this.X;
        switch (i) {
            case 0:
                AtomicReference atomicReference = (AtomicReference) obj;
                if (atomicReference.get() == null) {
                    return true;
                }
                Object obj2 = atomicReference.get();
                if (obj2 == null) {
                    return this.y0;
                }
                Object obj3 = this.B0;
                if (obj3 == null) {
                    return false;
                }
                if (b72VarO == null) {
                    try {
                        b72VarO = o(gt3Var, obj2.getClass());
                    } catch (a62 e) {
                        throw new t80(e);
                    }
                    break;
                }
                return obj3 == s52.z ? b72VarO.c(gt3Var, obj2) : obj3.equals(obj2);
            default:
                Object objR = ((c9) this.A0).R(obj);
                if (objR == null) {
                    return true;
                }
                if (b72VarO == null) {
                    try {
                        b72VarO = p(gt3Var, objR.getClass());
                    } catch (a62 e2) {
                        throw new t80(e2);
                    }
                    break;
                }
                return b72VarO.c(gt3Var, objR);
        }
    }

    @Override // defpackage.b72
    public boolean d() {
        switch (this.z) {
            case 0:
                return ((po2) this.A0) != null;
            default:
                return super.d();
        }
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) throws IOException {
        int i = this.z;
        zj4 zj4Var = this.A;
        b72 b72VarO = this.X;
        Object obj2 = this.A0;
        switch (i) {
            case 0:
                Object obj3 = ((AtomicReference) obj).get();
                if (obj3 == null) {
                    if (((po2) obj2) == null) {
                        gt3Var.h(i52Var);
                        return;
                    }
                    return;
                } else {
                    if (b72VarO == null) {
                        b72VarO = o(gt3Var, obj3.getClass());
                    }
                    if (zj4Var != null) {
                        b72VarO.f(obj3, i52Var, gt3Var, zj4Var);
                        return;
                    } else {
                        b72VarO.e(obj3, i52Var, gt3Var);
                        return;
                    }
                }
            default:
                c9 c9Var = (c9) obj2;
                try {
                    Object objR = c9Var.R(obj);
                    if (objR == null) {
                        gt3Var.h(i52Var);
                        return;
                    }
                    if (b72VarO == null) {
                        b72VarO = p(gt3Var, objR.getClass());
                    }
                    if (zj4Var != null) {
                        b72VarO.f(objR, i52Var, gt3Var, zj4Var);
                        return;
                    } else {
                        b72VarO.e(objR, i52Var, gt3Var);
                        return;
                    }
                } catch (Exception e) {
                    l34.n(gt3Var, e, obj, c9Var.q() + "()");
                    throw null;
                }
        }
    }

    @Override // defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) throws IOException {
        int i = this.z;
        b72 b72VarO = this.X;
        Object obj2 = this.A0;
        switch (i) {
            case 0:
                Object obj3 = ((AtomicReference) obj).get();
                if (obj3 == null) {
                    if (((po2) obj2) == null) {
                        gt3Var.h(i52Var);
                        return;
                    }
                    return;
                } else {
                    if (b72VarO == null) {
                        b72VarO = o(gt3Var, obj3.getClass());
                    }
                    b72VarO.f(obj3, i52Var, gt3Var, zj4Var);
                    return;
                }
            default:
                c9 c9Var = (c9) obj2;
                try {
                    Object objR = c9Var.R(obj);
                    if (objR == null) {
                        gt3Var.h(i52Var);
                        return;
                    }
                    if (b72VarO == null) {
                        b72VarO = p(gt3Var, objR.getClass());
                    } else if (this.y0) {
                        e10 e10VarE = zj4Var.e(i52Var, zj4Var.d(obj, g72.Z));
                        b72VarO.e(objR, i52Var, gt3Var);
                        zj4Var.f(i52Var, e10VarE);
                        return;
                    }
                    b72VarO.f(objR, i52Var, gt3Var, new s72(zj4Var, obj));
                    return;
                } catch (Exception e) {
                    l34.n(gt3Var, e, obj, c9Var.q() + "()");
                    throw null;
                }
        }
    }

    @Override // defpackage.b72
    public b72 g(po2 po2Var) {
        b72 b72Var;
        switch (this.z) {
            case 0:
                b72 b72Var2 = this.X;
                if (b72Var2 != null) {
                    b72 b72VarG = b72Var2.g(po2Var);
                    if (b72VarG == b72Var2) {
                        return this;
                    }
                    b72Var = b72VarG;
                } else {
                    b72Var = b72Var2;
                }
                po2 po2Var2 = (po2) this.A0;
                po2 no2Var = po2Var2 == null ? po2Var : new no2(po2Var, po2Var2);
                if (b72Var2 == b72Var && po2Var2 == no2Var) {
                    return this;
                }
                return new yf(this, this.Y, this.A, b72Var, no2Var, this.B0, this.y0);
            default:
                return this;
        }
    }

    public b72 o(gt3 gt3Var, Class cls) {
        b72 b72VarA = this.z0.A(cls);
        if (b72VarA != null) {
            return b72VarA;
        }
        nj4 nj4Var = this.Z;
        boolean zE0 = nj4Var.e0();
        nm nmVar = this.Y;
        b72 b72VarM = zE0 ? gt3Var.m(gt3Var.e(nj4Var, cls), nmVar) : gt3Var.n(cls, nmVar);
        po2 po2Var = (po2) this.A0;
        if (po2Var != null) {
            b72VarM = b72VarM.g(po2Var);
        }
        this.z0 = this.z0.n(cls, b72VarM);
        return b72VarM;
    }

    public b72 p(gt3 gt3Var, Class cls) {
        Set set = (Set) this.B0;
        b72 b72VarA = this.z0.A(cls);
        if (b72VarA != null) {
            return b72VarA;
        }
        nj4 nj4Var = this.Z;
        boolean zE0 = nj4Var.e0();
        nm nmVar = this.Y;
        if (!zE0) {
            b72 b72VarN = gt3Var.n(cls, nmVar);
            if (b72VarN != null && !set.isEmpty()) {
                b72VarN = b72VarN.i(set);
            }
            this.z0 = this.z0.n(cls, b72VarN);
            return b72VarN;
        }
        nj4 nj4VarE = gt3Var.e(nj4Var, cls);
        b72 b72VarM = gt3Var.m(nj4VarE, nmVar);
        if (b72VarM != null && !set.isEmpty()) {
            b72VarM = b72VarM.i(set);
        }
        ke0 ke0Var = this.z0;
        ke0Var.getClass();
        this.z0 = ke0Var.n(nj4VarE.L0, b72VarM);
        return b72VarM;
    }

    public yf q(nm nmVar, zj4 zj4Var, b72 b72Var, boolean z) {
        return (this.Y == nmVar && this.A == zj4Var && this.X == b72Var && z == this.y0) ? this : new yf(this, nmVar, zj4Var, b72Var, z);
    }

    public String toString() {
        switch (this.z) {
            case 1:
                StringBuilder sb = new StringBuilder("(@JsonValue serializer for method ");
                c9 c9Var = (c9) this.A0;
                sb.append(c9Var.O());
                sb.append("#");
                sb.append(c9Var.q());
                sb.append(")");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public yf(ch3 ch3Var, zj4 zj4Var, b72 b72Var) {
        super(ch3Var);
        this.Z = ch3Var.U0;
        this.Y = null;
        this.A = zj4Var;
        this.X = b72Var;
        this.A0 = null;
        this.B0 = null;
        this.y0 = false;
        this.z0 = z83.e;
    }

    public yf(c9 c9Var, zj4 zj4Var, b72 b72Var, Set set) {
        super(c9Var.x());
        this.A0 = c9Var;
        this.Z = c9Var.x();
        this.A = zj4Var;
        this.X = b72Var;
        this.Y = null;
        this.y0 = true;
        this.B0 = set;
        this.z0 = z83.e;
    }

    public yf(yf yfVar, nm nmVar, zj4 zj4Var, b72 b72Var, po2 po2Var, Object obj, boolean z) {
        super(yfVar);
        this.Z = yfVar.Z;
        this.z0 = z83.e;
        this.Y = nmVar;
        this.A = zj4Var;
        this.X = b72Var;
        this.A0 = po2Var;
        this.B0 = obj;
        this.y0 = z;
    }
}
