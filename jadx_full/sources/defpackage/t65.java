package defpackage;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t65 extends k95 {
    public final q65 A0;
    public final q65 B0;
    public final q65 C0;
    public final q65 D0;
    public final q65 E0;
    public final q65 F0;
    public final q65 G0;
    public final q65 H0;
    public char Y;
    public long Z;
    public String y0;
    public final q65 z0;

    public t65(k85 k85Var) {
        super(k85Var);
        this.Y = (char) 0;
        this.Z = -1L;
        this.z0 = new q65(this, 6, false, false);
        this.A0 = new q65(this, 6, true, false);
        this.B0 = new q65(this, 6, false, true);
        this.C0 = new q65(this, 5, false, false);
        this.D0 = new q65(this, 5, true, false);
        this.E0 = new q65(this, 5, false, true);
        this.F0 = new q65(this, 4, false, false);
        this.G0 = new q65(this, 3, false, false);
        this.H0 = new q65(this, 2, false, false);
    }

    public static r65 Z0(String str) {
        if (str == null) {
            return null;
        }
        return new r65(str);
    }

    public static String c1(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String strD1 = d1(obj, z);
        String strD12 = d1(obj2, z);
        String strD13 = d1(obj3, z);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strD1)) {
            sb.append(str2);
            sb.append(strD1);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strD12)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strD12);
        }
        if (!TextUtils.isEmpty(strD13)) {
            sb.append(str3);
            sb.append(strD13);
        }
        return sb.toString();
    }

    public static String d1(Object obj, boolean z) {
        int iLastIndexOf;
        String className;
        int iLastIndexOf2;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            char cCharAt = obj.toString().charAt(0);
            String strValueOf = String.valueOf(Math.abs(l.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            int length = String.valueOf(jRound).length();
            String str = cCharAt == '-' ? "-" : "";
            StringBuilder sb = new StringBuilder(str.length() + str.length() + length + 3 + String.valueOf(jRound2).length());
            sb.append(str);
            sb.append(jRound);
            sb.append("...");
            sb.append(str);
            sb.append(jRound2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof r65 ? ((r65) obj).a : z ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String canonicalName = k85.class.getCanonicalName();
        String strSubstring = (TextUtils.isEmpty(canonicalName) || (iLastIndexOf = canonicalName.lastIndexOf(46)) == -1) ? "" : canonicalName.substring(0, iLastIndexOf);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length2 = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length2) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                if (((TextUtils.isEmpty(className) || (iLastIndexOf2 = className.lastIndexOf(46)) == -1) ? "" : className.substring(0, iLastIndexOf2)).equals(strSubstring)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
            }
            i++;
        }
        return sb2.toString();
    }

    @Override // defpackage.k95
    public final boolean W0() {
        return false;
    }

    public final void a1(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(b1(), i)) {
            Log.println(i, b1(), c1(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        tj4.i(str);
        f85 f85Var = ((k85) this.f).Z;
        if (f85Var == null) {
            Log.println(6, b1(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!f85Var.X) {
                Log.println(6, b1(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i >= 9) {
                i = 8;
            }
            f85Var.e1(new o65(this, i, str, obj, obj2, obj3));
        }
    }

    public final String b1() {
        String str;
        synchronized (this) {
            try {
                str = this.y0;
                if (str == null) {
                    ((k85) ((k85) this.f).A.f).getClass();
                    str = "FA";
                    this.y0 = "FA";
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
