package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xg2 extends hi4 {
    public final /* synthetic */ int a = 0;
    public final Object b;
    public final hi4 c;
    public final Object d;

    public xg2(c70 c70Var, xg2 xg2Var, xg2 xg2Var2, st2 st2Var) {
        this.b = xg2Var;
        this.c = xg2Var2;
        this.d = st2Var;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        switch (this.a) {
            case 0:
                int iX = r62Var.X();
                if (iX == 9) {
                    r62Var.N();
                    return null;
                }
                Map map = (Map) ((st2) this.d).a();
                if (iX == 1) {
                    r62Var.B0();
                    while (r62Var.hasNext()) {
                        r62Var.B0();
                        Object objB = ((xg2) this.b).c.b(r62Var);
                        if (map.put(objB, ((xg2) this.c).c.b(r62Var)) != null) {
                            throw new l52("duplicate key: " + objB);
                        }
                        r62Var.w0();
                    }
                    r62Var.w0();
                } else {
                    r62Var.p0();
                    while (r62Var.hasNext()) {
                        vd3.z0.getClass();
                        int iN = r62Var.Z;
                        if (iN == 0) {
                            iN = r62Var.n();
                        }
                        if (iN == 13) {
                            r62Var.Z = 9;
                        } else if (iN == 12) {
                            r62Var.Z = 8;
                        } else {
                            if (iN != 14) {
                                throw r62Var.r0("a name");
                            }
                            r62Var.Z = 10;
                        }
                        Object objB2 = ((xg2) this.b).c.b(r62Var);
                        if (map.put(objB2, ((xg2) this.c).c.b(r62Var)) != null) {
                            throw new l52("duplicate key: " + objB2);
                        }
                    }
                    r62Var.V();
                }
                return map;
            default:
                return this.c.b(r62Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    @Override // defpackage.hi4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(v72 v72Var, Object obj) throws IOException {
        hi4 hi4VarD;
        int i = this.a;
        hi4 hi4Var = this.c;
        switch (i) {
            case 0:
                Map map = (Map) obj;
                xg2 xg2Var = (xg2) hi4Var;
                if (map == null) {
                    v72Var.C();
                } else {
                    v72Var.p0();
                    for (Map.Entry entry : map.entrySet()) {
                        v72Var.s(String.valueOf(entry.getKey()));
                        xg2Var.c(v72Var, entry.getValue());
                    }
                    v72Var.V();
                }
                break;
            default:
                Type type = (Type) this.d;
                Type type2 = (obj == null || !((type instanceof Class) || (type instanceof TypeVariable))) ? type : obj.getClass();
                if (type2 != type) {
                    hi4 hi4VarD2 = ((iq1) this.b).d(new bk4(type2));
                    if (hi4VarD2 instanceof jh3) {
                        hi4 hi4Var2 = hi4Var;
                        while ((hi4Var2 instanceof ct3) && (hi4VarD = ((ct3) hi4Var2).d()) != hi4Var2) {
                            hi4Var2 = hi4VarD;
                        }
                        if (hi4Var2 instanceof jh3) {
                        }
                    } else {
                        hi4Var = hi4VarD2;
                    }
                }
                hi4Var.c(v72Var, obj);
                break;
        }
    }

    public xg2(iq1 iq1Var, hi4 hi4Var, Type type) {
        this.b = iq1Var;
        this.c = hi4Var;
        this.d = type;
    }
}
