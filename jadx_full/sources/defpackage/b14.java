package defpackage;

import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b14 extends hi4 {
    public static final a14 b = new a14();
    public final hi4 a;

    public b14(hi4 hi4Var) {
        this.a = hi4Var;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) {
        Date date = (Date) this.a.b(r62Var);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) {
        this.a.c(v72Var, (Timestamp) obj);
    }
}
