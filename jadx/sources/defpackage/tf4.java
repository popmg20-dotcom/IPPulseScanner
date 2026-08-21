package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.getsurfboard.R;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import io.sentry.android.core.a1;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tf4 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static tf4 B0;
    public static tf4 C0;
    public final sf4 A;
    public boolean A0;
    public final sf4 X;
    public int Y;
    public int Z;
    public final View b;
    public final CharSequence f;
    public uf4 y0;
    public final int z;
    public boolean z0;

    /* JADX WARN: Type inference failed for: r0v0, types: [sf4] */
    /* JADX WARN: Type inference failed for: r0v1, types: [sf4] */
    public tf4(View view, CharSequence charSequence) {
        final int i = 0;
        this.A = new Runnable(this) { // from class: sf4
            public final /* synthetic */ tf4 f;

            {
                this.f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i2 = i;
                tf4 tf4Var = this.f;
                switch (i2) {
                    case 0:
                        tf4Var.c(false);
                        break;
                    default:
                        tf4Var.a();
                        break;
                }
            }
        };
        final int i2 = 1;
        this.X = new Runnable(this) { // from class: sf4
            public final /* synthetic */ tf4 f;

            {
                this.f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i22 = i2;
                tf4 tf4Var = this.f;
                switch (i22) {
                    case 0:
                        tf4Var.c(false);
                        break;
                    default:
                        tf4Var.a();
                        break;
                }
            }
        };
        this.b = view;
        this.f = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = xp4.a;
        this.z = Build.VERSION.SDK_INT >= 28 ? u9.r(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.A0 = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(tf4 tf4Var) {
        tf4 tf4Var2 = B0;
        if (tf4Var2 != null) {
            tf4Var2.b.removeCallbacks(tf4Var2.A);
        }
        B0 = tf4Var;
        if (tf4Var != null) {
            tf4Var.b.postDelayed(tf4Var.A, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        tf4 tf4Var = C0;
        View view = this.b;
        if (tf4Var == this) {
            C0 = null;
            uf4 uf4Var = this.y0;
            if (uf4Var != null) {
                View view2 = (View) uf4Var.a;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) uf4Var.b).getSystemService("window")).removeView(view2);
                }
                this.y0 = null;
                this.A0 = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                a1.d("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (B0 == this) {
            b(null);
        }
        view.removeCallbacks(this.X);
    }

    public final void c(boolean z) {
        int height;
        int i;
        int i2;
        boolean z2;
        int i3;
        int i4;
        long longPressTimeout;
        long j;
        long j2;
        View view = this.b;
        if (view.isAttachedToWindow()) {
            b(null);
            tf4 tf4Var = C0;
            if (tf4Var != null) {
                tf4Var.a();
            }
            C0 = this;
            this.z0 = z;
            uf4 uf4Var = new uf4(view.getContext());
            View view2 = (View) uf4Var.a;
            Context context = (Context) uf4Var.b;
            this.y0 = uf4Var;
            int width = this.Y;
            int i5 = this.Z;
            boolean z3 = this.z0;
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) uf4Var.d;
            if (view2.getParent() != null && view2.getParent() != null) {
                ((WindowManager) context.getSystemService("window")).removeView(view2);
            }
            ((TextView) uf4Var.c).setText(this.f);
            int[] iArr = (int[]) uf4Var.g;
            int[] iArr2 = (int[]) uf4Var.f;
            Rect rect = (Rect) uf4Var.e;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i5 + dimensionPixelOffset2;
                i = i5 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(z3 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            int i6 = width;
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context2 = view.getContext();
                while (true) {
                    if (!(context2 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    }
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            if (rootView == null) {
                a1.d("TooltipPopup", "Cannot find app view");
                i4 = 1;
            } else {
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i2 = i;
                    z2 = z3;
                    i3 = 0;
                    i4 = 1;
                } else {
                    Resources resources = context.getResources();
                    i4 = 1;
                    i2 = i;
                    z2 = z3;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i3 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(iArr);
                view.getLocationOnScreen(iArr2);
                int i7 = iArr2[i3] - iArr[i3];
                iArr2[i3] = i7;
                iArr2[i4] = iArr2[i4] - iArr[i4];
                layoutParams.x = (i7 + i6) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, i3);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i8 = iArr2[i4];
                int i9 = ((i8 + i2) - dimensionPixelOffset3) - measuredHeight;
                int i10 = i8 + height + dimensionPixelOffset3;
                if (z2) {
                    if (i9 >= 0) {
                        layoutParams.y = i9;
                    } else {
                        layoutParams.y = i10;
                    }
                } else if (measuredHeight + i10 <= rect.height()) {
                    layoutParams.y = i10;
                } else {
                    layoutParams.y = i9;
                }
            }
            ((WindowManager) context.getSystemService("window")).addView(view2, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.z0) {
                j2 = 2500;
            } else {
                WeakHashMap weakHashMap = wp4.a;
                if ((view.getWindowSystemUiVisibility() & 1) == i4) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = AbstractTrafficShapingHandler.DEFAULT_MAX_TIME;
                }
                j2 = j - longPressTimeout;
            }
            sf4 sf4Var = this.X;
            view.removeCallbacks(sf4Var);
            view.postDelayed(sf4Var, j2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            uf4 r4 = r3.y0
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.z0
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.b
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.A0 = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            uf4 r4 = r3.y0
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.A0
            if (r1 != 0) goto L66
            int r1 = r3.Y
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.z
            if (r1 > r2) goto L66
            int r1 = r3.Z
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.Y = r4
            r3.Z = r5
            r3.A0 = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tf4.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.Y = view.getWidth() / 2;
        this.Z = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
