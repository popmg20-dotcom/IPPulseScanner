package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class by1 extends eq1 {
    public final int a = 1;
    public final xc1 b = xc1.A;

    @Override // defpackage.eq1
    public final xc1 a() {
        return this.b;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ImageFormatFeature(imageCaptureOutputFormat=");
        int i = this.a;
        if (i == 0) {
            str = "JPEG";
        } else if (i != 1) {
            str = "UNDEFINED(" + i + ')';
        } else {
            str = "JPEG_R";
        }
        return fw.x(sb, str, ')');
    }
}
