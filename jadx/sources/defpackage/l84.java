package defpackage;

import android.hardware.camera2.CameraDevice;
import io.sentry.ILogger;
import io.sentry.android.core.internal.tombstone.c;
import io.sentry.g7;
import io.sentry.o;
import io.sentry.p5;
import io.sentry.util.b;
import io.sentry.x;
import io.sentry.y;
import io.sentry.z;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l84 implements wv, gf, kd0 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ l84(m84 m84Var, CameraDevice cameraDevice, xt3 xt3Var, List list) {
        this.b = m84Var;
        this.A = cameraDevice;
        this.f = xt3Var;
        this.z = list;
    }

    public void a() {
        int i;
        ILogger iLogger = (ILogger) this.b;
        String str = (String) this.z;
        z zVar = (z) this.A;
        File file = (File) this.f;
        p5 p5Var = p5.DEBUG;
        int i2 = 0;
        iLogger.h(p5Var, "Started processing cached files from %s", str);
        g7 g7Var = zVar.d;
        ILogger iLogger2 = zVar.b;
        try {
            iLogger2.h(p5Var, "Processing dir. %s", file.getAbsolutePath());
            File[] fileArrListFiles = file.listFiles(new x(i2, zVar));
            if (fileArrListFiles != null) {
                iLogger2.h(p5Var, "Processing %d items from cache dir %s", Integer.valueOf(fileArrListFiles.length), file.getAbsolutePath());
                int length = fileArrListFiles.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    File file2 = fileArrListFiles[i3];
                    if (file2.isFile()) {
                        String absolutePath = file2.getAbsolutePath();
                        if (!g7Var.contains(absolutePath)) {
                            c cVarD = zVar.a.d();
                            if (cVarD != null && cVarD.n(o.All)) {
                                iLogger2.h(p5.INFO, "DirectoryProcessor, rate limiting active.", new Object[i2]);
                                break;
                            }
                            p5 p5Var2 = p5.DEBUG;
                            Object[] objArr = new Object[1];
                            objArr[i2] = absolutePath;
                            iLogger2.h(p5Var2, "Processing file: %s", objArr);
                            i = i2;
                            try {
                                zVar.b(file2, b.f(new y(zVar.c, zVar.b, absolutePath, g7Var)));
                                Thread.sleep(100L);
                                i3++;
                                i2 = i;
                            } catch (Throwable th) {
                                th = th;
                                p5 p5Var3 = p5.ERROR;
                                Object[] objArr2 = new Object[1];
                                objArr2[i] = file.getAbsolutePath();
                                iLogger2.b(p5Var3, th, "Failed processing '%s'", objArr2);
                                p5 p5Var4 = p5.DEBUG;
                                Object[] objArr3 = new Object[1];
                                objArr3[i] = str;
                                iLogger.h(p5Var4, "Finished processing cached files from %s", objArr3);
                            }
                        } else {
                            p5 p5Var5 = p5.DEBUG;
                            Object[] objArr4 = new Object[1];
                            objArr4[i2] = absolutePath;
                            iLogger2.h(p5Var5, "File '%s' has already been processed so it will not be processed again.", objArr4);
                        }
                    } else {
                        p5 p5Var6 = p5.DEBUG;
                        Object[] objArr5 = new Object[1];
                        objArr5[i2] = file2.getAbsolutePath();
                        iLogger2.h(p5Var6, "File %s is not a File.", objArr5);
                    }
                    i = i2;
                    i3++;
                    i2 = i;
                }
            } else {
                iLogger2.h(p5.ERROR, "Cache dir %s is null or is not a directory.", file.getAbsolutePath());
            }
            i = i2;
        } catch (Throwable th2) {
            th = th2;
            i = 0;
        }
        p5 p5Var42 = p5.DEBUG;
        Object[] objArr32 = new Object[1];
        objArr32[i] = str;
        iLogger.h(p5Var42, "Finished processing cached files from %s", objArr32);
    }

    @Override // defpackage.gf
    /* JADX INFO: renamed from: apply */
    public nc2 mo23apply(Object obj) {
        m84 m84Var = (m84) this.b;
        CameraDevice cameraDevice = (CameraDevice) this.A;
        xt3 xt3Var = (xt3) this.f;
        List list = (List) this.z;
        if (m84Var.v.b) {
            Iterator it = m84Var.b.p().iterator();
            while (it.hasNext()) {
                ((m84) it.next()).i();
            }
        }
        m84Var.k("start openCaptureSession");
        synchronized (m84Var.a) {
            try {
                if (m84Var.m) {
                    return new zy1(1, new CancellationException("Opener is disabled"));
                }
                m84Var.b.x(m84Var);
                yv yvVarM = fx3.m(new l84(m84Var, list, new cp1(cameraDevice, m84Var.c), xt3Var));
                m84Var.h = yvVarM;
                ha1 ha1Var = new ha1(27, m84Var);
                yvVarM.a(new um1(0, yvVarM, ha1Var), yu0.a());
                return n12.K(m84Var.h);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.kd0
    public void c(int i, ud0 ud0Var, bv0 bv0Var) {
        jr2 jr2Var = (jr2) this.b;
        c03 c03Var = (c03) this.z;
        ln2 ln2Var = (ln2) this.A;
        int[] iArr = (int[]) this.f;
        char[] cArr = ud0Var.b;
        int iCeil = (int) Math.ceil(jr2Var.b(new o30(cArr, cArr.length), 0, ud0Var.f, c03Var));
        if (iCeil > ln2Var.a) {
            ln2Var.a = iCeil;
        }
        if (iArr != null) {
            iArr[i] = iCeil;
        }
    }

    @Override // defpackage.wv
    public Object n(vv vvVar) {
        String str;
        m84 m84Var = (m84) this.b;
        List list = (List) this.z;
        cp1 cp1Var = (cp1) this.A;
        xt3 xt3Var = (xt3) this.f;
        synchronized (m84Var.a) {
            m84Var.l(list);
            r25.j("The openCaptureSessionCompleter can only set once!", m84Var.i == null);
            m84Var.i = vvVar;
            ((lb) cp1Var.f).r(xt3Var);
            str = "openCaptureSession[session=" + m84Var + "]";
        }
        return str;
    }

    public /* synthetic */ l84(Object obj, Object obj2, Object obj3, Object obj4) {
        this.b = obj;
        this.z = obj2;
        this.A = obj3;
        this.f = obj4;
    }
}
