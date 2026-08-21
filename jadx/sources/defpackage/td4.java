package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class td4 {
    public static final /* synthetic */ long b = re.a.objectFieldOffset(td4.class.getDeclaredField("_size$volatile"));
    private volatile /* synthetic */ int _size$volatile;
    public e61[] a;

    public final void a(e61 e61Var) {
        e61Var.e((f61) this);
        e61[] e61VarArr = this.a;
        if (e61VarArr == null) {
            e61VarArr = new e61[4];
            this.a = e61VarArr;
        } else if (b() >= e61VarArr.length) {
            e61VarArr = (e61[]) Arrays.copyOf(e61VarArr, b() * 2);
            this.a = e61VarArr;
        }
        int iB = b();
        re.a.putIntVolatile(this, b, iB + 1);
        e61VarArr[iB] = e61Var;
        e61Var.f = iB;
        e(iB);
    }

    public final int b() {
        return re.a.getIntVolatile(this, b);
    }

    public final void c(e61 e61Var) {
        synchronized (this) {
            if (e61Var.b() != null) {
                d(e61Var.f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.e61 d(int r8) {
        /*
            r7 = this;
            e61[] r0 = r7.a
            r0.getClass()
            int r1 = r7.b()
            r2 = -1
            int r1 = r1 + r2
            sun.misc.Unsafe r3 = defpackage.re.a
            long r4 = defpackage.td4.b
            r3.putIntVolatile(r7, r4, r1)
            int r1 = r7.b()
            if (r8 >= r1) goto L7c
            int r1 = r7.b()
            r7.f(r8, r1)
            int r1 = r8 + (-1)
            int r1 = r1 / 2
            if (r8 <= 0) goto L3c
            r3 = r0[r8]
            r3.getClass()
            r4 = r0[r1]
            r4.getClass()
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3c
            r7.f(r8, r1)
            r7.e(r1)
            goto L7c
        L3c:
            int r1 = r8 * 2
            int r3 = r1 + 1
            int r4 = r7.b()
            if (r3 < r4) goto L47
            goto L7c
        L47:
            e61[] r4 = r7.a
            r4.getClass()
            int r1 = r1 + 2
            int r5 = r7.b()
            if (r1 >= r5) goto L65
            r5 = r4[r1]
            r5.getClass()
            r6 = r4[r3]
            r6.getClass()
            int r5 = r5.compareTo(r6)
            if (r5 >= 0) goto L65
            goto L66
        L65:
            r1 = r3
        L66:
            r3 = r4[r8]
            r3.getClass()
            r4 = r4[r1]
            r4.getClass()
            int r3 = r3.compareTo(r4)
            if (r3 > 0) goto L77
            goto L7c
        L77:
            r7.f(r8, r1)
            r8 = r1
            goto L3c
        L7c:
            int r8 = r7.b()
            r8 = r0[r8]
            r8.getClass()
            r1 = 0
            r8.e(r1)
            r8.f = r2
            int r7 = r7.b()
            r0[r7] = r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.td4.d(int):e61");
    }

    public final void e(int i) {
        while (i > 0) {
            e61[] e61VarArr = this.a;
            e61VarArr.getClass();
            int i2 = (i - 1) / 2;
            e61 e61Var = e61VarArr[i2];
            e61Var.getClass();
            e61 e61Var2 = e61VarArr[i];
            e61Var2.getClass();
            if (e61Var.compareTo(e61Var2) <= 0) {
                return;
            }
            f(i, i2);
            i = i2;
        }
    }

    public final void f(int i, int i2) {
        e61[] e61VarArr = this.a;
        e61VarArr.getClass();
        e61 e61Var = e61VarArr[i2];
        e61Var.getClass();
        e61 e61Var2 = e61VarArr[i];
        e61Var2.getClass();
        e61VarArr[i] = e61Var;
        e61VarArr[i2] = e61Var2;
        e61Var.f = i;
        e61Var2.f = i2;
    }
}
