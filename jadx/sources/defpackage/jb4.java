package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jb4 extends ke0 {
    public final /* synthetic */ Context e;
    public final /* synthetic */ TextPaint f;
    public final /* synthetic */ ke0 g;
    public final /* synthetic */ kb4 h;

    public jb4(kb4 kb4Var, Context context, TextPaint textPaint, ke0 ke0Var) {
        this.h = kb4Var;
        this.e = context;
        this.f = textPaint;
        this.g = ke0Var;
    }

    @Override // defpackage.ke0
    public final void o(int i) {
        this.g.o(i);
    }

    @Override // defpackage.ke0
    public final void p(Typeface typeface, boolean z) {
        this.h.f(this.e, this.f, typeface);
        this.g.p(typeface, z);
    }
}
