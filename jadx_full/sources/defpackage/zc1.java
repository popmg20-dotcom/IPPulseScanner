package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zc1 implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ String f;
    public final /* synthetic */ String z;

    public /* synthetic */ zc1(String str, String str2, int i) {
        this.b = i;
        this.f = str;
        this.z = str2;
    }

    @Override // defpackage.pl1
    public final Object a() throws IOException {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        String str = this.z;
        String str2 = this.f;
        switch (i) {
            case 0:
                vo.I(str2, gb4.M(str));
                break;
            case 1:
                vo.I(str2, gb4.M(str));
                break;
            case 2:
                fx3.E(str2, gb4.M(str));
                break;
            case 3:
                fx3.E(str2, gb4.M(str));
                break;
            case 4:
                tj4.X(str2, gb4.M(str));
                break;
            default:
                tj4.X(str2, gb4.M(str));
                break;
        }
        return xl4Var;
    }
}
