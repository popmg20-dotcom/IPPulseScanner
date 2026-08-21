package defpackage;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p45 extends b35 implements x35 {
    public final /* synthetic */ tm1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p45(l45 l45Var, tm1 tm1Var) {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
        this.c = tm1Var;
    }

    @Override // defpackage.b35
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i != 2) {
            return false;
        }
        d();
        return true;
    }

    @Override // defpackage.x35
    public final void d() {
        this.c.run();
    }
}
