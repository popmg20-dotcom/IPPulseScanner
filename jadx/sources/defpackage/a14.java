package defpackage;

import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class a14 implements ii4 {
    @Override // defpackage.ii4
    public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
        if (bk4Var.a != Timestamp.class) {
            return null;
        }
        iq1Var.getClass();
        return new b14(iq1Var.d(new bk4(Date.class)));
    }
}
