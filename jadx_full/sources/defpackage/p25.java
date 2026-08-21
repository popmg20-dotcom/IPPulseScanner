package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p25 extends s05 {
    public final /* synthetic */ tk a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p25(tk tkVar, Looper looper) {
        super(looper, 3);
        this.a = tkVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        u05 u05Var;
        tk tkVar = this.a;
        int i = tkVar.N0.get();
        int i2 = message.arg1;
        int i3 = message.what;
        if (i != i2) {
            if ((i3 == 2 || i3 == 1 || i3 == 7) && (u05Var = (u05) message.obj) != null) {
                u05Var.c();
                return;
            }
            return;
        }
        if ((i3 == 1 || i3 == 7 || i3 == 4 || i3 == 5) && !tkVar.c()) {
            u05 u05Var2 = (u05) message.obj;
            if (u05Var2 != null) {
                u05Var2.c();
                return;
            }
            return;
        }
        int i4 = message.what;
        if (i4 == 4) {
            tkVar.K0 = new ab0(message.arg2);
            if (!tkVar.L0 && !TextUtils.isEmpty(tkVar.t()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(tkVar.t());
                    if (!tkVar.L0) {
                        tkVar.y(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            ab0 ab0Var = tkVar.K0;
            if (ab0Var == null) {
                ab0Var = new ab0(8);
            }
            tkVar.A0.D(ab0Var);
            System.currentTimeMillis();
            return;
        }
        if (i4 == 5) {
            ab0 ab0Var2 = tkVar.K0;
            if (ab0Var2 == null) {
                ab0Var2 = new ab0(8);
            }
            tkVar.A0.D(ab0Var2);
            System.currentTimeMillis();
            return;
        }
        if (i4 == 3) {
            Object obj = message.obj;
            tkVar.A0.D(new ab0(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            System.currentTimeMillis();
            return;
        }
        if (i4 == 6) {
            tkVar.y(5, null);
            qk qkVar = tkVar.F0;
            if (qkVar != null) {
                qkVar.b(message.arg2);
            }
            System.currentTimeMillis();
            tkVar.w(5, 1, null);
            return;
        }
        if (i4 == 2 && !tkVar.isConnected()) {
            u05 u05Var3 = (u05) message.obj;
            if (u05Var3 != null) {
                u05Var3.c();
                return;
            }
            return;
        }
        int i5 = message.what;
        if (i5 != 2 && i5 != 1 && i5 != 7) {
            StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 34);
            sb.append("Don't know how to handle message: ");
            sb.append(i5);
            a1.p("GmsClient", sb.toString(), new Exception());
            return;
        }
        u05 u05Var4 = (u05) message.obj;
        synchronized (u05Var4) {
            try {
                bool = u05Var4.a;
                if (u05Var4.b) {
                    String string = u05Var4.toString();
                    StringBuilder sb2 = new StringBuilder(string.length() + 47);
                    sb2.append("Callback proxy ");
                    sb2.append(string);
                    sb2.append(" being reused. This is not safe.");
                    a1.n("GmsClient", sb2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            tk tkVar2 = u05Var4.f;
            int i6 = u05Var4.d;
            if (i6 != 0) {
                tkVar2.y(1, null);
                Bundle bundle = u05Var4.e;
                u05Var4.b(new ab0(i6, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            } else if (!u05Var4.a()) {
                tkVar2.y(1, null);
                u05Var4.b(new ab0(8, null));
            }
        }
        synchronized (u05Var4) {
            u05Var4.b = true;
        }
        u05Var4.c();
    }
}
