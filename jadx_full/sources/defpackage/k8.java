package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.StateSet;
import io.netty.handler.codec.dns.DnsRecord;
import org.xmlpull.v1.XmlPullParserException;

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
    */
    public static k8 c(Context context, Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws Throwable {
        int depth;
        int next;
        int next2;
        Context context2 = context;
        Resources resources2 = resources;
        String name = xmlResourceParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        k8 k8Var = new k8(null, null);
        TypedArray typedArrayO = l72.O(resources2, theme, attributeSet, tc3.a);
        int i = 1;
        k8Var.setVisible(typedArrayO.getBoolean(1, true), true);
        h8 h8Var = k8Var.F0;
        h8Var.d |= m80.b(typedArrayO);
        int i2 = 2;
        h8Var.i = typedArrayO.getBoolean(2, h8Var.i);
        int i3 = 3;
        h8Var.l = typedArrayO.getBoolean(3, h8Var.l);
        h8Var.y = typedArrayO.getInt(4, h8Var.y);
        h8Var.z = typedArrayO.getInt(5, h8Var.z);
        boolean z = false;
        k8Var.setDither(typedArrayO.getBoolean(0, h8Var.w));
        h8 h8Var2 = k8Var.b;
        if (resources2 != null) {
            h8Var2.b = resources2;
            int i4 = resources2.getDisplayMetrics().densityDpi;
            if (i4 == 0) {
                i4 = 160;
            }
            int i5 = h8Var2.c;
            h8Var2.c = i4;
            if (i5 != i4) {
                h8Var2.m = false;
                h8Var2.j = false;
            }
        } else {
            h8Var2.getClass();
        }
        typedArrayO.recycle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next3 = xmlResourceParser.next();
            if (next3 == i || ((depth = xmlResourceParser.getDepth()) < depth2 && next3 == i3)) {
                break;
            }
            if (next3 == i2 && depth <= depth2) {
                if (xmlResourceParser.getName().equals("item")) {
                    TypedArray typedArrayO2 = l72.O(resources2, theme, attributeSet, tc3.b);
                    int resourceId = typedArrayO2.getResourceId(z ? 1 : 0, z ? 1 : 0);
                    int resourceId2 = typedArrayO2.getResourceId(i, -1);
                    Drawable drawableF = resourceId2 > 0 ? ck3.d().f(context2, resourceId2) : null;
                    typedArrayO2.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr = new int[attributeCount];
                    int i6 = z ? 1 : 0;
                    for (int i7 = i6 == true ? 1 : 0; i7 < attributeCount; i7++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i7);
                        if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                            int i8 = (i6 == true ? 1 : 0) + 1;
                            if (!attributeSet.getAttributeBooleanValue(i7, z)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr[i6 == true ? 1 : 0] = attributeNameResource;
                            i6 = i8;
                        }
                    }
                    int[] iArrTrimStateSet = StateSet.trimStateSet(iArr, i6 == true ? 1 : 0);
                    if (drawableF == null) {
                        do {
                            next2 = xmlResourceParser.next();
                        } while (next2 == 4);
                        if (next2 != 2) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        if (xmlResourceParser.getName().equals("vector")) {
                            drawableF = new qo4();
                            drawableF.inflate(resources2, xmlResourceParser, attributeSet, theme);
                        } else {
                            drawableF = m80.a(resources, xmlResourceParser, attributeSet, theme);
                        }
                    }
                    if (drawableF == null) {
                        throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    h8 h8Var3 = k8Var.F0;
                    int iA = h8Var3.a(drawableF);
                    h8Var3.H[iA] = iArrTrimStateSet;
                    h8Var3.J.c(iA, Integer.valueOf(resourceId));
                } else if (xmlResourceParser.getName().equals("transition")) {
                    TypedArray typedArrayO3 = l72.O(resources2, theme, attributeSet, tc3.c);
                    int resourceId3 = typedArrayO3.getResourceId(2, -1);
                    int resourceId4 = typedArrayO3.getResourceId(1, -1);
                    int resourceId5 = typedArrayO3.getResourceId(z ? 1 : 0, -1);
                    Drawable drawableF2 = resourceId5 > 0 ? ck3.d().f(context2, resourceId5) : null;
                    boolean z2 = typedArrayO3.getBoolean(3, z);
                    typedArrayO3.recycle();
                    if (drawableF2 == null) {
                        do {
                            next = xmlResourceParser.next();
                        } while (next == 4);
                        if (next != 2) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        if (xmlResourceParser.getName().equals("animated-vector")) {
                            drawableF2 = new o8(context2, z ? 1 : 0);
                            drawableF2.inflate(resources2, xmlResourceParser, attributeSet, theme);
                        } else {
                            drawableF2 = m80.a(resources, xmlResourceParser, attributeSet, theme);
                        }
                    }
                    if (drawableF2 == null) {
                        throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    if (resourceId3 == -1 || resourceId4 == -1) {
                        break;
                    }
                    h8 h8Var4 = k8Var.F0;
                    int iA2 = h8Var4.a(drawableF2);
                    long j = resourceId3;
                    long j2 = resourceId4;
                    long j3 = (j << 32) | j2;
                    long j4 = z2 ? 8589934592L : 0L;
                    long j5 = iA2;
                    h8Var4.I.a(Long.valueOf(j5 | j4), j3);
                    if (z2) {
                        h8Var4.I.a(Long.valueOf(j5 | 4294967296L | j4), (j2 << 32) | j);
                    }
                    context2 = context;
                    resources2 = resources;
                    i = 1;
                    z = false;
                    i2 = 2;
                    i3 = 3;
                } else {
                    context2 = context;
                    resources2 = resources;
                }
                i = 1;
                i2 = 2;
                i3 = 3;
            }
        }
        throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(boolean z) {
        boolean z2;
        Drawable drawable;
        boolean z3 = true;
        this.Y = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.z;
        if (drawable2 != null) {
            long j = this.A0;
            if (j != 0) {
                if (j <= jUptimeMillis) {
                    drawable2.setAlpha(this.X);
                    this.A0 = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j - jUptimeMillis) * 255)) / this.b.y)) * this.X) / DnsRecord.CLASS_ANY);
                    z2 = true;
                }
            }
            drawable = this.A;
            if (drawable == null) {
                long j2 = this.B0;
                if (j2 != 0) {
                    if (j2 <= jUptimeMillis) {
                        drawable.setVisible(false, false);
                        this.A = null;
                        this.B0 = 0L;
                    } else {
                        drawable.setAlpha(((((int) ((j2 - jUptimeMillis) * 255)) / this.b.z) * this.X) / DnsRecord.CLASS_ANY);
                    }
                }
                if (z && z3) {
                    scheduleSelf(this.z0, jUptimeMillis + 16);
                    return;
                }
                return;
            }
            this.B0 = 0L;
            z3 = z2;
            if (z) {
                return;
            } else {
                return;
            }
        }
        this.A0 = 0L;
        z2 = false;
        drawable = this.A;
        if (drawable == null) {
        }
        z3 = z2;
        if (z) {
        }
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
    */
    public final boolean h(int i) {
        if (i == this.Z) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.b.z > 0) {
            Drawable drawable = this.A;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.z;
            if (drawable2 != null) {
                this.A = drawable2;
                this.B0 = ((long) this.b.z) + jUptimeMillis;
            } else {
                this.A = null;
                this.B0 = 0L;
            }
        } else {
            Drawable drawable3 = this.z;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i >= 0) {
            h8 h8Var = this.b;
            if (i < h8Var.h) {
                Drawable drawableD = h8Var.d(i);
                this.z = drawableD;
                this.Z = i;
                if (drawableD != null) {
                    int i2 = this.b.y;
                    if (i2 > 0) {
                        this.A0 = jUptimeMillis + ((long) i2);
                    }
                    d(drawableD);
                }
            } else {
                this.z = null;
                this.Z = -1;
            }
        }
        if (this.A0 != 0 || this.B0 != 0) {
            f33 f33Var = this.z0;
            if (f33Var == null) {
                this.z0 = new f33(6, this);
            } else {
                unscheduleSelf(f33Var);
            }
            a(true);
        }
        invalidateSelf();
        return true;
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
    */
    public final boolean onStateChange(int[] iArr) {
        int i;
        ez4 g8Var;
        h8 h8Var = this.F0;
        int iF = h8Var.f(iArr);
        if (iF < 0) {
            iF = h8Var.f(StateSet.WILD_CARD);
        }
        boolean z = false;
        z = false;
        if (iF != this.Z) {
            ez4 ez4Var = this.G0;
            int i2 = 1;
            if (ez4Var != null) {
                if (iF != this.H0) {
                    if (iF == this.I0 && ez4Var.i()) {
                        ez4Var.T();
                        this.H0 = this.I0;
                        this.I0 = iF;
                    } else {
                        i = this.H0;
                        ez4Var.W();
                    }
                }
                z = true;
            } else {
                i = this.Z;
            }
            this.G0 = null;
            this.I0 = -1;
            this.H0 = -1;
            h8 h8Var2 = this.F0;
            int iE = h8Var2.e(i);
            int iE2 = h8Var2.e(iF);
            if (iE2 != 0 && iE != 0) {
                long j = ((long) iE2) | (((long) iE) << 32);
                int iLongValue = (int) ((Long) h8Var2.I.e(j)).longValue();
                if (iLongValue >= 0) {
                    boolean z2 = (((Long) h8Var2.I.e(j)).longValue() & 8589934592L) != 0;
                    h(iLongValue);
                    Drawable drawable = this.z;
                    if (drawable instanceof AnimationDrawable) {
                        g8Var = new i8((AnimationDrawable) drawable, (((Long) h8Var2.I.e(j)).longValue() & 4294967296L) != 0, z2);
                    } else if (drawable instanceof o8) {
                        g8Var = new g8((o8) drawable, i2);
                    } else {
                        if (drawable instanceof Animatable) {
                            g8Var = new g8((Animatable) drawable, z ? 1 : 0);
                        }
                        if (h(iF)) {
                        }
                    }
                    g8Var.V();
                    this.G0 = g8Var;
                    this.I0 = i;
                    this.H0 = iF;
                    z = true;
                }
            } else if (h(iF)) {
                z = true;
            }
        }
        Drawable drawable2 = this.z;
        return drawable2 != null ? (drawable2.setState(iArr) ? 1 : 0) | z : z;
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
