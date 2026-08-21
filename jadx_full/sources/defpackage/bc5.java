package defpackage;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bc5 extends b35 implements y55 {
    public final /* synthetic */ AtomicReference c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc5(dd5 dd5Var, AtomicReference atomicReference) {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
        this.c = atomicReference;
    }

    @Override // defpackage.b35
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i != 2) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(ee5.CREATOR);
        d35.d(parcel);
        x(arrayListCreateTypedArrayList);
        return true;
    }

    @Override // defpackage.y55
    public final void x(List list) {
        AtomicReference atomicReference = this.c;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
