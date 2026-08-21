package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class go1 implements ss3 {
    public final /* synthetic */ int a;
    public final am1 b;
    public final Object c;

    public /* synthetic */ go1(Object obj, am1 am1Var, int i) {
        this.a = i;
        this.c = obj;
        this.b = am1Var;
    }

    @Override // defpackage.ss3
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return new fo1(this);
            default:
                return new mg4(this);
        }
    }
}
