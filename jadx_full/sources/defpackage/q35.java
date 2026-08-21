package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import io.sentry.android.core.a1;
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
    */
    public static final Object c(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            a1.o("AM", fw.u("Unexpected object type. Expected, Received: ", cls.getCanonicalName(), ", ", obj.getClass().getCanonicalName()), e);
            throw e;
        }
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
