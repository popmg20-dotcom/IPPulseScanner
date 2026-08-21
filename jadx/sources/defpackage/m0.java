package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0 {
    public Object a;
    public Object b;

    public m0(int i) {
        this.b = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            ((ArrayList) this.b).add(new yx0());
        }
    }

    public static float k(int i, int i2, int i3) {
        return tj4.l((i - i2) / i3, 0.0f, 1.0f);
    }

    public void d(String str) {
        ((CopyOnWriteArraySet) this.a).add(str);
        ((CopyOnWriteArraySet) this.b).remove(str);
    }

    public abstract void e();

    public void f() {
        wa waVar = (wa) this.a;
        if (waVar != null) {
            try {
                ((za) this.b).B0.unregisterReceiver(waVar);
            } catch (IllegalArgumentException unused) {
            }
            this.a = null;
        }
    }

    public abstract IntentFilter g();

    public abstract void h(q30 q30Var, q30 q30Var2);

    public void i() {
        this.a = null;
        this.b = null;
    }

    public abstract int j();

    public MenuItem l(MenuItem menuItem) {
        if (!(menuItem instanceof b64)) {
            return menuItem;
        }
        b64 b64Var = (b64) menuItem;
        xw3 xw3Var = (xw3) this.b;
        if (xw3Var == null) {
            xw3Var = new xw3(0);
            this.b = xw3Var;
        }
        MenuItem menuItem2 = (MenuItem) xw3Var.get(b64Var);
        if (menuItem2 != null) {
            return menuItem2;
        }
        xk2 xk2Var = new xk2((Context) this.a, b64Var);
        ((xw3) this.b).put(b64Var, xk2Var);
        return xk2Var;
    }

    public abstract void m(q30 q30Var, q30 q30Var2, CharSequence charSequence);

    public abstract void n();

    public abstract void o();

    public abstract String p();

    public abstract void q(cl clVar);

    public abstract void r();

    public abstract void s();

    public void t(wd0 wd0Var, Bundle bundle) {
        this.b = wd0Var;
        s();
    }

    public void u(boolean z) {
        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.b;
        CopyOnWriteArraySet copyOnWriteArraySet2 = (CopyOnWriteArraySet) this.a;
        if (z) {
            copyOnWriteArraySet2.add("android.widget.ImageView");
            copyOnWriteArraySet.remove("android.widget.ImageView");
        } else {
            copyOnWriteArraySet.add("android.widget.ImageView");
            copyOnWriteArraySet2.remove("android.widget.ImageView");
        }
    }

    public void v(boolean z) {
        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.b;
        CopyOnWriteArraySet copyOnWriteArraySet2 = (CopyOnWriteArraySet) this.a;
        if (z) {
            copyOnWriteArraySet2.add("android.widget.TextView");
            copyOnWriteArraySet.remove("android.widget.TextView");
        } else {
            copyOnWriteArraySet.add("android.widget.TextView");
            copyOnWriteArraySet2.remove("android.widget.TextView");
        }
    }

    public void w() {
        f();
        IntentFilter intentFilterG = g();
        if (intentFilterG.countActions() == 0) {
            return;
        }
        wa waVar = (wa) this.a;
        if (waVar == null) {
            waVar = new wa(0, this);
            this.a = waVar;
        }
        ((za) this.b).B0.registerReceiver(waVar, intentFilterG);
    }

    public abstract void x();

    public abstract void y();

    public abstract void z();

    public m0(Context context) {
        this.a = context;
    }

    public m0() {
        this.a = new CopyOnWriteArraySet();
        this.b = new CopyOnWriteArraySet();
    }

    public m0(bn bnVar) {
        this.a = bnVar;
        this.b = new ed4(bnVar);
    }

    public m0(za zaVar) {
        this.b = zaVar;
    }
}
