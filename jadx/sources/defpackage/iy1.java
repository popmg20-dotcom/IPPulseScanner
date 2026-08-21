package defpackage;

import androidx.camera.core.ImageProcessingUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class iy1 implements vi1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ my1 f;

    public /* synthetic */ iy1(my1 my1Var, my1 my1Var2, int i) {
        this.b = i;
        this.f = my1Var2;
    }

    @Override // defpackage.vi1
    public final void a(wi1 wi1Var) throws Exception {
        int i = this.b;
        my1 my1Var = this.f;
        switch (i) {
            case 0:
                int i2 = ImageProcessingUtil.a;
                my1Var.close();
                break;
            default:
                int i3 = ImageProcessingUtil.a;
                my1Var.close();
                break;
        }
    }
}
