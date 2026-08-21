package defpackage;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j70 implements ss3 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ j70(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.ss3
    public final Iterator iterator() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((Iterable) obj).iterator();
            case 1:
                return new ib2(this);
            case 2:
                ts3 ts3Var = new ts3();
                ts3Var.A = ((kk) ((Function2) obj)).n(ts3Var, ts3Var);
                return ts3Var;
            case 3:
                return (Iterator) obj;
            default:
                return new hb2((CharSequence) obj);
        }
    }
}
