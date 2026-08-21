package defpackage;

import android.database.SQLException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class za0 implements va0 {
    public final AtomicBoolean A;
    public final long X;
    public final q13 b;
    public final q13 f;
    public final ThreadLocal z;

    public za0(final lb lbVar, final String str, int i) {
        str.getClass();
        this.z = new ThreadLocal();
        final int i2 = 0;
        this.A = new AtomicBoolean(false);
        vd3 vd3Var = cz0.b;
        this.X = ek0.I(30);
        if (i <= 0) {
            xe.k("Maximum number of readers must be greater than 0");
            throw null;
        }
        this.b = new q13(i, new pl1() { // from class: wa0
            @Override // defpackage.pl1
            public final Object a() {
                int i3 = i2;
                String str2 = str;
                lb lbVar2 = lbVar;
                switch (i3) {
                    case 0:
                        go3 go3VarI = lbVar2.i(str2);
                        ez4.t(go3VarI, "PRAGMA query_only = 1");
                        return go3VarI;
                    default:
                        return lbVar2.i(str2);
                }
            }
        });
        final int i3 = 1;
        this.f = new q13(1, new pl1() { // from class: wa0
            @Override // defpackage.pl1
            public final Object a() {
                int i32 = i3;
                String str2 = str;
                lb lbVar2 = lbVar;
                switch (i32) {
                    case 0:
                        go3 go3VarI = lbVar2.i(str2);
                        ez4.t(go3VarI, "PRAGMA query_only = 1");
                        return go3VarI;
                    default:
                        return lbVar2.i(str2);
                }
            }
        });
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.A.compareAndSet(false, true)) {
            this.b.c();
            this.f.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0143 A[Catch: all -> 0x0191, TRY_LEAVE, TryCatch #1 {all -> 0x0191, blocks: (B:63:0x011c, B:68:0x0138, B:70:0x0143, B:83:0x0195, B:84:0x019c), top: B:107:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017b A[Catch: all -> 0x0190, TRY_LEAVE, TryCatch #0 {all -> 0x0190, blocks: (B:74:0x0175, B:76:0x017b, B:78:0x0186, B:79:0x0189), top: B:105:0x0175 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0195 A[Catch: all -> 0x0191, TRY_ENTER, TryCatch #1 {all -> 0x0191, blocks: (B:63:0x011c, B:68:0x0138, B:70:0x0143, B:83:0x0195, B:84:0x019c), top: B:107:0x011c }] */
    /* JADX WARN: Type inference failed for: r15v1, types: [xa0] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [q13] */
    /* JADX WARN: Type inference failed for: r2v6, types: [q13] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v5, types: [q13] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    @Override // defpackage.va0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(boolean z, Function2 function2, ie0 ie0Var) {
        ya0 ya0Var;
        bh3 bh3Var;
        Throwable th;
        ?? r2;
        bh3 bh3Var2;
        Object obj;
        cf0 cf0Var;
        ?? r5;
        Object obj2;
        bh3 bh3Var3;
        ?? r22;
        z13 z13Var;
        za0 za0Var = this;
        final boolean z2 = z;
        Function2 function22 = function2;
        if (ie0Var instanceof ya0) {
            ya0Var = (ya0) ie0Var;
            int i = ya0Var.D0;
            if ((i & Integer.MIN_VALUE) != 0) {
                ya0Var.D0 = i - Integer.MIN_VALUE;
            } else {
                ya0Var = new ya0(za0Var, ie0Var);
            }
        }
        cf0 cf0Var2 = ya0Var.f;
        Object obj3 = ya0Var.B0;
        int i2 = ya0Var.D0;
        cf0 cf0Var3 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        mf0 mf0Var = mf0.b;
        if (i2 == 0) {
            n12.S(obj3);
            if (za0Var.A.get()) {
                ez4.Y(21, "Connection pool is closed");
                throw null;
            }
            ThreadLocal threadLocal = za0Var.z;
            z13 z13Var2 = (z13) threadLocal.get();
            d7 d7Var = ua0.f;
            if (z13Var2 == null) {
                cf0Var2.getClass();
                ua0 ua0Var = (ua0) cf0Var2.Z(d7Var);
                z13Var2 = ua0Var != null ? ua0Var.b : null;
            }
            if (z13Var2 == null) {
                ?? r52 = z2 ? za0Var.b : za0Var.f;
                bh3Var = new bh3();
                try {
                    cf0Var2.getClass();
                    long j = za0Var.X;
                    ?? r15 = new pl1() { // from class: xa0
                        @Override // defpackage.pl1
                        public final Object a() {
                            String str = z2 ? "reader" : "writer";
                            StringBuilder sb = new StringBuilder();
                            sb.append("Timed out attempting to acquire a " + str + " connection.");
                            sb.append("\n\nWriter pool:\n");
                            za0 za0Var2 = this.b;
                            za0Var2.f.d(sb);
                            sb.append("Reader pool:");
                            sb.append('\n');
                            za0Var2.b.d(sb);
                            try {
                                ez4.Y(5, sb.toString());
                                throw null;
                            } catch (SQLException e) {
                                e.printStackTrace();
                                return xl4.a;
                            }
                        }
                    };
                    ya0Var.A = za0Var;
                    ya0Var.X = (Serializable) function22;
                    ya0Var.Y = r52;
                    ya0Var.Z = bh3Var;
                    ya0Var.y0 = cf0Var2;
                    ya0Var.z0 = bh3Var;
                    ya0Var.A0 = z2;
                    ya0Var.D0 = 3;
                    Object objB = r52.b(j, r15, ya0Var);
                    if (objB != mf0Var) {
                        obj = objB;
                        cf0Var = cf0Var2;
                        bh3Var2 = bh3Var;
                        r5 = r52;
                        gb0 gb0Var = (gb0) obj;
                        gb0Var.getClass();
                        cf0Var.getClass();
                        gb0Var.z = cf0Var;
                        gb0Var.A = new Throwable();
                        bh3Var.b = new z13(gb0Var, za0Var.b == za0Var.f && z2);
                        obj2 = bh3Var2.b;
                        if (obj2 != null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r2 = r52;
                    bh3Var2 = bh3Var;
                }
            } else {
                if (!z2 && z13Var2.b) {
                    ez4.Y(1, "Cannot upgrade connection from reader to writer");
                    throw null;
                }
                cf0Var2.getClass();
                if (cf0Var2.Z(d7Var) == null) {
                    cf0 cf0VarW = tj4.W(new ua0(z13Var2), new pd4(z13Var2, threadLocal));
                    hj hjVar = new hj(function22, z13Var2, z3 ? 1 : 0, 8);
                    ya0Var.D0 = 1;
                    Object objB0 = ji0.b0(cf0VarW, hjVar, ya0Var);
                    if (objB0 != mf0Var) {
                        return objB0;
                    }
                } else {
                    ya0Var.D0 = 2;
                    Object objK = function22.k(z13Var2, ya0Var);
                    if (objK != mf0Var) {
                        return objK;
                    }
                }
            }
            return mf0Var;
        }
        if (i2 == 1) {
            n12.S(obj3);
            return obj3;
        }
        if (i2 == 2) {
            n12.S(obj3);
            return obj3;
        }
        if (i2 == 3) {
            boolean z6 = ya0Var.A0;
            bh3 bh3Var4 = ya0Var.z0;
            cf0 cf0Var4 = ya0Var.y0;
            bh3 bh3Var5 = ya0Var.Z;
            q13 q13Var = ya0Var.Y;
            Function2 function23 = (Function2) ya0Var.X;
            za0 za0Var2 = (za0) ya0Var.A;
            try {
                n12.S(obj3);
                cf0Var = cf0Var4;
                obj = obj3;
                r5 = q13Var;
                bh3Var = bh3Var4;
                bh3Var2 = bh3Var5;
                function22 = function23;
                z2 = z6;
                za0Var = za0Var2;
                try {
                    gb0 gb0Var2 = (gb0) obj;
                    gb0Var2.getClass();
                    cf0Var.getClass();
                    gb0Var2.z = cf0Var;
                    gb0Var2.A = new Throwable();
                    bh3Var.b = new z13(gb0Var2, za0Var.b == za0Var.f && z2);
                    obj2 = bh3Var2.b;
                    if (obj2 != null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    z13 z13Var3 = (z13) obj2;
                    cf0 cf0VarW2 = tj4.W(new ua0(z13Var3), new pd4(z13Var3, za0Var.z));
                    hj hjVar2 = new hj(function22, bh3Var2, z4 ? 1 : 0, 9);
                    ya0Var.A = r5;
                    ya0Var.X = bh3Var2;
                    ya0Var.Y = null;
                    ya0Var.Z = null;
                    ya0Var.y0 = null;
                    ya0Var.z0 = null;
                    ya0Var.D0 = 4;
                    Object objB02 = ji0.b0(cf0VarW2, hjVar2, ya0Var);
                    if (objB02 != mf0Var) {
                        bh3Var3 = bh3Var2;
                        r22 = r5;
                        obj3 = objB02;
                        z13Var = (z13) bh3Var3.b;
                        if (z13Var != null) {
                        }
                        return obj3;
                    }
                    return mf0Var;
                } catch (Throwable th3) {
                    th = th3;
                    r2 = r5;
                }
            } catch (Throwable th4) {
                th = th4;
                bh3Var2 = bh3Var5;
                r2 = q13Var;
            }
        } else {
            if (i2 != 4) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bh3Var3 = (bh3) ya0Var.X;
            q13 q13Var2 = (q13) ya0Var.A;
            try {
                n12.S(obj3);
                r22 = q13Var2;
                try {
                    z13Var = (z13) bh3Var3.b;
                    if (z13Var != null) {
                        gb0 gb0Var3 = z13Var.a;
                        if (z13Var.d.compareAndSet(false, true)) {
                            try {
                                ez4.t(gb0Var3, "ROLLBACK TRANSACTION");
                            } catch (SQLException unused) {
                            }
                        }
                        gb0Var3.z = null;
                        gb0Var3.A = null;
                        r22.e(gb0Var3);
                    }
                } catch (Throwable unused2) {
                }
                return obj3;
            } catch (Throwable th5) {
                bh3Var2 = bh3Var3;
                th = th5;
                r2 = q13Var2;
            }
        }
        try {
            throw th;
        } finally {
        }
    }

    public za0(lb lbVar) {
        this.z = new ThreadLocal();
        this.A = new AtomicBoolean(false);
        vd3 vd3Var = cz0.b;
        this.X = ek0.I(30);
        q13 q13Var = new q13(1, new fn(2, lbVar));
        this.b = q13Var;
        this.f = q13Var;
    }
}
