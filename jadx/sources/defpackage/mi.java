package defpackage;

import android.content.DialogInterface;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mi implements DialogInterface.OnShowListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ u6 c;

    public /* synthetic */ mi(m31 m31Var, u6 u6Var, Set set) {
        this.a = 2;
        this.c = u6Var;
        this.b = set;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        int i = this.a;
        Object obj = this.b;
        u6 u6Var = this.c;
        switch (i) {
            case 0:
                zf2.q0((r90) obj, u6Var);
                break;
            case 1:
                zf2.q0((r90) obj, u6Var);
                break;
            default:
                m31.c(u6Var, (Set) obj);
                break;
        }
    }

    public /* synthetic */ mi(zf2 zf2Var, r90 r90Var, u6 u6Var, int i) {
        this.a = i;
        this.b = r90Var;
        this.c = u6Var;
    }
}
