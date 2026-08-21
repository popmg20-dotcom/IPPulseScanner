package defpackage;

import android.R;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ih4 {
    public final Object a;
    public final Object b;
    public Object c;
    public final Object d;

    public ih4(int i) {
        switch (i) {
            case 5:
                e24 e24Var = new e24(28);
                this.a = e24Var;
                ih4 ih4Var = new ih4((ih4) null, e24Var);
                this.c = ih4Var;
                this.b = ih4Var.k();
                jf4 jf4Var = new jf4(6);
                this.d = jf4Var;
                ih4Var.m("require", new kh5(jf4Var));
                ((HashMap) jf4Var.f).put("internal.platform", t45.a);
                ih4Var.m("runtime.counter", new p15(Double.valueOf(0.0d)));
                break;
            default:
                this.a = new ie(0);
                this.c = new SparseArray();
                this.d = new ff2();
                this.b = new ie(0);
                break;
        }
    }

    public iq4 a(j50 j50Var, String str) {
        iq4 iq4Var;
        iq4 iq4VarA;
        synchronized (((q84) this.d)) {
            try {
                oq4 oq4Var = (oq4) this.a;
                oq4Var.getClass();
                iq4Var = (iq4) oq4Var.a.get(str);
                if (j50Var.d(iq4Var)) {
                    mq4 mq4Var = (mq4) this.b;
                    if (mq4Var instanceof lp3) {
                        lp3 lp3Var = (lp3) mq4Var;
                        iq4Var.getClass();
                        r92 r92Var = lp3Var.d;
                        if (r92Var != null) {
                            hp3 hp3Var = lp3Var.e;
                            hp3Var.getClass();
                            n12.d(iq4Var, hp3Var, r92Var);
                        }
                    }
                    iq4Var.getClass();
                } else {
                    in2 in2Var = new in2((dg0) this.c);
                    in2Var.a.put(nq4.a, str);
                    mq4 mq4Var2 = (mq4) this.b;
                    try {
                        try {
                            iq4VarA = mq4Var2.c(j50Var, in2Var);
                        } catch (AbstractMethodError unused) {
                            Class cls = j50Var.a;
                            cls.getClass();
                            iq4VarA = mq4Var2.a(cls);
                        }
                    } catch (AbstractMethodError unused2) {
                        Class cls2 = j50Var.a;
                        cls2.getClass();
                        iq4VarA = mq4Var2.b(cls2, in2Var);
                    }
                    iq4Var = iq4VarA;
                    oq4 oq4Var2 = (oq4) this.a;
                    oq4Var2.getClass();
                    iq4Var.getClass();
                    iq4 iq4Var2 = (iq4) oq4Var2.a.put(str, iq4Var);
                    if (iq4Var2 != null) {
                        iq4Var2.b();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iq4Var;
    }

    public synchronized boolean b(aj3 aj3Var) {
        try {
            String str = aj3Var.f;
            boolean zContainsKey = ((HashMap) this.a).containsKey(str);
            HashMap map = (HashMap) this.a;
            if (!zContainsKey) {
                map.put(str, null);
                aj3Var.l(this);
                if (qs4.a) {
                    qs4.b("new request, sending to network %s", str);
                }
                return false;
            }
            List arrayList = (List) map.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            aj3Var.a("waiting-for-response");
            arrayList.add(aj3Var);
            ((HashMap) this.a).put(str, arrayList);
            if (qs4.a) {
                qs4.b("Request for cacheKey=%s is in flight, putting on hold.", str);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void c(aj3 aj3Var) {
        try {
            String str = aj3Var.f;
            List list = (List) ((HashMap) this.a).remove(str);
            if (list != null && !list.isEmpty()) {
                if (qs4.a) {
                    qs4.d("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), str);
                }
                aj3 aj3Var2 = (aj3) list.remove(0);
                ((HashMap) this.a).put(str, list);
                aj3Var2.l(this);
                try {
                    ((PriorityBlockingQueue) this.d).put(aj3Var2);
                } catch (InterruptedException e) {
                    qs4.c("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    lu luVar = (lu) this.c;
                    luVar.X = true;
                    luVar.interrupt();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void d(aj3 aj3Var, ue1 ue1Var) {
        List list;
        ju juVar = (ju) ue1Var.z;
        if (juVar == null || juVar.e < System.currentTimeMillis()) {
            c(aj3Var);
            return;
        }
        String str = aj3Var.f;
        synchronized (this) {
            list = (List) ((HashMap) this.a).remove(str);
        }
        if (list != null) {
            if (qs4.a) {
                qs4.d("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), str);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((w7) this.b).u((aj3) it.next(), ue1Var, null);
            }
        }
    }

    public void e() {
        int iB;
        jf4 jf4Var = (jf4) this.b;
        ub4 ub4Var = (ub4) this.a;
        ViewPager2 viewPager2 = (ViewPager2) this.d;
        int i = R.id.accessibilityActionPageLeft;
        wp4.k(viewPager2, R.id.accessibilityActionPageLeft);
        wp4.i(viewPager2, 0);
        wp4.k(viewPager2, R.id.accessibilityActionPageRight);
        wp4.i(viewPager2, 0);
        wp4.k(viewPager2, R.id.accessibilityActionPageUp);
        wp4.i(viewPager2, 0);
        wp4.k(viewPager2, R.id.accessibilityActionPageDown);
        wp4.i(viewPager2, 0);
        if (viewPager2.getAdapter() == null || (iB = viewPager2.getAdapter().b()) == 0 || !viewPager2.L0) {
            return;
        }
        if (viewPager2.getOrientation() != 0) {
            if (viewPager2.A < iB - 1) {
                wp4.l(viewPager2, new i2(R.id.accessibilityActionPageDown), null, ub4Var);
            }
            if (viewPager2.A > 0) {
                wp4.l(viewPager2, new i2(R.id.accessibilityActionPageUp), null, jf4Var);
                return;
            }
            return;
        }
        boolean z = viewPager2.A0.b.getLayoutDirection() == 1;
        int i2 = z ? 16908360 : 16908361;
        if (z) {
            i = 16908361;
        }
        if (viewPager2.A < iB - 1) {
            wp4.l(viewPager2, new i2(i2), null, ub4Var);
        }
        if (viewPager2.A > 0) {
            wp4.l(viewPager2, new i2(i), null, jf4Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00fe A[Catch: NumberFormatException | JSONException -> 0x010b, NumberFormatException | JSONException -> 0x010b, TRY_LEAVE, TryCatch #0 {NumberFormatException | JSONException -> 0x010b, blocks: (B:10:0x0031, B:24:0x0065, B:24:0x0065, B:26:0x0072, B:26:0x0072, B:28:0x0084, B:28:0x0084, B:29:0x008d, B:29:0x008d, B:51:0x00fe, B:51:0x00fe, B:33:0x009a, B:33:0x009a, B:35:0x00a7, B:35:0x00a7, B:37:0x00b9, B:37:0x00b9, B:38:0x00c2, B:38:0x00c2, B:42:0x00ce, B:42:0x00ce, B:46:0x00de, B:46:0x00de, B:50:0x00f2, B:50:0x00f2), top: B:63:0x0031, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bundle f() {
        l75 l75Var = (l75) this.d;
        k85 k85Var = (k85) l75Var.f;
        if (((Bundle) this.c) == null) {
            String string = l75Var.Z0().getString((String) this.a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int iHashCode = string3.hashCode();
                            if (iHashCode != 100) {
                                if (iHashCode != 108) {
                                    if (iHashCode != 115) {
                                        if (iHashCode != 3352) {
                                            if (iHashCode == 3445 && string3.equals("la")) {
                                                mg5.a();
                                                if (k85Var.A.f1(null, r55.R0)) {
                                                    JSONArray jSONArray2 = new JSONArray(jSONObject.getString("v"));
                                                    int length = jSONArray2.length();
                                                    long[] jArr = new long[length];
                                                    for (int i2 = 0; i2 < length; i2++) {
                                                        jArr[i2] = jSONArray2.optLong(i2);
                                                    }
                                                    bundle.putLongArray(string2, jArr);
                                                }
                                            } else {
                                                t65 t65Var = k85Var.Y;
                                                k85.h(t65Var);
                                                t65Var.z0.b(string3, "Unrecognized persisted bundle type. Type");
                                            }
                                        } else if (string3.equals("ia")) {
                                            mg5.a();
                                            if (k85Var.A.f1(null, r55.R0)) {
                                                JSONArray jSONArray3 = new JSONArray(jSONObject.getString("v"));
                                                int length2 = jSONArray3.length();
                                                int[] iArr = new int[length2];
                                                for (int i3 = 0; i3 < length2; i3++) {
                                                    iArr[i3] = jSONArray3.optInt(i3);
                                                }
                                                bundle.putIntArray(string2, iArr);
                                            }
                                        }
                                    } else if (string3.equals("s")) {
                                        bundle.putString(string2, jSONObject.getString("v"));
                                    }
                                } else if (string3.equals("l")) {
                                    bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                                }
                            } else if (string3.equals("d")) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            t65 t65Var2 = k85Var.Y;
                            k85.h(t65Var2);
                            t65Var2.z0.a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.c = bundle;
                } catch (JSONException unused2) {
                    t65 t65Var3 = k85Var.Y;
                    k85.h(t65Var3);
                    t65Var3.z0.a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (((Bundle) this.c) == null) {
                this.c = (Bundle) this.b;
            }
        }
        Bundle bundle2 = (Bundle) this.c;
        tj4.i(bundle2);
        return new Bundle(bundle2);
    }

    public d25 g(ih4 ih4Var, j95... j95VarArr) {
        d25 d25VarR = d25.q0;
        for (j95 j95Var : j95VarArr) {
            d25VarR = vo.R(j95Var);
            je.v0((ih4) this.c);
            if ((d25VarR instanceof e25) || (d25VarR instanceof b25)) {
                d25VarR = ((e24) this.a).K(ih4Var, d25VarR);
            }
        }
        return d25VarR;
    }

    public d25 h(d25 d25Var) {
        return ((e24) this.b).K(this, d25Var);
    }

    public d25 i(h15 h15Var) {
        d25 d25VarK = d25.q0;
        Iterator itK = h15Var.k();
        while (itK.hasNext()) {
            d25VarK = ((e24) this.b).K(this, h15Var.m(((Integer) itK.next()).intValue()));
            if (d25VarK instanceof n15) {
                break;
            }
        }
        return d25VarK;
    }

    public void j(Bundle bundle) {
        l75 l75Var = (l75) this.d;
        k85 k85Var = (k85) l75Var.f;
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        SharedPreferences.Editor editorEdit = l75Var.Z0().edit();
        int size = bundle2.size();
        String str = (String) this.a;
        if (size == 0) {
            editorEdit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle2.keySet()) {
                Object obj = bundle2.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        mg5.a();
                        if (k85Var.A.f1(null, r55.R0)) {
                            if (obj instanceof String) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "l");
                            } else if (obj instanceof int[]) {
                                jSONObject.put("v", Arrays.toString((int[]) obj));
                                jSONObject.put("t", "ia");
                            } else if (obj instanceof long[]) {
                                jSONObject.put("v", Arrays.toString((long[]) obj));
                                jSONObject.put("t", "la");
                            } else if (obj instanceof Double) {
                                jSONObject.put("v", obj.toString());
                                jSONObject.put("t", "d");
                            } else {
                                t65 t65Var = k85Var.Y;
                                k85.h(t65Var);
                                t65Var.z0.b(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            }
                            jSONArray.put(jSONObject);
                        } else {
                            jSONObject.put("v", obj.toString());
                            if (obj instanceof String) {
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("t", "l");
                            } else if (obj instanceof Double) {
                                jSONObject.put("t", "d");
                            } else {
                                t65 t65Var2 = k85Var.Y;
                                k85.h(t65Var2);
                                t65Var2.z0.b(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            }
                            jSONArray.put(jSONObject);
                        }
                    } catch (JSONException e) {
                        t65 t65Var3 = k85Var.Y;
                        k85.h(t65Var3);
                        t65Var3.z0.b(e, "Cannot serialize bundle value to SharedPreferences");
                    }
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.c = bundle2;
    }

    public ih4 k() {
        return new ih4(this, (e24) this.b);
    }

    public boolean l(String str) {
        if (((HashMap) this.c).containsKey(str)) {
            return true;
        }
        ih4 ih4Var = (ih4) this.a;
        if (ih4Var != null) {
            return ih4Var.l(str);
        }
        return false;
    }

    public void m(String str, d25 d25Var) {
        ih4 ih4Var;
        HashMap map = (HashMap) this.c;
        if (!map.containsKey(str) && (ih4Var = (ih4) this.a) != null && ih4Var.l(str)) {
            ih4Var.m(str, d25Var);
        } else {
            if (((HashMap) this.d).containsKey(str)) {
                return;
            }
            if (d25Var == null) {
                map.remove(str);
            } else {
                map.put(str, d25Var);
            }
        }
    }

    public void n(String str, d25 d25Var) {
        if (((HashMap) this.d).containsKey(str)) {
            return;
        }
        HashMap map = (HashMap) this.c;
        if (d25Var == null) {
            map.remove(str);
        } else {
            map.put(str, d25Var);
        }
    }

    public d25 o(String str) {
        HashMap map = (HashMap) this.c;
        if (map.containsKey(str)) {
            return (d25) map.get(str);
        }
        ih4 ih4Var = (ih4) this.a;
        if (ih4Var != null) {
            return ih4Var.o(str);
        }
        xe.k(ha0.x(str, " is not defined"));
        return null;
    }

    public ih4(l75 l75Var, String str) {
        this.d = l75Var;
        tj4.f(str);
        this.a = str;
        this.b = new Bundle();
    }

    public ih4(ih4 ih4Var, e24 e24Var) {
        this.c = new HashMap();
        this.d = new HashMap();
        this.a = ih4Var;
        this.b = e24Var;
    }

    public ih4(oq4 oq4Var, mq4 mq4Var, dg0 dg0Var) {
        oq4Var.getClass();
        dg0Var.getClass();
        this.a = oq4Var;
        this.b = mq4Var;
        this.c = dg0Var;
        this.d = new q84(0);
    }

    public ih4(ExecutorService executorService) {
        this.c = new Handler(Looper.getMainLooper());
        this.d = new fs1(this);
        la laVar = new la(executorService);
        this.a = laVar;
        this.b = n12.x(laVar);
    }

    public ih4(lu luVar, PriorityBlockingQueue priorityBlockingQueue, w7 w7Var) {
        this.a = new HashMap();
        this.b = w7Var;
        this.c = luVar;
        this.d = priorityBlockingQueue;
    }

    public ih4(ViewPager2 viewPager2) {
        this.d = viewPager2;
        this.a = new ub4(this);
        this.b = new jf4(2, this);
    }
}
