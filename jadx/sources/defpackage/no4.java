package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class no4 {
    public static final Matrix p = new Matrix();
    public final Path a;
    public final Path b;
    public final Matrix c;
    public Paint d;
    public Paint e;
    public PathMeasure f;
    public final ko4 g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l;
    public String m;
    public Boolean n;
    public final ie o;

    public no4(no4 no4Var) {
        this.c = new Matrix();
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = DnsRecord.CLASS_ANY;
        this.m = null;
        this.n = null;
        ie ieVar = new ie(0);
        this.o = ieVar;
        this.g = new ko4(no4Var.g, ieVar);
        this.a = new Path(no4Var.a);
        this.b = new Path(no4Var.b);
        this.h = no4Var.h;
        this.i = no4Var.i;
        this.j = no4Var.j;
        this.k = no4Var.k;
        this.l = no4Var.l;
        this.m = no4Var.m;
        String str = no4Var.m;
        if (str != null) {
            ieVar.put(str, this);
        }
        this.n = no4Var.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ko4 ko4Var, Matrix matrix, Canvas canvas, int i, int i2) {
        int i3;
        float f;
        int i4;
        float f2;
        Matrix matrix2 = ko4Var.a;
        ArrayList arrayList = ko4Var.b;
        matrix2.set(matrix);
        Matrix matrix3 = ko4Var.a;
        matrix3.preConcat(ko4Var.j);
        canvas.save();
        char c = 0;
        int i5 = 0;
        while (i5 < arrayList.size()) {
            lo4 lo4Var = (lo4) arrayList.get(i5);
            if (lo4Var instanceof ko4) {
                a((ko4) lo4Var, matrix3, canvas, i, i2);
            } else if (lo4Var instanceof mo4) {
                mo4 mo4Var = (mo4) lo4Var;
                float f3 = i / this.j;
                float f4 = i2 / this.k;
                float fMin = Math.min(f3, f4);
                Matrix matrix4 = this.c;
                matrix4.set(matrix3);
                matrix4.postScale(f3, f4);
                float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                matrix3.mapVectors(fArr);
                float fHypot = (float) Math.hypot(fArr[c], fArr[1]);
                boolean z = c;
                i3 = i5;
                float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                float f5 = (fArr[z ? 1 : 0] * fArr[3]) - (fArr[1] * fArr[2]);
                float fMax = Math.max(fHypot, fHypot2);
                float fAbs = fMax > 0.0f ? Math.abs(f5) / fMax : 0.0f;
                if (fAbs != 0.0f) {
                    Path path = this.a;
                    path.reset();
                    v03[] v03VarArr = mo4Var.a;
                    if (v03VarArr != null) {
                        n12.J(v03VarArr, path);
                    }
                    Path path2 = this.b;
                    path2.reset();
                    if (mo4Var instanceof io4) {
                        path2.setFillType(mo4Var.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                        path2.addPath(path, matrix4);
                        canvas.clipPath(path2);
                    } else {
                        jo4 jo4Var = (jo4) mo4Var;
                        float f6 = jo4Var.i;
                        if (f6 != 0.0f || jo4Var.j != 1.0f) {
                            float f7 = jo4Var.k;
                            float f8 = (f6 + f7) % 1.0f;
                            float f9 = (jo4Var.j + f7) % 1.0f;
                            PathMeasure pathMeasure = this.f;
                            PathMeasure pathMeasure2 = pathMeasure;
                            if (pathMeasure == null) {
                                PathMeasure pathMeasure3 = new PathMeasure();
                                this.f = pathMeasure3;
                                pathMeasure2 = pathMeasure3;
                            }
                            pathMeasure2.setPath(path, z);
                            float length = this.f.getLength();
                            float f10 = f8 * length;
                            float f11 = f9 * length;
                            path.reset();
                            PathMeasure pathMeasure4 = this.f;
                            if (f10 > f11) {
                                pathMeasure4.getSegment(f10, length, path, true);
                                f = 0.0f;
                                this.f.getSegment(0.0f, f11, path, true);
                            } else {
                                f = 0.0f;
                                pathMeasure4.getSegment(f10, f11, path, true);
                            }
                            path.rLineTo(f, f);
                        }
                        path2.addPath(path, matrix4);
                        qt qtVar = jo4Var.f;
                        if (((Shader) qtVar.c) == null && qtVar.b == 0) {
                            f2 = 255.0f;
                            i4 = 16777215;
                        } else {
                            if (this.e == null) {
                                i4 = 16777215;
                                Paint paint = new Paint(1);
                                this.e = paint;
                                paint.setStyle(Paint.Style.FILL);
                            } else {
                                i4 = 16777215;
                            }
                            Paint paint2 = this.e;
                            Shader shader = (Shader) qtVar.c;
                            if (shader != null) {
                                shader.setLocalMatrix(matrix4);
                                paint2.setShader(shader);
                                paint2.setAlpha(Math.round(jo4Var.h * 255.0f));
                                f2 = 255.0f;
                            } else {
                                paint2.setShader(null);
                                paint2.setAlpha(DnsRecord.CLASS_ANY);
                                int i6 = qtVar.b;
                                float f12 = jo4Var.h;
                                PorterDuff.Mode mode = qo4.A0;
                                f2 = 255.0f;
                                paint2.setColor((i6 & i4) | (((int) (Color.alpha(i6) * f12)) << 24));
                            }
                            paint2.setColorFilter(null);
                            path2.setFillType(jo4Var.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            canvas.drawPath(path2, paint2);
                        }
                        qt qtVar2 = jo4Var.d;
                        if (((Shader) qtVar2.c) != null || qtVar2.b != 0) {
                            if (this.d == null) {
                                Paint paint3 = new Paint(1);
                                this.d = paint3;
                                paint3.setStyle(Paint.Style.STROKE);
                            }
                            Paint paint4 = this.d;
                            Paint.Join join = jo4Var.m;
                            if (join != null) {
                                paint4.setStrokeJoin(join);
                            }
                            Paint.Cap cap = jo4Var.l;
                            if (cap != null) {
                                paint4.setStrokeCap(cap);
                            }
                            paint4.setStrokeMiter(jo4Var.n);
                            Shader shader2 = (Shader) qtVar2.c;
                            if (shader2 != null) {
                                shader2.setLocalMatrix(matrix4);
                                paint4.setShader(shader2);
                                paint4.setAlpha(Math.round(jo4Var.g * f2));
                            } else {
                                paint4.setShader(null);
                                paint4.setAlpha(DnsRecord.CLASS_ANY);
                                int i7 = qtVar2.b;
                                float f13 = jo4Var.g;
                                PorterDuff.Mode mode2 = qo4.A0;
                                paint4.setColor((i7 & i4) | (((int) (Color.alpha(i7) * f13)) << 24));
                            }
                            paint4.setColorFilter(null);
                            paint4.setStrokeWidth(jo4Var.e * fMin * fAbs);
                            canvas.drawPath(path2, paint4);
                        }
                    }
                }
                i5 = i3 + 1;
                c = 0;
            }
            i3 = i5;
            i5 = i3 + 1;
            c = 0;
        }
        canvas.restore();
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.l;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.l = i;
    }

    public no4() {
        this.c = new Matrix();
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = DnsRecord.CLASS_ANY;
        this.m = null;
        this.n = null;
        this.o = new ie(0);
        this.g = new ko4();
        this.a = new Path();
        this.b = new Path();
    }
}
