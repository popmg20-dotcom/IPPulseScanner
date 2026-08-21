package defpackage;

import android.view.View;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u02 extends k70 {
    public final View X;
    public int Y;
    public int Z;
    public final int[] y0;

    public u02(View view) {
        super((byte) 0, 8);
        this.y0 = new int[2];
        this.X = view;
    }

    @Override // defpackage.k70
    public final void P0(fu4 fu4Var) {
        this.X.setTranslationY(0.0f);
    }

    @Override // defpackage.k70
    public final void Q0(fu4 fu4Var) {
        View view = this.X;
        int[] iArr = this.y0;
        view.getLocationOnScreen(iArr);
        this.Y = iArr[1];
    }

    @Override // defpackage.k70
    public final bv4 R0(bv4 bv4Var, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((fu4) it.next()).a.d() & 8) != 0) {
                this.X.setTranslationY(t8.c(this.Z, r0.a.c(), 0));
                break;
            }
        }
        return bv4Var;
    }

    @Override // defpackage.k70
    public final e24 S0(fu4 fu4Var, e24 e24Var) {
        View view = this.X;
        int[] iArr = this.y0;
        view.getLocationOnScreen(iArr);
        int i = this.Y - iArr[1];
        this.Z = i;
        view.setTranslationY(i);
        return e24Var;
    }
}
