package defpackage;

import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sg0 extends y41 {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sg0(x41 x41Var, int i) {
        super(x41Var);
        this.e = i;
    }

    @Override // defpackage.y41
    public void q() {
        switch (this.e) {
            case 0:
                x41 x41Var = this.b;
                x41Var.I0 = null;
                CheckableImageButton checkableImageButton = x41Var.A0;
                checkableImageButton.setOnLongClickListener(null);
                v02.G(checkableImageButton, null);
                break;
        }
    }
}
