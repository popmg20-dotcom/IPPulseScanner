package defpackage;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z04 extends hi4 {
    public static final a b = new a();
    public final SimpleDateFormat a;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public class a implements ii4 {
        @Override // defpackage.ii4
        public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
            if (bk4Var.a == Time.class) {
                return new z04(0);
            }
            return null;
        }
    }

    private z04() {
        this.a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        Time time;
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        String strQ = r62Var.q();
        synchronized (this) {
            TimeZone timeZone = this.a.getTimeZone();
            try {
                try {
                    time = new Time(this.a.parse(strQ).getTime());
                } catch (ParseException e) {
                    throw new l52("Failed parsing '" + strQ + "' as SQL Time; at path " + r62Var.x(true), e);
                }
            } finally {
                this.a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            v72Var.C();
            return;
        }
        synchronized (this) {
            str = this.a.format((Date) time);
        }
        v72Var.Z(str);
    }

    public /* synthetic */ z04(int i) {
        this();
    }
}
