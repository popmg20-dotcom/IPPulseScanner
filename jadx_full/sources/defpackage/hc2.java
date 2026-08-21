package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import io.netty.channel.internal.ChannelUtils;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.sentry.android.core.a1;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class hc2 implements wv3 {
    public static final Method R0;
    public static final Method S0;
    public static final Method T0;
    public boolean A0;
    public boolean B0;
    public ng0 E0;
    public View F0;
    public AdapterView.OnItemClickListener G0;
    public AdapterView.OnItemSelectedListener H0;
    public final Handler M0;
    public Rect O0;
    public boolean P0;
    public final kb Q0;
    public int Y;
    public int Z;
    public final Context b;
    public ListAdapter f;
    public jy0 z;
    public boolean z0;
    public final int A = -2;
    public int X = -2;
    public final int y0 = 1002;
    public int C0 = 0;
    public final int D0 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
    public final ec2 I0 = new ec2(this, 1);
    public final gc2 J0 = new gc2(this);
    public final fc2 K0 = new fc2(this);
    public final ec2 L0 = new ec2(this, 0);
    public final Rect N0 = new Rect();

    static {
        int i = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        if (i <= 28) {
            try {
                R0 = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", cls);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                T0 = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                S0 = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, cls);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public hc2(Context context, AttributeSet attributeSet, int i, int i2) {
        int resourceId;
        this.b = context;
        this.M0 = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cd3.o, i, 0);
        this.Y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.Z = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.z0 = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        kb kbVar = new kb(context, attributeSet, i, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, cd3.s, i, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            kbVar.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        kbVar.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : vo.r(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.Q0 = kbVar;
        kbVar.setInputMethodMode(1);
    }

    public jy0 a(Context context, boolean z) {
        return new jy0(context, z);
    }

    @Override // defpackage.wv3
    public final boolean b() {
        return this.Q0.isShowing();
    }

    public final int c() {
        return this.Y;
    }

    @Override // defpackage.wv3
    public final void dismiss() {
        kb kbVar = this.Q0;
        kbVar.dismiss();
        kbVar.setContentView(null);
        this.z = null;
        this.M0.removeCallbacks(this.I0);
    }

    public final void e(int i) {
        this.Y = i;
    }

    @Override // defpackage.wv3
    public final void g() {
        int i;
        int iA;
        int paddingBottom;
        jy0 jy0Var;
        jy0 jy0Var2 = this.z;
        Context context = this.b;
        kb kbVar = this.Q0;
        int i2 = 1;
        if (jy0Var2 == null) {
            jy0 jy0VarA = a(context, !this.P0);
            this.z = jy0VarA;
            jy0VarA.setAdapter(this.f);
            this.z.setOnItemClickListener(this.G0);
            this.z.setFocusable(true);
            this.z.setFocusableInTouchMode(true);
            this.z.setOnItemSelectedListener(new ky0(i2, this));
            this.z.setOnScrollListener(this.K0);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.H0;
            if (onItemSelectedListener != null) {
                this.z.setOnItemSelectedListener(onItemSelectedListener);
            }
            kbVar.setContentView(this.z);
        }
        Drawable background = kbVar.getBackground();
        Rect rect = this.N0;
        if (background != null) {
            background.getPadding(rect);
            int i3 = rect.top;
            i = rect.bottom + i3;
            if (!this.z0) {
                this.Z = -i3;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        boolean z = kbVar.getInputMethodMode() == 2;
        View view = this.F0;
        int i4 = this.Z;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = S0;
            if (method != null) {
                try {
                    iA = ((Integer) method.invoke(kbVar, view, Integer.valueOf(i4), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                    iA = kbVar.getMaxAvailableHeight(view, i4);
                }
            } else {
                iA = kbVar.getMaxAvailableHeight(view, i4);
            }
        } else {
            iA = cc2.a(kbVar, view, i4, z);
        }
        int i5 = this.A;
        if (i5 == -1) {
            paddingBottom = iA + i;
        } else {
            int i6 = this.X;
            int iA2 = this.z.a(i6 != -2 ? i6 != -1 ? View.MeasureSpec.makeMeasureSpec(i6, Pow2.MAX_POW2) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Pow2.MAX_POW2) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.z.getPaddingBottom() + this.z.getPaddingTop() + i : 0);
        }
        boolean z2 = kbVar.getInputMethodMode() == 2;
        kbVar.setWindowLayoutType(this.y0);
        if (kbVar.isShowing()) {
            if (this.F0.isAttachedToWindow()) {
                int width = this.X;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.F0.getWidth();
                }
                if (i5 == -1) {
                    i5 = z2 ? paddingBottom : -1;
                    int i7 = this.X;
                    if (z2) {
                        kbVar.setWidth(i7 == -1 ? -1 : 0);
                        kbVar.setHeight(0);
                    } else {
                        kbVar.setWidth(i7 == -1 ? -1 : 0);
                        kbVar.setHeight(-1);
                    }
                } else if (i5 == -2) {
                    i5 = paddingBottom;
                }
                kbVar.setOutsideTouchable(true);
                int i8 = width;
                kbVar.update(this.F0, this.Y, this.Z, i8 < 0 ? -1 : i8, i5 < 0 ? -1 : i5);
                return;
            }
            return;
        }
        int width2 = this.X;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.F0.getWidth();
        }
        if (i5 == -1) {
            i5 = -1;
        } else if (i5 == -2) {
            i5 = paddingBottom;
        }
        kbVar.setWidth(width2);
        kbVar.setHeight(i5);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = R0;
            if (method2 != null) {
                try {
                    method2.invoke(kbVar, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            dc2.b(kbVar, true);
        }
        kbVar.setOutsideTouchable(true);
        kbVar.setTouchInterceptor(this.J0);
        if (this.B0) {
            kbVar.setOverlapAnchor(this.A0);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = T0;
            if (method3 != null) {
                try {
                    method3.invoke(kbVar, this.O0);
                } catch (Exception e) {
                    a1.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            dc2.a(kbVar, this.O0);
        }
        kbVar.showAsDropDown(this.F0, this.Y, this.Z, this.C0);
        this.z.setSelection(-1);
        if ((!this.P0 || this.z.isInTouchMode()) && (jy0Var = this.z) != null) {
            jy0Var.setListSelectionHidden(true);
            jy0Var.requestLayout();
        }
        if (this.P0) {
            return;
        }
        this.M0.post(this.L0);
    }

    public final Drawable h() {
        return this.Q0.getBackground();
    }

    public final void j(Drawable drawable) {
        this.Q0.setBackgroundDrawable(drawable);
    }

    @Override // defpackage.wv3
    public final jy0 k() {
        return this.z;
    }

    public final void l(int i) {
        this.Z = i;
        this.z0 = true;
    }

    public final int o() {
        if (this.z0) {
            return this.Z;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        ng0 ng0Var = this.E0;
        if (ng0Var == null) {
            this.E0 = new ng0(1, this);
        } else {
            ListAdapter listAdapter2 = this.f;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(ng0Var);
            }
        }
        this.f = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.E0);
        }
        jy0 jy0Var = this.z;
        if (jy0Var != null) {
            jy0Var.setAdapter(this.f);
        }
    }

    public final void q(int i) {
        Drawable background = this.Q0.getBackground();
        if (background == null) {
            this.X = i;
            return;
        }
        Rect rect = this.N0;
        background.getPadding(rect);
        this.X = rect.left + rect.right + i;
    }
}
