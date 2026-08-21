package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public n00(com.getsurfboard.ui.activity.QRCodeScannerActivity r8, defpackage.t92 r9) {
        /*
            Method dump skipped, instruction units count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n00.<init>(com.getsurfboard.ui.activity.QRCodeScannerActivity, t92):void");
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
