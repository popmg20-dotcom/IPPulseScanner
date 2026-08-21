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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(defpackage.qp3 r19) {
        /*
            Method dump skipped, instruction units count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aq3.e(qp3):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instruction units count: 1918
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aq3.j():void");
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
