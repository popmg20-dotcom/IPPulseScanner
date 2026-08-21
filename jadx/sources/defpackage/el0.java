package defpackage;

import j$.util.Objects;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class el0 extends hi4 {
    public static final bl0 c = new bl0();
    public final dl0 a;
    public final ArrayList b;

    public el0(dl0 dl0Var) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        Objects.requireNonNull(dl0Var);
        this.a = dl0Var;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (j32.a >= 9) {
            arrayList.add(new SimpleDateFormat(ha0.o("MMM d, yyyy", " ", "h:mm:ss a"), locale));
        }
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        Date dateB;
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        String strQ = r62Var.q();
        synchronized (this.b) {
            try {
                Iterator it = this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        try {
                            dateB = aw1.b(strQ, new ParsePosition(0));
                            break;
                        } catch (ParseException e) {
                            StringBuilder sbD = fw.D("Failed parsing '", strQ, "' as Date; at path ");
                            sbD.append(r62Var.x(true));
                            throw new l52(sbD.toString(), e);
                        }
                    }
                    DateFormat dateFormat = (DateFormat) it.next();
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            dateB = dateFormat.parse(strQ);
                            break;
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.a.a(dateB);
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            v72Var.C();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.b.get(0);
        synchronized (this.b) {
            str = dateFormat.format(date);
        }
        v72Var.Z(str);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
