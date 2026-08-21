package defpackage;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q13 {
    public final int a;
    public final pl1 b;
    public final ReentrantLock c = new ReentrantLock();
    public int d;
    public boolean e;
    public final gb0[] f;
    public final ns3 g;
    public final r02 h;

    public q13(int i, pl1 pl1Var) {
        this.a = i;
        this.b = pl1Var;
        this.f = new gb0[i];
        int i2 = os3.a;
        this.g = new ns3(i);
        r02 r02Var = new r02();
        if (i < 1) {
            xe.k("capacity must be >= 1");
            throw null;
        }
        if (i > 1073741824) {
            xe.k("capacity must be <= 2^30");
            throw null;
        }
        i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        r02Var.c = i - 1;
        r02Var.d = new Object[i];
        this.h = r02Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.ie0 r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof defpackage.o13
            if (r0 == 0) goto L13
            r0 = r8
            o13 r0 = (defpackage.o13) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            o13 r0 = new o13
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.X
            int r1 = r0.Z
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            q13 r7 = r0.A
            defpackage.n12.S(r8)
            goto L40
        L28:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r7)
            return r2
        L2e:
            defpackage.n12.S(r8)
            r0.A = r7
            r0.Z = r3
            ns3 r8 = r7.g
            java.lang.Object r8 = r8.a(r0)
            mf0 r0 = defpackage.mf0.b
            if (r8 != r0) goto L40
            return r0
        L40:
            java.util.concurrent.locks.ReentrantLock r8 = r7.c     // Catch: java.lang.Throwable -> L8c
            r02 r0 = r7.h     // Catch: java.lang.Throwable -> L8c
            r8.lock()     // Catch: java.lang.Throwable -> L8c
            boolean r1 = r7.e     // Catch: java.lang.Throwable -> L8e
            if (r1 != 0) goto L96
            int r1 = r0.a     // Catch: java.lang.Throwable -> L8e
            int r4 = r0.b     // Catch: java.lang.Throwable -> L8e
            if (r1 != r4) goto L72
            int r1 = r7.d     // Catch: java.lang.Throwable -> L8e
            int r4 = r7.a     // Catch: java.lang.Throwable -> L8e
            if (r1 < r4) goto L58
            goto L72
        L58:
            gb0 r1 = new gb0     // Catch: java.lang.Throwable -> L8e
            pl1 r4 = r7.b     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r4 = r4.a()     // Catch: java.lang.Throwable -> L8e
            go3 r4 = (defpackage.go3) r4     // Catch: java.lang.Throwable -> L8e
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L8e
            gb0[] r4 = r7.f     // Catch: java.lang.Throwable -> L8e
            int r5 = r7.d     // Catch: java.lang.Throwable -> L8e
            int r6 = r5 + 1
            r7.d = r6     // Catch: java.lang.Throwable -> L8e
            r4[r5] = r1     // Catch: java.lang.Throwable -> L8e
            r0.a(r1)     // Catch: java.lang.Throwable -> L8e
        L72:
            int r1 = r0.a     // Catch: java.lang.Throwable -> L8e
            int r4 = r0.b     // Catch: java.lang.Throwable -> L8e
            if (r1 == r4) goto L90
            java.lang.Object r4 = r0.d     // Catch: java.lang.Throwable -> L8e
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch: java.lang.Throwable -> L8e
            r5 = r4[r1]     // Catch: java.lang.Throwable -> L8e
            r4[r1] = r2     // Catch: java.lang.Throwable -> L8e
            int r1 = r1 + r3
            int r2 = r0.c     // Catch: java.lang.Throwable -> L8e
            r1 = r1 & r2
            r0.a = r1     // Catch: java.lang.Throwable -> L8e
            gb0 r5 = (defpackage.gb0) r5     // Catch: java.lang.Throwable -> L8e
            r8.unlock()     // Catch: java.lang.Throwable -> L8c
            return r5
        L8c:
            r8 = move-exception
            goto La2
        L8e:
            r0 = move-exception
            goto L9e
        L90:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException     // Catch: java.lang.Throwable -> L8e
            r0.<init>()     // Catch: java.lang.Throwable -> L8e
            throw r0     // Catch: java.lang.Throwable -> L8e
        L96:
            java.lang.String r0 = "Connection pool is closed"
            r1 = 21
            defpackage.ez4.Y(r1, r0)     // Catch: java.lang.Throwable -> L8e
            throw r2     // Catch: java.lang.Throwable -> L8e
        L9e:
            r8.unlock()     // Catch: java.lang.Throwable -> L8c
            throw r0     // Catch: java.lang.Throwable -> L8c
        La2:
            ns3 r7 = r7.g
            r7.c()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q13.a(ie0):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(2:48|12)|46|29|(1:(1:39)(2:35|(1:37)))(1:31)|38|19|44|20|21|(1:23)(11:24|25|46|29|(0)(0)|38|19|44|20|21|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
    
        r5 = r9;
        r9 = r10;
        r7 = r7;
        r6 = r6;
        r1 = r0;
        r0 = r1;
        r10 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073 A[Catch: all -> 0x0077, TryCatch #1 {all -> 0x0077, blocks: (B:29:0x006f, B:31:0x0073, B:35:0x007b, B:39:0x0083), top: B:46:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0058 -> B:25:0x005b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r7, defpackage.xa0 r9, defpackage.ie0 r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof defpackage.p13
            if (r0 == 0) goto L13
            r0 = r10
            p13 r0 = (defpackage.p13) r0
            int r1 = r0.A0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A0 = r1
            goto L18
        L13:
            p13 r0 = new p13
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.y0
            int r1 = r0.A0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L36
            if (r1 != r2) goto L30
            long r6 = r0.Z
            bh3 r8 = r0.Y
            pl1 r9 = r0.X
            q13 r1 = r0.A
            defpackage.n12.S(r10)     // Catch: java.lang.Throwable -> L2e
            goto L5b
        L2e:
            r10 = move-exception
            goto L68
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r6)
            return r3
        L36:
            defpackage.n12.S(r10)
        L39:
            bh3 r10 = new bh3
            r10.<init>()
            uf r1 = new uf     // Catch: java.lang.Throwable -> L62
            r4 = 17
            r1.<init>(r10, r6, r3, r4)     // Catch: java.lang.Throwable -> L62
            r0.A = r6     // Catch: java.lang.Throwable -> L62
            r0.X = r9     // Catch: java.lang.Throwable -> L62
            r0.Y = r10     // Catch: java.lang.Throwable -> L62
            r0.Z = r7     // Catch: java.lang.Throwable -> L62
            r0.A0 = r2     // Catch: java.lang.Throwable -> L62
            java.lang.Object r1 = defpackage.r25.Y(r7, r1, r0)     // Catch: java.lang.Throwable -> L62
            mf0 r4 = defpackage.mf0.b
            if (r1 != r4) goto L58
            return r4
        L58:
            r1 = r6
            r6 = r7
            r8 = r10
        L5b:
            r10 = r9
            r9 = r8
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r3
            goto L6f
        L62:
            r1 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r8 = r10
            r10 = r5
        L68:
            r5 = r9
            r9 = r8
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r10
            r10 = r5
        L6f:
            boolean r4 = r0 instanceof defpackage.ee4     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto L79
            r10.a()     // Catch: java.lang.Throwable -> L77
            goto L80
        L77:
            r7 = move-exception
            goto L84
        L79:
            if (r0 != 0) goto L83
            java.lang.Object r9 = r9.b     // Catch: java.lang.Throwable -> L77
            if (r9 == 0) goto L80
            return r9
        L80:
            r9 = r10
            r0 = r1
            goto L39
        L83:
            throw r0     // Catch: java.lang.Throwable -> L77
        L84:
            java.lang.Object r8 = r9.b
            gb0 r8 = (defpackage.gb0) r8
            if (r8 == 0) goto L8d
            r6.e(r8)
        L8d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q13.b(long, xa0, ie0):java.lang.Object");
    }

    public final void c() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            this.e = true;
            for (gb0 gb0Var : this.f) {
                if (gb0Var != null) {
                    gb0Var.close();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void d(StringBuilder sb) {
        r02 r02Var = this.h;
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            ub2 ub2VarI = p95.i();
            int i = (r02Var.b - r02Var.a) & r02Var.c;
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 >= 0) {
                    int i3 = r02Var.b;
                    int i4 = r02Var.a;
                    int i5 = r02Var.c;
                    if (i2 < ((i3 - i4) & i5)) {
                        Object obj = ((Object[]) r02Var.d)[(i4 + i2) & i5];
                        obj.getClass();
                        ub2VarI.add(obj);
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            ub2 ub2VarC = p95.c(ub2VarI);
            sb.append('\t' + toString() + " (");
            sb.append("capacity=" + this.a + ", ");
            sb.append("permits=" + Math.max(re.a.getIntVolatile(this.g, ms3.Y), 0) + ", ");
            sb.append("queue=(size=" + ub2VarC.a() + ")[" + d70.j0(ub2VarC, null, null, null, null, 63) + "], ");
            sb.append(")");
            sb.append('\n');
            gb0[] gb0VarArr = this.f;
            int length = gb0VarArr.length;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                gb0 gb0Var = gb0VarArr[i7];
                i6++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\t\t[");
                sb2.append(i6);
                sb2.append("] - ");
                sb2.append(gb0Var != null ? gb0Var.b.toString() : null);
                sb.append(sb2.toString());
                sb.append('\n');
                if (gb0Var != null) {
                    gb0Var.s(sb);
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void e(gb0 gb0Var) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            this.h.a(gb0Var);
            reentrantLock.unlock();
            this.g.c();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
