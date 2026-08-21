package defpackage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class su3 extends wu3 {
    public final uu3 c;
    public final float d;
    public final float e;

    public su3(uu3 uu3Var, float f, float f2) {
        this.c = uu3Var;
        this.d = f;
        this.e = f2;
    }

    @Override // defpackage.wu3
    public final void a(Matrix matrix, ju3 ju3Var, int i, Canvas canvas) {
        uu3 uu3Var = this.c;
        float f = uu3Var.c;
        float f2 = this.e;
        float f3 = uu3Var.b;
        float f4 = this.d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f2, f3 - f4), 0.0f);
        Matrix matrix2 = this.a;
        matrix2.set(matrix);
        matrix2.preTranslate(f4, f2);
        matrix2.preRotate(b());
        ju3Var.getClass();
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int i2 = ju3Var.f;
        int[] iArr = ju3.i;
        iArr[0] = i2;
        iArr[1] = ju3Var.e;
        iArr[2] = ju3Var.d;
        Paint paint = ju3Var.c;
        float f5 = rectF.left;
        paint.setShader(new LinearGradient(f5, rectF.top, f5, rectF.bottom, iArr, ju3.j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        uu3 uu3Var = this.c;
        return (float) Math.toDegrees(Math.atan((uu3Var.c - this.e) / (uu3Var.b - this.d)));
    }
}
