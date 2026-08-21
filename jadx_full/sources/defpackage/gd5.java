package defpackage;

import io.netty.util.internal.StringUtil;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class gd5 {
    public static final char[] a;

    static {
        char[] cArr = new char[80];
        a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        c(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            hb5 hb5Var = hb5.z;
            sb.append(l72.c0(new hb5(((String) obj).getBytes(nc5.a))));
            sb.append(StringUtil.DOUBLE_QUOTE);
            return;
        }
        if (obj instanceof hb5) {
            sb.append(": \"");
            sb.append(l72.c0((hb5) obj));
            sb.append(StringUtil.DOUBLE_QUOTE);
            return;
        }
        if (obj instanceof dc5) {
            sb.append(" {");
            b((dc5) obj, sb, i + 2);
            sb.append("\n");
            c(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i3 = i + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        a(sb, i3, "key", entry.getKey());
        a(sb, i3, "value", entry.getValue());
        sb.append("\n");
        c(i, sb);
        sb.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(dc5 dc5Var, StringBuilder sb, int i) {
        int i2;
        int i3;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = dc5Var.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            i2 = 3;
            if (i4 >= length) {
                break;
            }
            Method method3 = declaredMethods[i4];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i4++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (!strSubstring.endsWith("List") || strSubstring.endsWith("OrBuilderList") || strSubstring.equals("List") || (method2 = (Method) entry.getValue()) == null) {
                i3 = i2;
            } else {
                i3 = i2;
                if (method2.getReturnType().equals(List.class)) {
                    a(sb, i, strSubstring.substring(0, strSubstring.length() - 4), dc5.l(method2, dc5Var, new Object[0]));
                }
                i2 = i3;
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                a(sb, i, strSubstring.substring(0, strSubstring.length() - 3), dc5.l(method, dc5Var, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(strSubstring.substring(0, strSubstring.length() - 5))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objL = dc5.l(method4, dc5Var, new Object[0]);
                    if (method5 == null) {
                        if (objL instanceof Boolean) {
                            if (((Boolean) objL).booleanValue()) {
                                a(sb, i, strSubstring, objL);
                            }
                        } else if (objL instanceof Integer) {
                            if (((Integer) objL).intValue() != 0) {
                            }
                        } else if (objL instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objL).floatValue()) != 0) {
                            }
                        } else if (!(objL instanceof Double)) {
                            if (objL instanceof String) {
                                zEquals = objL.equals("");
                            } else if (objL instanceof hb5) {
                                zEquals = objL.equals(hb5.z);
                            } else if (objL instanceof va5) {
                                if (objL != ((dc5) ((dc5) ((va5) objL)).m(6))) {
                                }
                            } else if (!(objL instanceof Enum) || ((Enum) objL).ordinal() != 0) {
                            }
                            if (!zEquals) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objL).doubleValue()) != 0) {
                        }
                    } else if (((Boolean) dc5.l(method5, dc5Var, new Object[0])).booleanValue()) {
                    }
                }
            }
            i2 = i3;
        }
        fe5 fe5Var = dc5Var.zzc;
        if (fe5Var != null) {
            for (int i5 = 0; i5 < fe5Var.a; i5++) {
                a(sb, i, String.valueOf(fe5Var.b[i5] >>> 3), fe5Var.c[i5]);
            }
        }
    }

    public static void c(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(a, 0, i2);
            i -= i2;
        }
    }
}
