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
    */
    public final void k() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        WeakReference weakReference = this.b;
        Context context = (Context) weakReference.get();
        WeakReference weakReference2 = this.C0;
        View view = weakReference2 != null ? (View) weakReference2.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        Rect rect2 = this.A;
        rect.set(rect2);
        Rect rect3 = new Rect();
        view.getDrawingRect(rect3);
        WeakReference weakReference3 = this.D0;
        ViewGroup viewGroup = weakReference3 != null ? (ViewGroup) weakReference3.get() : null;
        if (viewGroup != null) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect3);
        }
        boolean zG = g();
        rj rjVar = this.X;
        float f9 = zG ? rjVar.d : rjVar.c;
        this.z0 = f9;
        if (f9 != -1.0f) {
            this.A0 = f9;
            this.B0 = f9;
        } else {
            this.A0 = Math.round((g() ? rjVar.g : rjVar.e) / 2.0f);
            this.B0 = Math.round((g() ? rjVar.h : rjVar.f) / 2.0f);
        }
        if (g()) {
            String strC = c();
            float f10 = this.A0;
            ob4 ob4Var = this.z;
            if (ob4Var.e) {
                ob4Var.a(strC);
                f8 = ob4Var.c;
            } else {
                f8 = ob4Var.c;
            }
            this.A0 = Math.max(f10, (f8 / 2.0f) + rjVar.b.L0.intValue());
            float f11 = this.B0;
            if (ob4Var.e) {
                ob4Var.a(strC);
            }
            float fMax = Math.max(f11, (ob4Var.d / 2.0f) + rjVar.b.M0.intValue());
            this.B0 = fMax;
            this.A0 = Math.max(this.A0, fMax);
        }
        qj qjVar = rjVar.b;
        qj qjVar2 = rjVar.b;
        int i = rjVar.k;
        int iIntValue = qjVar.O0.intValue();
        if (g()) {
            iIntValue = qjVar.Q0.intValue();
            Context context2 = (Context) weakReference.get();
            if (context2 != null) {
                f = -1.0f;
                iIntValue = t8.c(iIntValue, t8.b(0.0f, 1.0f, 0.3f, 1.0f, context2.getResources().getConfiguration().fontScale - 1.0f), iIntValue - qjVar.T0.intValue());
            } else {
                f = -1.0f;
            }
        }
        if (i == 0) {
            iIntValue -= Math.round(this.B0);
        }
        int iIntValue2 = qjVar.S0.intValue() + iIntValue;
        int iIntValue3 = qjVar2.J0.intValue();
        if (iIntValue3 == 8388691 || iIntValue3 == 8388693) {
            this.Z = rect3.bottom - iIntValue2;
        } else {
            this.Z = rect3.top + iIntValue2;
        }
        int iIntValue4 = g() ? qjVar.P0.intValue() : qjVar2.N0.intValue();
        if (i == 1) {
            iIntValue4 += g() ? rjVar.j : rjVar.i;
        }
        int iIntValue5 = qjVar.R0.intValue() + iIntValue4;
        int iIntValue6 = qjVar2.J0.intValue();
        if (iIntValue6 == 8388659 || iIntValue6 == 8388691) {
            if (rjVar.l == 0) {
                if (view.getLayoutDirection() == 0) {
                    f2 = rect3.left + this.A0;
                    f3 = (this.B0 * 2.0f) - iIntValue5;
                    f4 = f2 - f3;
                    this.Y = f4;
                } else {
                    f4 = (rect3.right - this.A0) + ((this.B0 * 2.0f) - iIntValue5);
                    this.Y = f4;
                }
            } else if (view.getLayoutDirection() == 0) {
                f4 = (rect3.left - this.A0) + iIntValue5;
                this.Y = f4;
            } else {
                f2 = rect3.right + this.A0;
                f3 = iIntValue5;
                f4 = f2 - f3;
                this.Y = f4;
            }
        } else if (rjVar.l == 0) {
            if (view.getLayoutDirection() == 0) {
                f5 = rect3.right + this.A0;
                f6 = iIntValue5;
                f7 = f5 - f6;
                this.Y = f7;
            } else {
                f7 = (rect3.left - this.A0) + iIntValue5;
                this.Y = f7;
            }
        } else if (view.getLayoutDirection() == 0) {
            f7 = (rect3.right - this.A0) + ((this.B0 * 2.0f) - iIntValue5);
            this.Y = f7;
        } else {
            f5 = rect3.left + this.A0;
            f6 = (this.B0 * 2.0f) - iIntValue5;
            f7 = f5 - f6;
            this.Y = f7;
        }
        if (qjVar.U0.booleanValue()) {
            ViewParent viewParentE = e();
            if (viewParentE == null) {
                viewParentE = view.getParent();
            }
            if ((viewParentE instanceof View) && (viewParentE.getParent() instanceof View)) {
                b(view, (View) viewParentE.getParent());
            }
        } else {
            b(view, null);
        }
        float f12 = this.Y;
        float f13 = this.Z;
        float f14 = this.A0;
        float f15 = this.B0;
        rect2.set((int) (f12 - f14), (int) (f13 - f15), (int) (f12 + f14), (int) (f13 + f15));
        float f16 = this.z0;
        yi2 yi2Var = this.f;
        if (f16 != f) {
            yi2Var.setShapeAppearanceModel(yi2Var.f.a.a(f16));
        }
        if (rect.equals(rect2)) {
            return;
        }
        yi2Var.setBounds(rect2);
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
