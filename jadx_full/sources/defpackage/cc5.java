package defpackage;

import android.os.Parcel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cc5 extends b35 implements b65 {
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ dd5 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc5(dd5 dd5Var, AtomicReference atomicReference) {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
        this.c = atomicReference;
        this.d = dd5Var;
    }

    @Override // defpackage.b35
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i != 2) {
            return false;
        }
        ne5 ne5Var = (ne5) d35.a(parcel, ne5.CREATOR);
        d35.d(parcel);
        v(ne5Var);
        return true;
    }

    @Override // defpackage.b65
    public final void v(ne5 ne5Var) {
        AtomicReference atomicReference = this.c;
        synchronized (atomicReference) {
            t65 t65Var = ((k85) this.d.f).Y;
            k85.h(t65Var);
            t65Var.H0.b(Integer.valueOf(ne5Var.b.size()), "[sgtm] Got upload batches from service. count");
            atomicReference.set(ne5Var);
            atomicReference.notifyAll();
        }
    }
}
