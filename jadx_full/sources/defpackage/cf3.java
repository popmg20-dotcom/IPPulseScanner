package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cf3 implements xx3 {
    public final View a;

    public cf3(ImageView imageView) {
        this.a = imageView;
    }

    @Override // defpackage.xx3
    public final Object a(re3 re3Var) {
        wx3 wx3VarL = qe4.l(this);
        if (wx3VarL != null) {
            return wx3VarL;
        }
        z00 z00Var = new z00(1, p95.u(re3Var));
        z00Var.w();
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        gr4 gr4Var = new gr4(this, viewTreeObserver, z00Var);
        viewTreeObserver.addOnPreDrawListener(gr4Var);
        z00Var.y(new fr4(0, this, viewTreeObserver, gr4Var));
        return z00Var.u();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cf3) {
            return n12.c(this.a, ((cf3) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + 1231;
    }
}
