package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class na5 implements Runnable {
    public final /* synthetic */ Bundle A;
    public final /* synthetic */ boolean X;
    public final /* synthetic */ boolean Y;
    public final /* synthetic */ boolean Z;
    public final /* synthetic */ String b;
    public final /* synthetic */ String f;
    public final /* synthetic */ ib5 y0;
    public final /* synthetic */ long z;

    public na5(ib5 ib5Var, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3) {
        this.b = str;
        this.f = str2;
        this.z = j;
        this.A = bundle;
        this.X = z;
        this.Y = z2;
        this.Z = z3;
        this.y0 = ib5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.y0.e1(this.b, this.f, this.z, this.A, this.X, this.Y, this.Z);
    }
}
