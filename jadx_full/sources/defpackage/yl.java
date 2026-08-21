package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class yl implements bg, e12 {
    public static final String X;
    public static final AtomicInteger Y;
    public s20 A;
    public final String b;
    public final String f;
    public s20 z;

    static {
        String string = UUID.randomUUID().toString();
        string.getClass();
        X = gb4.N(string);
        Y = new AtomicInteger(1);
    }

    public yl(String str, String str2) {
        this.b = str;
        this.f = str2;
    }

    @Override // defpackage.e12
    public final kk3 a(ve3 ve3Var) {
        cm2 cm2VarB;
        cm2 cm2Var = ve3Var.e;
        cm2Var.getClass();
        if (((lr1) cm2Var.A).a("Authorization") == null && (cm2VarB = b(cm2Var, null)) != null) {
            cm2Var = cm2VarB;
        }
        return ve3Var.b(cm2Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final cm2 b(cm2 cm2Var, kk3 kk3Var) {
        String str;
        int i;
        List<s20> list;
        int i2;
        s20 s20Var;
        int i3;
        int i4;
        String strN;
        String string;
        Logger logger;
        String string2;
        Logger logger2;
        String strN2;
        String str2 = this.b;
        String str3 = this.f;
        cm2Var.getClass();
        ev1 ev1Var = (ev1) cm2Var.f;
        if (kk3Var == null) {
            s20Var = this.z;
            if (s20Var == null && this.A == null) {
                ev1Var.f();
                yj0.a.fine("Trying Basic auth preemptively");
                Map mapSingletonMap = Collections.singletonMap("realm", "");
                mapSingletonMap.getClass();
                s20Var = new s20("Basic", mapSingletonMap);
                this.z = s20Var;
            }
            i = 0;
        } else {
            lr1 lr1Var = kk3Var.Y;
            int i5 = kk3Var.A;
            if (i5 == 401) {
                str = "WWW-Authenticate";
            } else if (i5 != 407) {
                list = g41.b;
                i = 0;
                s20 s20Var2 = null;
                s20 s20Var3 = null;
                for (s20 s20Var4 : list) {
                    if ("Basic".equalsIgnoreCase(s20Var4.a)) {
                        if (this.z != null) {
                            yj0.a.warning("Basic credentials didn't work last time -> aborting");
                            this.z = null;
                            return null;
                        }
                        s20Var2 = s20Var4;
                    } else if (!"Digest".equalsIgnoreCase(s20Var4.a)) {
                        continue;
                    } else {
                        if (this.A != null && !"true".equalsIgnoreCase((String) s20Var4.b.get("stale"))) {
                            yj0.a.warning("Digest credentials didn't work last time and server nonce has not expired -> aborting");
                            this.A = null;
                            return null;
                        }
                        s20Var3 = s20Var4;
                    }
                }
                this.z = s20Var2;
                this.A = s20Var3;
                s20Var = s20Var2;
            } else {
                str = "Proxy-Authenticate";
            }
            String str4 = str;
            bu buVar = ru1.a;
            ArrayList arrayList = new ArrayList();
            int size = lr1Var.size();
            int i6 = 0;
            i = 0;
            while (i6 < size) {
                if (str4.equalsIgnoreCase(gb4.z(lr1Var, i6))) {
                    hp hpVar = new hp();
                    hpVar.Q0(gb4.B(lr1Var, i6));
                    try {
                        ru1.b(hpVar, arrayList);
                        i2 = i6;
                    } catch (EOFException e) {
                        k13 k13Var = k13.a;
                        i2 = i6;
                        k13.a.i(5, "Unable to parse challenge", e);
                    }
                } else {
                    i2 = i6;
                }
                i6 = i2 + 1;
            }
            list = arrayList;
            s20 s20Var22 = null;
            s20 s20Var32 = null;
            while (r0.hasNext()) {
            }
            this.z = s20Var22;
            this.A = s20Var32;
            s20Var = s20Var22;
        }
        if (this.A != null) {
            Logger logger3 = yj0.a;
            logger3.fine("Adding Digest authorization request for " + ev1Var);
            s20 s20Var5 = this.A;
            String str5 = X;
            if (s20Var5 != null) {
                Map map = s20Var5.b;
                String str6 = (String) map.get("realm");
                String str7 = (String) map.get("opaque");
                String str8 = (String) map.get("nonce");
                String str9 = (String) map.get("algorithm");
                if (str9 == null || "MD5".equalsIgnoreCase(str9)) {
                    i3 = 1;
                } else if ("MD5-sess".equalsIgnoreCase(str9)) {
                    i3 = 2;
                } else {
                    logger3.warning("Ignoring unknown hash algorithm: ".concat(str9));
                    i3 = i;
                }
                String str10 = (String) map.get("qop");
                if (str10 != null) {
                    Iterator it = p44.L0(str10, new String[]{","}, 6).iterator();
                    int i7 = i;
                    int i8 = i7;
                    while (it.hasNext()) {
                        String str11 = (String) it.next();
                        Iterator it2 = it;
                        if (n12.c(str11, "auth")) {
                            it = it2;
                            i8 = 1;
                        } else if (n12.c(str11, "auth-int")) {
                            it = it2;
                            i7 = 1;
                        } else {
                            it = it2;
                        }
                    }
                    i4 = i7 != 0 ? 2 : i8 != 0 ? 1 : i;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add("username=".concat(gb4.T(str2)));
                if (str6 == null) {
                    yj0.a.warning("No realm provided, aborting Digest auth");
                    return null;
                }
                linkedList.add("realm=".concat(gb4.T(str6)));
                if (str8 == null) {
                    yj0.a.warning("No nonce provided, aborting Digest auth");
                    return null;
                }
                linkedList.add("nonce=".concat(gb4.T(str8)));
                if (str7 != null) {
                    linkedList.add("opaque=".concat(gb4.T(str7)));
                }
                if (i3 != 0) {
                    linkedList.add("algorithm=".concat(gb4.T(fw.f(i3))));
                }
                String str12 = (String) cm2Var.z;
                String strB = ev1Var.b();
                linkedList.add("uri=".concat(gb4.T(strB)));
                if (i4 != 0) {
                    String strK = fw.k(i4);
                    linkedList.add("qop=".concat(strK));
                    int i9 = i4;
                    linkedList.add("cnonce=".concat(gb4.T(str5)));
                    int andIncrement = Y.getAndIncrement();
                    Locale locale = Locale.ROOT;
                    Object[] objArr = new Object[1];
                    objArr[i] = Integer.valueOf(andIncrement);
                    String str13 = String.format(locale, "%08x", Arrays.copyOf(objArr, 1));
                    linkedList.add("nc=".concat(str13));
                    int i10 = i3 == 0 ? -1 : xl.a[fw.G(i3)];
                    if (i10 == 1) {
                        string = str2 + ':' + str6 + ':' + str3;
                    } else if (i10 != 2) {
                        string = null;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(gb4.N(str2 + ':' + str6 + ':' + str3));
                        sb.append(':');
                        sb.append(str8);
                        sb.append(':');
                        sb.append(str5);
                        string = sb.toString();
                    }
                    Logger logger4 = yj0.a;
                    logger4.finer("A1=" + string);
                    int iG = fw.G(i9);
                    if (iG == 0) {
                        logger = logger4;
                        string2 = str12 + ':' + strB;
                    } else {
                        if (iG != 1) {
                            g.d();
                            return null;
                        }
                        try {
                            ej3 ej3Var = (ej3) cm2Var.X;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str12);
                            sb2.append(':');
                            sb2.append(strB);
                            sb2.append(':');
                            if (ej3Var != null) {
                                hp hpVar2 = new hp();
                                ej3Var.c(hpVar2);
                                bu buVar2 = bu.A;
                                logger = logger4;
                                strN2 = t60.p(hpVar2.X(hpVar2.f)).c("MD5").e();
                            } else {
                                logger = logger4;
                                strN2 = gb4.N("");
                            }
                            sb2.append(strN2);
                            string2 = sb2.toString();
                        } catch (IOException unused) {
                            logger2 = yj0.a;
                            logger2.warning("Couldn't get entity-body for hash calculation");
                            string2 = null;
                        }
                    }
                    logger2 = logger;
                    logger2.finer("A2=" + string2);
                    if (string == null || string2 == null) {
                        strN = null;
                    } else {
                        String strN3 = gb4.N(string);
                        String str14 = str8 + ':' + str13 + ':' + str5 + ':' + strK + ':' + gb4.N(string2);
                        strN3.getClass();
                        strN = gb4.N(strN3 + ':' + str14);
                    }
                } else {
                    yj0.a.finer("Using legacy Digest auth");
                    if (i3 == 1) {
                        String strN4 = gb4.N(str2 + ':' + str6 + ':' + str3);
                        String str15 = str8 + ':' + gb4.N(str12 + ':' + strB);
                        strN4.getClass();
                        strN = gb4.N(strN4 + ':' + str15);
                    }
                }
                if (strN == null) {
                    return null;
                }
                linkedList.add("response=".concat(gb4.T(strN)));
                v92 v92VarW = cm2Var.w();
                v92VarW.l("Authorization", "Digest ".concat(d70.j0(linkedList, ", ", null, null, null, 62)));
                return new cm2(v92VarW);
            }
        } else {
            if (s20Var != null) {
                yj0.a.fine("Adding Basic authorization header for " + ev1Var);
                v92 v92VarW2 = cm2Var.w();
                Charset charset = y30.a;
                charset.getClass();
                byte[] bytes = (str2 + ':' + str3).getBytes(charset);
                bytes.getClass();
                new bu(bytes);
                v92VarW2.l("Authorization", "Basic ".concat(a.a(bytes, a.a)));
                return new cm2(v92VarW2);
            }
            if (kk3Var != null) {
                yj0.a.warning("No supported authentication scheme");
                return null;
            }
        }
        return null;
    }

    @Override // defpackage.bg
    public final cm2 h(em3 em3Var, kk3 kk3Var) {
        return b(kk3Var.b, kk3Var);
    }
}
