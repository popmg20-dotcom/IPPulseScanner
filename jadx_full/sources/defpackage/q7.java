package defpackage;

import android.graphics.Matrix;
import android.media.Image;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q7 implements my1 {
    public final Image b;
    public final cp1[] f;
    public final wg z;

    public q7(Image image) {
        this.b = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.f = new cp1[planes.length];
            for (int i = 0; i < planes.length; i++) {
                this.f[i] = new cp1(4, planes[i]);
            }
        } else {
            this.f = new cp1[0];
        }
        this.z = new wg(pa4.b, image.getTimestamp(), 0, new Matrix(), 0);
    }

    @Override // defpackage.my1
    public final int c() {
        return this.b.getHeight();
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }

    @Override // defpackage.my1
    public final int f() {
        return this.b.getWidth();
    }

    @Override // defpackage.my1
    public final cy1 g0() {
        return this.z;
    }

    @Override // defpackage.my1
    public final int getFormat() {
        return this.b.getFormat();
    }

    @Override // defpackage.my1
    public final ly1[] p() {
        return this.f;
    }
}
