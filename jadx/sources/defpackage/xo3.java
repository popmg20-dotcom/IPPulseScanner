package defpackage;

import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xo3 extends ContextWrapper {
    public static final /* synthetic */ int a = 0;

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return new vo3(this, getBaseContext().getApplicationContext());
    }
}
