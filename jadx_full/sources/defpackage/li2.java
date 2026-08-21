package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.getsurfboard.R;
import com.google.android.material.card.MaterialCardView;
import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class li2 {
    public static final ColorDrawable A;
    public static final double z = Math.cos(Math.toRadians(45.0d));
    public final MaterialCardView a;
    public final yi2 c;
    public final yi2 d;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Drawable j;
    public Drawable k;
    public ColorStateList l;
    public ColorStateList m;
    public nu3 n;
    public ColorStateList o;
    public RippleDrawable p;
    public LayerDrawable q;
    public yi2 r;
    public boolean t;
    public ValueAnimator u;
    public final TimeInterpolator v;
    public final int w;
    public final int x;
    public final Rect b = new Rect();
    public boolean s = false;
    public float y = 0.0f;

    static {
        A = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public li2(MaterialCardView materialCardView, AttributeSet attributeSet) {
        this.e = -1.0f;
        this.a = materialCardView;
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, vc3.a, R.attr.materialCardViewStyle, R.style.CardView);
        yi2 yi2Var = new yi2(materialCardView.getContext(), attributeSet, R.attr.materialCardViewStyle, R.style.Widget_MaterialComponents_CardView);
        this.c = yi2Var;
        yi2Var.l(materialCardView.getContext());
        yi2Var.r(-12303292);
        qy1 qy1VarL = yi2Var.getShapeAppearanceModel().l();
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
            this.e = dimension;
            qy1VarL.e = new a0(dimension);
            qy1VarL.f = new a0(dimension);
            qy1VarL.g = new a0(dimension);
            qy1VarL.h = new a0(dimension);
        }
        this.d = new yi2();
        h(qy1VarL.b());
        this.v = l72.W(materialCardView.getContext(), R.attr.motionEasingLinearInterpolator, t8.a);
        this.w = ek0.C(materialCardView.getContext(), R.attr.motionDurationShort2, 300);
        this.x = ek0.C(materialCardView.getContext(), R.attr.motionDurationShort1, 300);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float b(fx3 fx3Var, float f) {
        if (fx3Var instanceof cm3) {
            return (float) ((1.0d - z) * ((double) f));
        }
        if (fx3Var instanceof ug0) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    public final float a() {
        float fMax = 0.0f;
        for (ou3 ou3Var : this.n.c()) {
            if (ou3Var != null) {
                fx3 fx3Var = ou3Var.a;
                yi2 yi2Var = this.c;
                float fB = b(fx3Var, yi2Var.i());
                fx3 fx3Var2 = ou3Var.b;
                float[] fArr = yi2Var.T0;
                float fMax2 = Math.max(fB, b(fx3Var2, fArr != null ? fArr[0] : yi2Var.f.a.d().f.a(yi2Var.g())));
                fx3 fx3Var3 = ou3Var.c;
                float[] fArr2 = yi2Var.T0;
                float fB2 = b(fx3Var3, fArr2 != null ? fArr2[1] : yi2Var.f.a.d().g.a(yi2Var.g()));
                fx3 fx3Var4 = ou3Var.d;
                float[] fArr3 = yi2Var.T0;
                fMax = Math.max(fMax, Math.max(fMax2, Math.max(fB2, b(fx3Var4, fArr3 != null ? fArr3[2] : yi2Var.f.a.d().h.a(yi2Var.g())))));
            }
        }
        return fMax;
    }

    public final LayerDrawable c() {
        if (this.p == null) {
            this.r = new yi2(this.n);
            this.p = new RippleDrawable(this.l, null, this.r);
        }
        if (this.q == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.p, this.d, this.k});
            this.q = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.q;
    }

    public final ki2 d(Drawable drawable) {
        int iCeil;
        int i;
        if (this.a.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil((r0.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f));
            iCeil = (int) Math.ceil(r0.getMaxCardElevation() + (i() ? a() : 0.0f));
            i = iCeil2;
        } else {
            iCeil = 0;
            i = 0;
        }
        return new ki2(drawable, iCeil, i, iCeil, i);
    }

    public final void e(int i, int i2) {
        int iCeil;
        int iCeil2;
        int i3;
        int i4;
        if (this.q != null) {
            MaterialCardView materialCardView = this.a;
            if (materialCardView.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f)) * 2.0f);
                iCeil2 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (i() ? a() : 0.0f)) * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i5 = this.h;
            boolean z2 = (i5 & 8388613) == 8388613;
            int i6 = this.f;
            int i7 = z2 ? ((i - i6) - this.g) - iCeil2 : i6;
            int i8 = (i5 & 80) == 80 ? i6 : ((i2 - i6) - this.g) - iCeil;
            int i9 = (i5 & 8388613) == 8388613 ? i6 : ((i - i6) - this.g) - iCeil2;
            if ((i5 & 80) == 80) {
                i6 = ((i2 - i6) - this.g) - iCeil;
            }
            int i10 = i6;
            if (materialCardView.getLayoutDirection() == 1) {
                i4 = i9;
                i3 = i7;
            } else {
                i3 = i9;
                i4 = i7;
            }
            this.q.setLayerInset(2, i4, i10, i3, i8);
        }
    }

    public final void f(boolean z2, boolean z3) {
        Drawable drawable = this.k;
        if (drawable != null) {
            if (!z3) {
                drawable.setAlpha(z2 ? DnsRecord.CLASS_ANY : 0);
                this.y = z2 ? 1.0f : 0.0f;
                return;
            }
            float f = z2 ? 1.0f : 0.0f;
            float f2 = this.y;
            if (z2) {
                f2 = 1.0f - f2;
            }
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.u = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.y, f);
            this.u = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new rt0(2, this));
            this.u.setInterpolator(this.v);
            this.u.setDuration((long) ((z2 ? this.w : this.x) * f2));
            this.u.start();
        }
    }

    public final void g(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.k = drawableMutate;
            drawableMutate.setTintList(this.m);
            f(this.a.C0, false);
        } else {
            this.k = A;
        }
        LayerDrawable layerDrawable = this.q;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.k);
        }
    }

    public final void h(nu3 nu3Var) {
        this.n = nu3Var;
        yi2 yi2Var = this.c;
        yi2Var.u(nu3Var);
        this.d.u(nu3Var);
        yi2 yi2Var2 = this.r;
        if (yi2Var2 != null) {
            yi2Var2.u(nu3Var);
        }
        yi2Var.O0 = !yi2Var.m();
    }

    public final boolean i() {
        MaterialCardView materialCardView = this.a;
        return materialCardView.getPreventCornerOverlap() && this.c.m() && materialCardView.getUseCompatPadding();
    }

    public final boolean j() {
        View view = this.a;
        if (view.isClickable()) {
            return true;
        }
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    public final void k() {
        Drawable drawable = this.j;
        Drawable drawableC = j() ? c() : this.d;
        this.j = drawableC;
        if (drawable != drawableC) {
            MaterialCardView materialCardView = this.a;
            if (materialCardView.getForeground() instanceof InsetDrawable) {
                ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawableC);
            } else {
                materialCardView.setForeground(d(drawableC));
            }
        }
    }

    public final void l() {
        MaterialCardView materialCardView = this.a;
        float cardViewRadius = 0.0f;
        float fA = ((!materialCardView.getPreventCornerOverlap() || this.c.m()) && !i()) ? 0.0f : a();
        if (materialCardView.getPreventCornerOverlap() && materialCardView.getUseCompatPadding()) {
            cardViewRadius = (float) ((1.0d - z) * ((double) materialCardView.getCardViewRadius()));
        }
        int i = (int) (fA - cardViewRadius);
        Rect rect = this.b;
        materialCardView.z.set(rect.left + i, rect.top + i, rect.right + i, rect.bottom + i);
        lb lbVar = materialCardView.y0;
        if (!((q10) lbVar.z).getUseCompatPadding()) {
            lbVar.M(0, 0, 0, 0);
            return;
        }
        yl3 yl3Var = (yl3) lbVar.f;
        float f = yl3Var.e;
        float f2 = yl3Var.a;
        int iCeil = (int) Math.ceil(zl3.a(f, f2, r0.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(zl3.b(f, f2, r0.getPreventCornerOverlap()));
        lbVar.M(iCeil, iCeil2, iCeil, iCeil2);
    }

    public final void m() {
        boolean z2 = this.s;
        MaterialCardView materialCardView = this.a;
        if (!z2) {
            materialCardView.setBackgroundInternal(d(this.c));
        }
        materialCardView.setForeground(d(this.j));
    }
}
