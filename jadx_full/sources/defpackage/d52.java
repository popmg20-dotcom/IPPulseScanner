package defpackage;

import com.getsurfboard.backup.model.SettingValue;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d52 {
    public static final d52 A;
    public static final d52 A0;
    public static final /* synthetic */ d52[] B0;
    public static final d52 X;
    public static final d52 Y;
    public static final d52 Z;
    public static final d52 b;
    public static final d52 f;
    public static final d52 y0;
    public static final d52 z;
    public static final d52 z0;

    static {
        d52 d52Var = new d52("ANY", 0);
        b = d52Var;
        d52 d52Var2 = new d52("NATURAL", 1);
        f = d52Var2;
        d52 d52Var3 = new d52("SCALAR", 2);
        z = d52Var3;
        d52 d52Var4 = new d52("ARRAY", 3);
        A = d52Var4;
        d52 d52Var5 = new d52("OBJECT", 4);
        X = d52Var5;
        d52 d52Var6 = new d52("NUMBER", 5);
        Y = d52Var6;
        d52 d52Var7 = new d52("NUMBER_FLOAT", 6);
        Z = d52Var7;
        d52 d52Var8 = new d52("NUMBER_INT", 7);
        y0 = d52Var8;
        d52 d52Var9 = new d52(SettingValue.TYPE_STRING, 8);
        z0 = d52Var9;
        d52 d52Var10 = new d52(SettingValue.TYPE_BOOLEAN, 9);
        d52 d52Var11 = new d52("BINARY", 10);
        A0 = d52Var11;
        B0 = new d52[]{d52Var, d52Var2, d52Var3, d52Var4, d52Var5, d52Var6, d52Var7, d52Var8, d52Var9, d52Var10, d52Var11};
    }

    public static d52 valueOf(String str) {
        return (d52) Enum.valueOf(d52.class, str);
    }

    public static d52[] values() {
        return (d52[]) B0.clone();
    }

    public final boolean a() {
        return this == Y || this == y0 || this == Z;
    }
}
