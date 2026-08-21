package defpackage;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class aj4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        int iNextInt;
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        r62Var.p0();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (r62Var.X() == 4) {
                r62Var.V();
                return new GregorianCalendar(i, i2, i3, i4, i5, i6);
            }
            String strR = r62Var.R();
            iNextInt = r62Var.nextInt();
            switch (strR) {
                case "dayOfMonth":
                    i3 = iNextInt;
                    break;
                case "minute":
                    i5 = iNextInt;
                    break;
                case "second":
                    i6 = iNextInt;
                    break;
                case "year":
                    i = iNextInt;
                    break;
                case "month":
                    i2 = iNextInt;
                    break;
                case "hourOfDay":
                    i4 = iNextInt;
                    break;
            }
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        if (((Calendar) obj) == null) {
            v72Var.C();
            return;
        }
        v72Var.p0();
        v72Var.s("year");
        v72Var.U(r4.get(1));
        v72Var.s("month");
        v72Var.U(r4.get(2));
        v72Var.s("dayOfMonth");
        v72Var.U(r4.get(5));
        v72Var.s("hourOfDay");
        v72Var.U(r4.get(11));
        v72Var.s("minute");
        v72Var.U(r4.get(12));
        v72Var.s("second");
        v72Var.U(r4.get(13));
        v72Var.V();
    }
}
