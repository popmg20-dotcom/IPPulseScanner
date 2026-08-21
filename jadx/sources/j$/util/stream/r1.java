package j$.util.stream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public enum r1 {
    ANY(true, true),
    ALL(false, false),
    NONE(true, false);

    public final boolean a;
    public final boolean b;

    r1(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }
}
