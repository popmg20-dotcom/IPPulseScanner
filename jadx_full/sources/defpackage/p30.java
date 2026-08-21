package defpackage;

import io.netty.util.internal.StringUtil;
import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class p30 {
    public static final p30 b = new p30("\n");
    public static final p30 c = new p30("\u0000\r\n");
    public static final p30 d = new p30(" \u0000\r\n");
    public static final p30 e = new p30("\t \u0000\r\n");
    public static final p30 f;
    public static final p30 g;
    public static final p30 h;
    public static final Map i;
    public static final Map j;
    public final boolean[] a;

    static {
        new p30("\u0000 \t");
        f = new p30("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$_.!~*'()%,[]");
        g = new p30("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$_.!~*'()%");
        h = new p30("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_");
        HashMap map = new HashMap();
        map.put('0', WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR);
        map.put('a', "\u0007");
        map.put('b', "\b");
        map.put('t', "\t");
        map.put('n', "\n");
        map.put('v', "\u000b");
        map.put('f', "\f");
        map.put('r', "\r");
        map.put('e', "\u001b");
        map.put(' ', " ");
        map.put(Character.valueOf(StringUtil.DOUBLE_QUOTE), "\"");
        map.put('/', "/");
        map.put('\\', "\\");
        map.put('N', "\u0085");
        map.put('_', " ");
        i = DesugarCollections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put('x', 2);
        map2.put('u', 4);
        map2.put('U', 8);
        j = DesugarCollections.unmodifiableMap(map2);
    }

    public p30(String str) {
        boolean[] zArr = new boolean[128];
        this.a = zArr;
        Arrays.fill(zArr, false);
        for (int i2 = 0; i2 < str.length(); i2++) {
            this.a[str.codePointAt(i2)] = true;
        }
    }

    public static String a(String str) {
        Map map = i;
        for (Character ch : map.keySet()) {
            String str2 = (String) map.get(ch);
            if (!" ".equals(str2) && !"/".equals(str2) && !"\"".equals(str2) && str2.equals(str)) {
                return "\\" + ch;
            }
        }
        return str;
    }

    public final boolean b(int i2) {
        return i2 < 128 && this.a[i2];
    }

    public final boolean c(int i2) {
        return !b(i2);
    }
}
