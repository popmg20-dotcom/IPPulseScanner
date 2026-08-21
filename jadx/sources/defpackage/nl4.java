package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class nl4 {
    public static final du a;

    static {
        du duVar = new du(1);
        int i = 0;
        while (true) {
            ml4[] ml4VarArr = ml4.Dh;
            if (i >= ml4VarArr.length) {
                a = duVar;
                return;
            } else {
                duVar.j(ml4VarArr[i].f, Integer.valueOf(i));
                i++;
            }
        }
    }
}
