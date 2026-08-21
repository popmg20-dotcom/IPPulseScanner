package defpackage;

import android.util.Pair;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q23 extends p23 {
    public final j50 b;
    public final j50 c;
    public final Function2 d;

    public q23(j50 j50Var, j50 j50Var2, Function2 function2) {
        super(dh3.a(Pair.class));
        this.b = j50Var;
        this.c = j50Var2;
        this.d = function2;
    }

    @Override // defpackage.p23
    public final boolean a(Object obj, Object obj2) {
        Pair pair = (Pair) obj2;
        Object obj3 = pair.first;
        ke0.e(this.b, obj3);
        Object obj4 = pair.second;
        ke0.e(this.c, obj4);
        return ((Boolean) this.d.k(obj3, obj4)).booleanValue();
    }

    public final int hashCode() {
        return this.d.hashCode();
    }

    public final String toString() {
        return this.d.toString();
    }
}
