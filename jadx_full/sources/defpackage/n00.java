package defpackage;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.camera.core.impl.MetadataHolderService;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import j$.util.Objects;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n00 {
    public static final Object r = new Object();
    public static final SparseArray s = new SparseArray();
    public final q00 c;
    public final Executor d;
    public final Handler e;
    public final HandlerThread f;
    public rw g;
    public px h;
    public vx i;
    public e24 j;
    public iv1 k;
    public final dl3 l;
    public final yv m;
    public final wz n;
    public final Integer q;
    public final a00 a = new a00();
    public final Object b = new Object();
    public int o = 1;
    public nc2 p = zy1.z;

    /* JADX WARN: Code restructure failed: missing block: B:95:0x01ff, code lost:
    
        r5 = r0;
        r0 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public n00(QRCodeScannerActivity qRCodeScannerActivity, t92 t92Var) {
        ComponentCallbacks2 componentCallbacks2;
        p00 p00Var;
        String string;
        Bundle bundle;
        dl3 ie4Var;
        Context contextP = vf2.p(qRCodeScannerActivity);
        while (true) {
            if (!(contextP instanceof ContextWrapper)) {
                componentCallbacks2 = null;
                break;
            } else {
                if (contextP instanceof Application) {
                    componentCallbacks2 = (Application) contextP;
                    break;
                }
                contextP = ((ContextWrapper) contextP).getBaseContext();
            }
        }
        if (componentCallbacks2 instanceof p00) {
            p00Var = (p00) componentCallbacks2;
        } else {
            try {
                Context contextP2 = vf2.p(qRCodeScannerActivity);
                Bundle bundle2 = contextP2.getPackageManager().getServiceInfo(new ComponentName(contextP2, (Class<?>) MetadataHolderService.class), 640).metaData;
                string = bundle2 != null ? bundle2.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER") : null;
            } catch (PackageManager.NameNotFoundException e) {
                e = e;
                ez4.r("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            } catch (ClassNotFoundException e2) {
                e = e2;
                ez4.r("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            } catch (IllegalAccessException e3) {
                e = e3;
                ez4.r("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            } catch (InstantiationException e4) {
                e = e4;
                ez4.r("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            } catch (NoSuchMethodException e5) {
                e = e5;
                ez4.r("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            } catch (NullPointerException e6) {
                e = e6;
                ez4.r("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            } catch (InvocationTargetException e7) {
                e = e7;
                ez4.r("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            }
            if (string == null) {
                ez4.q("CameraX", "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
                p00Var = null;
            } else {
                p00Var = (p00) Class.forName(string).getDeclaredConstructor(null).newInstance(null);
            }
        }
        if (p00Var == null) {
            xe.q("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            throw null;
        }
        q00 cameraXConfig = p00Var.getCameraXConfig();
        this.c = cameraXConfig;
        ic3 ic3VarC = (ic3) cameraXConfig.b.p(q00.B0, null);
        if (ic3VarC != null) {
            ez4.o("CameraX", "QuirkSettings from CameraXConfig: " + ic3VarC);
        } else {
            try {
                bundle = qRCodeScannerActivity.getPackageManager().getServiceInfo(new ComponentName(qRCodeScannerActivity, (Class<?>) kc3.class), 640).metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                ez4.o("QuirkSettingsLoader", "QuirkSettings$MetadataHolderService is not found.");
            }
            if (bundle == null) {
                ez4.a0("QuirkSettingsLoader", "No metadata in MetadataHolderService.");
                ic3VarC = null;
                ez4.o("CameraX", "QuirkSettings from app metadata: " + ic3VarC);
            } else {
                ic3VarC = vf2.c(qRCodeScannerActivity, bundle);
                ez4.o("CameraX", "QuirkSettings from app metadata: " + ic3VarC);
            }
        }
        if (ic3VarC == null) {
            ic3VarC = jc3.b;
            ez4.o("CameraX", "QuirkSettings by default: " + ic3VarC);
        }
        un2 un2Var = jc3.c.a;
        synchronized (un2Var.b) {
            try {
                if (!Objects.equals(un2Var.f.getAndSet(ic3VarC), ic3VarC)) {
                    int i = un2Var.z + 1;
                    un2Var.z = i;
                    if (!un2Var.A) {
                        un2Var.A = true;
                        Iterator it = un2Var.Y.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                ((s24) it.next()).a(i);
                            } else {
                                synchronized (un2Var.b) {
                                    if (un2Var.z == i) {
                                        break;
                                    }
                                    Iterator it2 = un2Var.Y.iterator();
                                    int i2 = un2Var.z;
                                }
                            }
                        }
                        un2Var.A = false;
                    }
                }
            } finally {
            }
        }
        ((Integer) this.c.b.p(q00.C0, -1)).getClass();
        Executor izVar = (Executor) this.c.b.p(q00.X, null);
        Handler handler = (Handler) this.c.b.p(q00.Y, null);
        izVar = izVar == null ? new iz() : izVar;
        this.d = izVar;
        if (handler == null) {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.f = handlerThread;
            handlerThread.start();
            this.e = tj4.s(handlerThread.getLooper());
        } else {
            this.f = null;
            this.e = handler;
        }
        q00 q00Var = this.c;
        pg pgVar = q00.Z;
        q00Var.getClass();
        Integer num = (Integer) ((sw2) q00Var.m()).p(pgVar, null);
        this.q = num;
        b(num);
        dl3 dl3Var = (dl3) this.c.b.p(q00.A0, dl3.a);
        Objects.requireNonNull(dl3Var);
        long jA = dl3Var.a();
        if (dl3Var instanceof zz) {
            switch (((zz) dl3Var).b) {
                case 0:
                    ie4Var = new zz(jA, 0);
                    break;
                default:
                    ie4Var = new zz(jA, 1);
                    break;
            }
        } else {
            ie4Var = new ie4(jA, dl3Var);
        }
        this.l = ie4Var;
        this.n = new wz(izVar);
        this.m = c(qRCodeScannerActivity);
    }

    public static void a(Integer num) {
        synchronized (r) {
            try {
                if (num == null) {
                    return;
                }
                SparseArray sparseArray = s;
                int iIntValue = ((Integer) sparseArray.get(num.intValue())).intValue() - 1;
                if (iIntValue == 0) {
                    sparseArray.remove(num.intValue());
                } else {
                    sparseArray.put(num.intValue(), Integer.valueOf(iIntValue));
                }
                f();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(Integer num) {
        synchronized (r) {
            try {
                if (num == null) {
                    return;
                }
                r25.g(num.intValue(), 3, 6, "minLogLevel");
                SparseArray sparseArray = s;
                sparseArray.put(num.intValue(), Integer.valueOf(sparseArray.get(num.intValue()) != null ? 1 + ((Integer) sparseArray.get(num.intValue())).intValue() : 1));
                f();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void f() {
        SparseArray sparseArray = s;
        if (sparseArray.size() == 0) {
            ez4.j = 3;
            return;
        }
        if (sparseArray.get(3) != null) {
            ez4.j = 3;
            return;
        }
        if (sparseArray.get(4) != null) {
            ez4.j = 4;
        } else if (sparseArray.get(5) != null) {
            ez4.j = 5;
        } else if (sparseArray.get(6) != null) {
            ez4.j = 6;
        }
    }

    public final yv c(QRCodeScannerActivity qRCodeScannerActivity) {
        yv yvVar;
        synchronized (this.b) {
            boolean z = true;
            if (this.o != 1) {
                z = false;
            }
            r25.j("CameraX.initInternal() should only be called once per instance", z);
            this.o = 2;
            vv vvVar = new vv();
            vvVar.c = new wj3();
            yvVar = new yv(vvVar);
            vvVar.b = yvVar;
            vvVar.a = fw.class;
            try {
                Executor executor = this.d;
                executor.execute(new m00(this, qRCodeScannerActivity, executor, 1, vvVar, SystemClock.elapsedRealtime()));
                vvVar.a = "CameraX initInternal";
            } catch (Exception e) {
                yvVar.b(e);
            }
        }
        return yvVar;
    }

    public final void d() {
        synchronized (this.b) {
            this.o = 4;
        }
    }

    public final nc2 e() {
        synchronized (this.b) {
            try {
                this.e.removeCallbacksAndMessages("retry_token");
                int iG = fw.G(this.o);
                if (iG == 0) {
                    this.o = 5;
                    return zy1.z;
                }
                if (iG == 1) {
                    throw new IllegalStateException("CameraX could not be shutdown when it is initializing.");
                }
                if (iG == 2 || iG == 3) {
                    this.o = 5;
                    a(this.q);
                    this.p = fx3.m(new jd(3, this));
                }
                return this.p;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
