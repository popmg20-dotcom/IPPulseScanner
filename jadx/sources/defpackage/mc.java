package defpackage;

import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mc extends lc {
    public final /* synthetic */ AppCompatTextView Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mc(AppCompatTextView appCompatTextView) {
        super(appCompatTextView);
        this.Y = appCompatTextView;
    }

    @Override // defpackage.w7, defpackage.kc
    public final void k(int i, float f) {
        super/*android.widget.TextView*/.setLineHeight(i, f);
    }
}
