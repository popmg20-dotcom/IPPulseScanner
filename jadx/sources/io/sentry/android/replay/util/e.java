package io.sentry.android.replay.util;

import android.graphics.Bitmap;
import android.graphics.Paint;
import defpackage.pl1;
import defpackage.r82;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e extends r82 implements pl1 {
    public static final e A;
    public static final e z;
    public final /* synthetic */ int f;

    static {
        int i = 0;
        z = new e(i, 0);
        A = new e(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i, int i2) {
        super(i);
        this.f = i2;
    }

    @Override // defpackage.pl1
    public final Object a() {
        switch (this.f) {
            case 0:
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            default:
                return new Paint();
        }
    }
}
