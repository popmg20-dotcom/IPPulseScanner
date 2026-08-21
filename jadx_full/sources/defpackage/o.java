package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o extends s {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(bn bnVar, int i) {
        super(bnVar);
        this.c = i;
    }

    @Override // defpackage.s
    public final void C(int i, StringBuilder sb) {
        switch (this.c) {
            case 0:
                sb.append("(3103)");
                break;
            default:
                if (i >= 10000) {
                    sb.append("(3203)");
                } else {
                    sb.append("(3202)");
                }
                break;
        }
    }

    @Override // defpackage.s
    public final int D(int i) {
        switch (this.c) {
            case 0:
                return i;
            default:
                return i < 10000 ? i : i - 10000;
        }
    }

    @Override // defpackage.m0
    public final String p() throws qs2 {
        if (((bn) this.a).f != 60) {
            throw qs2.a();
        }
        StringBuilder sb = new StringBuilder();
        A(5, sb);
        E(sb, 45, 15);
        return sb.toString();
    }
}
