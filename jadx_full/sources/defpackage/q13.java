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
    */
    public final Object a(ie0 ie0Var) {
        o13 o13Var;
        if (ie0Var instanceof o13) {
            o13Var = (o13) ie0Var;
            int i = o13Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                o13Var.Z = i - Integer.MIN_VALUE;
            } else {
                o13Var = new o13(this, ie0Var);
            }
        }
        Object obj = o13Var.X;
        int i2 = o13Var.Z;
        if (i2 == 0) {
            n12.S(obj);
            o13Var.A = this;
            o13Var.Z = 1;
            Object objA = this.g.a(o13Var);
            mf0 mf0Var = mf0.b;
            if (objA == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            this = o13Var.A;
            n12.S(obj);
        }
        try {
            ReentrantLock reentrantLock = this.c;
            r02 r02Var = this.h;
            reentrantLock.lock();
            try {
                if (this.e) {
                    ez4.Y(21, "Connection pool is closed");
                    throw null;
                }
                if (r02Var.a == r02Var.b && this.d < this.a) {
                    gb0 gb0Var = new gb0((go3) this.b.a());
                    gb0[] gb0VarArr = this.f;
                    int i3 = this.d;
                    this.d = i3 + 1;
                    gb0VarArr[i3] = gb0Var;
                    r02Var.a(gb0Var);
                }
                int i4 = r02Var.a;
                if (i4 == r02Var.b) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                Object[] objArr = (Object[]) r02Var.d;
                Object obj2 = objArr[i4];
                objArr[i4] = null;
                r02Var.a = (i4 + 1) & r02Var.c;
                return (gb0) obj2;
            } finally {
                reentrantLock.unlock();
            }
        } catch (Throwable th) {
            this.g.c();
            throw th;
        }
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
    */
    public final Object b(long j, xa0 xa0Var, ie0 ie0Var) {
        p13 p13Var;
        pl1 pl1Var;
        bh3 bh3Var;
        p13 p13Var2;
        Throwable th;
        pl1 pl1Var2;
        Object objY;
        mf0 mf0Var;
        pl1 pl1Var3;
        if (ie0Var instanceof p13) {
            p13Var = (p13) ie0Var;
            int i = p13Var.A0;
            if ((i & Integer.MIN_VALUE) != 0) {
                p13Var.A0 = i - Integer.MIN_VALUE;
            } else {
                p13Var = new p13(this, ie0Var);
            }
        }
        Object obj = p13Var.y0;
        int i2 = p13Var.A0;
        ge0 ge0Var = null;
        if (i2 == 0) {
            n12.S(obj);
            pl1Var = xa0Var;
            bh3 bh3Var2 = new bh3();
            uf ufVar = new uf(bh3Var2, this, ge0Var, 17);
            p13Var.A = this;
            p13Var.X = pl1Var;
            p13Var.Y = bh3Var2;
            p13Var.Z = j;
            p13Var.A0 = 1;
            objY = r25.Y(j, ufVar, p13Var);
            mf0Var = mf0.b;
            if (objY != mf0Var) {
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            long j2 = p13Var.Z;
            bh3 bh3Var3 = p13Var.Y;
            pl1 pl1Var4 = p13Var.X;
            q13 q13Var = p13Var.A;
            try {
                try {
                    n12.S(obj);
                    pl1Var3 = pl1Var4;
                } catch (Throwable th2) {
                    bh3Var = bh3Var3;
                    j = j2;
                    this = q13Var;
                    p13Var2 = p13Var;
                    th = th2;
                    pl1Var2 = pl1Var4;
                    if (th instanceof ee4) {
                    }
                    pl1Var = pl1Var2;
                    p13Var = p13Var2;
                    bh3 bh3Var22 = new bh3();
                    uf ufVar2 = new uf(bh3Var22, this, ge0Var, 17);
                    p13Var.A = this;
                    p13Var.X = pl1Var;
                    p13Var.Y = bh3Var22;
                    p13Var.Z = j;
                    p13Var.A0 = 1;
                    objY = r25.Y(j, ufVar2, p13Var);
                    mf0Var = mf0.b;
                    if (objY != mf0Var) {
                    }
                }
                if (th instanceof ee4) {
                    pl1Var2.a();
                } else {
                    if (th != null) {
                        throw th;
                    }
                    Object obj2 = bh3Var.b;
                    if (obj2 != null) {
                        return obj2;
                    }
                }
                pl1Var = pl1Var2;
                p13Var = p13Var2;
                bh3 bh3Var222 = new bh3();
                uf ufVar22 = new uf(bh3Var222, this, ge0Var, 17);
                p13Var.A = this;
                p13Var.X = pl1Var;
                p13Var.Y = bh3Var222;
                p13Var.Z = j;
                p13Var.A0 = 1;
                objY = r25.Y(j, ufVar22, p13Var);
                mf0Var = mf0.b;
                if (objY != mf0Var) {
                    return mf0Var;
                }
                q13Var = this;
                j2 = j;
                bh3Var3 = bh3Var222;
                pl1Var3 = pl1Var;
                pl1Var2 = pl1Var3;
                bh3Var = bh3Var3;
                j = j2;
                this = q13Var;
                p13Var2 = p13Var;
                th = null;
                if (th instanceof ee4) {
                }
                pl1Var = pl1Var2;
                p13Var = p13Var2;
                bh3 bh3Var2222 = new bh3();
                uf ufVar222 = new uf(bh3Var2222, this, ge0Var, 17);
                p13Var.A = this;
                p13Var.X = pl1Var;
                p13Var.Y = bh3Var2222;
                p13Var.Z = j;
                p13Var.A0 = 1;
                objY = r25.Y(j, ufVar222, p13Var);
                mf0Var = mf0.b;
                if (objY != mf0Var) {
                }
            } catch (Throwable th3) {
                gb0 gb0Var = (gb0) bh3Var.b;
                if (gb0Var != null) {
                    this.e(gb0Var);
                }
                throw th3;
            }
            pl1Var2 = pl1Var3;
            bh3Var = bh3Var3;
            j = j2;
            this = q13Var;
            p13Var2 = p13Var;
            th = null;
        }
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
