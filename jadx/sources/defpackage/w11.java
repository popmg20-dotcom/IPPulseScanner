package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w11 implements Runnable {
    public final Object A;
    public Object X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ int b = 3;
    public final String f;
    public final Object z;

    public w11(x11 x11Var, ld0 ld0Var, ue2 ue2Var, String str) {
        this.Y = x11Var;
        this.z = ld0Var.E();
        this.A = ue2Var;
        this.f = str;
    }

    public boolean a() {
        return ((x11) this.Y).d == ((Thread) this.X) && !Thread.interrupted();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        AtomicReference atomicReference;
        dd5 dd5Var;
        v55 v55Var;
        qf5 qf5Var;
        v55 v55Var2;
        switch (this.b) {
            case 0:
                this.X = Thread.currentThread();
                t6 t6Var = new t6((byte) 0, 6);
                StringBuilder sb = (StringBuilder) this.z;
                int length = sb.length();
                ue2 ue2Var = (ue2) this.A;
                ue2Var.getClass();
                String str = this.f;
                int i2 = ue2Var.b;
                if (i2 != 1) {
                    if (i2 == 2) {
                        str = "\\b" + Pattern.quote(str) + "\\b";
                    } else if (i2 == 3) {
                    }
                    Pattern patternCompile = Pattern.compile(str, 10);
                    String string = sb.toString();
                    Matcher matcher = patternCompile.matcher(string);
                    while (matcher.find() && a()) {
                        t6Var.e(ez4.M(matcher.start(), matcher.end()));
                        if (matcher.end() == string.length()) {
                        }
                    }
                } else {
                    int length2 = str.length();
                    int i3 = 0;
                    while (i3 != -1 && i3 < length && a()) {
                        int length3 = sb.length() - str.length();
                        int length4 = str.length();
                        while (true) {
                            if (i3 <= length3) {
                                for (0; i < length4; i + 1) {
                                    char cCharAt = sb.charAt(i3 + i);
                                    char cCharAt2 = str.charAt(i);
                                    i = (cCharAt == cCharAt2 || Character.toLowerCase(cCharAt) == Character.toLowerCase(cCharAt2)) ? i + 1 : 0;
                                }
                            } else {
                                i3 = -1;
                            }
                            i3++;
                        }
                        if (i3 != -1) {
                            int i4 = i3 + length2;
                            t6Var.e(ez4.M(i3, i4));
                            i3 = i4;
                        }
                    }
                }
                if (a()) {
                    ((x11) this.Y).a.b0(new xy0(1, this, t6Var));
                    return;
                }
                return;
            case 1:
                i95 i95Var = (i95) this.z;
                tg5 tg5Var = (tg5) this.A;
                Bundle bundle = (Bundle) this.X;
                y55 y55Var = (y55) this.Y;
                String str2 = this.f;
                ff5 ff5Var = i95Var.c;
                ff5Var.x();
                try {
                    y55Var.x(ff5Var.b0(bundle, tg5Var));
                    return;
                } catch (RemoteException e) {
                    ff5Var.n().z0.c("Failed to return trigger URIs for app", str2, e);
                    return;
                }
            case 2:
                AtomicReference atomicReference2 = (AtomicReference) this.z;
                synchronized (atomicReference2) {
                    try {
                        try {
                            dd5Var = (dd5) this.Y;
                            v55Var = dd5Var.Z;
                        } catch (RemoteException e2) {
                            t65 t65Var = ((k85) ((dd5) this.Y).f).Y;
                            k85.h(t65Var);
                            t65Var.z0.d("(legacy) Failed to get conditional properties; remote exception", null, this.f, e2);
                            ((AtomicReference) this.z).set(Collections.EMPTY_LIST);
                            atomicReference = (AtomicReference) this.z;
                        }
                        if (v55Var == null) {
                            t65 t65Var2 = ((k85) dd5Var.f).Y;
                            k85.h(t65Var2);
                            t65Var2.z0.d("(legacy) Failed to get conditional properties; not connected to service", null, this.f, (String) this.A);
                            atomicReference2.set(Collections.EMPTY_LIST);
                            atomicReference2.notify();
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            atomicReference2.set(v55Var.w(this.f, (String) this.A, (tg5) this.X));
                        } else {
                            atomicReference2.set(v55Var.j(null, this.f, (String) this.A));
                        }
                        dd5Var.i1();
                        atomicReference = (AtomicReference) this.z;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th) {
                        ((AtomicReference) this.z).notify();
                        throw th;
                    }
                }
            default:
                v35 v35Var = (v35) this.X;
                String str3 = (String) this.z;
                String str4 = this.f;
                dd5 dd5Var2 = (dd5) this.Y;
                k85 k85Var = (k85) dd5Var2.f;
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        v55Var2 = dd5Var2.Z;
                    } catch (RemoteException e3) {
                        t65 t65Var3 = k85Var.Y;
                        k85.h(t65Var3);
                        t65Var3.z0.d("Failed to get conditional properties; remote exception", str4, str3, e3);
                    }
                    if (v55Var2 != null) {
                        arrayList = qf5.M1(v55Var2.w(str4, str3, (tg5) this.A));
                        dd5Var2.i1();
                        qf5Var = k85Var.z0;
                        k85.f(qf5Var);
                        qf5Var.L1(v35Var, arrayList);
                        return;
                    }
                    t65 t65Var4 = k85Var.Y;
                    k85.h(t65Var4);
                    t65Var4.z0.c("Failed to get conditional properties; not connected to service", str4, str3);
                    qf5Var = k85Var.z0;
                    k85.f(qf5Var);
                    qf5Var.L1(v35Var, arrayList);
                    return;
                } catch (Throwable th2) {
                    qf5 qf5Var2 = k85Var.z0;
                    k85.f(qf5Var2);
                    qf5Var2.L1(v35Var, arrayList);
                    throw th2;
                }
        }
    }

    public w11(dd5 dd5Var, String str, String str2, tg5 tg5Var, v35 v35Var) {
        this.f = str;
        this.z = str2;
        this.A = tg5Var;
        this.X = v35Var;
        this.Y = dd5Var;
    }

    public w11(dd5 dd5Var, AtomicReference atomicReference, String str, String str2, tg5 tg5Var) {
        this.z = atomicReference;
        this.f = str;
        this.A = str2;
        this.X = tg5Var;
        this.Y = dd5Var;
    }

    public /* synthetic */ w11(i95 i95Var, tg5 tg5Var, Bundle bundle, y55 y55Var, String str) {
        this.z = i95Var;
        this.A = tg5Var;
        this.X = bundle;
        this.Y = y55Var;
        this.f = str;
    }
}
