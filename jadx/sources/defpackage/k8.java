package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k8 extends Drawable implements Drawable.Callback {
    public static final /* synthetic */ int K0 = 0;
    public Drawable A;
    public long A0;
    public long B0;
    public l8 C0;
    public h8 D0;
    public boolean E0;
    public h8 F0;
    public ez4 G0;
    public boolean J0;
    public boolean Y;
    public h8 b;
    public Rect f;
    public boolean y0;
    public Drawable z;
    public f33 z0;
    public int X = DnsRecord.CLASS_ANY;
    public int Z = -1;
    public int H0 = -1;
    public int I0 = -1;

    public k8(h8 h8Var, Resources resources) {
        i(new h8(h8Var, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0272, code lost:
    
        r5.onStateChange(r5.getState());
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0279, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.k8 c(android.content.Context r24, android.content.res.Resources r25, android.content.res.XmlResourceParser r26, android.util.AttributeSet r27, android.content.res.Resources.Theme r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k8.c(android.content.Context, android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):k8");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.Y = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.z
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L36
            long r9 = r13.A0
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L38
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.X
            r3.setAlpha(r9)
            r13.A0 = r6
            goto L38
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            h8 r10 = r13.b
            int r10 = r10.y
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.X
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L39
        L36:
            r13.A0 = r6
        L38:
            r3 = r8
        L39:
            android.graphics.drawable.Drawable r9 = r13.A
            if (r9 == 0) goto L61
            long r10 = r13.B0
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L63
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L50
            r9.setVisible(r8, r8)
            r0 = 0
            r13.A = r0
            r13.B0 = r6
            goto L63
        L50:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            h8 r4 = r13.b
            int r4 = r4.z
            int r3 = r3 / r4
            int r4 = r13.X
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L64
        L61:
            r13.B0 = r6
        L63:
            r0 = r3
        L64:
            if (r14 == 0) goto L70
            if (r0 == 0) goto L70
            f33 r14 = r13.z0
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k8.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        b(theme);
        onStateChange(getState());
    }

    public final void b(Resources.Theme theme) {
        h8 h8Var = this.b;
        if (theme == null) {
            h8Var.getClass();
            return;
        }
        h8Var.c();
        int i = h8Var.h;
        Drawable[] drawableArr = h8Var.g;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.canApplyTheme()) {
                drawableArr[i2].applyTheme(theme);
                h8Var.e |= drawableArr[i2].getChangingConfigurations();
            }
        }
        Resources resources = theme.getResources();
        if (resources != null) {
            h8Var.b = resources;
            int i3 = resources.getDisplayMetrics().densityDpi;
            if (i3 == 0) {
                i3 = 160;
            }
            int i4 = h8Var.c;
            h8Var.c = i3;
            if (i4 != i3) {
                h8Var.m = false;
                h8Var.j = false;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return this.b.canApplyTheme();
    }

    public final void d(Drawable drawable) {
        l8 l8Var = this.C0;
        if (l8Var == null) {
            l8Var = new l8();
            this.C0 = l8Var;
        }
        l8Var.f = drawable.getCallback();
        drawable.setCallback(l8Var);
        try {
            if (this.b.y <= 0 && this.Y) {
                drawable.setAlpha(this.X);
            }
            h8 h8Var = this.b;
            if (h8Var.C) {
                drawable.setColorFilter(h8Var.B);
            } else {
                if (h8Var.F) {
                    drawable.setTintList(h8Var.D);
                }
                h8 h8Var2 = this.b;
                if (h8Var2.G) {
                    drawable.setTintMode(h8Var2.E);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.b.w);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setAutoMirrored(this.b.A);
            Rect rect = this.f;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
            l8 l8Var2 = this.C0;
            Drawable.Callback callback = (Drawable.Callback) l8Var2.f;
            l8Var2.f = null;
            drawable.setCallback(callback);
        } catch (Throwable th) {
            l8 l8Var3 = this.C0;
            Drawable.Callback callback2 = (Drawable.Callback) l8Var3.f;
            l8Var3.f = null;
            drawable.setCallback(callback2);
            throw th;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.z;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.A;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final void e() {
        boolean z;
        Drawable drawable = this.A;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.A = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.z;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.Y) {
                this.z.setAlpha(this.X);
            }
        }
        if (this.B0 != 0) {
            this.B0 = 0L;
            z = true;
        }
        if (this.A0 != 0) {
            this.A0 = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    public final Drawable f() {
        if (!this.y0 && super.mutate() == this) {
            h8 h8Var = new h8(this.F0, this, null);
            h8Var.I = h8Var.I.clone();
            h8Var.J = h8Var.J.clone();
            i(h8Var);
            this.y0 = true;
        }
        return this;
    }

    public final Drawable g() {
        if (!this.E0) {
            f();
            h8 h8Var = this.D0;
            h8Var.I = h8Var.I.clone();
            h8Var.J = h8Var.J.clone();
            this.E0 = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.X;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return this.b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z;
        h8 h8Var = this.b;
        if (!h8Var.u) {
            h8Var.c();
            h8Var.u = true;
            int i = h8Var.h;
            Drawable[] drawableArr = h8Var.g;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    h8Var.v = true;
                    z = true;
                    break;
                }
                if (drawableArr[i2].getConstantState() == null) {
                    h8Var.v = false;
                    z = false;
                    break;
                }
                i2++;
            }
        } else {
            z = h8Var.v;
        }
        if (!z) {
            return null;
        }
        this.b.d = getChangingConfigurations();
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        h8 h8Var = this.b;
        if (h8Var.l) {
            if (!h8Var.m) {
                h8Var.b();
            }
            return h8Var.o;
        }
        Drawable drawable = this.z;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        h8 h8Var = this.b;
        if (h8Var.l) {
            if (!h8Var.m) {
                h8Var.b();
            }
            return h8Var.n;
        }
        Drawable drawable = this.z;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        h8 h8Var = this.b;
        if (h8Var.l) {
            if (!h8Var.m) {
                h8Var.b();
            }
            return h8Var.q;
        }
        Drawable drawable = this.z;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        h8 h8Var = this.b;
        if (h8Var.l) {
            if (!h8Var.m) {
                h8Var.b();
            }
            return h8Var.p;
        }
        Drawable drawable = this.z;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.z;
        if (drawable != null && drawable.isVisible()) {
            h8 h8Var = this.b;
            if (h8Var.r) {
                return h8Var.s;
            }
            h8Var.c();
            int i = h8Var.h;
            Drawable[] drawableArr = h8Var.g;
            opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            h8Var.s = opacity;
            h8Var.r = true;
        }
        return opacity;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable = this.z;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        h8 h8Var = this.b;
        Rect rect2 = null;
        boolean padding = false;
        if (!h8Var.i) {
            Rect rect3 = h8Var.k;
            if (rect3 != null || h8Var.j) {
                rect2 = rect3;
            } else {
                h8Var.c();
                Rect rect4 = new Rect();
                int i = h8Var.h;
                Drawable[] drawableArr = h8Var.g;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i3 = rect4.left;
                        if (i3 > rect2.left) {
                            rect2.left = i3;
                        }
                        int i4 = rect4.top;
                        if (i4 > rect2.top) {
                            rect2.top = i4;
                        }
                        int i5 = rect4.right;
                        if (i5 > rect2.right) {
                            rect2.right = i5;
                        }
                        int i6 = rect4.bottom;
                        if (i6 > rect2.bottom) {
                            rect2.bottom = i6;
                        }
                    }
                }
                h8Var.j = true;
                h8Var.k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                padding = true;
            }
        } else {
            Drawable drawable = this.z;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.b.A && getLayoutDirection() == 1) {
            int i7 = rect.left;
            rect.left = rect.right;
            rect.right = i7;
        }
        return padding;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(int r10) {
        /*
            r9 = this;
            int r0 = r9.Z
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            h8 r0 = r9.b
            int r0 = r0.z
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.A
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.z
            if (r0 == 0) goto L29
            r9.A = r0
            h8 r0 = r9.b
            int r0 = r0.z
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.B0 = r0
            goto L35
        L29:
            r9.A = r4
            r9.B0 = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.z
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            h8 r0 = r9.b
            int r1 = r0.h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.d(r10)
            r9.z = r0
            r9.Z = r10
            if (r0 == 0) goto L5a
            h8 r10 = r9.b
            int r10 = r10.y
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.A0 = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.z = r4
            r10 = -1
            r9.Z = r10
        L5a:
            long r0 = r9.A0
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L67
            long r1 = r9.B0
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L7a
        L67:
            f33 r10 = r9.z0
            if (r10 != 0) goto L74
            f33 r10 = new f33
            r1 = 6
            r10.<init>(r1, r9)
            r9.z0 = r10
            goto L77
        L74:
            r9.unscheduleSelf(r10)
        L77:
            r9.a(r0)
        L7a:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k8.h(int):boolean");
    }

    public final void i(h8 h8Var) {
        this.b = h8Var;
        int i = this.Z;
        if (i >= 0) {
            Drawable drawableD = h8Var.d(i);
            this.z = drawableD;
            if (drawableD != null) {
                d(drawableD);
            }
        }
        this.A = null;
        this.D0 = h8Var;
        this.F0 = h8Var;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        h8 h8Var = this.b;
        if (h8Var != null) {
            h8Var.r = false;
            h8Var.t = false;
        }
        if (drawable != this.z || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.b.A;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    public final boolean j(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.A;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.z;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        e();
        ez4 ez4Var = this.G0;
        if (ez4Var != null) {
            ez4Var.W();
            this.G0 = null;
            h(this.H0);
            this.H0 = -1;
            this.I0 = -1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.J0) {
            g();
            h8 h8Var = this.F0;
            h8Var.I = h8Var.I.clone();
            h8Var.J = h8Var.J.clone();
            this.J0 = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.A;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.z;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        h8 h8Var = this.b;
        int i2 = this.Z;
        int i3 = h8Var.h;
        Drawable[] drawableArr = h8Var.g;
        boolean z = false;
        for (int i4 = 0; i4 < i3; i4++) {
            Drawable drawable = drawableArr[i4];
            if (drawable != null) {
                boolean layoutDirection = drawable.setLayoutDirection(i);
                if (i4 == i2) {
                    z = layoutDirection;
                }
            }
        }
        h8Var.x = i;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.A;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.z;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onStateChange(int[] r15) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k8.onStateChange(int[]):boolean");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.z || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.Y && this.X == i) {
            return;
        }
        this.Y = true;
        this.X = i;
        Drawable drawable = this.z;
        if (drawable != null) {
            if (this.A0 == 0) {
                drawable.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        h8 h8Var = this.b;
        if (h8Var.A != z) {
            h8Var.A = z;
            Drawable drawable = this.z;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        h8 h8Var = this.b;
        h8Var.C = true;
        if (h8Var.B != colorFilter) {
            h8Var.B = colorFilter;
            Drawable drawable = this.z;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        h8 h8Var = this.b;
        if (h8Var.w != z) {
            h8Var.w = z;
            Drawable drawable = this.z;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        Drawable drawable = this.z;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f;
        if (rect == null) {
            this.f = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.z;
        if (drawable != null) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        h8 h8Var = this.b;
        h8Var.F = true;
        if (h8Var.D != colorStateList) {
            h8Var.D = colorStateList;
            this.z.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        h8 h8Var = this.b;
        h8Var.G = true;
        if (h8Var.E != mode) {
            h8Var.E = mode;
            this.z.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean zJ = j(z, z2);
        ez4 ez4Var = this.G0;
        if (ez4Var != null && (zJ || z2)) {
            if (z) {
                ez4Var.V();
                return zJ;
            }
            jumpToCurrentState();
        }
        return zJ;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.z || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
