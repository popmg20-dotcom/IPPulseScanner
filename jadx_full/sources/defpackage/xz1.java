package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xz1 implements Serializable {
    public static final Pattern b = Pattern.compile("\\d{1,3}");
    public static final Pattern f = Pattern.compile("[^\\s/%]+");
    public static final ma0 z = new ma0("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");

    public static boolean a(String str) {
        return b(str) || c(str);
    }

    public static boolean b(String str) {
        String[] strArrA = z.a(str);
        if (strArrA != null) {
            for (String str2 : strArrA) {
                if (!q83.a(str2)) {
                    try {
                        if (Integer.parseInt(str2) <= 255 && (str2.length() <= 1 || !str2.startsWith("0"))) {
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        String str2;
        boolean zContains;
        int i;
        String[] strArrSplit = str.split("/", -1);
        if (strArrSplit.length <= 2 && (strArrSplit.length != 2 || (b.matcher(strArrSplit[1]).matches() && (i = Integer.parseInt(strArrSplit[1])) >= 0 && i <= 128))) {
            String[] strArrSplit2 = strArrSplit[0].split("%", -1);
            if (strArrSplit2.length <= 2 && ((strArrSplit2.length != 2 || f.matcher(strArrSplit2[1]).matches()) && (!(zContains = (str2 = strArrSplit2[0]).contains("::")) || str2.indexOf("::") == str2.lastIndexOf("::")))) {
                boolean zStartsWith = str2.startsWith("::");
                boolean zEndsWith = str2.endsWith("::");
                boolean zEndsWith2 = str2.endsWith(":");
                if ((!str2.startsWith(":") || zStartsWith) && (!zEndsWith2 || zEndsWith)) {
                    String[] strArrSplit3 = str2.split(":");
                    if (zContains) {
                        ArrayList arrayList = new ArrayList(Arrays.asList(strArrSplit3));
                        if (zEndsWith) {
                            arrayList.add("");
                        } else if (zStartsWith && !arrayList.isEmpty()) {
                            arrayList.remove(0);
                        }
                        strArrSplit3 = (String[]) arrayList.toArray(new String[0]);
                    }
                    if (strArrSplit3.length <= 8) {
                        int i2 = 0;
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            if (i2 >= strArrSplit3.length) {
                                if (i3 > 8 || (i3 < 8 && !zContains)) {
                                    break;
                                }
                                return true;
                            }
                            String str3 = strArrSplit3[i2];
                            if (q83.a(str3)) {
                                i4++;
                                if (i4 > 1) {
                                    break;
                                }
                                i3++;
                            } else if (i2 == strArrSplit3.length - 1 && str3.contains(".")) {
                                if (!b(str3)) {
                                    break;
                                }
                                i3 += 2;
                                i4 = 0;
                            } else {
                                if (str3.length() > 4) {
                                    break;
                                }
                                try {
                                    int i5 = Integer.parseInt(str3, 16);
                                    if (i5 < 0 || i5 > 65535) {
                                        break;
                                    }
                                    i4 = 0;
                                    i3++;
                                } catch (NumberFormatException unused) {
                                    return false;
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
        }
        return false;
    }
}
