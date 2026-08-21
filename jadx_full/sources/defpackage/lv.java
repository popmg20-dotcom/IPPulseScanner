package defpackage;

import java.text.DateFormat;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lv extends xj0 {
    public static final lv Z = new lv(null, null);

    public lv(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        Calendar calendar = (Calendar) obj;
        if (p(gt3Var)) {
            i52Var.i0(calendar == null ? 0L : calendar.getTimeInMillis());
        } else {
            q(calendar.getTime(), i52Var, gt3Var);
        }
    }

    @Override // defpackage.xj0
    public final xj0 r(Boolean bool, DateFormat dateFormat) {
        return new lv(bool, dateFormat);
    }
}
