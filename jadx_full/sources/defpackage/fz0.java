package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fz0 extends co4 {
    public final /* synthetic */ int k;

    public /* synthetic */ fz0(int i) {
        this.k = i;
    }

    @Override // defpackage.co4
    public final float C(Object obj) {
        switch (this.k) {
            case 0:
                return ((View) obj).getAlpha();
            case 1:
                return ((View) obj).getScaleX();
            case 2:
                return ((View) obj).getScaleY();
            case 3:
                return ((View) obj).getRotation();
            case 4:
                return ((View) obj).getRotationX();
            default:
                return ((View) obj).getRotationY();
        }
    }

    @Override // defpackage.co4
    public final void W(Object obj, float f) {
        switch (this.k) {
            case 0:
                ((View) obj).setAlpha(f);
                break;
            case 1:
                ((View) obj).setScaleX(f);
                break;
            case 2:
                ((View) obj).setScaleY(f);
                break;
            case 3:
                ((View) obj).setRotation(f);
                break;
            case 4:
                ((View) obj).setRotationX(f);
                break;
            default:
                ((View) obj).setRotationY(f);
                break;
        }
    }
}
