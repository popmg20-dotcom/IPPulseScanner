package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dr4 {
    public Interpolator c;
    public er4 d;
    public boolean e;
    public long b = -1;
    public final lf4 f = new lf4(this);
    public final ArrayList a = new ArrayList();

    public final void a() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((cr4) it.next()).b();
            }
            this.e = false;
        }
    }

    public final void b() {
        View view;
        if (this.e) {
            return;
        }
        for (cr4 cr4Var : this.a) {
            long j = this.b;
            if (j >= 0) {
                cr4Var.c(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null && (view = (View) cr4Var.a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.d != null) {
                cr4Var.d(this.f);
            }
            View view2 = (View) cr4Var.a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.e = true;
    }
}
