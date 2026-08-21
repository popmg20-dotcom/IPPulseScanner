package defpackage;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wv0 implements xx3 {
    public final Context a;

    public wv0(Context context) {
        this.a = context;
    }

    @Override // defpackage.xx3
    public final Object a(re3 re3Var) {
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        qu0 qu0Var = new qu0(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new wx3(qu0Var, qu0Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof wv0) {
            return n12.c(this.a, ((wv0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
