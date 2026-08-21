package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class rr2 {
    public static final qr2 a;
    public static final qr2 b;

    static {
        v93 v93Var = v93.c;
        qr2 qr2Var = null;
        try {
            qr2Var = (qr2) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = qr2Var;
        b = new qr2();
    }
}
