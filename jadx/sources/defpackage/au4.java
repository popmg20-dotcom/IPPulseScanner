package defpackage;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.getsurfboard.R;
import j$.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class au4 implements View.OnApplyWindowInsetsListener {
    public final k70 a;
    public bv4 b;

    public au4(View view, k70 k70Var) {
        bv4 bv4VarB;
        this.a = k70Var;
        WeakHashMap weakHashMap = wp4.a;
        bv4 bv4VarA = np4.a(view);
        if (bv4VarA != null) {
            int i = Build.VERSION.SDK_INT;
            bv4VarB = (i >= 36 ? new ou4(bv4VarA) : i >= 35 ? new nu4(bv4VarA) : i >= 34 ? new mu4(bv4VarA) : i >= 31 ? new lu4(bv4VarA) : i >= 30 ? new ku4(bv4VarA) : i >= 29 ? new ju4(bv4VarA) : new iu4(bv4VarA)).b();
        } else {
            bv4VarB = null;
        }
        this.b = bv4VarB;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int[] iArr;
        boolean z;
        if (!view.isLaidOut()) {
            this.b = bv4.g(windowInsets, view);
            return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }
        bv4 bv4VarG = bv4.g(windowInsets, view);
        yu4 yu4Var = bv4VarG.a;
        bv4 bv4VarA = this.b;
        if (bv4VarA == null) {
            WeakHashMap weakHashMap = wp4.a;
            bv4VarA = np4.a(view);
            this.b = bv4VarA;
        }
        if (bv4VarA == null) {
            this.b = bv4VarG;
            if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                return view.onApplyWindowInsets(windowInsets);
            }
        } else {
            k70 k70VarJ = bu4.j(view);
            if (k70VarJ == null || !Objects.equals((bv4) k70VarJ.f, bv4VarG)) {
                int[] iArr2 = new int[1];
                int[] iArr3 = new int[1];
                bv4 bv4Var = this.b;
                int i = 1;
                while (i <= 512) {
                    t02 t02VarH = yu4Var.h(i);
                    t02 t02VarH2 = bv4Var.a.h(i);
                    int i2 = t02VarH.a;
                    int i3 = t02VarH.d;
                    int i4 = t02VarH.c;
                    int i5 = t02VarH.b;
                    int i6 = t02VarH2.a;
                    int i7 = t02VarH2.d;
                    int[] iArr4 = iArr2;
                    int i8 = t02VarH2.c;
                    int i9 = t02VarH2.b;
                    if (i2 > i6 || i5 > i9 || i4 > i8 || i3 > i7) {
                        iArr = iArr3;
                        z = true;
                    } else {
                        iArr = iArr3;
                        z = false;
                    }
                    if (z != (i2 < i6 || i5 < i9 || i4 < i8 || i3 < i7)) {
                        if (z) {
                            iArr4[0] = iArr4[0] | i;
                        } else {
                            iArr[0] = iArr[0] | i;
                        }
                    }
                    i <<= 1;
                    iArr2 = iArr4;
                    iArr3 = iArr;
                }
                boolean z2 = false;
                int i10 = iArr2[0];
                int i11 = iArr3[0];
                int i12 = i10 | i11;
                if (i12 == 0) {
                    this.b = bv4VarG;
                    if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                        return view.onApplyWindowInsets(windowInsets);
                    }
                } else {
                    bv4 bv4Var2 = this.b;
                    fu4 fu4Var = new fu4(i12, (i10 & 8) != 0 ? bu4.e : (i11 & 8) != 0 ? bu4.f : (i10 & 519) != 0 ? bu4.g : (i11 & 519) != 0 ? bu4.h : null, (i12 & 8) != 0 ? 160L : 250L);
                    fu4Var.a.e(0.0f);
                    ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(fu4Var.a.b());
                    t02 t02VarH3 = yu4Var.h(i12);
                    t02 t02VarH4 = bv4Var2.a.h(i12);
                    int iMin = Math.min(t02VarH3.a, t02VarH4.a);
                    int i13 = t02VarH3.b;
                    int i14 = t02VarH4.b;
                    int iMin2 = Math.min(i13, i14);
                    int i15 = t02VarH3.c;
                    int i16 = t02VarH4.c;
                    int iMin3 = Math.min(i15, i16);
                    int i17 = t02VarH3.d;
                    int i18 = t02VarH4.d;
                    e24 e24Var = new e24(20, t02.c(iMin, iMin2, iMin3, Math.min(i17, i18)), t02.c(Math.max(t02VarH3.a, t02VarH4.a), Math.max(i13, i14), Math.max(i15, i16), Math.max(i17, i18)), z2);
                    bu4.g(view, fu4Var, bv4VarG, false);
                    duration.addUpdateListener(new zt4(fu4Var, bv4VarG, bv4Var2, i12, view));
                    duration.addListener(new og4(fu4Var, view));
                    pv2.a(view, new d20(view, fu4Var, e24Var, duration, 1, false));
                    this.b = bv4VarG;
                    if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                        return view.onApplyWindowInsets(windowInsets);
                    }
                }
            } else if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                return view.onApplyWindowInsets(windowInsets);
            }
        }
        return windowInsets;
    }
}
