package defpackage;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowInsets;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class qu4 extends yu4 {
    public static boolean m = false;
    public static Method n;
    public static Class o;
    public static Field p;
    public static Field q;
    public final WindowInsets c;
    public t02[] d;
    public t02 e;
    public bv4 f;
    public t02 g;
    public int h;
    public int i;
    public int j;
    public Rect[][] k;
    public Rect[][] l;

    public qu4(bv4 bv4Var, WindowInsets windowInsets) {
        super(bv4Var);
        this.e = null;
        this.k = new Rect[10][];
        this.l = new Rect[10][];
        this.c = windowInsets;
    }

    private vv0 B(View view) {
        Display display;
        if (view == null || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        if (this.a.a.s()) {
            return vv0.a(point.x, point.y, true, 0, 0, 0, 0);
        }
        bm3 bm3VarB = ut0.b(display, 0);
        bm3 bm3VarB2 = ut0.b(display, 1);
        bm3 bm3VarB3 = ut0.b(display, 2);
        bm3 bm3VarB4 = ut0.b(display, 3);
        return vv0.a(point.x, point.y, false, bm3VarB != null ? bm3VarB.b : 0, bm3VarB2 != null ? bm3VarB2.b : 0, bm3VarB3 != null ? bm3VarB3.b : 0, bm3VarB4 != null ? bm3VarB4.b : 0);
    }

    private static List<Rect> C(Rect[][] rectArr, int i) {
        Rect[] rectArr2;
        Rect[] rectArr3 = null;
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0 && (rectArr2 = rectArr[ye.C(i2)]) != null) {
                if (rectArr3 == null) {
                    rectArr3 = rectArr2;
                } else {
                    Rect[] rectArr4 = new Rect[rectArr3.length + rectArr2.length];
                    System.arraycopy(rectArr3, 0, rectArr4, 0, rectArr3.length);
                    System.arraycopy(rectArr2, 0, rectArr4, rectArr3.length, rectArr2.length);
                    rectArr3 = rectArr4;
                }
            }
        }
        return rectArr3 == null ? Collections.EMPTY_LIST : Arrays.asList(rectArr3);
    }

    private Rect[] D(t02 t02Var) {
        ArrayList arrayList = new ArrayList();
        int i = t02Var.a;
        int i2 = t02Var.d;
        int i3 = t02Var.c;
        int i4 = t02Var.b;
        if (i != 0) {
            arrayList.add(new Rect(0, 0, t02Var.a, this.i));
        }
        if (i4 != 0) {
            arrayList.add(new Rect(0, 0, this.j, i4));
        }
        if (i3 != 0) {
            int i5 = this.j;
            arrayList.add(new Rect(i5 - i3, 0, i5, this.i));
        }
        if (i2 != 0) {
            int i6 = this.i;
            arrayList.add(new Rect(0, i6 - i2, this.j, i6));
        }
        return (Rect[]) arrayList.toArray(new Rect[arrayList.size()]);
    }

    private t02 E(int i, boolean z) {
        t02 t02VarA = t02.e;
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0) {
                t02VarA = t02.a(t02VarA, F(i2, z));
            }
        }
        return t02VarA;
    }

    private t02 G() {
        bv4 bv4Var = this.f;
        return bv4Var != null ? bv4Var.a.k() : t02.e;
    }

    private t02 H(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            vp1.n("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            return null;
        }
        if (!m) {
            J();
        }
        Method method = n;
        if (method != null && o != null && p != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    a1.o("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) p.get(q.get(objInvoke));
                if (rect != null) {
                    return t02.c(rect.left, rect.top, rect.right, rect.bottom);
                }
            } catch (ReflectiveOperationException e) {
                a1.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
        }
        return null;
    }

    private static void J() {
        try {
            n = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            o = cls;
            p = cls.getDeclaredField("mVisibleInsets");
            q = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            p.setAccessible(true);
            q.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            a1.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
        }
        m = true;
    }

    public static boolean L(int i, int i2) {
        return (i & 6) == (i2 & 6);
    }

    @Override // defpackage.yu4
    public void A(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.l = (Rect[][]) rectArr.clone();
    }

    public t02 F(int i, boolean z) {
        t02 t02VarK;
        int i2;
        t02 t02Var = t02.e;
        if (i != 1) {
            if (i != 2) {
                if (i == 8) {
                    t02[] t02VarArr = this.d;
                    t02VarK = t02VarArr != null ? t02VarArr[ye.C(8)] : null;
                    if (t02VarK != null) {
                        return t02VarK;
                    }
                    t02 t02VarM = m();
                    t02 t02VarG = G();
                    int i3 = t02VarM.d;
                    if (i3 > t02VarG.d) {
                        return t02.c(0, 0, 0, i3);
                    }
                    t02 t02Var2 = this.g;
                    if (t02Var2 != null && !t02Var2.equals(t02Var) && (i2 = this.g.d) > t02VarG.d) {
                        return t02.c(0, 0, 0, i2);
                    }
                } else {
                    if (i == 16) {
                        return l();
                    }
                    if (i == 32) {
                        return j();
                    }
                    if (i == 64) {
                        return n();
                    }
                    if (i == 128) {
                        bv4 bv4Var = this.f;
                        rv0 rv0VarG = bv4Var != null ? bv4Var.a.g() : g();
                        if (rv0VarG != null) {
                            int i4 = Build.VERSION.SDK_INT;
                            return t02.c(i4 >= 28 ? u9.o(rv0VarG.a) : 0, i4 >= 28 ? u9.q(rv0VarG.a) : 0, i4 >= 28 ? u9.p(rv0VarG.a) : 0, i4 >= 28 ? u9.n(rv0VarG.a) : 0);
                        }
                    }
                }
            } else {
                if (z) {
                    t02 t02VarG2 = G();
                    t02 t02VarK2 = k();
                    return t02.c(Math.max(t02VarG2.a, t02VarK2.a), 0, Math.max(t02VarG2.c, t02VarK2.c), Math.max(t02VarG2.d, t02VarK2.d));
                }
                if ((this.h & 2) == 0) {
                    t02 t02VarM2 = m();
                    bv4 bv4Var2 = this.f;
                    t02VarK = bv4Var2 != null ? bv4Var2.a.k() : null;
                    int iMin = t02VarM2.d;
                    if (t02VarK != null) {
                        iMin = Math.min(iMin, t02VarK.d);
                    }
                    return t02.c(t02VarM2.a, 0, t02VarM2.c, iMin);
                }
            }
        } else {
            if (z) {
                return t02.c(0, Math.max(G().b, m().b), 0, 0);
            }
            if ((this.h & 4) == 0) {
                return t02.c(0, m().b, 0, 0);
            }
        }
        return t02Var;
    }

    public boolean I(int i) {
        if (i != 1 && i != 2) {
            if (i == 4) {
                return false;
            }
            if (i != 8 && i != 128) {
                return true;
            }
        }
        return !F(i, false).equals(t02.e);
    }

    public void K(t02 t02Var) {
        this.g = t02Var;
    }

    @Override // defpackage.yu4
    public void d(View view) {
        this.j = view.getWidth();
        this.i = view.getHeight();
        t02 t02VarH = H(view);
        if (t02VarH == null) {
            t02VarH = t02.e;
        }
        K(t02VarH);
    }

    @Override // defpackage.yu4
    public List<Rect> e(int i) {
        return C(this.k, i);
    }

    @Override // defpackage.yu4
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        qu4 qu4Var = (qu4) obj;
        return Objects.equals(this.g, qu4Var.g) && L(this.h, qu4Var.h);
    }

    @Override // defpackage.yu4
    public List<Rect> f(int i) {
        return C(this.l, i);
    }

    @Override // defpackage.yu4
    public t02 h(int i) {
        return E(i, false);
    }

    @Override // defpackage.yu4
    public t02 i(int i) {
        return E(i, true);
    }

    @Override // defpackage.yu4
    public final t02 m() {
        t02 t02Var = this.e;
        if (t02Var != null) {
            return t02Var;
        }
        WindowInsets windowInsets = this.c;
        t02 t02VarC = t02.c(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        this.e = t02VarC;
        return t02VarC;
    }

    @Override // defpackage.yu4
    public void o(View view) {
        B(view);
    }

    @Override // defpackage.yu4
    public void p() {
        for (int i = 1; i <= 512; i <<= 1) {
            int iC = ye.C(i);
            this.k[iC] = D(h(i));
            if (i != 8) {
                this.l[iC] = D(i(i));
            }
        }
    }

    @Override // defpackage.yu4
    public bv4 q(int i, int i2, int i3, int i4) {
        bv4 bv4VarG = bv4.g(this.c, null);
        int i5 = Build.VERSION.SDK_INT;
        pu4 ou4Var = i5 >= 36 ? new ou4(bv4VarG) : i5 >= 35 ? new nu4(bv4VarG) : i5 >= 34 ? new mu4(bv4VarG) : i5 >= 31 ? new lu4(bv4VarG) : i5 >= 30 ? new ku4(bv4VarG) : i5 >= 29 ? new ju4(bv4VarG) : new iu4(bv4VarG);
        ou4Var.h(bv4.e(m(), i, i2, i3, i4));
        ou4Var.f(bv4.e(k(), i, i2, i3, i4));
        return ou4Var.b();
    }

    @Override // defpackage.yu4
    public boolean s() {
        return this.c.isRound();
    }

    @Override // defpackage.yu4
    public boolean t(int i) {
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0 && !I(i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.yu4
    public void v(t02[] t02VarArr) {
        this.d = t02VarArr;
    }

    @Override // defpackage.yu4
    public void w(bv4 bv4Var) {
        this.f = bv4Var;
    }

    @Override // defpackage.yu4
    public void y(int i) {
        this.h = i;
    }

    @Override // defpackage.yu4
    public void z(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.k = (Rect[][]) rectArr.clone();
    }

    @Override // defpackage.yu4
    public void u(vv0 vv0Var) {
    }
}
