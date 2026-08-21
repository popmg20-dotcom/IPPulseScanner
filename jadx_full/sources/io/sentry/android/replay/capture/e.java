package io.sentry.android.replay.capture;

import defpackage.am1;
import io.sentry.android.replay.v;
import io.sentry.protocol.w;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ w A;
    public final /* synthetic */ v X;
    public final /* synthetic */ am1 Y;
    public final /* synthetic */ d Z;
    public final /* synthetic */ int b;
    public final /* synthetic */ long f;
    public final /* synthetic */ Date z;

    public /* synthetic */ e(d dVar, long j, Date date, w wVar, v vVar, am1 am1Var, int i) {
        this.b = i;
        this.Z = dVar;
        this.f = j;
        this.z = date;
        this.A = wVar;
        this.X = vVar;
        this.Y = am1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        am1 am1Var = this.Y;
        v vVar = this.X;
        d dVar = this.Z;
        switch (i) {
            case 0:
                g gVar = (g) dVar;
                am1Var.g(d.c(gVar, this.f, this.z, this.A, gVar.e(), vVar.b, vVar.a, vVar.e, vVar.f));
                break;
            default:
                o oVar = (o) dVar;
                am1Var.g(d.c(oVar, this.f, this.z, this.A, oVar.e(), vVar.b, vVar.a, vVar.e, vVar.f));
                break;
        }
    }
}
