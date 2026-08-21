package defpackage;

import java.util.ArrayList;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b30 implements nm1 {
    public final cf0 b;
    public final int f;
    public final jp z;

    public b30(cf0 cf0Var, int i, jp jpVar) {
        this.b = cf0Var;
        this.f = i;
        this.z = jpVar;
    }

    @Override // defpackage.zf1
    public Object a(ag1 ag1Var, ge0 ge0Var) {
        Object objH = p95.h(new uf(ag1Var, this, null, 3), ge0Var);
        return objH == mf0.b ? objH : xl4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // defpackage.nm1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.zf1 b(defpackage.cf0 r5, int r6, defpackage.jp r7) {
        /*
            r4 = this;
            cf0 r0 = r4.b
            cf0 r5 = r5.X(r0)
            jp r1 = defpackage.jp.b
            jp r2 = r4.z
            int r3 = r4.f
            if (r7 == r1) goto Lf
            goto L26
        Lf:
            r7 = -3
            if (r3 != r7) goto L13
            goto L25
        L13:
            if (r6 != r7) goto L17
        L15:
            r6 = r3
            goto L25
        L17:
            r7 = -2
            if (r3 != r7) goto L1b
            goto L25
        L1b:
            if (r6 != r7) goto L1e
            goto L15
        L1e:
            int r6 = r6 + r3
            if (r6 < 0) goto L22
            goto L25
        L22:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L25:
            r7 = r2
        L26:
            boolean r0 = defpackage.n12.c(r5, r0)
            if (r0 == 0) goto L31
            if (r6 != r3) goto L31
            if (r7 != r2) goto L31
            return r4
        L31:
            b30 r4 = r4.e(r5, r6, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b30.b(cf0, int, jp):zf1");
    }

    public String c() {
        return null;
    }

    public abstract Object d(q53 q53Var, ge0 ge0Var);

    public abstract b30 e(cf0 cf0Var, int i, jp jpVar);

    public zf1 f() {
        return null;
    }

    public y20 g(lf0 lf0Var) {
        int i = this.f;
        if (i == -3) {
            i = -2;
        }
        Function2 hjVar = new hj(this, null, 5);
        q53 q53Var = new q53(co4.I(lf0Var, this.b), uf2.a(i, this.z, null, 4));
        q53Var.l0(of0.z, q53Var, hjVar);
        return q53Var;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strC = c();
        if (strC != null) {
            arrayList.add(strC);
        }
        c41 c41Var = c41.b;
        cf0 cf0Var = this.b;
        if (cf0Var != c41Var) {
            arrayList.add("context=" + cf0Var);
        }
        int i = this.f;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        jp jpVar = jp.b;
        jp jpVar2 = this.z;
        if (jpVar2 != jpVar) {
            arrayList.add("onBufferOverflow=" + jpVar2);
        }
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append('[');
        return fw.x(sb, d70.j0(arrayList, ", ", null, null, null, 62), ']');
    }
}
