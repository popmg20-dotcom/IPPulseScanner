package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class r91 {
    public static final q91 a = new q91();
    public static final q91 b;

    static {
        v93 v93Var = v93.c;
        q91 q91Var = null;
        try {
            q91Var = (q91) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = q91Var;
    }
}
