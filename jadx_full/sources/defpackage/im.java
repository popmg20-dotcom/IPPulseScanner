package defpackage;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class im extends hk {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ im(bc0 bc0Var, int i) {
        super(bc0Var);
        this.b = i;
    }

    @Override // defpackage.nb0
    public final boolean c(gx4 gx4Var) {
        int i = this.b;
        gx4Var.getClass();
        switch (i) {
            case 0:
                return gx4Var.j.c;
            case 1:
                return gx4Var.j.e;
            case 2:
                return gx4Var.j.a == pr2.f;
            case 3:
                pr2 pr2Var = gx4Var.j.a;
                if (pr2Var != pr2.z) {
                    return Build.VERSION.SDK_INT >= 30 && pr2Var == pr2.Y;
                }
                return true;
            default:
                return gx4Var.j.f;
        }
    }

    @Override // defpackage.hk
    public final int d() {
        switch (this.b) {
            case 0:
                return 6;
            case 1:
                return 5;
            case 2:
                return 7;
            case 3:
                return 7;
            default:
                return 9;
        }
    }

    @Override // defpackage.hk
    public final boolean e(Object obj) {
        boolean zBooleanValue;
        switch (this.b) {
            case 0:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 1:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 2:
                lr2 lr2Var = (lr2) obj;
                lr2Var.getClass();
                return lr2Var.e || !lr2Var.a || (Build.VERSION.SDK_INT >= 26 && !lr2Var.b);
            case 3:
                lr2 lr2Var2 = (lr2) obj;
                lr2Var2.getClass();
                return !lr2Var2.a || lr2Var2.c || lr2Var2.e;
            default:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
        }
        return !zBooleanValue;
    }
}
