package io.sentry.android.replay.capture;

import defpackage.pl1;
import defpackage.r82;
import defpackage.xl4;
import io.sentry.protocol.w;
import io.sentry.q6;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a extends r82 implements pl1 {
    public final /* synthetic */ d A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ int f;
    public final /* synthetic */ Object z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, Object obj2, d dVar, int i) {
        super(0);
        this.f = i;
        this.z = obj;
        this.X = obj2;
        this.A = dVar;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.f;
        xl4 xl4Var = xl4.a;
        d dVar = this.A;
        Object obj = this.X;
        switch (i) {
            case 0:
                w wVar = (w) obj;
                io.sentry.android.replay.j jVar = dVar.h;
                if (jVar != null) {
                    jVar.x("replay.id", String.valueOf(wVar));
                }
                break;
            case 1:
                Integer num = (Integer) obj;
                io.sentry.android.replay.j jVar2 = dVar.h;
                if (jVar2 != null) {
                    jVar2.x("segment.id", String.valueOf(num));
                }
                break;
            case 2:
                q6 q6Var = (q6) obj;
                io.sentry.android.replay.j jVar3 = dVar.h;
                if (jVar3 != null) {
                    jVar3.x("replay.type", String.valueOf(q6Var));
                }
                break;
            default:
                Boolean bool = (Boolean) obj;
                io.sentry.android.replay.j jVar4 = dVar.h;
                if (jVar4 != null) {
                    jVar4.x("replay.flushed", String.valueOf(bool));
                }
                break;
        }
        return xl4Var;
    }
}
