package defpackage;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dc extends ji0 {
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;
    public final /* synthetic */ WeakReference j;
    public final /* synthetic */ jc k;

    public dc(jc jcVar, int i, int i2, WeakReference weakReference) {
        this.k = jcVar;
        this.h = i;
        this.i = i2;
        this.j = weakReference;
    }

    @Override // defpackage.ji0
    public final void F(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.h) != -1) {
            typeface = ic.a(typeface, i, (this.i & 2) != 0);
        }
        jc jcVar = this.k;
        if (jcVar.m) {
            jcVar.l = typeface;
            TextView textView = (TextView) this.j.get();
            if (textView != null) {
                boolean zIsAttachedToWindow = textView.isAttachedToWindow();
                int i2 = jcVar.j;
                if (zIsAttachedToWindow) {
                    textView.post(new ec(textView, typeface, i2));
                } else {
                    textView.setTypeface(typeface, i2);
                }
            }
        }
    }

    @Override // defpackage.ji0
    public final void E(int i) {
    }
}
