package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import io.sentry.ILogger;
import io.sentry.android.core.ScreenshotEventProcessor;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.s0;
import io.sentry.android.core.u0;
import io.sentry.clientreport.b;
import io.sentry.d5;
import io.sentry.l1;
import io.sentry.p5;
import io.sentry.s5;
import io.sentry.t4;
import io.sentry.w5;
import io.sentry.z6;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ft4 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ ft4(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        BufferedWriter bufferedWriter;
        int i = this.a;
        byte[] bArr = null;
        boolean z = false;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                e24 e24Var = (e24) obj2;
                e03 e03Var = (e03) obj;
                bh3 bh3Var = new bh3();
                try {
                    e24.n((lu2) e24Var.z, (String) e03Var.f, new gj(22, e03Var, bh3Var));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return (e03) bh3Var.b;
            case 1:
                e24 e24Var2 = (e24) obj2;
                zk zkVar = (zk) obj;
                String strU = fw.u(p44.G0("/", (String) e24Var2.f), "/Surfboard/profiles/", Uri.encode(zkVar.getName()), ".conf");
                try {
                    lu2 lu2Var = (lu2) e24Var2.z;
                    e1 e1Var = d73.a;
                    e24.A(lu2Var, strU, d73.g(zkVar.getName()));
                    return Boolean.TRUE;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return Boolean.FALSE;
                }
            case 2:
                ux4 ux4Var = (ux4) obj2;
                yx4 yx4Var = (yx4) obj;
                gx4 gx4Var = yx4Var.a;
                String str = yx4Var.c;
                jx4 jx4Var = yx4Var.h;
                boolean z2 = ux4Var instanceof sx4;
                ww4 ww4Var = ww4.b;
                if (z2) {
                    sc2 sc2Var = ((sx4) ux4Var).a;
                    ww4 ww4VarB = jx4Var.b(str);
                    bx4 bx4VarW = yx4Var.g.w();
                    bx4VarW.getClass();
                    ke0.r(bx4VarW.a, false, true, new ko0(str, 13));
                    if (ww4VarB != null) {
                        if (ww4VarB == ww4.f) {
                            String str2 = yx4Var.k;
                            if (sc2Var instanceof rc2) {
                                ue2.g().h(zx4.a, "Worker result SUCCESS for ".concat(str2));
                                if (gx4Var.c()) {
                                    yx4Var.b();
                                } else {
                                    jx4Var.h(ww4.z, str);
                                    di0 di0Var = ((rc2) sc2Var).a;
                                    di0Var.getClass();
                                    ke0.r(jx4Var.a, false, true, new gj(25, di0Var, str));
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    mo0 mo0Var = yx4Var.i;
                                    for (String str3 : mo0Var.a(str)) {
                                        if (jx4Var.b(str3) == ww4.X && ((Boolean) ke0.r(mo0Var.a, true, false, new ko0(str3, 2))).booleanValue()) {
                                            ue2.g().h(zx4.a, "Setting status to enqueued for ".concat(str3));
                                            jx4Var.h(ww4Var, str3);
                                            jx4Var.g(jCurrentTimeMillis, str3);
                                        }
                                    }
                                }
                            } else if (sc2Var instanceof qc2) {
                                ue2.g().h(zx4.a, "Worker result RETRY for ".concat(str2));
                                yx4Var.a(-256);
                                z = true;
                            } else {
                                ue2.g().h(zx4.a, "Worker result FAILURE for ".concat(str2));
                                if (gx4Var.c()) {
                                    yx4Var.b();
                                } else {
                                    yx4Var.d(sc2Var);
                                }
                            }
                        } else if (!ww4VarB.a()) {
                            yx4Var.a(-512);
                            z = true;
                        }
                    }
                } else if (ux4Var instanceof rx4) {
                    yx4Var.d(((rx4) ux4Var).a);
                } else {
                    if (!(ux4Var instanceof tx4)) {
                        g.d();
                        return null;
                    }
                    int i2 = ((tx4) ux4Var).a;
                    if (n12.c(gx4Var.y, Boolean.TRUE)) {
                        String str4 = zx4.a;
                        ue2.g().a(str4, "Worker " + gx4Var.c + " was interrupted. Backing off.");
                        yx4Var.a(i2);
                    } else {
                        ww4 ww4VarB2 = jx4Var.b(str);
                        if (ww4VarB2 == null || ww4VarB2.a()) {
                            String str5 = zx4.a;
                            ue2.g().a(str5, "Status for " + str + " is " + ww4VarB2 + " ; not doing any work");
                        } else {
                            String str6 = zx4.a;
                            ue2.g().a(str6, "Status for " + str + " is " + ww4VarB2 + "; not doing any work and rescheduling for later execution");
                            jx4Var.h(ww4Var, str);
                            jx4Var.i(i2, str);
                            jx4Var.e(-1L, str);
                        }
                    }
                    z = true;
                }
                return Boolean.valueOf(z);
            case 3:
                l1 l1Var = (l1) obj2;
                w5 w5Var = (w5) obj;
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d5.d), 512);
                    try {
                        l1Var.a(w5Var, bufferedWriter2);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter2.close();
                        byteArrayOutputStream.close();
                        return byteArray;
                    } finally {
                        try {
                            bufferedWriter2.close();
                            break;
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                } finally {
                    try {
                        byteArrayOutputStream.close();
                        break;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
            case 4:
                l1 l1Var2 = (l1) obj2;
                t4 t4Var = (t4) obj;
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter3 = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream3, d5.d), 512);
                    try {
                        l1Var2.a(t4Var, bufferedWriter3);
                        byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                        bufferedWriter3.close();
                        byteArrayOutputStream3.close();
                        return byteArray2;
                    } finally {
                        try {
                            bufferedWriter3.close();
                            break;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                } finally {
                    try {
                        byteArrayOutputStream3.close();
                        break;
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                }
            case 5:
                l1 l1Var3 = (l1) obj2;
                b bVar = (b) obj;
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream2, d5.d), 512);
                    try {
                        l1Var3.a(bVar, bufferedWriter);
                        byte[] byteArray3 = byteArrayOutputStream2.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream2.close();
                        return byteArray3;
                    } finally {
                        try {
                            bufferedWriter.close();
                            break;
                        } catch (Throwable th5) {
                            th.addSuppressed(th5);
                        }
                    }
                } finally {
                    try {
                        byteArrayOutputStream2.close();
                        break;
                    } catch (Throwable th6) {
                        th.addSuppressed(th6);
                    }
                }
            case 6:
                l1 l1Var4 = (l1) obj2;
                z6 z6Var = (z6) obj;
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter4 = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d5.d), 512);
                    try {
                        l1Var4.a(z6Var, bufferedWriter4);
                        byte[] byteArray4 = byteArrayOutputStream.toByteArray();
                        bufferedWriter4.close();
                        byteArrayOutputStream.close();
                        return byteArray4;
                    } finally {
                        try {
                            bufferedWriter4.close();
                            break;
                        } catch (Throwable th7) {
                            th.addSuppressed(th7);
                        }
                    }
                } finally {
                    try {
                        break;
                    } catch (Throwable th22) {
                    }
                }
            case 7:
                l1 l1Var5 = (l1) obj2;
                s5 s5Var = (s5) obj;
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream2, d5.d), 512);
                    try {
                        l1Var5.a(s5Var, bufferedWriter);
                        byte[] byteArray5 = byteArrayOutputStream2.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream2.close();
                        return byteArray5;
                    } finally {
                        try {
                            break;
                        } catch (Throwable th52) {
                        }
                    }
                } finally {
                    try {
                        break;
                    } catch (Throwable th62) {
                    }
                }
            case 8:
                return u0.c(((s0) obj2).b, (SentryAndroidOptions) obj);
            default:
                Bitmap bitmap = (Bitmap) obj;
                ILogger logger = ((ScreenshotEventProcessor) obj2).b.getLogger();
                if (!bitmap.isRecycled()) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream4);
                            bitmap.recycle();
                            if (byteArrayOutputStream4.size() <= 0) {
                                logger.h(p5.DEBUG, "Screenshot is 0 bytes, not attaching the image.", new Object[0]);
                                byteArrayOutputStream4.close();
                            } else {
                                byte[] byteArray6 = byteArrayOutputStream4.toByteArray();
                                byteArrayOutputStream4.close();
                                bArr = byteArray6;
                            }
                        } catch (Throwable th8) {
                            try {
                                byteArrayOutputStream4.close();
                                break;
                            } catch (Throwable th9) {
                                th8.addSuppressed(th9);
                            }
                            throw th8;
                        }
                    } catch (Throwable th10) {
                        logger.d(p5.ERROR, "Compressing bitmap failed.", th10);
                    }
                    break;
                }
                return bArr;
        }
    }
}
