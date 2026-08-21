package defpackage;

import com.getsurfboard.backup.model.SettingValue;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fu3 {
    public static final fu3 A;
    public static final fu3 X;
    public static final /* synthetic */ fu3[] Y;
    public static final fu3 b;
    public static final fu3 f;
    public static final fu3 z;

    static {
        fu3 fu3Var = new fu3(SettingValue.TYPE_STRING, 0);
        b = fu3Var;
        fu3 fu3Var2 = new fu3(SettingValue.TYPE_INT, 1);
        f = fu3Var2;
        fu3 fu3Var3 = new fu3(SettingValue.TYPE_LONG, 2);
        fu3 fu3Var4 = new fu3(SettingValue.TYPE_BOOLEAN, 3);
        z = fu3Var4;
        fu3 fu3Var5 = new fu3(SettingValue.TYPE_STRING_SET, 4);
        A = fu3Var5;
        fu3 fu3Var6 = new fu3(SettingValue.TYPE_ENUM, 5);
        X = fu3Var6;
        Y = new fu3[]{fu3Var, fu3Var2, fu3Var3, fu3Var4, fu3Var5, fu3Var6};
    }

    public static fu3 valueOf(String str) {
        return (fu3) Enum.valueOf(fu3.class, str);
    }

    public static fu3[] values() {
        return (fu3[]) Y.clone();
    }
}
