package defpackage;

import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ll0 {
    public static final ThreadLocal b = new ThreadLocal();
    public final TextPaint a;

    public ll0() {
        TextPaint textPaint = new TextPaint();
        this.a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
