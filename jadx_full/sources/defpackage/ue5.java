package defpackage;

import com.getsurfboard.backup.model.SettingValue;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ue5 {
    public static final ue5 A;
    public static final /* synthetic */ ue5[] A0;
    public static final ue5 X;
    public static final ue5 Y;
    public static final ue5 Z;
    public static final ue5 b;
    public static final ue5 f;
    public static final ue5 y0;
    public static final ue5 z;
    public static final ue5 z0;

    static {
        ue5 ue5Var = new ue5(SettingValue.TYPE_INT, 0);
        b = ue5Var;
        ue5 ue5Var2 = new ue5(SettingValue.TYPE_LONG, 1);
        f = ue5Var2;
        ue5 ue5Var3 = new ue5("FLOAT", 2);
        z = ue5Var3;
        ue5 ue5Var4 = new ue5("DOUBLE", 3);
        A = ue5Var4;
        ue5 ue5Var5 = new ue5(SettingValue.TYPE_BOOLEAN, 4);
        X = ue5Var5;
        ue5 ue5Var6 = new ue5(SettingValue.TYPE_STRING, 5);
        Y = ue5Var6;
        hb5 hb5Var = hb5.z;
        ue5 ue5Var7 = new ue5("BYTE_STRING", 6);
        Z = ue5Var7;
        ue5 ue5Var8 = new ue5(SettingValue.TYPE_ENUM, 7);
        y0 = ue5Var8;
        ue5 ue5Var9 = new ue5("MESSAGE", 8);
        z0 = ue5Var9;
        A0 = new ue5[]{ue5Var, ue5Var2, ue5Var3, ue5Var4, ue5Var5, ue5Var6, ue5Var7, ue5Var8, ue5Var9};
    }

    public static ue5[] values() {
        return (ue5[]) A0.clone();
    }
}
