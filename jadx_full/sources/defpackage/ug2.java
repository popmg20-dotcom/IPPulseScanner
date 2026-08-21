package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ug2 {
    public static final tg2 a;
    public static final tg2 b;

    static {
        v93 v93Var = v93.c;
        tg2 tg2Var = null;
        try {
            tg2Var = (tg2) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = tg2Var;
        b = new tg2();
    }
}
