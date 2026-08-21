package io.sentry.android.core.internal.threaddump;

import defpackage.sb0;
import io.sentry.n2;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.a0;
import io.sentry.protocol.c;
import io.sentry.protocol.c0;
import io.sentry.protocol.e0;
import io.sentry.q5;
import io.sentry.w;
import java.util.ArrayList;
import java.util.Collections;
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
    */
    public final void d(sb0 sb0Var) {
        Pattern pattern;
        int i2;
        String str;
        Matcher matcher;
        Pattern pattern2;
        ArrayList arrayList;
        Matcher matcher2;
        Matcher matcher3;
        ArrayList arrayList2;
        Matcher matcher4;
        Matcher matcher5;
        Matcher matcher6;
        Matcher matcher7;
        Matcher matcher8;
        Matcher matcher9;
        Matcher matcher10;
        String str2;
        Matcher matcher11;
        Matcher matcher12;
        Matcher matcher13;
        Integer numValueOf;
        sb0 sb0Var2 = sb0Var;
        int i3 = sb0Var2.b;
        Pattern pattern3 = h;
        String str3 = "";
        Matcher matcher14 = pattern3.matcher("");
        Pattern pattern4 = i;
        Matcher matcher15 = pattern4.matcher("");
        Matcher matcher16 = j.matcher("");
        while (true) {
            int i4 = sb0Var2.c;
            ArrayList<e0> arrayList3 = this.f;
            if (i4 >= i3) {
                for (e0 e0Var : arrayList3) {
                    Boolean bool = Boolean.TRUE;
                    if (bool.equals(e0Var.y0)) {
                        e0Var.z = "main";
                        e0Var.X = bool;
                        e0Var.Y = Boolean.valueOf(!this.b);
                    } else {
                        Boolean bool2 = Boolean.FALSE;
                        e0Var.X = bool2;
                        e0Var.Y = bool2;
                        e0Var.y0 = bool2;
                    }
                }
                return;
            }
            a aVarA = sb0Var2.a();
            String str4 = "Internal error while parsing thread dump.";
            p6 p6Var = this.a;
            if (aVarA == null) {
                p6Var.getLogger().h(p5.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                return;
            }
            String str5 = aVarA.a;
            Long lValueOf = null;
            if (c(matcher14, str5) || c(matcher15, str5)) {
                sb0Var2.c--;
                e0 e0Var2 = new e0();
                Matcher matcher17 = pattern3.matcher(str3);
                Matcher matcher18 = pattern4.matcher(str3);
                pattern = pattern3;
                if (sb0Var2.c >= i3) {
                    i2 = i3;
                    str = str3;
                    matcher = matcher14;
                    pattern2 = pattern4;
                    matcher3 = matcher15;
                    matcher2 = matcher16;
                    arrayList = arrayList3;
                    e0Var2 = null;
                    if (e0Var2 == null) {
                        arrayList.add(e0Var2);
                    }
                } else {
                    a aVarA2 = sb0Var2.a();
                    if (aVarA2 == null) {
                        p6Var.getLogger().h(p5.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                        i2 = i3;
                        str = str3;
                        matcher = matcher14;
                        pattern2 = pattern4;
                        matcher3 = matcher15;
                        matcher2 = matcher16;
                        arrayList = arrayList3;
                        e0Var2 = null;
                        if (e0Var2 == null) {
                        }
                    } else {
                        String str6 = aVarA2.a;
                        matcher = matcher14;
                        pattern2 = pattern4;
                        if (c(matcher17, str6)) {
                            Long lB = b(matcher17, 4);
                            if (lB == null) {
                                p6Var.getLogger().h(p5.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                                i2 = i3;
                                str = str3;
                                matcher3 = matcher15;
                                matcher2 = matcher16;
                                arrayList = arrayList3;
                                e0Var2 = null;
                                if (e0Var2 == null) {
                                }
                            } else {
                                e0Var2.b = lB;
                                String strGroup = matcher17.group(1);
                                e0Var2.z = strGroup;
                                if ("main".equals(strGroup)) {
                                    e0Var2.y0 = Boolean.TRUE;
                                }
                                String strGroup2 = matcher17.group(5);
                                if (strGroup2 != null) {
                                    if (strGroup2.contains(" ")) {
                                        e0Var2.A = strGroup2.substring(0, strGroup2.indexOf(32));
                                    } else {
                                        e0Var2.A = strGroup2;
                                    }
                                }
                                p6 p6Var2 = this.d.b;
                                arrayList2 = new ArrayList();
                                Matcher matcher19 = l.matcher(str3);
                                matcher4 = m.matcher(str3);
                                Matcher matcher20 = n.matcher(str3);
                                Matcher matcher21 = o.matcher(str3);
                                Matcher matcher22 = q.matcher(str3);
                                matcher3 = matcher15;
                                Matcher matcher23 = p.matcher(str3);
                                matcher2 = matcher16;
                                Matcher matcher24 = s.matcher(str3);
                                Matcher matcher25 = r.matcher(str3);
                                arrayList = arrayList3;
                                matcher5 = t.matcher(str3);
                                matcher6 = u.matcher(str3);
                                matcher7 = k.matcher(str3);
                                str = str3;
                                matcher8 = matcher25;
                                a0 a0Var = null;
                                while (true) {
                                    if (sb0Var2.c >= i3) {
                                        break;
                                    }
                                    a aVarA3 = sb0Var2.a();
                                    if (aVarA3 == null) {
                                        p6Var.getLogger().h(p5.WARNING, str4, new Object[0]);
                                        break;
                                    }
                                    String str7 = aVarA3.a;
                                    if (c(matcher7, str7)) {
                                        Long lB2 = b(matcher7, 1);
                                        if (lB2 != null && lB2.equals(this.c)) {
                                            e0Var2.y0 = Boolean.TRUE;
                                        }
                                        i2 = i3;
                                        matcher9 = matcher7;
                                    } else {
                                        i2 = i3;
                                        if (c(matcher4, str7)) {
                                            a0Var = new a0();
                                            matcher9 = matcher7;
                                            String str8 = matcher4.group(1) + "." + matcher4.group(2);
                                            a0Var.Y = str8;
                                            a0Var.X = matcher4.group(3);
                                            a0Var.A = matcher4.group(4);
                                            String strGroup3 = matcher4.group(5);
                                            if (strGroup3 == null || strGroup3.length() == 0) {
                                                numValueOf = null;
                                                a0Var.Z = numValueOf;
                                                a0Var.B0 = w.c(str8, p6Var2.getInAppIncludes(), p6Var2.getInAppExcludes());
                                                arrayList2.add(a0Var);
                                            } else {
                                                int i5 = Integer.parseInt(strGroup3);
                                                numValueOf = Integer.valueOf(i5);
                                                if (i5 < 0) {
                                                }
                                                a0Var.Z = numValueOf;
                                                a0Var.B0 = w.c(str8, p6Var2.getInAppIncludes(), p6Var2.getInAppExcludes());
                                                arrayList2.add(a0Var);
                                            }
                                            matcher8 = matcher11;
                                            matcher6 = matcher13;
                                            matcher5 = matcher12;
                                            matcher4 = matcher10;
                                            matcher7 = matcher9;
                                            i3 = i2;
                                            str4 = str2;
                                            sb0Var2 = sb0Var;
                                        } else {
                                            matcher9 = matcher7;
                                            if (c(matcher19, str7)) {
                                                a0 a0Var2 = new a0();
                                                a0Var2.C0 = matcher19.group(3);
                                                a0Var2.X = matcher19.group(6);
                                                String strGroup4 = matcher19.group(7);
                                                a0Var2.Z = (strGroup4 == null || strGroup4.length() == 0) ? null : Integer.valueOf(Integer.parseInt(strGroup4));
                                                a0Var2.H0 = "0x" + matcher19.group(2);
                                                a0Var2.E0 = "native";
                                                String strGroup5 = matcher19.group(8);
                                                String strA = strGroup5 == null ? null : io.sentry.config.a.a(strGroup5);
                                                if (strA != null) {
                                                    HashMap map = this.e;
                                                    if (map.containsKey(strA)) {
                                                        matcher10 = matcher4;
                                                        str2 = str4;
                                                    } else {
                                                        DebugImage debugImage = new DebugImage();
                                                        debugImage.setDebugId(strA);
                                                        matcher10 = matcher4;
                                                        debugImage.setType("elf");
                                                        str2 = str4;
                                                        debugImage.setCodeFile(matcher19.group(4));
                                                        debugImage.setCodeId(strGroup5);
                                                        map.put(strA, debugImage);
                                                    }
                                                    a0Var2.I0 = "rel:".concat(strA);
                                                } else {
                                                    matcher10 = matcher4;
                                                    str2 = str4;
                                                }
                                                arrayList2.add(a0Var2);
                                                a0Var = null;
                                            } else {
                                                matcher10 = matcher4;
                                                str2 = str4;
                                                if (c(matcher20, str7)) {
                                                    a0Var = new a0();
                                                    String str9 = matcher20.group(1) + "." + matcher20.group(2);
                                                    a0Var.Y = str9;
                                                    a0Var.X = matcher20.group(3);
                                                    a0Var.B0 = w.c(str9, p6Var2.getInAppIncludes(), p6Var2.getInAppExcludes());
                                                    a0Var.D0 = Boolean.TRUE;
                                                    arrayList2.add(a0Var);
                                                } else if (c(matcher21, str7)) {
                                                    if (a0Var != null) {
                                                        q5 q5Var = new q5();
                                                        q5Var.b = 1;
                                                        q5Var.f = matcher21.group(1);
                                                        q5Var.z = matcher21.group(2);
                                                        q5Var.A = matcher21.group(3);
                                                        a0Var.M0 = q5Var;
                                                        a(e0Var2, q5Var);
                                                    }
                                                } else if (c(matcher22, str7)) {
                                                    if (a0Var != null) {
                                                        q5 q5Var2 = new q5();
                                                        q5Var2.b = 2;
                                                        q5Var2.f = matcher22.group(1);
                                                        q5Var2.z = matcher22.group(2);
                                                        q5Var2.A = matcher22.group(3);
                                                        a0Var.M0 = q5Var2;
                                                        a(e0Var2, q5Var2);
                                                    }
                                                } else if (!c(matcher23, str7)) {
                                                    if (c(matcher24, str7)) {
                                                        if (a0Var != null) {
                                                            q5 q5Var3 = new q5();
                                                            q5Var3.b = 8;
                                                            q5Var3.f = matcher24.group(1);
                                                            q5Var3.z = matcher24.group(2);
                                                            q5Var3.A = matcher24.group(3);
                                                            q5Var3.X = b(matcher24, 4);
                                                            a0Var.M0 = q5Var3;
                                                            a(e0Var2, q5Var3);
                                                        }
                                                        matcher12 = matcher5;
                                                        matcher13 = matcher6;
                                                        matcher11 = matcher8;
                                                    } else {
                                                        matcher11 = matcher8;
                                                        if (!c(matcher11, str7)) {
                                                            matcher12 = matcher5;
                                                            if (!c(matcher12, str7)) {
                                                                if (str7.length() == 0) {
                                                                    break;
                                                                }
                                                                matcher13 = matcher6;
                                                                if (c(matcher13, str7)) {
                                                                    break;
                                                                }
                                                            } else if (a0Var != null) {
                                                                q5 q5Var4 = new q5();
                                                                q5Var4.b = 8;
                                                                a0Var.M0 = q5Var4;
                                                                a(e0Var2, q5Var4);
                                                            }
                                                        } else {
                                                            if (a0Var != null) {
                                                                q5 q5Var5 = new q5();
                                                                q5Var5.b = 8;
                                                                q5Var5.f = matcher11.group(1);
                                                                q5Var5.z = matcher11.group(2);
                                                                q5Var5.A = matcher11.group(3);
                                                                a0Var.M0 = q5Var5;
                                                                a(e0Var2, q5Var5);
                                                            }
                                                            matcher12 = matcher5;
                                                        }
                                                        matcher13 = matcher6;
                                                    }
                                                    matcher8 = matcher11;
                                                    matcher6 = matcher13;
                                                    matcher5 = matcher12;
                                                    matcher4 = matcher10;
                                                    matcher7 = matcher9;
                                                    i3 = i2;
                                                    str4 = str2;
                                                    sb0Var2 = sb0Var;
                                                } else if (a0Var != null) {
                                                    q5 q5Var6 = new q5();
                                                    q5Var6.b = 4;
                                                    q5Var6.f = matcher23.group(1);
                                                    q5Var6.z = matcher23.group(2);
                                                    q5Var6.A = matcher23.group(3);
                                                    a0Var.M0 = q5Var6;
                                                    a(e0Var2, q5Var6);
                                                }
                                            }
                                            matcher12 = matcher5;
                                            matcher13 = matcher6;
                                            matcher11 = matcher8;
                                            matcher8 = matcher11;
                                            matcher6 = matcher13;
                                            matcher5 = matcher12;
                                            matcher4 = matcher10;
                                            matcher7 = matcher9;
                                            i3 = i2;
                                            str4 = str2;
                                            sb0Var2 = sb0Var;
                                        }
                                    }
                                    matcher10 = matcher4;
                                    str2 = str4;
                                    matcher12 = matcher5;
                                    matcher13 = matcher6;
                                    matcher11 = matcher8;
                                    matcher8 = matcher11;
                                    matcher6 = matcher13;
                                    matcher5 = matcher12;
                                    matcher4 = matcher10;
                                    matcher7 = matcher9;
                                    i3 = i2;
                                    str4 = str2;
                                    sb0Var2 = sb0Var;
                                }
                                i2 = i3;
                                Collections.reverse(arrayList2);
                                c0 c0Var = new c0(arrayList2);
                                c0Var.z = Boolean.TRUE;
                                if (arrayList2.isEmpty()) {
                                    e0Var2.z0 = c0Var;
                                } else {
                                    e0Var2 = null;
                                }
                                if (e0Var2 == null) {
                                }
                            }
                        } else {
                            if (c(matcher18, str6)) {
                                Long lB3 = b(matcher18, 3);
                                if (lB3 == null) {
                                    p6Var.getLogger().h(p5.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                                    i2 = i3;
                                    str = str3;
                                    matcher3 = matcher15;
                                    matcher2 = matcher16;
                                    arrayList = arrayList3;
                                    e0Var2 = null;
                                    if (e0Var2 == null) {
                                    }
                                } else {
                                    e0Var2.b = lB3;
                                    e0Var2.z = matcher18.group(1);
                                    if (lB3.equals(this.c)) {
                                        e0Var2.y0 = Boolean.TRUE;
                                    }
                                }
                            }
                            p6 p6Var22 = this.d.b;
                            arrayList2 = new ArrayList();
                            Matcher matcher192 = l.matcher(str3);
                            matcher4 = m.matcher(str3);
                            Matcher matcher202 = n.matcher(str3);
                            Matcher matcher212 = o.matcher(str3);
                            Matcher matcher222 = q.matcher(str3);
                            matcher3 = matcher15;
                            Matcher matcher232 = p.matcher(str3);
                            matcher2 = matcher16;
                            Matcher matcher242 = s.matcher(str3);
                            Matcher matcher252 = r.matcher(str3);
                            arrayList = arrayList3;
                            matcher5 = t.matcher(str3);
                            matcher6 = u.matcher(str3);
                            matcher7 = k.matcher(str3);
                            str = str3;
                            matcher8 = matcher252;
                            a0 a0Var3 = null;
                            while (true) {
                                if (sb0Var2.c >= i3) {
                                }
                                matcher8 = matcher11;
                                matcher6 = matcher13;
                                matcher5 = matcher12;
                                matcher4 = matcher10;
                                matcher7 = matcher9;
                                i3 = i2;
                                str4 = str2;
                                sb0Var2 = sb0Var;
                            }
                            i2 = i3;
                            Collections.reverse(arrayList2);
                            c0 c0Var2 = new c0(arrayList2);
                            c0Var2.z = Boolean.TRUE;
                            if (arrayList2.isEmpty()) {
                            }
                            if (e0Var2 == null) {
                            }
                        }
                    }
                }
            } else {
                if (c(matcher16, str5)) {
                    this.c = b(matcher16, 1);
                } else {
                    boolean zStartsWith = str5.startsWith("Free memory until OOME ");
                    n2 n2Var = this.g;
                    if (zStartsWith) {
                        n2Var.l().z0 = n2.m(str5.substring(23));
                    } else if (str5.startsWith("Free memory until GC ")) {
                        n2Var.l().y0 = n2.m(str5.substring(21));
                    } else if (str5.startsWith("Free memory ")) {
                        n2Var.l().Z = n2.m(str5.substring(12));
                    } else if (str5.startsWith("Total memory ")) {
                        n2Var.l().A0 = n2.m(str5.substring(13));
                    } else if (str5.startsWith("Max memory ")) {
                        n2Var.l().B0 = n2.m(str5.substring(11));
                    } else if (str5.startsWith("Total time waiting for GC to complete: ")) {
                        n2Var.l().Y = n2.n(str5.substring(39));
                    } else if (str5.startsWith("Total GC time: ")) {
                        n2Var.l().f = n2.n(str5.substring(15));
                    } else if (str5.startsWith("Total GC count: ")) {
                        c cVarL = n2Var.l();
                        try {
                            lValueOf = Long.valueOf(Long.parseLong(str5.substring(16).trim()));
                        } catch (NumberFormatException unused) {
                        }
                        cVarL.b = lValueOf;
                    } else if (str5.startsWith("Total blocking GC time: ")) {
                        n2Var.l().A = n2.n(str5.substring(24));
                    } else if (str5.startsWith("Total blocking GC count: ")) {
                        c cVarL2 = n2Var.l();
                        try {
                            lValueOf = Long.valueOf(Long.parseLong(str5.substring(25).trim()));
                        } catch (NumberFormatException unused2) {
                        }
                        cVarL2.z = lValueOf;
                    } else if (str5.startsWith("Total pre-OOME GC count: ")) {
                        c cVarL3 = n2Var.l();
                        try {
                            lValueOf = Long.valueOf(Long.parseLong(str5.substring(25).trim()));
                        } catch (NumberFormatException unused3) {
                        }
                        cVarL3.X = lValueOf;
                    }
                }
                i2 = i3;
                pattern = pattern3;
                str = str3;
                matcher = matcher14;
                pattern2 = pattern4;
                matcher3 = matcher15;
                matcher2 = matcher16;
            }
            sb0Var2 = sb0Var;
            pattern3 = pattern;
            matcher14 = matcher;
            pattern4 = pattern2;
            matcher15 = matcher3;
            matcher16 = matcher2;
            str3 = str;
            i3 = i2;
        }
    }
}
