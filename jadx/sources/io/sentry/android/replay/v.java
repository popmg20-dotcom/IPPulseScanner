package io.sentry.android.replay;

import defpackage.ha0;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public final int a;
    public final int b;
    public final float c;
    public final float d;
    public final int e;
    public final int f;

    public v(int i, int i2, float f, float f2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.e = i3;
        this.f = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.a == vVar.a && this.b == vVar.b && Float.compare(this.c, vVar.c) == 0 && Float.compare(this.d, vVar.d) == 0 && this.e == vVar.e && this.f == vVar.f;
    }

    public final int hashCode() {
        return ((((Float.floatToIntBits(this.d) + ((Float.floatToIntBits(this.c) + (((this.a * 31) + this.b) * 31)) * 31)) * 31) + this.e) * 31) + this.f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ScreenshotRecorderConfig(recordingWidth=");
        sb.append(this.a);
        sb.append(", recordingHeight=");
        sb.append(this.b);
        sb.append(", scaleFactorX=");
        sb.append(this.c);
        sb.append(", scaleFactorY=");
        sb.append(this.d);
        sb.append(", frameRate=");
        sb.append(this.e);
        sb.append(", bitRate=");
        return ha0.p(sb, this.f, ')');
    }
}
