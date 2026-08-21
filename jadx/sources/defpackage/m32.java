package defpackage;

import android.net.Network;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.vpn.Jni;
import com.tencent.mars.xlog.Xlog;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m32 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Jni f;

    public /* synthetic */ m32(Jni jni, int i) {
        this.b = i;
        this.f = jni;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        boolean zProtect;
        switch (this.b) {
            case 0:
                Jni jni = this.f;
                t93 t93Var = (t93) obj;
                t93Var.getClass();
                return jni.f(t93Var);
            case 1:
                Jni jni2 = this.f;
                Socket socket = (Socket) obj;
                socket.getClass();
                Network network = jni2.u;
                if (network != null) {
                    try {
                        network.bindSocket(socket);
                        zProtect = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        zProtect = jni2.a.protect(socket);
                    }
                } else {
                    zProtect = jni2.a.protect(socket);
                }
                if (!zProtect) {
                    String str = "protect failed: " + socket;
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("Jni", str, null);
                    }
                }
                return Boolean.valueOf(zProtect);
            case 2:
                Jni jni3 = this.f;
                int iIntValue = ((Integer) obj).intValue();
                AtomicInteger atomicInteger = jni3.g;
                atomicInteger.set(Math.max(0, iIntValue));
                ws4.e.i(Integer.valueOf(atomicInteger.get() + jni3.h.get()));
                return xl4.a;
            default:
                Jni jni4 = this.f;
                Runnable runnable = (Runnable) obj;
                runnable.getClass();
                Handler handler = jni4.a.Y;
                if (handler != null) {
                    handler.removeCallbacks(runnable);
                }
                return Boolean.TRUE;
        }
    }
}
