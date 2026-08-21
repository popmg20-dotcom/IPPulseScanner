package defpackage;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ub4 implements vb4, hf4, z2, qk {
    public Object b;

    public /* synthetic */ ub4(Object obj) {
        this.b = obj;
    }

    public static ub4 g(String str) {
        return new ub4((TextUtils.isEmpty(str) || str.length() > 1) ? o95.UNINITIALIZED : t95.e(str.charAt(0)));
    }

    @Override // defpackage.hf4
    public boolean a(sk2 sk2Var) {
        return ((kf4) this.b).m.onMenuItemSelected(0, sk2Var);
    }

    @Override // defpackage.qk
    public void b(int i) {
        ((rp1) this.b).b(i);
    }

    @Override // defpackage.qk
    public void c() {
        ((rp1) this.b).c();
    }

    @Override // defpackage.z2
    public boolean d(View view) {
        ih4 ih4Var = (ih4) this.b;
        int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
        ViewPager2 viewPager2 = (ViewPager2) ih4Var.d;
        if (viewPager2.L0) {
            viewPager2.d(currentItem);
        }
        return true;
    }

    public void e() {
        zd5 zd5Var = (zd5) this.b;
        zd5Var.V0();
        k85 k85Var = (k85) zd5Var.f;
        l75 l75Var = k85Var.X;
        k85.f(l75Var);
        k85Var.B0.getClass();
        if (l75Var.f1(System.currentTimeMillis())) {
            l75 l75Var2 = k85Var.X;
            k85.f(l75Var2);
            l75Var2.F0.b(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.H0.a("Detected application was in foreground");
                h(System.currentTimeMillis());
            }
        }
    }

    public void f(long j) {
        zd5 zd5Var = (zd5) this.b;
        zd5Var.V0();
        zd5Var.Z0();
        k85 k85Var = (k85) zd5Var.f;
        l75 l75Var = k85Var.X;
        k85.f(l75Var);
        if (l75Var.f1(j)) {
            k85.f(l75Var);
            l75Var.F0.b(true);
            k85Var.l().a1();
        }
        k85.f(l75Var);
        l75Var.J0.b(j);
        if (l75Var.F0.a()) {
            h(j);
        }
    }

    public void h(long j) {
        zd5 zd5Var = (zd5) this.b;
        zd5Var.V0();
        k85 k85Var = (k85) zd5Var.f;
        if (k85Var.a()) {
            l75 l75Var = k85Var.X;
            k85.f(l75Var);
            l75Var.J0.b(j);
            k85Var.B0.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.H0.b(Long.valueOf(jElapsedRealtime), "Session started, time");
            long j2 = j / 1000;
            Long lValueOf = Long.valueOf(j2);
            ib5 ib5Var = k85Var.D0;
            k85.g(ib5Var);
            ib5Var.g1(j, lValueOf, "auto", "_sid");
            k85.f(l75Var);
            l75Var.K0.b(j2);
            l75Var.F0.b(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j2);
            k85.g(ib5Var);
            ib5Var.d1(j, bundle, "auto", "_s");
            String strB = l75Var.P0.B();
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strB);
            k85.g(ib5Var);
            ib5Var.d1(j, bundle2, "auto", "_ssr");
        }
    }

    public void i(int i, Object obj, sd5 sd5Var) throws a60 {
        va5 va5Var = (va5) obj;
        kb5 kb5Var = (kb5) this.b;
        kb5Var.l((i << 3) | 2);
        kb5Var.l(va5Var.b(sd5Var));
        sd5Var.d(va5Var, kb5Var.a);
    }

    public void j(int i, Object obj, sd5 sd5Var) throws a60 {
        kb5 kb5Var = (kb5) this.b;
        kb5Var.c(i, 3);
        sd5Var.d((va5) obj, kb5Var.a);
        kb5Var.c(i, 4);
    }

    @Override // defpackage.vb4
    public byte p(int i) {
        return ((byte[]) this.b)[i];
    }

    @Override // defpackage.vb4
    public int size() {
        return ((byte[]) this.b).length;
    }
}
