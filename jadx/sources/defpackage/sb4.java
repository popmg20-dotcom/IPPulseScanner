package defpackage;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sb4 {
    public static final sb4 e;
    public static final sb4 f;
    public static final sb4 g;
    public final xj4 a;
    public final o91 b;
    public final boolean c;
    public boolean d = false;

    static {
        int i = xj4.b;
        xj4 xj4Var = wj4.a;
        e = new sb4(xj4Var, o91.a(), false);
        f = new sb4(xj4Var, o91.a(), true);
        sb4 sb4Var = new sb4(xj4Var, o91.a(), false);
        sb4Var.d = tb4.a;
        g = sb4Var;
        new uj0(5);
    }

    public sb4(xj4 xj4Var, o91 o91Var, boolean z) {
        this.a = xj4Var;
        this.b = o91Var;
        this.c = z;
    }

    public static sb4 a() {
        y93 y93Var = aa3.a;
        if (y93Var.get() == z93.f) {
            boolean z = tb4.a;
            return g;
        }
        if (y93Var.get() == z93.b) {
            boolean z2 = tb4.a;
            return f;
        }
        boolean z3 = tb4.a;
        return e;
    }

    public static void e(int i, int i2, List list, cb0 cb0Var, boolean z) {
        String string;
        for (Object obj : list) {
            cb0Var.f(String.valueOf(i));
            cb0Var.f(":");
            cb0Var.d();
            int i3 = i2 & 7;
            if (i3 == 0) {
                if (z) {
                    string = "UNKNOWN_VARINT [REDACTED]";
                } else {
                    long jLongValue = ((Long) obj).longValue();
                    boolean z2 = tb4.a;
                    string = jLongValue >= 0 ? Long.toString(jLongValue) : BigInteger.valueOf(jLongValue & Long.MAX_VALUE).setBit(63).toString();
                }
                cb0Var.f(string);
            } else if (i3 == 1) {
                cb0Var.f(z ? "UNKNOWN_FIXED64 [REDACTED]" : String.format(null, "0x%016x", (Long) obj));
            } else if (i3 == 2) {
                try {
                    zt ztVar = (zt) obj;
                    cm4 cm4Var = cm4.f;
                    yl4 yl4VarP = yl4.p();
                    try {
                        m60 m60VarD = m60.d(ztVar.f, ztVar.e(), ztVar.size(), true);
                        yl4VarP.v(m60VarD);
                        m60VarD.a(0);
                        cm4 cm4VarP = yl4VarP.p();
                        cb0Var.f("{");
                        cb0Var.c();
                        ((StringBuilder) cb0Var.d).append("  ");
                        f(cm4VarP, cb0Var, z);
                        cb0Var.e();
                        cb0Var.f("}");
                    } catch (s12 e2) {
                        throw e2;
                    } catch (IOException e3) {
                        throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e3);
                    }
                } catch (s12 unused) {
                    if (z) {
                        cb0Var.f("UNKNOWN_STRING [REDACTED]");
                    } else {
                        cb0Var.f("\"");
                        boolean z3 = tb4.a;
                        cb0Var.f(ek0.g(new wn1(24, (zt) obj)));
                        cb0Var.f("\"");
                    }
                }
            } else if (i3 == 3) {
                f((cm4) obj, cb0Var, z);
            } else {
                if (i3 != 5) {
                    xe.k(dw2.A(i2, "Bad tag: "));
                    return;
                }
                cb0Var.f(z ? "UNKNOWN_FIXED32 [REDACTED]" : String.format(null, "0x%08x", (Integer) obj));
            }
            cb0Var.c();
        }
    }

    public static void f(cm4 cm4Var, cb0 cb0Var, boolean z) {
        if (cm4Var.b.isEmpty()) {
            return;
        }
        TreeMap treeMap = cm4Var.b;
        for (Map.Entry entry : (treeMap.isEmpty() ? Collections.EMPTY_MAP : (Map) treeMap.clone()).entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            am4 am4Var = (am4) entry.getValue();
            e(iIntValue, 0, am4Var.a, cb0Var, z);
            e(iIntValue, 5, am4Var.b, cb0Var, z);
            e(iIntValue, 1, am4Var.c, cb0Var, z);
            e(iIntValue, 2, am4Var.d, cb0Var, z);
            for (cm4 cm4Var2 : am4Var.e) {
                cb0Var.f(((Integer) entry.getKey()).toString());
                cb0Var.d();
                cb0Var.f("{");
                cb0Var.c();
                ((StringBuilder) cb0Var.d).append("  ");
                f(cm4Var2, cb0Var, z);
                cb0Var.e();
                cb0Var.f("}");
                cb0Var.c();
            }
        }
    }

    public final void b(ql2 ql2Var, cb0 cb0Var) {
        if (ql2Var.f().A.equals("google.protobuf.Any")) {
            ws0 ws0VarF = ql2Var.f();
            ft0 ft0VarL = ws0VarF.l(1);
            ft0 ft0VarL2 = ws0VarF.l(2);
            if (ft0VarL != null && ft0VarL.r() == et0.f && ft0VarL2 != null && ft0VarL2.r() == et0.X) {
                String str = (String) ql2Var.n(ft0VarL);
                if (!str.isEmpty()) {
                    Object objN = ql2Var.n(ft0VarL2);
                    try {
                        this.a.getClass();
                        String[] strArrSplit = str.split("/");
                        if (strArrSplit.length <= 1) {
                            throw new s12("Invalid type url found: ".concat(str));
                        }
                        ws0 ws0Var = (ws0) Collections.EMPTY_MAP.get(strArrSplit[strArrSplit.length - 1]);
                        if (ws0Var != null) {
                            mz0 mz0Var = new mz0(nz0.v(ws0Var).z);
                            mz0Var.z((zt) objN, this.b);
                            cb0Var.f("[");
                            cb0Var.f(str);
                            cb0Var.f("]");
                            cb0Var.d();
                            cb0Var.f("{");
                            cb0Var.c();
                            ((StringBuilder) cb0Var.d).append("  ");
                            b(mz0Var, cb0Var);
                            cb0Var.e();
                            cb0Var.f("}");
                            cb0Var.c();
                            return;
                        }
                    } catch (s12 unused) {
                    }
                }
            }
        }
        for (Map.Entry entry : ql2Var.l().entrySet()) {
            ft0 ft0Var = (ft0) entry.getKey();
            Object value = entry.getValue();
            if (ft0Var.t()) {
                ArrayList<rb4> arrayList = new ArrayList();
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    arrayList.add(new rb4(ft0Var, it.next()));
                }
                Collections.sort(arrayList);
                for (rb4 rb4Var : arrayList) {
                    Object obj = rb4Var.f;
                    if (obj == null) {
                        obj = rb4Var.b;
                    }
                    c(ft0Var, obj, cb0Var);
                }
            } else if (ft0Var.y()) {
                Iterator it2 = ((List) value).iterator();
                while (it2.hasNext()) {
                    c(ft0Var, it2.next(), cb0Var);
                }
            } else {
                c(ft0Var, value, cb0Var);
            }
        }
        f(ql2Var.i(), cb0Var, this.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.ft0 r7, java.lang.Object r8, defpackage.cb0 r9) {
        /*
            Method dump skipped, instruction units count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sb4.c(ft0, java.lang.Object, cb0):void");
    }

    public final String d(ql2 ql2Var) {
        try {
            StringBuilder sb = new StringBuilder();
            if (this.c) {
                try {
                    sb.append((CharSequence) "");
                } catch (IOException e2) {
                    throw new IllegalStateException(e2);
                }
            }
            ql2Var.f();
            b(ql2Var, new cb0(sb, this.d));
            return sb.toString();
        } catch (IOException e3) {
            zo2.q(e3);
            return null;
        }
    }
}
