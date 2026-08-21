package defpackage;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ch2 implements Serializable {
    public static final int A0;
    public static final ft3 B0;
    public static final int z0;
    public rt2 A;
    public final qv X;
    public final qv Y;
    public final ft3 Z;
    public final int b;
    public final int f;
    public final char y0;
    public final s62 z;

    static {
        int iD = 0;
        for (int i : fw.L(5)) {
            if (i == 0) {
                throw null;
            }
            iD |= ha0.d(i);
        }
        z0 = iD;
        for (i62 i62Var : i62.values()) {
            boolean z = i62Var.b;
        }
        int i2 = 0;
        for (h52 h52Var : h52.values()) {
            if (h52Var.b) {
                i2 |= h52Var.f;
            }
        }
        A0 = i2;
        B0 = new ft3(" ");
    }

    public ch2(xt2 xt2Var) {
        System.currentTimeMillis();
        new AtomicReference(new pr1());
        this.b = z0;
        this.f = A0;
        this.Z = B0;
        this.z = s62.z;
        this.A = xt2Var;
        this.y0 = StringUtil.DOUBLE_QUOTE;
        this.Y = qv.X;
        this.X = qv.f;
        System.identityHashCode(this);
        new AtomicReference(new wl3(12));
    }
}
