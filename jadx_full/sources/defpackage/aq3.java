package defpackage;

import j$.util.Optional;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class aq3 implements Iterator {
    public static final Pattern B0 = Pattern.compile("[^0-9A-Fa-f]");
    public re4 Z;
    public final w34 b;
    public boolean X = false;
    public int Y = 0;
    public int y0 = 0;
    public int z0 = -1;
    public boolean A0 = true;
    public final ArrayList f = new ArrayList(100);
    public final vd1 z = new vd1(10);
    public final LinkedHashMap A = new LinkedHashMap();

    public aq3(uf4 uf4Var, w34 w34Var) {
        this.b = w34Var;
        Optional optionalC = w34Var.c();
        b(new c44(optionalC, optionalC));
    }

    public final void A() {
        LinkedHashMap linkedHashMap = this.A;
        if (linkedHashMap.isEmpty()) {
            return;
        }
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            cx3 cx3Var = (cx3) it.next();
            int i = cx3Var.d;
            w34 w34Var = this.b;
            if (i != w34Var.i || w34Var.g - cx3Var.c > 1024) {
                if (cx3Var.b) {
                    s53.p("while scanning a simple key", cx3Var.f, "could not find expected ':'", w34Var.c());
                    return;
                }
                it.remove();
            }
        }
    }

    public final void B(int i) {
        if (k()) {
            while (this.z0 > i) {
                Optional optionalC = this.b.c();
                this.z0 = ((Integer) this.z.b()).intValue();
                b(new mn(optionalC, optionalC, 0));
            }
        }
    }

    public final boolean a(int i) {
        int i2 = this.z0;
        if (i2 >= i) {
            return false;
        }
        this.z.c(Integer.valueOf(i2));
        this.z0 = i;
        return true;
    }

    public final void b(re4 re4Var) {
        this.Z = re4Var;
        this.f.add(re4Var);
    }

    public final boolean c(int i) {
        while (m()) {
            j();
        }
        ArrayList arrayList = this.f;
        return !arrayList.isEmpty() && ((re4) arrayList.get(0)).a() == i;
    }

    public final boolean d(int... iArr) {
        while (m()) {
            j();
        }
        ArrayList arrayList = this.f;
        if (!arrayList.isEmpty()) {
            if (iArr.length == 0) {
                return true;
            }
            int iA = ((re4) arrayList.get(0)).a();
            for (int i : iArr) {
                if (iA == i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0055 A[PHI: r4
      0x0055: PHI (r4v16 j$.util.Optional) = (r4v0 j$.util.Optional), (r4v21 j$.util.Optional) binds: [B:7:0x0031, B:12:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(qp3 qp3Var) {
        char c;
        Optional optionalC;
        int i;
        String string;
        int iMax;
        qp3 qp3Var2;
        this.A0 = true;
        p();
        StringBuilder sb = new StringBuilder();
        w34 w34Var = this.b;
        Optional optionalC2 = w34Var.c();
        w34Var.b(1);
        Optional optionalEmpty = Optional.empty();
        int iD = w34Var.d();
        if (iD == 45 || iD == 43) {
            w34Var.b(1);
            int iD2 = w34Var.d();
            if (Character.isDigit(iD2)) {
                int i2 = Integer.parseInt(String.valueOf(Character.toChars(iD2)));
                if (i2 == 0) {
                    s53.p("while scanning a block scalar", optionalC2, "expected indentation indicator in the range 1-9, but found 0", w34Var.c());
                    return;
                } else {
                    optionalEmpty = Optional.of(Integer.valueOf(i2));
                    w34Var.b(1);
                }
            }
        } else if (Character.isDigit(iD)) {
            int i3 = Integer.parseInt(String.valueOf(Character.toChars(iD)));
            if (i3 == 0) {
                s53.p("while scanning a block scalar", optionalC2, "expected indentation indicator in the range 1-9, but found 0", w34Var.c());
                return;
            }
            optionalEmpty = Optional.of(Integer.valueOf(i3));
            w34Var.b(1);
            iD = w34Var.d();
            if (iD == 45 || iD == 43) {
                w34Var.b(1);
            }
        } else {
            iD = Integer.MIN_VALUE;
        }
        int iD3 = w34Var.d();
        if (p30.d.c(iD3)) {
            s53.p("while scanning a block scalar", optionalC2, fw.t(iD3, "expected chomping or indentation indicators, but found ", String.valueOf(Character.toChars(iD3)), "(", ")"), w34Var.c());
            return;
        }
        if (iD == 43) {
            c = 3;
        } else if (iD == 45) {
            c = 1;
        } else {
            if (iD != Integer.MIN_VALUE) {
                xe.k(dw2.A(iD, "Unexpected block chomping indicator: "));
                return;
            }
            c = 2;
        }
        while (w34Var.d() == 32) {
            w34Var.b(1);
        }
        f80 f80VarT = w34Var.d() == 35 ? t(3) : null;
        int iD4 = w34Var.d();
        if (!w().isPresent() && iD4 != 0) {
            s53.p("while scanning a block scalar", optionalC2, fw.t(iD4, "expected a comment or a line break, but found ", String.valueOf(Character.toChars(iD4)), "(", ")"), w34Var.c());
            return;
        }
        int i4 = this.z0 + 1;
        int i5 = i4 < 1 ? 1 : i4;
        int i6 = -1;
        if (optionalEmpty.isPresent()) {
            iMax = (((Integer) optionalEmpty.get()).intValue() + i5) - 1;
            zp3 zp3VarS = s(iMax);
            string = zp3VarS.b;
            optionalC = zp3VarS.a;
            i = 1;
        } else {
            StringBuilder sb2 = new StringBuilder();
            optionalC = w34Var.c();
            i = 1;
            int i7 = 0;
            while (true) {
                p30 p30Var = p30.b;
                int iD5 = w34Var.d();
                if (!p30Var.b(iD5) && " \r".indexOf(iD5) == -1) {
                    break;
                }
                Optional optional = optionalC2;
                if (w34Var.d() != 32) {
                    sb2.append((String) w().orElse(""));
                    optionalC = w34Var.c();
                    optionalC2 = optional;
                    i = 1;
                } else {
                    w34Var.b(1);
                    int i8 = w34Var.j;
                    if (i8 > i7) {
                        i7 = i8;
                    }
                    optionalC2 = optional;
                    i = 1;
                }
            }
            int i9 = w34Var.j;
            if (i9 > 0 && i9 < i7) {
                s53.p("while scanning a block scalar", optionalC, " the leading empty lines contain more spaces (" + i7 + ") than the first non-empty line (" + i9 + ").", w34Var.c());
                return;
            }
            string = sb2.toString();
            iMax = Math.max(i5, i9);
        }
        Optional optionalEmpty2 = Optional.empty();
        while (w34Var.j == iMax && w34Var.d() != 0) {
            sb.append(string);
            int i10 = " \t".indexOf(w34Var.d()) == i6 ? i : 0;
            int i11 = 0;
            while (p30.c.c(w34Var.e(i11))) {
                i11++;
            }
            sb.append(w34Var.g(i11));
            Optional optionalW = w();
            zp3 zp3VarS2 = s(iMax);
            String str = zp3VarS2.b;
            Optional optional2 = zp3VarS2.a;
            if (w34Var.j != iMax || w34Var.d() == 0) {
                qp3Var2 = qp3Var;
                optionalEmpty2 = optionalW;
                optionalC = optional2;
                string = str;
                break;
            }
            if (qp3Var != qp3.X) {
                sb.append((String) optionalW.orElse(""));
            } else {
                if (!"\n".equals(optionalW.orElse("")) || i10 == 0) {
                    i6 = -1;
                } else {
                    i6 = -1;
                    if (" \t".indexOf(w34Var.d()) == -1) {
                        if (str.isEmpty()) {
                            sb.append(' ');
                        }
                    }
                }
                sb.append((String) optionalW.orElse(""));
            }
            optionalEmpty2 = optionalW;
            optionalC = optional2;
            string = str;
        }
        qp3Var2 = qp3Var;
        if (c == 2 || c == 3) {
            sb.append((String) optionalEmpty2.orElse(""));
        }
        if (c == 3) {
            sb.append(string);
        }
        rp3 rp3Var = new rp3(sb.toString(), false, qp3Var2, optionalC2, optionalC);
        re4[] re4VarArr = new re4[2];
        re4VarArr[0] = f80VarT;
        re4VarArr[i] = rp3Var;
        ArrayList arrayListL = l(re4VarArr);
        this.Z = (re4) fw.r(arrayListL, i);
        this.f.addAll(arrayListL);
    }

    public final void f(boolean z) {
        B(-1);
        p();
        this.A0 = false;
        w34 w34Var = this.b;
        Optional optionalC = w34Var.c();
        w34Var.b(3);
        Optional optionalC2 = w34Var.c();
        b(z ? new mn(optionalC, optionalC2, 4) : new mn(optionalC, optionalC2, 3));
    }

    public final void g(boolean z) {
        p();
        this.Y--;
        this.A0 = false;
        w34 w34Var = this.b;
        Optional optionalC = w34Var.c();
        w34Var.b(1);
        Optional optionalC2 = w34Var.c();
        b(z ? new mn(optionalC, optionalC2, 6) : new mn(optionalC, optionalC2, 8));
    }

    public final void h(boolean z) {
        q();
        this.Y++;
        this.A0 = true;
        w34 w34Var = this.b;
        Optional optionalC = w34Var.c();
        w34Var.b(1);
        Optional optionalC2 = w34Var.c();
        b(z ? new mn(optionalC, optionalC2, 7) : new mn(optionalC, optionalC2, 9));
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return d(new int[0]);
    }

    public final void i(qp3 qp3Var) {
        q();
        this.A0 = false;
        boolean z = qp3Var == qp3.f;
        StringBuilder sb = new StringBuilder();
        w34 w34Var = this.b;
        Optional optionalC = w34Var.c();
        int iD = w34Var.d();
        w34Var.b(1);
        v(z, optionalC, sb);
        while (w34Var.d() != iD) {
            int i = 0;
            while (" \t".indexOf(w34Var.e(i)) != -1) {
                i++;
            }
            String strG = w34Var.g(i);
            if (w34Var.d() == 0) {
                s53.p("while scanning a quoted scalar", optionalC, "found unexpected end of stream", w34Var.c());
                return;
            }
            Optional optionalW = w();
            if (optionalW.isPresent()) {
                String strU = u(optionalC);
                if (!"\n".equals(optionalW.get())) {
                    sb.append((String) optionalW.get());
                } else if (strU.isEmpty()) {
                    sb.append(' ');
                }
                sb.append(strU);
            } else {
                sb.append(strG);
            }
            v(z, optionalC, sb);
        }
        w34Var.b(1);
        b(new rp3(sb.toString(), false, qp3Var, optionalC, w34Var.c()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:268:0x0568, code lost:
    
        if ("-?:".indexOf(r4) != (-1)) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0589, code lost:
    
        if ("-?".indexOf(r4) != (-1)) goto L280;
     */
    /* JADX WARN: Removed duplicated region for block: B:298:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x070f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j() {
        char c;
        String strX;
        String strY;
        char c2;
        Optional optionalC;
        Optional optionalEmpty;
        re4 re4Var;
        w34 w34Var = this.b;
        if (w34Var.h > 3145728) {
            throw new hy4("The incoming YAML document exceeds the limit: 3145728 code points.");
        }
        if (w34Var.g == 0 && w34Var.d() == 65279) {
            w34Var.b(1);
        }
        int i = -1;
        boolean z = false;
        while (true) {
            int i2 = 2;
            if (z) {
                break;
            }
            w34Var.c();
            int i3 = w34Var.j;
            int i4 = 0;
            while (w34Var.e(i4) == 32) {
                i4++;
            }
            if (w34Var.e(i4) == 9 && !k()) {
                i4++;
            }
            if (i4 > 0) {
                w34Var.b(i4);
            }
            if (w34Var.d() == 35) {
                if (i3 == 0 || ((re4Var = this.Z) != null && re4Var.a() == 4)) {
                    if (i != w34Var.j) {
                        i = -1;
                    }
                    t(i2);
                } else {
                    i = w34Var.j;
                }
                i2 = 3;
                t(i2);
            }
            if (!w().isPresent()) {
                z = true;
            } else if (k()) {
                this.A0 = true;
            }
        }
        A();
        B(w34Var.j);
        int iD = w34Var.d();
        LinkedHashMap linkedHashMap = this.A;
        if (iD == 0) {
            B(-1);
            p();
            this.A0 = false;
            linkedHashMap.clear();
            Optional optionalC2 = w34Var.c();
            b(new v34(optionalC2, optionalC2));
            this.X = true;
            return;
        }
        if (iD == 42) {
            q();
            this.A0 = false;
            b(r(false));
            return;
        }
        ArrayList arrayList = this.f;
        if (iD == 58) {
            if (!k() ? true : p30.e.b(w34Var.e(1))) {
                cx3 cx3Var = (cx3) linkedHashMap.remove(Integer.valueOf(this.Y));
                if (cx3Var != null) {
                    Optional optional = cx3Var.f;
                    int i5 = cx3Var.a;
                    int i6 = i5 - this.y0;
                    mn mnVar = new mn(optional, optional, 10);
                    if (i6 == arrayList.size()) {
                        this.Z = mnVar;
                    }
                    arrayList.add(i6, mnVar);
                    if (k() && a(cx3Var.e)) {
                        int i7 = i5 - this.y0;
                        mn mnVar2 = new mn(optional, optional, 1);
                        if (i7 == arrayList.size()) {
                            this.Z = mnVar2;
                        }
                        arrayList.add(i7, mnVar2);
                    }
                    this.A0 = false;
                } else {
                    if (k() && !this.A0) {
                        throw new v90(3, "mapping values are not allowed here", w34Var.c());
                    }
                    if (k() && a(w34Var.j)) {
                        Optional optionalC3 = w34Var.c();
                        b(new mn(optionalC3, optionalC3, 1));
                    }
                    this.A0 = k();
                    p();
                }
                Optional optionalC4 = w34Var.c();
                w34Var.b(1);
                b(new mn(optionalC4, w34Var.c(), 11));
                return;
            }
        } else {
            if (iD == 91) {
                h(false);
                return;
            }
            if (iD == 93) {
                g(false);
                return;
            }
            String str = null;
            if (iD == 33) {
                q();
                this.A0 = false;
                Optional optionalC5 = w34Var.c();
                int iE = w34Var.e(1);
                if (iE == 60) {
                    w34Var.b(2);
                    strY = y("tag", p30.f, optionalC5);
                    int iD2 = w34Var.d();
                    if (iD2 != 62) {
                        s53.p("while scanning a tag", optionalC5, fw.t(iD2, "expected '>', but found '", String.valueOf(Character.toChars(iD2)), "' (", ")"), w34Var.c());
                        return;
                    }
                    w34Var.b(1);
                } else if (p30.e.b(iE)) {
                    w34Var.b(1);
                    strY = "!";
                } else {
                    int i8 = 1;
                    while (true) {
                        if (!p30.d.c(iE)) {
                            w34Var.b(1);
                            strX = "!";
                            break;
                        } else if (iE == 33) {
                            strX = x("tag", optionalC5);
                            break;
                        } else {
                            i8++;
                            iE = w34Var.e(i8);
                        }
                    }
                    strY = y("tag", p30.g, optionalC5);
                    str = strX;
                }
                int iD3 = w34Var.d();
                if (p30.d.c(iD3)) {
                    s53.p("while scanning a tag", optionalC5, fw.t(iD3, "expected ' ', but found '", String.valueOf(Character.toChars(iD3)), "' (", ")"), w34Var.c());
                    return;
                } else {
                    b(new qa4(new zp3(strY, Optional.ofNullable(str)), optionalC5, w34Var.c()));
                    return;
                }
            }
            if (iD == 34) {
                i(qp3.f);
                return;
            }
            if (iD != 62) {
                if (iD != 63) {
                    switch (iD) {
                        case 37:
                            if (w34Var.j == 0) {
                                B(-1);
                                p();
                                this.A0 = false;
                                Optional optionalC6 = w34Var.c();
                                w34Var.b(1);
                                int iE2 = w34Var.e(0);
                                int i9 = 0;
                                while (p30.h.b(iE2)) {
                                    i9++;
                                    iE2 = w34Var.e(i9);
                                }
                                if (i9 == 0) {
                                    s53.p("while scanning a directive", optionalC6, fw.t(iE2, "expected alphabetic or numeric character, but found ", String.valueOf(Character.toChars(iE2)), "(", ")"), w34Var.c());
                                    return;
                                }
                                String strG = w34Var.g(i9);
                                int iD4 = w34Var.d();
                                if (p30.d.c(iD4)) {
                                    s53.p("while scanning a directive", optionalC6, fw.t(iD4, "expected alphabetic or numeric character, but found ", String.valueOf(Character.toChars(iD4)), "(", ")"), w34Var.c());
                                    return;
                                }
                                if ("YAML".equals(strG)) {
                                    while (w34Var.d() == 32) {
                                        w34Var.b(1);
                                    }
                                    Integer numZ = z(optionalC6);
                                    int iD5 = w34Var.d();
                                    if (iD5 != 46) {
                                        s53.p("while scanning a directive", optionalC6, fw.t(iD5, "expected a digit or '.', but found ", String.valueOf(Character.toChars(iD5)), "(", ")"), w34Var.c());
                                        return;
                                    }
                                    w34Var.b(1);
                                    Integer numZ2 = z(optionalC6);
                                    int iD6 = w34Var.d();
                                    c2 = 0;
                                    if (p30.d.c(iD6)) {
                                        s53.p("while scanning a directive", optionalC6, fw.t(iD6, "expected a digit or ' ', but found ", String.valueOf(Character.toChars(iD6)), "(", ")"), w34Var.c());
                                        return;
                                    }
                                    ArrayList arrayList2 = new ArrayList(2);
                                    arrayList2.add(numZ);
                                    arrayList2.add(numZ2);
                                    optionalEmpty = Optional.of(arrayList2);
                                    optionalC = w34Var.c();
                                } else {
                                    c2 = 0;
                                    if ("TAG".equals(strG)) {
                                        while (w34Var.d() == 32) {
                                            w34Var.b(1);
                                        }
                                        String strX2 = x("directive", optionalC6);
                                        int iD7 = w34Var.d();
                                        if (iD7 != 32) {
                                            s53.p("while scanning a directive", optionalC6, fw.t(iD7, "expected ' ', but found ", String.valueOf(Character.toChars(iD7)), "(", ")"), w34Var.c());
                                            return;
                                        }
                                        while (w34Var.d() == 32) {
                                            w34Var.b(1);
                                        }
                                        String strY2 = y("directive", p30.f, optionalC6);
                                        int iD8 = w34Var.d();
                                        if (p30.d.c(iD8)) {
                                            s53.p("while scanning a directive", optionalC6, fw.t(iD8, "expected ' ', but found ", String.valueOf(Character.toChars(iD8)), "(", ")"), w34Var.c());
                                            return;
                                        }
                                        ArrayList arrayList3 = new ArrayList(2);
                                        arrayList3.add(strX2);
                                        arrayList3.add(strY2);
                                        optionalEmpty = Optional.of(arrayList3);
                                        optionalC = w34Var.c();
                                    } else {
                                        optionalC = w34Var.c();
                                        int i10 = 0;
                                        while (p30.c.c(w34Var.e(i10))) {
                                            i10++;
                                        }
                                        if (i10 > 0) {
                                            w34Var.b(i10);
                                        }
                                        optionalEmpty = Optional.empty();
                                    }
                                }
                                while (w34Var.d() == 32) {
                                    w34Var.b(1);
                                }
                                if (w34Var.d() == 35) {
                                    t(3);
                                }
                                int iD9 = w34Var.d();
                                if (w().isEmpty() && iD9 != 0) {
                                    s53.p("while scanning a directive", optionalC6, fw.t(iD9, "expected a comment or a line break, but found ", String.valueOf(Character.toChars(iD9)), "(", ")"), w34Var.c());
                                    return;
                                }
                                cv0 cv0Var = new cv0(strG, optionalEmpty, optionalC6, optionalC);
                                re4[] re4VarArr = new re4[2];
                                re4VarArr[c2] = cv0Var;
                                re4VarArr[1] = null;
                                ArrayList arrayListL = l(re4VarArr);
                                this.Z = (re4) fw.r(arrayListL, 1);
                                arrayList.addAll(arrayListL);
                                return;
                            }
                            break;
                        case 38:
                            q();
                            this.A0 = false;
                            b(r(true));
                            return;
                        case 39:
                            i(qp3.z);
                            return;
                        default:
                            switch (iD) {
                                case 44:
                                    this.A0 = true;
                                    p();
                                    Optional optionalC7 = w34Var.c();
                                    w34Var.b(1);
                                    b(new mn(optionalC7, w34Var.c(), 5));
                                    return;
                                case 45:
                                    if (w34Var.j == 0 && "---".equals(w34Var.f(3)) && p30.e.b(w34Var.e(3))) {
                                        f(true);
                                        return;
                                    }
                                    if (p30.e.b(w34Var.e(1))) {
                                        if (k()) {
                                            if (!this.A0) {
                                                s53.p("", Optional.empty(), "sequence entries are not allowed here", w34Var.c());
                                                return;
                                            } else if (a(w34Var.j)) {
                                                Optional optionalC8 = w34Var.c();
                                                b(new mn(optionalC8, optionalC8, 2));
                                            }
                                        }
                                        this.A0 = true;
                                        p();
                                        Optional optionalC9 = w34Var.c();
                                        w34Var.b(1);
                                        b(new nn(optionalC9, w34Var.c()));
                                        return;
                                    }
                                    break;
                                case 46:
                                    if (w34Var.j == 0 && "...".equals(w34Var.f(3)) && p30.e.b(w34Var.e(3))) {
                                        f(false);
                                        return;
                                    }
                                    break;
                                default:
                                    switch (iD) {
                                        case 123:
                                            h(true);
                                            return;
                                        case 124:
                                            if (k()) {
                                                e(qp3.A);
                                                return;
                                            }
                                            break;
                                        case 125:
                                            g(true);
                                            return;
                                    }
                                    break;
                            }
                            break;
                    }
                } else if (p30.e.b(w34Var.e(1))) {
                    if (k()) {
                        if (!this.A0) {
                            throw new v90(3, "mapping keys are not allowed here", w34Var.c());
                        }
                        if (a(w34Var.j)) {
                            Optional optionalC10 = w34Var.c();
                            b(new mn(optionalC10, optionalC10, 1));
                        }
                    }
                    this.A0 = k();
                    p();
                    Optional optionalC11 = w34Var.c();
                    w34Var.b(1);
                    b(new mn(optionalC11, w34Var.c(), 10));
                    return;
                }
            } else if (k()) {
                e(qp3.X);
                return;
            }
        }
        int iD10 = w34Var.d();
        p30 p30Var = p30.e;
        if (p30Var.b(iD10) || "-?:,[]{}#&*!|>'\"%@`".indexOf(iD10) != -1) {
            if (k()) {
                if (p30Var.c(w34Var.e(1))) {
                }
                String strA = p30.a(String.valueOf(Character.toChars(iD)));
                if (iD == 9) {
                    strA = ha0.x(strA, "(TAB)");
                }
                s53.p("while scanning for the next token", Optional.empty(), fw.v("found character '", strA, "' that cannot start any token. (Do not use ", strA, " for indentation)"), w34Var.c());
                return;
            }
            int iE3 = w34Var.e(1);
            if (!(p30Var.b(iE3) || ",]".indexOf(iE3) != -1)) {
            }
            String strA2 = p30.a(String.valueOf(Character.toChars(iD)));
            if (iD == 9) {
            }
            s53.p("while scanning for the next token", Optional.empty(), fw.v("found character '", strA2, "' that cannot start any token. (Do not use ", strA2, " for indentation)"), w34Var.c());
            return;
        }
        q();
        this.A0 = false;
        StringBuilder sb = new StringBuilder();
        Optional optionalC12 = w34Var.c();
        int i11 = this.z0 + 1;
        String str2 = "";
        Optional optionalC13 = optionalC12;
        while (w34Var.d() != 35) {
            int i12 = 0;
            while (true) {
                int iE4 = w34Var.e(i12);
                p30 p30Var2 = p30.e;
                if (!p30Var2.b(iE4)) {
                    if (iE4 == 58) {
                        int iE5 = w34Var.e(i12 + 1);
                        String str3 = !k() ? ",[]{}" : "";
                        if (!p30Var2.b(iE5) && str3.indexOf(iE5) == -1) {
                            if (k() || ",[]{}".indexOf(iE4) == -1) {
                                i12++;
                            }
                        }
                    }
                    b(new rp3(sb.toString(), true, qp3.Y, optionalC12, optionalC13));
                }
            }
            if (i12 != 0) {
                this.A0 = false;
                sb.append(str2);
                sb.append(w34Var.g(i12));
                optionalC13 = w34Var.c();
                int i13 = 0;
                while (true) {
                    if (w34Var.e(i13) == 32 || w34Var.e(i13) == 9) {
                        i13++;
                    } else {
                        String strG2 = w34Var.g(i13);
                        Optional optionalW = w();
                        if (optionalW.isPresent()) {
                            this.A0 = true;
                            String strF = w34Var.f(3);
                            if ("---".equals(strF) || ("...".equals(strF) && p30.e.b(w34Var.e(3)))) {
                                c = ' ';
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                while (true) {
                                    c = ' ';
                                    if (w34Var.d() == 32) {
                                        w34Var.b(1);
                                    } else {
                                        Optional optionalW2 = w();
                                        if (optionalW2.isPresent()) {
                                            sb2.append((String) optionalW2.get());
                                            String strF2 = w34Var.f(3);
                                            if ("---".equals(strF2) || ("...".equals(strF2) && p30.e.b(w34Var.e(3)))) {
                                            }
                                        } else if ("\n".equals(optionalW.orElse(""))) {
                                            strG2 = sb2.length() == 0 ? " " : sb2.toString();
                                        } else {
                                            strG2 = ((String) optionalW.orElse("")) + ((Object) sb2);
                                        }
                                    }
                                }
                            }
                            str2 = "";
                            if (!str2.isEmpty() || w34Var.d() == 35 || (k() && w34Var.j < i11)) {
                            }
                        } else {
                            c = ' ';
                        }
                        str2 = strG2;
                        if (!str2.isEmpty()) {
                        }
                    }
                }
            }
            b(new rp3(sb.toString(), true, qp3.Y, optionalC12, optionalC13));
        }
        b(new rp3(sb.toString(), true, qp3.Y, optionalC12, optionalC13));
    }

    public final boolean k() {
        return this.Y == 0;
    }

    public final ArrayList l(re4... re4VarArr) {
        ArrayList arrayList = new ArrayList();
        for (re4 re4Var : re4VarArr) {
            if (re4Var != null && !(re4Var instanceof f80)) {
                arrayList.add(re4Var);
            }
        }
        return arrayList;
    }

    public final boolean m() {
        if (this.X) {
            return false;
        }
        if (this.f.isEmpty()) {
            return true;
        }
        A();
        LinkedHashMap linkedHashMap = this.A;
        return (!linkedHashMap.isEmpty() ? ((cx3) linkedHashMap.values().iterator().next()).a : -1) == this.y0;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final re4 next() {
        this.y0++;
        ArrayList arrayList = this.f;
        if (!arrayList.isEmpty()) {
            return (re4) arrayList.remove(0);
        }
        e04.h("No more Tokens found.");
        return null;
    }

    public final re4 o() {
        while (m()) {
            j();
        }
        return (re4) this.f.get(0);
    }

    public final void p() {
        cx3 cx3Var = (cx3) this.A.remove(Integer.valueOf(this.Y));
        if (cx3Var == null || !cx3Var.b) {
            return;
        }
        s53.p("while scanning a simple key", cx3Var.f, "could not find expected ':'", this.b.c());
    }

    public final void q() {
        boolean zK = k();
        w34 w34Var = this.b;
        boolean z = zK && this.z0 == w34Var.j;
        boolean z2 = this.A0;
        if (!z2 && z) {
            throw new hy4("A simple key is required only if it is the first token in the current line");
        }
        if (z2) {
            p();
            this.A.put(Integer.valueOf(this.Y), new cx3(this.f.size() + this.y0, z, w34Var.g, w34Var.i, w34Var.j, w34Var.c()));
        }
    }

    public final re4 r(boolean z) {
        p30 p30Var;
        w34 w34Var = this.b;
        Optional optionalC = w34Var.c();
        String str = w34Var.d() == 42 ? "alias" : "anchor";
        boolean z2 = true;
        w34Var.b(1);
        int iE = w34Var.e(0);
        int i = 0;
        while (true) {
            p30Var = p30.e;
            if (p30Var.b(iE) || ",[]{}/.*&".indexOf(iE) != -1) {
                break;
            }
            i++;
            iE = w34Var.e(i);
        }
        if (i == 0) {
            s53.p("while scanning an ".concat(str), optionalC, fw.t(iE, "unexpected character found ", String.valueOf(Character.toChars(iE)), "(", ")"), w34Var.c());
            return null;
        }
        String strG = w34Var.g(i);
        int iD = w34Var.d();
        if (!p30Var.b(iD) && "?:,]}%@`".indexOf(iD) == -1) {
            z2 = false;
        }
        if (z2) {
            Optional optionalC2 = w34Var.c();
            return z ? new h7(new f7(strG), optionalC, optionalC2) : new x6(new f7(strG), optionalC, optionalC2);
        }
        s53.p("while scanning an ".concat(str), optionalC, fw.t(iD, "unexpected character found ", String.valueOf(Character.toChars(iD)), "(", ")"), w34Var.c());
        return null;
    }

    public final zp3 s(int i) {
        StringBuilder sb = new StringBuilder();
        w34 w34Var = this.b;
        Optional optionalC = w34Var.c();
        for (int i2 = w34Var.j; i2 < i && w34Var.d() == 32; i2++) {
            w34Var.b(1);
        }
        while (true) {
            Optional optionalW = w();
            if (!optionalW.isPresent()) {
                return new zp3(-1, sb.toString(), optionalC);
            }
            sb.append((String) optionalW.get());
            optionalC = w34Var.c();
            for (int i3 = w34Var.j; i3 < i && w34Var.d() == 32; i3++) {
                w34Var.b(1);
            }
        }
    }

    public final f80 t(int i) {
        w34 w34Var = this.b;
        Optional optionalC = w34Var.c();
        w34Var.b(1);
        int i2 = 0;
        while (p30.c.c(w34Var.e(i2))) {
            i2++;
        }
        return new f80(i, w34Var.g(i2), optionalC, w34Var.c());
    }

    public final String u(Optional optional) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            w34 w34Var = this.b;
            String strF = w34Var.f(3);
            if (("---".equals(strF) || "...".equals(strF)) && p30.e.b(w34Var.e(3))) {
                s53.p("while scanning a quoted scalar", optional, "found unexpected document separator", w34Var.c());
                return null;
            }
            while (" \t".indexOf(w34Var.d()) != -1) {
                w34Var.b(1);
            }
            Optional optionalW = w();
            if (!optionalW.isPresent()) {
                return sb.toString();
            }
            sb.append((String) optionalW.get());
        }
    }

    public final void v(boolean z, Optional optional, StringBuilder sb) {
        w34 w34Var;
        while (true) {
            int i = 0;
            while (true) {
                p30 p30Var = p30.e;
                w34Var = this.b;
                int iE = w34Var.e(i);
                if (p30Var.b(iE) || "'\"\\".indexOf(iE) != -1) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != 0) {
                sb.append(w34Var.g(i));
            }
            int iD = w34Var.d();
            if (!z && iD == 39 && w34Var.e(1) == 39) {
                sb.append('\'');
                w34Var.b(2);
            } else if ((z && iD == 39) || (!z && "\"\\".indexOf(iD) != -1)) {
                sb.appendCodePoint(iD);
                w34Var.b(1);
            } else {
                if (!z || iD != 92) {
                    return;
                }
                w34Var.b(1);
                int iD2 = w34Var.d();
                if (!Character.isSupplementaryCodePoint(iD2)) {
                    Map map = p30.i;
                    char c = (char) iD2;
                    if (map.containsKey(Character.valueOf(c))) {
                        sb.append((String) map.get(Character.valueOf(c)));
                        w34Var.b(1);
                    }
                }
                if (!Character.isSupplementaryCodePoint(iD2)) {
                    Map map2 = p30.j;
                    char c2 = (char) iD2;
                    if (map2.containsKey(Character.valueOf(c2))) {
                        int iIntValue = ((Integer) map2.get(Character.valueOf(c2))).intValue();
                        w34Var.b(1);
                        String strF = w34Var.f(iIntValue);
                        if (B0.matcher(strF).find()) {
                            s53.p("while scanning a double-quoted scalar", optional, "expected escape sequence of " + iIntValue + " hexadecimal numbers, but found: " + strF, w34Var.c());
                            return;
                        }
                        try {
                            sb.appendCodePoint(Integer.parseInt(strF, 16));
                            w34Var.b(iIntValue);
                        } catch (IllegalArgumentException unused) {
                            s53.p("while scanning a double-quoted scalar", optional, "found unknown escape character ".concat(strF), w34Var.c());
                            return;
                        }
                    }
                }
                if (9 == iD2) {
                    sb.append('\t');
                    w34Var.b(1);
                } else {
                    if (!w().isPresent()) {
                        s53.p("while scanning a double-quoted scalar", optional, fw.t(iD2, "found unknown escape character ", String.valueOf(Character.toChars(iD2)), "(", ")"), w34Var.c());
                        return;
                    }
                    sb.append(u(optional));
                }
            }
        }
    }

    public final Optional w() {
        w34 w34Var = this.b;
        int iD = w34Var.d();
        if (iD != 13 && iD != 10 && iD != 133) {
            return Optional.empty();
        }
        if (iD == 13 && 10 == w34Var.e(1)) {
            w34Var.b(2);
        } else {
            w34Var.b(1);
        }
        return Optional.of("\n");
    }

    public final String x(String str, Optional optional) {
        w34 w34Var = this.b;
        int iD = w34Var.d();
        if (iD != 33) {
            s53.p("while scanning a ".concat(str), optional, fw.t(iD, "expected '!', but found ", String.valueOf(Character.toChars(iD)), "(", ")"), w34Var.c());
            return null;
        }
        int i = 1;
        int iE = w34Var.e(1);
        if (iE != 32) {
            int i2 = 1;
            while (p30.h.b(iE)) {
                i2++;
                iE = w34Var.e(i2);
            }
            if (iE != 33) {
                w34Var.b(i2);
                s53.p("while scanning a ".concat(str), optional, fw.t(iE, "expected '!', but found ", String.valueOf(Character.toChars(iE)), "(", ")"), w34Var.c());
                return null;
            }
            i = 1 + i2;
        }
        return w34Var.g(i);
    }

    public final String y(String str, p30 p30Var, Optional optional) {
        StringBuilder sb = new StringBuilder();
        w34 w34Var = this.b;
        int iE = w34Var.e(0);
        int i = 0;
        while (p30Var.b(iE)) {
            if (iE == 37) {
                sb.append(w34Var.g(i));
                int i2 = 1;
                while (w34Var.e(i2 * 3) == 37) {
                    i2++;
                }
                Optional optionalC = w34Var.c();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2);
                while (w34Var.d() == 37) {
                    w34Var.b(1);
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(w34Var.f(2), 16));
                        w34Var.b(2);
                    } catch (NumberFormatException unused) {
                        int iD = w34Var.d();
                        String strValueOf = String.valueOf(Character.toChars(iD));
                        int iE2 = w34Var.e(1);
                        String strValueOf2 = String.valueOf(Character.toChars(iE2));
                        s53.p("while scanning a ".concat(str), optional, "expected URI escape sequence of 2 hexadecimal numbers, but found " + strValueOf + "(" + iD + ") and " + strValueOf2 + "(" + iE2 + ")", w34Var.c());
                        return null;
                    }
                }
                try {
                    sb.append(dn4.a.decode(byteBufferAllocate).toString());
                    i = 0;
                } catch (CharacterCodingException e) {
                    s53.p("while scanning a ".concat(str), optional, ha0.n("expected URI in UTF-8: ", e.getMessage()), optionalC);
                    return null;
                }
            } else {
                i++;
            }
            iE = w34Var.e(i);
        }
        if (i != 0) {
            sb.append(w34Var.g(i));
        }
        if (sb.length() != 0) {
            return sb.toString();
        }
        s53.p("while scanning a ".concat(str), optional, fw.t(iE, "expected URI, but found ", String.valueOf(Character.toChars(iE)), "(", ")"), w34Var.c());
        return null;
    }

    public final Integer z(Optional optional) {
        w34 w34Var = this.b;
        int iD = w34Var.d();
        if (!Character.isDigit(iD)) {
            s53.p("while scanning a directive", optional, fw.t(iD, "expected a digit, but found ", String.valueOf(Character.toChars(iD)), "(", ")"), w34Var.c());
            return null;
        }
        int i = 0;
        while (Character.isDigit(w34Var.e(i))) {
            i++;
        }
        String strG = w34Var.g(i);
        if (i <= 3) {
            return Integer.valueOf(Integer.parseInt(strG));
        }
        s53.p("while scanning a YAML directive", optional, "found a number which cannot represent a valid version: ".concat(strG), w34Var.c());
        return null;
    }
}
