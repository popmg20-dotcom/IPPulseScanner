package defpackage;

import android.graphics.RectF;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xi2 extends co4 {
    public final int k;

    public xi2(int i) {
        this.k = i;
    }

    @Override // defpackage.co4
    public final float C(Object obj) {
        float[] fArr = ((yi2) obj).T0;
        if (fArr != null) {
            return fArr[this.k];
        }
        return 0.0f;
    }

    @Override // defpackage.co4
    public final void W(Object obj, float f) {
        float fA;
        yi2 yi2Var = (yi2) obj;
        float[] fArr = yi2Var.T0;
        if (fArr != null) {
            int i = this.k;
            if (fArr[i] != f) {
                fArr[i] = f;
                jd jdVar = yi2Var.V0;
                if (jdVar != null) {
                    y3 y3Var = yi2Var.J0;
                    if (fArr != null) {
                        fA = (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
                    } else {
                        RectF rectFG = yi2Var.g();
                        ou3 shapeAppearanceModel = yi2Var.getShapeAppearanceModel();
                        y3Var.getClass();
                        fA = (((yi2Var.getShapeAppearanceModel().h.a(rectFG) + shapeAppearanceModel.e.a(rectFG)) - yi2Var.getShapeAppearanceModel().g.a(rectFG)) - yi2Var.getShapeAppearanceModel().f.a(rectFG)) / 2.0f;
                    }
                    MaterialButton materialButton = (MaterialButton) jdVar.f;
                    int[] iArr = MaterialButton.c1;
                    int i2 = (int) (fA * 0.11f);
                    if (materialButton.W0 != i2) {
                        materialButton.W0 = i2;
                        materialButton.s();
                        materialButton.invalidate();
                    }
                }
                yi2Var.invalidateSelf();
            }
        }
    }
}
