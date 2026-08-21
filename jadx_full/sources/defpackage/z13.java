package defpackage;

import android.database.SQLException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z13 implements jg4, ld3 {
    public final gb0 a;
    public final boolean b;
    public final ae c = new ae();
    public final AtomicBoolean d = new AtomicBoolean(false);

    public z13(gb0 gb0Var, boolean z) {
        this.a = gb0Var;
        this.b = z;
    }

    @Override // defpackage.jg4
    public final Object a(ig4 ig4Var, Function2 function2, v74 v74Var) {
        if (this.d.get()) {
            ez4.Y(21, "Connection is recycled");
            throw null;
        }
        cf0 cf0Var = v74Var.f;
        cf0Var.getClass();
        ua0 ua0Var = (ua0) cf0Var.Z(ua0.f);
        if (ua0Var != null && ua0Var.b == this) {
            return g(ig4Var, function2, v74Var);
        }
        ez4.Y(21, "Attempted to use connection on a different coroutine");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.r13
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(String str, am1 am1Var, ie0 ie0Var) {
        y13 y13Var;
        gb0 gb0Var;
        if (ie0Var instanceof y13) {
            y13Var = (y13) ie0Var;
            int i = y13Var.A0;
            if ((i & Integer.MIN_VALUE) != 0) {
                y13Var.A0 = i - Integer.MIN_VALUE;
            } else {
                y13Var = new y13(this, ie0Var);
            }
        }
        Object obj = y13Var.y0;
        int i2 = y13Var.A0;
        if (i2 == 0) {
            n12.S(obj);
            if (this.d.get()) {
                ez4.Y(21, "Connection is recycled");
                throw null;
            }
            cf0 cf0Var = y13Var.f;
            cf0Var.getClass();
            ua0 ua0Var = (ua0) cf0Var.Z(ua0.f);
            if (ua0Var == null || ua0Var.b != this) {
                ez4.Y(21, "Attempted to use connection on a different coroutine");
                throw null;
            }
            y13Var.A = this;
            y13Var.X = str;
            y13Var.Y = am1Var;
            gb0Var = this.a;
            y13Var.Z = gb0Var;
            y13Var.A0 = 1;
            Object objG = gb0Var.f.g(y13Var);
            mf0 mf0Var = mf0.b;
            if (objG == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            gb0 gb0Var2 = y13Var.Z;
            am1Var = y13Var.Y;
            str = y13Var.X;
            z13 z13Var = y13Var.A;
            n12.S(obj);
            gb0Var = gb0Var2;
            this = z13Var;
        }
        try {
            s13 s13Var = new s13(this, this.a.D0(str));
            try {
                Object objG2 = am1Var.g(s13Var);
                vf2.e(s13Var, null);
                return objG2;
            } finally {
            }
        } finally {
            gb0Var.n(null);
        }
    }

    @Override // defpackage.ld3
    public final go3 c() {
        return this.a;
    }

    @Override // defpackage.jg4
    public final Object d(v74 v74Var) {
        if (this.d.get()) {
            ez4.Y(21, "Connection is recycled");
            throw null;
        }
        cf0 cf0Var = v74Var.f;
        cf0Var.getClass();
        ua0 ua0Var = (ua0) cf0Var.Z(ua0.f);
        if (ua0Var != null && ua0Var.b == this) {
            return Boolean.valueOf(!this.c.isEmpty());
        }
        ez4.Y(21, "Attempted to use connection on a different coroutine");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(ig4 ig4Var, ie0 ie0Var) {
        v13 v13Var;
        gb0 gb0Var;
        if (ie0Var instanceof v13) {
            v13Var = (v13) ie0Var;
            int i = v13Var.z0;
            if ((i & Integer.MIN_VALUE) != 0) {
                v13Var.z0 = i - Integer.MIN_VALUE;
            } else {
                v13Var = new v13(this, ie0Var);
            }
        }
        Object obj = v13Var.Z;
        int i2 = v13Var.z0;
        if (i2 == 0) {
            n12.S(obj);
            v13Var.A = this;
            v13Var.X = ig4Var;
            gb0Var = this.a;
            v13Var.Y = gb0Var;
            v13Var.z0 = 1;
            Object objG = gb0Var.f.g(v13Var);
            mf0 mf0Var = mf0.b;
            if (objG == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            gb0 gb0Var2 = v13Var.Y;
            ig4Var = v13Var.X;
            z13 z13Var = v13Var.A;
            n12.S(obj);
            gb0Var = gb0Var2;
            this = z13Var;
        }
        try {
            ae aeVar = this.c;
            gb0 gb0Var3 = this.a;
            int i3 = aeVar.z;
            if (aeVar.isEmpty()) {
                int iOrdinal = ig4Var.ordinal();
                if (iOrdinal == 0) {
                    ez4.t(gb0Var3, "BEGIN DEFERRED TRANSACTION");
                } else if (iOrdinal == 1) {
                    ez4.t(gb0Var3, "BEGIN IMMEDIATE TRANSACTION");
                } else {
                    if (iOrdinal != 2) {
                        throw new t80();
                    }
                    ez4.t(gb0Var3, "BEGIN EXCLUSIVE TRANSACTION");
                }
            } else {
                ez4.t(gb0Var3, "SAVEPOINT '" + i3 + '\'');
            }
            aeVar.addLast(new u13(i3));
            xl4 xl4Var = xl4.a;
            gb0Var.n(null);
            return xl4Var;
        } catch (Throwable th) {
            gb0Var.n(null);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(boolean z, ie0 ie0Var) {
        w13 w13Var;
        gb0 gb0Var;
        if (ie0Var instanceof w13) {
            w13Var = (w13) ie0Var;
            int i = w13Var.z0;
            if ((i & Integer.MIN_VALUE) != 0) {
                w13Var.z0 = i - Integer.MIN_VALUE;
            } else {
                w13Var = new w13(this, ie0Var);
            }
        }
        Object obj = w13Var.Z;
        int i2 = w13Var.z0;
        if (i2 == 0) {
            n12.S(obj);
            w13Var.A = this;
            gb0Var = this.a;
            w13Var.X = gb0Var;
            w13Var.Y = z;
            w13Var.z0 = 1;
            Object objG = gb0Var.f.g(w13Var);
            mf0 mf0Var = mf0.b;
            if (objG == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z = w13Var.Y;
            gb0 gb0Var2 = w13Var.X;
            z13 z13Var = w13Var.A;
            n12.S(obj);
            gb0Var = gb0Var2;
            this = z13Var;
        }
        try {
            ae aeVar = this.c;
            gb0 gb0Var3 = this.a;
            if (aeVar.isEmpty()) {
                throw new IllegalStateException("Not in a transaction");
            }
            u13 u13Var = (u13) d70.p0(aeVar);
            if (z) {
                u13Var.getClass();
                if (aeVar.isEmpty()) {
                    ez4.t(gb0Var3, "END TRANSACTION");
                } else {
                    ez4.t(gb0Var3, "RELEASE SAVEPOINT '" + u13Var.a + '\'');
                }
            } else if (aeVar.isEmpty()) {
                ez4.t(gb0Var3, "ROLLBACK TRANSACTION");
            } else {
                ez4.t(gb0Var3, "ROLLBACK TRANSACTION TO SAVEPOINT '" + u13Var.a + '\'');
            }
            xl4 xl4Var = xl4.a;
            gb0Var.n(null);
            return xl4Var;
        } catch (Throwable th) {
            gb0Var.n(null);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(ig4 ig4Var, Function2 function2, ie0 ie0Var) throws Throwable {
        x13 x13Var;
        z13 z13Var;
        int i;
        SQLException e;
        Throwable th;
        if (ie0Var instanceof x13) {
            x13Var = (x13) ie0Var;
            int i2 = x13Var.z0;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                x13Var.z0 = i2 - Integer.MIN_VALUE;
            } else {
                x13Var = new x13(this, ie0Var);
            }
        }
        Object objK = x13Var.Z;
        int i3 = x13Var.z0;
        mf0 mf0Var = mf0.b;
        try {
            if (i3 == 0) {
                n12.S(objK);
                if (ig4Var == null) {
                    ig4Var = ig4.b;
                }
                x13Var.A = this;
                x13Var.X = (Serializable) function2;
                x13Var.z0 = 1;
                if (e(ig4Var, x13Var) != mf0Var) {
                }
            }
            if (i3 == 1) {
                function2 = (Function2) x13Var.X;
                this = (z13) x13Var.A;
                n12.S(objK);
            } else {
                if (i3 != 2) {
                    if (i3 == 3 || i3 == 4) {
                        Object obj = x13Var.A;
                        n12.S(objK);
                        return obj;
                    }
                    if (i3 != 5) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    th = (Throwable) x13Var.X;
                    th = (Throwable) x13Var.A;
                    try {
                        n12.S(objK);
                        throw th;
                    } catch (SQLException e2) {
                        e = e2;
                        if (th != null) {
                            throw e;
                        }
                        ek0.b(th, e);
                        throw th;
                    }
                }
                i = x13Var.Y;
                z13Var = (z13) x13Var.A;
                try {
                    n12.S(objK);
                    boolean z = i != 0;
                    x13Var.A = objK;
                    x13Var.z0 = 3;
                    return z13Var.f(z, x13Var) != mf0Var ? mf0Var : objK;
                } catch (Throwable th2) {
                    th = th2;
                    this = z13Var;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        try {
                            x13Var.A = th;
                            x13Var.X = th3;
                            x13Var.z0 = 5;
                            if (this.f(false, x13Var) != mf0Var) {
                                throw th3;
                            }
                        } catch (SQLException e3) {
                            e = e3;
                            th = th3;
                            if (th != null) {
                            }
                        }
                    }
                }
            }
            t13 t13Var = new t13(0, this);
            x13Var.A = this;
            x13Var.X = null;
            x13Var.Y = 1;
            x13Var.z0 = 2;
            objK = function2.k(t13Var, x13Var);
            if (objK != mf0Var) {
                z13Var = this;
                i = 1;
                if (i != 0) {
                }
                x13Var.A = objK;
                x13Var.z0 = 3;
                if (z13Var.f(z, x13Var) != mf0Var) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            throw th;
        }
    }
}
