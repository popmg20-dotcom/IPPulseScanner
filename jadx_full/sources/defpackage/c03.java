package defpackage;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c03 extends Paint {
    public float a = measureText(" ");
    public boolean b;

    public c03(boolean z) {
        this.b = z;
    }

    public final float a(char[] cArr, int i, int i2, int i3, int i4, boolean z, float[] fArr, int i5) {
        float fMeasureText;
        float textRunAdvances = getTextRunAdvances(cArr, i, i2, i3, i4, z, fArr, i5);
        if (this.b) {
            for (int i6 = 0; i6 < i2; i6++) {
                char c = cArr[i + i6];
                if (ek0.s(c)) {
                    float fMeasureText2 = measureText(ek0.n(c));
                    if (fArr != null) {
                        int i7 = i5 + i6;
                        fMeasureText = textRunAdvances - fArr[i7];
                        fArr[i7] = fMeasureText2;
                    } else {
                        fMeasureText = textRunAdvances - measureText(Character.toString(c));
                    }
                    textRunAdvances = fMeasureText + fMeasureText2;
                }
            }
        }
        return textRunAdvances;
    }

    public final void b() {
        this.a = measureText(" ");
    }

    @Override // android.graphics.Paint
    public final void setLetterSpacing(float f) {
        super.setLetterSpacing(f);
        b();
    }
}
