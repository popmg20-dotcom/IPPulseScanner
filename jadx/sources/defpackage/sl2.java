package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sl2 implements gq3 {
    public static final int[] n = new int[0];
    public static final Unsafe o;
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final d1 e;
    public final boolean f;
    public final int[] g;
    public final int h;
    public final int i;
    public final qr2 j;
    public final wb2 k;
    public final em4 l;
    public final tg2 m;

    static {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new qm4(1));
        } catch (Throwable unused) {
            unsafe = null;
        }
        o = unsafe;
    }

    public sl2(int[] iArr, Object[] objArr, int i, int i2, d1 d1Var, int[] iArr2, int i3, int i4, qr2 qr2Var, wb2 wb2Var, em4 em4Var, q91 q91Var, tg2 tg2Var) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.f = d1Var instanceof co1;
        this.g = iArr2;
        this.h = i3;
        this.i = i4;
        this.j = qr2Var;
        this.k = wb2Var;
        this.l = em4Var;
        this.e = d1Var;
        this.m = tg2Var;
    }

    public static Field F(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbD = fw.D("Field ", str, " for ");
            sbD.append(cls.getName());
            sbD.append(" not found. Known fields are ");
            sbD.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbD.toString());
        }
    }

    public static int I(int i) {
        return (i & 267386880) >>> 20;
    }

    public static boolean p(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof co1) {
            return ((co1) obj).g();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x028b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.sl2 w(defpackage.qd3 r32, defpackage.qr2 r33, defpackage.wb2 r34, defpackage.em4 r35, defpackage.q91 r36, defpackage.tg2 r37) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl2.w(qd3, qr2, wb2, em4, q91, tg2):sl2");
    }

    public static long x(int i) {
        return i & 1048575;
    }

    public static int y(long j, Object obj) {
        return ((Integer) xm4.h(obj, j)).intValue();
    }

    public static long z(long j, Object obj) {
        return ((Long) xm4.h(obj, j)).longValue();
    }

    public final int A(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        int[] iArr = this.a;
        int length = (iArr.length / 3) - 1;
        int i2 = 0;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final void B(Object obj, long j, r02 r02Var, gq3 gq3Var, p91 p91Var) throws r12 {
        int iU;
        this.k.getClass();
        h12 h12VarA = wb2.a(j, obj);
        p60 p60Var = (p60) r02Var.d;
        int i = r02Var.a;
        if ((i & 7) != 3) {
            throw t12.b();
        }
        do {
            co1 co1VarI = gq3Var.i();
            r02Var.g(co1VarI, gq3Var, p91Var);
            gq3Var.b(co1VarI);
            ((x93) h12VarA).add(co1VarI);
            if (p60Var.c() || r02Var.c != 0) {
                return;
            } else {
                iU = p60Var.u();
            }
        } while (iU == i);
        r02Var.c = iU;
    }

    public final void C(Object obj, int i, r02 r02Var, gq3 gq3Var, p91 p91Var) throws t12 {
        int iU;
        this.k.getClass();
        h12 h12VarA = wb2.a(i & 1048575, obj);
        p60 p60Var = (p60) r02Var.d;
        int i2 = r02Var.a;
        if ((i2 & 7) != 2) {
            throw t12.b();
        }
        do {
            co1 co1VarI = gq3Var.i();
            r02Var.h(co1VarI, gq3Var, p91Var);
            gq3Var.b(co1VarI);
            ((x93) h12VarA).add(co1VarI);
            if (p60Var.c() || r02Var.c != 0) {
                return;
            } else {
                iU = p60Var.u();
            }
        } while (iU == i2);
        r02Var.c = iU;
    }

    public final void D(int i, r02 r02Var, Object obj) throws r12 {
        p60 p60Var = (p60) r02Var.d;
        if ((536870912 & i) != 0) {
            r02Var.C(2);
            xm4.o(obj, i & 1048575, p60Var.t());
        } else if (!this.f) {
            xm4.o(obj, i & 1048575, r02Var.j());
        } else {
            r02Var.C(2);
            xm4.o(obj, i & 1048575, p60Var.s());
        }
    }

    public final void E(int i, r02 r02Var, Object obj) throws r12 {
        boolean z = (536870912 & i) != 0;
        wb2 wb2Var = this.k;
        if (z) {
            wb2Var.getClass();
            r02Var.x(wb2.a(i & 1048575, obj), true);
        } else {
            wb2Var.getClass();
            r02Var.x(wb2.a(i & 1048575, obj), false);
        }
    }

    public final void G(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        xm4.m(obj, j, (1 << (i2 >>> 20)) | xm4.f(obj, j));
    }

    public final void H(int i, int i2, Object obj) {
        xm4.m(obj, this.a[i2 + 2] & 1048575, i);
    }

    public final int J(int i) {
        return this.a[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl2.a(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl2.b(java.lang.Object):void");
    }

    @Override // defpackage.gq3
    public final boolean c(Object obj) {
        int i;
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.h) {
            int i7 = this.g[i6];
            int[] iArr = this.a;
            int i8 = iArr[i7];
            int iJ = J(i7);
            int i9 = iArr[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = o.getInt(obj, i10);
                }
                i2 = i7;
                i3 = i5;
                i = i10;
            } else {
                int i12 = i5;
                i = i4;
                i2 = i7;
                i3 = i12;
            }
            if ((268435456 & iJ) == 0 || o(obj, i2, i, i3, i11)) {
                int I = I(iJ);
                if (I != 9 && I != 17) {
                    if (I != 27) {
                        if (I == 60 || I == 68) {
                            if (!q(i8, i2, obj) || m(i2).c(xm4.h(obj, iJ & 1048575))) {
                                i6++;
                                i4 = i;
                                i5 = i3;
                            }
                        } else if (I != 49) {
                            if (I != 50) {
                                continue;
                            } else {
                                Object objH = xm4.h(obj, iJ & 1048575);
                                this.m.getClass();
                                sg2 sg2Var = (sg2) objH;
                                if (sg2Var.isEmpty()) {
                                    continue;
                                } else {
                                    if (((bw4) ((jg2) this.b[(i2 / 3) * 2]).a.z).b != dw4.MESSAGE) {
                                        continue;
                                    } else {
                                        gq3 gq3VarA = null;
                                        for (Object obj2 : sg2Var.values()) {
                                            if (gq3VarA == null) {
                                                gq3VarA = v93.c.a(obj2.getClass());
                                            }
                                            if (!gq3VarA.c(obj2)) {
                                            }
                                        }
                                    }
                                }
                            }
                            i6++;
                            i4 = i;
                            i5 = i3;
                        }
                    }
                    List list = (List) xm4.h(obj, iJ & 1048575);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        gq3 gq3VarM = m(i2);
                        for (int i13 = 0; i13 < list.size(); i13++) {
                            if (gq3VarM.c(list.get(i13))) {
                            }
                        }
                    }
                    i6++;
                    i4 = i;
                    i5 = i3;
                } else if (!o(obj, i2, i, i3, i11) || m(i2).c(xm4.h(obj, iJ & 1048575))) {
                    i6++;
                    i4 = i;
                    i5 = i3;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.gq3
    public final void d(Object obj, zf2 zf2Var) throws IOException {
        int i;
        int i2;
        int i3;
        boolean z;
        sl2 sl2Var = this;
        zf2Var.getClass();
        r60 r60Var = (r60) zf2Var.f;
        int[] iArr = sl2Var.a;
        int length = iArr.length;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int iJ = sl2Var.J(i6);
            int i8 = iArr[i6];
            int I = I(iJ);
            Unsafe unsafe = o;
            if (I <= 17) {
                int i9 = iArr[i6 + 2];
                i = 1;
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i7 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                int i11 = 1 << (i9 >>> 20);
                i2 = iJ;
                i3 = i11;
            } else {
                i = 1;
                i2 = iJ;
                i3 = 0;
            }
            long j = i2 & i4;
            switch (I) {
                case 0:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.t(i8, Double.doubleToRawLongBits(xm4.c.c(j, obj)));
                    }
                    break;
                case 1:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.r(i8, Float.floatToRawIntBits(xm4.c.d(j, obj)));
                    }
                    sl2Var = this;
                    break;
                case 2:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.E(i8, unsafe.getLong(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 3:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.E(i8, unsafe.getLong(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 4:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.v(i8, unsafe.getInt(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 5:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.t(i8, unsafe.getLong(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 6:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.r(i8, unsafe.getInt(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 7:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.o(i8, xm4.c.a(j, obj));
                    }
                    sl2Var = this;
                    break;
                case 8:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof String) {
                            r60Var.z(i8, (String) object);
                        } else {
                            r60Var.p(i8, (au) object);
                        }
                    }
                    sl2Var = this;
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.y(i8, (d1) unsafe.getObject(obj, j), sl2Var.m(i6));
                    }
                    break;
                case 10:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.p(i8, (au) unsafe.getObject(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 11:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.C(i8, unsafe.getInt(obj, j));
                    }
                    sl2Var = this;
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.v(i8, unsafe.getInt(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 13:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.r(i8, unsafe.getInt(obj, j));
                    }
                    sl2Var = this;
                    break;
                case 14:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        r60Var.t(i8, unsafe.getLong(obj, j));
                    }
                    sl2Var = this;
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        int i12 = unsafe.getInt(obj, j);
                        r60Var.C(i8, (i12 >> 31) ^ (i12 << 1));
                    }
                    sl2Var = this;
                    break;
                case 16:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        long j2 = unsafe.getLong(obj, j);
                        r60Var.E(i8, (j2 >> 63) ^ (j2 << 1));
                    }
                    sl2Var = this;
                    break;
                case 17:
                    if (sl2Var.o(obj, i6, i5, i7, i3)) {
                        zf2Var.r0(i8, unsafe.getObject(obj, j), sl2Var.m(i6));
                    }
                    break;
                case 18:
                    hq3.n(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 19:
                    hq3.r(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 20:
                    hq3.t(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 21:
                    hq3.z(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 22:
                    hq3.s(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 23:
                    hq3.q(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 24:
                    hq3.p(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 25:
                    hq3.m(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 26:
                    int i13 = iArr[i6];
                    List list = (List) unsafe.getObject(obj, j);
                    Class cls = hq3.a;
                    if (list != null && !list.isEmpty()) {
                        for (int i14 = 0; i14 < list.size(); i14++) {
                            r60Var.z(i13, (String) list.get(i14));
                        }
                    }
                    break;
                case 27:
                    int i15 = iArr[i6];
                    List list2 = (List) unsafe.getObject(obj, j);
                    gq3 gq3VarM = sl2Var.m(i6);
                    Class cls2 = hq3.a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i16 = 0; i16 < list2.size(); i16++) {
                            r60Var.y(i15, (d1) list2.get(i16), gq3VarM);
                        }
                    }
                    break;
                case 28:
                    int i17 = iArr[i6];
                    List list3 = (List) unsafe.getObject(obj, j);
                    Class cls3 = hq3.a;
                    if (list3 != null && !list3.isEmpty()) {
                        for (int i18 = 0; i18 < list3.size(); i18++) {
                            r60Var.p(i17, (au) list3.get(i18));
                        }
                    }
                    break;
                case 29:
                    z = false;
                    hq3.y(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 30:
                    z = false;
                    hq3.o(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 31:
                    z = false;
                    hq3.u(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 32:
                    z = false;
                    hq3.v(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 33:
                    z = false;
                    hq3.w(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 34:
                    z = false;
                    hq3.x(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, false);
                    break;
                case 35:
                    hq3.n(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 36:
                    hq3.r(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 37:
                    hq3.t(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 38:
                    hq3.z(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 39:
                    hq3.s(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 40:
                    hq3.q(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 41:
                    hq3.p(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 42:
                    hq3.m(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 43:
                    hq3.y(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 44:
                    hq3.o(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 45:
                    hq3.u(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 46:
                    hq3.v(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case 47:
                    hq3.w(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, i);
                    break;
                case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                    hq3.x(iArr[i6], (List) unsafe.getObject(obj, j), zf2Var, true);
                    break;
                case 49:
                    int i19 = iArr[i6];
                    List list4 = (List) unsafe.getObject(obj, j);
                    gq3 gq3VarM2 = sl2Var.m(i6);
                    Class cls4 = hq3.a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            zf2Var.r0(i19, list4.get(i20), gq3VarM2);
                        }
                    }
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j);
                    if (object2 != null) {
                        int i21 = 2;
                        Object obj2 = sl2Var.b[(i6 / 3) * 2];
                        sl2Var.m.getClass();
                        n02 n02Var = ((jg2) obj2).a;
                        for (Map.Entry entry : ((sg2) object2).entrySet()) {
                            r60Var.B(i8, i21);
                            r60Var.D(jg2.a(n02Var, entry.getKey(), entry.getValue()));
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            ld1.b(r60Var, (bw4) n02Var.f, i, key);
                            i21 = 2;
                            ld1.b(r60Var, (bw4) n02Var.z, 2, value);
                            i = 1;
                        }
                    }
                    break;
                case 51:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.t(i8, Double.doubleToRawLongBits(((Double) xm4.h(obj, j)).doubleValue()));
                    }
                    break;
                case 52:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.r(i8, Float.floatToRawIntBits(((Float) xm4.h(obj, j)).floatValue()));
                    }
                    break;
                case 53:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.E(i8, z(j, obj));
                    }
                    break;
                case 54:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.E(i8, z(j, obj));
                    }
                    break;
                case 55:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.v(i8, y(j, obj));
                    }
                    break;
                case 56:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.t(i8, z(j, obj));
                    }
                    break;
                case 57:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.r(i8, y(j, obj));
                    }
                    break;
                case 58:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.o(i8, ((Boolean) xm4.h(obj, j)).booleanValue());
                    }
                    break;
                case 59:
                    if (sl2Var.q(i8, i6, obj)) {
                        Object object3 = unsafe.getObject(obj, j);
                        if (object3 instanceof String) {
                            r60Var.z(i8, (String) object3);
                        } else {
                            r60Var.p(i8, (au) object3);
                        }
                    }
                    break;
                case 60:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.y(i8, (d1) unsafe.getObject(obj, j), sl2Var.m(i6));
                    }
                    break;
                case 61:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.p(i8, (au) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.C(i8, y(j, obj));
                    }
                    break;
                case 63:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.v(i8, y(j, obj));
                    }
                    break;
                case 64:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.r(i8, y(j, obj));
                    }
                    break;
                case 65:
                    if (sl2Var.q(i8, i6, obj)) {
                        r60Var.t(i8, z(j, obj));
                    }
                    break;
                case 66:
                    if (sl2Var.q(i8, i6, obj)) {
                        int iY = y(j, obj);
                        r60Var.C(i8, (iY >> 31) ^ (iY << 1));
                    }
                    break;
                case 67:
                    if (sl2Var.q(i8, i6, obj)) {
                        long jZ = z(j, obj);
                        r60Var.E(i8, (jZ << i) ^ (jZ >> 63));
                    }
                    break;
                case 68:
                    if (sl2Var.q(i8, i6, obj)) {
                        zf2Var.r0(i8, unsafe.getObject(obj, j), sl2Var.m(i6));
                    }
                    break;
            }
            i6 += 3;
            i4 = 1048575;
        }
        sl2Var.l.getClass();
        ((co1) obj).unknownFields.d(zf2Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(defpackage.co1 r12, defpackage.co1 r13) {
        /*
            Method dump skipped, instruction units count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl2.e(co1, co1):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7 A[PHI: r3
      0x00d7: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x01f0, B:41:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(defpackage.co1 r12) {
        /*
            Method dump skipped, instruction units count: 746
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl2.f(co1):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x01cd  */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(defpackage.co1 r17) {
        /*
            Method dump skipped, instruction units count: 1854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl2.g(co1):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x082a A[Catch: all -> 0x0500, TryCatch #1 {all -> 0x0500, blocks: (B:158:0x0825, B:160:0x082a, B:161:0x082f, B:114:0x04fb, B:117:0x0503, B:118:0x051b, B:119:0x0533, B:120:0x054b, B:121:0x0563, B:122:0x057b, B:123:0x0593, B:124:0x05ab, B:125:0x05c3, B:126:0x05eb, B:127:0x060b, B:128:0x062b, B:129:0x064c, B:130:0x066d, B:131:0x0690, B:132:0x06b0, B:133:0x06c9, B:134:0x06f1, B:135:0x0702, B:136:0x0724, B:137:0x0745, B:138:0x0766, B:139:0x0786, B:140:0x07a6, B:141:0x07c5, B:142:0x07e7, B:148:0x0809), top: B:181:0x0825 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0850 A[LOOP:3: B:170:0x084e->B:171:0x0850, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0835 A[SYNTHETIC] */
    @Override // defpackage.gq3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(java.lang.Object r21, defpackage.r02 r22, defpackage.p91 r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl2.h(java.lang.Object, r02, p91):void");
    }

    @Override // defpackage.gq3
    public final co1 i() {
        this.j.getClass();
        return ((co1) this.e).i();
    }

    public final boolean j(co1 co1Var, co1 co1Var2, int i) {
        return n(i, co1Var) == n(i, co1Var2);
    }

    public final void k(int i, Object obj, Object obj2) {
        int i2 = this.a[i];
        if (xm4.h(obj, J(i) & 1048575) == null) {
            return;
        }
        l(i);
    }

    public final void l(int i) {
        if (this.b[((i / 3) * 2) + 1] == null) {
            return;
        }
        st4.n();
    }

    public final gq3 m(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.b;
        gq3 gq3Var = (gq3) objArr[i2];
        if (gq3Var != null) {
            return gq3Var;
        }
        gq3 gq3VarA = v93.c.a((Class) objArr[i2 + 1]);
        objArr[i2] = gq3VarA;
        return gq3VarA;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(int r8, java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl2.n(int, java.lang.Object):boolean");
    }

    public final boolean o(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? n(i, obj) : (i3 & i4) != 0;
    }

    public final boolean q(int i, int i2, Object obj) {
        return xm4.f(obj, (long) (this.a[i2 + 2] & 1048575)) == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009d, code lost:
    
        r9.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a0, code lost:
    
        r10.d(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.lang.Object r8, int r9, java.lang.Object r10, defpackage.p91 r11, defpackage.r02 r12) throws defpackage.r12 {
        /*
            r7 = this;
            int r9 = r7.J(r9)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r0
            long r0 = (long) r9
            java.lang.Object r9 = defpackage.xm4.h(r8, r0)
            tg2 r7 = r7.m
            if (r9 != 0) goto L1e
            r7.getClass()
            sg2 r9 = defpackage.sg2.f
            sg2 r9 = r9.b()
            defpackage.xm4.o(r8, r0, r9)
            goto L35
        L1e:
            r7.getClass()
            r2 = r9
            sg2 r2 = (defpackage.sg2) r2
            boolean r2 = r2.b
            if (r2 != 0) goto L35
            sg2 r2 = defpackage.sg2.f
            sg2 r2 = r2.b()
            defpackage.tg2.a(r2, r9)
            defpackage.xm4.o(r8, r0, r2)
            r9 = r2
        L35:
            r7.getClass()
            sg2 r9 = (defpackage.sg2) r9
            jg2 r10 = (defpackage.jg2) r10
            n02 r7 = r10.a
            r8 = 2
            r12.C(r8)
            java.lang.Object r10 = r12.d
            p60 r10 = (defpackage.p60) r10
            int r0 = r10.v()
            int r0 = r10.e(r0)
            java.lang.Object r1 = r7.A
            java.lang.String r2 = ""
            r3 = r1
        L53:
            int r4 = r12.f()     // Catch: java.lang.Throwable -> L77
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L9d
            boolean r5 = r10.c()     // Catch: java.lang.Throwable -> L77
            if (r5 == 0) goto L63
            goto L9d
        L63:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L86
            if (r4 == r8) goto L79
            boolean r4 = r12.D()     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
            if (r4 == 0) goto L71
            goto L53
        L71:
            t12 r4 = new t12     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
            throw r4     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
        L77:
            r7 = move-exception
            goto La4
        L79:
            java.lang.Object r4 = r7.z     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
            bw4 r4 = (defpackage.bw4) r4     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
            java.lang.Class r5 = r1.getClass()     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
            java.lang.Object r3 = r12.n(r4, r5, r11)     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
            goto L53
        L86:
            java.lang.Object r4 = r7.f     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
            bw4 r4 = (defpackage.bw4) r4     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
            r5 = 0
            java.lang.Object r2 = r12.n(r4, r5, r5)     // Catch: java.lang.Throwable -> L77 defpackage.r12 -> L90
            goto L53
        L90:
            boolean r4 = r12.D()     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto L97
            goto L53
        L97:
            t12 r7 = new t12     // Catch: java.lang.Throwable -> L77
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L77
            throw r7     // Catch: java.lang.Throwable -> L77
        L9d:
            r9.put(r2, r3)     // Catch: java.lang.Throwable -> L77
            r10.d(r0)
            return
        La4:
            r10.d(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl2.r(java.lang.Object, int, java.lang.Object, p91, r02):void");
    }

    public final void s(int i, Object obj, Object obj2) {
        if (n(i, obj2)) {
            long J = J(i) & 1048575;
            Unsafe unsafe = o;
            Object object = unsafe.getObject(obj2, J);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.a[i] + " is present but null: " + obj2);
            }
            gq3 gq3VarM = m(i);
            if (!n(i, obj)) {
                if (p(object)) {
                    co1 co1VarI = gq3VarM.i();
                    gq3VarM.a(co1VarI, object);
                    unsafe.putObject(obj, J, co1VarI);
                } else {
                    unsafe.putObject(obj, J, object);
                }
                G(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, J);
            if (!p(object2)) {
                co1 co1VarI2 = gq3VarM.i();
                gq3VarM.a(co1VarI2, object2);
                unsafe.putObject(obj, J, co1VarI2);
                object2 = co1VarI2;
            }
            gq3VarM.a(object2, object);
        }
    }

    public final void t(int i, Object obj, Object obj2) {
        int[] iArr = this.a;
        int i2 = iArr[i];
        if (q(i2, i, obj2)) {
            long J = J(i) & 1048575;
            Unsafe unsafe = o;
            Object object = unsafe.getObject(obj2, J);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2);
            }
            gq3 gq3VarM = m(i);
            if (!q(i2, i, obj)) {
                if (p(object)) {
                    co1 co1VarI = gq3VarM.i();
                    gq3VarM.a(co1VarI, object);
                    unsafe.putObject(obj, J, co1VarI);
                } else {
                    unsafe.putObject(obj, J, object);
                }
                H(i2, i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, J);
            if (!p(object2)) {
                co1 co1VarI2 = gq3VarM.i();
                gq3VarM.a(co1VarI2, object2);
                unsafe.putObject(obj, J, co1VarI2);
                object2 = co1VarI2;
            }
            gq3VarM.a(object2, object);
        }
    }

    public final Object u(int i, Object obj) {
        gq3 gq3VarM = m(i);
        long J = J(i) & 1048575;
        if (!n(i, obj)) {
            return gq3VarM.i();
        }
        Object object = o.getObject(obj, J);
        if (p(object)) {
            return object;
        }
        co1 co1VarI = gq3VarM.i();
        if (object != null) {
            gq3VarM.a(co1VarI, object);
        }
        return co1VarI;
    }

    public final Object v(int i, int i2, Object obj) {
        gq3 gq3VarM = m(i2);
        if (!q(i, i2, obj)) {
            return gq3VarM.i();
        }
        Object object = o.getObject(obj, J(i2) & 1048575);
        if (p(object)) {
            return object;
        }
        co1 co1VarI = gq3VarM.i();
        if (object != null) {
            gq3VarM.a(co1VarI, object);
        }
        return co1VarI;
    }
}
