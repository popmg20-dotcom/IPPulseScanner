package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Process;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.WindowInsetsAnimation;
import androidx.camera.core.internal.compat.quirk.ImageCaptureFailedForSpecificCombinationQuirk;
import androidx.camera.core.internal.compat.quirk.PreviewGreenTintQuirk;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.gms.common.api.Status;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.text.BreakIterator;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class e24 implements s41, om1, yj4, pk3, mu2, hw4 {
    public final /* synthetic */ int b;
    public Object f;
    public Object z;

    public e24(int i) {
        this.b = i;
        switch (i) {
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                new ReentrantLock();
                this.f = new ConcurrentHashMap();
                this.z = new ReferenceQueue();
                break;
            case 16:
                this.f = new xw3(0);
                this.z = new ff2();
                break;
            case 26:
                this.f = DesugarCollections.synchronizedMap(new WeakHashMap());
                this.z = DesugarCollections.synchronizedMap(new WeakHashMap());
                break;
            case 28:
                this.f = new HashMap();
                this.z = new l25(6);
                l25 l25Var = new l25(0);
                ArrayList arrayList = l25Var.a;
                arrayList.add(a35.BITWISE_AND);
                arrayList.add(a35.BITWISE_LEFT_SHIFT);
                arrayList.add(a35.BITWISE_NOT);
                arrayList.add(a35.BITWISE_OR);
                arrayList.add(a35.BITWISE_RIGHT_SHIFT);
                arrayList.add(a35.BITWISE_UNSIGNED_RIGHT_SHIFT);
                arrayList.add(a35.BITWISE_XOR);
                J(l25Var);
                l25 l25Var2 = new l25(1);
                ArrayList arrayList2 = l25Var2.a;
                arrayList2.add(a35.EQUALS);
                arrayList2.add(a35.GREATER_THAN);
                arrayList2.add(a35.GREATER_THAN_EQUALS);
                arrayList2.add(a35.IDENTITY_EQUALS);
                arrayList2.add(a35.IDENTITY_NOT_EQUALS);
                arrayList2.add(a35.LESS_THAN);
                arrayList2.add(a35.LESS_THAN_EQUALS);
                arrayList2.add(a35.NOT_EQUALS);
                J(l25Var2);
                l25 l25Var3 = new l25(2);
                ArrayList arrayList3 = l25Var3.a;
                arrayList3.add(a35.APPLY);
                arrayList3.add(a35.BLOCK);
                arrayList3.add(a35.BREAK);
                arrayList3.add(a35.CASE);
                arrayList3.add(a35.DEFAULT);
                arrayList3.add(a35.CONTINUE);
                arrayList3.add(a35.DEFINE_FUNCTION);
                arrayList3.add(a35.FN);
                arrayList3.add(a35.IF);
                arrayList3.add(a35.QUOTE);
                arrayList3.add(a35.RETURN);
                arrayList3.add(a35.SWITCH);
                arrayList3.add(a35.TERNARY);
                J(l25Var3);
                l25 l25Var4 = new l25(3);
                ArrayList arrayList4 = l25Var4.a;
                arrayList4.add(a35.AND);
                arrayList4.add(a35.NOT);
                arrayList4.add(a35.OR);
                J(l25Var4);
                l25 l25Var5 = new l25(4);
                ArrayList arrayList5 = l25Var5.a;
                arrayList5.add(a35.FOR_IN);
                arrayList5.add(a35.FOR_IN_CONST);
                arrayList5.add(a35.FOR_IN_LET);
                arrayList5.add(a35.FOR_LET);
                arrayList5.add(a35.FOR_OF);
                arrayList5.add(a35.FOR_OF_CONST);
                arrayList5.add(a35.FOR_OF_LET);
                arrayList5.add(a35.WHILE);
                J(l25Var5);
                l25 l25Var6 = new l25(5);
                ArrayList arrayList6 = l25Var6.a;
                arrayList6.add(a35.ADD);
                arrayList6.add(a35.DIVIDE);
                arrayList6.add(a35.MODULUS);
                arrayList6.add(a35.MULTIPLY);
                arrayList6.add(a35.NEGATE);
                arrayList6.add(a35.POST_DECREMENT);
                arrayList6.add(a35.POST_INCREMENT);
                arrayList6.add(a35.PRE_DECREMENT);
                arrayList6.add(a35.PRE_INCREMENT);
                arrayList6.add(a35.SUBTRACT);
                J(l25Var6);
                l25 l25Var7 = new l25(7);
                ArrayList arrayList7 = l25Var7.a;
                arrayList7.add(a35.ASSIGN);
                arrayList7.add(a35.CONST);
                arrayList7.add(a35.CREATE_ARRAY);
                arrayList7.add(a35.CREATE_OBJECT);
                arrayList7.add(a35.EXPRESSION_LIST);
                arrayList7.add(a35.GET);
                arrayList7.add(a35.GET_INDEX);
                arrayList7.add(a35.GET_PROPERTY);
                arrayList7.add(a35.NULL);
                arrayList7.add(a35.SET_PROPERTY);
                arrayList7.add(a35.TYPEOF);
                arrayList7.add(a35.UNDEFINED);
                arrayList7.add(a35.VAR);
                J(l25Var7);
                break;
            default:
                this.f = (ImageCaptureFailedForSpecificCombinationQuirk) vt0.a.z(ImageCaptureFailedForSpecificCombinationQuirk.class);
                this.z = (PreviewGreenTintQuirk) vt0.a.z(PreviewGreenTintQuirk.class);
                break;
        }
    }

    public static void A(lu2 lu2Var, String str, File file) throws IOException {
        dv1 dv1Var = new dv1();
        dv1Var.c(null, str);
        ck0 ck0Var = new ck0(lu2Var, dv1Var.a());
        cj3 cj3Var = ej3.a;
        uh3 uh3Var = pj2.e;
        kk3 kk3VarB = ck0Var.b(new ig0(3, new bj3(p95.n(HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE), file), ck0Var));
        try {
            ck0.a(kk3VarB);
            kk3VarB.close();
        } finally {
        }
    }

    public static void g(lu2 lu2Var, String str, am1 am1Var) {
        xg3 xg3Var = new xg3();
        try {
            dv1 dv1Var = new dv1();
            dv1Var.c(null, str);
            new ck0(lu2Var, dv1Var.a()).f(0, new k83[0], new ed(19, am1Var, xg3Var));
        } catch (rs2 unused) {
            am1Var.g(Boolean.FALSE);
            xg3Var.b = true;
        }
        if (xg3Var.b) {
            return;
        }
        am1Var.g(Boolean.FALSE);
    }

    public static void n(lu2 lu2Var, String str, gj gjVar) throws IOException {
        str.getClass();
        dv1 dv1Var = new dv1();
        dv1Var.c(null, str);
        ck0 ck0Var = new ck0(lu2Var, dv1Var.a());
        kk3 kk3VarB = ck0Var.b(new ak0(ck0Var, 1));
        try {
            ck0.a(kk3VarB);
            gjVar.g(kk3VarB.Z.x().E0());
            kk3VarB.close();
        } finally {
        }
    }

    public h24 B(vw4 vw4Var) {
        h24 h24VarD;
        vw4Var.getClass();
        synchronized (this.z) {
            h24VarD = ((wn1) this.f).D(vw4Var);
        }
        return h24VarD;
    }

    public void C(rg3 rg3Var) {
        fq4 fq4Var = (fq4) ((xw3) this.f).get(rg3Var);
        if (fq4Var == null) {
            return;
        }
        fq4Var.a &= -2;
    }

    public void D(rg3 rg3Var) {
        ff2 ff2Var = (ff2) this.z;
        int iJ = ff2Var.j() - 1;
        while (true) {
            if (iJ < 0) {
                break;
            }
            if (rg3Var == ff2Var.k(iJ)) {
                Object[] objArr = ff2Var.z;
                Object obj = objArr[iJ];
                Object obj2 = gb4.e;
                if (obj != obj2) {
                    objArr[iJ] = obj2;
                    ff2Var.b = true;
                }
            } else {
                iJ--;
            }
        }
        fq4 fq4Var = (fq4) ((xw3) this.f).remove(rg3Var);
        if (fq4Var != null) {
            fq4Var.a = 0;
            fq4Var.b = null;
            fq4Var.c = null;
            fq4.d.c(fq4Var);
        }
    }

    public void E(h24 h24Var, p84 p84Var) {
        h24Var.getClass();
        ih4 ih4Var = (ih4) this.z;
        ((la) ih4Var.a).execute(new b0(19, this, h24Var, p84Var));
    }

    public void F(h24 h24Var, int i) {
        h24Var.getClass();
        ih4 ih4Var = (ih4) this.z;
        ((la) ih4Var.a).execute(new o34((n53) this.f, h24Var, false, i));
    }

    public h24 G(vw4 vw4Var) {
        h24 h24VarF;
        synchronized (this.z) {
            h24VarF = ((wn1) this.f).F(vw4Var);
        }
        return h24VarF;
    }

    public void H(String str, tt3 tt3Var, mn4 mn4Var, ih ihVar, List list) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.z;
        if (linkedHashMap.containsKey(str)) {
            jn4 jn4Var = new jn4(tt3Var, mn4Var, ihVar, list);
            jn4 jn4Var2 = (jn4) linkedHashMap.get(str);
            jn4Var.e = jn4Var2.e;
            jn4Var.f = jn4Var2.f;
            linkedHashMap.put(str, jn4Var);
        }
    }

    public void I(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f)) {
            map = new HashMap((Map) this.f);
        }
        synchronized (((Map) this.z)) {
            map2 = new HashMap((Map) this.z);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                st4.n();
                return;
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((wa4) entry2.getKey()).a(new w9(status));
            }
        }
    }

    public void J(l25 l25Var) {
        Iterator it = l25Var.a.iterator();
        while (it.hasNext()) {
            ((HashMap) this.f).put(Integer.valueOf(((a35) it.next()).b).toString(), l25Var);
        }
    }

    public d25 K(ih4 ih4Var, d25 d25Var) {
        je.v0(ih4Var);
        if (!(d25Var instanceof e25)) {
            return d25Var;
        }
        e25 e25Var = (e25) d25Var;
        ArrayList arrayList = e25Var.f;
        String str = e25Var.b;
        HashMap map = (HashMap) this.f;
        return (map.containsKey(str) ? (l25) map.get(str) : (l25) this.z).a(str, ih4Var, arrayList);
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        mr4 mr4Var = (mr4) this.f;
        nr4 nr4Var = (nr4) this.z;
        nr4 nr4Var2 = new nr4();
        nr4Var2.a = nr4Var.a;
        nr4Var2.b = nr4Var.b;
        nr4Var2.c = nr4Var.c;
        nr4Var2.d = nr4Var.d;
        return mr4Var.u(view, bv4Var, nr4Var2);
    }

    @Override // defpackage.yj4
    public nj4 a(Type type) {
        return ((rj4) this.f).b(null, type, (qj4) this.z);
    }

    @Override // defpackage.s41
    public int b(int i, int i2, byte[] bArr) throws qy4 {
        if (i2 < 0) {
            st4.j("invalid length specified to decrpyt data");
            return 0;
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            byte b = bArr[i3];
            my4 my4Var = (my4) this.f;
            byte bA = (byte) ((my4Var.a() & 255) ^ b);
            my4Var.c(b);
            bArr[i3] = bA;
        }
        return i2;
    }

    @Override // defpackage.hw4
    public int c(int i, int i2) {
        int iMax;
        int i3;
        int iPreceding;
        char[] cArr = (char[]) this.z;
        BreakIterator breakIterator = (BreakIterator) this.f;
        if (i2 <= 0 || Character.isWhitespace(cArr[i2 - 1]) || breakIterator.isBoundary(i2) || (iPreceding = breakIterator.preceding(i2)) == -1 || (iMax = Math.max(i, Math.min(i2, iPreceding))) <= i) {
            iMax = i2;
        }
        if (iMax == i2 && i2 > i) {
            int i4 = i2 - 1;
            if (!Character.isWhitespace(cArr[i4])) {
                while (i4 > i) {
                    if (cArr[i4] == '.' && i4 - 1 >= i && !Character.isDigit(cArr[i3])) {
                        return i4 + 1;
                    }
                    i4--;
                }
                return i2;
            }
        }
        return iMax;
    }

    public void d(rg3 rg3Var, hm2 hm2Var) {
        xw3 xw3Var = (xw3) this.f;
        fq4 fq4VarA = (fq4) xw3Var.get(rg3Var);
        if (fq4VarA == null) {
            fq4VarA = fq4.a();
            xw3Var.put(rg3Var, fq4VarA);
        }
        fq4VarA.c = hm2Var;
        fq4VarA.a |= 8;
    }

    public b44 e(int i, kz kzVar, ArrayList arrayList, ArrayList arrayList2, uy uyVar, Range range, boolean z) {
        int i2;
        Rect rectH;
        boolean z2;
        kzVar.getClass();
        uyVar.getClass();
        range.getClass();
        ArrayList arrayList3 = new ArrayList();
        String strD = kzVar.d();
        strD.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            in4 in4Var = (in4) it.next();
            ih ihVar = in4Var.h;
            if (ihVar == null) {
                xe.k("Attached stream spec cannot be null for already attached use cases.");
                return null;
            }
            px pxVar = (px) this.z;
            if (pxVar == null) {
                xe.q("Required value was null.");
                return null;
            }
            int iN = in4Var.g.n();
            ih ihVar2 = in4Var.h;
            Size size = ihVar2 != null ? ihVar2.a : null;
            if (size == null) {
                xe.k("Attached surface resolution cannot be null for already attached use cases.");
                return null;
            }
            d44 d44VarJ = in4Var.g.J();
            r64 r64Var = (r64) pxVar.b.get(strD);
            r25.f(r64Var != null, "No such camera id in supported combination list: ".concat(strD));
            ph phVarL = r64Var.l(iN);
            d44 d44Var = w64.e;
            w64 w64VarJ0 = tj4.j0(iN, size, phVarL, i, u64.f, d44VarJ);
            int iN2 = in4Var.g.n();
            ih ihVar3 = in4Var.h;
            Size size2 = ihVar3 != null ? ihVar3.a : null;
            size2.getClass();
            oz0 oz0Var = ihVar.c;
            ArrayList arrayListH = z34.H(in4Var);
            ka0 ka0Var = ihVar.f;
            int iB = in4Var.g.b();
            Range rangeO = in4Var.g.O(ih.h);
            if (rangeO == null) {
                xe.k("Required value was null.");
                return null;
            }
            jg jgVar = new jg(w64VarJ0, iN2, size2, oz0Var, arrayListH, ka0Var, iB, rangeO, in4Var.g.X());
            arrayList3.add(jgVar);
            linkedHashMap2.put(jgVar, in4Var);
            linkedHashMap.put(in4Var, ihVar);
        }
        Pair pair = new Pair(linkedHashMap, linkedHashMap2);
        Object obj = pair.second;
        obj.getClass();
        Map map = (Map) obj;
        int i3 = ty.a;
        HashMap mapA = j00.A(arrayList, (pn4) ((sw2) ((zf2) uyVar).m()).p(uy.g, pn4.a), (vx) this.f, range);
        String strD2 = kzVar.d();
        strD2.getClass();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        if (arrayList.isEmpty()) {
            i2 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        } else {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            try {
                rectH = kzVar.h();
            } catch (NullPointerException unused) {
                rectH = null;
            }
            kw2 kw2Var = new kw2(kzVar, rectH != null ? kg4.f(rectH) : null);
            Iterator it2 = arrayList.iterator();
            boolean z3 = false;
            while (it2.hasNext()) {
                in4 in4Var2 = (in4) it2.next();
                Object obj2 = mapA.get(in4Var2);
                if (obj2 == null) {
                    xe.k("Required value was null.");
                    return null;
                }
                i00 i00Var = (i00) obj2;
                HashMap map2 = mapA;
                mn4 mn4VarN = in4Var2.n(kzVar, i00Var.a, i00Var.b);
                mn4VarN.getClass();
                linkedHashMap4.put(mn4VarN, in4Var2);
                linkedHashMap5.put(mn4VarN, kw2Var.b(mn4VarN));
                if (mn4VarN.W() == 2) {
                    mapA = map2;
                    z3 = true;
                } else {
                    mapA = map2;
                }
            }
            px pxVar2 = (px) this.z;
            if (pxVar2 == null) {
                xe.q("Required value was null.");
                return null;
            }
            ArrayList arrayList4 = new ArrayList(map.keySet());
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z2 = false;
                    break;
                }
                if (j00.F((in4) it3.next())) {
                    z2 = true;
                    break;
                }
            }
            r25.f(!linkedHashMap5.isEmpty(), "No new use cases to be bound.");
            r64 r64Var2 = (r64) pxVar2.b.get(strD2);
            r25.f(r64Var2 != null, "No such camera id in supported combination list: ".concat(strD2));
            k74 k74VarJ = r64Var2.j(i, arrayList4, linkedHashMap5, z3, z2, z);
            HashMap map3 = k74VarJ.a;
            HashMap map4 = k74VarJ.b;
            i2 = k74VarJ.c;
            for (Map.Entry entry : linkedHashMap4.entrySet()) {
                Object value = entry.getValue();
                Object obj3 = map3.get(entry.getKey());
                if (obj3 == null) {
                    xe.k("Required value was null.");
                    return null;
                }
                linkedHashMap3.put(value, obj3);
            }
            for (Map.Entry entry2 : map4.entrySet()) {
                if (map.containsKey(entry2.getKey())) {
                    Object obj4 = map.get(entry2.getKey());
                    if (obj4 == null) {
                        xe.k("Required value was null.");
                        return null;
                    }
                    linkedHashMap3.put(obj4, entry2.getValue());
                }
            }
        }
        Object obj5 = pair.first;
        obj5.getClass();
        LinkedHashMap linkedHashMap6 = new LinkedHashMap((Map) obj5);
        linkedHashMap6.putAll(linkedHashMap3);
        return new b44(i2, linkedHashMap6);
    }

    @Override // defpackage.pk3
    public void f(ns4 ns4Var) {
        ns4Var.getClass();
        ns4Var.printStackTrace();
        ((am1) this.z).g(null);
    }

    public boolean h(vw4 vw4Var) {
        boolean zContainsKey;
        synchronized (this.z) {
            zContainsKey = ((LinkedHashMap) ((wn1) this.f).f).containsKey(vw4Var);
        }
        return zContainsKey;
    }

    public Object i() {
        Object objRemoveLast;
        synchronized (this.z) {
            objRemoveLast = ((ArrayDeque) this.f).removeLast();
        }
        return objRemoveLast;
    }

    public void j(my1 my1Var) throws Exception {
        Object objI;
        cy1 cy1VarG0 = my1Var.g0();
        fy fyVar = cy1VarG0 instanceof gy ? ((gy) cy1VarG0).a : null;
        if (fyVar == null || ((fyVar.k() != dy.Y && fyVar.k() != dy.A) || fyVar.h() != cy.X || fyVar.f() != ey.A)) {
            my1Var.close();
            return;
        }
        synchronized (this.z) {
            try {
                objI = ((ArrayDeque) this.f).size() >= 3 ? i() : null;
                ((ArrayDeque) this.f).addFirst(my1Var);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objI != null) {
            ((my1) objI).close();
        }
    }

    public View k(int i, int i2, int i3, int i4) {
        tj tjVar = (tj) this.z;
        gp4 gp4Var = (gp4) this.f;
        int iC = gp4Var.c();
        int iL = gp4Var.l();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewS = gp4Var.s(i);
            int iA = gp4Var.a(viewS);
            int iV = gp4Var.v(viewS);
            tjVar.c = iC;
            tjVar.d = iL;
            tjVar.e = iA;
            tjVar.f = iV;
            if (i3 != 0) {
                tjVar.b = i3;
                if (tjVar.a()) {
                    return viewS;
                }
            }
            if (i4 != 0) {
                tjVar.b = i4;
                if (tjVar.a()) {
                    view = viewS;
                }
            }
            i += i5;
        }
        return view;
    }

    public File l() {
        File file = (File) this.f;
        if (file != null) {
            return file;
        }
        File file2 = new File(((Context) this.z).getCacheDir(), "volley");
        this.f = file2;
        return file2;
    }

    @Override // defpackage.om1
    public void m(Object obj) {
        switch (this.b) {
            case 4:
                d74 d74Var = (d74) obj;
                d74Var.getClass();
                xm0 xm0Var = (xm0) ((n02) this.z).f;
                if (!xm0Var.e.get()) {
                    xm0Var.b(new s7(25, xm0Var, d74Var), new d4(19, d74Var));
                } else {
                    d74Var.close();
                }
                break;
            case 5:
                r25.j(null, ((vv) this.f).b(null));
                break;
            case 6:
                ((dd0) this.f).accept(new nh(0, (Surface) this.z));
                break;
            default:
                r25.j("Unexpected result from SurfaceRequest. Surface was provided twice.", ((nh) obj).a != 3);
                ez4.o("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
                ((SurfaceTexture) this.f).release();
                ad4 ad4Var = ((zc4) this.z).a;
                if (ad4Var.j != null) {
                    ad4Var.j = null;
                }
                break;
        }
    }

    public st3 o() {
        st3 st3Var = new st3();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) this.z).entrySet()) {
            jn4 jn4Var = (jn4) entry.getValue();
            if (jn4Var.f && jn4Var.e) {
                String str = (String) entry.getKey();
                st3Var.a(jn4Var.a);
                arrayList.add(str);
            }
        }
        ez4.o("UseCaseAttachState", "Active and attached use case: " + arrayList + " for camera: " + ((String) this.f));
        return st3Var;
    }

    @Override // defpackage.pk3
    public void p(Object obj) {
        CharSequence relativeTimeSpanString;
        bp1 bp1Var = (bp1) obj;
        bp1Var.getClass();
        String packageName = ((Context) this.f).getPackageName();
        packageName.getClass();
        PackageInfo packageInfoG = ContextUtilsKt.g(packageName);
        String strConcat = p44.Q0("mobile-2.34.1 (Build 286)", '-').concat("-");
        if (!w44.j0(bp1Var.c(), strConcat, false)) {
            String strV = fw.v("Skipping ", bp1Var.c(), ", not a ", strConcat, " release");
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "VersionChecker", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strV);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("VersionChecker", strV, null);
            }
            ((am1) this.z).g(null);
            return;
        }
        if (w44.j0("mobile-2.34.1 (Build 286)", bp1Var.c(), false) || packageInfoG == null || !bp1Var.b().after(new Date(packageInfoG.lastUpdateTime))) {
            ((am1) this.z).g(null);
            return;
        }
        String strC = bp1Var.c();
        try {
            relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(bp1Var.b().getTime());
            relativeTimeSpanString.getClass();
        } catch (ParseException e) {
            e.printStackTrace();
            relativeTimeSpanString = "Unknown time";
        }
        ((am1) this.z).g(new yo4(strC, relativeTimeSpanString, bp1Var.a()));
    }

    @Override // defpackage.om1
    public void q(Throwable th) {
        switch (this.b) {
            case 4:
                int i = ((c74) this.f).f;
                if (i == 2 && (th instanceof CancellationException)) {
                    ez4.o("SurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                    return;
                } else {
                    ez4.b0("SurfaceProcessorNode", "Downstream node failed to provide Surface. Target: ".concat(xb5.o(i)), th);
                    return;
                }
            case 5:
                if (th instanceof h74) {
                    r25.j(null, ((yv) this.z).cancel(false));
                    return;
                } else {
                    r25.j(null, ((vv) this.f).b(null));
                    return;
                }
            case 6:
                r25.j("Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th, th instanceof h74);
                ((dd0) this.f).accept(new nh(1, (Surface) this.z));
                return;
            default:
                throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
        }
    }

    public st3 r() {
        st3 st3Var = new st3();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) this.z).entrySet()) {
            jn4 jn4Var = (jn4) entry.getValue();
            if (jn4Var.e) {
                st3Var.a(jn4Var.a);
                arrayList.add((String) entry.getKey());
            }
        }
        ez4.o("UseCaseAttachState", "All use case: " + arrayList + " for camera: " + ((String) this.f));
        return st3Var;
    }

    public Collection s() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) this.z).entrySet()) {
            if (((jn4) entry.getValue()).e) {
                arrayList.add(((jn4) entry.getValue()).a);
            }
        }
        return DesugarCollections.unmodifiableCollection(arrayList);
    }

    public Collection t() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) this.z).entrySet()) {
            if (((jn4) entry.getValue()).e) {
                arrayList.add(((jn4) entry.getValue()).b);
            }
        }
        return DesugarCollections.unmodifiableCollection(arrayList);
    }

    public String toString() {
        switch (this.b) {
            case 20:
                return "Bounds{lower=" + ((t02) this.f) + " upper=" + ((t02) this.z) + "}";
            default:
                return super.toString();
        }
    }

    public String u(String str) {
        String str2 = (String) this.z;
        Resources resources = (Resources) this.f;
        int identifier = resources.getIdentifier(str, "string", str2);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }

    public boolean v(String str) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.z;
        if (linkedHashMap.containsKey(str)) {
            return ((jn4) linkedHashMap.get(str)).e;
        }
        return false;
    }

    public boolean w(View view) {
        tj tjVar = (tj) this.z;
        gp4 gp4Var = (gp4) this.f;
        int iC = gp4Var.c();
        int iL = gp4Var.l();
        int iA = gp4Var.a(view);
        int iV = gp4Var.v(view);
        tjVar.c = iC;
        tjVar.d = iL;
        tjVar.e = iA;
        tjVar.f = iV;
        tjVar.b = 24579;
        return tjVar.a();
    }

    public hm2 x(rg3 rg3Var, int i) {
        fq4 fq4Var;
        hm2 hm2Var;
        xw3 xw3Var = (xw3) this.f;
        int iD = xw3Var.d(rg3Var);
        if (iD >= 0 && (fq4Var = (fq4) xw3Var.i(iD)) != null) {
            int i2 = fq4Var.a;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                fq4Var.a = i3;
                if (i == 4) {
                    hm2Var = fq4Var.b;
                } else if (i == 8) {
                    hm2Var = fq4Var.c;
                } else {
                    xe.k("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    xw3Var.g(iD);
                    fq4Var.a = 0;
                    fq4Var.b = null;
                    fq4Var.c = null;
                    fq4.d.c(fq4Var);
                }
                return hm2Var;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object y(boolean z, ie0 ie0Var) {
        et4 et4Var;
        if (ie0Var instanceof et4) {
            et4Var = (et4) ie0Var;
            int i = et4Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                et4Var.Y = i - Integer.MIN_VALUE;
            } else {
                et4Var = new et4(this, ie0Var);
            }
        }
        Object objB0 = et4Var.A;
        int i2 = et4Var.Y;
        if (i2 == 0) {
            n12.S(objB0);
            gm0 gm0Var = qv0.a;
            pl0 pl0Var = pl0.z;
            oo1 oo1Var = new oo1(this, z, null);
            et4Var.Y = 1;
            objB0 = ji0.b0(pl0Var, oo1Var, et4Var);
            mf0 mf0Var = mf0.b;
            if (objB0 == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(objB0);
        }
        return ((uk3) objB0).b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object z(List list, boolean z, ie0 ie0Var) {
        gt4 gt4Var;
        e24 e24Var;
        if (ie0Var instanceof gt4) {
            gt4Var = (gt4) ie0Var;
            int i = gt4Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                gt4Var.Y = i - Integer.MIN_VALUE;
                e24Var = this;
            } else {
                e24Var = this;
                gt4Var = new gt4(e24Var, ie0Var);
            }
        }
        Object objB0 = gt4Var.A;
        mf0 mf0Var = mf0.b;
        int i2 = gt4Var.Y;
        if (i2 == 0) {
            n12.S(objB0);
            String strK = ha0.k("start pushing ", list.size(), " profiles to remote");
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "WebDAVClient", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strK);
            }
            ge0 ge0Var = null;
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("WebDAVClient", strK, null);
            }
            gm0 gm0Var = qv0.a;
            pl0 pl0Var = pl0.z;
            i63 i63Var = new i63(e24Var, z, list, ge0Var, 2);
            gt4Var.Y = 1;
            objB0 = ji0.b0(pl0Var, i63Var, gt4Var);
            if (objB0 == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(objB0);
        }
        return ((uk3) objB0).b;
    }

    public /* synthetic */ e24(int i, Object obj, Object obj2, boolean z) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    public e24(Context context, int i) {
        this.b = i;
        switch (i) {
            case 18:
                this.z = context;
                this.f = null;
                break;
            default:
                tj4.i(context);
                Resources resources = context.getResources();
                this.f = resources;
                this.z = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
                break;
        }
    }

    public e24(char[] cArr, long j, boolean z) throws qy4 {
        this.b = 0;
        my4 my4Var = new my4();
        this.f = my4Var;
        if (cArr != null && cArr.length > 0) {
            my4Var.b(cArr, z);
            byte[] bArr = new byte[12];
            SecureRandom secureRandom = new SecureRandom();
            for (int i = 0; i < 12; i++) {
                byte bNextInt = (byte) secureRandom.nextInt(256);
                my4 my4Var2 = (my4) this.f;
                byte bA = (byte) ((my4Var2.a() & 255) ^ bNextInt);
                my4Var2.c(bNextInt);
                bArr[i] = bA;
            }
            this.z = bArr;
            my4Var.b(cArr, z);
            byte[] bArr2 = (byte[]) this.z;
            bArr2[11] = (byte) (j >>> 24);
            bArr2[10] = (byte) (j >>> 16);
            b(0, bArr2.length, bArr2);
            return;
        }
        st4.j("input password is null or empty, cannot initialize standard encrypter");
        throw null;
    }

    public e24(String str, String str2, String str3) {
        this.b = 19;
        this.f = str;
        yl ylVar = new yl(str2, str3);
        ku2 ku2Var = new ku2();
        ku2Var.i = false;
        ku2Var.h = ylVar;
        ku2Var.d.add(ylVar);
        this.z = new lu2(ku2Var);
    }

    public /* synthetic */ e24(int i, Object obj, Object obj2) {
        this.b = i;
        this.z = obj;
        this.f = obj2;
    }

    public e24(ud0 ud0Var) {
        this.b = 21;
        this.z = ud0Var.b;
        t30 t30Var = new t30(ud0Var);
        BreakIterator lineInstance = BreakIterator.getLineInstance();
        this.f = lineInstance;
        lineInstance.setText(t30Var);
    }

    public e24(st4 st4Var) {
        this.b = 24;
        this.z = new Object();
        this.f = new ArrayDeque(3);
    }

    public e24(String str) {
        this.b = 13;
        this.z = new LinkedHashMap();
        this.f = str;
    }

    public e24(n53 n53Var, ih4 ih4Var) {
        this.b = 22;
        n53Var.getClass();
        ih4Var.getClass();
        this.f = n53Var;
        this.z = ih4Var;
    }

    public e24(wn1 wn1Var) {
        this.b = 7;
        this.f = wn1Var;
        this.z = new Object();
    }

    public e24(vx vxVar) {
        this.b = 2;
        this.f = vxVar;
        this.z = null;
    }

    public e24(gp4 gp4Var) {
        this.b = 15;
        this.f = gp4Var;
        tj tjVar = new tj(3);
        tjVar.b = 0;
        this.z = tjVar;
    }

    public e24(WindowInsetsAnimation.Bounds bounds) {
        this.b = 20;
        this.f = du4.g(bounds);
        this.z = du4.f(bounds);
    }

    public e24(at3 at3Var) {
        this.b = 23;
        this.z = new AtomicBoolean(true);
    }
}
