package defpackage;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o51 extends se {
    public final /* synthetic */ int A0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o51(se seVar, nm nmVar, zj4 zj4Var, b72 b72Var, Boolean bool, int i) {
        super(seVar, nmVar, zj4Var, b72Var, bool);
        this.A0 = i;
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        switch (this.A0) {
            case 0:
                return ((EnumSet) obj).isEmpty();
            case 1:
                return ((List) obj).isEmpty();
            case 2:
                return !((Iterable) obj).iterator().hasNext();
            default:
                return !((Iterator) obj).hasNext();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        if (r2 == java.lang.Boolean.TRUE) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
    
        if (r2 == java.lang.Boolean.TRUE) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    @Override // defpackage.b72
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) throws IOException {
        boolean z;
        int i = this.A0;
        Boolean bool = this.Y;
        switch (i) {
            case 0:
                EnumSet enumSet = (EnumSet) obj;
                if (enumSet.size() == 1) {
                    if (bool == null) {
                        if (!gt3Var.b.h(dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
                        }
                        t(enumSet, i52Var, gt3Var);
                    }
                }
                i52Var.r0(enumSet);
                t(enumSet, i52Var, gt3Var);
                i52Var.I();
                break;
            case 1:
                List list = (List) obj;
                if (list.size() == 1) {
                    if (bool == null) {
                        if (!gt3Var.b.h(dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
                        }
                        v(list, i52Var, gt3Var);
                    }
                }
                i52Var.r0(list);
                v(list, i52Var, gt3Var);
                i52Var.I();
                break;
            case 2:
                Iterable iterable = (Iterable) obj;
                if (bool == null) {
                    if (!gt3Var.b.h(dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
                        if (bool == Boolean.TRUE) {
                            if (iterable != null) {
                                Iterator it = iterable.iterator();
                                if (it.hasNext()) {
                                    it.next();
                                    z = !it.hasNext();
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    s(iterable, i52Var, gt3Var);
                                }
                                break;
                            }
                        }
                    }
                }
                i52Var.q0(iterable);
                s(iterable, i52Var, gt3Var);
                i52Var.I();
                break;
            default:
                Iterator it2 = (Iterator) obj;
                i52Var.q0(it2);
                u(it2, i52Var, gt3Var);
                i52Var.I();
                break;
        }
    }

    @Override // defpackage.hd0
    public final hd0 o(zj4 zj4Var) {
        switch (this.A0) {
            case 0:
                return this;
            case 1:
                return new o51(this, this.A, zj4Var, this.y0, this.Y, 1);
            case 2:
                return new o51(this, this.A, zj4Var, this.y0, this.Y, 2);
            default:
                return new o51(this, this.A, zj4Var, this.y0, this.Y, 3);
        }
    }

    @Override // defpackage.se
    public final /* bridge */ /* synthetic */ void q(Object obj, i52 i52Var, gt3 gt3Var) throws IOException {
        switch (this.A0) {
            case 0:
                t((EnumSet) obj, i52Var, gt3Var);
                break;
            case 1:
                v((List) obj, i52Var, gt3Var);
                break;
            case 2:
                s((Iterable) obj, i52Var, gt3Var);
                break;
            default:
                u((Iterator) obj, i52Var, gt3Var);
                break;
        }
    }

    @Override // defpackage.se
    public final se r(nm nmVar, zj4 zj4Var, b72 b72Var, Boolean bool) {
        switch (this.A0) {
            case 0:
                return new o51(this, nmVar, zj4Var, b72Var, bool, 0);
            case 1:
                return new o51(this, nmVar, zj4Var, b72Var, bool, 1);
            case 2:
                return new o51(this, nmVar, zj4Var, b72Var, bool, 2);
            default:
                return new o51(this, nmVar, zj4Var, b72Var, bool, 3);
        }
    }

    public void s(Iterable iterable, i52 i52Var, gt3 gt3Var) {
        b72 b72Var;
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Class<?> cls = null;
            b72 b72VarQ = null;
            do {
                Object next = it.next();
                if (next == null) {
                    gt3Var.h(i52Var);
                } else {
                    b72 b72Var2 = this.y0;
                    if (b72Var2 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            b72VarQ = gt3Var.q(cls2, this.A);
                            cls = cls2;
                        }
                        b72Var = b72VarQ;
                    } else {
                        b72Var = b72VarQ;
                        b72VarQ = b72Var2;
                    }
                    zj4 zj4Var = this.Z;
                    if (zj4Var == null) {
                        b72VarQ.e(next, i52Var, gt3Var);
                    } else {
                        b72VarQ.f(next, i52Var, gt3Var, zj4Var);
                    }
                    b72VarQ = b72Var;
                }
            } while (it.hasNext());
        }
    }

    public void t(EnumSet enumSet, i52 i52Var, gt3 gt3Var) {
        i52Var.s(enumSet);
        Iterator it = enumSet.iterator();
        b72 b72VarJ = this.y0;
        while (it.hasNext()) {
            Enum r1 = (Enum) it.next();
            if (b72VarJ == null) {
                b72VarJ = gt3Var.j(r1.getDeclaringClass(), this.A);
            }
            b72VarJ.e(r1, i52Var, gt3Var);
        }
    }

    public void u(Iterator it, i52 i52Var, gt3 gt3Var) {
        if (it.hasNext()) {
            zj4 zj4Var = this.Z;
            b72 b72Var = this.y0;
            if (b72Var != null) {
                do {
                    Object next = it.next();
                    if (next == null) {
                        gt3Var.h(i52Var);
                    } else if (zj4Var == null) {
                        b72Var.e(next, i52Var, gt3Var);
                    } else {
                        b72Var.f(next, i52Var, gt3Var, zj4Var);
                    }
                } while (it.hasNext());
                return;
            }
            ke0 ke0Var = this.z0;
            do {
                Object next2 = it.next();
                if (next2 == null) {
                    gt3Var.h(i52Var);
                } else {
                    Class<?> cls = next2.getClass();
                    b72 b72VarA = ke0Var.A(cls);
                    if (b72VarA == null) {
                        nj4 nj4Var = this.z;
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
            } while (it.hasNext());
        }
    }

    public void v(List list, i52 i52Var, gt3 gt3Var) throws IOException {
        int i = 0;
        zj4 zj4Var = this.Z;
        b72 b72Var = this.y0;
        if (b72Var != null) {
            int size = list.size();
            if (size == 0) {
                return;
            }
            while (i < size) {
                Object obj = list.get(i);
                if (obj == null) {
                    try {
                        gt3Var.h(i52Var);
                    } catch (Exception e) {
                        l34.m(gt3Var, e, list, i);
                        throw null;
                    }
                } else if (zj4Var == null) {
                    b72Var.e(obj, i52Var, gt3Var);
                } else {
                    b72Var.f(obj, i52Var, gt3Var, zj4Var);
                }
                i++;
            }
            return;
        }
        nm nmVar = this.A;
        nj4 nj4Var = this.z;
        if (zj4Var != null) {
            int size2 = list.size();
            if (size2 == 0) {
                return;
            }
            try {
                ke0 ke0Var = this.z0;
                while (i < size2) {
                    Object obj2 = list.get(i);
                    if (obj2 == null) {
                        gt3Var.h(i52Var);
                    } else {
                        Class<?> cls = obj2.getClass();
                        b72 b72VarA = ke0Var.A(cls);
                        if (b72VarA == null) {
                            if (nj4Var.e0()) {
                                b72VarA = p(ke0Var, gt3Var.e(nj4Var, cls), gt3Var);
                            } else {
                                b72VarA = gt3Var.j(cls, nmVar);
                                ke0 ke0VarN = ke0Var.n(cls, b72VarA);
                                if (ke0Var != ke0VarN) {
                                    this.z0 = ke0VarN;
                                }
                            }
                            ke0Var = this.z0;
                        }
                        b72VarA.f(obj2, i52Var, gt3Var, zj4Var);
                    }
                    i++;
                }
                return;
            } catch (Exception e2) {
                l34.m(gt3Var, e2, list, i);
                throw null;
            }
        }
        int size3 = list.size();
        if (size3 == 0) {
            return;
        }
        try {
            ke0 ke0Var2 = this.z0;
            while (i < size3) {
                Object obj3 = list.get(i);
                if (obj3 == null) {
                    gt3Var.h(i52Var);
                } else {
                    Class<?> cls2 = obj3.getClass();
                    b72 b72VarA2 = ke0Var2.A(cls2);
                    if (b72VarA2 == null) {
                        if (nj4Var.e0()) {
                            b72VarA2 = p(ke0Var2, gt3Var.e(nj4Var, cls2), gt3Var);
                        } else {
                            b72VarA2 = gt3Var.j(cls2, nmVar);
                            ke0 ke0VarN2 = ke0Var2.n(cls2, b72VarA2);
                            if (ke0Var2 != ke0VarN2) {
                                this.z0 = ke0VarN2;
                            }
                        }
                        ke0Var2 = this.z0;
                    }
                    b72VarA2.e(obj3, i52Var, gt3Var);
                }
                i++;
            }
        } catch (Exception e3) {
            l34.m(gt3Var, e3, list, i);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o51(Class cls, nj4 nj4Var, boolean z, zj4 zj4Var, b72 b72Var, int i) {
        super(cls, nj4Var, z, zj4Var, b72Var);
        this.A0 = i;
    }
}
