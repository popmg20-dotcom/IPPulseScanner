package defpackage;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class fm extends vf2 implements Serializable {
    public static final HashMap Z;
    public static final HashMap y0;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put(String.class.getName(), new rt(2));
        et2 et2Var = et2.Y;
        map2.put(StringBuffer.class.getName(), et2Var);
        map2.put(StringBuilder.class.getName(), et2Var);
        map2.put(Character.class.getName(), et2Var);
        map2.put(Character.TYPE.getName(), et2Var);
        int i = 4;
        map2.put(Integer.class.getName(), new gt2(Integer.class, i));
        Class cls = Integer.TYPE;
        map2.put(cls.getName(), new gt2(cls, i));
        int i2 = 5;
        map2.put(Long.class.getName(), new gt2(Long.class, i2));
        Class cls2 = Long.TYPE;
        map2.put(cls2.getName(), new gt2(cls2, i2));
        String name = Byte.class.getName();
        gt2 gt2Var = gt2.Y;
        map2.put(name, gt2Var);
        map2.put(Byte.TYPE.getName(), gt2Var);
        String name2 = Short.class.getName();
        gt2 gt2Var2 = gt2.Z;
        map2.put(name2, gt2Var2);
        map2.put(Short.TYPE.getName(), gt2Var2);
        int i3 = 3;
        map2.put(Double.class.getName(), new gt2(Double.class, i3));
        Class cls3 = Double.TYPE;
        map2.put(cls3.getName(), new gt2(cls3, i3));
        String name3 = Float.class.getName();
        gt2 gt2Var3 = gt2.X;
        map2.put(name3, gt2Var3);
        map2.put(Float.TYPE.getName(), gt2Var3);
        map2.put(Boolean.TYPE.getName(), new yn(true, 1));
        int i4 = 0;
        map2.put(Boolean.class.getName(), new yn(false, 1));
        map2.put(BigInteger.class.getName(), new ft2(BigInteger.class));
        map2.put(BigDecimal.class.getName(), new ft2(BigDecimal.class));
        map2.put(Calendar.class.getName(), lv.Z);
        map2.put(Date.class.getName(), wj0.Z);
        HashMap map3 = new HashMap();
        map3.put(URL.class, new et2(URL.class, i4));
        map3.put(URI.class, new et2(URI.class, i4));
        map3.put(Currency.class, new et2(Currency.class, i4));
        map3.put(UUID.class, new uk4(null));
        map3.put(Pattern.class, new et2(Pattern.class, i4));
        map3.put(Locale.class, new et2(Locale.class, i4));
        map3.put(AtomicBoolean.class, f34.class);
        map3.put(AtomicInteger.class, g34.class);
        map3.put(AtomicLong.class, h34.class);
        map3.put(File.class, ae1.class);
        map3.put(Class.class, k50.class);
        zs2 zs2Var = zs2.A;
        map3.put(Void.class, zs2Var);
        map3.put(Void.TYPE, zs2Var);
        for (Map.Entry entry : map3.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof b72) {
                map2.put(((Class) entry.getKey()).getName(), (b72) value);
            } else {
                map.put(((Class) entry.getKey()).getName(), (Class) value);
            }
        }
        map.put(te4.class.getName(), ue4.class);
        Z = map2;
        y0 = map;
    }

    public static t52 I(gt3 gt3Var, ul ulVar, nj4 nj4Var, Class cls) {
        t52 t52VarA = (t52) gt3Var.b.Z.f;
        cu2 cu2Var = (cu2) ulVar.e;
        if (cu2Var != null) {
            t52VarA = t52VarA.a(cu2Var.x((w8) ulVar.f));
        }
        Class cls2 = nj4Var.L0;
        return t52VarA;
    }

    public static b72 K(gt3 gt3Var, xb5 xb5Var) {
        bt3 bt3Var = gt3Var.b;
        Object objI = bt3Var.d().I(xb5Var);
        if (objI == null) {
            return null;
        }
        b72 b72VarD = gt3Var.D(xb5Var, objI);
        Object objE = bt3Var.d().E(xb5Var);
        if (objE == null) {
            return b72VarD;
        }
        gt3Var.f(objE);
        return b72VarD;
    }

    public final l34 J(gt3 gt3Var, nj4 nj4Var, ul ulVar) {
        if (w62.class.isAssignableFrom(nj4Var.L0)) {
            return zs2.X;
        }
        c9 c9VarC = ulVar.c();
        if (c9VarC == null) {
            return null;
        }
        bt3 bt3Var = gt3Var.b;
        bt3Var.getClass();
        if (bt3Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            n50.d(c9VarC.Q(), bt3Var.f(ah2.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        nj4 nj4VarX = c9VarC.x();
        b72 b72VarK = K(gt3Var, c9VarC);
        if (b72VarK == null) {
            b72VarK = (b72) nj4VarX.N0;
        }
        zj4 zj4VarK = (zj4) nj4VarX.O0;
        if (zj4VarK == null) {
            zj4VarK = k(bt3Var, nj4VarX);
        }
        p52 p52VarV = bt3Var.d().v(c9VarC);
        Set set = p52VarV.z ? Collections.EMPTY_SET : p52VarV.b;
        if (b72VarK != null && !set.isEmpty()) {
            b72VarK = b72VarK.i(set);
        }
        return new yf(c9VarC, zj4VarK, b72VarK, set);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f8  */
    @Override // defpackage.vf2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.b72 j(defpackage.gt3 r11, defpackage.nj4 r12) {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fm.j(gt3, nj4):b72");
    }

    @Override // defpackage.vf2
    public final ak4 k(bt3 bt3Var, nj4 nj4Var) {
        ArrayList arrayList;
        nj4 nj4VarC = bt3Var.c(nj4Var.L0);
        ((wl) bt3Var.f.f).getClass();
        ul ulVarS = wl.S(bt3Var, nj4VarC);
        if (ulVarS == null) {
            ulVarS = ul.d(bt3Var, nj4VarC, x8.F(bt3Var, nj4VarC, bt3Var));
        }
        w8 w8Var = (w8) ulVarS.f;
        n34 n34VarL = bt3Var.d().L(bt3Var, w8Var, nj4Var);
        if (n34VarL == null) {
            arrayList = null;
            n34VarL = null;
        } else {
            cu2 cu2VarD = bt3Var.d();
            HashMap map = new HashMap();
            m34.I(w8Var, new uo2(w8Var.C0, null), bt3Var, cu2VarD, map);
            arrayList = new ArrayList(map.values());
        }
        if (n34VarL == null) {
            return null;
        }
        return n34VarL.a(bt3Var, nj4Var, arrayList);
    }
}
