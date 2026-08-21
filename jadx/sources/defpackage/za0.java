package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(boolean r17, kotlin.jvm.functions.Function2 r18, defpackage.ie0 r19) {
        /*
            Method dump skipped, instruction units count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za0.m(boolean, kotlin.jvm.functions.Function2, ie0):java.lang.Object");
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
