package defpackage;

import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h64 implements jg4, ld3 {
    public final c64 a;

    public h64(c64 c64Var) {
        this.a = c64Var;
    }

    @Override // defpackage.jg4
    public final Object a(ig4 ig4Var, Function2 function2, v74 v74Var) {
        return e(ig4Var, function2, v74Var);
    }

    @Override // defpackage.r13
    public final Object b(String str, am1 am1Var, ie0 ie0Var) {
        l64 l64VarD0 = this.a.D0(str);
        try {
            Object objG = am1Var.g(l64VarD0);
            vf2.e(l64VarD0, null);
            return objG;
        } finally {
        }
    }

    @Override // defpackage.ld3
    public final go3 c() {
        return this.a;
    }

    @Override // defpackage.jg4
    public final Object d(v74 v74Var) {
        return Boolean.valueOf(this.a.b.I());
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(ig4 ig4Var, Function2 function2, ie0 ie0Var) throws Throwable {
        g64 g64Var;
        h64 h64Var;
        gl1 gl1Var;
        if (ie0Var instanceof g64) {
            g64Var = (g64) ie0Var;
            int i = g64Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                g64Var.y0 = i - Integer.MIN_VALUE;
            } else {
                g64Var = new g64(this, ie0Var);
            }
        }
        Object obj = g64Var.Y;
        int i2 = g64Var.y0;
        if (i2 == 0) {
            n12.S(obj);
            gl1 gl1Var2 = this.a.b;
            gl1Var2.I();
            int iOrdinal = ig4Var.ordinal();
            if (iOrdinal == 0) {
                SQLiteDatabase sQLiteDatabase = gl1Var2.b;
                z82 z82Var = gl1.X;
                if (((Method) z82Var.getValue()) != null) {
                    z82 z82Var2 = gl1.A;
                    if (((Method) z82Var2.getValue()) != null) {
                        Method method = (Method) z82Var.getValue();
                        method.getClass();
                        Method method2 = (Method) z82Var2.getValue();
                        method2.getClass();
                        Object objInvoke = method2.invoke(sQLiteDatabase, null);
                        if (objInvoke != null) {
                            method.invoke(objInvoke, 0, null, 0, null);
                        } else {
                            xe.q("Required value was null.");
                        }
                    }
                }
                gl1Var2.g();
            } else if (iOrdinal == 1) {
                gl1Var2.n();
            } else {
                if (iOrdinal != 2) {
                    g.d();
                    return null;
                }
                gl1Var2.g();
            }
            try {
                Object t13Var = new t13(1, this);
                g64Var.A = this;
                g64Var.X = gl1Var2;
                g64Var.y0 = 1;
                Object objK = function2.k(t13Var, g64Var);
                Object obj2 = mf0.b;
                if (objK == obj2) {
                    return obj2;
                }
                h64Var = this;
                gl1Var = gl1Var2;
                obj = objK;
            } catch (Throwable th) {
                th = th;
                h64Var = this;
                gl1Var = gl1Var2;
                gl1Var.x();
                if (!gl1Var.I()) {
                    h64Var.getClass();
                }
                throw th;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            gl1Var = g64Var.X;
            h64Var = g64Var.A;
            try {
                n12.S(obj);
            } catch (Throwable th2) {
                th = th2;
                gl1Var.x();
                if (!gl1Var.I()) {
                }
                throw th;
            }
        }
        gl1Var.M();
        gl1Var.x();
        if (!gl1Var.I()) {
            h64Var.getClass();
        }
        return obj;
    }
}
