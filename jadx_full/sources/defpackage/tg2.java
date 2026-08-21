package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tg2 {
    public static sg2 a(Object obj, Object obj2) {
        sg2 sg2VarB = (sg2) obj;
        sg2 sg2Var = (sg2) obj2;
        if (!sg2Var.isEmpty()) {
            if (!sg2VarB.b) {
                sg2VarB = sg2VarB.b();
            }
            sg2VarB.a();
            if (!sg2Var.isEmpty()) {
                sg2VarB.putAll(sg2Var);
            }
        }
        return sg2VarB;
    }
}
