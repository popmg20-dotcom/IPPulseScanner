package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class c1 implements ql2, nl2 {
    public int b = 0;
    public int f = -1;

    public static Map o(List list) {
        if (list.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        c1 c1Var = (c1) it.next();
        ws0 ws0VarF = c1Var.f();
        ft0 ft0VarK = ws0VarF.k("key");
        ft0 ft0VarK2 = ws0VarF.k("value");
        Object objN = c1Var.n(ft0VarK2);
        if (objN instanceof bt0) {
            objN = Integer.valueOf(((bt0) objN).z.Z);
        }
        map.put(c1Var.n(ft0VarK), objN);
        while (it.hasNext()) {
            c1 c1Var2 = (c1) it.next();
            Object objN2 = c1Var2.n(ft0VarK2);
            if (objN2 instanceof bt0) {
                objN2 = Integer.valueOf(((bt0) objN2).z.Z);
            }
            map.put(c1Var2.n(ft0VarK), objN2);
        }
        return map;
    }

    public static int q(int i, Map map) {
        int i2;
        int iA;
        for (Map.Entry entry : map.entrySet()) {
            ft0 ft0Var = (ft0) entry.getKey();
            Object value = entry.getValue();
            int i3 = (i * 37) + ft0Var.z.Z;
            if (ft0Var.t()) {
                i2 = i3 * 53;
                iA = rg2.a(o((List) value));
            } else if (ft0Var.r() != et0.Y) {
                i2 = i3 * 53;
                iA = value.hashCode();
            } else if (ft0Var.y()) {
                int i4 = i3 * 53;
                Iterator it = ((List) value).iterator();
                int iA2 = 1;
                while (it.hasNext()) {
                    iA2 = (iA2 * 31) + ((g12) it.next()).a();
                }
                i = i4 + iA2;
            } else {
                i2 = i3 * 53;
                Charset charset = i12.a;
                iA = ((g12) value).a();
            }
            i = iA + i2;
        }
        return i;
    }

    public boolean equals(Object obj) {
        zt ztVarC;
        zt ztVarC2;
        boolean zEquals;
        zt ztVarC3;
        zt ztVarC4;
        boolean zEquals2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof c1) {
            c1 c1Var = (c1) obj;
            if (f() == c1Var.f()) {
                Map mapL = l();
                Map mapL2 = c1Var.l();
                if (mapL.size() == mapL2.size()) {
                    Iterator it = mapL.keySet().iterator();
                    loop0: while (true) {
                        if (it.hasNext()) {
                            ft0 ft0Var = (ft0) it.next();
                            if (!mapL2.containsKey(ft0Var)) {
                                break;
                            }
                            Object obj2 = mapL.get(ft0Var);
                            Object obj3 = mapL2.get(ft0Var);
                            if (ft0Var.r() != et0.X) {
                                if (!ft0Var.t()) {
                                    if (!obj2.equals(obj3)) {
                                        break;
                                    }
                                } else {
                                    if (!rg2.c(o((List) obj2), o((List) obj3))) {
                                        break;
                                    }
                                }
                            } else if (!ft0Var.y()) {
                                boolean z = obj2 instanceof byte[];
                                if (z && (obj3 instanceof byte[])) {
                                    zEquals2 = Arrays.equals((byte[]) obj2, (byte[]) obj3);
                                } else {
                                    if (z) {
                                        byte[] bArr = (byte[]) obj2;
                                        ztVarC3 = zt.c(0, bArr.length, bArr);
                                    } else {
                                        ztVarC3 = (zt) obj2;
                                    }
                                    if (obj3 instanceof byte[]) {
                                        byte[] bArr2 = (byte[]) obj3;
                                        ztVarC4 = zt.c(0, bArr2.length, bArr2);
                                    } else {
                                        ztVarC4 = (zt) obj3;
                                    }
                                    zEquals2 = ztVarC3.equals(ztVarC4);
                                }
                                if (!zEquals2) {
                                    break;
                                }
                            } else {
                                List list = (List) obj2;
                                List list2 = (List) obj3;
                                if (list.size() != list2.size()) {
                                    break;
                                }
                                for (int i = 0; i < list.size(); i++) {
                                    Object obj4 = list.get(i);
                                    Object obj5 = list2.get(i);
                                    boolean z2 = obj4 instanceof byte[];
                                    if (z2 && (obj5 instanceof byte[])) {
                                        zEquals = Arrays.equals((byte[]) obj4, (byte[]) obj5);
                                    } else {
                                        if (z2) {
                                            byte[] bArr3 = (byte[]) obj4;
                                            ztVarC = zt.c(0, bArr3.length, bArr3);
                                        } else {
                                            ztVarC = (zt) obj4;
                                        }
                                        if (obj5 instanceof byte[]) {
                                            byte[] bArr4 = (byte[]) obj5;
                                            ztVarC2 = zt.c(0, bArr4.length, bArr4);
                                        } else {
                                            ztVarC2 = (zt) obj5;
                                        }
                                        zEquals = ztVarC.equals(ztVarC2);
                                    }
                                    if (!zEquals) {
                                        break loop0;
                                    }
                                }
                            }
                        } else if (i().equals(c1Var.i())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // defpackage.nl2
    public final zt g() {
        try {
            int iH = h();
            zt ztVar = zt.z;
            byte[] bArr = new byte[iH];
            q60 q60Var = new q60(bArr, iH);
            d(q60Var);
            q60Var.a();
            return new zt(bArr);
        } catch (IOException e) {
            zo2.o(p("ByteString"), e);
            return null;
        }
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = i().hashCode() + (q(f().hashCode() + 779, l()) * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    public final byte[] j() {
        try {
            int iH = h();
            byte[] bArr = new byte[iH];
            q60 q60Var = new q60(bArr, iH);
            d(q60Var);
            q60Var.a();
            return bArr;
        } catch (IOException e) {
            zo2.o(p("byte array"), e);
            return null;
        }
    }

    public final String p(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public abstract a1 r();

    public abstract a1 t(ue1 ue1Var);

    public final String toString() {
        return sb4.a().d(this);
    }

    public abstract a1 u();
}
