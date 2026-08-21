package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lp4 implements View.OnApplyWindowInsetsListener {
    public bv4 a = null;
    public final /* synthetic */ View b;
    public final /* synthetic */ mu2 c;

    public lp4(View view, mu2 mu2Var) {
        this.b = view;
        this.c = mu2Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        bv4 bv4VarG = bv4.g(windowInsets, view);
        int i = Build.VERSION.SDK_INT;
        mu2 mu2Var = this.c;
        if (i < 30) {
            mp4.a(windowInsets, this.b);
            if (bv4VarG.equals(this.a)) {
                return mu2Var.Z(view, bv4VarG).f();
            }
        }
        this.a = bv4VarG;
        bv4 bv4VarZ = mu2Var.Z(view, bv4VarG);
        if (i >= 30) {
            return bv4VarZ.f();
        }
        WeakHashMap weakHashMap = wp4.a;
        view.requestApplyInsets();
        return bv4VarZ.f();
    }
}
