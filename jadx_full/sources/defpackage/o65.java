package defpackage;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o65 implements Runnable {
    public final Object A;
    public final Object X;
    public final Object Y;
    public final Object Z;
    public final /* synthetic */ int b = 1;
    public final int f;
    public final String z;

    public /* synthetic */ o65(String str, v65 v65Var, int i, IOException iOException, byte[] bArr, Map map) {
        this.A = v65Var;
        this.f = i;
        this.X = iOException;
        this.Y = bArr;
        this.z = str;
        this.Z = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
                t65 t65Var = (t65) this.Z;
                l75 l75Var = ((k85) t65Var.f).X;
                k85.f(l75Var);
                if (!l75Var.X) {
                    Log.println(6, t65Var.b1(), "Persisted config not initialized. Not logging error/warn");
                    return;
                }
                if (t65Var.Y == 0) {
                    x15 x15Var = ((k85) t65Var.f).A;
                    if (x15Var.y0 == null) {
                        synchronized (x15Var) {
                            try {
                                if (x15Var.y0 == null) {
                                    k85 k85Var = (k85) x15Var.f;
                                    ApplicationInfo applicationInfo = k85Var.b.getApplicationInfo();
                                    String strI = u9.i();
                                    if (applicationInfo != null) {
                                        String str = applicationInfo.processName;
                                        x15Var.y0 = Boolean.valueOf(str != null && str.equals(strI));
                                    }
                                    if (x15Var.y0 == null) {
                                        x15Var.y0 = Boolean.TRUE;
                                        t65 t65Var2 = k85Var.Y;
                                        k85.h(t65Var2);
                                        t65Var2.z0.a("My process not in the list of running processes");
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    if (x15Var.y0.booleanValue()) {
                        t65Var.Y = 'C';
                    } else {
                        t65Var.Y = 'c';
                    }
                    break;
                }
                long j = t65Var.Z;
                if (j < 0) {
                    ((k85) t65Var.f).A.a1();
                    j = 133005;
                    t65Var.Z = 133005L;
                }
                int i = this.f;
                char c = t65Var.Y;
                String str2 = this.z;
                Object obj = this.A;
                Object obj2 = this.X;
                Object obj3 = this.Y;
                char cCharAt = "01VDIWEA?".charAt(i);
                String strC1 = t65.c1(true, str2, obj, obj2, obj3);
                StringBuilder sb = new StringBuilder(String.valueOf(cCharAt).length() + 1 + String.valueOf(c).length() + String.valueOf(j).length() + 1 + strC1.length());
                sb.append("2");
                sb.append(cCharAt);
                sb.append(c);
                sb.append(j);
                sb.append(":");
                sb.append(strC1);
                String string = sb.toString();
                if (string.length() > 1024) {
                    string = str2.substring(0, 1024);
                }
                i40 i40Var = l75Var.y0;
                if (i40Var != null) {
                    l75 l75Var2 = (l75) i40Var.z;
                    l75Var2.V0();
                    if (((l75) i40Var.z).Z0().getLong("health_monitor:start", 0L) == 0) {
                        i40Var.k();
                    }
                    long j2 = l75Var2.Z0().getLong("health_monitor:count", 0L);
                    if (j2 <= 0) {
                        SharedPreferences.Editor editorEdit = l75Var2.Z0().edit();
                        editorEdit.putString("health_monitor:value", string);
                        editorEdit.putLong("health_monitor:count", 1L);
                        editorEdit.apply();
                        return;
                    }
                    qf5 qf5Var = ((k85) l75Var2.f).z0;
                    k85.f(qf5Var);
                    long jNextLong = qf5Var.U1().nextLong() & Long.MAX_VALUE;
                    long j3 = j2 + 1;
                    long j4 = Long.MAX_VALUE / j3;
                    SharedPreferences.Editor editorEdit2 = l75Var2.Z0().edit();
                    if (jNextLong < j4) {
                        editorEdit2.putString("health_monitor:value", string);
                    }
                    editorEdit2.putLong("health_monitor:count", j3);
                    editorEdit2.apply();
                    return;
                }
                return;
            default:
                ((v65) this.A).a(this.z, this.f, (Throwable) this.X, (byte[]) this.Y, (Map) this.Z);
                return;
        }
    }

    public o65(t65 t65Var, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f = i;
        this.z = str;
        this.A = obj;
        this.X = obj2;
        this.Y = obj3;
        this.Z = t65Var;
    }
}
