package io.sentry.android.replay.capture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import defpackage.a82;
import defpackage.bf2;
import defpackage.bh3;
import defpackage.d70;
import defpackage.df2;
import defpackage.g41;
import defpackage.gb4;
import defpackage.n12;
import defpackage.tj4;
import defpackage.vf2;
import defpackage.z72;
import defpackage.z82;
import io.sentry.b4;
import io.sentry.f1;
import io.sentry.m4;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.u;
import io.sentry.protocol.w;
import io.sentry.q6;
import io.sentry.r6;
import io.sentry.t6;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x020f A[LOOP:2: B:46:0x0146->B:102:0x020f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x021c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static l a(f1 f1Var, p6 p6Var, long j, Date date, w wVar, int i, int i2, int i3, q6 q6Var, io.sentry.android.replay.j jVar, int i4, int i5, String str, List list, Deque deque, List list2, List list3) {
        io.sentry.util.a aVar;
        int i6;
        boolean z;
        Object obj;
        df2 df2Var;
        io.sentry.android.replay.j jVar2;
        int i7;
        io.sentry.android.replay.c cVar;
        io.sentry.android.replay.c cVar2;
        Object obj2;
        long j2;
        Object obj3;
        long j3;
        long j4;
        List list4;
        Collection collection;
        List<io.sentry.g> list5;
        boolean z2;
        io.sentry.rrweb.b bVarA;
        Object obj4;
        p6Var.getClass();
        wVar.getClass();
        list2.getClass();
        list3.getClass();
        if (jVar != null) {
            p6 p6Var2 = jVar.b;
            long jMin = Math.min(j, 300000L);
            long time = date.getTime();
            File file = new File(jVar.s(), i + ".mp4");
            io.sentry.util.a aVar2 = jVar.Y;
            ArrayList arrayList = jVar.z0;
            io.sentry.util.a aVar3 = jVar.A;
            long j5 = 0;
            if (file.exists() && file.length() > 0) {
                file.delete();
            }
            aVar2.g();
            try {
                ArrayList arrayList2 = arrayList.isEmpty() ? new ArrayList() : d70.z0(arrayList);
                vf2.e(aVar2, null);
                if (arrayList2.isEmpty()) {
                    p6Var2.getLogger().h(p5.DEBUG, "No captured frames, skipping generating a video segment", new Object[0]);
                    i6 = i4;
                    z = true;
                    cVar2 = null;
                } else {
                    aVar3.g();
                    try {
                        Collection collection2 = arrayList;
                        i6 = i4;
                        List list6 = arrayList2;
                        try {
                            io.sentry.android.core.d dVar = new io.sentry.android.core.d(p6Var2, new io.sentry.android.replay.video.a(file, i3, i2, i6, i5));
                            try {
                                MediaCodec mediaCodec = (MediaCodec) dVar.c;
                                mediaCodec.configure((MediaFormat) ((z82) dVar.d).getValue(), (Surface) null, (MediaCrypto) null, 1);
                                dVar.g = mediaCodec.createInputSurface();
                                mediaCodec.start();
                                dVar.c(false);
                                vf2.e(aVar3, null);
                                jVar.Z = dVar;
                                long j6 = 1000 / ((long) i6);
                                Object objE0 = d70.e0(list6);
                                z = true;
                                long j7 = time + jMin;
                                if (j7 <= Long.MIN_VALUE) {
                                    df2Var = df2.A;
                                    obj = objE0;
                                } else {
                                    obj = objE0;
                                    df2Var = new df2(time, j7 - 1);
                                }
                                df2Var.getClass();
                                gb4.q(j6 > 0, Long.valueOf(j6));
                                long j8 = df2Var.b;
                                long j9 = df2Var.f;
                                long j10 = df2Var.z > 0 ? j6 : -j6;
                                long j11 = new bf2(j8, j9, j10).f;
                                if ((j10 <= 0 || j8 > j11) && (j10 >= 0 || j11 > j8)) {
                                    jVar2 = jVar;
                                    i7 = 0;
                                } else {
                                    Object obj5 = obj;
                                    long j12 = j8;
                                    int i8 = 0;
                                    while (true) {
                                        Iterator it = list6.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                obj2 = obj5;
                                                j2 = j12;
                                                break;
                                            }
                                            obj2 = obj5;
                                            io.sentry.android.replay.k kVar = (io.sentry.android.replay.k) it.next();
                                            long j13 = j12 + j6;
                                            j2 = j12;
                                            long j14 = kVar.b;
                                            if (j2 <= j14 && j14 <= j13) {
                                                obj3 = kVar;
                                                break;
                                            }
                                            if (j14 > j13) {
                                                break;
                                            }
                                            obj5 = obj2;
                                            j12 = j2;
                                        }
                                        obj3 = obj2;
                                        io.sentry.android.replay.k kVar2 = (io.sentry.android.replay.k) obj3;
                                        if (kVar2 != null) {
                                            try {
                                                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(kVar2.a.getAbsolutePath());
                                                aVar3.g();
                                                jVar2 = jVar;
                                                j3 = j11;
                                                try {
                                                    io.sentry.android.core.d dVar2 = jVar2.Z;
                                                    if (dVar2 != null) {
                                                        bitmapDecodeFile.getClass();
                                                        dVar2.d(bitmapDecodeFile);
                                                    }
                                                    try {
                                                        vf2.e(aVar3, null);
                                                        bitmapDecodeFile.recycle();
                                                        i8++;
                                                        obj5 = obj3;
                                                        j4 = j6;
                                                        list4 = list6;
                                                        collection = collection2;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        j4 = j6;
                                                        p6Var2.getLogger().d(p5.WARNING, "Unable to decode bitmap and encode it into a video, skipping frame", th);
                                                        if (obj3 == null) {
                                                        }
                                                    }
                                                } finally {
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                jVar2 = jVar;
                                                j3 = j11;
                                            }
                                            if (j2 != j3) {
                                                i7 = i8;
                                                break;
                                            }
                                            collection2 = collection;
                                            list6 = list4;
                                            j12 = j2 + j10;
                                            j11 = j3;
                                            j6 = j4;
                                        } else {
                                            jVar2 = jVar;
                                            j3 = j11;
                                            j4 = j6;
                                        }
                                        if (obj3 == null) {
                                            jVar2.n(((io.sentry.android.replay.k) obj3).a);
                                            aVar2.g();
                                            collection = collection2;
                                            try {
                                                if ((collection instanceof z72) && !(collection instanceof a82)) {
                                                    tj4.h0(collection, "kotlin.collections.MutableCollection");
                                                    throw null;
                                                }
                                                collection.remove(obj3);
                                                vf2.e(aVar2, null);
                                                list4 = list6;
                                                list4.remove(obj3);
                                                obj5 = null;
                                            } finally {
                                            }
                                        } else {
                                            list4 = list6;
                                            collection = collection2;
                                            obj5 = obj3;
                                        }
                                        if (j2 != j3) {
                                        }
                                    }
                                }
                                if (i7 == 0) {
                                    p6Var2.getLogger().h(p5.DEBUG, "Generated a video with no frames, not capturing a replay segment", new Object[0]);
                                    aVar3.g();
                                    try {
                                        io.sentry.android.core.d dVar3 = jVar2.Z;
                                        if (dVar3 != null) {
                                            dVar3.f();
                                        }
                                        jVar2.Z = null;
                                        vf2.e(aVar3, null);
                                        jVar2.n(file);
                                        cVar = null;
                                    } finally {
                                    }
                                } else {
                                    aVar3.g();
                                    try {
                                        io.sentry.android.core.d dVar4 = jVar2.Z;
                                        if (dVar4 != null) {
                                            dVar4.f();
                                        }
                                        io.sentry.android.core.d dVar5 = jVar2.Z;
                                        if (dVar5 != null) {
                                            io.sentry.android.replay.video.b bVar = (io.sentry.android.replay.video.b) dVar5.f;
                                            if (bVar.e != 0) {
                                                j5 = (bVar.f + bVar.a) / 1000;
                                            }
                                        }
                                        long j15 = j5;
                                        jVar2.Z = null;
                                        vf2.e(aVar3, null);
                                        jVar2.C(j7);
                                        cVar = new io.sentry.android.replay.c(file, i7, j15);
                                    } finally {
                                        try {
                                            throw th;
                                        } finally {
                                        }
                                    }
                                }
                                cVar2 = cVar;
                            } catch (Throwable th3) {
                                aVar = aVar3;
                                try {
                                    dVar.f();
                                    throw th3;
                                } catch (Throwable th4) {
                                    th = th4;
                                    Throwable th5 = th;
                                    try {
                                        throw th5;
                                    } catch (Throwable th6) {
                                        vf2.e(aVar, th5);
                                        throw th6;
                                    }
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            aVar = aVar3;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        aVar = aVar3;
                    }
                }
                if (cVar2 != null) {
                    File file2 = cVar2.a;
                    int i9 = cVar2.b;
                    long j16 = cVar2.c;
                    if (list == null) {
                        bh3 bh3Var = new bh3();
                        bh3Var.b = g41.b;
                        if (f1Var != null) {
                            f1Var.w(new io.sentry.android.fragment.c(bh3Var, 2));
                        }
                        list5 = (List) bh3Var.b;
                    } else {
                        list5 = list;
                    }
                    Date date2 = new Date(date.getTime() + j16);
                    r6 r6Var = new r6();
                    r6Var.b = wVar;
                    r6Var.J0 = wVar;
                    r6Var.K0 = i;
                    r6Var.L0 = date2;
                    r6Var.M0 = date;
                    r6Var.I0 = q6Var;
                    r6Var.G0 = file2;
                    r6Var.P0 = list2;
                    r6Var.Q0 = list3;
                    ArrayList arrayList3 = new ArrayList();
                    io.sentry.rrweb.j jVar3 = new io.sentry.rrweb.j();
                    jVar3.f = date.getTime();
                    jVar3.A = i2;
                    jVar3.X = i3;
                    arrayList3.add(jVar3);
                    io.sentry.rrweb.m mVar = new io.sentry.rrweb.m();
                    mVar.f = date.getTime();
                    mVar.A = i;
                    mVar.Y = j16;
                    mVar.B0 = i9;
                    mVar.X = file2.length();
                    mVar.D0 = i6;
                    mVar.z0 = i2;
                    mVar.A0 = i3;
                    mVar.E0 = 0;
                    mVar.F0 = 0;
                    arrayList3.add(mVar);
                    LinkedList linkedList = new LinkedList();
                    io.sentry.g gVar = null;
                    for (io.sentry.g gVar2 : list5) {
                        if (gVar == null || !n12.c(gVar.Z, "network.event")) {
                            z2 = false;
                        } else {
                            Map mapB = gVar.b();
                            mapB.getClass();
                            Object obj6 = mapB.get("action");
                            if (obj6 == null) {
                                obj6 = null;
                            }
                            if (n12.c(obj6, "NETWORK_AVAILABLE") && n12.c(gVar2.Z, "network.event") && gVar2.b().containsKey("network_type") && gVar2.c().getTime() + 5000 >= date.getTime()) {
                                z2 = z;
                            }
                        }
                        if ((gVar2.c().getTime() >= date.getTime() || z2) && gVar2.c().getTime() < date2.getTime() && (bVarA = p6Var.getReplayController().X().a(gVar2)) != null) {
                            arrayList3.add(bVarA);
                            io.sentry.rrweb.a aVar4 = bVarA instanceof io.sentry.rrweb.a ? (io.sentry.rrweb.a) bVarA : null;
                            if (n12.c(aVar4 != null ? aVar4.Y : null, "navigation")) {
                                io.sentry.rrweb.a aVar5 = (io.sentry.rrweb.a) bVarA;
                                ConcurrentHashMap concurrentHashMap = aVar5.z0;
                                if (concurrentHashMap == null || (obj4 = concurrentHashMap.get("to")) == null) {
                                    obj4 = null;
                                }
                                if (obj4 instanceof String) {
                                    ConcurrentHashMap concurrentHashMap2 = aVar5.z0;
                                    concurrentHashMap2.getClass();
                                    V v = concurrentHashMap2.get("to");
                                    v.getClass();
                                    linkedList.add((String) v);
                                }
                            }
                        }
                        gVar = gVar2;
                    }
                    if (str != null && !n12.c(d70.e0(linkedList), str)) {
                        linkedList.addFirst(str);
                    }
                    long time2 = date2.getTime();
                    Iterator it2 = deque.iterator();
                    it2.getClass();
                    while (it2.hasNext()) {
                        io.sentry.rrweb.b bVar2 = (io.sentry.rrweb.b) it2.next();
                        long j17 = bVar2.f;
                        if (j17 < time2) {
                            if (j17 >= date.getTime()) {
                                arrayList3.add(bVar2);
                            }
                            it2.remove();
                        }
                    }
                    if (i == 0) {
                        io.sentry.rrweb.k kVar3 = new io.sentry.rrweb.k(io.sentry.rrweb.c.Custom);
                        HashMap map = new HashMap();
                        kVar3.A = map;
                        kVar3.z = "options";
                        u sdkVersion = p6Var.getSdkVersion();
                        if (sdkVersion != null) {
                            map.put("nativeSdkName", sdkVersion.b);
                            map.put("nativeSdkVersion", sdkVersion.f);
                        }
                        t6 sessionReplay = p6Var.getSessionReplay();
                        Double d = sessionReplay.e;
                        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) sessionReplay.a;
                        map.put("errorSampleRate", d);
                        map.put("sessionSampleRate", sessionReplay.d);
                        map.put("maskAllImages", Boolean.valueOf(copyOnWriteArraySet.contains("android.widget.ImageView")));
                        map.put("maskAllText", Boolean.valueOf(copyOnWriteArraySet.contains("android.widget.TextView")));
                        map.put("quality", sessionReplay.f.serializedName());
                        map.put("maskedViewClasses", copyOnWriteArraySet);
                        map.put("unmaskedViewClasses", (CopyOnWriteArraySet) sessionReplay.b);
                        map.put("screenshotStrategy", sessionReplay.n == m4.PIXEL_COPY ? "pixelCopy" : "canvas");
                        map.put("networkDetailHasUrls", Boolean.valueOf(!sessionReplay.p.isEmpty()));
                        if (!sessionReplay.p.isEmpty()) {
                            map.put("networkDetailAllowUrls", sessionReplay.p);
                            map.put("networkRequestHeaders", sessionReplay.s);
                            map.put("networkResponseHeaders", sessionReplay.t);
                            map.put("networkCaptureBodies", Boolean.valueOf(sessionReplay.r));
                            if (!sessionReplay.q.isEmpty()) {
                                map.put("networkDetailDenyUrls", sessionReplay.q);
                            }
                        }
                        arrayList3.add(kVar3);
                    }
                    b4 b4Var = new b4();
                    b4Var.b = Integer.valueOf(i);
                    b4Var.f = d70.u0(arrayList3, new h());
                    r6Var.N0 = linkedList;
                    return new j(r6Var, b4Var);
                }
            } finally {
            }
        }
        return k.a;
    }
}
