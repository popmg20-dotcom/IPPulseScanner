package defpackage;

import io.netty.util.internal.StringUtil;
import j$.util.DesugarTimeZone;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e34 extends DateFormat {
    public static final Locale A0;
    public static final SimpleDateFormat B0;
    public static final e34 C0;
    public static final GregorianCalendar D0;
    public static final Pattern Y = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");
    public static final Pattern Z;
    public static final String[] y0;
    public static final TimeZone z0;
    public transient Calendar A;
    public transient DateFormat X;
    public transient TimeZone b;
    public final Locale f;
    public Boolean z;

    static {
        try {
            Z = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
            y0 = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};
            TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
            z0 = timeZone;
            Locale locale = Locale.US;
            A0 = locale;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
            B0 = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
            C0 = new e34();
            D0 = new GregorianCalendar(timeZone, locale);
        } catch (Exception e) {
            vp1.p(e);
        }
    }

    public e34(TimeZone timeZone, Locale locale, Boolean bool) {
        this.b = timeZone;
        this.f = locale;
        this.z = bool;
    }

    public static int b(int i, String str) {
        return (str.charAt(i + 1) - '0') + ((str.charAt(i) - '0') * 10);
    }

    public static int c(String str) {
        return (str.charAt(3) - '0') + ((str.charAt(2) - '0') * 10) + ((str.charAt(1) - '0') * 100) + ((str.charAt(0) - '0') * 1000);
    }

    public static void f(StringBuffer stringBuffer, int i) {
        int i2 = i / 10;
        if (i2 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i2 + 48));
            i -= i2 * 10;
        }
        stringBuffer.append((char) (i + 48));
    }

    public static void g(StringBuffer stringBuffer, int i) {
        int i2 = i / 100;
        if (i2 == 0) {
            stringBuffer.append('0');
            stringBuffer.append('0');
        } else {
            if (i2 > 99) {
                stringBuffer.append(i2);
            } else {
                f(stringBuffer, i2);
            }
            i -= i2 * 100;
        }
        f(stringBuffer, i);
    }

    public final Calendar a(TimeZone timeZone) {
        Calendar calendar = this.A;
        if (calendar == null) {
            calendar = (Calendar) D0.clone();
            this.A = calendar;
        }
        if (!calendar.getTimeZone().equals(timeZone)) {
            calendar.setTimeZone(timeZone);
        }
        calendar.setLenient(isLenient());
        return calendar;
    }

    @Override // java.text.DateFormat, java.text.Format
    public final Object clone() {
        return new e34(this.b, this.f, this.z);
    }

    public final Date d(String str) throws ParseException {
        String str2;
        int i;
        int i2;
        int iB;
        int length = str.length();
        Calendar calendarA = a((this.b == null || 'Z' == str.charAt(length + (-1))) ? z0 : this.b);
        calendarA.clear();
        int iCharAt = 0;
        if (length > 10) {
            Matcher matcher = Z.matcher(str);
            if (matcher.matches()) {
                int iStart = matcher.start(2);
                int iEnd = matcher.end(2);
                int i3 = iEnd - iStart;
                if (i3 > 1) {
                    int iB2 = b(iStart + 1, str) * 3600;
                    if (i3 >= 5) {
                        iB2 += b(iEnd - 2, str) * 60;
                    }
                    calendarA.set(15, str.charAt(iStart) == '-' ? iB2 * (-1000) : iB2 * 1000);
                    calendarA.set(16, 0);
                }
                int iC = c(str);
                int iB3 = b(5, str) - 1;
                int iB4 = b(8, str);
                int iB5 = b(11, str);
                int iB6 = b(14, str);
                if (length <= 16 || str.charAt(16) != ':') {
                    i = iB4;
                    i2 = iC;
                    iB = 0;
                } else {
                    i = iB4;
                    i2 = iC;
                    iB = b(17, str);
                }
                calendarA.set(i2, iB3, i, iB5, iB6, iB);
                int iStart2 = matcher.start(1);
                int i4 = iStart2 + 1;
                int iEnd2 = matcher.end(1);
                if (i4 >= iEnd2) {
                    calendarA.set(14, 0);
                } else {
                    int i5 = iEnd2 - i4;
                    if (i5 != 0) {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                if (i5 != 3 && i5 > 9) {
                                    throw new ParseException(fw.v("Cannot parse date \"", str, "\": invalid fractional seconds '", matcher.group(1).substring(1), "'; can use at most 9 digits"), i4);
                                }
                                iCharAt = str.charAt(iStart2 + 3) - '0';
                            }
                            iCharAt += (str.charAt(iStart2 + 2) - '0') * 10;
                        }
                        iCharAt += (str.charAt(i4) - '0') * 100;
                    }
                    calendarA.set(14, iCharAt);
                }
                return calendarA.getTime();
            }
            str2 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
        } else {
            if (Y.matcher(str).matches()) {
                calendarA.set(c(str), b(5, str) - 1, b(8, str), 0, 0, 0);
                calendarA.set(14, 0);
                return calendarA.getTime();
            }
            str2 = "yyyy-MM-dd";
        }
        Boolean bool = this.z;
        StringBuilder sbE = fw.E("Cannot parse date \"", str, "\": while it seems to fit format '", str2, "', parsing fails (leniency? ");
        sbE.append(bool);
        sbE.append(")");
        throw new ParseException(sbE.toString(), 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
    
        if (r2 < 0) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Date e(java.lang.String r6, java.text.ParsePosition r7) throws java.text.ParseException {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e34.e(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    @Override // java.text.DateFormat
    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // java.text.DateFormat
    public final StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = this.b;
        if (timeZone == null) {
            timeZone = z0;
        }
        Calendar calendarA = a(timeZone);
        calendarA.setTime(date);
        int i = calendarA.get(1);
        if (calendarA.get(0) != 0) {
            if (i > 9999) {
                stringBuffer.append('+');
            }
            g(stringBuffer, i);
        } else if (i == 1) {
            stringBuffer.append("+0000");
        } else {
            stringBuffer.append('-');
            g(stringBuffer, i - 1);
        }
        stringBuffer.append('-');
        f(stringBuffer, calendarA.get(2) + 1);
        stringBuffer.append('-');
        f(stringBuffer, calendarA.get(5));
        stringBuffer.append('T');
        f(stringBuffer, calendarA.get(11));
        stringBuffer.append(':');
        f(stringBuffer, calendarA.get(12));
        stringBuffer.append(':');
        f(stringBuffer, calendarA.get(13));
        stringBuffer.append('.');
        int i2 = calendarA.get(14);
        int i3 = i2 / 100;
        if (i3 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i3 + 48));
            i2 -= i3 * 100;
        }
        f(stringBuffer, i2);
        int offset = timeZone.getOffset(calendarA.getTimeInMillis());
        if (offset == 0) {
            stringBuffer.append("+00:00");
            return stringBuffer;
        }
        int i4 = offset / 60000;
        int iAbs = Math.abs(i4 / 60);
        int iAbs2 = Math.abs(i4 % 60);
        stringBuffer.append(offset < 0 ? '-' : '+');
        f(stringBuffer, iAbs);
        stringBuffer.append(':');
        f(stringBuffer, iAbs2);
        return stringBuffer;
    }

    @Override // java.text.DateFormat
    public final TimeZone getTimeZone() {
        return this.b;
    }

    @Override // java.text.DateFormat
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.text.DateFormat
    public final boolean isLenient() {
        Boolean bool = this.z;
        return bool == null || bool.booleanValue();
    }

    @Override // java.text.DateFormat
    public final Date parse(String str) throws ParseException {
        String strTrim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date dateE = e(strTrim, parsePosition);
        if (dateE != null) {
            return dateE;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : y0) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            } else {
                sb.append(StringUtil.DOUBLE_QUOTE);
            }
            sb.append(str2);
        }
        sb.append(StringUtil.DOUBLE_QUOTE);
        throw new ParseException(fw.v("Cannot parse date \"", strTrim, "\": not compatible with any of standard forms (", sb.toString(), ")"), parsePosition.getErrorIndex());
    }

    @Override // java.text.DateFormat
    public final void setLenient(boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        Boolean bool = this.z;
        if (boolValueOf == bool || boolValueOf.equals(bool)) {
            return;
        }
        this.z = boolValueOf;
        this.X = null;
    }

    @Override // java.text.DateFormat
    public final void setTimeZone(TimeZone timeZone) {
        if (timeZone.equals(this.b)) {
            return;
        }
        this.X = null;
        this.b = timeZone;
    }

    public final String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", e34.class.getName(), this.b, this.f, this.z);
    }

    public e34() {
        this.f = A0;
    }

    @Override // java.text.DateFormat
    public final Date parse(String str, ParsePosition parsePosition) {
        try {
            return e(str, parsePosition);
        } catch (ParseException unused) {
            return null;
        }
    }
}
