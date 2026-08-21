package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppLocalesMetadataHolderService;
import j$.util.Objects;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ma {
    public static final la b = new la(new yu0(1));
    public static int f = -100;
    public static rd2 z = null;
    public static rd2 A = null;
    public static Boolean X = null;
    public static boolean Y = false;
    public static final me Z = new me(0);
    public static final Object y0 = new Object();
    public static final Object z0 = new Object();

    public static void a() {
        rd2 rd2Var;
        me meVar = Z;
        meVar.getClass();
        ee eeVar = new ee(meVar);
        while (eeVar.hasNext()) {
            ma maVar = (ma) ((WeakReference) eeVar.next()).get();
            if (maVar != null) {
                za zaVar = (za) maVar;
                Context context = zaVar.B0;
                int i = 1;
                if (e(context) && (rd2Var = z) != null && !rd2Var.equals(A)) {
                    b.execute(new ia(context, i));
                }
                zaVar.q(true, true);
            }
        }
    }

    public static Object b() {
        Context context;
        me meVar = Z;
        meVar.getClass();
        ee eeVar = new ee(meVar);
        while (eeVar.hasNext()) {
            ma maVar = (ma) ((WeakReference) eeVar.next()).get();
            if (maVar != null && (context = ((za) maVar).B0) != null) {
                return context.getSystemService("locale");
            }
        }
        return null;
    }

    public static boolean e(Context context) {
        if (X == null) {
            try {
                int i = AppLocalesMetadataHolderService.b;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AppLocalesMetadataHolderService.class), Build.VERSION.SDK_INT >= 24 ? bd.a() | 128 : 640).metaData;
                if (bundle != null) {
                    X = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                X = Boolean.FALSE;
            }
        }
        return X.booleanValue();
    }

    public static void h(za zaVar) {
        synchronized (y0) {
            try {
                me meVar = Z;
                meVar.getClass();
                ee eeVar = new ee(meVar);
                while (eeVar.hasNext()) {
                    ma maVar = (ma) ((WeakReference) eeVar.next()).get();
                    if (maVar == zaVar || maVar == null) {
                        eeVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void j(rd2 rd2Var) {
        Objects.requireNonNull(rd2Var);
        if (Build.VERSION.SDK_INT >= 33) {
            Object objB = b();
            if (objB != null) {
                ka.b(objB, ja.a(rd2Var.a.a()));
                return;
            }
            return;
        }
        if (rd2Var.equals(z)) {
            return;
        }
        synchronized (y0) {
            z = rd2Var;
            a();
        }
    }

    public static void n(int i) {
        if (i != -1 && i != 0 && i != 1 && i != 2 && i != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
            return;
        }
        if (f != i) {
            f = i;
            synchronized (y0) {
                try {
                    me meVar = Z;
                    meVar.getClass();
                    ee eeVar = new ee(meVar);
                    while (eeVar.hasNext()) {
                        ma maVar = (ma) ((WeakReference) eeVar.next()).get();
                        if (maVar != null) {
                            ((za) maVar).q(true, true);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void p(Context context) {
        if (e(context)) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (Y) {
                    return;
                }
                b.execute(new ia(context, 0));
                return;
            }
            synchronized (z0) {
                try {
                    rd2 rd2Var = z;
                    if (rd2Var == null) {
                        rd2 rd2VarB = A;
                        if (rd2VarB == null) {
                            rd2VarB = rd2.b(ji0.M(context));
                            A = rd2VarB;
                        }
                        if (rd2VarB.a.isEmpty()) {
                        } else {
                            z = A;
                        }
                    } else if (!rd2Var.equals(A)) {
                        rd2 rd2Var2 = z;
                        A = rd2Var2;
                        ji0.J(context, rd2Var2.a.a());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public abstract void c();

    public abstract void d();

    public abstract void f();

    public abstract void g();

    public abstract boolean i(int i);

    public abstract void k(int i);

    public abstract void l(View view);

    public abstract void m(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void o(CharSequence charSequence);
}
