package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.viewpager2.widget.ViewPager2;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jf4 implements lk2, z2, rk, dv2, s54, cd5, of5 {
    public final /* synthetic */ int b;
    public final Object f;

    public jf4(int i) {
        this.b = i;
        switch (i) {
            case 6:
                this.f = new HashMap();
                break;
            default:
                this.f = new CountDownLatch(1);
                break;
        }
    }

    @Override // defpackage.lk2
    public boolean V(nk2 nk2Var, sk2 sk2Var) {
        switch (this.b) {
            case 0:
                return false;
            default:
                ((ka2) this.f).a(sk2Var);
                return true;
        }
    }

    @Override // defpackage.rk
    public void a(ab0 ab0Var) {
        ((sp1) this.f).a(ab0Var);
    }

    @Override // defpackage.lk2
    public void a0(nk2 nk2Var) {
        switch (this.b) {
            case 0:
                kf4 kf4Var = (kf4) this.f;
                boolean zR = kf4Var.l.a.r();
                Window.Callback callback = kf4Var.m;
                if (zR) {
                    callback.onPanelClosed(108, nk2Var);
                } else if (callback.onPreparePanel(0, null, nk2Var)) {
                    callback.onMenuOpened(108, nk2Var);
                }
                break;
            default:
                nk2Var.getClass();
                break;
        }
    }

    @Override // defpackage.of5
    public void b(String str, String str2, Bundle bundle) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        ff5 ff5Var = (ff5) this.f;
        if (!zIsEmpty) {
            ff5Var.C().e1(new d20(this, str, str2, bundle, 10));
            return;
        }
        k85 k85Var = ff5Var.C0;
        if (k85Var != null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.b(str2, "AppId not known when logging event");
        }
    }

    @Override // defpackage.dv2
    public void c() {
        ((CountDownLatch) this.f).countDown();
    }

    @Override // defpackage.z2
    public boolean d(View view) {
        ih4 ih4Var = (ih4) this.f;
        int currentItem = ((ViewPager2) view).getCurrentItem() - 1;
        ViewPager2 viewPager2 = (ViewPager2) ih4Var.d;
        if (viewPager2.L0) {
            viewPager2.d(currentItem);
        }
        return true;
    }

    @Override // defpackage.cd5
    public boolean g(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (((cd5[]) this.f)[i].g(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.s54
    public /* synthetic */ Object get() {
        Object obj = oa5.g;
        return ga5.H((Context) this.f);
    }

    @Override // defpackage.cd5
    public qd5 h(Class cls) {
        for (int i = 0; i < 2; i++) {
            cd5 cd5Var = ((cd5[]) this.f)[i];
            if (cd5Var.g(cls)) {
                return cd5Var.h(cls);
            }
        }
        vp1.n("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }

    public /* synthetic */ jf4(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }
}
