package defpackage;

import com.getsurfboard.ui.activity.ProfileEditorActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p53 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ p53(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.b;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                xl4 xl4Var = xl4.a;
                ((z00) obj2).d(xl4Var);
                return xl4Var;
            default:
                Throwable th = (Throwable) obj;
                th.getClass();
                ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) obj2;
                return ji0.B(uf2.t(profileEditorActivity), null, null, new w53(profileEditorActivity, th, null, 1), 3);
        }
    }
}
