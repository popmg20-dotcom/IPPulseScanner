package defpackage;

import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class lc extends w7 {
    public final /* synthetic */ AppCompatTextView X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lc(AppCompatTextView appCompatTextView) {
        super(8, appCompatTextView);
        this.X = appCompatTextView;
    }

    @Override // defpackage.w7, defpackage.kc
    public final void e(int i) {
        super/*android.widget.TextView*/.setLastBaselineToBottomHeight(i);
    }

    @Override // defpackage.w7, defpackage.kc
    public final void g(int i) {
        super/*android.widget.TextView*/.setFirstBaselineToTopHeight(i);
    }
}
