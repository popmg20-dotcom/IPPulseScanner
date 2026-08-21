package defpackage;

import com.getsurfboard.backup.model.SettingValue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum qc5 {
    f("VOID"),
    z(SettingValue.TYPE_INT),
    A(SettingValue.TYPE_LONG),
    X("FLOAT"),
    Y("DOUBLE"),
    Z(SettingValue.TYPE_BOOLEAN),
    y0(SettingValue.TYPE_STRING),
    z0("BYTE_STRING"),
    A0(SettingValue.TYPE_ENUM),
    B0("MESSAGE");

    public final Class b;

    static {
        hb5 hb5Var = hb5.z;
    }

    qc5(String str) {
        this.b = cls;
    }
}
