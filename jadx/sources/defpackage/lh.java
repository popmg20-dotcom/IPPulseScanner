package defpackage;

import android.graphics.Rect;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lh {
    public final Size a;
    public final Rect b;
    public final mz c;
    public final int d;
    public final boolean e;

    public lh(Size size, Rect rect, mz mzVar, int i, boolean z) {
        if (size == null) {
            zo2.n("Null inputSize");
            throw null;
        }
        this.a = size;
        this.b = rect;
        this.c = mzVar;
        this.d = i;
        this.e = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lh)) {
            return false;
        }
        lh lhVar = (lh) obj;
        if (!this.a.equals(lhVar.a) || !this.b.equals(lhVar.b)) {
            return false;
        }
        mz mzVar = lhVar.c;
        mz mzVar2 = this.c;
        if (mzVar2 == null) {
            if (mzVar != null) {
                return false;
            }
        } else if (!mzVar2.equals(mzVar)) {
            return false;
        }
        return this.d == lhVar.d && this.e == lhVar.e;
    }

    public final int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        mz mzVar = this.c;
        return (this.e ? 1231 : 1237) ^ ((((iHashCode ^ (mzVar == null ? 0 : mzVar.hashCode())) * 1000003) ^ this.d) * 1000003);
    }

    public final String toString() {
        return "CameraInputInfo{inputSize=" + this.a + ", inputCropRect=" + this.b + ", cameraInternal=" + this.c + ", rotationDegrees=" + this.d + ", mirroring=" + this.e + "}";
    }
}
