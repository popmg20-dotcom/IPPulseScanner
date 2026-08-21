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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.ag1 r17, defpackage.ge0 r18) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m24.a(ag1, ge0):java.lang.Object");
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
