package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i44 extends le {
    public static final i44 Y;
    public final b72 X;

    static {
        rj4.z.getClass();
        qj4 qj4Var = rj4.A;
        if (!qj4Var.f() || rj4.a(String.class) == null) {
            new jx3(String.class, qj4Var, null, null);
        }
        Y = new i44();
    }

    public i44() {
        super(String[].class);
        this.X = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // defpackage.le, defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b72 a(gt3 gt3Var, nm nmVar) {
        b72 b72VarD;
        Object objC;
        if (nmVar != null) {
            cu2 cu2VarD = gt3Var.b.d();
            c9 c9VarA = nmVar.a();
            b72VarD = (c9VarA == null || (objC = cu2VarD.c(c9VarA)) == null) ? null : gt3Var.D(c9VarA, objC);
        }
        e52 e52VarK = l34.k(gt3Var, nmVar, String[].class);
        Boolean boolB = e52VarK != null ? e52VarK.b(b52.b) : null;
        b72 b72Var = this.X;
        if (b72VarD == null) {
            b72VarD = b72Var;
        }
        b72 b72VarJ = l34.j(gt3Var, nmVar, b72VarD);
        if (b72VarJ == null) {
            b72VarJ = gt3Var.j(String.class, nmVar);
        }
        b72 b72Var2 = n50.q(b72VarJ) ? null : b72VarJ;
        return (b72Var2 == b72Var && Objects.equals(boolB, this.A)) ? this : new i44(this, nmVar, b72Var2, boolB);
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((String[]) obj).length == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // defpackage.b72
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        String[] strArr = (String[]) obj;
        if (strArr.length == 1) {
            Boolean bool = this.A;
            if (bool == null) {
                if (!gt3Var.b.h(dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
                }
                r(strArr, i52Var, gt3Var);
                return;
            }
        }
        i52Var.r0(strArr);
        r(strArr, i52Var, gt3Var);
        i52Var.I();
    }

    @Override // defpackage.le
    public final b72 q(nm nmVar, Boolean bool) {
        return new i44(this, nmVar, this.X, bool);
    }

    @Override // defpackage.le
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void r(String[] strArr, i52 i52Var, gt3 gt3Var) {
        int length = strArr.length;
        if (length == 0) {
            return;
        }
        int i = 0;
        b72 b72Var = this.X;
        if (b72Var == null) {
            while (i < length) {
                String str = strArr[i];
                if (str == null) {
                    i52Var.U();
                } else {
                    i52Var.G0(str);
                }
                i++;
            }
            return;
        }
        int length2 = strArr.length;
        while (i < length2) {
            String str2 = strArr[i];
            if (str2 == null) {
                gt3Var.h(i52Var);
            } else {
                b72Var.e(str2, i52Var, gt3Var);
            }
            i++;
        }
    }

    public i44(i44 i44Var, nm nmVar, b72 b72Var, Boolean bool) {
        super(i44Var, nmVar, bool);
        this.X = b72Var;
    }

    @Override // defpackage.hd0
    public final hd0 o(zj4 zj4Var) {
        return this;
    }
}
