package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.File;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class df implements fd1 {
    public final /* synthetic */ int a;

    public /* synthetic */ df(int i) {
        this.a = i;
    }

    @Override // defpackage.fd1
    public final gd1 a(Object obj, rw2 rw2Var) {
        int i = 0;
        int i2 = 1;
        switch (this.a) {
            case 0:
                Uri uri = (Uri) obj;
                if (j.d(uri)) {
                    return new ef(uri, rw2Var, i);
                }
                return null;
            case 1:
                return new kn((Bitmap) obj, rw2Var, i);
            case 2:
                return new kn((ByteBuffer) obj, rw2Var, i2);
            case 3:
                Uri uri2 = (Uri) obj;
                if (n12.c(uri2.getScheme(), "content")) {
                    return new yd0(uri2, rw2Var);
                }
                return null;
            case 4:
                return new kn((Drawable) obj, rw2Var, 2);
            case 5:
                return new pd1((File) obj);
            default:
                Uri uri3 = (Uri) obj;
                if (n12.c(uri3.getScheme(), "android.resource")) {
                    return new ef(uri3, rw2Var, i2);
                }
                return null;
        }
    }
}
