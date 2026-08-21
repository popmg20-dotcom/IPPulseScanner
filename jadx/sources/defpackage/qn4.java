package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum qn4 {
    z("PREVIEW"),
    A("IMAGE_CAPTURE"),
    X("VIDEO_CAPTURE"),
    Y("STREAM_SHARING"),
    Z("UNDEFINED");

    public static final d84 f = new d84(3);
    public final Class b;

    qn4(String str) {
        this.b = cls;
    }

    @Override // java.lang.Enum
    public final String toString() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return "Preview";
        }
        if (iOrdinal == 1) {
            return "ImageCapture";
        }
        if (iOrdinal == 2) {
            return "VideoCapture";
        }
        if (iOrdinal == 3) {
            return "StreamSharing";
        }
        if (iOrdinal == 4) {
            return "Undefined";
        }
        g.d();
        return null;
    }
}
