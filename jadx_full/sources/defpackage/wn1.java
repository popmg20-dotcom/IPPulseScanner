package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.MainActivity;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.navigation.NavigationView;
import com.tencent.mars.xlog.Xlog;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.text.Bidi;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wn1 implements rl2, vv2, lk2, ne0, gp4, ho3, z2, vb4, mv1, yt4 {
    public final /* synthetic */ int b;
    public Object f;

    public wn1(int i) {
        this.b = i;
        switch (i) {
            case 5:
                this.f = (ExtraCroppingQuirk) xt0.a.z(ExtraCroppingQuirk.class);
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                this.f = null;
                break;
            case 17:
                this.f = new LinkedHashSet();
                break;
            case 20:
                this.f = new LinkedHashMap();
                break;
            case 23:
                break;
            default:
                this.f = new iv1(this);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static me0 A(HttpCookie httpCookie) {
        String strB;
        boolean z;
        String str;
        boolean z2;
        String str2;
        long j;
        boolean z3;
        boolean zBooleanValue;
        String name = httpCookie.getName();
        name.getClass();
        if (!n12.c(p44.U0(name).toString(), name)) {
            xe.k("name is not trimmed");
            return null;
        }
        String value = httpCookie.getValue();
        value.getClass();
        if (!n12.c(p44.U0(value).toString(), value)) {
            xe.k("value is not trimmed");
            return null;
        }
        String domain = httpCookie.getDomain();
        domain.getClass();
        if (w44.j0(domain, ".", false)) {
            String strF0 = p44.F0(domain, ".");
            strB = fz4.b(strF0);
            if (strB == null) {
                xe.k("unexpected domain: ".concat(strF0));
                return null;
            }
            z = false;
        } else {
            strB = fz4.b(domain);
            if (strB == null) {
                xe.k("unexpected domain: ".concat(domain));
                return null;
            }
            z = true;
        }
        String path = httpCookie.getPath();
        if (path == null) {
            path = "/";
        }
        if (!w44.j0(path, "/", false)) {
            xe.k("path must start with '/'");
            return null;
        }
        if (httpCookie.getMaxAge() >= 0) {
            long maxAge = httpCookie.getMaxAge() * 1000;
            if (maxAge >= 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() + maxAge;
                if (jCurrentTimeMillis >= 0) {
                    if (jCurrentTimeMillis <= 0) {
                        jCurrentTimeMillis = Long.MIN_VALUE;
                    }
                    str = path;
                    str2 = strB;
                    j = jCurrentTimeMillis <= 253402300799999L ? jCurrentTimeMillis : 253402300799999L;
                    z3 = true;
                    z2 = false;
                } else {
                    str = path;
                    z2 = false;
                    str2 = strB;
                    j = 253402300799999L;
                    z3 = false;
                }
            }
        }
        boolean secure = httpCookie.getSecure();
        try {
            Object objInvoke = HttpCookie.class.getMethod("isHttpOnly", null).invoke(httpCookie, null);
            objInvoke.getClass();
            zBooleanValue = ((Boolean) objInvoke).booleanValue();
        } catch (Exception unused) {
            zBooleanValue = z2;
        }
        return new me0(name, value, j, str2, str, secure, zBooleanValue, z3, z, null);
    }

    public void C(String str, xf2 xf2Var) {
        str.getClass();
        xf2Var.getClass();
        boolean zA = xf2Var.a();
        d83 d83Var = (d83) this.f;
        int i = 3;
        if (!zA) {
            String str2 = xf2Var.b;
            str2.getClass();
            ji0.B(uf2.t(d83Var), null, null, new z73(str, str2, d83Var, true, null), 3);
            return;
        }
        wh2 wh2Var = new wh2(d83Var.requireContext());
        wh2Var.x(R.string.warning);
        wh2Var.t(R.string.local_managed_config_warning);
        int i2 = 5;
        wh2Var.w(R.string.i_got_it, new ph0(i2));
        wh2Var.v(R.string.learn_more, new y5(i2, d83Var));
        ja1 ja1Var = new ja1(2);
        p6 p6Var = (p6) wh2Var.z;
        p6Var.p = ja1Var;
        p6Var.o = new ka1(i);
        u6 u6VarH = wh2Var.h();
        u6VarH.setOnShowListener(new ai0(4));
        u6VarH.show();
    }

    public h24 D(vw4 vw4Var) {
        vw4Var.getClass();
        return (h24) ((LinkedHashMap) this.f).remove(vw4Var);
    }

    public List E(String str) {
        str.getClass();
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (n12.c(((vw4) entry.getKey()).a, str)) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap2.keySet().iterator();
        while (it.hasNext()) {
            linkedHashMap.remove((vw4) it.next());
        }
        return d70.y0(linkedHashMap2.values());
    }

    public h24 F(vw4 vw4Var) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f;
        Object h24Var = linkedHashMap.get(vw4Var);
        if (h24Var == null) {
            h24Var = new h24(vw4Var);
            linkedHashMap.put(vw4Var, h24Var);
        }
        return (h24) h24Var;
    }

    @Override // defpackage.lk2
    public boolean V(nk2 nk2Var, sk2 sk2Var) {
        switch (this.b) {
            case 8:
                qq2 qq2Var = ((NavigationView) this.f).D0;
                if (qq2Var == null || !((tf2) qq2Var).j(sk2Var)) {
                }
                break;
        }
        return false;
    }

    @Override // defpackage.gp4
    public int a(View view) {
        return ag3.A(view) - ((ViewGroup.MarginLayoutParams) ((bg3) view.getLayoutParams())).leftMargin;
    }

    @Override // defpackage.lk2
    public void a0(nk2 nk2Var) {
        switch (this.b) {
            case 8:
                break;
            default:
                Toolbar toolbar = (Toolbar) this.f;
                q3 q3Var = toolbar.b.N0;
                if (q3Var == null || !q3Var.k()) {
                    Iterator it = ((CopyOnWriteArrayList) toolbar.a1.z).iterator();
                    while (it.hasNext()) {
                        ((sj1) it.next()).a.t(nk2Var);
                    }
                }
                jf4 jf4Var = toolbar.i1;
                if (jf4Var != null) {
                    jf4Var.a0(nk2Var);
                }
                break;
        }
    }

    @Override // defpackage.rl2
    public boolean b(ft0 ft0Var) {
        return ((jd1) this.f).h(ft0Var);
    }

    @Override // defpackage.gp4
    public int c() {
        return ((ag3) this.f).H();
    }

    @Override // defpackage.z2
    public boolean d(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f;
        if (!swipeDismissBehavior.w(view)) {
            return false;
        }
        boolean z = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.X;
        int width = (!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth();
        WeakHashMap weakHashMap = wp4.a;
        view.offsetLeftAndRight(width);
        view.setAlpha(0.0f);
        zf2 zf2Var = swipeDismissBehavior.f;
        if (zf2Var != null) {
            zf2Var.o0(view);
        }
        return true;
    }

    @Override // defpackage.rl2
    public rl2 e(ft0 ft0Var, Object obj) {
        ((jd1) this.f).a(ft0Var, obj);
        return this;
    }

    @Override // defpackage.rl2
    public int f(ft0 ft0Var) {
        return ft0Var.B() ? 2 : 1;
    }

    @Override // defpackage.ne0
    public void g(ev1 ev1Var, List list) {
        ev1Var.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            me0 me0Var = (me0) it.next();
            boolean z = me0Var.h;
            long j = me0Var.c;
            if (!z || j > jCurrentTimeMillis) {
                HttpCookie httpCookie = new HttpCookie(me0Var.a, me0Var.b);
                boolean z2 = me0Var.i;
                String strConcat = me0Var.d;
                if (!z2) {
                    strConcat = ".".concat(strConcat);
                }
                httpCookie.setDomain(strConcat);
                httpCookie.setPath(me0Var.e);
                if (me0Var.h) {
                    long j2 = (j - jCurrentTimeMillis) / 1000;
                    if (j2 < 1) {
                        j2 = 1;
                    }
                    httpCookie.setMaxAge(j2);
                } else {
                    httpCookie.setMaxAge(-1L);
                }
                httpCookie.setSecure(me0Var.f);
                try {
                    HttpCookie.class.getMethod("setHttpOnly", Boolean.TYPE).invoke(httpCookie, Boolean.valueOf(me0Var.g));
                } catch (Exception unused) {
                }
                ((CookieManager) this.f).getCookieStore().add(ev1Var.i(), httpCookie);
            }
        }
    }

    @Override // defpackage.rl2
    public int h() {
        return 2;
    }

    @Override // defpackage.ho3
    public go3 i(String str) {
        str.getClass();
        return new c64(((f64) this.f).T());
    }

    @Override // defpackage.mv1
    public int j() {
        return ((lj3[]) this.f).length;
    }

    @Override // defpackage.rl2
    public k91 k(l91 l91Var, ws0 ws0Var, int i) {
        return (k91) l91Var.f.get(new j91(ws0Var, i));
    }

    @Override // defpackage.gp4
    public int l() {
        ag3 ag3Var = (ag3) this.f;
        return ag3Var.n - ag3Var.I();
    }

    @Override // defpackage.mv1
    public int m(int i) {
        return (int) (((lj3[]) this.f)[i].a >> 32);
    }

    @Override // defpackage.vv2
    public wv2 n(zv2 zv2Var, int i) {
        g20 g20VarA = ((dp2) this.f).a(zv2Var, i);
        if (g20VarA != null) {
            return new wv2(g20VarA, zv2Var);
        }
        return null;
    }

    @Override // defpackage.rl2
    public c1 o(zt ztVar, o91 o91Var, ft0 ft0Var, c1 c1Var) {
        c1 c1Var2;
        a1 a1VarR = c1Var.r();
        if (!ft0Var.y() && (c1Var2 = (c1) ((jd1) this.f).f(ft0Var)) != null) {
            a1VarR.x(c1Var2);
        }
        a1VarR.z(ztVar, o91Var);
        return a1VarR.q();
    }

    @Override // defpackage.vb4
    public byte p(int i) {
        return ((zt) this.f).a(i);
    }

    @Override // defpackage.rl2
    public void q(m60 m60Var, o91 o91Var, ft0 ft0Var, c1 c1Var) {
        ml2 ml2VarE;
        jd1 jd1Var = (jd1) this.f;
        if (ft0Var.y()) {
            a1 a1VarR = c1Var.r();
            m60Var.k(a1VarR, o91Var);
            e(ft0Var, a1VarR.q());
        } else if (!jd1Var.h(ft0Var)) {
            a1 a1VarR2 = c1Var.r();
            m60Var.k(a1VarR2, o91Var);
            w(ft0Var, a1VarR2);
        } else {
            Object objG = jd1Var.g(ft0Var);
            if (objG instanceof ml2) {
                ml2VarE = (ml2) objG;
            } else {
                ml2VarE = ((nl2) objG).u();
                jd1Var.n(ft0Var, ml2VarE);
            }
            m60Var.k(ml2VarE, o91Var);
        }
    }

    @Override // defpackage.mv1
    public int r(int i) {
        return (int) (((lj3[]) this.f)[i].a & 4294967295L);
    }

    @Override // defpackage.gp4
    public View s(int i) {
        return ((ag3) this.f).u(i);
    }

    @Override // defpackage.vb4
    public int size() {
        return ((zt) this.f).size();
    }

    @Override // defpackage.mv1
    public boolean t(int i) {
        return (((lj3[]) this.f)[i].b & 1) != 0;
    }

    @Override // defpackage.ne0
    public List u(ev1 ev1Var) {
        ev1Var.getClass();
        List<HttpCookie> list = ((CookieManager) this.f).getCookieStore().get(ev1Var.i());
        list.getClass();
        return ws3.V(new oe1(new oe1(new go1(new oe1(new j70(0, list), false, new ji(20)), new ji(21, this), 1), false, new ji(29)), true, new f0(15, ev1Var)));
    }

    @Override // defpackage.gp4
    public int v(View view) {
        return ag3.D(view) + ((ViewGroup.MarginLayoutParams) ((bg3) view.getLayoutParams())).rightMargin;
    }

    @Override // defpackage.rl2
    public rl2 w(ft0 ft0Var, Object obj) {
        ((jd1) this.f).n(ft0Var, obj);
        return this;
    }

    @Override // defpackage.rl2
    public void x(m60 m60Var, o91 o91Var, ft0 ft0Var, c1 c1Var) {
        ml2 ml2VarE;
        jd1 jd1Var = (jd1) this.f;
        boolean zY = ft0Var.y();
        rq0 rq0Var = ft0Var.z;
        if (zY) {
            a1 a1VarR = c1Var.r();
            m60Var.i(rq0Var.Z, a1VarR, o91Var);
            e(ft0Var, a1VarR.q());
        } else if (!jd1Var.h(ft0Var)) {
            a1 a1VarR2 = c1Var.r();
            m60Var.i(rq0Var.Z, a1VarR2, o91Var);
            w(ft0Var, a1VarR2);
        } else {
            Object objG = jd1Var.g(ft0Var);
            if (objG instanceof ml2) {
                ml2VarE = (ml2) objG;
            } else {
                ml2VarE = ((nl2) objG).u();
                jd1Var.n(ft0Var, ml2VarE);
            }
            m60Var.i(rq0Var.Z, ml2VarE, o91Var);
        }
    }

    public pe3 y() {
        hv0 hv0VarS;
        ue1 ue1Var = (ue1) this.f;
        jv0 jv0Var = (jv0) ue1Var.A;
        synchronized (jv0Var) {
            ue1Var.e(true);
            hv0VarS = jv0Var.s(((gv0) ue1Var.b).a);
        }
        if (hv0VarS != null) {
            return new pe3(hv0VarS);
        }
        return null;
    }

    public synchronized void z(em3 em3Var) {
        em3Var.getClass();
        ((LinkedHashSet) this.f).remove(em3Var);
    }

    private final void B(nk2 nk2Var) {
    }

    public wn1(f64 f64Var) {
        this.b = 21;
        f64Var.getClass();
        this.f = f64Var;
    }

    public wn1(at3 at3Var) {
        this.b = 27;
        this.f = new AtomicInteger(0);
    }

    public wn1(List list) {
        this.b = 7;
        this.f = new dp2(list);
    }

    public /* synthetic */ wn1(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    public wn1(o84 o84Var, ot4 ot4Var, ue2 ue2Var) {
        this.b = 29;
        this.f = ot4Var;
    }

    public wn1(MainActivity mainActivity) {
        v62 v62Var;
        this.b = 19;
        if (Build.VERSION.SDK_INT >= 31) {
            v62Var = new j04(mainActivity);
        } else {
            v62Var = new v62(mainActivity);
        }
        v62Var.t();
        this.f = v62Var;
    }

    public wn1(bv0 bv0Var) {
        this.b = 28;
        long[] jArr = bv0Var.b;
        long[] jArr2 = bv0Var.b;
        int length = jArr.length;
        this.f = new lj3[length];
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (jArr2[i] & 4294967295L);
            lj3[] lj3VarArr = (lj3[]) this.f;
            long jM = ez4.M(bv0Var.m(i), bv0Var.r(i));
            int i2 = (int) (4294967295L & jArr2[i]);
            lj3 lj3Var = new lj3();
            lj3Var.a = jM;
            lj3Var.b = i2;
            lj3VarArr[i] = lj3Var;
        }
        Bidi.reorderVisually(bArr, 0, (lj3[]) this.f, 0, length);
    }

    public wn1(t24 t24Var, boolean z) {
        this.b = 3;
        this.f = t24Var;
    }

    public wn1(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.b = 2;
        if (Build.VERSION.SDK_INT >= 25) {
            this.f = new m02(uri, clipDescription, uri2);
        } else {
            this.f = new n02(uri, clipDescription, uri2);
        }
    }
}
