package defpackage;

import com.getsurfboard.base.ContextUtilsKt;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r63 extends v74 implements Function2 {
    public final /* synthetic */ cd1 A0;
    public final /* synthetic */ ad1 B0;
    public /* synthetic */ Object X;
    public final /* synthetic */ String Y;
    public final /* synthetic */ String Z;
    public final /* synthetic */ Map y0;
    public final /* synthetic */ ed1 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r63(String str, String str2, Map map, ed1 ed1Var, cd1 cd1Var, ad1 ad1Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.Y = str;
        this.Z = str2;
        this.y0 = map;
        this.z0 = ed1Var;
        this.A0 = cd1Var;
        this.B0 = ad1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((r63) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        r63 r63Var = new r63(this.Y, this.Z, this.y0, this.z0, this.A0, this.B0, ge0Var);
        r63Var.X = obj;
        return r63Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0385 A[PHI: r1
      0x0385: PHI (r1v37 java.lang.String) = (r1v27 java.lang.String), (r1v45 java.lang.String) binds: [B:101:0x0443, B:74:0x037b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) throws IOException {
        Iterator it;
        ArrayList arrayList;
        String strO;
        String strO2;
        lf0 lf0Var = (lf0) this.X;
        n12.S(obj);
        z53 z53Var = new z53(lf0Var, 2);
        Set set = s63.a;
        String str = this.Y;
        str.getClass();
        Map map = this.y0;
        map.getClass();
        ed1 ed1Var = this.z0;
        ed1Var.getClass();
        cd1 cd1Var = this.A0;
        cd1Var.getClass();
        ad1 ad1Var = this.B0;
        ad1Var.getClass();
        Collection collectionValues = map.values();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = collectionValues.iterator();
        while (it2.hasNext()) {
            ea3 ea3Var = (ea3) it2.next();
            boolean z = ea3Var instanceof ms4;
            tn tnVar = tn.b;
            String str2 = str;
            Map map2 = map;
            ed1 ed1Var2 = ed1Var;
            cd1 cd1Var2 = cd1Var;
            ad1 ad1Var2 = ad1Var;
            z53 z53Var2 = z53Var;
            if (z) {
                ms4 ms4Var = (ms4) ea3Var;
                it = it2;
                arrayList = arrayList2;
                strO = ms4Var.b + " = vmess, " + ms4Var.f + ", " + ms4Var.z + ", username=" + ms4Var.A + ", ws=" + ms4Var.Y + ", tls=" + ms4Var.X + ", ws-path=" + ms4Var.Z + ", skip-cert-verify=" + ms4Var.z0 + ", udp-relay=" + ms4Var.C0 + ", vmess-aead=" + ms4Var.D0;
                Map map3 = ms4Var.y0;
                if (!map3.isEmpty()) {
                    ArrayList arrayList3 = new ArrayList(map3.size());
                    for (Map.Entry entry : map3.entrySet()) {
                        arrayList3.add(entry.getKey() + ":" + entry.getValue());
                    }
                    strO = strO.concat(d70.j0(arrayList3, "|", ", ws-headers=", null, null, 60));
                }
                String str3 = ms4Var.A0;
                if (str3 != null) {
                    strO = ha0.o(strO, ", sni=", str3);
                }
                String str4 = ms4Var.B0;
                if (str4 != null) {
                    strO = ha0.o(strO, ", server-cert-fingerprint-sha256=", str4);
                }
                tn tnVar2 = ms4Var.E0;
                if (tnVar2 != tnVar) {
                    String lowerCase = tnVar2.name().toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                    strO = strO + ", block-quic=" + lowerCase;
                }
                String str5 = ms4Var.F0;
                if (str5 != null) {
                    strO = ha0.o(strO, ", underlying-proxy=", str5);
                }
            } else {
                it = it2;
                arrayList = arrayList2;
                if (ea3Var instanceof mu3) {
                    mu3 mu3Var = (mu3) ea3Var;
                    String str6 = mu3Var.Z;
                    String str7 = mu3Var.b;
                    String str8 = mu3Var.f;
                    int i = mu3Var.z;
                    String str9 = mu3Var.A;
                    String str10 = mu3Var.X;
                    boolean z2 = mu3Var.z0;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str7);
                    sb.append(" = ss, ");
                    sb.append(str8);
                    sb.append(", ");
                    sb.append(i);
                    ha0.v(sb, ", encrypt-method=", str9, ", password=", str10);
                    sb.append(", udp-relay=");
                    sb.append(z2);
                    String string = sb.toString();
                    lu3 lu3Var = mu3Var.Y;
                    if (lu3Var == lu3.TLS) {
                        string = ha0.o(string, ", obfs=tls, obfs-host=", str6);
                    } else if (lu3Var == lu3.HTTP) {
                        string = fw.v(string, ", obfs=http, obfs-host=", str6, ", obfs-uri=", mu3Var.y0);
                    }
                    tn tnVar3 = mu3Var.A0;
                    if (tnVar3 != tnVar) {
                        String lowerCase2 = tnVar3.name().toLowerCase(Locale.ROOT);
                        lowerCase2.getClass();
                        string = string + ", block-quic=" + lowerCase2;
                    }
                    String str11 = mu3Var.B0;
                    strO = str11 != null ? ha0.o(string, ", underlying-proxy=", str11) : string;
                } else if (ea3Var instanceof xh4) {
                    xh4 xh4Var = (xh4) ea3Var;
                    strO = xh4Var.b + " = trojan, " + xh4Var.f + ", " + xh4Var.z + ", password=" + xh4Var.A + ", ws=" + xh4Var.X + ", ws-path=" + xh4Var.Y + ", skip-cert-verify=" + xh4Var.y0 + ", udp-relay=" + xh4Var.B0;
                    Map map4 = xh4Var.Z;
                    if (!map4.isEmpty()) {
                        ArrayList arrayList4 = new ArrayList(map4.size());
                        for (Map.Entry entry2 : map4.entrySet()) {
                            arrayList4.add(entry2.getKey() + ":" + entry2.getValue());
                        }
                        strO = strO.concat(d70.j0(arrayList4, "|", ", ws-headers=", null, null, 60));
                    }
                    String str12 = xh4Var.z0;
                    if (str12 != null) {
                        strO = ha0.o(strO, ", sni=", str12);
                    }
                    String str13 = xh4Var.A0;
                    if (str13 != null) {
                        strO = ha0.o(strO, ", server-cert-fingerprint-sha256=", str13);
                    }
                    tn tnVar4 = xh4Var.C0;
                    if (tnVar4 != tnVar) {
                        String lowerCase3 = tnVar4.name().toLowerCase(Locale.ROOT);
                        lowerCase3.getClass();
                        strO = strO + ", block-quic=" + lowerCase3;
                    }
                    String str14 = xh4Var.D0;
                    if (str14 != null) {
                        strO = ha0.o(strO, ", underlying-proxy=", str14);
                    }
                } else if (ea3Var instanceof s9) {
                    s9 s9Var = (s9) ea3Var;
                    String strO3 = s9Var.b + " = anytls, " + s9Var.f + ", " + s9Var.z + ", password=" + s9Var.A + ", skip-cert-verify=" + s9Var.X + ", udp-relay=" + s9Var.z0;
                    String str15 = s9Var.Y;
                    if (str15 != null) {
                        strO3 = ha0.o(strO3, ", sni=", str15);
                    }
                    String str16 = s9Var.Z;
                    if (str16 != null) {
                        strO3 = ha0.o(strO3, ", server-cert-fingerprint-sha256=", str16);
                    }
                    strO2 = strO3 + ", reuse=" + s9Var.y0;
                    tn tnVar5 = s9Var.A0;
                    if (tnVar5 != tnVar) {
                        String lowerCase4 = tnVar5.name().toLowerCase(Locale.ROOT);
                        lowerCase4.getClass();
                        strO2 = strO2 + ", block-quic=" + lowerCase4;
                    }
                    String str17 = s9Var.B0;
                    strO = str17 != null ? ha0.o(strO2, ", underlying-proxy=", str17) : strO2;
                } else if (ea3Var instanceof jv1) {
                    jv1 jv1Var = (jv1) ea3Var;
                    String str18 = jv1Var.b;
                    String str19 = jv1Var.f;
                    int i2 = jv1Var.z;
                    String str20 = jv1Var.A;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str18);
                    sb2.append(" = hysteria2, ");
                    sb2.append(str19);
                    sb2.append(", ");
                    sb2.append(i2);
                    String strY = fw.y(sb2, ", password=", str20);
                    Integer num = jv1Var.X;
                    if (num != null) {
                        strY = strY + ", download-bandwidth=" + num;
                    }
                    List list = jv1Var.Y;
                    if (list != null) {
                        strY = fw.u(strY, ", port-hopping=\"", d70.j0(list, ";", null, null, null, 62), "\"");
                    }
                    Integer num2 = jv1Var.Z;
                    if (num2 != null) {
                        strY = strY + ", port-hopping-interval=" + num2;
                    }
                    strO2 = strY + ", skip-cert-verify=" + jv1Var.z0;
                    String str21 = jv1Var.A0;
                    if (str21 != null) {
                        strO2 = ha0.o(strO2, ", sni=", str21);
                    }
                    String str22 = jv1Var.B0;
                    if (str22 != null) {
                        strO2 = ha0.o(strO2, ", server-cert-fingerprint-sha256=", str22);
                    }
                    String str23 = jv1Var.y0;
                    if (str23 != null) {
                        strO2 = ha0.o(strO2, ", salamander-password=", str23);
                    }
                    tn tnVar6 = jv1Var.D0;
                    if (tnVar6 != tnVar) {
                        String lowerCase5 = tnVar6.name().toLowerCase(Locale.ROOT);
                        lowerCase5.getClass();
                        strO2 = strO2 + ", block-quic=" + lowerCase5;
                    }
                    String str24 = jv1Var.E0;
                    if (str24 != null) {
                        strO = ha0.o(strO2, ", underlying-proxy=", str24);
                    }
                } else {
                    strO = null;
                }
            }
            arrayList2 = arrayList;
            if (strO != null) {
                arrayList2.add(strO);
            }
            str = str2;
            map = map2;
            ed1Var = ed1Var2;
            cd1Var = cd1Var2;
            ad1Var = ad1Var2;
            z53Var = z53Var2;
            it2 = it;
        }
        String str25 = str;
        ed1 ed1Var3 = ed1Var;
        cd1 cd1Var3 = cd1Var;
        ad1 ad1Var3 = ad1Var;
        z53 z53Var3 = z53Var;
        String strJ0 = d70.j0(arrayList2, "\n", null, null, null, 62);
        String strJ02 = d70.j0(map.keySet(), ", ", null, null, null, 62);
        InputStream inputStreamOpen = ContextUtilsKt.getContext().getAssets().open("template.conf");
        inputStreamOpen.getClass();
        Charset charset = y30.a;
        String strO4 = String.format(l72.T(new BufferedReader(new InputStreamReader(inputStreamOpen, charset), 8192)), Arrays.copyOf(new Object[]{strJ0, strJ02}, 2));
        String str26 = this.Z;
        if (str26 != null && !p44.x0(str26)) {
            strO4 = ha0.o(ha0.o("#!MANAGED-CONFIG ", str26, " interval=86400 strict=false"), "\n", strO4);
        }
        byte[] bytes = strO4.getBytes(charset);
        bytes.getClass();
        return new uk3(c63.j(str25, new ByteArrayInputStream(bytes), ed1Var3, cd1Var3, ad1Var3, z53Var3));
    }
}
