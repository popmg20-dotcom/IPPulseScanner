package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k02 extends InputConnectionWrapper {
    public final /* synthetic */ jd a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k02(InputConnection inputConnection, jd jdVar) {
        super(inputConnection, false);
        this.a = jdVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        wn1 wn1Var = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            wn1Var = new wn1(2, new m02(inputContentInfo));
        }
        if (this.a.b(wn1Var, i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
