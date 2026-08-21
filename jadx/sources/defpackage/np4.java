package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class np4 {
    public static bv4 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        bv4 bv4VarG = bv4.g(rootWindowInsets, null);
        yu4 yu4Var = bv4VarG.a;
        yu4Var.w(bv4VarG);
        View rootView = view.getRootView();
        yu4Var.d(rootView);
        yu4Var.o(rootView);
        yu4Var.p();
        return bv4VarG;
    }
}
