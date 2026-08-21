package defpackage;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sz1 extends l34 implements ee0 {
    public static final sz1 X = new sz1(0);
    public static final sz1 Y = new sz1(1);
    public final /* synthetic */ int A;
    public final Boolean z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sz1(int i) {
        this(List.class);
        this.A = i;
        switch (i) {
            case 1:
                this(Collection.class);
                break;
            default:
                break;
        }
    }

    public static void o(List list, i52 i52Var, gt3 gt3Var, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                String str = (String) list.get(i2);
                if (str == null) {
                    gt3Var.h(i52Var);
                } else {
                    i52Var.G0(str);
                }
            } catch (Exception e) {
                l34.m(gt3Var, e, list, i2);
                throw null;
            }
        }
    }

    public static void p(Collection collection, i52 i52Var, gt3 gt3Var) throws IOException {
        int i = 0;
        try {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null) {
                    gt3Var.h(i52Var);
                } else {
                    i52Var.G0(str);
                }
                i++;
            }
        } catch (Exception e) {
            l34.m(gt3Var, e, collection, i);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.b72 a(defpackage.gt3 r6, defpackage.nm r7) {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L1a
            bt3 r1 = r6.b
            cu2 r1 = r1.d()
            c9 r2 = r7.a()
            if (r2 == 0) goto L1a
            java.lang.Object r1 = r1.c(r2)
            if (r1 == 0) goto L1a
            b72 r1 = r6.D(r2, r1)
            goto L1b
        L1a:
            r1 = r0
        L1b:
            java.lang.Class r2 = r5.b
            e52 r2 = defpackage.l34.k(r6, r7, r2)
            if (r2 == 0) goto L2a
            b52 r3 = defpackage.b52.b
            java.lang.Boolean r2 = r2.b(r3)
            goto L2b
        L2a:
            r2 = r0
        L2b:
            b72 r1 = defpackage.l34.j(r6, r7, r1)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r1 != 0) goto L37
            b72 r1 = r6.j(r3, r7)
        L37:
            boolean r7 = defpackage.n50.q(r1)
            r4 = 1
            if (r7 == 0) goto L59
            java.lang.Boolean r6 = r5.z
            boolean r6 = j$.util.Objects.equals(r2, r6)
            if (r6 == 0) goto L47
            return r5
        L47:
            int r6 = r5.A
            switch(r6) {
                case 0: goto L52;
                default: goto L4c;
            }
        L4c:
            sz1 r6 = new sz1
            r6.<init>(r5, r2, r4)
            goto L58
        L52:
            sz1 r6 = new sz1
            r7 = 0
            r6.<init>(r5, r2, r7)
        L58:
            return r6
        L59:
            x60 r5 = new x60
            rj4 r6 = r6.s()
            qj4 r7 = defpackage.rj4.A
            nj4 r6 = r6.b(r0, r3, r7)
            r5.<init>(r6, r4, r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sz1.a(gt3, nm):b72");
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((Collection) obj).isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r4 == java.lang.Boolean.TRUE) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        if (r4 == java.lang.Boolean.TRUE) goto L21;
     */
    @Override // defpackage.b72
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r5, defpackage.i52 r6, defpackage.gt3 r7) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = r4.A
            r1 = 1
            java.lang.Boolean r4 = r4.z
            switch(r0) {
                case 0: goto L2e;
                default: goto L8;
            }
        L8:
            java.util.Collection r5 = (java.util.Collection) r5
            int r0 = r5.size()
            if (r0 != r1) goto L24
            if (r4 != 0) goto L1c
            dt3 r0 = defpackage.dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            bt3 r1 = r7.b
            boolean r0 = r1.h(r0)
            if (r0 != 0) goto L20
        L1c:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            if (r4 != r0) goto L24
        L20:
            p(r5, r6, r7)
            goto L2d
        L24:
            r6.r0(r5)
            p(r5, r6, r7)
            r6.I()
        L2d:
            return
        L2e:
            java.util.List r5 = (java.util.List) r5
            int r0 = r5.size()
            if (r0 != r1) goto L4a
            if (r4 != 0) goto L42
            dt3 r2 = defpackage.dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            bt3 r3 = r7.b
            boolean r2 = r3.h(r2)
            if (r2 != 0) goto L46
        L42:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            if (r4 != r2) goto L4a
        L46:
            o(r5, r6, r7, r1)
            goto L53
        L4a:
            r6.r0(r5)
            o(r5, r6, r7, r0)
            r6.I()
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sz1.e(java.lang.Object, i52, gt3):void");
    }

    @Override // defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) throws IOException {
        switch (this.A) {
            case 0:
                List list = (List) obj;
                e10 e10VarE = zj4Var.e(i52Var, zj4Var.d(list, g72.X));
                i52Var.s(list);
                o(list, i52Var, gt3Var, list.size());
                zj4Var.f(i52Var, e10VarE);
                break;
            default:
                Collection collection = (Collection) obj;
                e10 e10VarE2 = zj4Var.e(i52Var, zj4Var.d(collection, g72.X));
                i52Var.s(collection);
                p(collection, i52Var, gt3Var);
                zj4Var.f(i52Var, e10VarE2);
                break;
        }
    }

    public sz1(Class cls) {
        super(cls, 0);
        this.z = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz1(sz1 sz1Var, Boolean bool, int i) {
        super(sz1Var);
        this.A = i;
        this.z = bool;
    }
}
