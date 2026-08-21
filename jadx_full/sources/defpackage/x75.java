package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x75 extends pe5 implements w15 {
    public final ie A0;
    public final ie B0;
    public final ie C0;
    public final bf3 D0;
    public final rz4 E0;
    public final ie F0;
    public final ie G0;
    public final ie H0;
    public final ie Z;
    public final ie y0;
    public final ie z0;

    public x75(ff5 ff5Var) {
        super(ff5Var);
        this.Z = new ie(0);
        this.y0 = new ie(0);
        this.z0 = new ie(0);
        this.A0 = new ie(0);
        this.B0 = new ie(0);
        this.F0 = new ie(0);
        this.G0 = new ie(0);
        this.H0 = new ie(0);
        this.C0 = new ie(0);
        this.D0 = new bf3(this);
        this.E0 = new rz4(3, this);
    }

    public static final ie f1(j65 j65Var) {
        ie ieVar = new ie(0);
        for (s65 s65Var : j65Var.r()) {
            ieVar.put(s65Var.n(), s65Var.o());
        }
        return ieVar;
    }

    public static final r95 g1(int i) {
        int i2 = i - 1;
        if (i2 == 1) {
            return r95.AD_STORAGE;
        }
        if (i2 == 2) {
            return r95.ANALYTICS_STORAGE;
        }
        if (i2 == 3) {
            return r95.AD_USER_DATA;
        }
        if (i2 != 4) {
            return null;
        }
        return r95.AD_PERSONALIZATION;
    }

    public final o95 Z0(String str, r95 r95Var) {
        V0();
        b1(str);
        a65 a65VarQ1 = q1(str);
        if (a65VarQ1 != null) {
            Iterator it = a65VarQ1.s().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o55 o55Var = (o55) it.next();
                if (g1(o55Var.n()) == r95Var) {
                    int iO = o55Var.o() - 1;
                    if (iO == 1) {
                        return o95.GRANTED;
                    }
                    if (iO == 2) {
                        return o95.DENIED;
                    }
                }
            }
        }
        return o95.UNINITIALIZED;
    }

    public final boolean a1(String str) {
        V0();
        b1(str);
        a65 a65VarQ1 = q1(str);
        if (a65VarQ1 == null) {
            return false;
        }
        for (o55 o55Var : a65VarQ1.n()) {
            if (o55Var.n() == 3 && o55Var.p() == 3) {
                return true;
            }
        }
        return false;
    }

    public final void b1(String str) {
        W0();
        V0();
        tj4.f(str);
        ie ieVar = this.B0;
        if (ieVar.get(str) == null) {
            m25 m25Var = this.X.z;
            ff5.R(m25Var);
            n02 n02VarB2 = m25Var.b2(str);
            ie ieVar2 = this.H0;
            ie ieVar3 = this.G0;
            ie ieVar4 = this.F0;
            ie ieVar5 = this.Z;
            if (n02VarB2 != null) {
                h65 h65Var = (h65) e1(str, (byte[]) n02VarB2.f).g();
                c1(str, h65Var);
                ieVar5.put(str, f1((j65) h65Var.e()));
                ieVar.put(str, (j65) h65Var.e());
                d1(str, (j65) h65Var.e());
                ieVar4.put(str, ((j65) h65Var.f).y());
                ieVar3.put(str, (String) n02VarB2.z);
                ieVar2.put(str, (String) n02VarB2.A);
                return;
            }
            ieVar5.put(str, null);
            this.z0.put(str, null);
            this.y0.put(str, null);
            this.A0.put(str, null);
            ieVar.put(str, null);
            ieVar4.put(str, null);
            ieVar3.put(str, null);
            ieVar2.put(str, null);
            this.C0.put(str, null);
        }
    }

    public final void c1(String str, h65 h65Var) {
        k85 k85Var = (k85) this.f;
        HashSet hashSet = new HashSet();
        ie ieVar = new ie(0);
        ie ieVar2 = new ie(0);
        ie ieVar3 = new ie(0);
        Iterator it = DesugarCollections.unmodifiableList(((j65) h65Var.f).x()).iterator();
        while (it.hasNext()) {
            hashSet.add(((c65) it.next()).n());
        }
        for (int i = 0; i < ((j65) h65Var.f).s(); i++) {
            e65 e65Var = (e65) ((j65) h65Var.f).t(i).g();
            if (e65Var.h().isEmpty()) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.C0.a("EventConfig contained null event name");
            } else {
                String strH = e65Var.h();
                String strZ = n12.Z(e65Var.h(), xb5.Z, xb5.z0);
                if (!TextUtils.isEmpty(strZ)) {
                    e65Var.c();
                    ((f65) e65Var.f).u(strZ);
                    h65Var.c();
                    ((j65) h65Var.f).F(i, (f65) e65Var.e());
                }
                if (((f65) e65Var.f).o() && ((f65) e65Var.f).p()) {
                    ieVar.put(strH, Boolean.TRUE);
                }
                if (((f65) e65Var.f).q() && ((f65) e65Var.f).r()) {
                    ieVar2.put(e65Var.h(), Boolean.TRUE);
                }
                if (((f65) e65Var.f).s()) {
                    if (((f65) e65Var.f).t() < 2 || ((f65) e65Var.f).t() > 65535) {
                        t65 t65Var2 = k85Var.Y;
                        k85.h(t65Var2);
                        t65Var2.C0.c("Invalid sampling rate. Event name, sample rate", e65Var.h(), Integer.valueOf(((f65) e65Var.f).t()));
                    } else {
                        ieVar3.put(e65Var.h(), Integer.valueOf(((f65) e65Var.f).t()));
                    }
                }
            }
        }
        this.y0.put(str, hashSet);
        this.z0.put(str, ieVar);
        this.A0.put(str, ieVar2);
        this.C0.put(str, ieVar3);
    }

    public final void d1(String str, j65 j65Var) {
        k85 k85Var = (k85) this.f;
        int iW = j65Var.w();
        bf3 bf3Var = this.D0;
        if (iW == 0) {
            bf3Var.m(str);
            return;
        }
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        t65Var.H0.b(Integer.valueOf(j65Var.w()), "EES programs found");
        int i = 0;
        h95 h95Var = (h95) j65Var.v().get(0);
        try {
            l35 l35Var = new l35();
            ih4 ih4Var = l35Var.a;
            ((HashMap) ((jf4) ih4Var.d).f).put("internal.remoteConfig", new s75(this, str, 2));
            ((HashMap) ((jf4) ih4Var.d).f).put("internal.appMetadata", new s75(this, str, i));
            ((HashMap) ((jf4) ih4Var.d).f).put("internal.logger", new vq1(1, this));
            l35Var.b(h95Var);
            bf3Var.l(str, l35Var);
            k85.h(t65Var);
            q65 q65Var = t65Var.H0;
            q65Var.c("EES program loaded for appId, activities", str, Integer.valueOf(h95Var.o().o()));
            for (d95 d95Var : h95Var.o().n()) {
                k85.h(t65Var);
                q65Var.b(d95Var.n(), "EES program activity");
            }
        } catch (c45 unused) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.b(str, "Failed to load EES program. appId");
        }
    }

    public final j65 e1(String str, byte[] bArr) {
        k85 k85Var = (k85) this.f;
        if (bArr == null) {
            return j65.E();
        }
        try {
            j65 j65Var = (j65) ((h65) z65.I1(j65.D(), bArr)).e();
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.H0.c("Parsed config. version, gmp_app_id", j65Var.n() ? Long.valueOf(j65Var.o()) : null, j65Var.p() ? j65Var.q() : null);
            return j65Var;
        } catch (RuntimeException e) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.C0.c("Unable to merge remote config. appId", t65.Z0(str), e);
            return j65.E();
        } catch (pc5 e2) {
            t65 t65Var3 = k85Var.Y;
            k85.h(t65Var3);
            t65Var3.C0.c("Unable to merge remote config. appId", t65.Z0(str), e2);
            return j65.E();
        }
    }

    public final j65 h1(String str) {
        W0();
        V0();
        tj4.f(str);
        b1(str);
        return (j65) this.B0.get(str);
    }

    public final String i1(String str) {
        V0();
        b1(str);
        return (String) this.F0.get(str);
    }

    @Override // defpackage.w15
    public final String j0(String str, String str2) {
        V0();
        b1(str);
        Map map = (Map) this.Z.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0413, code lost:
    
        if (r5.t() == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0415, code lost:
    
        r0 = java.lang.Boolean.valueOf(r5.u());
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x041e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x041f, code lost:
    
        r7.put("session_scoped", r0);
        r7.put("data", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0431, code lost:
    
        if (r9.K1().insertWithOnConflict("property_filters", null, r7, 5) != (-1)) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0433, code lost:
    
        r0 = r14.Y;
        defpackage.k85.h(r0);
        r0.z0.b(defpackage.t65.Z0(r29), "Failed to insert property filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0444, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0446, code lost:
    
        r1 = r23;
        r0 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x044c, code lost:
    
        r1 = r14.Y;
        defpackage.k85.h(r1);
        r1.z0.c("Error storing property filter. appId", defpackage.t65.Z0(r29), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x045c, code lost:
    
        r9.W0();
        r9.V0();
        defpackage.tj4.f(r29);
        r0 = r9.K1();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r29, java.lang.String.valueOf(r26)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r29, java.lang.String.valueOf(r26)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x047f, code lost:
    
        r1 = r24;
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x061c, code lost:
    
        r24.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x061f, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0262, code lost:
    
        r6 = r0.p().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x026e, code lost:
    
        if (r6.hasNext() == false) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x027a, code lost:
    
        if (((defpackage.m55) r6.next()).n() != false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x027c, code lost:
    
        r0 = r14.Y;
        defpackage.k85.h(r0);
        r0.C0.c("Property filter with no ID. Audience definition ignored. appId, audienceId", defpackage.t65.Z0(r29), java.lang.Integer.valueOf(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0292, code lost:
    
        r6 = r0.s().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x029e, code lost:
    
        r23 = r0;
        r0 = "audience_id";
        r24 = r1;
        r1 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x02ae, code lost:
    
        if (r6.hasNext() == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x02b0, code lost:
    
        r7 = (defpackage.f55) r6.next();
        r9.W0();
        r9.V0();
        defpackage.tj4.f(r29);
        defpackage.tj4.i(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x02ca, code lost:
    
        if (r7.p().isEmpty() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02cc, code lost:
    
        r0 = r14.Y;
        defpackage.k85.h(r0);
        r0 = r0.C0;
        r4 = defpackage.t65.Z0(r29);
        r6 = java.lang.Integer.valueOf(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x02e1, code lost:
    
        if (r7.n() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02e3, code lost:
    
        r21 = java.lang.Integer.valueOf(r7.o());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02ee, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02f1, code lost:
    
        r21 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02f3, code lost:
    
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r4, r6, java.lang.String.valueOf(r21));
        r25 = r3;
        r26 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0300, code lost:
    
        r25 = r3;
        r3 = r7.a();
        r26 = r5;
        r5 = new android.content.ContentValues();
        r5.put("app_id", r29);
        r5.put("audience_id", java.lang.Integer.valueOf(r26));
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x031b, code lost:
    
        if (r7.n() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x031d, code lost:
    
        r0 = java.lang.Integer.valueOf(r7.o());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0326, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0327, code lost:
    
        r5.put("filter_id", r0);
        r5.put("event_name", r7.p());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0337, code lost:
    
        if (r7.x() == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0339, code lost:
    
        r0 = java.lang.Boolean.valueOf(r7.y());
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0342, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0343, code lost:
    
        r5.put("session_scoped", r0);
        r5.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0355, code lost:
    
        if (r9.K1().insertWithOnConflict("event_filters", null, r5, 5) != (-1)) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0357, code lost:
    
        r0 = r14.Y;
        defpackage.k85.h(r0);
        r0.z0.b(defpackage.t65.Z0(r29), "Failed to insert event filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0367, code lost:
    
        r0 = r23;
        r1 = r24;
        r3 = r25;
        r5 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0371, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0372, code lost:
    
        r1 = r14.Y;
        defpackage.k85.h(r1);
        r1.z0.c("Error storing event filter. appId", defpackage.t65.Z0(r29), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0384, code lost:
    
        r25 = r3;
        r26 = r5;
        r3 = r23.p().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0394, code lost:
    
        if (r3.hasNext() == false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0396, code lost:
    
        r5 = (defpackage.m55) r3.next();
        r9.W0();
        r9.V0();
        defpackage.tj4.f(r29);
        defpackage.tj4.i(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x03b0, code lost:
    
        if (r5.p().isEmpty() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x03b2, code lost:
    
        r0 = r14.Y;
        defpackage.k85.h(r0);
        r0 = r0.C0;
        r3 = defpackage.t65.Z0(r29);
        r4 = java.lang.Integer.valueOf(r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x03c7, code lost:
    
        if (r5.n() == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x03c9, code lost:
    
        r5 = java.lang.Integer.valueOf(r5.o());
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03d2, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03d3, code lost:
    
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r3, r4, java.lang.String.valueOf(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x03dc, code lost:
    
        r6 = r5.a();
        r7 = new android.content.ContentValues();
        r7.put(r1, r29);
        r23 = r1;
        r7.put(r0, java.lang.Integer.valueOf(r26));
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x03f5, code lost:
    
        if (r5.n() == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x03f7, code lost:
    
        r1 = java.lang.Integer.valueOf(r5.o());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0400, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0401, code lost:
    
        r7.put("filter_id", r1);
        r27 = r0;
        r7.put("property_name", r5.p());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j1(String str, String str2, String str3, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        h65 h65Var;
        byte[] bArrA;
        boolean z;
        W0();
        V0();
        tj4.f(str);
        h65 h65Var2 = (h65) e1(str, bArr).g();
        c1(str, h65Var2);
        d1(str, (j65) h65Var2.e());
        j65 j65Var = (j65) h65Var2.e();
        ie ieVar = this.B0;
        ieVar.put(str, j65Var);
        this.F0.put(str, ((j65) h65Var2.f).y());
        this.G0.put(str, str2);
        this.H0.put(str, str3);
        this.Z.put(str, f1((j65) h65Var2.e()));
        ff5 ff5Var = this.X;
        m25 m25Var = ff5Var.z;
        ff5.R(m25Var);
        ArrayList<d55> arrayList = new ArrayList(DesugarCollections.unmodifiableList(((j65) h65Var2.f).u()));
        k85 k85Var = (k85) m25Var.f;
        int i = 0;
        while (i < arrayList.size()) {
            c55 c55Var = (c55) ((d55) arrayList.get(i)).g();
            ie ieVar2 = ieVar;
            if (((d55) c55Var.f).t() != 0) {
                int i2 = 0;
                while (i2 < ((d55) c55Var.f).t()) {
                    e55 e55Var = (e55) ((d55) c55Var.f).u(i2).g();
                    e55 e55Var2 = (e55) e55Var.clone();
                    ff5 ff5Var2 = ff5Var;
                    h65 h65Var3 = h65Var2;
                    String strZ = n12.Z(((f55) e55Var.f).p(), xb5.Z, xb5.z0);
                    if (strZ != null) {
                        e55Var2.c();
                        ((f55) e55Var2.f).A(strZ);
                        z = true;
                    } else {
                        z = false;
                    }
                    int i3 = 0;
                    while (i3 < ((f55) e55Var.f).r()) {
                        h55 h55VarS = ((f55) e55Var.f).s(i3);
                        boolean z2 = z;
                        e55 e55Var3 = e55Var;
                        String strZ2 = n12.Z(h55VarS.u(), je.X, je.Y);
                        if (strZ2 != null) {
                            g55 g55Var = (g55) h55VarS.g();
                            g55Var.c();
                            ((h55) g55Var.f).w(strZ2);
                            h55 h55Var = (h55) g55Var.e();
                            e55Var2.c();
                            ((f55) e55Var2.f).B(i3, h55Var);
                            z = true;
                        } else {
                            z = z2;
                        }
                        i3++;
                        e55Var = e55Var3;
                    }
                    if (z) {
                        c55Var.c();
                        ((d55) c55Var.f).w(i2, (f55) e55Var2.e());
                        arrayList.set(i, (d55) c55Var.e());
                    }
                    i2++;
                    ff5Var = ff5Var2;
                    h65Var2 = h65Var3;
                }
            }
            h65 h65Var4 = h65Var2;
            ff5 ff5Var3 = ff5Var;
            if (((d55) c55Var.f).q() != 0) {
                for (int i4 = 0; i4 < ((d55) c55Var.f).q(); i4++) {
                    m55 m55VarR = ((d55) c55Var.f).r(i4);
                    String strZ3 = n12.Z(m55VarR.p(), ye.d, ye.e);
                    if (strZ3 != null) {
                        l55 l55Var = (l55) m55VarR.g();
                        l55Var.c();
                        ((m55) l55Var.f).w(strZ3);
                        c55Var.c();
                        ((d55) c55Var.f).v(i4, (m55) l55Var.e());
                        arrayList.set(i, (d55) c55Var.e());
                    }
                }
            }
            i++;
            ieVar = ieVar2;
            ff5Var = ff5Var3;
            h65Var2 = h65Var4;
        }
        h65 h65Var5 = h65Var2;
        ie ieVar3 = ieVar;
        ff5 ff5Var4 = ff5Var;
        m25Var.W0();
        m25Var.V0();
        tj4.f(str);
        SQLiteDatabase sQLiteDatabaseK1 = m25Var.K1();
        sQLiteDatabaseK1.beginTransaction();
        try {
            m25Var.W0();
            m25Var.V0();
            tj4.f(str);
            SQLiteDatabase sQLiteDatabaseK12 = m25Var.K1();
            sQLiteDatabaseK12.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseK12.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                d55 d55Var = (d55) it.next();
                m25Var.W0();
                m25Var.V0();
                tj4.f(str);
                tj4.i(d55Var);
                if (d55Var.n()) {
                    int iO = d55Var.o();
                    Iterator it2 = d55Var.s().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (!((f55) it2.next()).n()) {
                            t65 t65Var = k85Var.Y;
                            k85.h(t65Var);
                            t65Var.C0.c("Event filter with no ID. Audience definition ignored. appId, audienceId", t65.Z0(str), Integer.valueOf(iO));
                            break;
                        }
                    }
                } else {
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.C0.b(t65.Z0(str), "Audience with no ID. appId");
                }
            }
            sQLiteDatabase = sQLiteDatabaseK1;
            ArrayList arrayList2 = new ArrayList();
            for (d55 d55Var2 : arrayList) {
                arrayList2.add(d55Var2.n() ? Integer.valueOf(d55Var2.o()) : null);
            }
            tj4.f(str);
            m25Var.W0();
            m25Var.V0();
            SQLiteDatabase sQLiteDatabaseK13 = m25Var.K1();
            try {
                long jF1 = m25Var.F1("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int iMax = Math.max(0, Math.min(2000, k85Var.A.d1(str, r55.V)));
                if (jF1 > iMax) {
                    ArrayList arrayList3 = new ArrayList();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= arrayList2.size()) {
                            String strJoin = TextUtils.join(",", arrayList3);
                            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
                            sb.append("(");
                            sb.append(strJoin);
                            sb.append(")");
                            String string = sb.toString();
                            StringBuilder sb2 = new StringBuilder(string.length() + 140);
                            sb2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
                            sb2.append(string);
                            sb2.append(" order by rowid desc limit -1 offset ?)");
                            sQLiteDatabaseK13.delete("audience_filter_values", sb2.toString(), new String[]{str, Integer.toString(iMax)});
                            break;
                        }
                        Integer num = (Integer) arrayList2.get(i5);
                        if (num == null) {
                            break;
                        }
                        arrayList3.add(Integer.toString(num.intValue()));
                        i5++;
                    }
                }
            } catch (SQLiteException e) {
                t65 t65Var3 = k85Var.Y;
                k85.h(t65Var3);
                t65Var3.z0.c("Database error querying filters. appId", t65.Z0(str), e);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            try {
                h65Var5.c();
                h65Var = h65Var5;
            } catch (RuntimeException e2) {
                e = e2;
                h65Var = h65Var5;
            }
            try {
                ((j65) h65Var.f).G();
                bArrA = ((j65) h65Var.e()).a();
            } catch (RuntimeException e3) {
                e = e3;
                t65 t65Var4 = ((k85) this.f).Y;
                k85.h(t65Var4);
                t65Var4.C0.c("Unable to serialize reduced-size config. Storing full config instead. appId", t65.Z0(str), e);
                bArrA = bArr;
            }
            m25 m25Var2 = ff5Var4.z;
            ff5.R(m25Var2);
            k85 k85Var2 = (k85) m25Var2.f;
            tj4.f(str);
            m25Var2.V0();
            m25Var2.W0();
            ContentValues contentValues = new ContentValues();
            contentValues.put("remote_config", bArrA);
            contentValues.put("config_last_modified_time", str2);
            contentValues.put("e_tag", str3);
            try {
                if (m25Var2.K1().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                    t65 t65Var5 = k85Var2.Y;
                    k85.h(t65Var5);
                    t65Var5.z0.b(t65.Z0(str), "Failed to update remote config (got 0). appId");
                }
            } catch (SQLiteException e4) {
                t65 t65Var6 = k85Var2.Y;
                k85.h(t65Var6);
                t65Var6.z0.c("Error storing remote config. appId", t65.Z0(str), e4);
            }
            h65Var.c();
            ((j65) h65Var.f).H();
            ieVar3.put(str, (j65) h65Var.e());
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = sQLiteDatabaseK1;
        }
    }

    public final boolean k1(String str, String str2) {
        Boolean bool;
        V0();
        b1(str);
        if ("1".equals(j0(str, "measurement.upload.blacklist_internal")) && qf5.v1(str2)) {
            return true;
        }
        if ("1".equals(j0(str, "measurement.upload.blacklist_public")) && qf5.V1(str2)) {
            return true;
        }
        Map map = (Map) this.z0.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean l1(String str, String str2) {
        Boolean bool;
        V0();
        b1(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.A0.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final int m1(String str, String str2) {
        Integer num;
        V0();
        b1(str);
        Map map = (Map) this.C0.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final boolean n1(String str) {
        V0();
        b1(str);
        ie ieVar = this.y0;
        if (ieVar.get(str) != null) {
            return ((Set) ieVar.get(str)).contains("os_version") || ((Set) ieVar.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean o1(String str) {
        V0();
        b1(str);
        ie ieVar = this.y0;
        return ieVar.get(str) != null && ((Set) ieVar.get(str)).contains("app_instance_id");
    }

    public final boolean p1(String str, r95 r95Var) {
        V0();
        b1(str);
        a65 a65VarQ1 = q1(str);
        if (a65VarQ1 == null) {
            return false;
        }
        for (o55 o55Var : a65VarQ1.n()) {
            if (r95Var == g1(o55Var.n())) {
                return o55Var.o() == 2;
            }
        }
        return false;
    }

    public final a65 q1(String str) {
        V0();
        b1(str);
        j65 j65VarH1 = h1(str);
        if (j65VarH1 == null || !j65VarH1.z()) {
            return null;
        }
        return j65VarH1.A();
    }

    @Override // defpackage.pe5
    public final void Y0() {
    }
}
