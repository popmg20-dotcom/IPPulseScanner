package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class uz3 implements Serializable {
    public final int b;
    public final int f;

    public uz3(int i, int i2) {
        this.b = i;
        this.f = i2;
    }

    public final String toString() {
        return "Version{major=" + this.b + ", minor=" + this.f + "}";
    }
}
