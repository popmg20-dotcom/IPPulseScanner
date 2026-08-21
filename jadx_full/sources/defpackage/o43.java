package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o43 {
    public Size a;
    public Rect b;
    public int c;
    public Matrix d;
    public int e;
    public boolean f;
    public boolean g;
    public r43 h;

    public final void a(Size size, int i, Rect rect) {
        Matrix matrix;
        if (f()) {
            Matrix matrix2 = new Matrix();
            if (f()) {
                Matrix matrix3 = new Matrix(this.d);
                matrix3.postConcat(c(size, i));
                matrix = matrix3;
            } else {
                matrix = null;
            }
            matrix.invert(matrix2);
            Matrix matrix4 = new Matrix();
            matrix4.setRectToRect(new RectF(0.0f, 0.0f, rect.width(), rect.height()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
            matrix2.postConcat(matrix4);
        }
    }

    public final Size b() {
        return kg4.c(this.c) ? new Size(this.b.height(), this.b.width()) : new Size(this.b.width(), this.b.height());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Matrix c(Size size, int i) {
        Matrix.ScaleToFit scaleToFit;
        RectF rectF;
        r25.j(null, f());
        if (kg4.d(size, true, b())) {
            rectF = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
        } else {
            RectF rectF2 = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
            Size sizeB = b();
            RectF rectF3 = new RectF(0.0f, 0.0f, sizeB.getWidth(), sizeB.getHeight());
            Matrix matrix = new Matrix();
            r43 r43Var = this.h;
            int iOrdinal = r43Var.ordinal();
            if (iOrdinal == 0) {
                scaleToFit = Matrix.ScaleToFit.START;
                if (r43Var != r43.FIT_CENTER || r43Var == r43.FIT_START || r43Var == r43.FIT_END) {
                    matrix.setRectToRect(rectF3, rectF2, scaleToFit);
                } else {
                    matrix.setRectToRect(rectF2, rectF3, scaleToFit);
                    matrix.invert(matrix);
                }
                matrix.mapRect(rectF3);
                if (i != 1) {
                    float width = size.getWidth() / 2.0f;
                    float f = width + width;
                    rectF = new RectF(f - rectF3.right, rectF3.top, f - rectF3.left, rectF3.bottom);
                } else {
                    rectF = rectF3;
                }
            } else if (iOrdinal == 1) {
                scaleToFit = Matrix.ScaleToFit.CENTER;
                if (r43Var != r43.FIT_CENTER) {
                    matrix.setRectToRect(rectF3, rectF2, scaleToFit);
                    matrix.mapRect(rectF3);
                    if (i != 1) {
                    }
                }
            } else if (iOrdinal == 2) {
                scaleToFit = Matrix.ScaleToFit.END;
                if (r43Var != r43.FIT_CENTER) {
                }
            } else {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        if (iOrdinal != 5) {
                            ez4.q("PreviewTransform", "Unexpected crop rect: " + r43Var);
                            scaleToFit = Matrix.ScaleToFit.FILL;
                        }
                    }
                }
                if (r43Var != r43.FIT_CENTER) {
                }
            }
        }
        Matrix matrixA = kg4.a(new RectF(this.b), rectF, this.c, false);
        if (this.f && this.g) {
            boolean zC = kg4.c(this.c);
            Rect rect = this.b;
            if (zC) {
                matrixA.preScale(1.0f, -1.0f, rect.centerX(), this.b.centerY());
                return matrixA;
            }
            matrixA.preScale(-1.0f, 1.0f, rect.centerX(), this.b.centerY());
        }
        return matrixA;
    }

    public final Matrix d() {
        r25.j(null, f());
        RectF rectF = new RectF(0.0f, 0.0f, this.a.getWidth(), this.a.getHeight());
        return kg4.a(rectF, rectF, !this.g ? this.c : -r25.T(this.e), false);
    }

    public final RectF e(Size size, int i) {
        r25.j(null, f());
        Matrix matrixC = c(size, i);
        RectF rectF = new RectF(0.0f, 0.0f, this.a.getWidth(), this.a.getHeight());
        matrixC.mapRect(rectF);
        return rectF;
    }

    public final boolean f() {
        return (this.b == null || this.a == null || !(!this.g || this.e != -1)) ? false : true;
    }
}
