package androidx.camera.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import defpackage.ad4;
import defpackage.am2;
import defpackage.br4;
import defpackage.co4;
import defpackage.ez4;
import defpackage.i43;
import defpackage.j74;
import defpackage.kg4;
import defpackage.kz;
import defpackage.l74;
import defpackage.lq3;
import defpackage.mx2;
import defpackage.o43;
import defpackage.oj1;
import defpackage.on2;
import defpackage.p43;
import defpackage.q43;
import defpackage.r10;
import defpackage.r43;
import defpackage.s43;
import defpackage.t43;
import defpackage.u43;
import defpackage.uc3;
import defpackage.vp1;
import defpackage.vx1;
import defpackage.wp4;
import defpackage.wt0;
import defpackage.yc2;
import defpackage.yy;
import defpackage.zo2;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class PreviewView extends FrameLayout {
    public static final /* synthetic */ int G0 = 0;
    public final o43 A;
    public final AtomicReference A0;
    public final u43 B0;
    public kz C0;
    public final p43 D0;
    public final r10 E0;
    public final oj1 F0;
    public q43 b;
    public t43 f;
    public boolean y0;
    public final lq3 z;
    public final on2 z0;

    public PreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        this.b = q43.PERFORMANCE;
        o43 o43Var = new o43();
        o43Var.h = r43.FILL_CENTER;
        this.A = o43Var;
        this.y0 = true;
        this.z0 = new on2(s43.b);
        this.A0 = new AtomicReference();
        this.B0 = new u43(o43Var);
        this.D0 = new p43(this);
        this.E0 = new r10(3, this);
        this.F0 = new oj1(20, this);
        co4.h();
        Resources.Theme theme = context.getTheme();
        int[] iArr = uc3.a;
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        wp4.m(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0);
        try {
            int integer = typedArrayObtainStyledAttributes.getInteger(1, o43Var.h.b);
            for (r43 r43Var : r43.values()) {
                if (r43Var.b == integer) {
                    setScaleType(r43Var);
                    int integer2 = typedArrayObtainStyledAttributes.getInteger(0, 0);
                    for (q43 q43Var : q43.values()) {
                        if (q43Var.b == integer2) {
                            setImplementationMode(q43Var);
                            typedArrayObtainStyledAttributes.recycle();
                            new l74(context, new zo2(28));
                            if (getBackground() == null) {
                                setBackgroundColor(getContext().getColor(R.color.black));
                            }
                            lq3 lq3Var = new lq3(context, null, 0, 0);
                            lq3Var.setBackgroundColor(-1);
                            lq3Var.setAlpha(0.0f);
                            lq3Var.setElevation(Float.MAX_VALUE);
                            this.z = lq3Var;
                            lq3Var.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                            return;
                        }
                    }
                    throw new IllegalArgumentException("Unknown implementation mode id " + integer2);
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + integer);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public static boolean b(j74 j74Var, q43 q43Var) {
        boolean zEquals = j74Var.d.r().j().equals("androidx.camera.camera2.legacy");
        boolean z = (wt0.a.z(SurfaceViewStretchedQuirk.class) == null && wt0.a.z(SurfaceViewNotCroppedByParentQuirk.class) == null) ? false : true;
        if (Build.VERSION.SDK_INT > 24 && !zEquals && !z) {
            int iOrdinal = q43Var.ordinal();
            if (iOrdinal == 0) {
                return false;
            }
            if (iOrdinal != 1) {
                vp1.h(q43Var, "Invalid implementation mode: ");
                return false;
            }
        }
        return true;
    }

    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getSystemService("display");
    }

    private vx1 getScreenFlashInternal() {
        return this.z.getScreenFlash();
    }

    private int getViewPortScaleType() {
        int iOrdinal = getScaleType().ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3 && iOrdinal != 4 && iOrdinal != 5) {
                    zo2.v(getScaleType(), "Unexpected scale type: ");
                    return 0;
                }
            }
        }
        return i;
    }

    private void setScreenFlashUiInfo(vx1 vx1Var) {
        ez4.o("PreviewView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public final void a() {
        Rect rect;
        Display defaultDisplay;
        kz kzVar;
        co4.h();
        if (this.f != null) {
            if (this.y0 && (defaultDisplay = getDefaultDisplay()) != null && (kzVar = this.C0) != null) {
                o43 o43Var = this.A;
                int iK = kzVar.k(defaultDisplay.getRotation());
                int rotation = defaultDisplay.getRotation();
                if (o43Var.g) {
                    o43Var.c = iK;
                    o43Var.e = rotation;
                }
            }
            this.f.f();
        }
        u43 u43Var = this.B0;
        Size size = new Size(getWidth(), getHeight());
        int layoutDirection = getLayoutDirection();
        u43Var.getClass();
        co4.h();
        synchronized (u43Var) {
            try {
                if (size.getWidth() != 0 && size.getHeight() != 0 && (rect = u43Var.b) != null) {
                    u43Var.a.a(size, layoutDirection, rect);
                }
            } finally {
            }
        }
    }

    public Bitmap getBitmap() {
        co4.h();
        t43 t43Var = this.f;
        if (t43Var == null) {
            return null;
        }
        FrameLayout frameLayout = t43Var.b;
        Bitmap bitmapB = t43Var.b();
        if (bitmapB == null) {
            return null;
        }
        o43 o43Var = t43Var.c;
        Size size = new Size(frameLayout.getWidth(), frameLayout.getHeight());
        int layoutDirection = frameLayout.getLayoutDirection();
        if (!o43Var.f()) {
            return bitmapB;
        }
        Matrix matrixD = o43Var.d();
        RectF rectFE = o43Var.e(size, layoutDirection);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), bitmapB.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.postConcat(matrixD);
        matrix.postScale(rectFE.width() / o43Var.a.getWidth(), rectFE.height() / o43Var.a.getHeight());
        matrix.postTranslate(rectFE.left, rectFE.top);
        canvas.drawBitmap(bitmapB, matrix, new Paint(7));
        return bitmapCreateBitmap;
    }

    public yy getController() {
        co4.h();
        return null;
    }

    public Display getDefaultDisplay() {
        if (getDisplay() == null) {
            return null;
        }
        Display display = getDisplayManager().getDisplay(0);
        return display != null ? display : getDisplay();
    }

    public q43 getImplementationMode() {
        co4.h();
        return this.b;
    }

    public am2 getMeteringPointFactory() {
        co4.h();
        return this.B0;
    }

    public mx2 getOutputTransform() {
        Matrix matrixC;
        o43 o43Var = this.A;
        co4.h();
        try {
            matrixC = o43Var.c(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrixC = null;
        }
        Rect rect = o43Var.b;
        if (matrixC == null || rect == null) {
            ez4.o("PreviewView", "Transform info is not ready");
            return null;
        }
        RectF rectF = kg4.a;
        RectF rectF2 = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(kg4.a, rectF2, Matrix.ScaleToFit.FILL);
        matrixC.preConcat(matrix);
        if (this.f instanceof ad4) {
            matrixC.postConcat(getMatrix());
        } else if (!getMatrix().isIdentity()) {
            ez4.a0("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
        }
        new Size(rect.width(), rect.height());
        return new mx2();
    }

    public yc2 getPreviewStreamState() {
        return this.z0;
    }

    public r43 getScaleType() {
        co4.h();
        return this.A.h;
    }

    public vx1 getScreenFlash() {
        return getScreenFlashInternal();
    }

    public Matrix getSensorToViewTransform() {
        co4.h();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        Size size = new Size(getWidth(), getHeight());
        int layoutDirection = getLayoutDirection();
        o43 o43Var = this.A;
        if (!o43Var.f()) {
            return null;
        }
        Matrix matrix = new Matrix(o43Var.d);
        matrix.postConcat(o43Var.c(size, layoutDirection));
        return matrix;
    }

    public i43 getSurfaceProvider() {
        co4.h();
        return this.F0;
    }

    public br4 getViewPort() {
        co4.h();
        Display defaultDisplay = getDefaultDisplay();
        if (defaultDisplay == null) {
            return null;
        }
        defaultDisplay.getRotation();
        co4.h();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        new Rational(getWidth(), getHeight());
        getViewPortScaleType();
        getLayoutDirection();
        return new br4();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        DisplayManager displayManager;
        super.onAttachedToWindow();
        if (!isInEditMode() && (displayManager = getDisplayManager()) != null) {
            displayManager.registerDisplayListener(this.D0, new Handler(Looper.getMainLooper()));
        }
        addOnLayoutChangeListener(this.E0);
        t43 t43Var = this.f;
        if (t43Var != null) {
            t43Var.c();
        }
        co4.h();
        getViewPort();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        DisplayManager displayManager;
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.E0);
        t43 t43Var = this.f;
        if (t43Var != null) {
            t43Var.d();
        }
        if (isInEditMode() || (displayManager = getDisplayManager()) == null) {
            return;
        }
        displayManager.unregisterDisplayListener(this.D0);
    }

    public void setController(yy yyVar) {
        co4.h();
        co4.h();
        getViewPort();
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public void setImplementationMode(q43 q43Var) {
        co4.h();
        this.b = q43Var;
    }

    public void setScaleType(r43 r43Var) {
        co4.h();
        this.A.h = r43Var;
        a();
        co4.h();
        getViewPort();
    }

    public void setScreenFlashOverlayColor(int i) {
        this.z.setBackgroundColor(i);
    }

    public void setScreenFlashWindow(Window window) {
        co4.h();
        this.z.setScreenFlashWindow(window);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public PreviewView(Context context) {
        this(context, null);
    }
}
