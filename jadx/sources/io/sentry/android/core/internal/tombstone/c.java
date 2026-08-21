package io.sentry.android.core.internal.tombstone;

import com.tencent.mars.xlog.Xlog;
import defpackage.cf4;
import defpackage.en;
import defpackage.fw;
import defpackage.gk2;
import defpackage.ii;
import defpackage.k01;
import defpackage.pr1;
import defpackage.w41;
import defpackage.wl3;
import defpackage.xb5;
import defpackage.zh3;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.g;
import io.sentry.f5;
import io.sentry.g2;
import io.sentry.o;
import io.sentry.p5;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.a0;
import io.sentry.protocol.b0;
import io.sentry.protocol.c0;
import io.sentry.protocol.e0;
import io.sentry.protocol.f;
import io.sentry.protocol.p;
import io.sentry.protocol.v;
import io.sentry.w;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Closeable {
    public final List A;
    public final Serializable X;
    public final Object Y;
    public final /* synthetic */ int b;
    public final Object f;
    public final Object z;

    public c(InputStream inputStream, List list, List list2, String str) {
        this.b = 0;
        HashMap map = new HashMap();
        this.Y = map;
        this.f = inputStream;
        this.z = list;
        this.A = list2;
        this.X = str;
        map.put("SIGILL", "IllegalInstruction");
        map.put("SIGTRAP", "Trap");
        map.put("SIGABRT", "Abort");
        map.put("SIGBUS", "BusError");
        map.put("SIGFPE", "FloatingPointException");
        map.put("SIGSEGV", "Segfault");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.b) {
            case 0:
                ((InputStream) this.f).close();
                return;
            default:
                ArrayList arrayList = (ArrayList) this.X;
                io.sentry.util.a aVar = (io.sentry.util.a) this.Y;
                aVar.g();
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Future) it.next()).cancel(false);
                    }
                    arrayList.clear();
                    aVar.close();
                    ((CopyOnWriteArrayList) this.A).clear();
                    return;
                } catch (Throwable th) {
                    try {
                        aVar.close();
                        break;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
        }
    }

    public void g(o oVar, Date date, long j) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.f;
        ArrayList arrayList = (ArrayList) this.X;
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.z;
        Date date2 = (Date) concurrentHashMap.get(oVar);
        if (date2 == null || date.after(date2)) {
            concurrentHashMap.put(oVar, date);
            Iterator it = ((CopyOnWriteArrayList) this.A).iterator();
            while (it.hasNext()) {
                ((io.sentry.transport.o) it.next()).N(this);
            }
            io.sentry.util.a aVar = (io.sentry.util.a) this.Y;
            aVar.g();
            try {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (((Future) it2.next()).isDone()) {
                        it2.remove();
                    }
                }
                try {
                    arrayList.add(sentryAndroidOptions.getTimerExecutorService().b(new g(17, this), j));
                } catch (RejectedExecutionException e) {
                    sentryAndroidOptions.getLogger().d(p5.WARNING, "Failed to schedule rate limit lifted notification.", e);
                }
                aVar.close();
            } catch (Throwable th) {
                try {
                    aVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public boolean n(o oVar) {
        Date date;
        Date date2 = new Date(System.currentTimeMillis());
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.z;
        Date date3 = (Date) concurrentHashMap.get(o.All);
        if (date3 != null && !date2.after(date3)) {
            return true;
        }
        if (o.Unknown.equals(oVar) || (date = (Date) concurrentHashMap.get(oVar)) == null) {
            return false;
        }
        return !date2.after(date);
    }

    public f5 s() throws IOException {
        c cVar;
        DebugImage debugImageA;
        Map map;
        Iterator it;
        DebugImage debugImageA2;
        en enVar;
        ArrayList arrayList;
        int i;
        en enVar2;
        ArrayList arrayList2;
        int i2;
        en enVar3;
        en enVar4;
        en enVar5;
        en enVar6;
        en enVar7;
        InputStream inputStream = (InputStream) this.f;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i3);
        }
        en enVar8 = new en(byteArrayOutputStream.toByteArray(), 1);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        String str = "";
        int i4 = 0;
        int i5 = 0;
        String strG = "";
        w41 w41Var = null;
        while (true) {
            int iH = enVar8.h();
            if (iH == 0) {
                String str2 = str;
                int i6 = i5;
                List listUnmodifiableList = DesugarCollections.unmodifiableList(arrayList3);
                DesugarCollections.unmodifiableList(arrayList4);
                DesugarCollections.unmodifiableList(arrayList5);
                Map mapUnmodifiableMap = DesugarCollections.unmodifiableMap(map2);
                DesugarCollections.unmodifiableMap(map3);
                List listUnmodifiableList2 = DesugarCollections.unmodifiableList(arrayList6);
                DesugarCollections.unmodifiableList(arrayList7);
                DesugarCollections.unmodifiableList(arrayList8);
                f5 f5Var = new f5();
                f5Var.L0 = p5.FATAL;
                f5Var.y0 = "native";
                p pVar = new p();
                StringBuilder sb = new StringBuilder();
                Iterator it2 = listUnmodifiableList.iterator();
                if (it2.hasNext()) {
                    while (true) {
                        sb.append((CharSequence) it2.next());
                        if (it2.hasNext()) {
                            sb.append((CharSequence) " ");
                        }
                    }
                }
                String string = sb.toString();
                if (w41Var != null) {
                    Locale locale = Locale.ROOT;
                    String strConcat = !strG.isEmpty() ? strG.concat(": ") : str2;
                    pVar.b = strConcat + "Fatal signal " + ((String) w41Var.c) + " (" + w41Var.a + "), " + ((String) w41Var.d) + " (" + w41Var.b + "), pid = " + i4 + " (" + string + ")";
                } else {
                    Locale locale2 = Locale.ROOT;
                    pVar.b = "Fatal exit pid = " + i4 + " (" + string + ")";
                }
                f5Var.H0 = pVar;
                ArrayList arrayList9 = new ArrayList();
                Iterator it3 = listUnmodifiableList2.iterator();
                b bVar = null;
                while (it3.hasNext()) {
                    gk2 gk2Var = (gk2) it3.next();
                    boolean z = gk2Var.d;
                    String str3 = gk2Var.f;
                    String str4 = gk2Var.e;
                    long j = gk2Var.b;
                    if (!z || str4.isEmpty() || str4.startsWith("/dev/")) {
                        map = mapUnmodifiableMap;
                        it = it3;
                    } else {
                        boolean zIsEmpty = str3.isEmpty();
                        map = mapUnmodifiableMap;
                        it = it3;
                        boolean z2 = gk2Var.c == 0;
                        if (zIsEmpty || !z2) {
                            if (bVar != null && str4.equals((String) bVar.c)) {
                                bVar.b = j;
                            }
                        } else if (bVar == null || !str4.equals((String) bVar.c)) {
                            if (bVar != null && (debugImageA2 = bVar.a()) != null) {
                                arrayList9.add(debugImageA2);
                            }
                            b bVar2 = new b();
                            bVar2.c = str4;
                            bVar2.d = str3;
                            bVar2.a = gk2Var.a;
                            bVar2.b = j;
                            bVar = bVar2;
                        } else {
                            bVar.b = j;
                        }
                    }
                    mapUnmodifiableMap = map;
                    it3 = it;
                }
                Map map4 = mapUnmodifiableMap;
                if (bVar != null && (debugImageA = bVar.a()) != null) {
                    arrayList9.add(debugImageA);
                }
                f fVar = new f();
                fVar.b(arrayList9);
                f5Var.E0 = fVar;
                v vVar = new v();
                if (w41Var != null) {
                    String str5 = (String) w41Var.c;
                    vVar.b = str5;
                    cVar = this;
                    vVar.f = (String) ((HashMap) cVar.Y).get(str5);
                    io.sentry.protocol.o oVar = new io.sentry.protocol.o();
                    oVar.b = a.TOMBSTONE.getValue();
                    oVar.A = Boolean.FALSE;
                    oVar.Z = Boolean.TRUE;
                    HashMap map5 = new HashMap();
                    map5.put("number", Integer.valueOf(w41Var.a));
                    map5.put("name", (String) w41Var.c);
                    map5.put("code", Integer.valueOf(w41Var.b));
                    map5.put("code_name", (String) w41Var.d);
                    oVar.X = new HashMap(map5);
                    vVar.Y = oVar;
                } else {
                    cVar = this;
                }
                vVar.A = Long.valueOf(i6);
                ArrayList arrayList10 = new ArrayList(1);
                arrayList10.add(vVar);
                f5Var.h(arrayList10);
                ArrayList arrayListD = f5Var.d();
                Objects.requireNonNull(arrayListD);
                v vVar2 = (v) arrayListD.get(0);
                ArrayList arrayList11 = new ArrayList();
                Iterator it4 = map4.entrySet().iterator();
                while (it4.hasNext()) {
                    cf4 cf4Var = (cf4) ((Map.Entry) it4.next()).getValue();
                    e0 e0Var = new e0();
                    e0Var.b = Long.valueOf(((Integer) r5.getKey()).intValue());
                    e0Var.z = cf4Var.b;
                    ArrayList arrayList12 = new ArrayList();
                    Iterator it5 = cf4Var.d.iterator();
                    while (it5.hasNext()) {
                        ii iiVar = (ii) it5.next();
                        String str6 = iiVar.c;
                        String str7 = iiVar.b;
                        if (!str6.endsWith("libart.so") && (!str6.startsWith("<anonymous") || !str7.isEmpty())) {
                            a0 a0Var = new a0();
                            a0Var.C0 = str6;
                            a0Var.X = str7;
                            Iterator it6 = it5;
                            Iterator it7 = it4;
                            a0Var.H0 = String.format("0x%x", Long.valueOf(iiVar.a));
                            Boolean boolC = str7.isEmpty() ? Boolean.FALSE : w.c(str7, (List) cVar.z, cVar.A);
                            String str8 = (String) cVar.X;
                            a0Var.B0 = Boolean.valueOf((boolC != null && boolC.booleanValue()) || (str8 != null && str6.startsWith(str8)));
                            arrayList12.add(0, a0Var);
                            it5 = it6;
                            it4 = it7;
                        }
                    }
                    Iterator it8 = it4;
                    c0 c0Var = new c0();
                    c0Var.b = arrayList12;
                    c0Var.A = b0.NONE;
                    HashMap map6 = new HashMap();
                    for (zh3 zh3Var : cf4Var.c) {
                        map6.put(zh3Var.a, String.format("0x%x", Long.valueOf(zh3Var.b)));
                    }
                    c0Var.f = map6;
                    e0Var.z0 = c0Var;
                    int i7 = cf4Var.a;
                    if (i6 == i7) {
                        e0Var.X = Boolean.TRUE;
                        vVar2.X = c0Var;
                    }
                    if (i4 == i7) {
                        e0Var.z = "main";
                        e0Var.y0 = Boolean.TRUE;
                    }
                    arrayList11.add(e0Var);
                    it4 = it8;
                }
                f5Var.J0 = new g2(arrayList11);
                return f5Var;
            }
            int i8 = iH >>> 3;
            int i9 = iH & 7;
            String str9 = str;
            switch (i8) {
                case 1:
                    enVar = enVar8;
                    arrayList = arrayList3;
                    i = i5;
                    en.b(i8, 0, i9);
                    int i10 = (int) enVar.i();
                    int[] iArrL = fw.L(6);
                    int length = iArrL.length;
                    for (int i11 = 0; i11 < length && fw.G(iArrL[i11]) != i10; i11++) {
                    }
                    i5 = i;
                    break;
                case 2:
                    enVar = enVar8;
                    arrayList = arrayList3;
                    en.b(i8, 2, i9);
                    enVar.g();
                    break;
                case 3:
                    enVar = enVar8;
                    arrayList = arrayList3;
                    en.b(i8, 2, i9);
                    enVar.g();
                    break;
                case 4:
                    enVar = enVar8;
                    arrayList = arrayList3;
                    en.b(i8, 2, i9);
                    enVar.g();
                    break;
                case 5:
                    enVar = enVar8;
                    arrayList = arrayList3;
                    i = i5;
                    en.b(i8, 0, i9);
                    i4 = (int) enVar.i();
                    i5 = i;
                    break;
                case 6:
                    enVar = enVar8;
                    arrayList = arrayList3;
                    en.b(i8, 0, i9);
                    i5 = (int) enVar.i();
                    break;
                case 7:
                    enVar = enVar8;
                    arrayList = arrayList3;
                    i = i5;
                    en.b(i8, 0, i9);
                    enVar.i();
                    i5 = i;
                    break;
                case 8:
                    enVar = enVar8;
                    arrayList = arrayList3;
                    en.b(i8, 2, i9);
                    enVar.g();
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    enVar = enVar8;
                    arrayList = arrayList3;
                    i = i5;
                    en.b(i8, 2, i9);
                    arrayList.add(enVar.g());
                    i5 = i;
                    break;
                case 10:
                    enVar = enVar8;
                    i = i5;
                    en.b(i8, 2, i9);
                    en enVarF = enVar.f();
                    String strG2 = str9;
                    String strG3 = strG2;
                    int i12 = 0;
                    int i13 = 0;
                    while (true) {
                        int iH2 = enVarF.h();
                        if (iH2 == 0) {
                            arrayList = arrayList3;
                            w41Var = new w41(i12, i13, strG2, strG3);
                            i5 = i;
                        } else {
                            int i14 = iH2 >>> 3;
                            int i15 = iH2 & 7;
                            switch (i14) {
                                case 1:
                                    enVar2 = enVarF;
                                    en.b(i14, 0, i15);
                                    arrayList2 = arrayList3;
                                    i12 = (int) enVar2.i();
                                    break;
                                case 2:
                                    enVar2 = enVarF;
                                    i2 = i12;
                                    en.b(i14, 2, i15);
                                    strG2 = enVar2.g();
                                    arrayList2 = arrayList3;
                                    i12 = i2;
                                    break;
                                case 3:
                                    enVar2 = enVarF;
                                    en.b(i14, 0, i15);
                                    i2 = i12;
                                    i13 = (int) enVar2.i();
                                    arrayList2 = arrayList3;
                                    i12 = i2;
                                    break;
                                case 4:
                                    enVar2 = enVarF;
                                    en.b(i14, 2, i15);
                                    arrayList2 = arrayList3;
                                    strG3 = enVar2.g();
                                    break;
                                case 5:
                                    enVar2 = enVarF;
                                    en.b(i14, 0, i15);
                                    enVar2.d();
                                    arrayList2 = arrayList3;
                                    break;
                                case 6:
                                    enVar2 = enVarF;
                                    en.b(i14, 0, i15);
                                    enVar2.i();
                                    arrayList2 = arrayList3;
                                    break;
                                case 7:
                                    enVar2 = enVarF;
                                    en.b(i14, 0, i15);
                                    enVar2.i();
                                    arrayList2 = arrayList3;
                                    break;
                                case 8:
                                    enVar2 = enVarF;
                                    en.b(i14, 0, i15);
                                    enVar2.d();
                                    arrayList2 = arrayList3;
                                    break;
                                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                                    enVar2 = enVarF;
                                    en.b(i14, 0, i15);
                                    enVar2.i();
                                    arrayList2 = arrayList3;
                                    break;
                                case 10:
                                    enVar2 = enVarF;
                                    en.b(i14, 2, i15);
                                    xb5.i(enVar2.f());
                                    arrayList2 = arrayList3;
                                    break;
                                default:
                                    enVarF.j(i15);
                                    enVar2 = enVarF;
                                    arrayList2 = arrayList3;
                                    break;
                            }
                            arrayList3 = arrayList2;
                            enVarF = enVar2;
                        }
                        break;
                    }
                    break;
                case 11:
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                case 13:
                default:
                    enVar8.j(i9);
                    enVar = enVar8;
                    arrayList = arrayList3;
                    i = i5;
                    i5 = i;
                    break;
                case 14:
                    enVar = enVar8;
                    en.b(i8, 2, i9);
                    strG = enVar.g();
                    arrayList = arrayList3;
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    enVar = enVar8;
                    i = i5;
                    int i16 = 2;
                    en.b(i8, 2, i9);
                    en enVarF2 = enVar.f();
                    while (true) {
                        int iH3 = enVarF2.h();
                        if (iH3 == 0) {
                            arrayList5.add(new pr1());
                            arrayList = arrayList3;
                            i5 = i;
                        } else {
                            int i17 = iH3 >>> 3;
                            int i18 = iH3 & 7;
                            if (i17 != 1) {
                                if (i17 != i16) {
                                    enVarF2.j(i18);
                                } else {
                                    en.b(i17, i16, i18);
                                    en enVarF3 = enVarF2.f();
                                    while (true) {
                                        int iH4 = enVarF3.h();
                                        if (iH4 != 0) {
                                            int i19 = iH4 >>> 3;
                                            int i20 = iH4 & 7;
                                            if (i19 == 1) {
                                                enVar4 = enVarF2;
                                                enVar5 = enVarF3;
                                                en.b(i19, 0, i20);
                                                int i21 = (int) enVar5.i();
                                                int[] iArrL2 = fw.L(2);
                                                int length2 = iArrL2.length;
                                                for (int i22 = 0; i22 < length2 && fw.G(iArrL2[i22]) != i21; i22++) {
                                                }
                                            } else if (i19 == i16) {
                                                enVar4 = enVarF2;
                                                enVar5 = enVarF3;
                                                en.b(i19, 0, i20);
                                                int i23 = (int) enVar5.i();
                                                int[] iArrL3 = fw.L(6);
                                                int length3 = iArrL3.length;
                                                for (int i24 = 0; i24 < length3 && fw.G(iArrL3[i24]) != i23; i24++) {
                                                }
                                            } else if (i19 != 3) {
                                                enVarF3.j(i20);
                                                enVar4 = enVarF2;
                                                enVar5 = enVarF3;
                                            } else {
                                                en.b(i19, i16, i20);
                                                en enVarF4 = enVarF3.f();
                                                ArrayList arrayList13 = new ArrayList();
                                                ArrayList arrayList14 = new ArrayList();
                                                while (true) {
                                                    int iH5 = enVarF4.h();
                                                    if (iH5 != 0) {
                                                        int i25 = iH5 >>> 3;
                                                        en enVar9 = enVarF2;
                                                        int i26 = iH5 & 7;
                                                        switch (i25) {
                                                            case 1:
                                                                enVar6 = enVarF3;
                                                                en.b(i25, 0, i26);
                                                                enVarF4.i();
                                                                break;
                                                            case 2:
                                                                enVar6 = enVarF3;
                                                                en.b(i25, 0, i26);
                                                                enVarF4.i();
                                                                break;
                                                            case 3:
                                                                enVar6 = enVarF3;
                                                                en.b(i25, 0, i26);
                                                                enVarF4.i();
                                                                break;
                                                            case 4:
                                                                enVar6 = enVarF3;
                                                                en.b(i25, 2, i26);
                                                                arrayList13.add(xb5.g(enVarF4.f()));
                                                                break;
                                                            case 5:
                                                                enVar6 = enVarF3;
                                                                en.b(i25, 0, i26);
                                                                enVarF4.i();
                                                                break;
                                                            case 6:
                                                                enVar6 = enVarF3;
                                                                en.b(i25, 2, i26);
                                                                arrayList14.add(xb5.g(enVarF4.f()));
                                                                break;
                                                            default:
                                                                enVarF4.j(i26);
                                                                enVar6 = enVarF3;
                                                                break;
                                                        }
                                                        enVarF3 = enVar6;
                                                        enVarF2 = enVar9;
                                                    } else {
                                                        enVar4 = enVarF2;
                                                        enVar5 = enVarF3;
                                                        DesugarCollections.unmodifiableList(arrayList13);
                                                        DesugarCollections.unmodifiableList(arrayList14);
                                                    }
                                                }
                                            }
                                            enVarF3 = enVar5;
                                            enVarF2 = enVar4;
                                            i16 = 2;
                                        }
                                    }
                                }
                                enVar3 = enVarF2;
                            } else {
                                enVar3 = enVarF2;
                                en.b(i17, i16, i18);
                                enVar3.g();
                            }
                            enVarF2 = enVar3;
                        }
                        break;
                    }
                    break;
                case 16:
                    enVar = enVar8;
                    i = i5;
                    en.b(i8, 2, i9);
                    xb5.j(enVar.f(), map2);
                    arrayList = arrayList3;
                    i5 = i;
                    break;
                case 17:
                    enVar = enVar8;
                    i = i5;
                    en.b(i8, 2, i9);
                    en enVarF5 = enVar.f();
                    String strG4 = str9;
                    String strG5 = strG4;
                    long jI = 0;
                    long jI2 = 0;
                    long jI3 = 0;
                    boolean zD = false;
                    while (true) {
                        int iH6 = enVarF5.h();
                        if (iH6 == 0) {
                            arrayList6.add(new gk2(jI, jI2, jI3, zD, strG4, strG5));
                            arrayList = arrayList3;
                            i5 = i;
                            break;
                        } else {
                            int i27 = iH6 >>> 3;
                            int i28 = iH6 & 7;
                            switch (i27) {
                                case 1:
                                    en.b(i27, 0, i28);
                                    jI = enVarF5.i();
                                    break;
                                case 2:
                                    en.b(i27, 0, i28);
                                    jI2 = enVarF5.i();
                                    break;
                                case 3:
                                    en.b(i27, 0, i28);
                                    jI3 = enVarF5.i();
                                    break;
                                case 4:
                                    en.b(i27, 0, i28);
                                    zD = enVarF5.d();
                                    break;
                                case 5:
                                    en.b(i27, 0, i28);
                                    enVarF5.d();
                                    break;
                                case 6:
                                    en.b(i27, 0, i28);
                                    enVarF5.d();
                                    break;
                                case 7:
                                    en.b(i27, 2, i28);
                                    strG4 = enVarF5.g();
                                    break;
                                case 8:
                                    en.b(i27, 2, i28);
                                    strG5 = enVarF5.g();
                                    break;
                                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                                    en.b(i27, 0, i28);
                                    enVarF5.i();
                                    break;
                                default:
                                    enVarF5.j(i28);
                                    break;
                            }
                        }
                    }
                    break;
                case 18:
                    enVar = enVar8;
                    i = i5;
                    en.b(i8, 2, i9);
                    en enVarF6 = enVar.f();
                    ArrayList arrayList15 = new ArrayList();
                    while (true) {
                        int iH7 = enVarF6.h();
                        if (iH7 == 0) {
                            k01 k01Var = new k01(23);
                            DesugarCollections.unmodifiableList(arrayList15);
                            arrayList7.add(k01Var);
                            arrayList = arrayList3;
                            i5 = i;
                            break;
                        } else {
                            int i29 = iH7 >>> 3;
                            int i30 = iH7 & 7;
                            if (i29 == 1) {
                                en.b(i29, 2, i30);
                                enVarF6.g();
                            } else if (i29 != 2) {
                                enVarF6.j(i30);
                            } else {
                                en.b(i29, 2, i30);
                                en enVarF7 = enVarF6.f();
                                while (true) {
                                    int iH8 = enVarF7.h();
                                    if (iH8 != 0) {
                                        int i31 = iH8 >>> 3;
                                        int i32 = iH8 & 7;
                                        switch (i31) {
                                            case 1:
                                                en.b(i31, 2, i32);
                                                enVarF7.g();
                                                break;
                                            case 2:
                                                en.b(i31, 0, i32);
                                                enVarF7.i();
                                                break;
                                            case 3:
                                                en.b(i31, 0, i32);
                                                enVarF7.i();
                                                break;
                                            case 4:
                                                en.b(i31, 0, i32);
                                                enVarF7.i();
                                                break;
                                            case 5:
                                                en.b(i31, 2, i32);
                                                enVarF7.g();
                                                break;
                                            case 6:
                                                en.b(i31, 2, i32);
                                                enVarF7.g();
                                                break;
                                            default:
                                                enVarF7.j(i32);
                                                break;
                                        }
                                    } else {
                                        arrayList15.add(new pr1());
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 19:
                    enVar = enVar8;
                    i = i5;
                    en.b(i8, 2, i9);
                    en enVarF8 = enVar.f();
                    while (true) {
                        int iH9 = enVarF8.h();
                        if (iH9 == 0) {
                            arrayList8.add(new pr1());
                            arrayList = arrayList3;
                            i5 = i;
                            break;
                        } else {
                            int i33 = iH9 >>> 3;
                            int i34 = iH9 & 7;
                            if (i33 == 1) {
                                en.b(i33, 0, i34);
                                enVarF8.i();
                            } else if (i33 == 2) {
                                en.b(i33, 2, i34);
                                enVarF8.g();
                            } else if (i33 == 3) {
                                en.b(i33, 2, i34);
                                enVarF8.g();
                            } else if (i33 != 4) {
                                enVarF8.j(i34);
                            } else {
                                en.b(i33, 0, i34);
                                enVarF8.i();
                            }
                        }
                    }
                    break;
                case 20:
                    enVar = enVar8;
                    i = i5;
                    en.b(i8, 0, i9);
                    enVar.i();
                    arrayList = arrayList3;
                    i5 = i;
                    break;
                case 21:
                    enVar = enVar8;
                    i = i5;
                    int i35 = 2;
                    en.b(i8, 2, i9);
                    en enVarF9 = enVar.f();
                    while (true) {
                        int iH10 = enVarF9.h();
                        if (iH10 == 0) {
                            arrayList4.add(new wl3(14));
                            arrayList = arrayList3;
                            i5 = i;
                        } else {
                            int i36 = iH10 >>> 3;
                            int i37 = iH10 & 7;
                            if (i36 == 1) {
                                en.b(i36, i35, i37);
                                enVarF9.e();
                            } else if (i36 != i35) {
                                enVarF9.j(i37);
                            } else {
                                en.b(i36, i35, i37);
                                enVarF9.e();
                            }
                            i35 = 2;
                        }
                        break;
                    }
                    break;
                case 22:
                    enVar = enVar8;
                    i = i5;
                    en.b(i8, 0, i9);
                    enVar.i();
                    arrayList = arrayList3;
                    i5 = i;
                    break;
                case 23:
                    enVar = enVar8;
                    i = i5;
                    en.b(i8, 0, i9);
                    enVar.d();
                    arrayList = arrayList3;
                    i5 = i;
                    break;
                case 24:
                    enVar = enVar8;
                    i = i5;
                    en.b(i8, 0, i9);
                    int i38 = (int) enVar.i();
                    int[] iArrL4 = fw.L(6);
                    int length4 = iArrL4.length;
                    for (int i39 = 0; i39 < length4 && fw.G(iArrL4[i39]) != i38; i39++) {
                    }
                    arrayList = arrayList3;
                    i5 = i;
                    break;
                case 25:
                    enVar = enVar8;
                    i = i5;
                    en.b(i8, 2, i9);
                    xb5.j(enVar.f(), map3);
                    arrayList = arrayList3;
                    i5 = i;
                    break;
                case 26:
                    en.b(i8, 2, i9);
                    en enVarF10 = enVar8.f();
                    ArrayList arrayList16 = new ArrayList();
                    while (true) {
                        int iH11 = enVarF10.h();
                        if (iH11 == 0) {
                            enVar = enVar8;
                            i = i5;
                            DesugarCollections.unmodifiableList(arrayList16);
                            arrayList = arrayList3;
                            i5 = i;
                        } else {
                            en enVar10 = enVar8;
                            int i40 = iH11 >>> 3;
                            int i41 = iH11 & 7;
                            int i42 = i5;
                            if (i40 == 1) {
                                enVar7 = enVarF10;
                                en.b(i40, 0, i41);
                                enVar7.i();
                            } else if (i40 != 2) {
                                enVarF10.j(i41);
                                enVar7 = enVarF10;
                            } else {
                                en.b(i40, 2, i41);
                                en enVarF11 = enVarF10.f();
                                while (true) {
                                    int iH12 = enVarF11.h();
                                    if (iH12 != 0) {
                                        int i43 = iH12 >>> 3;
                                        int i44 = iH12 & 7;
                                        en enVar11 = enVarF10;
                                        if (i43 == 1) {
                                            en.b(i43, 2, i44);
                                            xb5.g(enVarF11.f());
                                        } else if (i43 == 2) {
                                            en.b(i43, 0, i44);
                                            enVarF11.i();
                                        } else if (i43 != 3) {
                                            enVarF11.j(i44);
                                        } else {
                                            en.b(i43, 0, i44);
                                            enVarF11.i();
                                        }
                                        enVarF10 = enVar11;
                                    } else {
                                        enVar7 = enVarF10;
                                        arrayList16.add(new pr1());
                                    }
                                }
                            }
                            enVarF10 = enVar7;
                            enVar8 = enVar10;
                            i5 = i42;
                        }
                        break;
                    }
                    break;
            }
            arrayList3 = arrayList;
            str = str9;
            enVar8 = enVar;
        }
    }

    public c(SentryAndroidOptions sentryAndroidOptions) {
        this.b = 1;
        this.z = new ConcurrentHashMap();
        this.A = new CopyOnWriteArrayList();
        this.X = new ArrayList();
        this.Y = new io.sentry.util.a();
        this.f = sentryAndroidOptions;
    }
}
