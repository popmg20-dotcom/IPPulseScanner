package androidx.work;

import android.content.Context;
import defpackage.d02;
import defpackage.n12;
import defpackage.na0;
import defpackage.ue2;
import defpackage.wl3;
import defpackage.xw4;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class WorkManagerInitializer implements d02 {
    public static final String a = ue2.i("WrkMgrInitializer");

    @Override // defpackage.d02
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // defpackage.d02
    public final Object b(Context context) {
        ue2.g().a(a, "Initializing WorkManager with default configuration.");
        na0 na0Var = new na0(new wl3(13));
        context.getClass();
        synchronized (xw4.m) {
            try {
                xw4 xw4Var = xw4.k;
                if (xw4Var != null && xw4.l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (xw4Var == null) {
                    Context applicationContext = context.getApplicationContext();
                    xw4 xw4VarU = xw4.l;
                    if (xw4VarU == null) {
                        xw4VarU = n12.u(applicationContext, na0Var);
                        xw4.l = xw4VarU;
                    }
                    xw4.k = xw4VarU;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xw4.c(context);
    }
}
