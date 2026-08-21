package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iv1 implements wy3, sv {
    public static final byte[] Y = new byte[0];
    public static iv1 Z;
    public Object A;
    public Object X;
    public final /* synthetic */ int b;
    public Object f;
    public Object z;

    public iv1(Typeface typeface, yl2 yl2Var) {
        int i;
        int i2;
        int i3;
        int i4;
        this.b = 23;
        this.X = typeface;
        this.f = yl2Var;
        this.A = new zl2(1024);
        int iA = yl2Var.a(6);
        if (iA != 0) {
            int i5 = iA + yl2Var.b;
            i = ((ByteBuffer) yl2Var.A).getInt(((ByteBuffer) yl2Var.A).getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.z = new char[i * 2];
        int iA2 = yl2Var.a(6);
        if (iA2 != 0) {
            int i6 = iA2 + yl2Var.b;
            i2 = ((ByteBuffer) yl2Var.A).getInt(((ByteBuffer) yl2Var.A).getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            kk4 kk4Var = new kk4(this, i7);
            xl2 xl2VarB = kk4Var.b();
            int iA3 = xl2VarB.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) xl2VarB.A).getInt(iA3 + xl2VarB.b) : 0, (char[]) this.z, i7 * 2);
            xl2 xl2VarB2 = kk4Var.b();
            int iA4 = xl2VarB2.a(16);
            if (iA4 != 0) {
                int i8 = iA4 + xl2VarB2.b;
                i3 = ((ByteBuffer) xl2VarB2.A).getInt(((ByteBuffer) xl2VarB2.A).getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            r25.f(i3 > 0, "invalid metadata codepoint length");
            zl2 zl2Var = (zl2) this.A;
            xl2 xl2VarB3 = kk4Var.b();
            int iA5 = xl2VarB3.a(16);
            if (iA5 != 0) {
                int i9 = iA5 + xl2VarB3.b;
                i4 = ((ByteBuffer) xl2VarB3.A).getInt(((ByteBuffer) xl2VarB3.A).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            zl2Var.a(kk4Var, 0, i4 - 1);
        }
    }

    public static void b(iv1 iv1Var, qu2 qu2Var) {
        iv1Var.getClass();
        if (((LinkedHashSet) iv1Var.A).add(qu2Var)) {
            yp2 yp2Var = (yp2) iv1Var.z;
            if (qu2Var.c != null) {
                s53.t("Handler '", qu2Var, "' is already registered with a dispatcher");
                return;
            }
            yp2Var.e.addFirst(qu2Var);
            qu2Var.c = iv1Var;
            yp2Var.b();
        }
    }

    public static int k(int[] iArr) throws qs2 {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i) {
                i3 = i4;
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i3;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i3 <= i6) {
            int i11 = i3;
            i3 = i6;
            i6 = i11;
        }
        if (i3 - i6 <= length / 16) {
            throw qs2.a();
        }
        int i12 = i3 - 1;
        int i13 = -1;
        int i14 = i12;
        while (i12 > i6) {
            int i15 = i12 - i6;
            int i16 = (i2 - iArr[i12]) * (i3 - i12) * i15 * i15;
            if (i16 > i13) {
                i14 = i12;
                i13 = i16;
            }
            i12--;
        }
        return i14 << 3;
    }

    public static iv1 q() {
        iv1 iv1Var = Z;
        if (iv1Var != null) {
            return iv1Var;
        }
        iv1 iv1Var2 = new iv1(26);
        Z = iv1Var2;
        return iv1Var2;
    }

    public static void y(iv1 iv1Var, ie3 ie3Var, le3 le3Var, ie3 ie3Var2, int i) {
        cp1 cp1Var;
        if ((i & 1) != 0) {
            ie3Var = null;
        }
        if ((i & 2) != 0) {
            le3Var = null;
        }
        if ((i & 4) != 0) {
            ie3Var2 = null;
        }
        iv1Var.getClass();
        TimeZone timeZone = jz4.a;
        boolean zIsShutdown = iv1Var.l().isShutdown();
        synchronized (iv1Var) {
            if (le3Var != null) {
                try {
                    if (!((ArrayDeque) iv1Var.X).remove(le3Var)) {
                        throw new IllegalStateException("Call wasn't in-flight!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (ie3Var2 != null) {
                ie3Var2.f.decrementAndGet();
                if (!((ArrayDeque) iv1Var.A).remove(ie3Var2)) {
                    throw new IllegalStateException("Call wasn't in-flight!");
                }
            }
            if (ie3Var != null) {
                ((ArrayDeque) iv1Var.z).add(ie3Var);
                ie3 ie3VarM = iv1Var.m(((ev1) ie3Var.z.f.f).d);
                if (ie3VarM != null) {
                    ie3Var.f = ie3VarM.f;
                }
            }
            if ((le3Var != null || ie3Var2 != null) && (zIsShutdown || ((ArrayDeque) iv1Var.A).isEmpty())) {
                ((ArrayDeque) iv1Var.X).isEmpty();
            }
            int i2 = 24;
            if (zIsShutdown) {
                List listY0 = d70.y0((ArrayDeque) iv1Var.z);
                ((ArrayDeque) iv1Var.z).clear();
                cp1Var = new cp1(i2, listY0);
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayDeque) iv1Var.z).iterator();
                it.getClass();
                while (it.hasNext()) {
                    ie3 ie3Var3 = (ie3) it.next();
                    if (((ArrayDeque) iv1Var.A).size() >= 64) {
                        break;
                    }
                    if (ie3Var3.f.get() < 5) {
                        it.remove();
                        ie3Var3.f.incrementAndGet();
                        arrayList.add(ie3Var3);
                        ((ArrayDeque) iv1Var.A).add(ie3Var3);
                    }
                }
                cp1Var = new cp1(i2, arrayList);
            }
        }
        int size = ((List) cp1Var.f).size();
        for (int i3 = 0; i3 < size; i3++) {
            ie3 ie3Var4 = (ie3) ((List) cp1Var.f).get(i3);
            if (ie3Var4 != ie3Var) {
                le3 le3Var2 = ie3Var4.z;
            }
            if (zIsShutdown) {
                ie3Var4.getClass();
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(null);
                le3 le3Var3 = ie3Var4.z;
                le3Var3.i(interruptedIOException);
                ie3Var4.b.o(le3Var3, interruptedIOException);
            } else {
                ExecutorService executorServiceL = iv1Var.l();
                ie3Var4.getClass();
                le3 le3Var4 = ie3Var4.z;
                le3Var4.b.a.getClass();
                try {
                    try {
                        executorServiceL.execute(ie3Var4);
                    } catch (Throwable th2) {
                        iv1 iv1Var2 = le3Var4.b.a;
                        iv1Var2.getClass();
                        y(iv1Var2, null, null, ie3Var4, 3);
                        throw th2;
                    }
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException2 = new InterruptedIOException("executor rejected");
                    interruptedIOException2.initCause(e);
                    le3 le3Var5 = ie3Var4.z;
                    le3Var5.i(interruptedIOException2);
                    ie3Var4.b.o(le3Var5, interruptedIOException2);
                    iv1 iv1Var3 = le3Var4.b.a;
                    iv1Var3.getClass();
                    y(iv1Var3, null, null, ie3Var4, 3);
                }
            }
        }
    }

    public void A(pl plVar) {
        synchronized (this.f) {
            try {
                if (r(plVar)) {
                    qy3 qy3Var = (qy3) this.A;
                    if (qy3Var.c) {
                        qy3Var.c = false;
                        C(qy3Var);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object B(ie0 ie0Var) throws Throwable {
        zn3 zn3Var;
        wn2 wn2Var;
        Throwable th;
        wn2 wn2Var2;
        iv1 iv1Var;
        if (ie0Var instanceof zn3) {
            zn3Var = (zn3) ie0Var;
            int i = zn3Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                zn3Var.y0 = i - Integer.MIN_VALUE;
            } else {
                zn3Var = new zn3(this, ie0Var);
            }
        }
        Object obj = zn3Var.Y;
        int i2 = zn3Var.y0;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        try {
            if (i2 == 0) {
                n12.S(obj);
                if (((o80) this.z).P()) {
                    return xl4Var;
                }
                wn2Var = (yn2) this.f;
                zn3Var.A = this;
                zn3Var.X = wn2Var;
                zn3Var.y0 = 1;
                if (wn2Var.g(zn3Var) != mf0Var) {
                }
                return mf0Var;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                wn2Var2 = zn3Var.X;
                iv1Var = zn3Var.A;
                try {
                    n12.S(obj);
                    ((o80) iv1Var.z).S(xl4Var);
                    wn2Var2.n(null);
                    return xl4Var;
                } catch (Throwable th2) {
                    th = th2;
                    wn2Var2.n(null);
                    throw th;
                }
            }
            wn2 wn2Var3 = zn3Var.X;
            iv1 iv1Var2 = zn3Var.A;
            n12.S(obj);
            wn2Var = wn2Var3;
            this = iv1Var2;
            if (((o80) this.z).P()) {
                wn2Var.n(null);
                return xl4Var;
            }
            zn3Var.A = this;
            zn3Var.X = wn2Var;
            zn3Var.y0 = 2;
            if (this.j(zn3Var) != mf0Var) {
                iv1Var = this;
                wn2Var2 = wn2Var;
                ((o80) iv1Var.z).S(xl4Var);
                wn2Var2.n(null);
                return xl4Var;
            }
            return mf0Var;
        } catch (Throwable th3) {
            wn2 wn2Var4 = wn2Var;
            th = th3;
            wn2Var2 = wn2Var4;
            wn2Var2.n(null);
            throw th;
        }
    }

    public void C(qy3 qy3Var) {
        Handler handler = (Handler) this.z;
        int i = qy3Var.b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        handler.removeCallbacksAndMessages(qy3Var);
        handler.sendMessageDelayed(Message.obtain(handler, 0, qy3Var), i);
    }

    public void D() {
        qy3 qy3Var = (qy3) this.X;
        if (qy3Var != null) {
            this.A = qy3Var;
            this.X = null;
            pl plVar = (pl) qy3Var.a.get();
            if (plVar == null) {
                this.A = null;
            } else {
                Handler handler = sl.y;
                handler.sendMessage(handler.obtainMessage(0, plVar.a));
            }
        }
    }

    public void E(h24 h24Var) {
        h24Var.getClass();
        xy0 xy0Var = new xy0(24, this, h24Var);
        synchronized (this.A) {
        }
        ((Handler) ((w7) this.f).f).postDelayed(xy0Var, 5400000L);
    }

    @Override // defpackage.wy3
    public lz3 a() {
        return (km0) this.A;
    }

    public void c(xp2 xp2Var) {
        if (((LinkedHashSet) this.X).add(xp2Var)) {
            ((yp2) this.z).a(this, xp2Var, -1);
        }
    }

    public void d(pu2 pu2Var, int i) {
        if (i != 1 && i != 0) {
            e04.f(dw2.A(i, "Unsupported priority value: "));
        } else if (((LinkedHashSet) this.X).add(pu2Var)) {
            ((yp2) this.z).a(this, pu2Var, i);
        }
    }

    public te3 e() {
        Context context = (Context) this.f;
        em0 em0Var = (em0) this.z;
        final int i = 0;
        n84 n84Var = new n84(new pl1(this) { // from class: ey1
            public final /* synthetic */ iv1 f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int largeMemoryClass;
                qe3 qe3Var;
                int i2 = i;
                iv1 iv1Var = this.f;
                switch (i2) {
                    case 0:
                        Context context2 = (Context) iv1Var.f;
                        Bitmap.Config config = j.a;
                        double d = 0.2d;
                        try {
                            Object systemService = context2.getSystemService((Class<Object>) ActivityManager.class);
                            systemService.getClass();
                            if (((ActivityManager) systemService).isLowRamDevice()) {
                                d = 0.15d;
                            }
                        } catch (Exception unused) {
                        }
                        int i3 = 0;
                        t6 t6Var = new t6((byte) 0, 8);
                        if (d > 0.0d) {
                            Bitmap.Config config2 = j.a;
                            try {
                                Object systemService2 = context2.getSystemService((Class<Object>) ActivityManager.class);
                                systemService2.getClass();
                                ActivityManager activityManager = (ActivityManager) systemService2;
                                largeMemoryClass = (context2.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                            } catch (Exception unused2) {
                                largeMemoryClass = 256;
                            }
                            i3 = (int) (d * ((double) largeMemoryClass) * 1024.0d * 1024.0d);
                            break;
                        }
                        return new we3(i3 > 0 ? new v62(i3, t6Var) : new w7(27, t6Var), t6Var);
                    default:
                        k01 k01Var = k01.y0;
                        Context context3 = (Context) iv1Var.f;
                        synchronized (k01Var) {
                            try {
                                qe3Var = k01.z0;
                                if (qe3Var == null) {
                                    x72 x72Var = ge1.b;
                                    gm0 gm0Var = qv0.a;
                                    pl0 pl0Var = pl0.z;
                                    Bitmap.Config config3 = j.a;
                                    File cacheDir = context3.getCacheDir();
                                    if (cacheDir == null) {
                                        throw new IllegalStateException("cacheDir == null");
                                    }
                                    cacheDir.mkdirs();
                                    File fileV = le1.V(cacheDir);
                                    String str = u03.f;
                                    u03 u03VarR = pr1.r(fileV);
                                    long jW = 10485760;
                                    try {
                                        File file = u03VarR.toFile();
                                        file.mkdir();
                                        StatFs statFs = new StatFs(file.getAbsolutePath());
                                        jW = gb4.w((long) (0.02d * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), 10485760L, 262144000L);
                                        break;
                                    } catch (Exception unused3) {
                                    }
                                    qe3 qe3Var2 = new qe3(jW, pl0Var, x72Var, u03VarR);
                                    k01.z0 = qe3Var2;
                                    qe3Var = qe3Var2;
                                }
                            } finally {
                            }
                        }
                        return qe3Var;
                }
            }
        });
        final int i2 = 1;
        n84 n84Var2 = new n84(new pl1(this) { // from class: ey1
            public final /* synthetic */ iv1 f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int largeMemoryClass;
                qe3 qe3Var;
                int i22 = i2;
                iv1 iv1Var = this.f;
                switch (i22) {
                    case 0:
                        Context context2 = (Context) iv1Var.f;
                        Bitmap.Config config = j.a;
                        double d = 0.2d;
                        try {
                            Object systemService = context2.getSystemService((Class<Object>) ActivityManager.class);
                            systemService.getClass();
                            if (((ActivityManager) systemService).isLowRamDevice()) {
                                d = 0.15d;
                            }
                        } catch (Exception unused) {
                        }
                        int i3 = 0;
                        t6 t6Var = new t6((byte) 0, 8);
                        if (d > 0.0d) {
                            Bitmap.Config config2 = j.a;
                            try {
                                Object systemService2 = context2.getSystemService((Class<Object>) ActivityManager.class);
                                systemService2.getClass();
                                ActivityManager activityManager = (ActivityManager) systemService2;
                                largeMemoryClass = (context2.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                            } catch (Exception unused2) {
                                largeMemoryClass = 256;
                            }
                            i3 = (int) (d * ((double) largeMemoryClass) * 1024.0d * 1024.0d);
                            break;
                        }
                        return new we3(i3 > 0 ? new v62(i3, t6Var) : new w7(27, t6Var), t6Var);
                    default:
                        k01 k01Var = k01.y0;
                        Context context3 = (Context) iv1Var.f;
                        synchronized (k01Var) {
                            try {
                                qe3Var = k01.z0;
                                if (qe3Var == null) {
                                    x72 x72Var = ge1.b;
                                    gm0 gm0Var = qv0.a;
                                    pl0 pl0Var = pl0.z;
                                    Bitmap.Config config3 = j.a;
                                    File cacheDir = context3.getCacheDir();
                                    if (cacheDir == null) {
                                        throw new IllegalStateException("cacheDir == null");
                                    }
                                    cacheDir.mkdirs();
                                    File fileV = le1.V(cacheDir);
                                    String str = u03.f;
                                    u03 u03VarR = pr1.r(fileV);
                                    long jW = 10485760;
                                    try {
                                        File file = u03VarR.toFile();
                                        file.mkdir();
                                        StatFs statFs = new StatFs(file.getAbsolutePath());
                                        jW = gb4.w((long) (0.02d * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), 10485760L, 262144000L);
                                        break;
                                    } catch (Exception unused3) {
                                    }
                                    qe3 qe3Var2 = new qe3(jW, pl0Var, x72Var, u03VarR);
                                    k01.z0 = qe3Var2;
                                    qe3Var = qe3Var2;
                                }
                            } finally {
                            }
                        }
                        return qe3Var;
                }
            }
        });
        n84 n84Var3 = new n84(new t4(8));
        o90 o90Var = (o90) this.A;
        if (o90Var == null) {
            g41 g41Var = g41.b;
            o90Var = new o90(g41Var, g41Var, g41Var, g41Var, g41Var);
        }
        return new te3(context, em0Var, n84Var, n84Var2, n84Var3, o90Var, (wl3) this.X);
    }

    public void f(h24 h24Var) {
        Runnable runnable;
        h24Var.getClass();
        synchronized (this.A) {
            runnable = (Runnable) ((LinkedHashMap) this.X).remove(h24Var);
        }
        if (runnable != null) {
            ((Handler) ((w7) this.f).f).removeCallbacks(runnable);
        }
    }

    public boolean g(qy3 qy3Var, int i) {
        pl plVar = (pl) qy3Var.a.get();
        if (plVar == null) {
            return false;
        }
        ((Handler) this.z).removeCallbacksAndMessages(qy3Var);
        Handler handler = sl.y;
        handler.sendMessage(handler.obtainMessage(1, i, 0, plVar.a));
        return true;
    }

    public void h(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            zo2.w("This graph contains cyclic dependencies");
            return;
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((xw3) this.z).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                h(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public void i(xp2 xp2Var, vp2 vp2Var) {
        yp2 yp2Var = (yp2) this.z;
        if (yp2Var.g != 0) {
            return;
        }
        qu2 qu2VarC = yp2Var.c(-1);
        yp2Var.f = qu2VarC;
        yp2Var.g = -1;
        yp2Var.h = xp2Var;
        if (vp2Var != null) {
            if (qu2VarC != null) {
                qu2VarC.d.d(new yh(vp2Var));
            }
            yp2Var.a.j(null, new aq2(vp2Var));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        if (r7 == r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
    
        if (r7 == r2) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object j(ie0 ie0Var) {
        ri0 ri0Var;
        fi0 fi0Var;
        lj0 lj0Var = (lj0) this.X;
        if (ie0Var instanceof ri0) {
            ri0Var = (ri0) ie0Var;
            int i = ri0Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                ri0Var.Z = i - Integer.MIN_VALUE;
            } else {
                ri0Var = new ri0(this, ie0Var);
            }
        }
        Object objH = ri0Var.X;
        int i2 = ri0Var.Z;
        if (i2 == 0) {
            n12.S(objH);
            List list = (List) this.A;
            mf0 mf0Var = mf0.b;
            if (list == null || list.isEmpty()) {
                ri0Var.A = this;
                ri0Var.Z = 1;
                objH = lj0Var.h(false, ri0Var);
            } else {
                nx3 nx3VarC = lj0Var.c();
                ui0 ui0Var = new ui0(lj0Var, this, null);
                ri0Var.A = this;
                ri0Var.Z = 2;
                objH = nx3VarC.b(ui0Var, ri0Var);
            }
            return mf0Var;
        }
        if (i2 == 1) {
            this = ri0Var.A;
            n12.S(objH);
            fi0Var = (fi0) objH;
        } else {
            if (i2 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            this = ri0Var.A;
            n12.S(objH);
            fi0Var = (fi0) objH;
        }
        ((lj0) this.X).y0.x(fi0Var);
        return xl4.a;
    }

    public synchronized ExecutorService l() {
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = (ThreadPoolExecutor) this.f;
        if (threadPoolExecutor == null) {
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(0, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new iz4(jz4.b + " Dispatcher", false));
            this.f = threadPoolExecutor2;
            threadPoolExecutor = threadPoolExecutor2;
        }
        return threadPoolExecutor;
    }

    public ie3 m(String str) {
        Iterator it = ((ArrayDeque) this.A).iterator();
        it.getClass();
        while (it.hasNext()) {
            ie3 ie3Var = (ie3) it.next();
            if (n12.c(((ev1) ie3Var.z.f.f).d, str)) {
                return ie3Var;
            }
        }
        Iterator it2 = ((ArrayDeque) this.z).iterator();
        it2.getClass();
        while (it2.hasNext()) {
            ie3 ie3Var2 = (ie3) it2.next();
            if (n12.c(((ev1) ie3Var2.z.f.f).d, str)) {
                return ie3Var2;
            }
        }
        return null;
    }

    public w54 n(u3 u3Var) {
        ArrayList arrayList = (ArrayList) this.A;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            w54 w54Var = (w54) arrayList.get(i);
            if (w54Var != null && w54Var.b == u3Var) {
                return w54Var;
            }
        }
        w54 w54Var2 = new w54((Context) this.z, u3Var);
        arrayList.add(w54Var2);
        return w54Var2;
    }

    @Override // defpackage.sv
    public void o(le3 le3Var, IOException iOException) {
        ArrayList arrayList = (ArrayList) this.f;
        synchronized (arrayList) {
            arrayList.add(iOException);
        }
        ((CountDownLatch) this.z).countDown();
    }

    @Override // defpackage.wy3
    public vx3 p() {
        return (jm0) this.X;
    }

    public boolean r(pl plVar) {
        qy3 qy3Var = (qy3) this.A;
        return (qy3Var == null || plVar == null || qy3Var.a.get() != plVar) ? false : true;
    }

    public od3 s(String str) {
        HashMap map = (HashMap) this.z;
        od3 od3Var = (od3) map.get(str);
        if (od3Var == null) {
            int iIndexOf = str.indexOf(64);
            String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
            if (!strSubstring.equals(str)) {
                return (od3) map.get(strSubstring);
            }
        }
        return od3Var;
    }

    @Override // defpackage.sv
    public void t(le3 le3Var, kk3 kk3Var) {
        String str = (String) this.A;
        ArrayList arrayList = (ArrayList) this.X;
        ArrayList arrayList2 = (ArrayList) this.f;
        try {
            ArrayList arrayListB = pw0.b(kk3Var, str);
            synchronized (arrayList) {
                arrayList.addAll(arrayListB);
            }
        } catch (Exception e) {
            synchronized (arrayList2) {
                arrayList2.add(e);
            }
        }
        ((CountDownLatch) this.z).countDown();
    }

    public String toString() {
        switch (this.b) {
            case 8:
                String string = ((Socket) this.f).toString();
                string.getClass();
                return string;
            default:
                return super.toString();
        }
    }

    public boolean u(u3 u3Var, sk2 sk2Var) {
        return ((ActionMode.Callback) this.f).onActionItemClicked(n(u3Var), new xk2((Context) this.z, sk2Var));
    }

    public boolean v(u3 u3Var, nk2 nk2Var) {
        ActionMode.Callback callback = (ActionMode.Callback) this.f;
        w54 w54VarN = n(u3Var);
        xw3 xw3Var = (xw3) this.X;
        Menu jl2Var = (Menu) xw3Var.get(nk2Var);
        if (jl2Var == null) {
            jl2Var = new jl2((Context) this.z, nk2Var);
            xw3Var.put(nk2Var, jl2Var);
        }
        return callback.onCreateActionMode(w54VarN, jl2Var);
    }

    public void w(pl plVar) {
        synchronized (this.f) {
            try {
                if (r(plVar)) {
                    qy3 qy3Var = (qy3) this.A;
                    if (!qy3Var.c) {
                        qy3Var.c = true;
                        ((Handler) this.z).removeCallbacksAndMessages(qy3Var);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void x(int i) {
        ListView listView = (ListView) this.f;
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        listView.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        float f = i;
        MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 2, 0.0f, f, 0);
        listView.onTouchEvent(motionEventObtain2);
        motionEventObtain2.recycle();
        MotionEvent motionEventObtain3 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, f, 0);
        listView.onTouchEvent(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    public InetAddress z(String str) {
        str.getClass();
        int size = ((HashMap) this.f).size();
        int i = eb1.c;
        if (size >= i) {
            String strA = dw2.A(i, "map size exceeded: ");
            if (fy4.b) {
                Xlog.logWrite2(0L, 4, "FakeIpMapper", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strA);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.e("FakeIpMapper", strA, null);
            }
            return null;
        }
        HashMap map = (HashMap) this.f;
        Object objValueOf = map.get(str);
        if (objValueOf == null) {
            int size2 = ((HashMap) this.f).size() + eb1.a;
            ((HashMap) this.z).put(Integer.valueOf(size2), str);
            objValueOf = Integer.valueOf(size2);
            map.put(str, objValueOf);
        }
        int iIntValue = ((Number) objValueOf).intValue();
        try {
            InetAddress byAddress = InetAddress.getByAddress(new byte[]{(byte) ((iIntValue >> 24) & DnsRecord.CLASS_ANY), (byte) ((iIntValue >> 16) & DnsRecord.CLASS_ANY), (byte) ((iIntValue >> 8) & DnsRecord.CLASS_ANY), (byte) (iIntValue & DnsRecord.CLASS_ANY)});
            byAddress.getClass();
            return byAddress;
        } catch (UnknownHostException e) {
            throw new AssertionError("format ip failed", e);
        }
    }

    public /* synthetic */ iv1(MaterialCardView materialCardView, TextView textView, View view, TextView textView2, MaterialTextView materialTextView, int i) {
        this.b = i;
        this.f = textView;
        this.z = view;
        this.A = textView2;
        this.X = materialTextView;
    }

    public /* synthetic */ iv1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
        this.X = obj4;
    }

    public iv1(int i) {
        this.b = i;
        int i2 = 0;
        switch (i) {
            case 11:
                this.f = new c23(10);
                this.z = new xw3(0);
                this.A = new ArrayList();
                this.X = new HashSet();
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                this.z = new ArrayDeque();
                this.A = new ArrayDeque();
                this.X = new ArrayDeque();
                break;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                this.f = new HashMap();
                this.z = new HashMap();
                this.A = new ConcurrentHashMap();
                gm0 gm0Var = qv0.a;
                pl0 pl0Var = pl0.z;
                r54 r54VarD = gb4.d();
                pl0Var.getClass();
                this.X = p95.a(tj4.W(pl0Var, r54VarD));
                break;
            case 26:
                this.f = new Object();
                this.z = new Handler(Looper.getMainLooper(), new py3(i2, this));
                break;
            default:
                this.f = new float[3];
                this.z = new float[360];
                this.A = new int[20];
                this.X = new SparseArray();
                break;
        }
    }

    public iv1(w7 w7Var, e24 e24Var) {
        this.b = 29;
        this.f = w7Var;
        this.z = e24Var;
        this.A = new Object();
        this.X = new LinkedHashMap();
    }

    public iv1(lf0 lf0Var, ij0 ij0Var, hj hjVar) {
        this.b = 25;
        this.f = lf0Var;
        this.z = hjVar;
        this.A = uf2.a(ChannelUtils.WRITE_STATUS_SNDBUF_FULL, null, null, 6);
        this.X = new cp1(7);
        v32 v32Var = (v32) lf0Var.I().Z(pr1.X);
        if (v32Var != null) {
            v32Var.M(new ze0(1, ij0Var, this));
        }
    }

    public iv1(eo1 eo1Var) {
        this.b = 14;
        this.f = eo1Var;
    }

    public iv1(Socket socket) {
        this.b = 8;
        this.f = socket;
        this.z = new AtomicInteger();
        this.A = new km0(this);
        this.X = new jm0(this);
    }

    public iv1(kf2 kf2Var) {
        this.b = 0;
        this.b = 0;
        this.f = kf2Var;
        this.z = Y;
        this.A = new int[32];
    }

    public iv1(bd4 bd4Var) {
        this.b = 28;
        this.f = new HashMap();
        this.z = new HashMap();
        this.A = new HashMap();
        this.X = bd4Var;
    }

    public iv1(ConstraintLayout constraintLayout, MaterialButton materialButton, TextInputLayout textInputLayout, MaterialButton materialButton2, TextView textView, LoadingIndicator loadingIndicator, MaterialButton materialButton3) {
        this.b = 9;
        this.f = textInputLayout;
        this.z = materialButton2;
        this.A = loadingIndicator;
        this.X = materialButton3;
    }

    public iv1(fn fnVar, int i) {
        this.b = 4;
        Object obj = (i & 1) != 0 ? w10.z : fnVar;
        x10 x10Var = x10.z;
        x10 x10Var2 = x10.A;
        x10 x10Var3 = x10.X;
        this.f = obj;
        this.z = x10Var;
        this.A = x10Var2;
        this.X = x10Var3;
    }

    public iv1(jd jdVar) {
        this.b = 24;
        this.f = jdVar;
        this.z = new yp2();
        new LinkedHashSet();
        this.A = new LinkedHashSet();
        this.X = new LinkedHashSet();
    }

    public iv1(a00 a00Var, ow owVar, vx vxVar, e24 e24Var) {
        this.b = 3;
        a00Var.getClass();
        owVar.getClass();
        vxVar.getClass();
        e24Var.getClass();
        this.f = a00Var;
        this.z = owVar;
        this.A = vxVar;
        this.X = e24Var;
    }

    public /* synthetic */ iv1(int i, boolean z) {
        this.b = i;
    }

    public iv1(wn1 wn1Var) {
        this.b = 19;
        this.f = new eg0(27);
        this.z = new eg0(27);
        this.X = new o84(0);
    }

    public iv1(ArrayList arrayList, CountDownLatch countDownLatch, pw0 pw0Var, String str, ArrayList arrayList2) {
        this.b = 13;
        this.f = arrayList;
        this.z = countDownLatch;
        this.A = str;
        this.X = arrayList2;
    }

    public iv1(Context context) {
        this.b = 20;
        this.f = context.getApplicationContext();
        this.z = h.a;
        this.A = null;
        this.X = new wl3(21);
    }

    public iv1(Context context, ActionMode.Callback callback) {
        this.b = 27;
        this.z = context;
        this.f = callback;
        this.A = new ArrayList();
        this.X = new xw3(0);
    }

    public iv1(lj0 lj0Var, List list) {
        this.b = 6;
        this.X = lj0Var;
        this.f = new yn2();
        this.z = vo.a();
        this.A = d70.y0(list);
    }
}
