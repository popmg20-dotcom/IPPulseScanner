package defpackage;

import android.graphics.Bitmap;
import android.os.Process;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.dns.DnsRecord;
import io.sentry.android.core.a1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p81 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public final /* synthetic */ String Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p81(String str, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Y = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws ey4, IOException {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 1:
                ((p81) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            case 2:
                ((p81) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            case 3:
                ((p81) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            case 4:
                ((p81) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            case 5:
                ((p81) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            case 7:
                ((p81) n(ge0Var, lf0Var)).p(xl4Var);
                break;
        }
        return ((p81) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        String str = this.Y;
        switch (i) {
            case 0:
                return new p81(str, ge0Var, 0);
            case 1:
                return new p81(str, ge0Var, 1);
            case 2:
                return new p81(str, ge0Var, 2);
            case 3:
                return new p81(str, ge0Var, 3);
            case 4:
                return new p81(str, ge0Var, 4);
            case 5:
                return new p81(str, ge0Var, 5);
            case 6:
                return new p81(str, ge0Var, 6);
            case 7:
                return new p81(str, ge0Var, 7);
            case 8:
                return new p81(str, ge0Var, 8);
            default:
                return new p81(str, ge0Var, 9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x04b9 A[SYNTHETIC] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) throws ey4, IOException {
        int i;
        Throwable th;
        InputStream inputStreamOpenStream;
        zk zkVar;
        char c;
        Object next;
        zk zkVar2;
        Object obj2;
        Object obj3;
        lm2 lm2Var;
        int iOrdinal;
        int i2;
        int i3;
        int i4;
        int i5;
        char c2;
        bn bnVar;
        int i6;
        boolean z;
        char c3 = '\n';
        int i7 = 1;
        switch (this.X) {
            case 0:
                Throwable th2 = null;
                n12.S(obj);
                InetAddress byName = InetAddress.getByName(this.Y);
                byName.getClass();
                int i8 = 8080;
                while (true) {
                    if (i8 < 65535) {
                        try {
                        } catch (Exception e) {
                            e = e;
                        }
                        try {
                            new ServerSocket(i8, 1, byName).close();
                            i = i8;
                        } catch (Exception e2) {
                            e = e2;
                            String str = e.getLocalizedMessage() + " " + byName.getHostAddress() + ":" + i8;
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 3, "SocketUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
                            }
                            if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                                th = th2;
                            } else {
                                th = th2;
                                a1.o("SocketUtils", str, th);
                            }
                            i8++;
                            th2 = th;
                        }
                    } else {
                        i = 0;
                    }
                    i8++;
                    th2 = th;
                }
                return new Integer(i);
            case 1:
                n12.S(obj);
                inputStreamOpenStream = new URL(this.Y).openStream();
                try {
                    ko1 ko1Var = ko1.a;
                    inputStreamOpenStream.getClass();
                    ko1.a(inputStreamOpenStream);
                    inputStreamOpenStream.close();
                    return xl4.a;
                } finally {
                }
            case 2:
                n12.S(obj);
                File file = ko1.d;
                if (file.exists()) {
                    file.renameTo(ko1.e);
                    ko1 ko1Var2 = ko1.a;
                    ko1.b(this.Y);
                }
                return xl4.a;
            case 3:
                n12.S(obj);
                inputStreamOpenStream = new URL(this.Y).openStream();
                try {
                    ko1 ko1Var3 = ko1.a;
                    inputStreamOpenStream.getClass();
                    ko1.a(inputStreamOpenStream);
                    inputStreamOpenStream.close();
                    return xl4.a;
                } finally {
                }
            case 4:
                n12.S(obj);
                try {
                    vd3 vd3Var = vd3.A;
                    String str2 = this.Y;
                    vd3Var.m(str2, str2);
                    break;
                } catch (Exception unused) {
                }
                return xl4.a;
            case 5:
                n12.S(obj);
                try {
                    k01 k01Var = k01.A;
                    String str3 = this.Y;
                    k01Var.c(str3, str3);
                    break;
                } catch (Exception unused2) {
                }
                return xl4.a;
            case 6:
                char c4 = '\n';
                String str4 = this.Y;
                n12.S(obj);
                try {
                    File fileG = d73.g(str4);
                    if (fileG.exists()) {
                        String strD = g73.d(str4);
                        List list = (List) d73.b.d();
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    next = it.next();
                                    if (n12.c(((zk) next).getName(), str4)) {
                                    }
                                } else {
                                    next = null;
                                }
                            }
                            zkVar = (zk) next;
                        } else {
                            zkVar = null;
                        }
                        zk zkVarA = zkVar instanceof t53 ? t53.a((t53) zkVar, strD, 4194302) : zkVar instanceof p12 ? p12.a((p12) zkVar, strD) : null;
                        if (zkVarA != null) {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileG), y30.a), 8192);
                            try {
                                StringBuilder sb = new StringBuilder();
                                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                    if (w44.j0(line, "#!MANAGED-CONFIG ", false)) {
                                        c = c4;
                                    } else {
                                        sb.append(line);
                                        c = c4;
                                        sb.append(c);
                                    }
                                    c4 = c;
                                }
                                String string = sb.toString();
                                zkVarA.h();
                                zkVarA.o(string.hashCode());
                                on2 on2Var = d73.b;
                                Collection collection = (List) on2Var.d();
                                if (collection == null) {
                                    collection = g41.b;
                                }
                                ArrayList arrayList = new ArrayList(collection);
                                arrayList.add(zkVarA);
                                h70.T(arrayList, d73.a);
                                on2Var.i(arrayList);
                                le1.W(d73.g(strD), string);
                                bufferedReader.close();
                            } finally {
                            }
                        }
                        ji0.i(str4, strD);
                        return strD;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return null;
            case 7:
                n12.S(obj);
                String strA = i73.a();
                String str5 = this.Y;
                if (n12.c(strA, str5)) {
                    i73.b(null);
                }
                List list2 = (List) d73.b.d();
                if (list2 != null) {
                    Iterator it2 = list2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object next2 = it2.next();
                            if (n12.c(((zk) next2).getName(), str5)) {
                                obj2 = next2;
                            }
                        } else {
                            obj2 = null;
                        }
                    }
                    zkVar2 = (zk) obj2;
                } else {
                    zkVar2 = null;
                }
                if (zkVar2 != null) {
                    on2 on2Var2 = d73.b;
                    Collection collection2 = (List) on2Var2.d();
                    if (collection2 == null) {
                        collection2 = g41.b;
                    }
                    ArrayList arrayList2 = new ArrayList(collection2);
                    arrayList2.remove(zkVar2);
                    on2Var2.i(arrayList2);
                }
                d73.g(str5).delete();
                ua3 ua3VarT = oj0.a.t();
                ua3VarT.getClass();
                ke0.r(ua3VarT.a, false, true, new ko0(str5, 8));
                return xl4.a;
            case 8:
                n12.S(obj);
                String str6 = this.Y;
                if (!str6.isEmpty()) {
                    Charset charset = n41.b;
                    lm2 lm2Var2 = lm2.BYTE;
                    Charset charset2 = n44.b;
                    if (charset2 != null && charset2.equals(charset)) {
                        byte[] bytes = str6.getBytes(n44.b);
                        int length = bytes.length;
                        if (length % 2 != 0) {
                            z = false;
                            if (z) {
                                lm2Var = lm2.KANJI;
                            }
                            bn bnVar2 = new bn();
                            char c5 = 4;
                            bnVar2.b(lm2Var.f, 4);
                            bn bnVar3 = new bn();
                            iOrdinal = lm2Var.ordinal();
                            obj3 = null;
                            if (iOrdinal != 1) {
                            }
                            int iA = lm2Var.a(wo4.c(1)) + bnVar2.f + bnVar3.f;
                            i2 = 1;
                            while (i2 <= 40) {
                            }
                            throw new ey4("Data too big");
                        }
                        for (int i9 = 0; i9 < length; i9 += 2) {
                            int i10 = bytes[i9] & 255;
                            if ((i10 < 129 || i10 > 159) && (i10 < 224 || i10 > 235)) {
                                z = false;
                                if (z) {
                                }
                                bn bnVar22 = new bn();
                                char c52 = 4;
                                bnVar22.b(lm2Var.f, 4);
                                bn bnVar32 = new bn();
                                iOrdinal = lm2Var.ordinal();
                                obj3 = null;
                                if (iOrdinal != 1) {
                                }
                                int iA2 = lm2Var.a(wo4.c(1)) + bnVar22.f + bnVar32.f;
                                i2 = 1;
                                while (i2 <= 40) {
                                }
                                throw new ey4("Data too big");
                            }
                        }
                        z = true;
                        if (z) {
                        }
                        bn bnVar222 = new bn();
                        char c522 = 4;
                        bnVar222.b(lm2Var.f, 4);
                        bn bnVar322 = new bn();
                        iOrdinal = lm2Var.ordinal();
                        obj3 = null;
                        if (iOrdinal != 1) {
                        }
                        int iA22 = lm2Var.a(wo4.c(1)) + bnVar222.f + bnVar322.f;
                        i2 = 1;
                        while (i2 <= 40) {
                        }
                        throw new ey4("Data too big");
                    }
                    int i11 = 0;
                    boolean z2 = false;
                    boolean z3 = false;
                    while (true) {
                        if (i11 < str6.length()) {
                            char cCharAt = str6.charAt(i11);
                            if (cCharAt >= '0' && cCharAt <= '9') {
                                z3 = true;
                            } else if ((cCharAt < '`' ? n41.a[cCharAt] : -1) != -1) {
                                z2 = true;
                            }
                            i11++;
                        } else if (z2) {
                            lm2Var = lm2.ALPHANUMERIC;
                        } else if (z3) {
                            lm2Var = lm2.NUMERIC;
                        }
                    }
                    lm2Var = lm2Var2;
                    bn bnVar2222 = new bn();
                    char c5222 = 4;
                    bnVar2222.b(lm2Var.f, 4);
                    bn bnVar3222 = new bn();
                    iOrdinal = lm2Var.ordinal();
                    obj3 = null;
                    if (iOrdinal != 1) {
                        int length2 = str6.length();
                        int i12 = 0;
                        while (i12 < length2) {
                            int iCharAt = str6.charAt(i12) - '0';
                            int i13 = i12 + 2;
                            if (i13 < length2) {
                                bnVar3222.b(((str6.charAt(i12 + 1) - '0') * 10) + (iCharAt * 100) + (str6.charAt(i13) - '0'), 10);
                                i12 += 3;
                            } else {
                                i12++;
                                if (i12 < length2) {
                                    bnVar3222.b((iCharAt * 10) + (str6.charAt(i12) - '0'), 7);
                                    i12 = i13;
                                } else {
                                    bnVar3222.b(iCharAt, 4);
                                }
                            }
                        }
                    } else if (iOrdinal == 2) {
                        int length3 = str6.length();
                        int i14 = 0;
                        while (i14 < length3) {
                            char cCharAt2 = str6.charAt(i14);
                            int[] iArr = n41.a;
                            int i15 = cCharAt2 < '`' ? iArr[cCharAt2] : -1;
                            if (i15 == -1) {
                                throw new ey4();
                            }
                            int i16 = i14 + 1;
                            if (i16 < length3) {
                                char cCharAt3 = str6.charAt(i16);
                                int i17 = cCharAt3 < '`' ? iArr[cCharAt3] : -1;
                                if (i17 == -1) {
                                    throw new ey4();
                                }
                                bnVar3222.b((i15 * 45) + i17, 11);
                                i14 += 2;
                            } else {
                                bnVar3222.b(i15, 6);
                                i14 = i16;
                            }
                        }
                    } else if (iOrdinal == 4) {
                        for (byte b : str6.getBytes(charset)) {
                            bnVar3222.b(b, 8);
                        }
                    } else {
                        if (iOrdinal != 6) {
                            throw new ey4("Invalid mode: " + lm2Var);
                        }
                        Charset charset3 = n44.b;
                        if (charset3 == null) {
                            throw new ey4("SJIS Charset not supported on this platform");
                        }
                        byte[] bytes2 = str6.getBytes(charset3);
                        if (bytes2.length % 2 != 0) {
                            throw new ey4("Kanji byte size not even");
                        }
                        int length4 = bytes2.length - 1;
                        for (int i18 = 0; i18 < length4; i18 += 2) {
                            int i19 = (bytes2[i18 + 1] & 255) | ((bytes2[i18] & 255) << 8);
                            int i20 = (i19 < 33088 || i19 > 40956) ? (i19 < 57408 || i19 > 60351) ? -1 : i19 - 49472 : i19 - 33088;
                            if (i20 == -1) {
                                throw new ey4("Invalid byte sequence");
                            }
                            bnVar3222.b(((i20 >> 8) * 192) + (i20 & DnsRecord.CLASS_ANY), 13);
                        }
                    }
                    int iA222 = lm2Var.a(wo4.c(1)) + bnVar2222.f + bnVar3222.f;
                    i2 = 1;
                    while (i2 <= 40) {
                        wo4 wo4VarC = wo4.c(i2);
                        if (n41.a(iA222, wo4VarC, i7)) {
                            int iA3 = lm2Var.a(wo4VarC) + bnVar2222.f + bnVar3222.f;
                            int i21 = i7;
                            while (i21 <= 40) {
                                wo4 wo4VarC2 = wo4.c(i21);
                                if (n41.a(iA3, wo4VarC2, i7)) {
                                    bn bnVar4 = new bn();
                                    int i22 = bnVar2222.f;
                                    bnVar4.c(i22);
                                    for (int i23 = 0; i23 < i22; i23++) {
                                        bnVar4.a(bnVar2222.d(i23));
                                    }
                                    int iG = lm2Var == lm2Var2 ? bnVar3222.g() : str6.length();
                                    int iA4 = lm2Var.a(wo4VarC2);
                                    int i24 = i7 << iA4;
                                    if (iG >= i24) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(iG);
                                        sb2.append(" is bigger than ");
                                        sb2.append(i24 - 1);
                                        throw new ey4(sb2.toString());
                                    }
                                    bnVar4.b(iG, iA4);
                                    int i25 = bnVar3222.f;
                                    bnVar4.c(bnVar4.f + i25);
                                    for (int i26 = 0; i26 < i25; i26++) {
                                        bnVar4.a(bnVar3222.d(i26));
                                    }
                                    t6 t6Var = wo4VarC2.c[fw.G(i7)];
                                    int i27 = wo4VarC2.d;
                                    int i28 = t6Var.f;
                                    hm2[] hm2VarArr = (hm2[]) t6Var.z;
                                    int i29 = 0;
                                    for (hm2 hm2Var : hm2VarArr) {
                                        i29 += hm2Var.b;
                                    }
                                    int i30 = i27 - (i29 * i28);
                                    int i31 = i30 * 8;
                                    if (bnVar4.f > i31) {
                                        throw new ey4("data bits cannot fit in the QR Code" + bnVar4.f + " > " + i31);
                                    }
                                    for (int i32 = 0; i32 < 4 && bnVar4.f < i31; i32++) {
                                        bnVar4.a(false);
                                    }
                                    boolean z4 = false;
                                    int i33 = 7 & bnVar4.f;
                                    if (i33 > 0) {
                                        while (i33 < 8) {
                                            bnVar4.a(z4);
                                            i33++;
                                            z4 = false;
                                        }
                                    }
                                    int iG2 = i30 - bnVar4.g();
                                    for (int i34 = 0; i34 < iG2; i34++) {
                                        bnVar4.b((i34 & 1) == 0 ? 236 : 17, 8);
                                    }
                                    if (bnVar4.f != i31) {
                                        throw new ey4("Bits size does not equal capacity");
                                    }
                                    int i35 = 0;
                                    for (hm2 hm2Var2 : hm2VarArr) {
                                        i35 += hm2Var2.b;
                                    }
                                    if (bnVar4.g() != i30) {
                                        throw new ey4("Number of bits and data bytes does not match");
                                    }
                                    ArrayList arrayList3 = new ArrayList(i35);
                                    int i36 = 0;
                                    int i37 = 0;
                                    int iMax = 0;
                                    int iMax2 = 0;
                                    while (i36 < i35) {
                                        int[] iArr2 = new int[i7];
                                        int[] iArr3 = new int[i7];
                                        if (i36 >= i35) {
                                            throw new ey4("Block ID too large");
                                        }
                                        int i38 = i27 % i35;
                                        int i39 = i35 - i38;
                                        int i40 = i27 / i35;
                                        int i41 = i40 + 1;
                                        int i42 = i30 / i35;
                                        int i43 = i42 + 1;
                                        char c6 = c5222;
                                        int i44 = i40 - i42;
                                        char c7 = c3;
                                        int i45 = i41 - i43;
                                        if (i44 != i45) {
                                            throw new ey4("EC bytes mismatch");
                                        }
                                        int i46 = i7;
                                        if (i35 != i39 + i38) {
                                            throw new ey4("RS blocks mismatch");
                                        }
                                        if (i27 != ((i43 + i45) * i38) + ((i42 + i44) * i39)) {
                                            throw new ey4("Total bytes mismatch");
                                        }
                                        if (i36 < i39) {
                                            c2 = 0;
                                            iArr2[0] = i42;
                                            iArr3[0] = i44;
                                        } else {
                                            c2 = 0;
                                            iArr2[0] = i43;
                                            iArr3[0] = i45;
                                        }
                                        int i47 = iArr2[c2];
                                        byte[] bArr = new byte[i47];
                                        int i48 = i37 * 8;
                                        int i49 = 0;
                                        while (i49 < i47) {
                                            int i50 = i36;
                                            int i51 = i35;
                                            int[] iArr4 = iArr3;
                                            int i52 = 0;
                                            for (int i53 = 0; i53 < 8; i53++) {
                                                if (bnVar4.d(i48)) {
                                                    i52 |= i46 << (7 - i53);
                                                }
                                                i48++;
                                            }
                                            bArr[i49] = (byte) i52;
                                            i49++;
                                            i36 = i50;
                                            i35 = i51;
                                            iArr3 = iArr4;
                                        }
                                        int i54 = i36;
                                        int i55 = i35;
                                        int i56 = iArr3[0];
                                        int i57 = i47 + i56;
                                        int[] iArr5 = new int[i57];
                                        for (int i58 = 0; i58 < i47; i58++) {
                                            iArr5[i58] = bArr[i58] & 255;
                                        }
                                        ho1 ho1Var = ho1.l;
                                        ArrayList arrayList4 = new ArrayList();
                                        arrayList4.add(new io1(ho1Var, new int[]{i46}));
                                        if (i56 != 0) {
                                            int i59 = i57 - i56;
                                            if (i59 > 0) {
                                                if (i56 >= arrayList4.size()) {
                                                    io1 io1Var = (io1) fw.r(arrayList4, i46);
                                                    int size = arrayList4.size();
                                                    bnVar = bnVar4;
                                                    io1 io1VarG = io1Var;
                                                    while (size <= i56) {
                                                        int i60 = size;
                                                        io1VarG = io1VarG.g(new io1(ho1Var, new int[]{1, ho1Var.a[(i60 - 1) + ho1Var.g]}));
                                                        arrayList4.add(io1VarG);
                                                        size = i60 + 1;
                                                        i27 = i27;
                                                        wo4VarC2 = wo4VarC2;
                                                    }
                                                } else {
                                                    bnVar = bnVar4;
                                                }
                                                int i61 = i27;
                                                wo4 wo4Var = wo4VarC2;
                                                io1 io1Var2 = (io1) arrayList4.get(i56);
                                                int[] iArr6 = new int[i59];
                                                System.arraycopy(iArr5, 0, iArr6, 0, i59);
                                                if (i59 == 0) {
                                                    s53.d();
                                                } else if (i59 <= 1 || iArr6[0] != 0) {
                                                    i6 = i59;
                                                    if (i56 >= 0) {
                                                        int length5 = iArr6.length;
                                                        int[] iArr7 = new int[length5 + i56];
                                                        int i62 = 0;
                                                        while (i62 < length5) {
                                                            iArr7[i62] = ho1Var.c(iArr6[i62], 1);
                                                            i62++;
                                                            iArr6 = iArr6;
                                                        }
                                                        io1 io1Var3 = new io1(ho1Var, iArr7);
                                                        if (!ho1Var.equals(io1Var2.a)) {
                                                            xe.k("GenericGFPolys do not have same GenericGF field");
                                                        } else if (io1Var2.e()) {
                                                            xe.k("Divide by 0");
                                                        } else {
                                                            io1 io1VarA = ho1Var.c;
                                                            int iB = ho1Var.b(io1Var2.c(io1Var2.d()));
                                                            while (io1Var3.d() >= io1Var2.d() && !io1Var3.e()) {
                                                                int iD = io1Var3.d() - io1Var2.d();
                                                                int iC = ho1Var.c(io1Var3.c(io1Var3.d()), iB);
                                                                int i63 = iB;
                                                                io1 io1VarH = io1Var2.h(iD, iC);
                                                                io1VarA = io1VarA.a(ho1Var.a(iD, iC));
                                                                io1Var3 = io1Var3.a(io1VarH);
                                                                iB = i63;
                                                            }
                                                            int[] iArr8 = new io1[]{io1VarA, io1Var3}[1].b;
                                                            int length6 = i56 - iArr8.length;
                                                            for (int i64 = 0; i64 < length6; i64++) {
                                                                iArr5[i6 + i64] = 0;
                                                            }
                                                            System.arraycopy(iArr8, 0, iArr5, i6 + length6, iArr8.length);
                                                            byte[] bArr2 = new byte[i56];
                                                            for (int i65 = 0; i65 < i56; i65++) {
                                                                bArr2[i65] = (byte) iArr5[i47 + i65];
                                                            }
                                                            arrayList3.add(new rn(bArr, bArr2));
                                                            iMax = Math.max(iMax, i47);
                                                            iMax2 = Math.max(iMax2, i56);
                                                            i37 += iArr2[0];
                                                            i36 = i54 + 1;
                                                            c3 = c7;
                                                            i35 = i55;
                                                            bnVar4 = bnVar;
                                                            c5222 = c6;
                                                            i27 = i61;
                                                            wo4VarC2 = wo4Var;
                                                            i7 = 1;
                                                        }
                                                    } else {
                                                        s53.d();
                                                    }
                                                } else {
                                                    int i66 = 1;
                                                    while (i66 < i59 && iArr6[i66] == 0) {
                                                        i66++;
                                                    }
                                                    if (i66 == i59) {
                                                        iArr6 = new int[]{0};
                                                        i6 = i59;
                                                        if (i56 >= 0) {
                                                        }
                                                    } else {
                                                        int i67 = i59 - i66;
                                                        i6 = i59;
                                                        int[] iArr9 = new int[i67];
                                                        System.arraycopy(iArr6, i66, iArr9, 0, i67);
                                                        iArr6 = iArr9;
                                                        if (i56 >= 0) {
                                                        }
                                                    }
                                                }
                                            } else {
                                                xe.k("No data bytes provided");
                                            }
                                        } else {
                                            xe.k("No error correction bytes");
                                        }
                                    }
                                    int i68 = i27;
                                    wo4 wo4Var2 = wo4VarC2;
                                    if (i30 != i37) {
                                        throw new ey4("Data bytes does not match offset");
                                    }
                                    bn bnVar5 = new bn();
                                    for (int i69 = 0; i69 < iMax; i69++) {
                                        Iterator it3 = arrayList3.iterator();
                                        while (it3.hasNext()) {
                                            byte[] bArr3 = ((rn) it3.next()).a;
                                            if (i69 < bArr3.length) {
                                                bnVar5.b(bArr3[i69], 8);
                                            }
                                        }
                                    }
                                    for (int i70 = 0; i70 < iMax2; i70++) {
                                        Iterator it4 = arrayList3.iterator();
                                        while (it4.hasNext()) {
                                            byte[] bArr4 = ((rn) it4.next()).b;
                                            if (i70 < bArr4.length) {
                                                bnVar5.b(bArr4[i70], 8);
                                            }
                                        }
                                    }
                                    if (i68 != bnVar5.g()) {
                                        StringBuilder sbD = dw2.D("Interleaving error: ", i68, " and ");
                                        sbD.append(bnVar5.g());
                                        sbD.append(" differ.");
                                        throw new ey4(sbD.toString());
                                    }
                                    int i71 = (wo4Var2.a * 4) + 17;
                                    boolean z5 = false;
                                    tt ttVar = new tt(i71, i71, 0);
                                    int i72 = ttVar.c;
                                    int i73 = ttVar.b;
                                    int i74 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                                    int i75 = 0;
                                    int i76 = -1;
                                    while (i75 < 8) {
                                        r25.c(bnVar5, 1, wo4Var2, i75, ttVar);
                                        int iB2 = ke0.b(ttVar, z5) + ke0.b(ttVar, true);
                                        byte[][] bArr5 = (byte[][]) ttVar.d;
                                        int i77 = 0;
                                        for (int i78 = 0; i78 < i72 - 1; i78++) {
                                            byte[] bArr6 = bArr5[i78];
                                            int i79 = 0;
                                            while (i79 < i73 - 1) {
                                                byte b2 = bArr6[i79];
                                                int i80 = i79 + 1;
                                                int i81 = i75;
                                                if (b2 == bArr6[i80]) {
                                                    byte[] bArr7 = bArr5[i78 + 1];
                                                    if (b2 == bArr7[i79] && b2 == bArr7[i80]) {
                                                        i77++;
                                                    }
                                                }
                                                i79 = i80;
                                                i75 = i81;
                                            }
                                        }
                                        int i82 = i75;
                                        int i83 = (i77 * 3) + iB2;
                                        int i84 = 0;
                                        for (int i85 = 0; i85 < i72; i85++) {
                                            for (int i86 = 0; i86 < i73; i86++) {
                                                byte[] bArr8 = bArr5[i85];
                                                int i87 = i86 + 6;
                                                if (i87 < i73) {
                                                    byte b3 = 1;
                                                    if (bArr8[i86] == 1 && bArr8[i86 + 1] == 0 && bArr8[i86 + 2] == 1 && bArr8[i86 + 3] == 1 && bArr8[i86 + 4] == 1 && bArr8[i86 + 5] == 0 && bArr8[i87] == 1) {
                                                        int i88 = i86 - 4;
                                                        if (i88 < 0 || bArr8.length < i86) {
                                                            i5 = i86 + 7;
                                                            int i89 = i86 + 11;
                                                            if (i5 < 0 && bArr8.length >= i89) {
                                                                while (i5 < i89) {
                                                                    i3 = i84;
                                                                    if (bArr8[i5] != 1) {
                                                                        i5++;
                                                                        i84 = i3;
                                                                    }
                                                                }
                                                                i84++;
                                                            }
                                                            i84 = i3;
                                                        } else {
                                                            while (i88 < i86) {
                                                                if (bArr8[i88] == b3) {
                                                                    i5 = i86 + 7;
                                                                    int i892 = i86 + 11;
                                                                    if (i5 < 0) {
                                                                        i3 = i84;
                                                                        i84 = i3;
                                                                    }
                                                                } else {
                                                                    i88++;
                                                                    b3 = 1;
                                                                }
                                                            }
                                                            i84++;
                                                        }
                                                    } else {
                                                        i3 = i84;
                                                        i84 = i3;
                                                    }
                                                }
                                                int i90 = i85 + 6;
                                                if (i90 < i72) {
                                                    byte b4 = 1;
                                                    if (bArr5[i85][i86] == 1 && bArr5[i85 + 1][i86] == 0 && bArr5[i85 + 2][i86] == 1 && bArr5[i85 + 3][i86] == 1 && bArr5[i85 + 4][i86] == 1 && bArr5[i85 + 5][i86] == 0 && bArr5[i90][i86] == 1) {
                                                        int i91 = i85 - 4;
                                                        if (i91 < 0 || bArr5.length < i85) {
                                                            i4 = i85 + 7;
                                                            int i92 = i85 + 11;
                                                            if (i4 < 0 && bArr5.length >= i92) {
                                                                while (i4 < i92) {
                                                                    if (bArr5[i4][i86] == 1) {
                                                                    }
                                                                    i4++;
                                                                    break;
                                                                }
                                                                i84++;
                                                            }
                                                        } else {
                                                            while (i91 < i85) {
                                                                if (bArr5[i91][i86] == b4) {
                                                                    i4 = i85 + 7;
                                                                    int i922 = i85 + 11;
                                                                    if (i4 < 0) {
                                                                    }
                                                                } else {
                                                                    i91++;
                                                                    b4 = 1;
                                                                }
                                                            }
                                                            i84++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        int i93 = (i84 * 40) + i83;
                                        int i94 = 0;
                                        for (int i95 = 0; i95 < i72; i95++) {
                                            byte[] bArr9 = bArr5[i95];
                                            for (int i96 = 0; i96 < i73; i96++) {
                                                if (bArr9[i96] == 1) {
                                                    i94++;
                                                }
                                            }
                                        }
                                        int i97 = i72 * i73;
                                        int iAbs = (((Math.abs((i94 * 2) - i97) * 10) / i97) * 10) + i93;
                                        if (iAbs < i74) {
                                            i74 = iAbs;
                                            i76 = i82;
                                        }
                                        i75 = i82 + 1;
                                        z5 = false;
                                    }
                                    r25.c(bnVar5, 1, wo4Var2, i76, ttVar);
                                    int i98 = i73 + 8;
                                    int i99 = i72 + 8;
                                    int iMax3 = Math.max(200, i98);
                                    int iMax4 = Math.max(200, i99);
                                    int iMin = Math.min(iMax3 / i98, iMax4 / i99);
                                    int i100 = (iMax3 - (i73 * iMin)) / 2;
                                    int i101 = (iMax4 - (i72 * iMin)) / 2;
                                    cn cnVar = new cn(iMax3, iMax4);
                                    int i102 = 0;
                                    while (i102 < i72) {
                                        int i103 = i100;
                                        int i104 = 0;
                                        while (i104 < i73) {
                                            if (ttVar.c(i104, i102) == 1) {
                                                cnVar.g(i103, i101, iMin, iMin);
                                            }
                                            i104++;
                                            i103 += iMin;
                                        }
                                        i102++;
                                        i101 += iMin;
                                    }
                                    int i105 = cnVar.b;
                                    int i106 = cnVar.f;
                                    int[] iArr10 = new int[i105 * i106];
                                    for (int i107 = 0; i107 < i106; i107++) {
                                        for (int i108 = 0; i108 < i105; i108++) {
                                            iArr10[(i107 * i105) + i108] = cnVar.b(i108, i107) ? -16777216 : -1;
                                        }
                                    }
                                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i105, i106, Bitmap.Config.ARGB_8888);
                                    bitmapCreateBitmap.getClass();
                                    bitmapCreateBitmap.setPixels(iArr10, 0, i105, 0, 0, i105, i106);
                                    return bitmapCreateBitmap;
                                }
                                i21++;
                                i7 = 1;
                            }
                            throw new ey4("Data too big");
                        }
                        i2++;
                        i7 = 1;
                    }
                    throw new ey4("Data too big");
                }
                obj3 = null;
                xe.k("Found empty contents");
                return obj3;
            default:
                n12.S(obj);
                return InetAddress.getAllByName(this.Y);
        }
    }
}
