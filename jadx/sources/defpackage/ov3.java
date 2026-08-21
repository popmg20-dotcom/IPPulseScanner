package defpackage;

import android.content.Context;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ov3 {
    public final gd a;
    public final pv3 b;
    public final Context c;
    public final String d;
    public final n84 e;
    public final Set f;

    public ov3(Context context, String str, Set set, gd gdVar, pv3 pv3Var) {
        set.getClass();
        ig0 ig0Var = new ig0(6, context, str);
        this.a = gdVar;
        this.b = pv3Var;
        this.c = context;
        this.d = str;
        this.e = new n84(ig0Var);
        this.f = set == rv3.a ? null : d70.B0(set);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r5, defpackage.ie0 r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof defpackage.nv3
            if (r0 == 0) goto L13
            r0 = r6
            nv3 r0 = (defpackage.nv3) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            nv3 r0 = new nv3
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.X
            int r1 = r0.Z
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            ov3 r4 = r0.A
            defpackage.n12.S(r6)
            goto L40
        L27:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            r4 = 0
            return r4
        L2e:
            defpackage.n12.S(r6)
            r0.A = r4
            r0.Z = r2
            gd r6 = r4.a
            java.lang.Object r6 = r6.k(r5, r0)
            mf0 r5 = defpackage.mf0.b
            if (r6 != r5) goto L40
            return r5
        L40:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            if (r5 != 0) goto L4b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L4b:
            java.util.Set r5 = r4.f
            n84 r4 = r4.e
            r6 = 0
            if (r5 != 0) goto L68
            java.lang.Object r4 = r4.getValue()
            android.content.SharedPreferences r4 = (android.content.SharedPreferences) r4
            java.util.Map r4 = r4.getAll()
            r4.getClass()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L66
            goto L8b
        L66:
            r2 = r6
            goto L8b
        L68:
            java.lang.Object r4 = r4.getValue()
            android.content.SharedPreferences r4 = (android.content.SharedPreferences) r4
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L75
            goto L66
        L75:
            java.util.Iterator r5 = r5.iterator()
        L79:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L66
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r4.contains(r0)
            if (r0 == 0) goto L79
        L8b:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ov3.a(java.lang.Object, ie0):java.lang.Object");
    }
}
