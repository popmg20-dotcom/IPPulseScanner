package defpackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class au2 extends hi4 {
    public static final zt2 c = new zt2(1);
    public final iq1 a;
    public final int b;

    public au2(iq1 iq1Var, int i) {
        this.a = iq1Var;
        this.b = i;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        Object arrayList;
        Serializable arrayList2;
        int iX = r62Var.X();
        int iG = fw.G(iX);
        if (iG == 0) {
            r62Var.B0();
            arrayList = new ArrayList();
        } else if (iG != 2) {
            arrayList = null;
        } else {
            r62Var.p0();
            arrayList = new pb2(true);
        }
        if (arrayList == null) {
            return d(iX, r62Var);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (r62Var.hasNext()) {
                String strR = arrayList instanceof Map ? r62Var.R() : null;
                int iX2 = r62Var.X();
                int iG2 = fw.G(iX2);
                if (iG2 == 0) {
                    r62Var.B0();
                    arrayList2 = new ArrayList();
                } else if (iG2 != 2) {
                    arrayList2 = null;
                } else {
                    r62Var.p0();
                    arrayList2 = new pb2(true);
                }
                boolean z = arrayList2 != null;
                if (arrayList2 == null) {
                    arrayList2 = d(iX2, r62Var);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(strR, arrayList2);
                }
                if (z) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    r62Var.w0();
                } else {
                    r62Var.V();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        if (obj == null) {
            v72Var.C();
            return;
        }
        Class<?> cls = obj.getClass();
        iq1 iq1Var = this.a;
        iq1Var.getClass();
        hi4 hi4VarD = iq1Var.d(new bk4(cls));
        if (!(hi4VarD instanceof au2)) {
            hi4VarD.c(v72Var, obj);
        } else {
            v72Var.p0();
            v72Var.V();
        }
    }

    public final Serializable d(int i, r62 r62Var) {
        int iG = fw.G(i);
        if (iG == 5) {
            return r62Var.q();
        }
        if (iG == 6) {
            return dw2.t(this.b, r62Var);
        }
        if (iG == 7) {
            return Boolean.valueOf(r62Var.I());
        }
        if (iG == 8) {
            r62Var.N();
            return null;
        }
        xe.q("Unexpected token: ".concat(ha0.B(i)));
        return null;
    }
}
