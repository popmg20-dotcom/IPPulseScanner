package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o83 implements Serializable {
    public static final o83 Y = new o83(Boolean.TRUE, null, null, null, null, null, null);
    public static final o83 Z = new o83(Boolean.FALSE, null, null, null, null, null, null);
    public static final o83 y0 = new o83(null, null, null, null, null, null, null);
    public final bt2 A;
    public final bt2 X;
    public final Boolean b;
    public final Integer f;
    public final String z;

    public o83(Boolean bool, String str, Integer num, String str2, vo voVar, bt2 bt2Var, bt2 bt2Var2) {
        this.b = bool;
        this.f = num;
        this.z = (str2 == null || str2.isEmpty()) ? null : str2;
        this.A = bt2Var;
        this.X = bt2Var2;
    }
}
