package defpackage;

import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jz2 implements pl1 {
    public static final jz2 f = new jz2(0);
    public final /* synthetic */ int b;

    public /* synthetic */ jz2(int i) {
        this.b = i;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                break;
            case 1:
                p95.C(R.string.unknown_error, new Object[0]);
                break;
            case 2:
                p95.C(R.string.unknown_error, new Object[0]);
                break;
            default:
                p95.C(R.string.io_error, new Object[0]);
                break;
        }
        return xl4Var;
    }
}
