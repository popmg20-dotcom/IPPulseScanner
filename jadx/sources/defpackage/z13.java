package defpackage;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r6, defpackage.am1 r7, defpackage.ie0 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof defpackage.y13
            if (r0 == 0) goto L13
            r0 = r8
            y13 r0 = (defpackage.y13) r0
            int r1 = r0.A0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A0 = r1
            goto L18
        L13:
            y13 r0 = new y13
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.y0
            int r1 = r0.A0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L36
            if (r1 != r2) goto L30
            gb0 r5 = r0.Z
            am1 r7 = r0.Y
            java.lang.String r6 = r0.X
            z13 r0 = r0.A
            defpackage.n12.S(r8)
            r8 = r5
            r5 = r0
            goto L6d
        L30:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r5)
            return r3
        L36:
            defpackage.n12.S(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r5.d
            boolean r8 = r8.get()
            r1 = 21
            if (r8 != 0) goto L96
            cf0 r8 = r0.f
            r8.getClass()
            d7 r4 = defpackage.ua0.f
            af0 r8 = r8.Z(r4)
            ua0 r8 = (defpackage.ua0) r8
            if (r8 == 0) goto L90
            z13 r8 = r8.b
            if (r8 != r5) goto L90
            r0.A = r5
            r0.X = r6
            r0.Y = r7
            gb0 r8 = r5.a
            r0.Z = r8
            r0.A0 = r2
            wn2 r1 = r8.f
            java.lang.Object r0 = r1.g(r0)
            mf0 r1 = defpackage.mf0.b
            if (r0 != r1) goto L6d
            return r1
        L6d:
            s13 r0 = new s13     // Catch: java.lang.Throwable -> L83
            gb0 r1 = r5.a     // Catch: java.lang.Throwable -> L83
            io3 r6 = r1.D0(r6)     // Catch: java.lang.Throwable -> L83
            r0.<init>(r5, r6)     // Catch: java.lang.Throwable -> L83
            java.lang.Object r5 = r7.g(r0)     // Catch: java.lang.Throwable -> L85
            defpackage.vf2.e(r0, r3)     // Catch: java.lang.Throwable -> L83
            r8.n(r3)
            return r5
        L83:
            r5 = move-exception
            goto L8c
        L85:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L87
        L87:
            r6 = move-exception
            defpackage.vf2.e(r0, r5)     // Catch: java.lang.Throwable -> L83
            throw r6     // Catch: java.lang.Throwable -> L83
        L8c:
            r8.n(r3)
            throw r5
        L90:
            java.lang.String r5 = "Attempted to use connection on a different coroutine"
            defpackage.ez4.Y(r1, r5)
            throw r3
        L96:
            java.lang.String r5 = "Connection is recycled"
            defpackage.ez4.Y(r1, r5)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z13.b(java.lang.String, am1, ie0):java.lang.Object");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(defpackage.ig4 r7, defpackage.ie0 r8) {
        /*
            r6 = this;
            java.lang.String r0 = "SAVEPOINT '"
            boolean r1 = r8 instanceof defpackage.v13
            if (r1 == 0) goto L15
            r1 = r8
            v13 r1 = (defpackage.v13) r1
            int r2 = r1.z0
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.z0 = r2
            goto L1a
        L15:
            v13 r1 = new v13
            r1.<init>(r6, r8)
        L1a:
            java.lang.Object r8 = r1.Z
            int r2 = r1.z0
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L30
            gb0 r6 = r1.Y
            ig4 r7 = r1.X
            z13 r1 = r1.A
            defpackage.n12.S(r8)
            r8 = r6
            r6 = r1
            goto L4e
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r6)
            return r4
        L36:
            defpackage.n12.S(r8)
            r1.A = r6
            r1.X = r7
            gb0 r8 = r6.a
            r1.Y = r8
            r1.z0 = r3
            wn2 r2 = r8.f
            java.lang.Object r1 = r2.g(r1)
            mf0 r2 = defpackage.mf0.b
            if (r1 != r2) goto L4e
            return r2
        L4e:
            ae r1 = r6.c     // Catch: java.lang.Throwable -> L6b
            gb0 r6 = r6.a     // Catch: java.lang.Throwable -> L6b
            int r2 = r1.z     // Catch: java.lang.Throwable -> L6b
            boolean r5 = r1.isEmpty()     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L7f
            int r7 = r7.ordinal()     // Catch: java.lang.Throwable -> L6b
            if (r7 == 0) goto L79
            if (r7 == r3) goto L73
            r0 = 2
            if (r7 != r0) goto L6d
            java.lang.String r7 = "BEGIN EXCLUSIVE TRANSACTION"
            defpackage.ez4.t(r6, r7)     // Catch: java.lang.Throwable -> L6b
            goto L93
        L6b:
            r6 = move-exception
            goto La1
        L6d:
            t80 r6 = new t80     // Catch: java.lang.Throwable -> L6b
            r6.<init>()     // Catch: java.lang.Throwable -> L6b
            throw r6     // Catch: java.lang.Throwable -> L6b
        L73:
            java.lang.String r7 = "BEGIN IMMEDIATE TRANSACTION"
            defpackage.ez4.t(r6, r7)     // Catch: java.lang.Throwable -> L6b
            goto L93
        L79:
            java.lang.String r7 = "BEGIN DEFERRED TRANSACTION"
            defpackage.ez4.t(r6, r7)     // Catch: java.lang.Throwable -> L6b
            goto L93
        L7f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L6b
            r7.append(r2)     // Catch: java.lang.Throwable -> L6b
            r0 = 39
            r7.append(r0)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L6b
            defpackage.ez4.t(r6, r7)     // Catch: java.lang.Throwable -> L6b
        L93:
            u13 r6 = new u13     // Catch: java.lang.Throwable -> L6b
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L6b
            r1.addLast(r6)     // Catch: java.lang.Throwable -> L6b
            xl4 r6 = defpackage.xl4.a     // Catch: java.lang.Throwable -> L6b
            r8.n(r4)
            return r6
        La1:
            r8.n(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z13.e(ig4, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(boolean r7, defpackage.ie0 r8) {
        /*
            r6 = this;
            java.lang.String r0 = "ROLLBACK TRANSACTION TO SAVEPOINT '"
            java.lang.String r1 = "RELEASE SAVEPOINT '"
            boolean r2 = r8 instanceof defpackage.w13
            if (r2 == 0) goto L17
            r2 = r8
            w13 r2 = (defpackage.w13) r2
            int r3 = r2.z0
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.z0 = r3
            goto L1c
        L17:
            w13 r2 = new w13
            r2.<init>(r6, r8)
        L1c:
            java.lang.Object r8 = r2.Z
            int r3 = r2.z0
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L38
            if (r3 != r4) goto L32
            boolean r7 = r2.Y
            gb0 r6 = r2.X
            z13 r2 = r2.A
            defpackage.n12.S(r8)
            r8 = r6
            r6 = r2
            goto L50
        L32:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r6)
            return r5
        L38:
            defpackage.n12.S(r8)
            r2.A = r6
            gb0 r8 = r6.a
            r2.X = r8
            r2.Y = r7
            r2.z0 = r4
            wn2 r3 = r8.f
            java.lang.Object r2 = r3.g(r2)
            mf0 r3 = defpackage.mf0.b
            if (r2 != r3) goto L50
            return r3
        L50:
            ae r2 = r6.c     // Catch: java.lang.Throwable -> L73
            gb0 r6 = r6.a     // Catch: java.lang.Throwable -> L73
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> L73
            if (r3 != 0) goto Lb0
            java.lang.Object r3 = defpackage.d70.p0(r2)     // Catch: java.lang.Throwable -> L73
            u13 r3 = (defpackage.u13) r3     // Catch: java.lang.Throwable -> L73
            r4 = 39
            if (r7 == 0) goto L8a
            r3.getClass()     // Catch: java.lang.Throwable -> L73
            boolean r7 = r2.isEmpty()     // Catch: java.lang.Throwable -> L73
            if (r7 == 0) goto L75
            java.lang.String r7 = "END TRANSACTION"
            defpackage.ez4.t(r6, r7)     // Catch: java.lang.Throwable -> L73
            goto Laa
        L73:
            r6 = move-exception
            goto Lb8
        L75:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r7.<init>(r1)     // Catch: java.lang.Throwable -> L73
            int r0 = r3.a     // Catch: java.lang.Throwable -> L73
            r7.append(r0)     // Catch: java.lang.Throwable -> L73
            r7.append(r4)     // Catch: java.lang.Throwable -> L73
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L73
            defpackage.ez4.t(r6, r7)     // Catch: java.lang.Throwable -> L73
            goto Laa
        L8a:
            boolean r7 = r2.isEmpty()     // Catch: java.lang.Throwable -> L73
            if (r7 == 0) goto L96
            java.lang.String r7 = "ROLLBACK TRANSACTION"
            defpackage.ez4.t(r6, r7)     // Catch: java.lang.Throwable -> L73
            goto Laa
        L96:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L73
            int r0 = r3.a     // Catch: java.lang.Throwable -> L73
            r7.append(r0)     // Catch: java.lang.Throwable -> L73
            r7.append(r4)     // Catch: java.lang.Throwable -> L73
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L73
            defpackage.ez4.t(r6, r7)     // Catch: java.lang.Throwable -> L73
        Laa:
            xl4 r6 = defpackage.xl4.a     // Catch: java.lang.Throwable -> L73
            r8.n(r5)
            return r6
        Lb0:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L73
            java.lang.String r7 = "Not in a transaction"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L73
            throw r6     // Catch: java.lang.Throwable -> L73
        Lb8:
            r8.n(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z13.f(boolean, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(defpackage.ig4 r11, kotlin.jvm.functions.Function2 r12, defpackage.ie0 r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof defpackage.x13
            if (r0 == 0) goto L13
            r0 = r13
            x13 r0 = (defpackage.x13) r0
            int r1 = r0.z0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.z0 = r1
            goto L18
        L13:
            x13 r0 = new x13
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.Z
            int r1 = r0.z0
            r2 = 0
            r3 = 0
            r4 = 5
            r5 = 3
            r6 = 2
            r7 = 1
            mf0 r8 = defpackage.mf0.b
            if (r1 == 0) goto L69
            if (r1 == r7) goto L5c
            if (r1 == r6) goto L4d
            if (r1 == r5) goto L47
            r10 = 4
            if (r1 == r10) goto L47
            if (r1 == r4) goto L37
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r10)
            return r2
        L37:
            java.io.Serializable r10 = r0.X
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.Object r11 = r0.A
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            defpackage.n12.S(r13)     // Catch: android.database.SQLException -> L44
            goto Lc0
        L44:
            r12 = move-exception
            goto Lbb
        L47:
            java.lang.Object r10 = r0.A
            defpackage.n12.S(r13)
            return r10
        L4d:
            int r10 = r0.Y
            java.lang.Object r11 = r0.A
            z13 r11 = (defpackage.z13) r11
            defpackage.n12.S(r13)     // Catch: java.lang.Throwable -> L57
            goto L96
        L57:
            r10 = move-exception
            r9 = r11
            r11 = r10
            r10 = r9
            goto La6
        L5c:
            java.io.Serializable r10 = r0.X
            r12 = r10
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            java.lang.Object r10 = r0.A
            z13 r10 = (defpackage.z13) r10
            defpackage.n12.S(r13)
            goto L80
        L69:
            defpackage.n12.S(r13)
            if (r11 != 0) goto L70
            ig4 r11 = defpackage.ig4.b
        L70:
            r0.A = r10
            r13 = r12
            java.io.Serializable r13 = (java.io.Serializable) r13
            r0.X = r13
            r0.z0 = r7
            java.lang.Object r11 = r10.e(r11, r0)
            if (r11 != r8) goto L80
            goto Lb4
        L80:
            t13 r11 = new t13     // Catch: java.lang.Throwable -> La5
            r11.<init>(r3, r10)     // Catch: java.lang.Throwable -> La5
            r0.A = r10     // Catch: java.lang.Throwable -> La5
            r0.X = r2     // Catch: java.lang.Throwable -> La5
            r0.Y = r7     // Catch: java.lang.Throwable -> La5
            r0.z0 = r6     // Catch: java.lang.Throwable -> La5
            java.lang.Object r13 = r12.k(r11, r0)     // Catch: java.lang.Throwable -> La5
            if (r13 != r8) goto L94
            goto Lb4
        L94:
            r11 = r10
            r10 = r7
        L96:
            if (r10 == 0) goto L99
            r3 = r7
        L99:
            r0.A = r13
            r0.z0 = r5
            java.lang.Object r10 = r11.f(r3, r0)
            if (r10 != r8) goto La4
            goto Lb4
        La4:
            return r13
        La5:
            r11 = move-exception
        La6:
            throw r11     // Catch: java.lang.Throwable -> La7
        La7:
            r12 = move-exception
            r0.A = r11     // Catch: android.database.SQLException -> Lb7
            r0.X = r12     // Catch: android.database.SQLException -> Lb7
            r0.z0 = r4     // Catch: android.database.SQLException -> Lb7
            java.lang.Object r10 = r10.f(r3, r0)     // Catch: android.database.SQLException -> Lb7
            if (r10 != r8) goto Lb5
        Lb4:
            return r8
        Lb5:
            r10 = r12
            goto Lc0
        Lb7:
            r10 = move-exception
            r9 = r12
            r12 = r10
            r10 = r9
        Lbb:
            if (r11 == 0) goto Lc1
            defpackage.ek0.b(r11, r12)
        Lc0:
            throw r10
        Lc1:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z13.g(ig4, kotlin.jvm.functions.Function2, ie0):java.lang.Object");
    }
}
