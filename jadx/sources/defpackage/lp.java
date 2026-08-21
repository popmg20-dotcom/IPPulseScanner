package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public interface lp {
    public static final lp e;

    static {
        int i = 10;
        lp k01Var = new k01(i);
        List listAsList = Arrays.asList(ed3.X, hh0.X, a01.X, zx3.X, c01.X, cw2.X, ay3.X);
        int i2 = kp.a;
        if (!ga5.u(listAsList)) {
            k01Var = new cp1(i, listAsList);
        }
        e = k01Var;
    }
}
