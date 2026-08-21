package defpackage;

import java.util.EnumSet;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class zt3 {
    public static final zt3 b;
    public static final /* synthetic */ zt3[] f;

    static {
        zt3 zt3Var = new zt3("NONE", 0);
        b = zt3Var;
        f = new zt3[]{zt3Var, new zt3("IGNORE", 1), new zt3("RESERVED", 2)};
        EnumSet.allOf(zt3.class);
    }

    public static zt3 valueOf(String str) {
        return (zt3) Enum.valueOf(zt3.class, str);
    }

    public static zt3[] values() {
        return (zt3[]) f.clone();
    }
}
