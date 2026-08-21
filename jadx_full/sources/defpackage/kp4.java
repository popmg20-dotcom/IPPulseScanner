package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class kp4 {
    public static WindowInsets a(View view, WindowInsets windowInsets) {
        int i = cq4.a;
        return view.dispatchApplyWindowInsets(windowInsets);
    }
}
