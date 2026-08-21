package defpackage;

import android.text.TextUtils;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fa4 {
    public CharSequence a;
    public int b;
    public View c;
    public TabLayout d;
    public ga4 e;

    public final void a(String str) {
        if (TextUtils.isEmpty(null) && !TextUtils.isEmpty(str)) {
            this.e.setContentDescription(str);
        }
        this.a = str;
        ga4 ga4Var = this.e;
        if (ga4Var != null) {
            ga4Var.d();
        }
    }
}
