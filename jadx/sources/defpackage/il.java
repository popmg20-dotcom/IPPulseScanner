package defpackage;

import j$.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class il {
    public static final Pattern b = Pattern.compile("^$");
    public static final Pattern c = Pattern.compile("^\\$\\{\\s*(?:(\\w+)(?:(:?[-?])(\\w+)?)?)\\s*\\}$");
    public HashMap a;

    public final void a(oa4 oa4Var, Pattern pattern, String str) {
        HashMap map = this.a;
        int i = 0;
        if (str == null) {
            ((List) Map.EL.computeIfAbsent(map, null, new hl(i))).add(new yj3(oa4Var, pattern));
            return;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        while (i < length) {
            char c2 = charArray[i];
            Character chValueOf = Character.valueOf(c2);
            if (c2 == 0) {
                chValueOf = null;
            }
            List arrayList = (List) map.get(chValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(chValueOf, arrayList);
            }
            arrayList.add(new yj3(oa4Var, pattern));
            i++;
        }
    }

    public final oa4 b(String str, Boolean bool) {
        HashMap map = this.a;
        if (!bool.booleanValue()) {
            return oa4.i;
        }
        List<yj3> list = str.isEmpty() ? (List) map.get((char) 0) : (List) map.get(Character.valueOf(str.charAt(0)));
        if (list != null) {
            for (yj3 yj3Var : list) {
                oa4 oa4Var = yj3Var.a;
                if (yj3Var.b.matcher(str).matches()) {
                    return oa4Var;
                }
            }
        }
        if (map.containsKey(null)) {
            for (yj3 yj3Var2 : (List) map.get(null)) {
                oa4 oa4Var2 = yj3Var2.a;
                if (yj3Var2.b.matcher(str).matches()) {
                    return oa4Var2;
                }
            }
        }
        return oa4.i;
    }
}
