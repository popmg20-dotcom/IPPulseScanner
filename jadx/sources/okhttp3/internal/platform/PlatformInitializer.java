package okhttp3.internal.platform;

import android.content.Context;
import defpackage.be0;
import defpackage.d02;
import defpackage.g41;
import defpackage.k13;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class PlatformInitializer implements d02 {
    @Override // defpackage.d02
    public final List a() {
        return g41.b;
    }

    @Override // defpackage.d02
    public final Object b(Context context) {
        context.getClass();
        k13 k13Var = k13.a;
        Object obj = k13.a;
        be0 be0Var = obj != null ? (be0) obj : null;
        if (be0Var != null) {
            be0Var.a(context);
        }
        return k13.a;
    }
}
