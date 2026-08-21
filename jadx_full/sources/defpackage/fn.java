package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.work.Worker;
import com.getsurfboard.R;
import com.getsurfboard.ui.SurfboardApp;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.p4;
import j$.time.Duration;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.net.BindException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fn implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ fn(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:67|68|69|(8:71|346|72|(3:74|(3:358|106|107)(4:77|323|78|(2:80|(3:362|89|90)(6:84|341|85|86|88|(1:102)(2:363|103)))(3:359|92|93))|(2:364|119))|317|108|109|(0))|118|122|321|123|(12:126|127|315|128|(3:130|(4:132|330|133|374)(2:136|373)|137)(4:371|138|139|365)|134|135|344|149|153|(4:155|326|156|157)(2:366|161)|124)|372|144|334|145|146|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:71|(2:346|72)|(3:74|(3:358|106|107)(4:77|323|78|(2:80|(3:362|89|90)(6:84|341|85|86|88|(1:102)(2:363|103)))(3:359|92|93))|(2:364|119))|317|108|109|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02eb, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0357, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0364 A[Catch: all -> 0x02fc, TRY_LEAVE, TryCatch #16 {all -> 0x02fc, blocks: (B:56:0x01af, B:58:0x01bd, B:59:0x01c6, B:69:0x022b, B:71:0x0235, B:119:0x02fb, B:115:0x02f2, B:122:0x0300, B:155:0x0364, B:161:0x0383, B:152:0x035e, B:167:0x038f, B:170:0x03a2, B:171:0x03a9, B:172:0x03aa, B:173:0x03ad, B:174:0x03ae, B:175:0x03c3, B:60:0x01d1, B:62:0x01da, B:68:0x0207, B:164:0x0386, B:165:0x038b, B:112:0x02ed, B:149:0x0359, B:72:0x023e, B:74:0x0247, B:77:0x0257, B:103:0x02dc, B:99:0x02d5, B:106:0x02e0, B:107:0x02e5), top: B:343:0x01af, inners: #0, #9, #17, #18 }] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x02fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v116, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v121 */
    /* JADX WARN: Type inference failed for: r0v122, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v123 */
    /* JADX WARN: Type inference failed for: r0v129 */
    /* JADX WARN: Type inference failed for: r0v130, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v131, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v132 */
    /* JADX WARN: Type inference failed for: r0v136 */
    /* JADX WARN: Type inference failed for: r0v137, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v184 */
    @Override // defpackage.pl1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a() {
        kl1 kl1Var;
        boolean zX0;
        int iA0;
        Iterator it;
        e03 e03Var;
        ArrayList arrayList;
        ?? th;
        long j;
        ?? th2;
        ?? r0;
        int iF;
        e03 e03Var2;
        int i = 2;
        e03 e03Var3 = null;
        boolean z = false;
        boolean z2 = false;
        switch (this.b) {
            case 0:
                return jn.b((jn) this.f);
            case 1:
                z14 z14Var = (z14) ((j80) this.f).h;
                if (z14Var != null) {
                    z14Var.g(null);
                }
                return xl4.a;
            case 2:
                return ((lb) this.f).i(":memory:");
            case 3:
                h91 h91Var = (h91) this.f;
                return h91Var.b != null ? Build.VERSION.SDK_INT >= 31 ? ut0.d(h91Var.a) : o04.b : o04.c;
            case 4:
                ll1 ll1Var = (ll1) this.f;
                String str = ll1Var.f;
                if (str == null || !ll1Var.A) {
                    kl1Var = new kl1(ll1Var.b, ll1Var.f, new zf2(29), ll1Var.z, ll1Var.X);
                } else {
                    Context context = ll1Var.b;
                    context.getClass();
                    File noBackupFilesDir = context.getNoBackupFilesDir();
                    noBackupFilesDir.getClass();
                    kl1Var = new kl1(ll1Var.b, new File(noBackupFilesDir, str).getAbsolutePath(), new zf2(29), ll1Var.z, ll1Var.X);
                }
                kl1Var.setWriteAheadLoggingEnabled(ll1Var.Z);
                return kl1Var;
            case 5:
                int iOrdinal = ((eq1) this.f).a().ordinal();
                if (iOrdinal == 0) {
                    i = 0;
                } else if (iOrdinal == 1) {
                    i = 1;
                } else if (iOrdinal != 2) {
                    i = 3;
                    if (iOrdinal != 3) {
                        g.d();
                        return null;
                    }
                }
                return Integer.valueOf(i);
            case 6:
                return (List) this.f;
            case 7:
                fu1 fu1Var = (fu1) this.f;
                fu1Var.getClass();
                try {
                    fu1Var.N0.F(2, 0, false);
                    break;
                } catch (IOException e) {
                    t51 t51Var = t51.PROTOCOL_ERROR;
                    fu1Var.g(t51Var, t51Var, e);
                }
                return xl4.a;
            case 8:
                pl3 pl3Var = ((y12) this.f).a;
                return Boolean.valueOf(!pl3Var.k() || pl3Var.o());
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                try {
                    ((i94) this.f).a();
                    break;
                } catch (BindException e2) {
                    e2.printStackTrace();
                }
                return xl4.a;
            case 10:
                ha1 ha1Var = (ha1) this.f;
                ha1Var.getClass();
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "SSHDumpServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "stop");
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("SSHDumpServer", "stop", null);
                }
                h14 h14Var = (h14) ha1Var.f;
                if (h14Var.W0.getAndSet(false)) {
                    try {
                        Duration durationOfMillis = Duration.ofMillis(Long.MAX_VALUE);
                        wk0 wk0VarW0 = h14Var.W0(false);
                        u00[] u00VarArr = new u00[0];
                        if (durationOfMillis != null) {
                            wk0VarW0.getClass();
                            zX0 = wk0VarW0.X0(durationOfMillis.toMillis(), u00VarArr);
                        } else {
                            zX0 = wk0VarW0.X0(Long.MAX_VALUE, u00VarArr);
                        }
                        if (!zX0) {
                            throw new SocketTimeoutException("Failed to receive closure confirmation within " + durationOfMillis + " millis");
                        }
                    } finally {
                        h14Var.N0.clear();
                    }
                }
                return xl4.a;
            case 11:
                jy2 jy2Var = (jy2) d70.e0(((pf1) ((qt) ((gn2) this.f).b.b).c).g());
                if (jy2Var != null && (jy2Var instanceof hy2)) {
                    hy2 hy2Var = (hy2) jy2Var;
                    if (hy2Var.a == hd2.b) {
                        return hy2Var;
                    }
                }
                return null;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new uu2((wu2) this.f);
            case 13:
                hv3 hv3Var = ((rf) this.f).l;
                xl4 xl4Var = xl4.a;
                hv3Var.p(xl4Var);
                return xl4Var;
            case 14:
                ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) this.f;
                int i2 = ProfileEditorActivity.Y0;
                profileEditorActivity.z();
                String strX = profileEditorActivity.T0;
                cm2 cm2Var = profileEditorActivity.S0;
                if (strX == null) {
                    if (cm2Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((Toolbar) cm2Var.Z).setTitle("");
                } else {
                    if (cm2Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    Toolbar toolbar = (Toolbar) cm2Var.Z;
                    jl4 jl4Var = ((CodeEditor) cm2Var.z).J1.z0;
                    if (jl4Var.f && jl4Var.Y > 0) {
                        strX = ha0.x(strX, WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
                    }
                    toolbar.setTitle(strX);
                }
                return xl4.a;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return ((FrameLayout) ((dk1) this.f).m).getContext().getDrawable(R.drawable.custom_popupmenu_background);
            case 16:
                ((d83) this.f).m();
                return xl4.a;
            case 17:
                zj3 zj3Var = (zj3) this.f;
                ClassLoader classLoader = zj3Var.f;
                ge1 ge1Var = zj3Var.z;
                Enumeration<URL> resources = classLoader.getResources("");
                resources.getClass();
                ArrayList<URL> list = Collections.list(resources);
                list.getClass();
                ArrayList arrayList2 = new ArrayList();
                for (URL url : list) {
                    url.getClass();
                    if (n12.c(url.getProtocol(), "file")) {
                        String str2 = u03.f;
                        e03Var2 = new e03(ge1Var, pr1.r(new File(url.toURI())));
                    } else {
                        e03Var2 = null;
                    }
                    if (e03Var2 != null) {
                        arrayList2.add(e03Var2);
                    }
                }
                Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
                resources2.getClass();
                ArrayList list2 = Collections.list(resources2);
                list2.getClass();
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    URL url2 = (URL) it2.next();
                    url2.getClass();
                    String string = url2.toString();
                    string.getClass();
                    if (w44.j0(string, "jar:file:", z) && (iA0 = p44.A0(string, "!", 6)) != -1) {
                        String str3 = u03.f;
                        u03 u03VarR = pr1.r(new File(URI.create(string.substring(4, iA0))));
                        w72 w72VarQ = ge1Var.Q(u03VarR);
                        try {
                            long size = w72VarQ.size();
                            long j2 = size - 22;
                            long j3 = 0;
                            if (j2 < 0) {
                                throw new IOException("not a zip: size=" + w72VarQ.size());
                            }
                            long jMax = Math.max(size - 65558, 0L);
                            while (true) {
                                long j4 = j3;
                                he3 he3Var = new he3(w72VarQ.g(j2));
                                try {
                                    if (he3Var.F() == 101010256) {
                                        int iN = he3Var.N() & 65535;
                                        int iN2 = he3Var.N() & 65535;
                                        long jN = he3Var.N() & 65535;
                                        it = it2;
                                        if (jN != (he3Var.N() & 65535) || iN != 0 || iN2 != 0) {
                                            throw new IOException("unsupported zip: spanned");
                                        }
                                        e03Var = e03Var3;
                                        he3Var.Z(4L);
                                        long jF = ((long) he3Var.F()) & 4294967295L;
                                        int iN3 = he3Var.N() & 65535;
                                        r51 r51Var = new r51(jN, jF, iN3);
                                        he3Var.Q(iN3);
                                        he3Var.close();
                                        long j5 = j2 - 20;
                                        if (j5 > j4) {
                                            he3 he3Var2 = new he3(w72VarQ.g(j5));
                                            try {
                                            } catch (Throwable th3) {
                                                try {
                                                } catch (Throwable th4) {
                                                    ek0.b(th3, th4);
                                                }
                                                th2 = th3;
                                                break;
                                            }
                                            if (he3Var2.F() == 117853008) {
                                                int iF2 = he3Var2.F();
                                                long jI = he3Var2.I();
                                                if (he3Var2.F() != z || iF2 != 0) {
                                                    throw new IOException("unsupported zip: spanned");
                                                }
                                                he3 he3Var3 = new he3(w72VarQ.g(jI));
                                                try {
                                                    iF = he3Var3.F();
                                                } catch (Throwable th5) {
                                                    try {
                                                    } catch (Throwable th6) {
                                                        ek0.b(th5, th6);
                                                    }
                                                    r0 = th5;
                                                }
                                                if (iF != 101075792) {
                                                    throw new IOException("bad zip: expected " + fx3.n(101075792) + " but was " + fx3.n(iF));
                                                }
                                                he3Var3.Z(12L);
                                                int iF3 = he3Var3.F();
                                                int iF4 = he3Var3.F();
                                                long jI2 = he3Var3.I();
                                                if (jI2 != he3Var3.I() || iF3 != 0 || iF4 != 0) {
                                                    throw new IOException("unsupported zip: spanned");
                                                }
                                                he3Var3.Z(8L);
                                                try {
                                                    th = e03Var;
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                }
                                                r51Var = new r51(jI2, he3Var3.I(), iN3);
                                                r0 = th;
                                                if (r0 != 0) {
                                                    throw r0;
                                                }
                                                break;
                                                if (th2 != 0) {
                                                    throw th2;
                                                }
                                            }
                                            th2 = e03Var;
                                            if (th2 != 0) {
                                            }
                                        }
                                        r51 r51Var2 = r51Var;
                                        ArrayList arrayList4 = new ArrayList();
                                        he3 he3Var4 = new he3(w72VarQ.g(r51Var2.b));
                                        try {
                                            j = r51Var2.a;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            arrayList = arrayList4;
                                        }
                                        while (j4 < j) {
                                            ny4 ny4VarB = fx3.B(he3Var4);
                                            ArrayList arrayList5 = arrayList4;
                                            try {
                                                if (ny4VarB.h >= r51Var2.b) {
                                                    arrayList = arrayList5;
                                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                                }
                                                u03 u03Var = zj3.X;
                                                if (ke0.l(ny4VarB.a)) {
                                                    arrayList = arrayList5;
                                                    try {
                                                        arrayList.add(ny4VarB);
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                    }
                                                } else {
                                                    arrayList = arrayList5;
                                                }
                                                j4++;
                                                arrayList4 = arrayList;
                                                th = th9;
                                            } catch (Throwable th10) {
                                                th = th10;
                                                arrayList = arrayList5;
                                            }
                                            Throwable th11 = th;
                                            try {
                                            } catch (Throwable th12) {
                                                ek0.b(th11, th12);
                                            }
                                            th = th11;
                                            if (th == 0) {
                                                throw th;
                                            }
                                            sy4 sy4Var = new sy4(u03VarR, ge1Var, fx3.b(arrayList));
                                            try {
                                                w72VarQ.close();
                                                break;
                                            } catch (Throwable unused) {
                                            }
                                            e03Var3 = new e03(sy4Var, zj3.X);
                                            break;
                                        }
                                        arrayList = arrayList4;
                                        th = e03Var;
                                        if (th == 0) {
                                        }
                                    } else {
                                        e03 e03Var4 = e03Var3;
                                        Iterator it3 = it2;
                                        he3Var.close();
                                        j2--;
                                        if (j2 < jMax) {
                                            throw new IOException("not a zip: end of central directory signature not found");
                                        }
                                        e03Var3 = e03Var4;
                                        j3 = j4;
                                        it2 = it3;
                                        z = true;
                                    }
                                } finally {
                                    he3Var.close();
                                }
                                break;
                            }
                        } catch (Throwable th13) {
                            if (w72VarQ == null) {
                                throw th13;
                            }
                            try {
                                w72VarQ.close();
                                throw th13;
                            } catch (Throwable th14) {
                                ek0.b(th13, th14);
                                throw th13;
                            }
                        }
                    } else {
                        e03Var = e03Var3;
                        it = it2;
                    }
                    if (e03Var3 != null) {
                        arrayList3.add(e03Var3);
                    }
                    e03Var3 = e03Var;
                    it2 = it;
                    z = true;
                    z = false;
                }
                return d70.m0(arrayList2, arrayList3);
            case 18:
                return ((Callable) this.f).call();
            case 19:
                ((Runnable) this.f).run();
                return xl4.a;
            case 20:
                ClassLoader classLoader2 = ((s23) this.f).a;
                Class<?> clsLoadClass = classLoader2.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                clsLoadClass.getClass();
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getWindowExtensions", null);
                Class<?> clsLoadClass2 = classLoader2.loadClass("androidx.window.extensions.WindowExtensions");
                clsLoadClass2.getClass();
                declaredMethod.getClass();
                return Boolean.valueOf(declaredMethod.getReturnType().equals(clsLoadClass2) && Modifier.isPublic(declaredMethod.getModifiers()));
            case 21:
                return cp3.c((pq4) this.f);
            case 22:
                kp3 kp3Var = (kp3) this.f;
                kp3Var.getLifecycle().a(new nf3(z2 ? 1 : 0, kp3Var));
                return xl4.a;
            case 23:
                return (lb2) this.f;
            case 24:
                SurfboardApp surfboardApp = (SurfboardApp) this.f;
                int i3 = SurfboardApp.A;
                xl4 xl4Var2 = xl4.a;
                try {
                    File file = new File(surfboardApp.getFilesDir(), "crash/xray_crash.log");
                    if (file.exists()) {
                        String strU = le1.U(file);
                        if (p44.x0(strU)) {
                            file.delete();
                        } else {
                            p4.c().j(SurfboardApp.a(strU));
                            p4.b(5000L);
                            file.delete();
                        }
                    }
                    break;
                } catch (Exception unused2) {
                }
                return xl4Var2;
            case 25:
                xo4 xo4Var = (xo4) this.f;
                return BigInteger.valueOf(xo4Var.b).shiftLeft(32).or(BigInteger.valueOf(xo4Var.f)).shiftLeft(32).or(BigInteger.valueOf(xo4Var.z));
            case 26:
                h51.a((nw4) this.f);
                return xl4.a;
            default:
                return ((Worker) this.f).c();
        }
    }
}
