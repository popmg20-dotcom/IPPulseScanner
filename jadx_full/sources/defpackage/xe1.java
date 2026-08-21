package defpackage;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xe1 implements ci {
    public static final AtomicReference a = new AtomicReference();

    @Override // defpackage.ci
    public final void a(boolean z) {
        synchronized (ze1.j) {
            try {
                for (ze1 ze1Var : new ArrayList(ze1.k.values())) {
                    if (ze1Var.e.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator it = ze1Var.i.iterator();
                        while (it.hasNext()) {
                            ze1 ze1Var2 = ((we1) it.next()).a;
                            if (!z) {
                                ((nl0) ze1Var2.h.get()).b();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
