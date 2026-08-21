package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m81 extends cp1 {
    public final /* synthetic */ n40 A;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m81(n40 n40Var) {
        super(2);
        this.A = n40Var;
    }

    @Override // defpackage.cp1
    public final p2 P(int i) {
        n40 n40Var = this.A;
        int i2 = i == 2 ? n40Var.k : n40Var.l;
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        return g(i2);
    }

    @Override // defpackage.cp1
    public final boolean a0(int i, int i2, Bundle bundle) {
        int i3;
        n40 n40Var = this.A;
        Chip chip = n40Var.i;
        if (i == -1) {
            return chip.performAccessibilityAction(i2, bundle);
        }
        if (i2 == 1) {
            return n40Var.p(i);
        }
        if (i2 == 2) {
            return n40Var.j(i);
        }
        boolean z = false;
        if (i2 == 64) {
            AccessibilityManager accessibilityManager = n40Var.h;
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i3 = n40Var.k) == i) {
                return false;
            }
            if (i3 != Integer.MIN_VALUE) {
                n40Var.k = Integer.MIN_VALUE;
                chip.invalidate();
                n40Var.q(i3, 65536);
            }
            n40Var.k = i;
            chip.invalidate();
            n40Var.q(i, 32768);
            return true;
        }
        if (i2 == 128) {
            if (n40Var.k != i) {
                return false;
            }
            n40Var.k = Integer.MIN_VALUE;
            chip.invalidate();
            n40Var.q(i, 65536);
            return true;
        }
        Chip chip2 = n40Var.n;
        if (i2 == 16) {
            if (i == 0) {
                return chip2.performClick();
            }
            if (i == 1) {
                chip2.playSoundEffect(0);
                View.OnClickListener onClickListener = chip2.B0;
                if (onClickListener != null) {
                    onClickListener.onClick(chip2);
                    z = true;
                }
                if (chip2.N0) {
                    chip2.M0.q(1, 1);
                }
            }
        }
        return z;
    }

    @Override // defpackage.cp1
    public final p2 g(int i) {
        return new p2(AccessibilityNodeInfo.obtain(this.A.n(i).a));
    }
}
