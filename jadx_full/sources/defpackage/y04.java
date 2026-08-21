package defpackage;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y04 extends hi4 {
    public static final a b = new a();
    public final SimpleDateFormat a;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public class a implements ii4 {
        @Override // defpackage.ii4
        public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
            if (bk4Var.a == Date.class) {
                return new y04(0);
            }
            return null;
        }
    }

    private y04() {
        this.a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        Date date;
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        String strQ = r62Var.q();
        synchronized (this) {
            TimeZone timeZone = this.a.getTimeZone();
            try {
                try {
                    date = new Date(this.a.parse(strQ).getTime());
                } catch (ParseException e) {
                    throw new l52("Failed parsing '" + strQ + "' as SQL Date; at path " + r62Var.x(true), e);
                }
            } finally {
                this.a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            v72Var.C();
            return;
        }
        synchronized (this) {
            str = this.a.format((java.util.Date) date);
        }
        v72Var.Z(str);
    }

    public /* synthetic */ y04(int i) {
        this();
    }
}
