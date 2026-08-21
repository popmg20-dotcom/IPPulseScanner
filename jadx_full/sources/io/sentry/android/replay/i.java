package io.sentry.android.replay;

import defpackage.am1;
import defpackage.bh3;
import defpackage.r82;
import defpackage.xg3;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.r6;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i extends r82 implements am1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Serializable X;
    public final /* synthetic */ int f;
    public final /* synthetic */ long z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(long j, Object obj, Serializable serializable, int i) {
        super(1);
        this.f = i;
        this.z = j;
        this.A = obj;
        this.X = serializable;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.f;
        Serializable serializable = this.X;
        long j = this.z;
        Object obj2 = this.A;
        switch (i) {
            case 0:
                k kVar = (k) obj;
                kVar.getClass();
                if (kVar.b >= j) {
                    bh3 bh3Var = (bh3) serializable;
                    if (bh3Var.b == null) {
                        bh3Var.b = kVar.c;
                    }
                } else {
                    ((j) obj2).n(kVar.a);
                }
                break;
            default:
                io.sentry.android.replay.capture.j jVar = (io.sentry.android.replay.capture.j) obj;
                io.sentry.android.replay.capture.g gVar = (io.sentry.android.replay.capture.g) obj2;
                jVar.getClass();
                r6 r6Var = jVar.a;
                if (r6Var.L0.getTime() < j) {
                    gVar.k(gVar.e() - 1);
                    File file = r6Var.G0;
                    p6 p6Var = gVar.v;
                    if (file != null) {
                        try {
                            if (!file.delete()) {
                                p6Var.getLogger().h(p5.ERROR, "Failed to delete replay segment: %s", file.getAbsolutePath());
                            }
                        } catch (Throwable th) {
                            p6Var.getLogger().b(p5.ERROR, th, "Failed to delete replay segment: %s", file.getAbsolutePath());
                        }
                    }
                    ((xg3) serializable).b = true;
                    break;
                }
                break;
        }
        return Boolean.FALSE;
    }
}
