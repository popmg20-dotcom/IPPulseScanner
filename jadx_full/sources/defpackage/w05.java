package defpackage;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w05 extends m35 {
    public final k85 a;
    public final ib5 b;

    public w05(k85 k85Var) {
        tj4.i(k85Var);
        this.a = k85Var;
        ib5 ib5Var = k85Var.D0;
        k85.g(ib5Var);
        this.b = ib5Var;
    }

    @Override // defpackage.jb5
    public final void b(String str, String str2, Bundle bundle) {
        ib5 ib5Var = this.b;
        ((k85) ib5Var.f).B0.getClass();
        ib5Var.a1(str, str2, bundle, true, true, System.currentTimeMillis());
    }

    @Override // defpackage.jb5
    public final String c() {
        yb5 yb5Var = ((k85) this.b.f).C0;
        k85.g(yb5Var);
        rb5 rb5Var = yb5Var.Y;
        if (rb5Var != null) {
            return rb5Var.a;
        }
        return null;
    }

    @Override // defpackage.jb5
    public final String d() {
        yb5 yb5Var = ((k85) this.b.f).C0;
        k85.g(yb5Var);
        rb5 rb5Var = yb5Var.Y;
        if (rb5Var != null) {
            return rb5Var.b;
        }
        return null;
    }

    @Override // defpackage.jb5
    public final void e(Bundle bundle) {
        ib5 ib5Var = this.b;
        ((k85) ib5Var.f).B0.getClass();
        ib5Var.i1(bundle, System.currentTimeMillis());
    }

    @Override // defpackage.jb5
    public final void f(String str) {
        k85 k85Var = this.a;
        d45 d45Var = k85Var.E0;
        k85.e(d45Var);
        k85Var.B0.getClass();
        d45Var.X0(SystemClock.elapsedRealtime(), str);
    }

    @Override // defpackage.jb5
    public final void g(String str) {
        k85 k85Var = this.a;
        d45 d45Var = k85Var.E0;
        k85.e(d45Var);
        k85Var.B0.getClass();
        d45Var.W0(SystemClock.elapsedRealtime(), str);
    }

    @Override // defpackage.jb5
    public final long h() {
        qf5 qf5Var = this.a.z0;
        k85.f(qf5Var);
        return qf5Var.T1();
    }

    @Override // defpackage.jb5
    public final void i(String str, String str2, Bundle bundle) {
        ib5 ib5Var = this.a.D0;
        k85.g(ib5Var);
        ib5Var.j1(str, str2, bundle);
    }

    @Override // defpackage.jb5
    public final List j(String str, String str2) {
        ib5 ib5Var = this.b;
        k85 k85Var = (k85) ib5Var.f;
        f85 f85Var = k85Var.Z;
        t65 t65Var = k85Var.Y;
        k85.h(f85Var);
        if (f85Var.b1()) {
            k85.h(t65Var);
            t65Var.z0.a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        if (d84.j()) {
            k85.h(t65Var);
            t65Var.z0.a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        f85 f85Var2 = k85Var.Z;
        k85.h(f85Var2);
        f85Var2.f1(atomicReference, 5000L, "get conditional user properties", new d20(ib5Var, atomicReference, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return qf5.M1(list);
        }
        k85.h(t65Var);
        t65Var.z0.b(null, "Timed out waiting for get conditional user properties");
        return new ArrayList();
    }

    @Override // defpackage.jb5
    public final int k(String str) {
        ib5 ib5Var = this.b;
        ib5Var.getClass();
        tj4.f(str);
        x15 x15Var = ((k85) ib5Var.f).A;
        return 25;
    }

    @Override // defpackage.jb5
    public final String l() {
        return (String) this.b.A0.get();
    }

    @Override // defpackage.jb5
    public final String m() {
        return this.b.k1();
    }

    @Override // defpackage.jb5
    public final Map n(String str, String str2, boolean z) {
        ib5 ib5Var = this.b;
        k85 k85Var = (k85) ib5Var.f;
        f85 f85Var = k85Var.Z;
        t65 t65Var = k85Var.Y;
        k85.h(f85Var);
        if (f85Var.b1()) {
            k85.h(t65Var);
            t65Var.z0.a("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        if (d84.j()) {
            k85.h(t65Var);
            t65Var.z0.a("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        f85 f85Var2 = k85Var.Z;
        k85.h(f85Var2);
        f85Var2.f1(atomicReference, 5000L, "get user properties", new ia5(ib5Var, atomicReference, str, str2, z));
        List<kf5> list = (List) atomicReference.get();
        if (list == null) {
            k85.h(t65Var);
            t65Var.z0.b(Boolean.valueOf(z), "Timed out waiting for handle get user properties, includeInternal");
            return Collections.EMPTY_MAP;
        }
        ie ieVar = new ie(list.size());
        for (kf5 kf5Var : list) {
            Object objA = kf5Var.a();
            if (objA != null) {
                ieVar.put(kf5Var.f, objA);
            }
        }
        return ieVar;
    }
}
