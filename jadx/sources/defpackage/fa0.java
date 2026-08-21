package defpackage;

import kotlin.jvm.functions.Function2;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class fa0 {
    public static final br1 a = new br1("CLOSED", 3);

    public static final Object a(sr3 sr3Var, long j, Function2 function2) {
        while (true) {
            sr3 sr3Var2 = sr3Var;
            while (true) {
                if (sr3Var2.A >= j && !sr3Var2.d()) {
                    return sr3Var2;
                }
                Object objectVolatile = re.a.getObjectVolatile(sr3Var2, ga0.b);
                br1 br1Var = a;
                if (objectVolatile == br1Var) {
                    return br1Var;
                }
                sr3Var = (sr3) ((ga0) objectVolatile);
                if (sr3Var != null) {
                    break;
                }
                sr3 sr3Var3 = (sr3) function2.k(Long.valueOf(sr3Var2.A + 1), sr3Var2);
                while (true) {
                    Unsafe unsafe = re.a;
                    long j2 = ga0.b;
                    if (unsafe.compareAndSwapObject(sr3Var2, j2, (Object) null, sr3Var3)) {
                        if (sr3Var2.d()) {
                            sr3Var2.e();
                        }
                        sr3Var2 = sr3Var3;
                    } else if (unsafe.getObjectVolatile(sr3Var2, j2) != null) {
                        break;
                    }
                }
            }
        }
    }
}
