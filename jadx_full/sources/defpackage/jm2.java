package defpackage;

import io.netty.util.internal.StringUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jm2 {
    public static final ExecutorService c = Executors.newSingleThreadExecutor();
    public final yd3 a;
    public final LinkedHashMap b = new LinkedHashMap();

    public jm2(yd3 yd3Var) {
        this.a = yd3Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x027c, code lost:
    
        r0 = new defpackage.w9(r3);
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0284, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(InputStream inputStream) {
        String str;
        String str2 = "//";
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            try {
                a02 a02Var = new a02("");
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        try {
                            bufferedReader2.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    String strTrim = line.trim();
                    if (ke0.F(strTrim, '#') || ke0.F(strTrim, ';') || strTrim.startsWith(str2)) {
                        str = str2;
                        str2 = str;
                    } else {
                        if (!ke0.F(strTrim, '[') || strTrim.indexOf(93) == -1 || (!ke0.f(strTrim.trim(), ']') && ((!strTrim.contains(str2) || !ke0.f(strTrim.split(str2)[0].trim(), ']')) && ((strTrim.indexOf(59) == -1 || !ke0.f(((String) ke0.D(strTrim, ';').get(0)).trim(), ']')) && (strTrim.indexOf(35) == -1 || !ke0.f(((String) ke0.D(strTrim, '#').get(0)).trim(), ']')))))) {
                            if (strTrim.indexOf(61) != -1) {
                                String strTrim2 = ((String) ke0.D(strTrim, '=').get(0)).trim();
                                if (!(strTrim2.indexOf(44) != -1) || (ke0.F(strTrim2, StringUtil.DOUBLE_QUOTE) && ke0.f(strTrim2, StringUtil.DOUBLE_QUOTE))) {
                                    int iIndexOf = strTrim.indexOf(61);
                                    if (iIndexOf <= 0) {
                                        break;
                                    }
                                    String strTrim3 = strTrim.substring(0, iIndexOf).trim();
                                    List listD = ke0.D(strTrim.substring(iIndexOf + 1), StringUtil.COMMA);
                                    StringBuilder sb = new StringBuilder();
                                    ArrayList arrayList = new ArrayList();
                                    int i = 0;
                                    boolean z = false;
                                    while (true) {
                                        if (i >= listD.size()) {
                                            str = str2;
                                            break;
                                        }
                                        String str3 = (String) listD.get(i);
                                        int i2 = 0;
                                        int i3 = 0;
                                        while (i2 < str3.length()) {
                                            String str4 = str2;
                                            if (str3.charAt(i2) == '\"') {
                                                i3++;
                                            }
                                            i2++;
                                            str2 = str4;
                                        }
                                        str = str2;
                                        int i4 = i3;
                                        if (i4 == 1) {
                                            if (sb.length() == 0) {
                                                sb.append(str3);
                                                arrayList.add(Integer.valueOf(i));
                                            } else if (str3.trim().endsWith("\"")) {
                                                sb.append(",");
                                                sb.append(str3);
                                                arrayList.add(Integer.valueOf(i));
                                                z = true;
                                            }
                                        } else if (i4 == 0 && sb.length() > 0) {
                                            sb.append(",");
                                            sb.append(str3);
                                            arrayList.add(Integer.valueOf(i));
                                        }
                                        if (z) {
                                            break;
                                        }
                                        i++;
                                        str2 = str;
                                    }
                                    if (z) {
                                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                                            int iIntValue = ((Integer) arrayList.get(size)).intValue();
                                            listD.remove(iIntValue);
                                            if (size == 0) {
                                                listD.add(iIntValue, sb.toString());
                                            }
                                        }
                                    }
                                    ArrayList arrayList2 = new ArrayList();
                                    int i5 = 0;
                                    while (i5 < listD.size()) {
                                        if (i5 == listD.size() - 1) {
                                            String str5 = (String) listD.get(i5);
                                            int iIndexOf2 = str5.indexOf(" //");
                                            if (iIndexOf2 == -1) {
                                                iIndexOf2 = str5.indexOf(" #");
                                            }
                                            if (iIndexOf2 == -1) {
                                                iIndexOf2 = str5.indexOf(" ;");
                                            }
                                            if (iIndexOf2 != -1) {
                                                arrayList2.add(str5.substring(0, iIndexOf2).trim());
                                            } else {
                                                arrayList2.add(str5);
                                            }
                                        } else {
                                            String strTrim4 = ((String) listD.get(i5)).trim();
                                            int i6 = i5 + 1;
                                            String strTrim5 = ((String) listD.get(i6)).trim();
                                            if (!ke0.F(strTrim4, StringUtil.DOUBLE_QUOTE) || ke0.F(strTrim4, StringUtil.DOUBLE_QUOTE) || ke0.F(strTrim5, StringUtil.DOUBLE_QUOTE) || !ke0.f(strTrim5, StringUtil.DOUBLE_QUOTE)) {
                                                arrayList2.add(strTrim4);
                                            } else {
                                                arrayList2.add(((String) listD.get(i5)) + "," + ((String) listD.get(i6)));
                                                i5 = i6;
                                            }
                                        }
                                        i5++;
                                    }
                                    a02Var.a(strTrim3, (String[]) arrayList2.toArray(new String[0]));
                                } else {
                                    str = str2;
                                    if (strTrim.indexOf(44) != -1) {
                                        List listD2 = ke0.D(strTrim, StringUtil.COMMA);
                                        String str6 = (String) listD2.get(listD2.size() - 1);
                                        int iIndexOf3 = str6.indexOf(" //");
                                        if (iIndexOf3 == -1) {
                                            iIndexOf3 = str6.indexOf(" #");
                                        }
                                        if (iIndexOf3 == -1) {
                                            iIndexOf3 = str6.indexOf(" ;");
                                        }
                                        if (iIndexOf3 != -1) {
                                            listD2.set(listD2.size() - 1, str6.substring(0, iIndexOf3).trim());
                                        }
                                        a02Var.a(strTrim, (String[]) listD2.toArray(new String[0]));
                                    }
                                }
                                str2 = str;
                            }
                        }
                        a02 a02Var2 = new a02(strTrim.substring(1, strTrim.indexOf(93)));
                        this.b.put(a02Var2.a, a02Var2);
                        a02Var = a02Var2;
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
