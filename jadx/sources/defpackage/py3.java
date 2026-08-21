package defpackage;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class py3 implements Handler.Callback {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ py3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    private final boolean a(Message message) {
        if (message.what != 0) {
            return false;
        }
        iv1 iv1Var = (iv1) this.b;
        qy3 qy3Var = (qy3) message.obj;
        synchronized (iv1Var.f) {
            if (((qy3) iv1Var.A) == qy3Var || ((qy3) iv1Var.X) == qy3Var) {
                iv1Var.g(qy3Var, 2);
            }
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.a) {
            case 0:
                return a(message);
            default:
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        return false;
                    }
                    bg5 bg5Var = (bg5) this.b;
                    synchronized (bg5Var.a) {
                        try {
                            sc5 sc5Var = (sc5) message.obj;
                            vd5 vd5Var = (vd5) bg5Var.a.get(sc5Var);
                            if (vd5Var != null && vd5Var.f == 3) {
                                String strValueOf = String.valueOf(sc5Var);
                                StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
                                sb.append("Timeout waiting for ServiceConnection callback ");
                                sb.append(strValueOf);
                                a1.e("GmsClientSupervisor", sb.toString(), new Exception());
                                ComponentName componentName = vd5Var.Y;
                                if (componentName == null) {
                                    sc5Var.getClass();
                                    componentName = null;
                                }
                                if (componentName == null) {
                                    sc5Var.getClass();
                                    componentName = new ComponentName("com.google.android.gms", "unknown");
                                }
                                vd5Var.onServiceDisconnected(componentName);
                            }
                        } finally {
                        }
                        break;
                    }
                } else {
                    bg5 bg5Var2 = (bg5) this.b;
                    synchronized (bg5Var2.a) {
                        try {
                            sc5 sc5Var2 = (sc5) message.obj;
                            vd5 vd5Var2 = (vd5) bg5Var2.a.get(sc5Var2);
                            if (vd5Var2 != null && vd5Var2.b.isEmpty()) {
                                if (vd5Var2.z) {
                                    sc5 sc5Var3 = vd5Var2.X;
                                    bg5 bg5Var3 = vd5Var2.Z;
                                    bg5Var3.c.removeMessages(1, sc5Var3);
                                    bg5Var3.d.b(bg5Var3.b, vd5Var2);
                                    vd5Var2.z = false;
                                    vd5Var2.f = 2;
                                }
                                bg5Var2.a.remove(sc5Var2);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return true;
        }
    }
}
