package defpackage;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class cg2 {
    public Object A;
    public int b;
    public int f;
    public int z;

    public cg2() {
        if (p84.f == null) {
            p84.f = new p84(3);
        }
    }

    public int a(int i) {
        if (i < this.z) {
            return ((ByteBuffer) this.A).getShort(this.f + i);
        }
        return 0;
    }

    public void b() {
        if (((dg2) this.A).y0 != this.z) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object c(View view);

    public abstract void d(View view, Object obj);

    public void e() {
        while (true) {
            int i = this.b;
            dg2 dg2Var = (dg2) this.A;
            if (i >= dg2Var.Y || dg2Var.z[i] >= 0) {
                return;
            } else {
                this.b = i + 1;
            }
        }
    }

    public void f(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.f) {
            d(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f) {
            tag = c(view);
        } else {
            tag = view.getTag(this.b);
            if (!((Class) this.A).isInstance(tag)) {
                tag = null;
            }
        }
        if (g(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateE = wp4.e(view);
            h2 h2Var = accessibilityDelegateE != null ? accessibilityDelegateE instanceof g2 ? ((g2) accessibilityDelegateE).a : new h2(accessibilityDelegateE) : null;
            if (h2Var == null) {
                h2Var = new h2();
            }
            wp4.n(view, h2Var);
            view.setTag(this.b, obj);
            wp4.i(view, this.z);
        }
    }

    public abstract boolean g(Object obj, Object obj2);

    public boolean hasNext() {
        return this.b < ((dg2) this.A).Y;
    }

    public void remove() {
        dg2 dg2Var = (dg2) this.A;
        b();
        if (this.f == -1) {
            xe.q("Call next() before removing element from the iterator.");
            return;
        }
        dg2Var.c();
        dg2Var.k(this.f);
        this.f = -1;
        this.z = dg2Var.y0;
    }
}
