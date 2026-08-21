package defpackage;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class a8 implements xy3 {
    public static final vd3 f = new vd3(8);
    public final Class a;
    public final Method b;
    public final Method c;
    public final Method d;
    public final Method e;

    public a8(Class cls) throws NoSuchMethodException {
        this.a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        declaredMethod.getClass();
        this.b = declaredMethod;
        this.c = cls.getMethod("setHostname", String.class);
        this.d = cls.getMethod("getAlpnSelectedProtocol", null);
        this.e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // defpackage.xy3
    public final String a(SSLSocket sSLSocket) {
        if (this.a.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.d.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, y30.a);
                }
            } catch (IllegalAccessException e) {
                xe.i(e);
                return null;
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (!(cause instanceof NullPointerException) || !n12.c(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    xe.i(e2);
                    return null;
                }
            }
        }
        return null;
    }

    @Override // defpackage.xy3
    public final boolean b(SSLSocket sSLSocket) {
        return this.a.isInstance(sSLSocket);
    }

    @Override // defpackage.xy3
    public final void c(SSLSocket sSLSocket, String str, List list) {
        if (this.a.isInstance(sSLSocket)) {
            try {
                this.b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null && Build.VERSION.SDK_INT <= 23) {
                    this.c.invoke(sSLSocket, str);
                }
                Method method = this.e;
                k13 k13Var = k13.a;
                method.invoke(sSLSocket, wl3.o(list));
            } catch (IllegalAccessException e) {
                xe.i(e);
            } catch (InvocationTargetException e2) {
                xe.i(e2);
            }
        }
    }

    @Override // defpackage.xy3
    public final boolean g() {
        boolean z = y7.e;
        return y7.e;
    }
}
