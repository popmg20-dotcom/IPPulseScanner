package defpackage;

import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.database.AppDatabase;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class oj0 {
    public static final AppDatabase a;

    static {
        ml3 ml3VarJ = l72.j(ContextUtilsKt.getContext(), AppDatabase.class, "surfboard");
        ml3VarJ.n = false;
        ml3VarJ.o = true;
        ml3VarJ.p = false;
        int i = 6;
        int i2 = 7;
        int i3 = 8;
        ml3VarJ.a(new gm2(3, 4, 13), new gm2(5, i, 14), new gm2(i, i2, 15), new gm2(i2, i3, 16), new gm2(i3, 9, 17));
        ml3VarJ.i = true;
        a = (AppDatabase) ml3VarJ.b();
    }
}
