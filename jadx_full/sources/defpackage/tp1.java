package defpackage;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tp1 implements Handler.Callback {
    public static final Status o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);
    public static final Status p = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object q = new Object();
    public static tp1 r;
    public long a;
    public boolean b;
    public eb4 c;
    public n05 d;
    public final Context e;
    public final lp1 f;
    public final rz4 g;
    public final AtomicInteger h;
    public final AtomicInteger i;
    public final ConcurrentHashMap j;
    public final me k;
    public final me l;
    public final s05 m;
    public volatile boolean n;

    public tp1(Context context, Looper looper) {
        lp1 lp1Var = lp1.d;
        this.a = 10000L;
        this.b = false;
        this.h = new AtomicInteger(1);
        this.i = new AtomicInteger(0);
        this.j = new ConcurrentHashMap(5, 0.75f, 1);
        this.k = new me(0);
        this.l = new me(0);
        this.n = true;
        this.e = context;
        s05 s05Var = new s05(looper, this);
        Looper.getMainLooper();
        this.m = s05Var;
        this.f = lp1Var;
        this.g = new rz4(1);
        PackageManager packageManager = context.getPackageManager();
        Boolean boolValueOf = tj4.k;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(vf2.v() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
            tj4.k = boolValueOf;
        }
        if (boolValueOf.booleanValue()) {
            this.n = false;
        }
        s05Var.sendMessage(s05Var.obtainMessage(6));
    }

    public static Status b(x9 x9Var, ab0 ab0Var) {
        w7 w7Var = x9Var.b;
        return new Status(17, "API: ClientTelemetry.API is not available on this device. Connection failed with: ".concat(String.valueOf(ab0Var)), ab0Var.z, ab0Var);
    }

    public static tp1 e(Context context) {
        tp1 tp1Var;
        synchronized (q) {
            try {
                tp1Var = r;
                if (tp1Var == null) {
                    Looper looper = bg5.b().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = lp1.c;
                    tp1 tp1Var2 = new tp1(applicationContext, looper);
                    r = tp1Var2;
                    tp1Var = tp1Var2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tp1Var;
    }

    public final boolean a(ab0 ab0Var, int i) {
        lp1 lp1Var = this.f;
        lp1Var.getClass();
        Context context = this.e;
        if (!v02.r(context)) {
            int i2 = ab0Var.f;
            PendingIntent pendingIntentO = ab0Var.z;
            if (!((i2 == 0 || pendingIntentO == null) ? false : true)) {
                pendingIntentO = null;
                Intent intentA = lp1Var.a(i2, context, null);
                if (intentA != null) {
                    pendingIntentO = l72.o(context, 0, intentA, false);
                }
            }
            if (pendingIntentO != null) {
                int i3 = GoogleApiActivity.f;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", pendingIntentO);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                lp1Var.f(context, i2, PendingIntent.getActivity(context, 0, intent, p05.a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final sz4 c(kp1 kp1Var) {
        x9 x9Var = kp1Var.e;
        ConcurrentHashMap concurrentHashMap = this.j;
        sz4 sz4Var = (sz4) concurrentHashMap.get(x9Var);
        if (sz4Var == null) {
            sz4Var = new sz4(this, kp1Var);
            concurrentHashMap.put(x9Var, sz4Var);
        }
        if (sz4Var.d.j()) {
            this.l.add(x9Var);
        }
        sz4Var.m();
        return sz4Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d() {
        eb4 eb4Var = this.c;
        if (eb4Var != null) {
            if (eb4Var.b > 0) {
                n05 n05Var = this.d;
                if (n05Var == null) {
                    n05 n05Var2 = new n05(this.e, n05.i, fb4.b, jp1.b);
                    this.d = n05Var2;
                    n05Var = n05Var2;
                }
                n05Var.b(eb4Var);
            } else if (!this.b) {
                synchronized (wl3.class) {
                    if (wl3.f == null) {
                        wl3.f = new wl3(0);
                    }
                }
                int i = ((SparseIntArray) this.g.f).get(203400000, -1);
                if (i == -1 || i == 0) {
                }
            }
            this.c = null;
        }
    }

    public final void f(ab0 ab0Var, int i) {
        if (a(ab0Var, i)) {
            return;
        }
        s05 s05Var = this.m;
        s05Var.sendMessage(s05Var.obtainMessage(5, i, 0, ab0Var));
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) {
        sz4 sz4Var;
        boolean z;
        ic1[] ic1VarArrB;
        Context context = this.e;
        me meVar = this.l;
        s05 s05Var = this.m;
        ConcurrentHashMap concurrentHashMap = this.j;
        int i = message.what;
        int i2 = 0;
        switch (i) {
            case 1:
                this.a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                s05Var.removeMessages(12);
                Iterator it = concurrentHashMap.keySet().iterator();
                while (it.hasNext()) {
                    s05Var.sendMessageDelayed(s05Var.obtainMessage(12, (x9) it.next()), this.a);
                }
                return true;
            case 2:
                message.obj.getClass();
                st4.n();
                return false;
            case 3:
                for (sz4 sz4Var2 : concurrentHashMap.values()) {
                    tj4.e(sz4Var2.n.m);
                    sz4Var2.m = null;
                    sz4Var2.m();
                }
                return true;
            case 4:
            case 8:
            case 13:
                a05 a05Var = (a05) message.obj;
                n05 n05Var = a05Var.c;
                j05 j05Var = a05Var.a;
                sz4 sz4VarC = (sz4) concurrentHashMap.get(n05Var.e);
                if (sz4VarC == null) {
                    sz4VarC = c(a05Var.c);
                }
                if (!sz4VarC.d.j() || this.i.get() == a05Var.b) {
                    sz4VarC.n(j05Var);
                    return true;
                }
                j05Var.c(o);
                sz4VarC.q();
                return true;
            case 5:
                int i3 = message.arg1;
                ab0 ab0Var = (ab0) message.obj;
                Iterator it2 = concurrentHashMap.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        sz4Var = (sz4) it2.next();
                        if (sz4Var.i == i3) {
                        }
                    } else {
                        sz4Var = null;
                    }
                }
                if (sz4Var == null) {
                    a1.p("GoogleApiManager", ha0.k("Could not find API instance ", i3, " while trying to fail enqueued calls."), new Exception());
                    return true;
                }
                int i4 = ab0Var.f;
                if (i4 != 13) {
                    sz4Var.e(b(sz4Var.e, ab0Var));
                    return true;
                }
                this.f.getClass();
                int i5 = up1.e;
                sz4Var.e(new Status(17, fw.u("Error resolution was canceled by the user, original error message: ", ab0.a(i4), ": ", ab0Var.A), null, null));
                return true;
            case 6:
                if (context.getApplicationContext() instanceof Application) {
                    di.b((Application) context.getApplicationContext());
                    di diVar = di.X;
                    diVar.a(new pz4(this));
                    AtomicBoolean atomicBoolean = diVar.b;
                    AtomicBoolean atomicBoolean2 = diVar.f;
                    if (atomicBoolean2.get()) {
                        z = atomicBoolean.get();
                        if (!z) {
                            this.a = 300000L;
                            return true;
                        }
                    } else if (u9.G()) {
                        z = true;
                        if (!z) {
                        }
                    } else {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!atomicBoolean2.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            atomicBoolean.set(true);
                        }
                        z = atomicBoolean.get();
                        if (!z) {
                        }
                    }
                }
                return true;
            case 7:
                c((kp1) message.obj);
                return true;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                if (concurrentHashMap.containsKey(message.obj)) {
                    sz4 sz4Var3 = (sz4) concurrentHashMap.get(message.obj);
                    tj4.e(sz4Var3.n.m);
                    if (sz4Var3.k) {
                        sz4Var3.m();
                        return true;
                    }
                }
                return true;
            case 10:
                meVar.getClass();
                ee eeVar = new ee(meVar);
                while (eeVar.hasNext()) {
                    sz4 sz4Var4 = (sz4) concurrentHashMap.remove((x9) eeVar.next());
                    if (sz4Var4 != null) {
                        sz4Var4.q();
                    }
                }
                meVar.clear();
                return true;
            case 11:
                if (concurrentHashMap.containsKey(message.obj)) {
                    sz4 sz4Var5 = (sz4) concurrentHashMap.get(message.obj);
                    tp1 tp1Var = sz4Var5.n;
                    tj4.e(tp1Var.m);
                    boolean z2 = sz4Var5.k;
                    if (z2) {
                        x9 x9Var = sz4Var5.e;
                        s05 s05Var2 = sz4Var5.n.m;
                        if (z2) {
                            s05Var2.removeMessages(11, x9Var);
                            s05Var2.removeMessages(9, x9Var);
                            sz4Var5.k = false;
                        }
                        sz4Var5.e(tp1Var.f.b(tp1Var.e, mp1.a) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.", null, null) : new Status(22, "API failed to connect while resuming due to an unknown error.", null, null));
                        sz4Var5.d.b("Timing out connection while resuming.");
                        return true;
                    }
                }
                return true;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                if (concurrentHashMap.containsKey(message.obj)) {
                    sz4 sz4Var6 = (sz4) concurrentHashMap.get(message.obj);
                    tj4.e(sz4Var6.n.m);
                    t9 t9Var = sz4Var6.d;
                    if (t9Var.isConnected() && sz4Var6.h.isEmpty()) {
                        e24 e24Var = sz4Var6.f;
                        if (((Map) e24Var.f).isEmpty() && ((Map) e24Var.z).isEmpty()) {
                            t9Var.b("Timing out service connection.");
                            return true;
                        }
                        sz4Var6.j();
                    }
                    return true;
                }
                return true;
            case 14:
                message.obj.getClass();
                st4.n();
                return false;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                tz4 tz4Var = (tz4) message.obj;
                if (concurrentHashMap.containsKey(tz4Var.a)) {
                    sz4 sz4Var7 = (sz4) concurrentHashMap.get(tz4Var.a);
                    if (sz4Var7.l.contains(tz4Var) && !sz4Var7.k) {
                        if (sz4Var7.d.isConnected()) {
                            sz4Var7.g();
                            return true;
                        }
                        sz4Var7.m();
                        return true;
                    }
                }
                return true;
            case 16:
                tz4 tz4Var2 = (tz4) message.obj;
                if (concurrentHashMap.containsKey(tz4Var2.a)) {
                    sz4 sz4Var8 = (sz4) concurrentHashMap.get(tz4Var2.a);
                    ArrayList arrayList = sz4Var8.l;
                    tp1 tp1Var2 = sz4Var8.n;
                    LinkedList<yz4> linkedList = sz4Var8.c;
                    if (arrayList.remove(tz4Var2)) {
                        tp1Var2.m.removeMessages(15, tz4Var2);
                        tp1Var2.m.removeMessages(16, tz4Var2);
                        ic1 ic1Var = tz4Var2.b;
                        ArrayList arrayList2 = new ArrayList(linkedList.size());
                        for (yz4 yz4Var : linkedList) {
                            if (yz4Var != null && (ic1VarArrB = yz4Var.b(sz4Var8)) != null) {
                                int length = ic1VarArrB.length;
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= length) {
                                    }
                                    if (!gb4.I(ic1VarArrB[i6], ic1Var)) {
                                        i6++;
                                    } else if (i6 >= 0) {
                                        arrayList2.add(yz4Var);
                                    }
                                    break;
                                }
                            }
                        }
                        int size = arrayList2.size();
                        while (i2 < size) {
                            yz4 yz4Var2 = (yz4) arrayList2.get(i2);
                            linkedList.remove(yz4Var2);
                            yz4Var2.d(new ym4(ic1Var));
                            i2++;
                        }
                    }
                }
                return true;
            case 17:
                d();
                return true;
            case 18:
                ((zz4) message.obj).getClass();
                if (0 == 0) {
                    eb4 eb4Var = new eb4(0, Arrays.asList(null));
                    n05 n05Var2 = this.d;
                    if (n05Var2 == null) {
                        n05 n05Var3 = new n05(this.e, n05.i, fb4.b, jp1.b);
                        this.d = n05Var3;
                        n05Var2 = n05Var3;
                    }
                    n05Var2.b(eb4Var);
                    return true;
                }
                eb4 eb4Var2 = this.c;
                if (eb4Var2 != null) {
                    List list = eb4Var2.f;
                    if (eb4Var2.b != 0 || (list != null && list.size() >= 0)) {
                        s05Var.removeMessages(17);
                        eb4 eb4Var3 = this.c;
                        if (eb4Var3 != null) {
                            if (eb4Var3.b > 0) {
                                n05 n05Var4 = this.d;
                                if (n05Var4 == null) {
                                    n05 n05Var5 = new n05(this.e, n05.i, fb4.b, jp1.b);
                                    this.d = n05Var5;
                                    n05Var4 = n05Var5;
                                }
                                n05Var4.b(eb4Var3);
                                this.c = null;
                            } else {
                                if (!this.b) {
                                    synchronized (wl3.class) {
                                        if (wl3.f == null) {
                                            wl3.f = new wl3(i2);
                                        }
                                        break;
                                    }
                                    int i7 = ((SparseIntArray) this.g.f).get(203400000, -1);
                                    if (i7 == -1 || i7 == 0) {
                                    }
                                }
                                this.c = null;
                            }
                            return true;
                        }
                    } else {
                        eb4 eb4Var4 = this.c;
                        List arrayList3 = eb4Var4.f;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                            eb4Var4.f = arrayList3;
                        }
                        arrayList3.add(null);
                    }
                }
                if (this.c == null) {
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.add(null);
                    this.c = new eb4(0, arrayList4);
                    s05Var.sendMessageDelayed(s05Var.obtainMessage(17), 0L);
                    return true;
                }
                return true;
            case 19:
                this.b = false;
                return true;
            default:
                a1.n("GoogleApiManager", "Unknown message id: " + i);
                return false;
        }
    }
}
