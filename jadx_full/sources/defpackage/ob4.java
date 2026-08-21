package defpackage;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ob4 {
    public float c;
    public float d;
    public final WeakReference f;
    public kb4 g;
    public final TextPaint a = new TextPaint(1);
    public final l40 b = new l40(1, this);
    public boolean e = true;

    public ob4(nb4 nb4Var) {
        this.f = new WeakReference(null);
        this.f = new WeakReference(nb4Var);
    }

    public final void a(String str) {
        TextPaint textPaint = this.a;
        this.c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        this.d = str != null ? Math.abs(textPaint.getFontMetrics().ascent) : 0.0f;
        this.e = false;
    }

    public final void b(kb4 kb4Var, Context context) {
        if (this.g != kb4Var) {
            this.g = kb4Var;
            WeakReference weakReference = this.f;
            if (kb4Var != null) {
                TextPaint textPaint = this.a;
                l40 l40Var = this.b;
                kb4Var.e(context, textPaint, l40Var);
                nb4 nb4Var = (nb4) weakReference.get();
                if (nb4Var != null) {
                    textPaint.drawableState = nb4Var.getState();
                }
                kb4Var.d(context, textPaint, l40Var);
                this.e = true;
            }
            nb4 nb4Var2 = (nb4) weakReference.get();
            if (nb4Var2 != null) {
                nb4Var2.a();
                nb4Var2.onStateChange(nb4Var2.getState());
            }
        }
    }
}
