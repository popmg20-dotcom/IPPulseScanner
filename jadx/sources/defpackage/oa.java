package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import com.getsurfboard.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oa implements mu2, fl2 {
    public final /* synthetic */ za b;

    public /* synthetic */ oa(za zaVar) {
        this.b = zaVar;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        int i;
        int i2;
        boolean z;
        bv4 bv4VarB;
        boolean z2;
        int iD = bv4Var.d();
        za zaVar = this.b;
        Context context = zaVar.B0;
        int iD2 = bv4Var.d();
        ActionBarContextView actionBarContextView = zaVar.L0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            i = 0;
            i2 = 8;
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) zaVar.L0.getLayoutParams();
            if (zaVar.L0.isShown()) {
                if (zaVar.s1 == null) {
                    zaVar.s1 = new Rect();
                    zaVar.t1 = new Rect();
                }
                Rect rect = zaVar.s1;
                Rect rect2 = zaVar.t1;
                rect.set(bv4Var.b(), bv4Var.d(), bv4Var.c(), bv4Var.a());
                ViewGroup viewGroup = zaVar.Q0;
                if (Build.VERSION.SDK_INT >= 29) {
                    boolean z3 = pr4.a;
                    lr4.a(viewGroup, rect, rect2);
                } else {
                    if (!pr4.a) {
                        pr4.a = true;
                        try {
                            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                            pr4.b = declaredMethod;
                            if (!declaredMethod.isAccessible()) {
                                pr4.b.setAccessible(true);
                            }
                        } catch (NoSuchMethodException unused) {
                            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                        }
                    }
                    Method method = pr4.b;
                    if (method != null) {
                        try {
                            method.invoke(viewGroup, rect, rect2);
                        } catch (Exception e) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                        }
                    }
                }
                int i3 = rect.top;
                int i4 = rect.left;
                int i5 = rect.right;
                ViewGroup viewGroup2 = zaVar.Q0;
                WeakHashMap weakHashMap = wp4.a;
                bv4 bv4VarA = np4.a(viewGroup2);
                int iB = bv4VarA == null ? 0 : bv4VarA.b();
                int iC = bv4VarA == null ? 0 : bv4VarA.c();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z2 = true;
                }
                if (i3 <= 0 || zaVar.S0 != null) {
                    i2 = 8;
                    View view2 = zaVar.S0;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i6 = marginLayoutParams2.height;
                        int i7 = marginLayoutParams.topMargin;
                        if (i6 != i7 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                            marginLayoutParams2.height = i7;
                            marginLayoutParams2.leftMargin = iB;
                            marginLayoutParams2.rightMargin = iC;
                            zaVar.S0.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    zaVar.S0 = view3;
                    i2 = 8;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iB;
                    layoutParams.rightMargin = iC;
                    zaVar.Q0.addView(zaVar.S0, -1, layoutParams);
                }
                View view4 = zaVar.S0;
                z = view4 != null;
                if (z && view4.getVisibility() != 0) {
                    View view5 = zaVar.S0;
                    view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? context.getColor(R.color.abc_decor_view_status_guard_light) : context.getColor(R.color.abc_decor_view_status_guard));
                }
                if (!zaVar.X0 && z) {
                    iD2 = 0;
                }
                i = 0;
                z = z;
                z = z2;
            } else {
                i2 = 8;
                i = 0;
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z = false;
                } else {
                    z = false;
                    z = false;
                }
            }
            if (z) {
                zaVar.L0.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = zaVar.S0;
        if (view6 != null) {
            if (z) {
                i2 = i;
            }
            view6.setVisibility(i2);
        }
        if (iD != iD2) {
            int iB2 = bv4Var.b();
            int iC2 = bv4Var.c();
            int iA = bv4Var.a();
            int i8 = Build.VERSION.SDK_INT;
            pu4 ou4Var = i8 >= 36 ? new ou4(bv4Var) : i8 >= 35 ? new nu4(bv4Var) : i8 >= 34 ? new mu4(bv4Var) : i8 >= 31 ? new lu4(bv4Var) : i8 >= 30 ? new ku4(bv4Var) : i8 >= 29 ? new ju4(bv4Var) : new iu4(bv4Var);
            ou4Var.h(t02.c(iB2, iD2, iC2, iA));
            bv4VarB = ou4Var.b();
        } else {
            bv4VarB = bv4Var;
        }
        WeakHashMap weakHashMap2 = wp4.a;
        WindowInsets windowInsetsF = bv4VarB.f();
        if (windowInsetsF == null) {
            return bv4VarB;
        }
        WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsF);
        return !windowInsetsOnApplyWindowInsets.equals(windowInsetsF) ? bv4.g(windowInsetsOnApplyWindowInsets, view) : bv4VarB;
    }

    @Override // defpackage.fl2
    public void a(nk2 nk2Var, boolean z) {
        ya yaVar;
        nk2 nk2VarM = nk2Var.m();
        int i = 0;
        boolean z2 = nk2VarM != nk2Var;
        if (z2) {
            nk2Var = nk2VarM;
        }
        za zaVar = this.b;
        ya[] yaVarArr = zaVar.b1;
        int length = yaVarArr != null ? yaVarArr.length : 0;
        while (true) {
            if (i < length) {
                yaVar = yaVarArr[i];
                if (yaVar != null && yaVar.h == nk2Var) {
                    break;
                } else {
                    i++;
                }
            } else {
                yaVar = null;
                break;
            }
        }
        if (yaVar != null) {
            if (!z2) {
                zaVar.v(yaVar, z);
            } else {
                zaVar.t(yaVar.a, yaVar, nk2VarM);
                zaVar.v(yaVar, true);
            }
        }
    }

    @Override // defpackage.fl2
    public boolean i0(nk2 nk2Var) {
        Window.Callback callback;
        if (nk2Var != nk2Var.m()) {
            return true;
        }
        za zaVar = this.b;
        if (!zaVar.V0 || (callback = zaVar.C0.getCallback()) == null || zaVar.g1) {
            return true;
        }
        callback.onMenuOpened(108, nk2Var);
        return true;
    }
}
