package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ru3 extends wu3 {
    public final tu3 c;

    public ru3(tu3 tu3Var) {
        this.c = tu3Var;
    }

    @Override // defpackage.wu3
    public final void a(Matrix matrix, ju3 ju3Var, int i, Canvas canvas) {
        RectF rectF = tu3.h;
        tu3 tu3Var = this.c;
        float f = tu3Var.f;
        float f2 = tu3Var.g;
        RectF rectF2 = new RectF(tu3Var.b, tu3Var.c, tu3Var.d, tu3Var.e);
        Paint paint = ju3Var.b;
        boolean z = f2 < 0.0f;
        Path path = ju3Var.g;
        int[] iArr = ju3.k;
        if (z) {
            iArr[0] = 0;
            iArr[1] = ju3Var.f;
            iArr[2] = ju3Var.e;
            iArr[3] = ju3Var.d;
        } else {
            path.rewind();
            path.moveTo(rectF2.centerX(), rectF2.centerY());
            path.arcTo(rectF2, f, f2);
            path.close();
            float f3 = -i;
            rectF2.inset(f3, f3);
            iArr[0] = 0;
            iArr[1] = ju3Var.d;
            iArr[2] = ju3Var.e;
            iArr[3] = ju3Var.f;
        }
        float fWidth = rectF2.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f4 = 1.0f - (i / fWidth);
        float[] fArr = ju3.l;
        fArr[1] = f4;
        fArr[2] = ((1.0f - f4) / 2.0f) + f4;
        paint.setShader(new RadialGradient(rectF2.centerX(), rectF2.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF2.height() / rectF2.width());
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, ju3Var.h);
        }
        canvas.drawArc(rectF2, f, f2, true, paint);
        canvas.restore();
    }
}
