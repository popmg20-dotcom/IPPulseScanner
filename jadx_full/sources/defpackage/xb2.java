package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xb2 {
    public static final wb2 a;
    public static final wb2 b;

    static {
        v93 v93Var = v93.c;
        wb2 wb2Var = null;
        try {
            wb2Var = (wb2) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = wb2Var;
        b = new wb2();
    }
}
