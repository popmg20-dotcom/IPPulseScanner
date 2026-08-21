package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bg5 {
    public static final Object g = new Object();
    public static bg5 h;
    public static HandlerThread i;
    public final HashMap a = new HashMap();
    public final Context b;
    public volatile s05 c;
    public final fb0 d;
    public final long e;
    public final long f;

    public bg5(Context context, Looper looper) {
        py3 py3Var = new py3(1, this);
        this.b = context.getApplicationContext();
        s05 s05Var = new s05(looper, py3Var);
        Looper.getMainLooper();
        this.c = s05Var;
        this.d = fb0.a();
        this.e = 5000L;
        this.f = 300000L;
    }

    public static bg5 a(Context context) {
        bg5 bg5Var;
        synchronized (g) {
            try {
                bg5Var = h;
                if (bg5Var == null) {
                    bg5Var = new bg5(context.getApplicationContext(), context.getMainLooper());
                    h = bg5Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bg5Var;
    }

    public static HandlerThread b() {
        synchronized (g) {
            try {
                HandlerThread handlerThread = i;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                i = handlerThread2;
                handlerThread2.start();
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ab0 c(sc5 sc5Var, r45 r45Var, String str, Executor executor) {
        HashMap map = this.a;
        synchronized (map) {
            try {
                vd5 vd5Var = (vd5) map.get(sc5Var);
                ab0 ab0VarA = null;
                if (executor == null) {
                    executor = null;
                }
                if (vd5Var == null) {
                    vd5Var = new vd5(this, sc5Var);
                    vd5Var.b.put(r45Var, r45Var);
                    ab0VarA = vd5Var.a(str, executor);
                    map.put(sc5Var, vd5Var);
                } else {
                    this.c.removeMessages(0, sc5Var);
                    if (vd5Var.b.containsKey(r45Var)) {
                        String string = sc5Var.toString();
                        StringBuilder sb = new StringBuilder(string.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(string);
                        throw new IllegalStateException(sb.toString());
                    }
                    vd5Var.b.put(r45Var, r45Var);
                    int i2 = vd5Var.f;
                    if (i2 == 1) {
                        r45Var.onServiceConnected(vd5Var.Y, vd5Var.A);
                    } else if (i2 == 2) {
                        ab0VarA = vd5Var.a(str, executor);
                    }
                }
                if (vd5Var.z) {
                    return ab0.X;
                }
                if (ab0VarA == null) {
                    ab0VarA = new ab0(-1);
                }
                return ab0VarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(String str, ServiceConnection serviceConnection, boolean z) {
        sc5 sc5Var = new sc5(str, z);
        tj4.j(serviceConnection, "ServiceConnection must not be null");
        HashMap map = this.a;
        synchronized (map) {
            try {
                vd5 vd5Var = (vd5) map.get(sc5Var);
                if (vd5Var == null) {
                    String string = sc5Var.toString();
                    StringBuilder sb = new StringBuilder(string.length() + 50);
                    sb.append("Nonexistent connection status for service config: ");
                    sb.append(string);
                    throw new IllegalStateException(sb.toString());
                }
                if (!vd5Var.b.containsKey(serviceConnection)) {
                    String string2 = sc5Var.toString();
                    StringBuilder sb2 = new StringBuilder(string2.length() + 76);
                    sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb2.append(string2);
                    throw new IllegalStateException(sb2.toString());
                }
                vd5Var.b.remove(serviceConnection);
                if (vd5Var.b.isEmpty()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, sc5Var), this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
