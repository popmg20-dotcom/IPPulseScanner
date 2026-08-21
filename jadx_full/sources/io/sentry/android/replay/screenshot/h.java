package io.sentry.android.replay.screenshot;

import android.graphics.Canvas;
import android.graphics.Matrix;
import defpackage.pl1;
import defpackage.r82;
import io.sentry.android.replay.v;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h extends r82 implements pl1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ i z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(i iVar, int i) {
        super(0);
        this.f = i;
        this.z = iVar;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.f;
        i iVar = this.z;
        switch (i) {
            case 0:
                Matrix matrix = new Matrix();
                v vVar = iVar.c;
                matrix.preScale(vVar.c, vVar.d);
                return matrix;
            default:
                return new Canvas(iVar.g);
        }
    }
}
