package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.getsurfboard.R;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pj extends Drawable implements nb4 {
    public final Rect A;
    public float A0;
    public float B0;
    public WeakReference C0;
    public WeakReference D0;
    public final rj X;
    public float Y;
    public float Z;
    public final WeakReference b;
    public final yi2 f;
    public final int y0;
    public final ob4 z;
    public float z0;

    public pj(Context context, qj qjVar) {
        kb4 kb4Var;
        WeakReference weakReference = new WeakReference(context);
        this.b = weakReference;
        fx3.f(context, fx3.z, "Theme.MaterialComponents");
        this.A = new Rect();
        ob4 ob4Var = new ob4(this);
        this.z = ob4Var;
        Paint.Align align = Paint.Align.CENTER;
        TextPaint textPaint = ob4Var.a;
        textPaint.setTextAlign(align);
        rj rjVar = new rj(context, qjVar);
        this.X = rjVar;
        boolean zG = g();
        qj qjVar2 = rjVar.b;
        yi2 yi2Var = new yi2(ou3.f(context, zG ? qjVar2.Z.intValue() : qjVar2.X.intValue(), g() ? qjVar2.y0.intValue() : qjVar2.Y.intValue()).b());
        this.f = yi2Var;
        i();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && ob4Var.g != (kb4Var = new kb4(context2, qjVar2.A.intValue()))) {
            ob4Var.b(kb4Var, context2);
            textPaint.setColor(qjVar2.z.intValue());
            invalidateSelf();
            k();
            invalidateSelf();
        }
        int i = qjVar2.C0;
        if (i != -2) {
            this.y0 = ((int) Math.pow(10.0d, ((double) i) - 1.0d)) - 1;
        } else {
            this.y0 = qjVar2.D0;
        }
        ob4Var.e = true;
        k();
        invalidateSelf();
        ob4Var.e = true;
        i();
        k();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(qjVar2.f.intValue());
        if (yi2Var.f.c != colorStateListValueOf) {
            yi2Var.p(colorStateListValueOf);
            invalidateSelf();
        }
        textPaint.setColor(qjVar2.z.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.C0;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.C0.get();
            WeakReference weakReference3 = this.D0;
            j(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        k();
        setVisible(qjVar2.K0.booleanValue(), false);
    }

    @Override // defpackage.nb4
    public final void a() {
        invalidateSelf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(View view, View view2) {
        float y;
        float x;
        ViewParent parent;
        boolean z;
        FrameLayout frameLayoutE = e();
        if (frameLayoutE == null) {
            float y2 = view.getY();
            x = view.getX();
            parent = view.getParent();
            y = y2;
        } else {
            y = 0.0f;
            x = 0.0f;
            parent = frameLayoutE;
        }
        while (true) {
            z = parent instanceof View;
            if (!z || parent == view2) {
                break;
            }
            ViewParent parent2 = parent.getParent();
            if (!(parent2 instanceof ViewGroup) || ((ViewGroup) parent2).getClipChildren()) {
                break;
            }
            View view3 = (View) parent;
            y += view3.getY();
            x += view3.getX();
            parent = parent.getParent();
        }
        if (z) {
            float f = (this.Z - this.B0) + y;
            float f2 = (this.Y - this.A0) + x;
            View view4 = (View) parent;
            float height = ((this.Z + this.B0) - view4.getHeight()) + y;
            float width = ((this.Y + this.A0) - view4.getWidth()) + x;
            if (f < 0.0f) {
                this.Z = Math.abs(f) + this.Z;
            }
            if (f2 < 0.0f) {
                this.Y = Math.abs(f2) + this.Y;
            }
            if (height > 0.0f) {
                this.Z -= Math.abs(height);
            }
            if (width > 0.0f) {
                this.Y -= Math.abs(width);
            }
        }
    }

    public final String c() {
        rj rjVar = this.X;
        qj qjVar = rjVar.b;
        qj qjVar2 = rjVar.b;
        String str = qjVar.A0;
        WeakReference weakReference = this.b;
        if (str == null) {
            if (!h()) {
                return null;
            }
            int i = this.y0;
            if (i == -2 || f() <= i) {
                return NumberFormat.getInstance(qjVar2.E0).format(f());
            }
            Context context = (Context) weakReference.get();
            return context == null ? "" : String.format(qjVar2.E0, context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(i), "+");
        }
        int i2 = qjVar.C0;
        if (i2 == -2 || str == null || str.length() <= i2) {
            return str;
        }
        Context context2 = (Context) weakReference.get();
        if (context2 == null) {
            return "";
        }
        return String.format(context2.getString(R.string.m3_exceed_max_badge_text_suffix), str.substring(0, i2 - 1), "…");
    }

    public final CharSequence d() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        rj rjVar = this.X;
        qj qjVar = rjVar.b;
        if (qjVar.A0 != null) {
            CharSequence charSequence = qjVar.F0;
            return charSequence != null ? charSequence : rjVar.b.A0;
        }
        boolean zH = h();
        qj qjVar2 = rjVar.b;
        if (!zH) {
            return qjVar2.G0;
        }
        if (qjVar2.H0 == 0 || (context = (Context) this.b.get()) == null) {
            return null;
        }
        int i = this.y0;
        return (i == -2 || f() <= i) ? context.getResources().getQuantityString(qjVar2.H0, f(), Integer.valueOf(f())) : context.getString(qjVar2.I0, Integer.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String strC;
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f.draw(canvas);
        if (!g() || (strC = c()) == null) {
            return;
        }
        Rect rect = new Rect();
        ob4 ob4Var = this.z;
        ob4Var.a.getTextBounds(strC, 0, strC.length(), rect);
        float fExactCenterY = this.Z - rect.exactCenterY();
        canvas.drawText(strC, this.Y, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), ob4Var.a);
    }

    public final FrameLayout e() {
        WeakReference weakReference = this.D0;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public final int f() {
        int i = this.X.b.B0;
        if (i != -1) {
            return i;
        }
        return 0;
    }

    public final boolean g() {
        return this.X.b.A0 != null || h();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.X.b.z0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.A.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.A.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final boolean h() {
        qj qjVar = this.X.b;
        return qjVar.A0 == null && qjVar.B0 != -1;
    }

    public final void i() {
        Context context = (Context) this.b.get();
        if (context == null) {
            return;
        }
        boolean zG = g();
        rj rjVar = this.X;
        this.f.setShapeAppearanceModel(ou3.f(context, zG ? rjVar.b.Z.intValue() : rjVar.b.X.intValue(), g() ? rjVar.b.y0.intValue() : rjVar.b.Y.intValue()).b());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    public final void j(View view, FrameLayout frameLayout) {
        this.C0 = new WeakReference(view);
        this.D0 = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        k();
        invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0118 A[PHI: r13
      0x0118: PHI (r13v2 int) = (r13v1 int), (r13v8 int) binds: [B:45:0x00e4, B:47:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            Method dump skipped, instruction units count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pj.k():void");
    }

    @Override // android.graphics.drawable.Drawable, defpackage.nb4
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        rj rjVar = this.X;
        rjVar.a.z0 = i;
        rjVar.b.z0 = i;
        this.z.a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
