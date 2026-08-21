package defpackage;

import io.netty.channel.unix.Socket;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class qb1 implements Serializable {
    public final int A;
    public final int X;
    public final transient ArrayList Y;
    public final String b;
    public final TimeZone f;
    public final Locale z;
    public static final Locale Z = new Locale("ja", "JP", "JP");
    public static final e1 y0 = new e1(13);
    public static final ConcurrentMap[] z0 = new ConcurrentMap[17];
    public static final gb1 A0 = new gb1(1, 0);
    public static final gb1 B0 = new gb1(2, 1);
    public static final kb1 C0 = new kb1(1);
    public static final kb1 D0 = new kb1(3);
    public static final kb1 E0 = new kb1(4);
    public static final kb1 F0 = new kb1(6);
    public static final kb1 G0 = new kb1(5);
    public static final gb1 H0 = new gb1(7, 2);
    public static final kb1 I0 = new kb1(8);
    public static final kb1 J0 = new kb1(11);
    public static final gb1 K0 = new gb1(11, 3);
    public static final gb1 L0 = new gb1(10, 4);
    public static final kb1 M0 = new kb1(10);
    public static final kb1 N0 = new kb1(12);
    public static final kb1 O0 = new kb1(13);
    public static final kb1 P0 = new kb1(14);

    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x015a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public qb1(String str, TimeZone timeZone, Locale locale) {
        int i;
        mb1 mb1VarA;
        this.b = str;
        this.f = timeZone;
        this.z = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (locale.equals(Z)) {
            i = 0;
        } else {
            calendar.setTime(new Date());
            i = calendar.get(1) - 80;
        }
        int i2 = (i / 100) * 100;
        this.A = i2;
        this.X = i - i2;
        this.Y = new ArrayList();
        int i3 = 0;
        while (true) {
            nb1 nb1Var = null;
            if (i3 < str.length()) {
                char cCharAt = str.charAt(i3);
                if ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z')) {
                    StringBuilder sb = new StringBuilder();
                    boolean z = false;
                    while (i3 < str.length()) {
                        char cCharAt2 = str.charAt(i3);
                        if (z || ((cCharAt2 < 'A' || cCharAt2 > 'Z') && (cCharAt2 < 'a' || cCharAt2 > 'z'))) {
                            if (cCharAt2 != '\'' || ((i3 = i3 + 1) != str.length() && str.charAt(i3) == '\'')) {
                                i3++;
                                sb.append(cCharAt2);
                            } else {
                                z = !z;
                            }
                        } else {
                            if (!z) {
                                xe.k("Unterminated quote");
                                throw null;
                            }
                            String string = sb.toString();
                            nb1Var = new nb1(new ib1(string), string.length());
                        }
                    }
                    if (!z) {
                    }
                } else {
                    int i4 = i3;
                    do {
                        i4++;
                        if (i4 < str.length()) {
                        }
                        int i5 = i4 - i3;
                        if (cCharAt == 'y') {
                            mb1VarA = i5 > 2 ? C0 : A0;
                            nb1 nb1Var2 = new nb1(mb1VarA, i5);
                            i3 = i4;
                            nb1Var = nb1Var2;
                        } else if (cCharAt != 'z') {
                            switch (cCharAt) {
                                case 'D':
                                    mb1VarA = F0;
                                    nb1 nb1Var22 = new nb1(mb1VarA, i5);
                                    i3 = i4;
                                    nb1Var = nb1Var22;
                                    break;
                                case 'E':
                                    mb1VarA = a(7, calendar);
                                    nb1 nb1Var222 = new nb1(mb1VarA, i5);
                                    i3 = i4;
                                    nb1Var = nb1Var222;
                                    break;
                                case 'F':
                                    mb1VarA = I0;
                                    nb1 nb1Var2222 = new nb1(mb1VarA, i5);
                                    i3 = i4;
                                    nb1Var = nb1Var2222;
                                    break;
                                case 'G':
                                    mb1VarA = a(0, calendar);
                                    nb1 nb1Var22222 = new nb1(mb1VarA, i5);
                                    i3 = i4;
                                    nb1Var = nb1Var22222;
                                    break;
                                case 'H':
                                    mb1VarA = J0;
                                    nb1 nb1Var222222 = new nb1(mb1VarA, i5);
                                    i3 = i4;
                                    nb1Var = nb1Var222222;
                                    break;
                                default:
                                    switch (cCharAt) {
                                        case 'K':
                                            mb1VarA = M0;
                                            nb1 nb1Var2222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var2222222;
                                            break;
                                        case 'M':
                                            mb1VarA = i5 >= 3 ? a(2, calendar) : B0;
                                            nb1 nb1Var22222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var22222222;
                                            break;
                                        case 'S':
                                            mb1VarA = P0;
                                            nb1 nb1Var222222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var222222222;
                                            break;
                                        case 'a':
                                            mb1VarA = a(9, calendar);
                                            nb1 nb1Var2222222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var2222222222;
                                            break;
                                        case Socket.UDS_SUN_PATH_SIZE /* 100 */:
                                            mb1VarA = G0;
                                            nb1 nb1Var22222222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var22222222222;
                                            break;
                                        case 'h':
                                            mb1VarA = L0;
                                            nb1 nb1Var222222222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var222222222222;
                                            break;
                                        case 'k':
                                            mb1VarA = K0;
                                            nb1 nb1Var2222222222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var2222222222222;
                                            break;
                                        case 'm':
                                            mb1VarA = N0;
                                            nb1 nb1Var22222222222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var22222222222222;
                                            break;
                                        case 's':
                                            mb1VarA = O0;
                                            nb1 nb1Var222222222222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var222222222222222;
                                            break;
                                        case 'u':
                                            mb1VarA = H0;
                                            nb1 nb1Var2222222222222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var2222222222222222;
                                            break;
                                        case 'w':
                                            mb1VarA = D0;
                                            nb1 nb1Var22222222222222222 = new nb1(mb1VarA, i5);
                                            i3 = i4;
                                            nb1Var = nb1Var22222222222222222;
                                            break;
                                        default:
                                            switch (cCharAt) {
                                                case 'W':
                                                    mb1VarA = E0;
                                                    nb1 nb1Var222222222222222222 = new nb1(mb1VarA, i5);
                                                    i3 = i4;
                                                    nb1Var = nb1Var222222222222222222;
                                                    break;
                                                case 'X':
                                                    if (i5 == 1) {
                                                        mb1VarA = jb1.b;
                                                    } else if (i5 == 2) {
                                                        mb1VarA = jb1.c;
                                                    } else {
                                                        if (i5 != 3) {
                                                            jb1 jb1Var = jb1.b;
                                                            xe.k("invalid number of X");
                                                            throw null;
                                                        }
                                                        mb1VarA = jb1.d;
                                                    }
                                                    nb1 nb1Var2222222222222222222 = new nb1(mb1VarA, i5);
                                                    i3 = i4;
                                                    nb1Var = nb1Var2222222222222222222;
                                                    break;
                                                case 'Y':
                                                    break;
                                                case 'Z':
                                                    mb1VarA = i5 == 2 ? jb1.d : a(15, calendar);
                                                    nb1 nb1Var22222222222222222222 = new nb1(mb1VarA, i5);
                                                    i3 = i4;
                                                    nb1Var = nb1Var22222222222222222222;
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException("Format '" + cCharAt + "' not supported");
                                            }
                                            break;
                                    }
                                    break;
                            }
                        }
                    } while (str.charAt(i4) == cCharAt);
                    int i52 = i4 - i3;
                    if (cCharAt == 'y') {
                    }
                }
            }
            if (nb1Var == null) {
                return;
            } else {
                this.Y.add(nb1Var);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(StringBuilder sb, String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '$' || cCharAt == '.' || cCharAt == '?' || cCharAt == '^' || cCharAt == '[' || cCharAt == '\\' || cCharAt == '{' || cCharAt == '|') {
                sb.append('\\');
            } else {
                switch (cCharAt) {
                }
            }
            sb.append(cCharAt);
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.append('?');
        }
    }

    public final mb1 a(int i, Calendar calendar) {
        ConcurrentMap concurrentMap;
        ConcurrentMap[] concurrentMapArr = z0;
        synchronized (concurrentMapArr) {
            try {
                if (concurrentMapArr[i] == null) {
                    concurrentMapArr[i] = new ConcurrentHashMap(3);
                }
                concurrentMap = concurrentMapArr[i];
            } catch (Throwable th) {
                throw th;
            }
        }
        mb1 mb1Var = (mb1) concurrentMap.get(this.z);
        if (mb1Var != null) {
            return mb1Var;
        }
        Locale locale = this.z;
        mb1 pb1Var = i == 15 ? new pb1(locale) : new hb1(i, calendar, locale);
        mb1 mb1Var2 = (mb1) concurrentMap.putIfAbsent(this.z, pb1Var);
        return mb1Var2 != null ? mb1Var2 : pb1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(String str, ParsePosition parsePosition, Calendar calendar) {
        int i;
        ListIterator listIterator = this.Y.listIterator();
        while (listIterator.hasNext()) {
            nb1 nb1Var = (nb1) listIterator.next();
            if (nb1Var.a.a() && listIterator.hasNext()) {
                mb1 mb1Var = ((nb1) listIterator.next()).a;
                listIterator.previous();
                if (mb1Var.a()) {
                    i = nb1Var.b;
                }
            } else {
                i = 0;
            }
            qb1 qb1Var = this;
            String str2 = str;
            ParsePosition parsePosition2 = parsePosition;
            Calendar calendar2 = calendar;
            if (!nb1Var.a.b(qb1Var, calendar2, str2, parsePosition2, i)) {
                return false;
            }
            this = qb1Var;
            calendar = calendar2;
            str = str2;
            parsePosition = parsePosition2;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof qb1)) {
            return false;
        }
        qb1 qb1Var = (qb1) obj;
        return this.b.equals(qb1Var.b) && this.f.equals(qb1Var.f) && this.z.equals(qb1Var.z);
    }

    public final int hashCode() {
        return (((this.z.hashCode() * 13) + this.f.hashCode()) * 13) + this.b.hashCode();
    }

    public final String toString() {
        return "FastDateParser[" + this.b + "," + this.z + "," + this.f.getID() + "]";
    }
}
