package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q35 extends b35 implements v35 {
    public final AtomicReference c;
    public boolean d;

    public q35() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        this.c = new AtomicReference();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
    
        r3 = r3.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(android.os.Bundle r3, java.lang.Class r4) {
        /*
            if (r3 == 0) goto L2a
            java.lang.String r0 = "r"
            java.lang.Object r3 = r3.get(r0)
            if (r3 == 0) goto L2a
            java.lang.Object r3 = r4.cast(r3)     // Catch: java.lang.ClassCastException -> Lf
            return r3
        Lf:
            r0 = move-exception
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getCanonicalName()
            java.lang.String r1 = "Unexpected object type. Expected, Received: "
            java.lang.String r2 = ", "
            java.lang.String r3 = defpackage.fw.u(r1, r4, r2, r3)
            java.lang.String r4 = "AM"
            io.sentry.android.core.a1.o(r4, r3, r0)
            throw r0
        L2a:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q35.c(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    @Override // defpackage.b35
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) d35.a(parcel, Bundle.CREATOR);
        d35.d(parcel);
        t(bundle);
        parcel2.writeNoException();
        return true;
    }

    public final Bundle b(long j) {
        Bundle bundle;
        AtomicReference atomicReference = this.c;
        synchronized (atomicReference) {
            if (!this.d) {
                try {
                    atomicReference.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.c.get();
        }
        return bundle;
    }

    @Override // defpackage.v35
    public final void t(Bundle bundle) {
        AtomicReference atomicReference = this.c;
        synchronized (atomicReference) {
            try {
                try {
                    atomicReference.set(bundle);
                    this.d = true;
                } finally {
                    this.c.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
