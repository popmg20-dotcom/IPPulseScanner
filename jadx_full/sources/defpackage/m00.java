package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m00 implements Runnable {
    public final /* synthetic */ long A;
    public final /* synthetic */ int X;
    public final /* synthetic */ Context Y;
    public final /* synthetic */ vv Z;
    public final /* synthetic */ int b = 0;
    public final /* synthetic */ n00 f;
    public final /* synthetic */ Executor z;

    public /* synthetic */ m00(n00 n00Var, Context context, Executor executor, int i, vv vvVar, long j) {
        this.f = n00Var;
        this.Y = context;
        this.z = executor;
        this.X = i;
        this.Z = vvVar;
        this.A = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0173 A[Catch: all -> 0x0223, TryCatch #2 {all -> 0x0223, blocks: (B:7:0x0039, B:9:0x0041, B:11:0x005e, B:13:0x0078, B:15:0x007f, B:17:0x0089, B:19:0x009f, B:26:0x00b1, B:27:0x00d6, B:29:0x00dc, B:30:0x00ec, B:32:0x011c, B:34:0x0122, B:35:0x0128, B:37:0x0133, B:38:0x013f, B:49:0x0162, B:51:0x0173, B:52:0x017a, B:56:0x0188, B:58:0x01bb, B:59:0x01c0, B:60:0x01cb, B:61:0x01cd, B:65:0x01d2, B:67:0x01d6, B:68:0x01de, B:70:0x01e2, B:71:0x020c, B:73:0x0210, B:74:0x0215, B:79:0x0222, B:45:0x0148, B:46:0x0154, B:47:0x0155, B:48:0x0161, B:63:0x01cf, B:64:0x01d1), top: B:85:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01cb A[Catch: all -> 0x0223, TryCatch #2 {all -> 0x0223, blocks: (B:7:0x0039, B:9:0x0041, B:11:0x005e, B:13:0x0078, B:15:0x007f, B:17:0x0089, B:19:0x009f, B:26:0x00b1, B:27:0x00d6, B:29:0x00dc, B:30:0x00ec, B:32:0x011c, B:34:0x0122, B:35:0x0128, B:37:0x0133, B:38:0x013f, B:49:0x0162, B:51:0x0173, B:52:0x017a, B:56:0x0188, B:58:0x01bb, B:59:0x01c0, B:60:0x01cb, B:61:0x01cd, B:65:0x01d2, B:67:0x01d6, B:68:0x01de, B:70:0x01e2, B:71:0x020c, B:73:0x0210, B:74:0x0215, B:79:0x0222, B:45:0x0148, B:46:0x0154, B:47:0x0155, B:48:0x0161, B:63:0x01cf, B:64:0x01d1), top: B:85:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ce  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        cl3 cl3VarB;
        switch (this.b) {
            case 0:
                n00 n00Var = this.f;
                Context context = this.Y;
                Executor executor = this.z;
                int i = this.X;
                vv vvVar = this.Z;
                long j = this.A;
                Trace.beginSection(vo.O("CX:initAndRetryRecursively"));
                Context contextP = vf2.p(context);
                try {
                    try {
                    } finally {
                        Trace.endSection();
                    }
                } catch (c02 e) {
                    e = e;
                } catch (RuntimeException e2) {
                    e = e2;
                } catch (k00 e3) {
                    e = e3;
                }
                if (n00Var.c.c() == null) {
                    throw new c02(new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory."));
                }
                ng ngVar = new ng(n00Var.d, n00Var.e);
                b00 b00VarA = n00Var.c.a();
                long jD = n00Var.c.d();
                if (n00Var.c.g() == null) {
                    throw new c02(new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory."));
                }
                vx vxVar = new vx(contextP);
                n00Var.i = vxVar;
                e24 e24Var = new e24(vxVar);
                n00Var.j = e24Var;
                try {
                    n00Var.g = new rw(contextP, ngVar, b00VarA, jD, n00Var.c, e24Var);
                } catch (c02 e4) {
                    e = e4;
                    contextP = contextP;
                    xz xzVar = new xz(j, e);
                    cl3VarB = n00Var.l.b(xzVar);
                    if (vo.A()) {
                        vo.L(xzVar.a, "CX:CameraProvider-RetryStatus");
                    }
                    n00Var.n.e();
                    if (!cl3VarB.b || i >= Integer.MAX_VALUE) {
                        synchronized (n00Var.b) {
                            n00Var.o = 3;
                            break;
                        }
                        if (cl3VarB.c) {
                            n00Var.d();
                            vvVar.b(null);
                        } else if (e instanceof k00) {
                            String str = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((k00) e).b;
                            ez4.r("CameraX", str, e);
                            vvVar.d(new c02(new e00(str)));
                        } else if (e instanceof c02) {
                            vvVar.d(e);
                        } else {
                            vvVar.d(new c02(e));
                        }
                    } else {
                        ez4.b0("CameraX", "Retry init. Start time " + j + " current time " + SystemClock.elapsedRealtime(), e);
                        Handler handler = n00Var.e;
                        m00 m00Var = new m00(n00Var, executor, j, i, contextP, vvVar);
                        long j2 = cl3VarB.a;
                        if (Build.VERSION.SDK_INT >= 28) {
                            u9.x(handler, m00Var, j2);
                        } else {
                            Message messageObtain = Message.obtain(handler, m00Var);
                            messageObtain.obj = "retry_token";
                            handler.sendMessageDelayed(messageObtain, j2);
                        }
                    }
                } catch (RuntimeException e5) {
                    e = e5;
                    contextP = contextP;
                    xz xzVar2 = new xz(j, e);
                    cl3VarB = n00Var.l.b(xzVar2);
                    if (vo.A()) {
                    }
                    n00Var.n.e();
                    if (cl3VarB.b) {
                        synchronized (n00Var.b) {
                        }
                    }
                } catch (k00 e6) {
                    e = e6;
                    contextP = contextP;
                    xz xzVar22 = new xz(j, e);
                    cl3VarB = n00Var.l.b(xzVar22);
                    if (vo.A()) {
                    }
                    n00Var.n.e();
                    if (cl3VarB.b) {
                    }
                }
                if (n00Var.c.f() == null) {
                    throw new c02(new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager."));
                }
                rw rwVar = n00Var.g;
                px pxVarA = nx.a(contextP, rwVar.e, rwVar.a());
                n00Var.h = pxVarA;
                n00Var.j.z = pxVarA;
                if (executor instanceof iz) {
                    ((iz) executor).b(n00Var.g);
                }
                n00Var.a.d(n00Var.g);
                ow owVar = n00Var.g.b;
                owVar.getClass();
                n00Var.k = new iv1(n00Var.a, owVar, n00Var.i, n00Var.j);
                Iterator it = n00Var.a.c().iterator();
                while (it.hasNext()) {
                    ((mz) it.next()).r().s(n00Var.k);
                }
                n00Var.n.f(n00Var.g, n00Var.a);
                wz wzVar = n00Var.n;
                px pxVar = n00Var.h;
                wzVar.getClass();
                pxVar.getClass();
                wzVar.i.add(pxVar);
                wz wzVar2 = n00Var.n;
                ow owVar2 = n00Var.g.b;
                wzVar2.getClass();
                owVar2.getClass();
                wzVar2.i.add(owVar2);
                l00.a(contextP, n00Var.a, b00VarA);
                if (i > 1 && vo.A()) {
                    vo.L(-1, "CX:CameraProvider-RetryStatus");
                }
                n00Var.d();
                vvVar.b(null);
                return;
            default:
                n00 n00Var2 = this.f;
                Executor executor2 = this.z;
                executor2.execute(new m00(n00Var2, this.Y, executor2, this.X + 1, this.Z, this.A));
                return;
        }
    }

    public /* synthetic */ m00(n00 n00Var, Executor executor, long j, int i, Context context, vv vvVar) {
        this.f = n00Var;
        this.z = executor;
        this.A = j;
        this.X = i;
        this.Y = context;
        this.Z = vvVar;
    }
}
