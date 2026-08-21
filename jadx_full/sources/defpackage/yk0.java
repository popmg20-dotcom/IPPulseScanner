package defpackage;

import android.widget.ListView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yk0 implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ int f;
    public final /* synthetic */ int z;

    public /* synthetic */ yk0(Object obj, int i, int i2, int i3) {
        this.b = i3;
        this.A = obj;
        this.f = i;
        this.z = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        boolean z = false;
        boolean z2 = true;
        int i2 = this.z;
        int i3 = this.f;
        Object obj = this.A;
        switch (i) {
            case 0:
                iv1 iv1Var = (iv1) obj;
                if (i3 == 0 && i2 == 0) {
                    ((ListView) iv1Var.f).setSelectionFromTop(0, 0);
                } else {
                    while (((ListView) iv1Var.f).getFirstVisiblePosition() + 1 > i3 && ((ListView) iv1Var.f).canScrollList(-1)) {
                        iv1Var.x(i2 / 2);
                    }
                    while (((ListView) iv1Var.f).getLastVisiblePosition() - 1 < i3 && ((ListView) iv1Var.f).canScrollList(1)) {
                        iv1Var.x((-i2) / 2);
                    }
                }
                break;
            default:
                c74 c74Var = (c74) obj;
                if (c74Var.i != i3) {
                    c74Var.i = i3;
                    z = true;
                }
                if (c74Var.h != i2) {
                    c74Var.h = i2;
                } else {
                    z2 = z;
                }
                if (z2) {
                    c74Var.e();
                }
                break;
        }
    }
}
