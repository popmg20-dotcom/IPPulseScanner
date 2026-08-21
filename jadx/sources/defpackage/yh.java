package defpackage;

import android.os.Build;
import android.window.BackEvent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yh {
    public final float a;
    public final float b;
    public final float c;
    public final int d;
    public final long e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public yh(BackEvent backEvent) {
        this(backEvent.getTouchX(), backEvent.getTouchY(), backEvent.getProgress(), backEvent.getSwipeEdge(), Build.VERSION.SDK_INT >= 36 ? backEvent.getFrameTimeMillis() : 0L);
        backEvent.getClass();
    }

    public final String toString() {
        return "BackEventCompat(touchX=" + this.a + ", touchY=" + this.b + ", progress=" + this.c + ", swipeEdge=" + this.d + ", frameTimeMillis=" + this.e + ')';
    }

    public yh(float f, float f2, float f3, int i, long j) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = i;
        this.e = j;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public yh(vp2 vp2Var) {
        this(vp2Var.c, vp2Var.d, vp2Var.b, vp2Var.a, vp2Var.e);
        vp2Var.getClass();
    }
}
