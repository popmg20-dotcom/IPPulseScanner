package defpackage;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class up4 implements OnReceiveContentListener {
    public final hv2 a;

    public up4(hv2 hv2Var) {
        this.a = hv2Var;
    }

    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        td0 td0Var = new td0(new pd0(contentInfo));
        td0 td0VarD = this.a.d(view, td0Var);
        if (td0VarD == null) {
            return null;
        }
        return td0VarD == td0Var ? contentInfo : td0VarD.b();
    }
}
