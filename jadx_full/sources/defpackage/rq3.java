package defpackage;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rq3 implements sq3 {
    public final ScrollFeedbackProvider b;

    public rq3(NestedScrollView nestedScrollView) {
        this.b = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // defpackage.sq3
    public final void onScrollLimit(int i, int i2, int i3, boolean z) {
        this.b.onScrollLimit(i, i2, i3, z);
    }

    @Override // defpackage.sq3
    public final void onScrollProgress(int i, int i2, int i3, int i4) {
        this.b.onScrollProgress(i, i2, i3, i4);
    }
}
