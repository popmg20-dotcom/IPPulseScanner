package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tw2 extends h31 {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ tw2(ag3 ag3Var, int i) {
        super(ag3Var);
        this.d = i;
    }

    @Override // defpackage.h31
    public final int d(View view) {
        int iD;
        int i;
        int i2 = this.d;
        Object obj = this.b;
        switch (i2) {
            case 0:
                bg3 bg3Var = (bg3) view.getLayoutParams();
                ((ag3) obj).getClass();
                iD = ag3.D(view);
                i = ((ViewGroup.MarginLayoutParams) bg3Var).rightMargin;
                break;
            default:
                bg3 bg3Var2 = (bg3) view.getLayoutParams();
                ((ag3) obj).getClass();
                iD = ag3.y(view);
                i = ((ViewGroup.MarginLayoutParams) bg3Var2).bottomMargin;
                break;
        }
        return iD + i;
    }

    @Override // defpackage.h31
    public final int e(View view) {
        int iC;
        int i;
        int i2 = this.d;
        Object obj = this.b;
        switch (i2) {
            case 0:
                bg3 bg3Var = (bg3) view.getLayoutParams();
                ((ag3) obj).getClass();
                iC = ag3.C(view) + ((ViewGroup.MarginLayoutParams) bg3Var).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) bg3Var).rightMargin;
                break;
            default:
                bg3 bg3Var2 = (bg3) view.getLayoutParams();
                ((ag3) obj).getClass();
                iC = ag3.B(view) + ((ViewGroup.MarginLayoutParams) bg3Var2).topMargin;
                i = ((ViewGroup.MarginLayoutParams) bg3Var2).bottomMargin;
                break;
        }
        return iC + i;
    }

    @Override // defpackage.h31
    public final int f(View view) {
        int iB;
        int i;
        int i2 = this.d;
        Object obj = this.b;
        switch (i2) {
            case 0:
                bg3 bg3Var = (bg3) view.getLayoutParams();
                ((ag3) obj).getClass();
                iB = ag3.B(view) + ((ViewGroup.MarginLayoutParams) bg3Var).topMargin;
                i = ((ViewGroup.MarginLayoutParams) bg3Var).bottomMargin;
                break;
            default:
                bg3 bg3Var2 = (bg3) view.getLayoutParams();
                ((ag3) obj).getClass();
                iB = ag3.C(view) + ((ViewGroup.MarginLayoutParams) bg3Var2).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) bg3Var2).rightMargin;
                break;
        }
        return iB + i;
    }

    @Override // defpackage.h31
    public final int g(View view) {
        int iA;
        int i;
        int i2 = this.d;
        Object obj = this.b;
        switch (i2) {
            case 0:
                bg3 bg3Var = (bg3) view.getLayoutParams();
                ((ag3) obj).getClass();
                iA = ag3.A(view);
                i = ((ViewGroup.MarginLayoutParams) bg3Var).leftMargin;
                break;
            default:
                bg3 bg3Var2 = (bg3) view.getLayoutParams();
                ((ag3) obj).getClass();
                iA = ag3.E(view);
                i = ((ViewGroup.MarginLayoutParams) bg3Var2).topMargin;
                break;
        }
        return iA - i;
    }

    @Override // defpackage.h31
    public final int h() {
        switch (this.d) {
            case 0:
                return ((ag3) this.b).n;
            default:
                return ((ag3) this.b).o;
        }
    }

    @Override // defpackage.h31
    public final int i() {
        int i;
        int I;
        int i2 = this.d;
        Object obj = this.b;
        switch (i2) {
            case 0:
                ag3 ag3Var = (ag3) obj;
                i = ag3Var.n;
                I = ag3Var.I();
                break;
            default:
                ag3 ag3Var2 = (ag3) obj;
                i = ag3Var2.o;
                I = ag3Var2.G();
                break;
        }
        return i - I;
    }

    @Override // defpackage.h31
    public final int j() {
        switch (this.d) {
            case 0:
                return ((ag3) this.b).I();
            default:
                return ((ag3) this.b).G();
        }
    }

    @Override // defpackage.h31
    public final int k() {
        switch (this.d) {
            case 0:
                return ((ag3) this.b).l;
            default:
                return ((ag3) this.b).m;
        }
    }

    @Override // defpackage.h31
    public final int l() {
        switch (this.d) {
            case 0:
                return ((ag3) this.b).m;
            default:
                return ((ag3) this.b).l;
        }
    }

    @Override // defpackage.h31
    public final int m() {
        switch (this.d) {
            case 0:
                return ((ag3) this.b).H();
            default:
                return ((ag3) this.b).J();
        }
    }

    @Override // defpackage.h31
    public final int n() {
        int iH;
        int I;
        int i = this.d;
        Object obj = this.b;
        switch (i) {
            case 0:
                ag3 ag3Var = (ag3) obj;
                iH = ag3Var.n - ag3Var.H();
                I = ag3Var.I();
                break;
            default:
                ag3 ag3Var2 = (ag3) obj;
                iH = ag3Var2.o - ag3Var2.J();
                I = ag3Var2.G();
                break;
        }
        return iH - I;
    }

    @Override // defpackage.h31
    public final int o(View view) {
        int i = this.d;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                Rect rect = (Rect) obj;
                ((ag3) obj2).N(view, rect);
                return rect.right;
            default:
                Rect rect2 = (Rect) obj;
                ((ag3) obj2).N(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // defpackage.h31
    public final int p(View view) {
        int i = this.d;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                Rect rect = (Rect) obj;
                ((ag3) obj2).N(view, rect);
                return rect.left;
            default:
                Rect rect2 = (Rect) obj;
                ((ag3) obj2).N(view, rect2);
                return rect2.top;
        }
    }

    @Override // defpackage.h31
    public final void q(int i) {
        switch (this.d) {
            case 0:
                ((ag3) this.b).S(i);
                break;
            default:
                ((ag3) this.b).T(i);
                break;
        }
    }
}
