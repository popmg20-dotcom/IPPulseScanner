package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class oe1 implements ss3 {
    public final ss3 a;
    public final boolean b;
    public final am1 c;

    public oe1(ss3 ss3Var, boolean z, am1 am1Var) {
        this.a = ss3Var;
        this.b = z;
        this.c = am1Var;
    }

    @Override // defpackage.ss3
    public final Iterator iterator() {
        return new ne1(this);
    }
}
