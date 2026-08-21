package defpackage;

import java.util.concurrent.atomic.AtomicReference;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class m24 extends a2 implements zf1, nm1, k24, tn2 {
    public static final /* synthetic */ long Y = re.a.objectFieldOffset(m24.class.getDeclaredField("_state$volatile"));
    public int X;
    private volatile /* synthetic */ Object _state$volatile;

    public m24(Object obj) {
        this._state$volatile = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0096, code lost:
    
        if (r11 != r5) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0041: MOVE (r1 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:66), block:B:17:0x0041 */
    /* JADX WARN: Path cross not found for [B:67:0x0117, B:68:0x0118], limit reached: 77 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098 A[Catch: all -> 0x0063, TryCatch #1 {all -> 0x0063, blocks: (B:36:0x0098, B:38:0x00a2, B:41:0x00a9, B:42:0x00ad, B:44:0x00b0, B:55:0x00d5, B:58:0x00e5, B:59:0x0101, B:65:0x0111, B:62:0x0108, B:64:0x010e, B:46:0x00b6, B:50:0x00bd, B:70:0x011b, B:71:0x0120, B:24:0x005f, B:34:0x0087, B:29:0x0070, B:31:0x0074), top: B:75:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5 A[Catch: all -> 0x0063, TryCatch #1 {all -> 0x0063, blocks: (B:36:0x0098, B:38:0x00a2, B:41:0x00a9, B:42:0x00ad, B:44:0x00b0, B:55:0x00d5, B:58:0x00e5, B:59:0x0101, B:65:0x0111, B:62:0x0108, B:64:0x010e, B:46:0x00b6, B:50:0x00bd, B:70:0x011b, B:71:0x0120, B:24:0x005f, B:34:0x0087, B:29:0x0070, B:31:0x0074), top: B:75:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011b A[Catch: all -> 0x0063, TryCatch #1 {all -> 0x0063, blocks: (B:36:0x0098, B:38:0x00a2, B:41:0x00a9, B:42:0x00ad, B:44:0x00b0, B:55:0x00d5, B:58:0x00e5, B:59:0x0101, B:65:0x0111, B:62:0x0108, B:64:0x010e, B:46:0x00b6, B:50:0x00bd, B:70:0x011b, B:71:0x0120, B:24:0x005f, B:34:0x0087, B:29:0x0070, B:31:0x0074), top: B:75:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r1v0, types: [a2, m24] */
    /* JADX WARN: Type inference failed for: r1v1, types: [a2] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [m24] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, m24] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r4v0, types: [b2, int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00e4 -> B:35:0x0096). Please report as a decompilation issue!!! */
    @Override // defpackage.zf1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ag1 ag1Var, ge0 ge0Var) {
        l24 l24Var;
        o24 o24Var;
        ?? r11;
        ag1 ag1Var2;
        v32 v32Var;
        Object obj;
        v32 v32Var2;
        ?? r1;
        Object andSet;
        Object obj2;
        ?? r12 = this;
        ag1 ag1Var3 = ag1Var;
        if (ge0Var instanceof l24) {
            l24Var = (l24) ge0Var;
            int i = l24Var.B0;
            if ((i & Integer.MIN_VALUE) != 0) {
                l24Var.B0 = i - Integer.MIN_VALUE;
            } else {
                l24Var = new l24(r12, ge0Var);
            }
        }
        Object obj3 = l24Var.z0;
        ?? r4 = l24Var.B0;
        mf0 mf0Var = mf0.b;
        try {
            if (r4 == 0) {
                n12.S(obj3);
                o24Var = (o24) r12.c();
                r1 = r12;
                if (ag1Var3 instanceof d54) {
                    l24Var.A = r12;
                    l24Var.X = ag1Var3;
                    l24Var.Y = o24Var;
                    l24Var.B0 = 1;
                    r1 = r12;
                    if (((d54) ag1Var3).a(l24Var) == mf0Var) {
                        return mf0Var;
                    }
                }
            } else if (r4 != 1) {
                try {
                    if (r4 == 2) {
                        obj = l24Var.y0;
                        v32Var = l24Var.Z;
                        o24Var = l24Var.Y;
                        ag1Var2 = l24Var.X;
                        m24 m24Var = l24Var.A;
                        n12.S(obj3);
                        r11 = m24Var;
                        v32Var2 = v32Var;
                        r1 = r11;
                        AtomicReference atomicReference = o24Var.a;
                        br1 br1Var = n24.a;
                        andSet = atomicReference.getAndSet(br1Var);
                        andSet.getClass();
                        if (andSet != n24.b) {
                        }
                        if (r1 != 0) {
                        }
                    } else {
                        if (r4 != 3) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        obj = l24Var.y0;
                        v32 v32Var3 = l24Var.Z;
                        o24Var = l24Var.Y;
                        ag1Var2 = l24Var.X;
                        m24 m24Var2 = l24Var.A;
                        n12.S(obj3);
                        v32Var2 = v32Var3;
                        r1 = m24Var2;
                        if (r1 != 0) {
                            Object objectVolatile = re.a.getObjectVolatile((Object) r1, Y);
                            if (v32Var2 != null && !v32Var2.isActive()) {
                                throw v32Var2.F();
                            }
                            if (obj != null) {
                                r1 = r1;
                                if (obj.equals(objectVolatile)) {
                                    AtomicReference atomicReference2 = o24Var.a;
                                    br1 br1Var2 = n24.a;
                                    andSet = atomicReference2.getAndSet(br1Var2);
                                    andSet.getClass();
                                    if (andSet != n24.b) {
                                        l24Var.A = r1;
                                        l24Var.X = ag1Var2;
                                        l24Var.Y = o24Var;
                                        l24Var.Z = v32Var2;
                                        l24Var.y0 = obj;
                                        l24Var.B0 = 3;
                                        xl4 xl4Var = xl4.a;
                                        z00 z00Var = new z00(1, p95.u(l24Var));
                                        z00Var.w();
                                        AtomicReference atomicReference3 = o24Var.a;
                                        while (true) {
                                            if (atomicReference3.compareAndSet(br1Var2, z00Var)) {
                                                break;
                                            }
                                            if (atomicReference3.get() != br1Var2) {
                                                z00Var.d(xl4Var);
                                                break;
                                            }
                                        }
                                        Object objU = z00Var.u();
                                        if (objU == mf0Var) {
                                        }
                                        if (objU != mf0Var) {
                                        }
                                    }
                                    if (r1 != 0) {
                                        throw new ClassCastException();
                                    }
                                }
                                return mf0Var;
                            }
                            Object obj4 = objectVolatile == at2.a ? null : objectVolatile;
                            l24Var.A = r1;
                            l24Var.X = ag1Var2;
                            l24Var.Y = o24Var;
                            l24Var.Z = v32Var2;
                            l24Var.y0 = objectVolatile;
                            l24Var.B0 = 2;
                            if (ag1Var2.h(obj4, l24Var) == mf0Var) {
                                return mf0Var;
                            }
                            obj = objectVolatile;
                            r11 = r1;
                            v32Var = v32Var2;
                            v32Var2 = v32Var;
                            r1 = r11;
                            AtomicReference atomicReference22 = o24Var.a;
                            br1 br1Var22 = n24.a;
                            andSet = atomicReference22.getAndSet(br1Var22);
                            andSet.getClass();
                            if (andSet != n24.b) {
                            }
                            if (r1 != 0) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r12 = obj2;
                    r12.f(r4);
                    throw th;
                }
            } else {
                o24Var = l24Var.Y;
                ag1Var3 = l24Var.X;
                m24 m24Var3 = l24Var.A;
                n12.S(obj3);
                r1 = m24Var3;
            }
            cf0 cf0Var = l24Var.f;
            cf0Var.getClass();
            v32Var2 = (v32) cf0Var.Z(pr1.X);
            ag1Var2 = ag1Var3;
            obj = null;
            if (r1 != 0) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // defpackage.nm1
    public final zf1 b(cf0 cf0Var, int i, jp jpVar) {
        return (((i < 0 || i >= 2) && i != -2) || jpVar != jp.f) ? iv3.c(this, cf0Var, i, jpVar) : this;
    }

    @Override // defpackage.a2
    public final b2 d() {
        return new o24();
    }

    @Override // defpackage.a2
    public final b2[] e() {
        return new o24[2];
    }

    public final boolean g(Object obj, Object obj2) {
        br1 br1Var = at2.a;
        if (obj == null) {
            obj = br1Var;
        }
        if (obj2 == null) {
            obj2 = br1Var;
        }
        return j(obj, obj2);
    }

    @Override // defpackage.ag1
    public final Object h(Object obj, ge0 ge0Var) {
        if (obj == null) {
            obj = at2.a;
        }
        j(null, obj);
        return xl4.a;
    }

    public final Object i() {
        Object objectVolatile = re.a.getObjectVolatile(this, Y);
        if (objectVolatile == at2.a) {
            return null;
        }
        return objectVolatile;
    }

    public final boolean j(Object obj, Object obj2) {
        int i;
        b2[] b2VarArr;
        br1 br1Var;
        synchronized (this) {
            Unsafe unsafe = re.a;
            long j = Y;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            if (obj != null && !n12.c(objectVolatile, obj)) {
                return false;
            }
            if (n12.c(objectVolatile, obj2)) {
                return true;
            }
            unsafe.putObjectVolatile(this, j, obj2);
            int i2 = this.X;
            if ((i2 & 1) != 0) {
                this.X = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.X = i3;
            b2[] b2VarArr2 = this.b;
            while (true) {
                o24[] o24VarArr = (o24[]) b2VarArr2;
                if (o24VarArr != null) {
                    for (o24 o24Var : o24VarArr) {
                        if (o24Var != null) {
                            AtomicReference atomicReference = o24Var.a;
                            while (true) {
                                Object obj3 = atomicReference.get();
                                if (obj3 != null && obj3 != (br1Var = n24.b)) {
                                    br1 br1Var2 = n24.a;
                                    if (obj3 != br1Var2) {
                                        while (!atomicReference.compareAndSet(obj3, br1Var2)) {
                                            if (atomicReference.get() != obj3) {
                                                break;
                                            }
                                        }
                                        ((z00) obj3).d(xl4.a);
                                        break;
                                    }
                                    while (!atomicReference.compareAndSet(obj3, br1Var)) {
                                        if (atomicReference.get() != obj3) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i = this.X;
                    if (i == i3) {
                        this.X = i3 + 1;
                        return true;
                    }
                    b2VarArr = this.b;
                }
                b2VarArr2 = b2VarArr;
                i3 = i;
            }
        }
    }
}
