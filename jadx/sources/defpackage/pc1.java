package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.media.ImageReader;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pc1 implements AutoCloseable {
    public final OutputConfiguration b;
    public final ImageReader f;

    public pc1(OutputConfiguration outputConfiguration, ImageReader imageReader) {
        this.b = outputConfiguration;
        this.f = imageReader;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        ImageReader imageReader = this.f;
        if (imageReader != null) {
            imageReader.close();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pc1)) {
            return false;
        }
        pc1 pc1Var = (pc1) obj;
        return this.b.equals(pc1Var.b) && n12.c(this.f, pc1Var.f);
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        ImageReader imageReader = this.f;
        return iHashCode + (imageReader == null ? 0 : imageReader.hashCode());
    }

    public final String toString() {
        return "CloseableOutputConfiguration(value=" + this.b + ", backingImageReader=" + this.f + ')';
    }
}
