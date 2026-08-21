package io.sentry.android.replay.capture;

import defpackage.pl1;
import defpackage.r82;
import defpackage.xl4;
import io.sentry.android.replay.v;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c extends r82 implements pl1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ d X;
    public final /* synthetic */ int f;
    public final /* synthetic */ Object z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, Object obj2, d dVar, int i) {
        super(0);
        this.f = i;
        this.z = obj;
        this.A = obj2;
        this.X = dVar;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.f;
        Object obj = this.z;
        xl4 xl4Var = xl4.a;
        d dVar = this.X;
        Object obj2 = this.A;
        switch (i) {
            case 0:
                v vVar = (v) obj2;
                if (vVar != null) {
                    io.sentry.android.replay.j jVar = dVar.h;
                    if (jVar != null) {
                        jVar.x("config.height", String.valueOf(vVar.b));
                    }
                    io.sentry.android.replay.j jVar2 = dVar.h;
                    if (jVar2 != null) {
                        jVar2.x("config.width", String.valueOf(vVar.a));
                    }
                    io.sentry.android.replay.j jVar3 = dVar.h;
                    if (jVar3 != null) {
                        jVar3.x("config.frame-rate", String.valueOf(vVar.e));
                    }
                    io.sentry.android.replay.j jVar4 = dVar.h;
                    if (jVar4 != null) {
                        jVar4.x("config.bit-rate", String.valueOf(vVar.f));
                    }
                }
                break;
            case 1:
                Date date = (Date) obj2;
                io.sentry.android.replay.j jVar5 = dVar.h;
                if (jVar5 != null) {
                    jVar5.x("segment.timestamp", date == null ? null : io.sentry.vendor.a.f(date.getTime()));
                }
                break;
            default:
                io.sentry.android.replay.j jVar6 = dVar.h;
                if (jVar6 != null) {
                    jVar6.x("replay.screen-at-start", String.valueOf(obj2));
                }
                break;
        }
        return xl4Var;
    }
}
