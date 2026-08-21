package defpackage;

import android.os.Build;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class em {
    public static final am d = new am(0, 0);
    public static final Pattern e = Pattern.compile("\\b(comment|string|regex|meta\\.embedded)\\b");
    public final am a;
    public final dm b;
    public final ConcurrentHashMap c = new ConcurrentHashMap();

    public em(int i, Map map) {
        this.a = new am(i, 8);
        this.b = new dm(map == null ? Collections.EMPTY_MAP : map);
    }

    public static int b(String str) {
        String strGroup;
        Matcher matcher = e.matcher(str);
        if (!matcher.find()) {
            return 8;
        }
        strGroup = matcher.group(1);
        strGroup.getClass();
        switch (strGroup) {
            case "string":
                return 2;
            case "regex":
                return 3;
            case "comment":
                return 1;
            case "meta.embedded":
                return 0;
            default:
                throw new r94("Unexpected match for standard token type: ".concat(strGroup));
        }
    }

    public final int a(String str) {
        dm dmVar = this.b;
        Pattern pattern = (Pattern) dmVar.b;
        Object obj = null;
        if (pattern != null) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                obj = ((Map) dmVar.a).get(matcher.group(1));
            }
        }
        Integer num = (Integer) obj;
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    public final am c(String str) {
        if (str == null) {
            return d;
        }
        int i = Build.VERSION.SDK_INT;
        ConcurrentHashMap concurrentHashMap = this.c;
        if (i >= 24) {
            return (am) ConcurrentMap.EL.computeIfAbsent(concurrentHashMap, str, new bm(0, this, str));
        }
        am amVar = (am) concurrentHashMap.get(str);
        if (amVar != null) {
            return amVar;
        }
        am amVar2 = new am(a(str), b(str));
        concurrentHashMap.put(str, amVar2);
        return amVar2;
    }
}
