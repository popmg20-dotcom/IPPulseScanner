package defpackage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class md2 extends Drawable implements Drawable.Callback {
    public final od2 A;
    public final ld2 X;
    public int Z;
    public final Context f;
    public qo4 y0;
    public final pd2 z;
    public u8 b = new u8();
    public final Paint Y = new Paint();

    public md2(Context context, pd2 pd2Var, od2 od2Var, ld2 ld2Var) {
        this.f = context;
        this.z = pd2Var;
        this.A = od2Var;
        this.X = ld2Var;
        ld2Var.g = this;
        setAlpha(DnsRecord.CLASS_ANY);
    }

    public final boolean a(boolean z, boolean z2, boolean z3) {
        boolean visible = super.setVisible(z, z2);
        ld2 ld2Var = this.X;
        ObjectAnimator objectAnimator = ld2Var.d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        w04 w04Var = ld2Var.e;
        if (w04Var != null) {
            w04Var.d();
        }
        if (!z || !z3 || (this.b != null && u8.a(this.f.getContentResolver()) == 0.0f)) {
            return visible;
        }
        if (ld2Var.e == null) {
            w04 w04Var2 = new w04(ld2Var, ld2.j);
            x04 x04Var = new x04();
            x04Var.b(200.0f);
            x04Var.a(0.6f);
            w04Var2.m = x04Var;
            w04Var2.b(0.01f);
            ld2Var.e = w04Var2;
        }
        if (ld2Var.d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(ld2Var, ld2.i, 0.0f, 1.0f);
            ld2Var.d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(650L);
            ld2Var.d.setInterpolator(null);
            ld2Var.d.setRepeatCount(-1);
            ld2Var.d.addListener(new d3(10, ld2Var));
        }
        ld2Var.a = 1;
        ld2Var.a(0.0f);
        ld2Var.h.a = ld2Var.f.d[0];
        ld2Var.e.a(ld2Var.a);
        ld2Var.d.start();
        return visible;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        qo4 qo4Var;
        Rect rect = new Rect();
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            u8 u8Var = this.b;
            int i2 = 0;
            pd2 pd2Var = this.z;
            if (u8Var != null && u8.a(this.f.getContentResolver()) == 0.0f && (qo4Var = this.y0) != null) {
                qo4Var.setBounds(bounds);
                this.y0.setTint(pd2Var.d[0]);
                this.y0.draw(canvas);
                return;
            }
            canvas.save();
            od2 od2Var = this.A;
            od2Var.getClass();
            pd2 pd2Var2 = od2Var.a;
            canvas.translate(bounds.centerX(), bounds.centerY());
            float f = 2.0f;
            canvas.clipRect((-Math.max(pd2Var2.c, pd2Var2.a)) / 2.0f, (-Math.max(pd2Var2.b, pd2Var2.a)) / 2.0f, Math.max(pd2Var2.c, pd2Var2.a) / 2.0f, Math.max(pd2Var2.b, pd2Var2.a) / 2.0f);
            canvas.rotate(-90.0f);
            float fMin = Math.min(pd2Var2.b, pd2Var2.c) / 2.0f;
            int iN = n12.n(pd2Var.e, this.Z);
            Paint paint = this.Y;
            paint.setColor(iN);
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            canvas.drawRoundRect(new RectF((-r10) / 2.0f, (-r12) / 2.0f, pd2Var2.b / 2.0f, pd2Var2.c / 2.0f), fMin, fMin, paint);
            nd2 nd2Var = this.X.h;
            int i3 = this.Z;
            Matrix matrix = od2Var.c;
            paint.setColor(n12.n(nd2Var.a, i3));
            paint.setStyle(style);
            canvas.save();
            canvas.rotate(nd2Var.c);
            Path path = od2Var.b;
            path.rewind();
            int iFloor = (int) Math.floor(nd2Var.b);
            m20[] m20VarArr = od2.e;
            int length = m20VarArr.length;
            int i4 = iFloor / length;
            if ((iFloor ^ length) < 0 && i4 * length != iFloor) {
                i4--;
            }
            float f2 = nd2Var.b - iFloor;
            m20 m20Var = m20VarArr[iFloor - (i4 * length)];
            m20Var.getClass();
            ub2 ub2VarI = p95.i();
            ArrayList arrayList = m20Var.a;
            int size = arrayList.size();
            hg0 hg0Var = null;
            int i5 = 0;
            hg0 hg0Var2 = null;
            while (i5 < size) {
                float[] fArr = new float[8];
                int i6 = i2;
                for (int i7 = 8; i2 < i7; i7 = 8) {
                    fArr[i2] = eo4.c(((hg0) ((e03) arrayList.get(i5)).b).a[i2], ((hg0) ((e03) arrayList.get(i5)).f).a[i2], f2);
                    i2++;
                    f = f;
                }
                float f3 = f;
                hg0 hg0Var3 = new hg0(fArr);
                if (hg0Var2 == null) {
                    hg0Var2 = hg0Var3;
                }
                if (hg0Var != null) {
                    ub2VarI.add(hg0Var);
                }
                i5++;
                hg0Var = hg0Var3;
                i2 = i6;
                f = f3;
            }
            int i8 = i2;
            float f4 = f;
            if (hg0Var != null && hg0Var2 != null) {
                float[] fArr2 = hg0Var.a;
                float f5 = fArr2[i8];
                float f6 = fArr2[1];
                float f7 = fArr2[2];
                float f8 = fArr2[3];
                float f9 = fArr2[4];
                float f10 = fArr2[5];
                float[] fArr3 = hg0Var2.a;
                ub2VarI.add(je.a(f5, f6, f7, f8, f9, f10, fArr3[i8], fArr3[1]));
            }
            ub2 ub2VarC = p95.c(ub2VarI);
            path.rewind();
            int i9 = 1;
            int i10 = i8;
            for (int iA = ub2VarC.a(); i10 < iA; iA = iA) {
                hg0 hg0Var4 = (hg0) ub2VarC.get(i10);
                if (i9 != 0) {
                    float[] fArr4 = hg0Var4.a;
                    path.moveTo(fArr4[i8], fArr4[1]);
                    i = i8;
                } else {
                    i = i9;
                }
                float[] fArr5 = hg0Var4.a;
                path.cubicTo(fArr5[2], fArr5[3], fArr5[4], fArr5[5], hg0Var4.a(), hg0Var4.b());
                i10++;
                i9 = i;
            }
            path.close();
            float f11 = pd2Var2.a / f4;
            matrix.setScale(f11, f11);
            path.transform(matrix);
            canvas.drawPath(path, paint);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.Z;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        pd2 pd2Var = this.A.a;
        return Math.max(pd2Var.b, pd2Var.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        pd2 pd2Var = this.A.a;
        return Math.max(pd2Var.c, pd2Var.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.Z != i) {
            this.Z = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.Y.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return a(z, z2, z);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
