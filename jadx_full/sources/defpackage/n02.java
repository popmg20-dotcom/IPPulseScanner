package defpackage;

import android.app.Activity;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Size;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.foreground.SystemForegroundService;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class n02 implements o02, om1, eu2, hx1, gr2 {
    public static n02 X;
    public static n02 Y;
    public Object A;
    public final /* synthetic */ int b;
    public Object f;
    public Object z;

    public n02(int i) {
        this.b = i;
        switch (i) {
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                this.f = new we0();
                m24 m24VarA = n24.a(null);
                this.z = m24VarA;
                this.A = new fe3(m24VarA);
                break;
            case 10:
                ed2 ed2Var = ed2.c;
                this.f = ed2Var;
                this.z = ed2Var;
                this.A = ed2Var;
                break;
            case 14:
                this.f = new byte[2];
                this.z = new byte[4];
                this.A = new byte[8];
                break;
            case 27:
                this.f = new y05("", 0L, null);
                this.z = new y05("", 0L, null);
                this.A = new ArrayList();
                break;
            default:
                this.f = new on2();
                this.z = new HashMap();
                break;
        }
    }

    public static void F(InputStream inputStream, byte[] bArr, int i) throws qy4 {
        if (yr2.g0(inputStream, bArr, 0, i) == i) {
            return;
        }
        st4.j("Could not fill buffer");
    }

    public static int G(int i, byte[] bArr) {
        return ((((bArr[i + 3] & 255) << 8) | (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    public static int J(int i, byte[] bArr) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public static void R(int i, byte[] bArr) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & DnsRecord.CLASS_ANY);
    }

    public static void U(byte[] bArr, long j) {
        bArr[7] = (byte) (j >>> 56);
        bArr[6] = (byte) (j >>> 48);
        bArr[5] = (byte) (j >>> 40);
        bArr[4] = (byte) (j >>> 32);
        bArr[3] = (byte) (j >>> 24);
        bArr[2] = (byte) (j >>> 16);
        bArr[1] = (byte) (j >>> 8);
        bArr[0] = (byte) (j & 255);
    }

    public static fd2 g(fd2 fd2Var, fd2 fd2Var2, fd2 fd2Var3, fd2 fd2Var4) {
        return fd2Var4 == null ? fd2Var3 : fd2Var instanceof dd2 ? (((fd2Var2 instanceof ed2) && (fd2Var4 instanceof ed2)) || (fd2Var4 instanceof cd2)) ? fd2Var4 : fd2Var : fd2Var4;
    }

    public static w51 j(ry1 ry1Var, Throwable th) {
        if (th instanceof ys2) {
            ry1Var.getClass();
            em0 em0Var = ry1Var.x;
            em0Var.getClass();
            em0 em0Var2 = h.a;
            em0Var.getClass();
        } else {
            ry1Var.x.getClass();
            em0 em0Var3 = h.a;
        }
        return new w51(null, ry1Var, th);
    }

    public static boolean v(ry1 ry1Var, Bitmap.Config config) {
        if (!v02.q(config)) {
            return true;
        }
        if (!ry1Var.i) {
            return false;
        }
        ty1 ty1Var = ry1Var.c;
        if (!(ty1Var instanceof ty1)) {
            return true;
        }
        ImageView imageView = ty1Var.f;
        return !imageView.isAttachedToWindow() || imageView.isHardwareAccelerated();
    }

    public static n02 y(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new n02(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object A(v32 v32Var, ie0 ie0Var) {
        qx3 qx3Var;
        yn2 yn2Var;
        if (ie0Var instanceof qx3) {
            qx3Var = (qx3) ie0Var;
            int i = qx3Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                qx3Var.y0 = i - Integer.MIN_VALUE;
            } else {
                qx3Var = new qx3(this, ie0Var);
            }
        }
        Object obj = qx3Var.Y;
        int i2 = qx3Var.y0;
        if (i2 == 0) {
            n12.S(obj);
            yn2Var = (yn2) this.z;
            qx3Var.A = v32Var;
            qx3Var.X = yn2Var;
            qx3Var.y0 = 1;
            Object objG = yn2Var.g(qx3Var);
            mf0 mf0Var = mf0.b;
            if (objG == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            yn2 yn2Var2 = qx3Var.X;
            v32 v32Var2 = qx3Var.A;
            n12.S(obj);
            yn2Var = yn2Var2;
            v32Var = v32Var2;
        }
        try {
            if (v32Var == ((v32) this.A)) {
                this.A = null;
            }
            yn2Var.n(null);
            return xl4.a;
        } catch (Throwable th) {
            yn2Var.n(null);
            throw th;
        }
    }

    public void B(Activity activity, iv4 iv4Var) {
        WeakHashMap weakHashMap = (WeakHashMap) this.A;
        activity.getClass();
        ReentrantLock reentrantLock = (ReentrantLock) this.z;
        reentrantLock.lock();
        try {
            if (iv4Var.equals((iv4) weakHashMap.get(activity))) {
                return;
            }
            reentrantLock.unlock();
            Iterator it = ((jw3) ((wn1) this.f).f).b.iterator();
            it.getClass();
            while (it.hasNext()) {
                iw3 iw3Var = (iw3) it.next();
                if (iw3Var.a.equals(activity)) {
                    iw3Var.c = iv4Var;
                    iw3Var.b.accept(iv4Var);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public rw2 C(ry1 ry1Var, wx3 wx3Var) {
        ry1Var.getClass();
        Bitmap.Config config = ry1Var.d;
        if (v02.q(config) && (!v(ry1Var, config) || !((ar1) this.A).b(wx3Var))) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap.Config config2 = config;
        p95 p95Var = wx3Var.a;
        ru0 ru0Var = ru0.n;
        return new rw2(ry1Var.a, config2, null, wx3Var, (p95Var.equals(ru0Var) || wx3Var.b.equals(ru0Var)) ? sp3.f : ry1Var.t, h.a(ry1Var), ry1Var.j && config2 != Bitmap.Config.ALPHA_8, true, null, ry1Var.g, ry1Var.h, ry1Var.u, ry1Var.k, ry1Var.l, ry1Var.m);
    }

    public void D(p92 p92Var) {
        cx cxVar = (cx) this.A;
        if (cxVar != null) {
            cxVar.run();
        }
        cx cxVar2 = new cx((fa2) this.f, p92Var);
        this.A = cxVar2;
        ((Handler) this.z).postAtFrontOfQueue(cxVar2);
    }

    public void E(char c, g84 g84Var) {
        ((HashMap) this.f).put(Character.valueOf(c), g84Var);
    }

    public int H(InputStream inputStream) throws qy4 {
        byte[] bArr = (byte[]) this.z;
        F(inputStream, bArr, 4);
        return G(0, bArr);
    }

    public long I(int i, byte[] bArr) {
        byte[] bArr2 = (byte[]) this.A;
        if (bArr.length - i < 8) {
            Arrays.fill(bArr2, (byte) 0);
        }
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, 8));
        return (((((((((((((((long) (bArr2[7] & 255)) << 8) | ((long) (bArr2[6] & 255))) << 8) | ((long) (bArr2[5] & 255))) << 8) | ((long) (bArr2[4] & 255))) << 8) | ((long) (bArr2[3] & 255))) << 8) | ((long) (bArr2[2] & 255))) << 8) | ((long) (bArr2[1] & 255))) << 8) | ((long) (bArr2[0] & 255));
    }

    public void K() {
        ((TypedArray) this.z).recycle();
    }

    public void L(gd2 gd2Var) {
        this.f = gd2Var.a;
        this.A = gd2Var.c;
        this.z = gd2Var.b;
    }

    public void M(gd2 gd2Var, gd2 gd2Var2) {
        Object objI;
        fd2 fd2Var;
        fd2 fd2Var2;
        b80 b80Var;
        fd2 fd2Var3;
        m24 m24Var = (m24) this.z;
        do {
            objI = m24Var.i();
            b80 b80Var2 = (b80) objI;
            fd2 fd2Var4 = ed2.c;
            if (b80Var2 == null || (fd2Var = b80Var2.a) == null) {
                fd2Var = fd2Var4;
            }
            fd2 fd2Var5 = gd2Var.a;
            fd2 fd2VarG = g(fd2Var, fd2Var5, fd2Var5, gd2Var2 != null ? gd2Var2.a : null);
            if (b80Var2 == null || (fd2Var2 = b80Var2.b) == null) {
                fd2Var2 = fd2Var4;
            }
            fd2 fd2VarG2 = g(fd2Var2, fd2Var5, gd2Var.b, gd2Var2 != null ? gd2Var2.b : null);
            if (b80Var2 != null && (fd2Var3 = b80Var2.c) != null) {
                fd2Var4 = fd2Var3;
            }
            b80Var = new b80(fd2VarG, fd2VarG2, g(fd2Var4, fd2Var5, gd2Var.c, gd2Var2 != null ? gd2Var2.c : null), gd2Var, gd2Var2);
            if (n12.c(b80Var2, b80Var)) {
                return;
            }
        } while (!m24Var.g(objI, b80Var));
        Iterator it = ((we0) this.f).iterator();
        while (it.hasNext()) {
            ((am1) it.next()).g(b80Var);
        }
    }

    public void N(hd2 hd2Var, fd2 fd2Var) {
        hd2Var.getClass();
        int iOrdinal = hd2Var.ordinal();
        if (iOrdinal == 0) {
            this.f = fd2Var;
            return;
        }
        if (iOrdinal == 1) {
            this.z = fd2Var;
        } else if (iOrdinal == 2) {
            this.A = fd2Var;
        } else {
            g.d();
        }
    }

    public gd2 O() {
        return new gd2((fd2) this.f, (fd2) this.z, (fd2) this.A);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [v32] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [v32] */
    /* JADX WARN: Type inference failed for: r9v1, types: [wn2] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [wn2] */
    /* JADX WARN: Type inference failed for: r9v4, types: [wn2] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object P(v32 v32Var, ie0 ie0Var) {
        rx3 rx3Var;
        ?? r1;
        ?? r0;
        if (ie0Var instanceof rx3) {
            rx3Var = (rx3) ie0Var;
            int i = rx3Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                rx3Var.y0 = i - Integer.MIN_VALUE;
            } else {
                rx3Var = new rx3(this, ie0Var);
            }
        }
        Object obj = rx3Var.Y;
        int i2 = rx3Var.y0;
        mf0 mf0Var = mf0.b;
        try {
            if (i2 == 0) {
                n12.S(obj);
                yn2 yn2Var = (yn2) this.z;
                rx3Var.A = v32Var;
                rx3Var.X = yn2Var;
                rx3Var.y0 = 1;
                if (yn2Var.g(rx3Var) != mf0Var) {
                    r1 = v32Var;
                    v32Var = yn2Var;
                }
                return mf0Var;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                wn2 wn2Var = rx3Var.X;
                v32 v32Var2 = rx3Var.A;
                n12.S(obj);
                r0 = v32Var2;
                v32Var = wn2Var;
                r1 = r0;
                this.A = r1;
                return true;
            }
            wn2 wn2Var2 = rx3Var.X;
            v32 v32Var3 = rx3Var.A;
            n12.S(obj);
            r1 = v32Var3;
            v32Var = wn2Var2;
            v32 v32Var4 = (v32) this.A;
            if (v32Var4 != null) {
                v32Var4.isActive();
            }
            if (v32Var4 != null) {
                v32Var4.g(new px3((oj1) this.f));
            }
            if (v32Var4 != null) {
                rx3Var.A = r1;
                rx3Var.X = v32Var;
                rx3Var.y0 = 2;
                if (v32Var4.i0(rx3Var) != mf0Var) {
                    r0 = r1;
                    v32Var = v32Var;
                    r1 = r0;
                }
                return mf0Var;
            }
            this.A = r1;
            return true;
        } finally {
            v32Var.n(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public rw2 Q(rw2 rw2Var) {
        boolean z;
        boolean z2;
        Bitmap.Config config = rw2Var.b;
        mu muVar = rw2Var.o;
        boolean z3 = true;
        if (!v02.q(config) || ((ar1) this.A).j()) {
            z = false;
        } else {
            config = Bitmap.Config.ARGB_8888;
            z = true;
        }
        Bitmap.Config config2 = config;
        if (rw2Var.o.b) {
            x84 x84Var = (x84) this.z;
            synchronized (x84Var) {
                x84Var.a();
                z2 = x84Var.X;
            }
            if (z2) {
                z3 = z;
            } else {
                muVar = mu.DISABLED;
            }
        }
        return z3 ? new rw2(rw2Var.a, config2, rw2Var.c, rw2Var.d, rw2Var.e, rw2Var.f, rw2Var.g, rw2Var.h, rw2Var.i, rw2Var.j, rw2Var.k, rw2Var.l, rw2Var.m, rw2Var.n, muVar) : rw2Var;
    }

    public void S(OutputStream outputStream, int i) {
        byte[] bArr = (byte[]) this.z;
        R(i, bArr);
        outputStream.write(bArr);
    }

    public void T(OutputStream outputStream, long j) {
        byte[] bArr = (byte[]) this.A;
        U(bArr, j);
        outputStream.write(bArr);
    }

    public void V(ByteArrayOutputStream byteArrayOutputStream, int i) {
        byte[] bArr = (byte[]) this.f;
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & DnsRecord.CLASS_ANY);
        byteArrayOutputStream.write(bArr);
    }

    public synchronized void W(int i, int i2, long j, long j2) {
        ((k85) this.f).B0.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        AtomicLong atomicLong = (AtomicLong) this.A;
        if (atomicLong.get() != -1 && jElapsedRealtime - atomicLong.get() <= 1800000) {
            return;
        }
        wt2 wt2VarB = ((n05) this.z).b(new eb4(0, Arrays.asList(new dm2(36301, i, 0, j, j2, null, null, 0, i2))));
        ((fa5) wt2VarB.d).w(new f95(xa4.a, new i40(this, jElapsedRealtime)));
        wt2VarB.j();
    }

    @Override // defpackage.eu2
    public void a(Executor executor, du2 du2Var) {
        synchronized (((HashMap) this.z)) {
            boolean zIsEmpty = ((HashMap) this.z).isEmpty();
            ((HashMap) this.z).put(du2Var, executor);
            if (zIsEmpty) {
                ((xq1) vf2.q()).execute(new zc2(this, 1));
            } else {
                executor.execute(new xy0(7, this, (n43) du2Var));
            }
        }
    }

    @Override // defpackage.o02
    public Uri b() {
        return (Uri) this.z;
    }

    @Override // defpackage.o02
    public Uri c() {
        return (Uri) this.f;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        switch (this.b) {
            case 27:
                n02 n02Var = new n02(((y05) this.f).clone());
                Iterator it = ((ArrayList) this.A).iterator();
                while (it.hasNext()) {
                    ((ArrayList) n02Var.A).add(((y05) it.next()).clone());
                }
                return n02Var;
            default:
                return super.clone();
        }
    }

    @Override // defpackage.o02
    public Object e() {
        return null;
    }

    @Override // defpackage.eu2
    public void f(du2 du2Var) {
        synchronized (((HashMap) this.z)) {
            ((HashMap) this.z).remove(du2Var);
            if (((HashMap) this.z).isEmpty()) {
                ((xq1) vf2.q()).execute(new zc2(this, 0));
            }
        }
    }

    @Override // defpackage.o02
    public ClipDescription getDescription() {
        return (ClipDescription) this.A;
    }

    public void h(c74 c74Var, Map.Entry entry) {
        c74 c74Var2 = (c74) entry.getValue();
        ez4.o("SurfaceProcessorNode", "     -> outputEdge = " + c74Var2);
        lh lhVar = null;
        lh lhVar2 = new lh(c74Var.g.a, ((bh) entry.getKey()).d, c74Var.c ? (mz) this.z : null, ((bh) entry.getKey()).f, ((bh) entry.getKey()).g);
        int i = ((bh) entry.getKey()).c;
        c74Var2.getClass();
        co4.h();
        c74Var2.a();
        r25.j("Consumer can only be linked once.", !c74Var2.j);
        c74Var2.j = true;
        b74 b74Var = c74Var2.l;
        r20 r20VarW = n12.W(b74Var.c(), new a74(c74Var2, b74Var, i, lhVar2, lhVar), vf2.q());
        r20VarW.a(new um1(0, r20VarW, new e24(4, this, c74Var2)), vf2.q());
    }

    @Override // defpackage.gr2
    public boolean i() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f;
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                return true;
            }
        }
        return false;
    }

    public fd2 k(hd2 hd2Var) {
        hd2Var.getClass();
        int iOrdinal = hd2Var.ordinal();
        if (iOrdinal == 0) {
            return (fd2) this.f;
        }
        if (iOrdinal == 1) {
            return (fd2) this.z;
        }
        if (iOrdinal == 2) {
            return (fd2) this.A;
        }
        g.d();
        return null;
    }

    @Override // defpackage.hx1
    public void l(du3 du3Var) {
        int i;
        int i2;
        byte[] bArr;
        if (((AtomicBoolean) this.A).get()) {
            du3Var.close();
            return;
        }
        ((AtomicBoolean) this.A).set(true);
        if (xb3.a.contains(Integer.valueOf(du3Var.f.getFormat())) && du3Var.f.p().length == 3) {
            ly1 ly1Var = du3Var.f.p()[0];
            ByteBuffer byteBufferH = ly1Var.h();
            byteBufferH.getClass();
            byte[] bArr2 = new byte[byteBufferH.remaining()];
            byteBufferH.get(bArr2);
            byteBufferH.rewind();
            int i3 = du3Var.Y;
            int i4 = du3Var.Z;
            int iA = ly1Var.a();
            int iC = ly1Var.c();
            int i5 = i3 * i4;
            byte[] bArr3 = new byte[i5];
            for (int i6 = 0; i6 < i4; i6++) {
                for (int i7 = 0; i7 < i3; i7++) {
                    bArr3[(i6 * i3) + i7] = bArr2[(i7 * iC) + (i6 * iA)];
                }
            }
            int i8 = du3Var.Y;
            int i9 = du3Var.Z;
            int iD = du3Var.X.d();
            if (iD != 0 && iD % 90 == 0) {
                byte[] bArr4 = new byte[i5];
                for (int i10 = 0; i10 < i9; i10++) {
                    for (int i11 = 0; i11 < i8; i11++) {
                        if (iD == 90) {
                            bArr4[(((i11 * i9) + i9) - i10) - 1] = bArr3[(i10 * i8) + i11];
                        } else if (iD == 180) {
                            bArr4[(((((i9 - i10) - 1) * i8) + i8) - i11) - 1] = bArr3[(i10 * i8) + i11];
                        } else if (iD == 270) {
                            bArr4[(i11 * i9) + i10] = bArr3[(((i10 * i8) + i8) - i11) - 1];
                        }
                    }
                }
                if (iD != 180) {
                    i2 = i8;
                    i = i9;
                    bArr = bArr4;
                } else {
                    bArr3 = bArr4;
                    i = i8;
                    i2 = i9;
                    bArr = bArr3;
                }
            } else {
                i = i8;
                i2 = i9;
                bArr = bArr3;
            }
            lb lbVar = new lb(15, new iv1(new j13(i, i2, i, i2, bArr)));
            try {
                try {
                    ki0 ki0Var = (ki0) this.z;
                    if (((be3[]) ki0Var.b) == null) {
                        ki0Var.g();
                    }
                    vk3 vk3VarC = ki0Var.c(lbVar);
                    String str = vk3VarC.a;
                    str.getClass();
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "QRCodeAnalyzer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("QRCodeAnalyzer", str, null);
                    }
                    bc3 bc3Var = (bc3) this.f;
                    String str2 = vk3VarC.a;
                    str2.getClass();
                    bc3Var.g(str2);
                } catch (qs2 e) {
                    e.printStackTrace();
                }
                ((ki0) this.z).reset();
                du3Var.close();
                ((AtomicBoolean) this.A).set(false);
            } catch (Throwable th) {
                ((ki0) this.z).reset();
                du3Var.close();
                throw th;
            }
        }
    }

    @Override // defpackage.om1
    public void m(Object obj) {
        switch (this.b) {
            case 3:
                j80 j80Var = (j80) this.f;
                j80Var.e = (n00) this.z;
                j80Var.f = vf2.p((QRCodeScannerActivity) this.A);
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ((n43) this.A).e = null;
                break;
            default:
                n12.N((nc2) this.f, (vv) this.z);
                break;
        }
    }

    public ColorStateList n(int i) {
        int resourceId;
        ColorStateList colorStateListG;
        TypedArray typedArray = (TypedArray) this.z;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListG = v9.g((Context) this.f, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListG;
    }

    public Drawable o(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.z;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : vo.r((Context) this.f, resourceId);
    }

    public Drawable p(int i) {
        int resourceId;
        Drawable drawableG;
        if (!((TypedArray) this.z).hasValue(i) || (resourceId = ((TypedArray) this.z).getResourceId(i, 0)) == 0) {
            return null;
        }
        db dbVarA = db.a();
        Context context = (Context) this.f;
        synchronized (dbVarA) {
            drawableG = dbVarA.a.g(context, resourceId, true);
        }
        return drawableG;
    }

    @Override // defpackage.om1
    public void q(Throwable th) {
        switch (this.b) {
            case 3:
                j80 j80Var = (j80) this.f;
                ga1 ga1Var = new ga1(9, j80Var);
                if (co4.E()) {
                    ga1Var.run();
                } else {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    r25.j("Unable to post to main thread", new Handler(Looper.getMainLooper()).post(new xy0(23, ga1Var, countDownLatch)));
                    try {
                        if (!countDownLatch.await(30000L, TimeUnit.MILLISECONDS)) {
                            throw new IllegalStateException("Timeout to wait main thread execution");
                        }
                    } catch (InterruptedException e) {
                        throw new t80(e);
                    }
                }
                n00 n00Var = (n00) j80Var.e;
                nc2 nc2VarE = n00Var != null ? n00Var.e() : zy1.z;
                nc2VarE.getClass();
                synchronized (j80Var.a) {
                    j80Var.b = null;
                    j80Var.c = nc2VarE;
                    ((HashMap) j80Var.g).clear();
                    ((HashSet) j80Var.h).clear();
                }
                j80Var.e = null;
                j80Var.f = null;
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ((n43) this.A).e = null;
                ArrayList arrayList = (ArrayList) this.f;
                if (arrayList.isEmpty()) {
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((kz) this.z).r((yx) it.next());
                }
                arrayList.clear();
                return;
            default:
                boolean z = th instanceof CancellationException;
                vv vvVar = (vv) this.z;
                if (z) {
                    r25.j(null, vvVar.d(new h74(((String) this.A).concat(" cancelled."), th)));
                    return;
                } else {
                    vvVar.b(null);
                    return;
                }
        }
    }

    public Typeface r(int i, int i2, dc dcVar) {
        int resourceId = ((TypedArray) this.z).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        TypedValue typedValue = (TypedValue) this.A;
        if (typedValue == null) {
            typedValue = new TypedValue();
            this.A = typedValue;
        }
        TypedValue typedValue2 = typedValue;
        Context context = (Context) this.f;
        ThreadLocal threadLocal = hk3.a;
        if (context.isRestricted()) {
            return null;
        }
        return hk3.b(context, resourceId, typedValue2, i2, dcVar, true, false);
    }

    public int s() {
        Rect rect = (Rect) this.A;
        RecyclerView recyclerView = (RecyclerView) this.f;
        if (recyclerView.getChildCount() == 0) {
            return 0;
        }
        RecyclerView.P(recyclerView.getChildAt(0), rect);
        return rect.height();
    }

    @Override // defpackage.gr2
    public void shutdown() {
        ((ConnectivityManager) this.f).unregisterNetworkCallback((wz1) this.A);
    }

    public Size[] t(int i) {
        ArrayList arrayList;
        List arrayList2;
        HashMap map = (HashMap) this.A;
        Size[] outputSizes = null;
        if (map.containsKey(Integer.valueOf(i))) {
            if (((Size[]) map.get(Integer.valueOf(i))) == null) {
                return null;
            }
            return (Size[]) ((Size[]) map.get(Integer.valueOf(i))).clone();
        }
        try {
            outputSizes = ((StreamConfigurationMap) ((oj1) this.f).f).getOutputSizes(i);
        } catch (Throwable th) {
            ez4.b0("StreamConfigurationMapCompat", "Failed to get output sizes for " + i, th);
        }
        if (outputSizes == null || outputSizes.length == 0) {
            ez4.a0("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for format " + i);
            return outputSizes;
        }
        v62 v62Var = (v62) this.z;
        ArrayList arrayList3 = new ArrayList(Arrays.asList(outputSizes));
        if (((ExtraSupportedOutputSizeQuirk) v62Var.f) != null) {
            Size[] sizeArr = (i == 34 && "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL)) ? new Size[]{new Size(1440, 1080), new Size(960, 720)} : new Size[0];
            if (sizeArr.length > 0) {
                arrayList3.addAll(Arrays.asList(sizeArr));
            }
        }
        br1 br1Var = (br1) v62Var.z;
        if (((ExcludedSupportedSizesQuirk) xt0.a.z(ExcludedSupportedSizesQuirk.class)) == null) {
            arrayList2 = new ArrayList();
        } else {
            String str = br1Var.f;
            String str2 = Build.BRAND;
            if ("OnePlus".equalsIgnoreCase(str2) && "OnePlus6".equalsIgnoreCase(Build.DEVICE)) {
                arrayList = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList.add(new Size(4160, 3120));
                    arrayList.add(new Size(4000, 3000));
                }
            } else if ("OnePlus".equalsIgnoreCase(str2) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE)) {
                arrayList = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList.add(new Size(4160, 3120));
                    arrayList.add(new Size(4000, 3000));
                }
            } else if ("HUAWEI".equalsIgnoreCase(str2) && "HWANE".equalsIgnoreCase(Build.DEVICE)) {
                arrayList = new ArrayList();
                if (str.equals("0") && (i == 34 || i == 35)) {
                    arrayList.add(new Size(720, 720));
                    arrayList.add(new Size(400, 400));
                }
            } else if (ExcludedSupportedSizesQuirk.e()) {
                arrayList = new ArrayList();
                if (str.equals("0")) {
                    if (i == 34) {
                        arrayList.add(new Size(4128, 3096));
                        arrayList.add(new Size(4128, 2322));
                        arrayList.add(new Size(3088, 3088));
                        arrayList.add(new Size(3264, 2448));
                        arrayList.add(new Size(3264, 1836));
                        arrayList.add(new Size(2048, 1536));
                        arrayList.add(new Size(2048, 1152));
                        arrayList.add(new Size(1920, 1080));
                    } else if (i == 35) {
                        arrayList.add(new Size(4128, 2322));
                        arrayList.add(new Size(3088, 3088));
                        arrayList.add(new Size(3264, 2448));
                        arrayList.add(new Size(3264, 1836));
                        arrayList.add(new Size(2048, 1536));
                        arrayList.add(new Size(2048, 1152));
                        arrayList.add(new Size(1920, 1080));
                    }
                } else if (str.equals("1") && (i == 34 || i == 35)) {
                    arrayList.add(new Size(3264, 2448));
                    arrayList.add(new Size(3264, 1836));
                    arrayList.add(new Size(2448, 2448));
                    arrayList.add(new Size(1920, 1920));
                    arrayList.add(new Size(2048, 1536));
                    arrayList.add(new Size(2048, 1152));
                    arrayList.add(new Size(1920, 1080));
                }
            } else if (ExcludedSupportedSizesQuirk.d()) {
                arrayList = new ArrayList();
                if (str.equals("0")) {
                    if (i == 34) {
                        arrayList.add(new Size(4128, 3096));
                        arrayList.add(new Size(4128, 2322));
                        arrayList.add(new Size(3088, 3088));
                        arrayList.add(new Size(3264, 2448));
                        arrayList.add(new Size(3264, 1836));
                        arrayList.add(new Size(2048, 1536));
                        arrayList.add(new Size(2048, 1152));
                        arrayList.add(new Size(1920, 1080));
                    } else if (i == 35) {
                        arrayList.add(new Size(2048, 1536));
                        arrayList.add(new Size(2048, 1152));
                        arrayList.add(new Size(1920, 1080));
                    }
                } else if (str.equals("1") && (i == 34 || i == 35)) {
                    arrayList.add(new Size(2576, 1932));
                    arrayList.add(new Size(2560, 1440));
                    arrayList.add(new Size(1920, 1920));
                    arrayList.add(new Size(2048, 1536));
                    arrayList.add(new Size(2048, 1152));
                    arrayList.add(new Size(1920, 1080));
                }
            } else if ("REDMI".equalsIgnoreCase(str2) && "joyeuse".equalsIgnoreCase(Build.DEVICE)) {
                arrayList = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList.add(new Size(9280, 6944));
                }
            } else if (ExcludedSupportedSizesQuirk.c()) {
                ArrayList arrayList4 = new ArrayList();
                arrayList2 = arrayList4;
                if (i == 35) {
                    arrayList4.add(new Size(3840, 2160));
                    arrayList4.add(new Size(3264, 2448));
                    arrayList4.add(new Size(3200, 2400));
                    arrayList4.add(new Size(2688, 1512));
                    arrayList4.add(new Size(2592, 1944));
                    arrayList4.add(new Size(2592, 1940));
                    arrayList4.add(new Size(1920, 1440));
                    arrayList2 = arrayList4;
                }
            } else if (ExcludedSupportedSizesQuirk.b()) {
                ArrayList arrayList5 = new ArrayList();
                arrayList2 = arrayList5;
                if (i == 35) {
                    arrayList5.add(new Size(4032, 3024));
                    arrayList5.add(new Size(4000, 3000));
                    arrayList5.add(new Size(3264, 2448));
                    arrayList5.add(new Size(3200, 2400));
                    arrayList5.add(new Size(3024, 3024));
                    arrayList5.add(new Size(2976, 2976));
                    arrayList5.add(new Size(2448, 2448));
                    arrayList2 = arrayList5;
                }
            } else {
                ez4.a0("ExcludedSupportedSizesQuirk", "Cannot retrieve list of supported sizes to exclude on this device.");
                arrayList2 = Collections.EMPTY_LIST;
            }
            arrayList2 = arrayList;
        }
        if (!arrayList2.isEmpty()) {
            arrayList3.removeAll(arrayList2);
        }
        if (arrayList3.isEmpty()) {
            ez4.a0("OutputSizesCorrector", "Sizes array becomes empty after excluding problematic output sizes.");
        }
        Size[] sizeArr2 = (Size[]) arrayList3.toArray(new Size[0]);
        map.put(Integer.valueOf(i), sizeArr2);
        return (Size[]) sizeArr2.clone();
    }

    public String toString() {
        switch (this.b) {
            case 8:
                StringBuilder sb = new StringBuilder(32);
                sb.append((String) this.f);
                sb.append('{');
                v62 v62Var = (v62) ((v62) this.z).z;
                String str = "";
                while (v62Var != null) {
                    Object obj = v62Var.f;
                    sb.append(str);
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    v62Var = (v62) v62Var.z;
                    str = ", ";
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public LinearLayoutManager u() {
        ag3 layoutManager = ((RecyclerView) this.f).getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.p == 1) {
                return linearLayoutManager;
            }
        }
        return null;
    }

    public g84 w(char c) {
        n02 n02Var;
        g84 g84Var = (g84) ((HashMap) this.f).get(Character.valueOf(c));
        return (g84Var != null || (n02Var = (n02) this.A) == null) ? g84Var : n02Var.w(c);
    }

    public List x(char c) {
        n02 n02Var;
        List arrayList = (List) ((HashMap) this.z).get(Character.valueOf(c));
        if (arrayList == null && (n02Var = (n02) this.A) != null) {
            arrayList = new ArrayList(n02Var.x(c));
        }
        return arrayList == null ? Collections.EMPTY_LIST : arrayList;
    }

    public void z(Network network, boolean z) {
        boolean z2;
        Network[] allNetworks = ((ConnectivityManager) this.f).getAllNetworks();
        int length = allNetworks.length;
        boolean z3 = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Network network2 = allNetworks[i];
            if (n12.c(network2, network)) {
                z2 = z;
            } else {
                NetworkCapabilities networkCapabilities = ((ConnectivityManager) this.f).getNetworkCapabilities(network2);
                z2 = networkCapabilities != null && networkCapabilities.hasCapability(12);
            }
            if (z2) {
                z3 = true;
                break;
            }
            i++;
        }
        x84 x84Var = (x84) this.z;
        synchronized (x84Var) {
            try {
                if (((te3) x84Var.b.get()) != null) {
                    x84Var.X = z3;
                } else {
                    x84Var.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.o02
    public void d() {
    }

    public n02(Context context, k85 k85Var) {
        this.b = 29;
        this.A = new AtomicLong(-1L);
        this.z = new n05(context, n05.i, new fb4("measurement:api"), jp1.b);
        this.f = k85Var;
    }

    public n02(y05 y05Var) {
        this.b = 27;
        this.f = y05Var;
        this.z = y05Var.clone();
        this.A = new ArrayList();
    }

    public n02(te3 te3Var, x84 x84Var) {
        Object id0Var;
        this.b = 17;
        this.f = te3Var;
        this.z = x84Var;
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            boolean z = c.a;
        } else {
            if (!c.a) {
                if (i != 26 && i != 27) {
                    id0Var = new id0(true);
                } else {
                    id0Var = new wl3(22);
                }
            }
            this.A = id0Var;
        }
        id0Var = new id0(false);
        this.A = id0Var;
    }

    public n02(bc3 bc3Var) {
        this.b = 13;
        this.f = bc3Var;
        this.z = new ki0(2);
        this.A = new AtomicBoolean(false);
    }

    public n02(SystemForegroundService systemForegroundService) {
        this.b = 18;
        this.f = new fa2(systemForegroundService);
        this.z = new Handler(Looper.getMainLooper());
    }

    public n02(RecyclerView recyclerView, hf3 hf3Var) {
        this.b = 16;
        this.A = new Rect();
        this.f = recyclerView;
        this.z = hf3Var;
    }

    public n02(StreamConfigurationMap streamConfigurationMap, v62 v62Var) {
        this.b = 21;
        this.A = new HashMap();
        new HashMap();
        new HashMap();
        this.f = new oj1(27, streamConfigurationMap);
        this.z = v62Var;
    }

    public /* synthetic */ n02(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }

    public n02(ai2 ai2Var, View view) {
        Object bi2Var;
        this.b = 6;
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            bi2Var = new di2();
        } else {
            bi2Var = i >= 33 ? new bi2() : null;
        }
        this.f = bi2Var;
        this.z = ai2Var;
        this.A = view;
    }

    public n02(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.b = 0;
        this.f = uri;
        this.A = clipDescription;
        this.z = uri2;
    }

    public n02(e84 e84Var) {
        this.b = 24;
        this.f = new HashMap();
        this.z = new HashMap();
        this.A = e84Var;
    }

    public n02(Context context, TypedArray typedArray) {
        this.b = 25;
        this.f = context;
        this.z = typedArray;
    }

    public n02(Runnable runnable) {
        this.b = 7;
        this.z = new CopyOnWriteArrayList();
        this.A = new HashMap();
        this.f = runnable;
    }

    public n02(Context context, LocationManager locationManager) {
        this.b = 26;
        this.A = new ci4();
        this.f = context;
        this.z = locationManager;
    }

    public n02(ConnectivityManager connectivityManager, x84 x84Var) {
        this.b = 15;
        this.f = connectivityManager;
        this.z = x84Var;
        wz1 wz1Var = new wz1(2, this);
        this.A = wz1Var;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), wz1Var);
    }

    public n02(oj1 oj1Var) {
        this.b = 20;
        this.f = oj1Var;
        this.z = new yn2();
    }

    public n02(mz mzVar, xm0 xm0Var) {
        this.b = 22;
        this.z = mzVar;
        this.f = xm0Var;
    }

    public n02(Context context, View view) {
        this.b = 11;
        nk2 nk2Var = new nk2(context);
        this.f = nk2Var;
        nk2Var.e = new ha1(17, this);
        al2 al2Var = new al2(context, nk2Var, view, false, R.attr.popupMenuStyle, 0);
        this.z = al2Var;
        al2Var.f = 0;
        al2Var.j = new e23();
    }

    public n02(n43 n43Var, ArrayList arrayList, kz kzVar) {
        this.b = 12;
        this.A = n43Var;
        this.f = arrayList;
        this.z = kzVar;
    }

    public n02(String str) {
        this.b = 8;
        v62 v62Var = new v62(5, false);
        this.z = v62Var;
        this.A = v62Var;
        this.f = str;
    }

    public n02(wn1 wn1Var) {
        this.b = 19;
        this.f = wn1Var;
        this.z = new ReentrantLock();
        this.A = new WeakHashMap();
    }
}
