package defpackage;

import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class cx3 {
    public final int a;
    public final boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final Optional f;

    public cx3(int i, boolean z, int i2, int i3, int i4, Optional optional) {
        this.a = i;
        this.b = z;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = optional;
    }

    public final String toString() {
        return "SimpleKey - tokenNumber=" + this.a + " required=" + this.b + " index=" + this.c + " line=" + this.d + " column=" + this.e;
    }
}
