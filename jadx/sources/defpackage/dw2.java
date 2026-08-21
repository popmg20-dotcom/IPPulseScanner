package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.u;
import j$.util.Objects;
import j$.util.Optional;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.security.Provider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.conscrypt.OpenSSLProvider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class dw2 {
    public static String A(int i, String str) {
        return str + i;
    }

    public static String B(Class cls, String str) {
        return str + cls;
    }

    public static String C(StringBuilder sb, String str, long j) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder D(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static void E(s64 s64Var, w64 w64Var, v64 v64Var, t64 t64Var, d44 d44Var) {
        s64Var.a(w64Var);
        s64Var.a(tj4.r(v64Var, t64Var, d44Var));
    }

    public static void F(StringBuilder sb, String str, String str2, OpenSSLProvider openSSLProvider, String str3) {
        sb.append(str);
        sb.append(str2);
        openSSLProvider.put(str3, sb.toString());
    }

    public static boolean G(Class cls, Method method, Class cls2) {
        cls.getClass();
        return method.getReturnType().equals(cls2);
    }

    public static boolean H(Method method) {
        method.getClass();
        return Modifier.isPublic(method.getModifiers());
    }

    public static /* synthetic */ void I(Object obj) {
        if (obj == null) {
            return;
        }
        st4.n();
    }

    public static /* synthetic */ String J(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "null" : "REMOVING" : "ADDING" : "NONE";
    }

    public static /* synthetic */ String K(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED";
    }

    public static jr3 L(Class cls, z1 z1Var, mr3 mr3Var) {
        if (z1Var != null) {
            if (z1Var.Z()) {
                String strX0 = z1Var.x0();
                n12.g(strX0, "No provider name specified");
                return new ir3(cls, strX0, cls.getDeclaredMethod("getInstance", String.class, String.class));
            }
            Provider providerI0 = z1Var.i0();
            Objects.requireNonNull(providerI0, "No provider instance");
            return new ir3(cls, providerI0, cls.getDeclaredMethod("getInstance", String.class, Provider.class));
        }
        if (mr3Var == mr3.P) {
            return new hr3(cls, cls.getDeclaredMethod("getInstance", String.class));
        }
        if (mr3Var.Z()) {
            String strX02 = mr3Var.x0();
            n12.g(strX02, "No provider name specified");
            return new ir3(cls, strX02, cls.getDeclaredMethod("getInstance", String.class, String.class));
        }
        Provider providerI02 = mr3Var.i0();
        Objects.requireNonNull(providerI02, "No provider instance");
        return new ir3(cls, providerI02, cls.getDeclaredMethod("getInstance", String.class, Provider.class));
    }

    public static boolean a(zd3 zd3Var, pg pgVar) {
        return zd3Var.m().K(pgVar);
    }

    public static void b(zd3 zd3Var, ed edVar) {
        zd3Var.m().l(edVar);
    }

    public static ia0 c(zd3 zd3Var, pg pgVar) {
        return zd3Var.m().S(pgVar);
    }

    public static Set d(zd3 zd3Var, pg pgVar) {
        return zd3Var.m().y(pgVar);
    }

    public static String e(mn4 mn4Var) {
        return (String) mn4Var.u(ta4.T);
    }

    public static String f(mn4 mn4Var, String str) {
        return (String) mn4Var.p(ta4.T, str);
    }

    public static String g(ea3 ea3Var) {
        if (ea3Var instanceof s9) {
            return "anytls";
        }
        if (ea3Var instanceof tu0) {
            return "direct";
        }
        if (ea3Var instanceof ou1) {
            return "http";
        }
        if (ea3Var instanceof gv1) {
            return "https";
        }
        if (ea3Var instanceof jv1) {
            return "hysteria2";
        }
        if ((ea3Var instanceof ii3) || (ea3Var instanceof li3)) {
            return "reject";
        }
        if (ea3Var instanceof mu3) {
            return "shadowsocks";
        }
        if (ea3Var instanceof sy3) {
            return "snell";
        }
        if (ea3Var instanceof zy3) {
            return "socks5";
        }
        if (ea3Var instanceof az3) {
            return "socks5-tls";
        }
        if (ea3Var instanceof xh4) {
            return "trojan";
        }
        if (ea3Var instanceof ai4) {
            return "tuic-v5";
        }
        if (ea3Var instanceof ms4) {
            return "vmess";
        }
        if (ea3Var instanceof fw4) {
            return "wireguard";
        }
        g.d();
        return null;
    }

    public static boolean h(ea3 ea3Var) {
        if ((ea3Var instanceof s9) || (ea3Var instanceof xh4) || (ea3Var instanceof ms4) || (ea3Var instanceof sy3)) {
            return true;
        }
        if ((ea3Var instanceof mu3) || (ea3Var instanceof jv1) || (ea3Var instanceof ai4) || (ea3Var instanceof fw4) || (ea3Var instanceof zy3) || (ea3Var instanceof az3) || (ea3Var instanceof ou1) || (ea3Var instanceof gv1) || (ea3Var instanceof tu0) || (ea3Var instanceof ii3) || (ea3Var instanceof li3)) {
            return false;
        }
        g.d();
        return false;
    }

    public static Set i(zd3 zd3Var) {
        return zd3Var.m().t();
    }

    public static boolean j(bn3 bn3Var, String str, String str2, InetAddress inetAddress, String str3, String str4, List list, on3 on3Var, e03 e03Var, String str5, Integer num, Integer num2, Integer num3, String str6, int i) {
        if (bn3Var instanceof xm3) {
            ArrayList arrayList = ((xm3) bn3Var).b;
            if (arrayList.isEmpty()) {
                return true;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!fx3.u((tn3) it.next(), str, str2, inetAddress, str3, str4, list, on3Var, e03Var, str5, num, num2, num3, str6, i)) {
                }
            }
            return true;
        }
        if (bn3Var instanceof an3) {
            ArrayList arrayList2 = ((an3) bn3Var).b;
            if (!arrayList2.isEmpty()) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    if (fx3.u((tn3) it2.next(), str, str2, inetAddress, str3, str4, list, on3Var, e03Var, str5, num, num2, num3, str6, i)) {
                        return true;
                    }
                }
            }
        } else {
            if (!(bn3Var instanceof zm3)) {
                g.d();
                return false;
            }
            if (!fx3.u((tn3) d70.d0(((zm3) bn3Var).z), str, str2, inetAddress, str3, str4, list, on3Var, e03Var, str5, num, num2, num3, str6, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(hn3 hn3Var, String str, Integer num, int i, int i2) {
        if ((hn3Var instanceof cn3) && ((cn3) hn3Var).b == i) {
            return true;
        }
        if (str != null && (hn3Var instanceof gn3) && n12.c(((gn3) hn3Var).b, str)) {
            return true;
        }
        if (num != null && (hn3Var instanceof dn3)) {
            if (((dn3) hn3Var).b == num.intValue()) {
                return true;
            }
        }
        if (!(hn3Var instanceof fn3)) {
            return false;
        }
        en3 en3Var = ((fn3) hn3Var).b;
        if (en3Var.f != i2) {
            return false;
        }
        Integer num2 = en3Var.z;
        return num2 == null || num2.intValue() == i;
    }

    public static boolean l(qn3 qn3Var, String str, String str2, List list, on3 on3Var, e03 e03Var) {
        list.getClass();
        e03Var.getClass();
        if ((qn3Var instanceof nn3) && str != null && ji0.a0(((nn3) qn3Var).b, str)) {
            return true;
        }
        if ((qn3Var instanceof kn3) && str2 != null && ji0.a0(((kn3) qn3Var).b, str2)) {
            return true;
        }
        if ((qn3Var instanceof mn3) && list.contains(((mn3) qn3Var).b)) {
            return true;
        }
        if ((qn3Var instanceof pn3) && ((pn3) qn3Var).b == on3Var) {
            return true;
        }
        if (!(qn3Var instanceof ln3)) {
            return false;
        }
        ln3 ln3Var = (ln3) qn3Var;
        return ln3Var.b == ((Number) e03Var.b).intValue() && ln3Var.f == ((Number) e03Var.f).intValue();
    }

    public static Object m(zd3 zd3Var, pg pgVar) {
        return zd3Var.m().u(pgVar);
    }

    public static Object n(zd3 zd3Var, pg pgVar, Object obj) {
        return zd3Var.m().p(pgVar, obj);
    }

    public static Object o(zd3 zd3Var, pg pgVar, ia0 ia0Var) {
        return zd3Var.m().C(pgVar, ia0Var);
    }

    public static boolean p(ea3 ea3Var, boolean z) {
        if (z) {
            return true;
        }
        return ea3Var.e();
    }

    public static boolean q(ea3 ea3Var, t53 t53Var, Map map, boolean z) {
        String strQ;
        t53Var.getClass();
        map.getClass();
        if (z) {
            return true;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        while (ea3Var != null) {
            arrayList.add(ea3Var);
            if (ea3Var.v() || (strQ = ea3Var.q()) == null) {
                break;
            }
            if (!hashSet.add(strQ) || (ea3Var = t53Var.l(strQ, map)) == null) {
                return false;
            }
            if ((ea3Var instanceof tu0) || (ea3Var instanceof ii3) || (ea3Var instanceof li3)) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((ea3) it.next()).U(z)) {
                return false;
            }
        }
        return true;
    }

    public static final String r(char c, int i) {
        String str;
        String str2 = " ";
        if (i == 1) {
            str = "";
        } else {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw null;
                    }
                }
                str = "";
            }
            str = " ";
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(c);
        if (i == 1 || i == 2) {
            str2 = "";
        } else if (i != 3 && i != 4) {
            throw null;
        }
        sb.append(str2);
        return sb.toString();
    }

    public static final void s(int i, View view, ViewGroup viewGroup) {
        view.getClass();
        viewGroup.getClass();
        if (u.M(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Calling apply state");
        }
        int iG = fw.G(i);
        if (iG == 0) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                if (u.M(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup2);
                }
                viewGroup2.removeView(view);
                return;
            }
            return;
        }
        if (iG == 1) {
            if (u.M(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            ViewParent parent2 = view.getParent();
            if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                if (u.M(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + viewGroup);
                }
                viewGroup.addView(view);
            }
            view.setVisibility(0);
            return;
        }
        if (iG == 2) {
            if (u.M(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (iG != 3) {
            return;
        }
        if (u.M(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static Number t(int i, r62 r62Var) throws IOException {
        if (i == 1) {
            return Double.valueOf(r62Var.nextDouble());
        }
        if (i == 2) {
            return new y82(r62Var.q());
        }
        if (i == 3) {
            String strQ = r62Var.q();
            if (strQ.indexOf(46) >= 0) {
                return u(strQ, r62Var);
            }
            try {
                return Long.valueOf(Long.parseLong(strQ));
            } catch (NumberFormatException unused) {
                return u(strQ, r62Var);
            }
        }
        String strQ2 = r62Var.q();
        try {
            return fx3.z(strQ2);
        } catch (NumberFormatException e) {
            StringBuilder sbD = fw.D("Cannot parse ", strQ2, "; at path ");
            sbD.append(r62Var.x(true));
            throw new h62(sbD.toString(), e);
        }
    }

    public static Double u(String str, r62 r62Var) throws wf2 {
        try {
            Double dValueOf = Double.valueOf(str);
            if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                if (r62Var.F0 != 1) {
                    throw new wf2("JSON forbids NaN and infinities: " + dValueOf + "; at path " + r62Var.x(true));
                }
            }
            return dValueOf;
        } catch (NumberFormatException e) {
            StringBuilder sbD = fw.D("Cannot parse ", str, "; at path ");
            sbD.append(r62Var.x(true));
            throw new h62(sbD.toString(), e);
        }
    }

    public static void v(String str, boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        n12.g(str, "No name provided");
        Optional.ofNullable(boolValueOf);
    }

    public static int w(int i, int i2, String str) {
        return (str.hashCode() + i) * i2;
    }

    public static s64 x(s64 s64Var, w64 w64Var, ArrayList arrayList, s64 s64Var2) {
        s64Var.a(w64Var);
        arrayList.add(s64Var2);
        return new s64();
    }

    public static s64 y(ArrayList arrayList, s64 s64Var) {
        arrayList.add(s64Var);
        return new s64();
    }

    public static ClassCastException z(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }
}
