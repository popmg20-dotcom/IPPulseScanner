package defpackage;

import android.os.Looper;
import android.os.SystemClock;
import io.sentry.android.core.internal.tombstone.b;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zd5 extends u55 {
    public final ca5 A0;
    public s05 Y;
    public boolean Z;
    public final ub4 y0;
    public final b z0;

    public zd5(k85 k85Var) {
        super(k85Var);
        this.Z = true;
        this.y0 = new ub4(this);
        b bVar = new b();
        bVar.d = this;
        k85 k85Var2 = (k85) this.f;
        bVar.c = new td5(bVar, k85Var2, 0);
        k85Var2.B0.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        bVar.a = jElapsedRealtime;
        bVar.b = jElapsedRealtime;
        this.z0 = bVar;
        this.A0 = new ca5(this);
    }

    @Override // defpackage.u55
    public final boolean Y0() {
        return false;
    }

    public final void Z0() {
        V0();
        if (this.Y == null) {
            this.Y = new s05(Looper.getMainLooper(), 2);
        }
    }
}
