package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y34 implements rt3 {
    public final /* synthetic */ z34 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ mn4 d;
    public final /* synthetic */ ih e;
    public final /* synthetic */ ih f;

    public /* synthetic */ y34(z34 z34Var, String str, String str2, mn4 mn4Var, ih ihVar, ih ihVar2) {
        this.a = z34Var;
        this.b = str;
        this.c = str2;
        this.d = mn4Var;
        this.e = ihVar;
        this.f = ihVar2;
    }

    @Override // defpackage.rt3
    public final void a(tt3 tt3Var) {
        z34 z34Var = this.a;
        if (z34Var.c() == null) {
            return;
        }
        z34Var.D();
        z34Var.C(z34Var.E(this.b, this.c, this.d, this.e, this.f));
        z34Var.p();
        es4 es4Var = z34Var.q;
        es4Var.getClass();
        co4.h();
        Iterator it = es4Var.b.iterator();
        while (it.hasNext()) {
            es4Var.e((in4) it.next());
        }
    }
}
