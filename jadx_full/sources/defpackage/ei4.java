package defpackage;

import com.getsurfboard.backup.model.SettingValue;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ei4 {
    public static final /* synthetic */ ei4[] A;
    public static final ei4 b;
    public static final ei4 f;
    public static final ei4[] z;

    static {
        ei4 ei4Var = new ei4("EXTENDED", 0);
        b = ei4Var;
        ei4 ei4Var2 = new ei4("POINTER", 1);
        f = ei4Var2;
        A = new ei4[]{ei4Var, ei4Var2, new ei4("UTF8_STRING", 2), new ei4("DOUBLE", 3), new ei4("BYTES", 4), new ei4("UINT16", 5), new ei4("UINT32", 6), new ei4("MAP", 7), new ei4("INT32", 8), new ei4("UINT64", 9), new ei4("UINT128", 10), new ei4("ARRAY", 11), new ei4("CONTAINER", 12), new ei4("END_MARKER", 13), new ei4(SettingValue.TYPE_BOOLEAN, 14), new ei4("FLOAT", 15)};
        z = values();
    }

    public static ei4 valueOf(String str) {
        return (ei4) Enum.valueOf(ei4.class, str);
    }

    public static ei4[] values() {
        return (ei4[]) A.clone();
    }
}
