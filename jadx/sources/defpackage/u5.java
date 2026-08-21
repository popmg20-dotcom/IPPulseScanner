package defpackage;

import com.getsurfboard.R;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u5 {
    public static final u5 A;
    public static final u5 X;
    public static final /* synthetic */ u5[] Y;
    public static final /* synthetic */ j51 Z;
    public static final u5 z;
    public final int b;
    public final int f;

    static {
        u5 u5Var = new u5("IP", 0, R.string.host_type_ip, R.string.host_value_hint_ip);
        z = u5Var;
        u5 u5Var2 = new u5("DOMAIN", 1, R.string.host_type_domain, R.string.host_value_hint_domain);
        u5 u5Var3 = new u5("DNS_SERVER", 2, R.string.host_type_dns_server, R.string.host_value_hint_dns);
        A = u5Var3;
        u5 u5Var4 = new u5("DOH_SERVER", 3, R.string.host_type_doh_server, R.string.host_value_hint_doh);
        X = u5Var4;
        u5[] u5VarArr = {u5Var, u5Var2, u5Var3, u5Var4};
        Y = u5VarArr;
        Z = new j51(u5VarArr);
    }

    public u5(String str, int i, int i2, int i3) {
        this.b = i2;
        this.f = i3;
    }

    public static u5 valueOf(String str) {
        return (u5) Enum.valueOf(u5.class, str);
    }

    public static u5[] values() {
        return (u5[]) Y.clone();
    }
}
