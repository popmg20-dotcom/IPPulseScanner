package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p extends r {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(bn bnVar, int i) {
        super(bnVar);
        this.c = i;
    }

    @Override // defpackage.m0
    public final String p() throws qs2 {
        switch (this.c) {
            case 0:
                ed4 ed4Var = (ed4) this.b;
                if (((bn) this.a).f < 48) {
                    throw qs2.a();
                }
                StringBuilder sb = new StringBuilder();
                A(8, sb);
                int iY = ed4.y(48, 2, (bn) ed4Var.f);
                sb.append("(392");
                sb.append(iY);
                sb.append(')');
                sb.append(ed4Var.t(50, null).d);
                return sb.toString();
            case 1:
                ed4 ed4Var2 = (ed4) this.b;
                bn bnVar = (bn) ed4Var2.f;
                if (((bn) this.a).f < 48) {
                    throw qs2.a();
                }
                StringBuilder sb2 = new StringBuilder();
                A(8, sb2);
                int iY2 = ed4.y(48, 2, bnVar);
                sb2.append("(393");
                sb2.append(iY2);
                sb2.append(')');
                int iY3 = ed4.y(50, 10, bnVar);
                if (iY3 / 100 == 0) {
                    sb2.append('0');
                }
                if (iY3 / 10 == 0) {
                    sb2.append('0');
                }
                sb2.append(iY3);
                sb2.append(ed4Var2.t(60, null).d);
                return sb2.toString();
            default:
                StringBuilder sb3 = new StringBuilder();
                sb3.append("(01)");
                int length = sb3.length();
                ed4 ed4Var3 = (ed4) this.b;
                sb3.append(ed4.y(4, 4, (bn) ed4Var3.f));
                B(sb3, 8, length);
                return ed4Var3.s(48, sb3);
        }
    }
}
