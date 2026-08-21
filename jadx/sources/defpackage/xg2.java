package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xg2 extends hi4 {
    public final /* synthetic */ int a = 0;
    public final Object b;
    public final hi4 c;
    public final Object d;

    public xg2(c70 c70Var, xg2 xg2Var, xg2 xg2Var2, st2 st2Var) {
        this.b = xg2Var;
        this.c = xg2Var2;
        this.d = st2Var;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        switch (this.a) {
            case 0:
                int iX = r62Var.X();
                if (iX == 9) {
                    r62Var.N();
                    return null;
                }
                Map map = (Map) ((st2) this.d).a();
                if (iX == 1) {
                    r62Var.B0();
                    while (r62Var.hasNext()) {
                        r62Var.B0();
                        Object objB = ((xg2) this.b).c.b(r62Var);
                        if (map.put(objB, ((xg2) this.c).c.b(r62Var)) != null) {
                            throw new l52("duplicate key: " + objB);
                        }
                        r62Var.w0();
                    }
                    r62Var.w0();
                } else {
                    r62Var.p0();
                    while (r62Var.hasNext()) {
                        vd3.z0.getClass();
                        int iN = r62Var.Z;
                        if (iN == 0) {
                            iN = r62Var.n();
                        }
                        if (iN == 13) {
                            r62Var.Z = 9;
                        } else if (iN == 12) {
                            r62Var.Z = 8;
                        } else {
                            if (iN != 14) {
                                throw r62Var.r0("a name");
                            }
                            r62Var.Z = 10;
                        }
                        Object objB2 = ((xg2) this.b).c.b(r62Var);
                        if (map.put(objB2, ((xg2) this.c).c.b(r62Var)) != null) {
                            throw new l52("duplicate key: " + objB2);
                        }
                    }
                    r62Var.V();
                }
                return map;
            default:
                return this.c.b(r62Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    @Override // defpackage.hi4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.v72 r4, java.lang.Object r5) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.a
            hi4 r1 = r3.c
            switch(r0) {
                case 0: goto L4a;
                default: goto L7;
            }
        L7:
            java.lang.Object r0 = r3.d
            java.lang.reflect.Type r0 = (java.lang.reflect.Type) r0
            if (r5 == 0) goto L1a
            boolean r2 = r0 instanceof java.lang.Class
            if (r2 != 0) goto L15
            boolean r2 = r0 instanceof java.lang.reflect.TypeVariable
            if (r2 == 0) goto L1a
        L15:
            java.lang.Class r2 = r5.getClass()
            goto L1b
        L1a:
            r2 = r0
        L1b:
            if (r2 == r0) goto L46
            java.lang.Object r3 = r3.b
            iq1 r3 = (defpackage.iq1) r3
            bk4 r0 = new bk4
            r0.<init>(r2)
            hi4 r3 = r3.d(r0)
            boolean r0 = r3 instanceof defpackage.jh3
            if (r0 != 0) goto L2f
            goto L45
        L2f:
            r0 = r1
        L30:
            boolean r2 = r0 instanceof defpackage.ct3
            if (r2 == 0) goto L40
            r2 = r0
            ct3 r2 = (defpackage.ct3) r2
            hi4 r2 = r2.d()
            if (r2 != r0) goto L3e
            goto L40
        L3e:
            r0 = r2
            goto L30
        L40:
            boolean r0 = r0 instanceof defpackage.jh3
            if (r0 != 0) goto L45
            goto L46
        L45:
            r1 = r3
        L46:
            r1.c(r4, r5)
            return
        L4a:
            java.util.Map r5 = (java.util.Map) r5
            xg2 r1 = (defpackage.xg2) r1
            if (r5 != 0) goto L54
            r4.C()
            goto L81
        L54:
            r4.p0()
            java.util.Set r3 = r5.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L5f:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L7e
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r0 = r5.getKey()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r4.s(r0)
            java.lang.Object r5 = r5.getValue()
            r1.c(r4, r5)
            goto L5f
        L7e:
            r4.V()
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xg2.c(v72, java.lang.Object):void");
    }

    public xg2(iq1 iq1Var, hi4 hi4Var, Type type) {
        this.b = iq1Var;
        this.c = hi4Var;
        this.d = type;
    }
}
