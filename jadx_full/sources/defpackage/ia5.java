package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ia5 implements Runnable {
    public final /* synthetic */ boolean A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ int b = 2;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public ia5(ib5 ib5Var, AtomicReference atomicReference, String str, String str2, boolean z) {
        this.X = atomicReference;
        this.f = str;
        this.z = str2;
        this.A = z;
        Objects.requireNonNull(ib5Var);
        this.Y = ib5Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0149 A[Catch: RuntimeException -> 0x00dc, TryCatch #1 {RuntimeException -> 0x00dc, blocks: (B:19:0x006c, B:50:0x00fc, B:52:0x0107, B:55:0x0114, B:57:0x011a, B:59:0x0134, B:62:0x0141, B:65:0x0149, B:68:0x0160, B:70:0x016f, B:69:0x0167, B:71:0x0182, B:73:0x0188, B:75:0x018e, B:77:0x0194, B:79:0x019c, B:81:0x01a4, B:83:0x01ac, B:85:0x01b2, B:86:0x01c4, B:23:0x008d, B:25:0x0093, B:27:0x009b, B:29:0x00a1, B:31:0x00a7, B:33:0x00ad, B:35:0x00b5, B:37:0x00bd, B:39:0x00c5, B:41:0x00cd, B:44:0x00df, B:46:0x00ed), top: B:96:0x006c }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        Bundle bundleW1;
        String str;
        CharSequence charSequence;
        int i = this.b;
        boolean z = this.A;
        Object obj = this.z;
        Object obj2 = this.f;
        Object obj3 = this.X;
        Object obj4 = this.Y;
        switch (i) {
            case 0:
                dd5 dd5VarJ = ((AppMeasurementDynamiteService) obj4).c.j();
                dd5VarJ.V0();
                dd5VarJ.W0();
                dd5VarJ.j1(new ac5(dd5VarJ, (String) obj2, (String) obj, dd5VarJ.l1(false), this.A, (v35) obj3));
                break;
            case 1:
                dd5 dd5VarJ2 = ((k85) ((ib5) obj4).f).j();
                dd5VarJ2.V0();
                dd5VarJ2.W0();
                dd5VarJ2.j1(new ac5(dd5VarJ2, (AtomicReference) obj3, (String) obj2, (String) obj, dd5VarJ2.l1(false), this.A));
                break;
            case 2:
                ib5 ib5Var = (ib5) ((a55) obj4).f;
                k85 k85Var = (k85) ib5Var.f;
                ib5Var.V0();
                o75 o75Var = ib5Var.L0;
                String str2 = (String) obj;
                Uri uri = (Uri) obj3;
                try {
                    qf5 qf5Var = k85Var.z0;
                    t65 t65Var = k85Var.Y;
                    k85.f(qf5Var);
                    if (TextUtils.isEmpty(str2)) {
                        bundleW1 = null;
                    } else if (str2.contains("gclid") || str2.contains("gbraid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || str2.contains("sfmc_id")) {
                        bundleW1 = qf5Var.W1(Uri.parse("https://google.com/search?".concat(str2)));
                        if (bundleW1 != null) {
                            bundleW1.putString("_cis", "referrer");
                        }
                    } else {
                        t65 t65Var2 = ((k85) qf5Var.f).Y;
                        k85.h(t65Var2);
                        t65Var2.G0.a("Activity created with data 'referrer' without required params");
                        bundleW1 = null;
                    }
                    String str3 = (String) obj2;
                    if (z) {
                        str = "Activity created with data 'referrer' without required params";
                        qf5 qf5Var2 = k85Var.z0;
                        k85.f(qf5Var2);
                        Bundle bundleW12 = qf5Var2.W1(uri);
                        if (bundleW12 != null) {
                            bundleW12.putString("_cis", "intent");
                            if (bundleW12.containsKey("gclid") || bundleW1 == null || !bundleW1.containsKey("gclid")) {
                                charSequence = "utm_medium";
                            } else {
                                charSequence = "utm_medium";
                                bundleW12.putString("_cer", "gclid=" + bundleW1.getString("gclid"));
                            }
                            ib5Var.c1(str3, "_cmp", bundleW12);
                            o75Var.b(bundleW12, str3);
                        }
                        if (TextUtils.isEmpty(str2)) {
                            k85.h(t65Var);
                            q65 q65Var = t65Var.G0;
                            q65Var.b(str2, "Activity created with referrer");
                            if (k85Var.A.f1(null, r55.H0)) {
                                if (bundleW1 != null) {
                                    ib5Var.c1(str3, "_cmp", bundleW1);
                                    o75Var.b(bundleW1, str3);
                                } else {
                                    k85.h(t65Var);
                                    q65Var.b(str2, "Referrer does not contain valid parameters");
                                }
                                k85Var.B0.getClass();
                                ib5Var.f1("auto", "_ldl", null, true, System.currentTimeMillis());
                            } else if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains(charSequence) && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                                k85.h(t65Var);
                                q65Var.a(str);
                            } else if (!TextUtils.isEmpty(str2)) {
                                k85Var.B0.getClass();
                                ib5Var.f1("auto", "_ldl", str2, true, System.currentTimeMillis());
                            }
                        }
                    } else {
                        str = "Activity created with data 'referrer' without required params";
                    }
                    charSequence = "utm_medium";
                    if (TextUtils.isEmpty(str2)) {
                    }
                } catch (RuntimeException e) {
                    t65 t65Var3 = ((k85) ib5Var.f).Y;
                    k85.h(t65Var3);
                    t65Var3.z0.b(e, "Throwable caught in handleReferrerForOnActivityCreated");
                    return;
                }
                break;
            default:
                dd5 dd5Var = (dd5) obj4;
                v55 v55Var = dd5Var.Z;
                k85 k85Var2 = (k85) dd5Var.f;
                if (v55Var == null) {
                    t65 t65Var4 = k85Var2.Y;
                    k85.h(t65Var4);
                    t65Var4.z0.a("Failed to send default event parameters to service");
                } else {
                    tg5 tg5Var = (tg5) obj3;
                    if (k85Var2.A.f1(null, r55.c1)) {
                        dd5Var.n1(v55Var, z ? null : (y25) obj2, tg5Var);
                    } else {
                        try {
                            v55Var.q((Bundle) obj, tg5Var);
                            dd5Var.i1();
                        } catch (RemoteException e2) {
                            t65 t65Var5 = k85Var2.Y;
                            k85.h(t65Var5);
                            t65Var5.z0.b(e2, "Failed to send default event parameters to service");
                        }
                    }
                }
                break;
        }
    }

    public ia5(a55 a55Var, boolean z, Uri uri, String str, String str2) {
        this.A = z;
        this.X = uri;
        this.f = str;
        this.z = str2;
        this.Y = a55Var;
    }

    public ia5(AppMeasurementDynamiteService appMeasurementDynamiteService, v35 v35Var, String str, String str2, boolean z) {
        this.X = v35Var;
        this.f = str;
        this.z = str2;
        this.A = z;
        this.Y = appMeasurementDynamiteService;
    }

    public ia5(dd5 dd5Var, tg5 tg5Var, boolean z, y25 y25Var, Bundle bundle) {
        this.X = tg5Var;
        this.A = z;
        this.f = y25Var;
        this.z = bundle;
        Objects.requireNonNull(dd5Var);
        this.Y = dd5Var;
    }
}
