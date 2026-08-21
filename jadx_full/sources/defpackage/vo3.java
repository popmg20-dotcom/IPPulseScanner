package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class vo3 extends ContextWrapper {
    public final /* synthetic */ xo3 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vo3(xo3 xo3Var, Context context) {
        super(context);
        this.a = xo3Var;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"window".equals(str)) {
            return super.getSystemService(str);
        }
        return new wo3(this.a, (WindowManager) getBaseContext().getSystemService(str));
    }
}
