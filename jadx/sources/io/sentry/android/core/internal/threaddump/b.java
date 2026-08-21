package io.sentry.android.core.internal.threaddump;

import io.sentry.n2;
import io.sentry.p6;
import io.sentry.protocol.e0;
import io.sentry.q5;
import io.sentry.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final Pattern h = Pattern.compile("\"(.*)\" (.*) ?prio=(\\d+)\\s+tid=(\\d+)\\s*(.*)");
    public static final Pattern i = Pattern.compile("\"(.*)\" (.*) ?sysTid=(\\d+)");
    public static final Pattern j = Pattern.compile("----- pid (\\d+) at .*");
    public static final Pattern k = Pattern.compile("\\s*\\|\\s*sysTid=(\\d+).*");
    public static final Pattern l = Pattern.compile(" *(?:native: )?#(\\d+) \\S+ ([0-9a-fA-F]+)\\s+((.*?)(?:\\s+\\(deleted\\))?(?:\\s+\\(offset (.*?)\\))?)(?:\\s+\\((?:\\?\\?\\?|(.*?)(?:\\+(\\d+))?)\\))?(?:\\s+\\(BuildId: (.*?)\\))?");
    public static final Pattern m = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\((.*):([\\d-]+)\\)");
    public static final Pattern n = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\(Native method\\)");
    public static final Pattern o = Pattern.compile(" *- locked \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    public static final Pattern p = Pattern.compile(" *- sleeping on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    public static final Pattern q = Pattern.compile(" *- waiting on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    public static final Pattern r = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    public static final Pattern s = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)(?: held by thread (\\d+))");
    public static final Pattern t = Pattern.compile(" *- waiting to lock an unknown object");
    public static final Pattern u = Pattern.compile("\\s+");
    public final p6 a;
    public final boolean b;
    public Long c;
    public final w d;
    public final n2 g = new n2(1);
    public final HashMap e = new HashMap();
    public final ArrayList f = new ArrayList();

    public b(p6 p6Var, boolean z) {
        this.a = p6Var;
        this.b = z;
        this.d = new w(p6Var);
    }

    public static void a(e0 e0Var, q5 q5Var) {
        Map map = e0Var.A0;
        if (map == null) {
            map = new HashMap();
        }
        q5 q5Var2 = (q5) map.get(q5Var.f);
        if (q5Var2 != null) {
            q5Var2.b = Math.max(q5Var2.b, q5Var.b);
        } else {
            String str = q5Var.f;
            q5 q5Var3 = new q5();
            q5Var3.b = q5Var.b;
            q5Var3.f = str;
            q5Var3.z = q5Var.z;
            q5Var3.A = q5Var.A;
            q5Var3.X = q5Var.X;
            q5Var3.Y = io.sentry.util.b.o(q5Var.Y);
            map.put(str, q5Var3);
        }
        e0Var.A0 = map;
    }

    public static Long b(Matcher matcher, int i2) {
        String strGroup = matcher.group(i2);
        if (strGroup == null || strGroup.length() == 0) {
            return null;
        }
        return Long.valueOf(Long.parseLong(strGroup));
    }

    public static boolean c(Matcher matcher, String str) {
        matcher.reset(str);
        return matcher.matches();
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x05a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02d9 A[EDGE_INSN: B:207:0x02d9->B:94:0x02d9 BREAK  A[LOOP:1: B:89:0x02c3->B:175:0x0575], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d8 A[PHI: r21 r23 r25 r26 r28 r31 r34
      0x01d8: PHI (r21v2 java.util.regex.Matcher) = (r21v3 java.util.regex.Matcher), (r21v4 java.util.regex.Matcher) binds: [B:63:0x01d2, B:177:0x0597] A[DONT_GENERATE, DONT_INLINE]
      0x01d8: PHI (r23v2 java.util.regex.Pattern) = (r23v3 java.util.regex.Pattern), (r23v4 java.util.regex.Pattern) binds: [B:63:0x01d2, B:177:0x0597] A[DONT_GENERATE, DONT_INLINE]
      0x01d8: PHI (r25v1 java.util.regex.Matcher) = (r25v2 java.util.regex.Matcher), (r25v3 java.util.regex.Matcher) binds: [B:63:0x01d2, B:177:0x0597] A[DONT_GENERATE, DONT_INLINE]
      0x01d8: PHI (r26v1 java.util.regex.Matcher) = (r26v2 java.util.regex.Matcher), (r26v3 java.util.regex.Matcher) binds: [B:63:0x01d2, B:177:0x0597] A[DONT_GENERATE, DONT_INLINE]
      0x01d8: PHI (r28v1 java.util.ArrayList) = (r28v2 java.util.ArrayList), (r28v3 java.util.ArrayList) binds: [B:63:0x01d2, B:177:0x0597] A[DONT_GENERATE, DONT_INLINE]
      0x01d8: PHI (r31v2 java.lang.String) = (r31v3 java.lang.String), (r31v4 java.lang.String) binds: [B:63:0x01d2, B:177:0x0597] A[DONT_GENERATE, DONT_INLINE]
      0x01d8: PHI (r34v2 int) = (r34v3 int), (r34v5 int) binds: [B:63:0x01d2, B:177:0x0597] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(defpackage.sb0 r37) {
        /*
            Method dump skipped, instruction units count: 1518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.threaddump.b.d(sb0):void");
    }
}
