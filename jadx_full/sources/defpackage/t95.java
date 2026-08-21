package defpackage;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t95 {
    public static final t95 c = new t95(100);
    public final EnumMap a;
    public final int b;

    public t95(int i) {
        EnumMap enumMap = new EnumMap(r95.class);
        this.a = enumMap;
        r95 r95Var = r95.AD_STORAGE;
        o95 o95Var = o95.UNINITIALIZED;
        enumMap.put(r95Var, o95Var);
        enumMap.put(r95.ANALYTICS_STORAGE, o95Var);
        this.b = i;
    }

    public static String a(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static t95 b(int i, Bundle bundle) {
        if (bundle == null) {
            return new t95(i);
        }
        EnumMap enumMap = new EnumMap(r95.class);
        for (r95 r95Var : q95.STORAGE.b) {
            enumMap.put(r95Var, d(bundle.getString(r95Var.b)));
        }
        return new t95(enumMap, i);
    }

    public static t95 c(int i, String str) {
        EnumMap enumMap = new EnumMap(r95.class);
        r95[] r95VarArr = q95.STORAGE.b;
        for (int i2 = 0; i2 < r95VarArr.length; i2++) {
            String str2 = str == null ? "" : str;
            r95 r95Var = r95VarArr[i2];
            int i3 = i2 + 2;
            if (i3 < str2.length()) {
                enumMap.put(r95Var, e(str2.charAt(i3)));
            } else {
                enumMap.put(r95Var, o95.UNINITIALIZED);
            }
        }
        return new t95(enumMap, i);
    }

    public static o95 d(String str) {
        o95 o95Var = o95.UNINITIALIZED;
        return str == null ? o95Var : str.equals("granted") ? o95.GRANTED : str.equals("denied") ? o95.DENIED : o95Var;
    }

    public static o95 e(char c2) {
        return c2 != '+' ? c2 != '0' ? c2 != '1' ? o95.UNINITIALIZED : o95.GRANTED : o95.DENIED : o95.POLICY;
    }

    public static char h(o95 o95Var) {
        if (o95Var == null) {
            return '-';
        }
        int iOrdinal = o95Var.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static boolean l(int i, int i2) {
        int i3 = -30;
        if (i == -20) {
            if (i2 == -30) {
                return true;
            }
            i = -20;
        }
        if (i != -30) {
            i3 = i;
        } else if (i2 == -20) {
            return true;
        }
        return i3 == i2 || i < i2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof t95) {
            t95 t95Var = (t95) obj;
            r95[] r95VarArr = q95.STORAGE.b;
            int length = r95VarArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    r95 r95Var = r95VarArr[i];
                    if (this.a.get(r95Var) != t95Var.a.get(r95Var)) {
                        break;
                    }
                    i++;
                } else if (this.b == t95Var.b) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String f() {
        int iOrdinal;
        StringBuilder sb = new StringBuilder("G1");
        for (r95 r95Var : q95.STORAGE.b) {
            o95 o95Var = (o95) this.a.get(r95Var);
            char c2 = '-';
            if (o95Var != null && (iOrdinal = o95Var.ordinal()) != 0) {
                if (iOrdinal == 1) {
                    c2 = '1';
                } else if (iOrdinal == 2) {
                    c2 = '0';
                } else if (iOrdinal != 3) {
                }
            }
            sb.append(c2);
        }
        return sb.toString();
    }

    public final String g() {
        StringBuilder sb = new StringBuilder("G1");
        for (r95 r95Var : q95.STORAGE.b) {
            sb.append(h((o95) this.a.get(r95Var)));
        }
        return sb.toString();
    }

    public final int hashCode() {
        Iterator it = this.a.values().iterator();
        int iHashCode = this.b * 17;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((o95) it.next()).hashCode();
        }
        return iHashCode;
    }

    public final boolean i(r95 r95Var) {
        return ((o95) this.a.get(r95Var)) != o95.DENIED;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final t95 j(t95 t95Var) {
        EnumMap enumMap = new EnumMap(r95.class);
        for (r95 r95Var : q95.STORAGE.b) {
            o95 o95Var = (o95) this.a.get(r95Var);
            o95 o95Var2 = (o95) t95Var.a.get(r95Var);
            if (o95Var != null) {
                if (o95Var2 != null) {
                    o95 o95Var3 = o95.UNINITIALIZED;
                    if (o95Var != o95Var3) {
                        if (o95Var2 != o95Var3) {
                            o95 o95Var4 = o95.POLICY;
                            if (o95Var == o95Var4) {
                                o95Var = o95Var2;
                            } else if (o95Var2 != o95Var4) {
                                o95 o95Var5 = o95.DENIED;
                                o95Var = (o95Var == o95Var5 || o95Var2 == o95Var5) ? o95Var5 : o95.GRANTED;
                            }
                        }
                    }
                }
            }
            if (o95Var != null) {
                enumMap.put(r95Var, o95Var);
            }
        }
        return new t95(enumMap, 100);
    }

    public final t95 k(t95 t95Var) {
        EnumMap enumMap = new EnumMap(r95.class);
        for (r95 r95Var : q95.STORAGE.b) {
            o95 o95Var = (o95) this.a.get(r95Var);
            if (o95Var == o95.UNINITIALIZED) {
                o95Var = (o95) t95Var.a.get(r95Var);
            }
            if (o95Var != null) {
                enumMap.put(r95Var, o95Var);
            }
        }
        return new t95(enumMap, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(a(this.b));
        for (r95 r95Var : q95.STORAGE.b) {
            sb.append(",");
            sb.append(r95Var.b);
            sb.append("=");
            o95 o95Var = (o95) this.a.get(r95Var);
            if (o95Var == null) {
                o95Var = o95.UNINITIALIZED;
            }
            sb.append(o95Var);
        }
        return sb.toString();
    }

    public t95(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(r95.class);
        this.a = enumMap2;
        enumMap2.putAll(enumMap);
        this.b = i;
    }
}
