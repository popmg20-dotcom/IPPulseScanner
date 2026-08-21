package defpackage;

import java.io.StringWriter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bk0 extends r82 implements pl1 {
    public final /* synthetic */ int A;
    public final /* synthetic */ ck0 f;
    public final /* synthetic */ StringWriter z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk0(ck0 ck0Var, StringWriter stringWriter, int i) {
        super(0);
        this.f = ck0Var;
        this.z = stringWriter;
        this.A = i;
    }

    @Override // defpackage.pl1
    public final Object a() {
        ck0 ck0Var = this.f;
        lu2 lu2Var = ck0Var.a;
        v92 v92Var = new v92(15);
        v92Var.b = ck0Var.c;
        cj3 cj3Var = ej3.a;
        String string = this.z.toString();
        string.getClass();
        v92Var.m("PROPFIND", t60.j(string, ck0.d));
        int i = this.A;
        v92Var.l("Depth", i >= 0 ? String.valueOf(i) : "infinity");
        return new le3(lu2Var, new cm2(v92Var)).e();
    }
}
