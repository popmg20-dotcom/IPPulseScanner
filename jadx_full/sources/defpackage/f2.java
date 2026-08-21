package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f2 extends ClickableSpan {
    public final int b;
    public final p2 f;
    public final int z;

    public f2(int i, p2 p2Var, int i2) {
        this.b = i;
        this.f = p2Var;
        this.z = i2;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.b);
        this.f.a.performAction(this.z, bundle);
    }
}
