package defpackage;

import java.text.DateFormat;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wj0 extends xj0 {
    public static final wj0 Z = new wj0(null, null);

    public wj0(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        Date date = (Date) obj;
        if (p(gt3Var)) {
            i52Var.i0(date == null ? 0L : date.getTime());
        } else {
            q(date, i52Var, gt3Var);
        }
    }

    @Override // defpackage.xj0
    public final xj0 r(Boolean bool, DateFormat dateFormat) {
        return new wj0(bool, dateFormat);
    }
}
