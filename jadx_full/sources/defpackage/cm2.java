package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.tencent.mars.xlog.Xlog;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.g;
import io.sentry.j5;
import io.sentry.metrics.a;
import io.sentry.n2;
import io.sentry.p2;
import io.sentry.p5;
import io.sentry.transport.p;
import io.sentry.v5;
import io.sentry.w5;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.Optional;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class cm2 implements a {
    public Object A;
    public Object X;
    public Object Y;
    public Object Z;
    public final /* synthetic */ int b;
    public Object f;
    public Object z;

    public cm2(sy syVar, sv0 sv0Var, sw swVar) {
        Size size;
        this.b = 0;
        p64 p64Var = new p64();
        Size size2 = null;
        this.Z = null;
        this.A = new bm2();
        this.Y = swVar;
        Size[] sizeArrT = syVar.c().t(34);
        if (sizeArrT == null) {
            ez4.q("MeteringRepeating", "Can not get output size list.");
            size = new Size(0, 0);
        } else {
            if (p64Var.a != null && "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL)) {
                ArrayList arrayList = new ArrayList();
                for (Size size3 : sizeArrT) {
                    if (p64.c.compare(size3, p64.b) >= 0) {
                        arrayList.add(size3);
                    }
                }
                sizeArrT = (Size[]) arrayList.toArray(new Size[0]);
            }
            List listAsList = Arrays.asList(sizeArrT);
            Collections.sort(listAsList, new i60(7));
            Size sizeE = sv0Var.e();
            long jMin = Math.min(((long) sizeE.getWidth()) * ((long) sizeE.getHeight()), 307200L);
            int length = sizeArrT.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Size size4 = sizeArrT[i];
                long width = ((long) size4.getWidth()) * ((long) size4.getHeight());
                if (width == jMin) {
                    size = size4;
                    break;
                } else if (width <= jMin) {
                    i++;
                    size2 = size4;
                } else if (size2 != null) {
                    size = size2;
                }
            }
            size = (Size) listAsList.get(0);
        }
        this.X = size;
        ez4.o("MeteringRepeating", "MeteringSession SurfaceTexture size: " + size);
        this.z = l();
    }

    public static void A(Drawable drawable, int i, PorterDuff.Mode mode) {
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = db.b;
        }
        drawableMutate.setColorFilter(db.c(i, mode));
    }

    public static boolean c(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList k(Context context, int i) {
        int iC = id4.c(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{id4.b, id4.d, id4.c, id4.f}, new int[]{id4.b(context, R.attr.colorButtonNormal), u70.c(iC, i), u70.c(iC, i), i});
    }

    public static LayerDrawable r(ck3 ck3Var, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawableF = ck3Var.f(context, R.drawable.abc_star_black_48dp);
        Drawable drawableF2 = ck3Var.f(context, R.drawable.abc_star_half_black_48dp);
        if ((drawableF instanceof BitmapDrawable) && drawableF.getIntrinsicWidth() == dimensionPixelSize && drawableF.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableF;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableF.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableF.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableF2 instanceof BitmapDrawable) && drawableF2.getIntrinsicWidth() == dimensionPixelSize && drawableF2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableF2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableF2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableF2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [io.netty.channel.ChannelFuture] */
    public void B() {
        Channel channel = ((ServerBootstrap) this.A).bind((InetSocketAddress) this.z).sync2().channel();
        String str = ((Proxy.Type) this.f) + " proxy listen in " + channel.localAddress();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "LocalProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("LocalProxy", str, null);
        }
        channel.closeFuture().sync2();
    }

    public void C() {
        Context context = ((ViewGroup) this.f).getContext();
        this.A = vo.r(context, R.drawable.afs_md2_track);
        this.X = vo.r(context, R.drawable.afs_md2_thumb);
        this.Y = ke0.d;
    }

    @Override // io.sentry.metrics.a
    public void a(boolean z) {
        j5 j5Var = (j5) this.X;
        if (z) {
            v(true);
            j5Var.submit(new g(16, this));
        } else {
            j5Var.a(((SentryAndroidOptions) this.f).getShutdownTimeoutMillis());
            while (!((ConcurrentLinkedQueue) this.A).isEmpty()) {
                o();
            }
        }
    }

    @Override // io.sentry.metrics.a
    public void b(long j) {
        v(true);
        try {
            ((p) ((n2) this.Z).f).tryAcquireSharedNanos(1, TimeUnit.MILLISECONDS.toNanos(j));
        } catch (InterruptedException e) {
            ((SentryAndroidOptions) this.f).getLogger().d(p5.ERROR, "Failed to flush metrics events", e);
            Thread.currentThread().interrupt();
        }
    }

    public void d() {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup instanceof RecyclerView) {
            n02 n02Var = new n02((RecyclerView) viewGroup, (hf3) this.z);
            Drawable drawable = (Drawable) this.A;
            Drawable drawable2 = (Drawable) this.X;
            dd0 dd0Var = (dd0) this.Y;
            ac1 uk0Var = (ac1) this.Z;
            if (uk0Var == null) {
                uk0Var = new uk0(viewGroup);
            }
            new bc1(viewGroup, n02Var, drawable, drawable2, dd0Var, uk0Var);
            return;
        }
        if (viewGroup instanceof NestedScrollView) {
            vp1.j("Please use ", wb1.class.getSimpleName(), " instead of NestedScrollViewfor fast scroll");
            return;
        }
        if (viewGroup instanceof ScrollView) {
            vp1.j("Please use ", xb1.class.getSimpleName(), " instead of ScrollViewfor fast scroll");
        } else if (viewGroup instanceof WebView) {
            vp1.j("Please use ", yb1.class.getSimpleName(), " instead of WebViewfor fast scroll");
        } else {
            vp1.n(viewGroup.getClass().getSimpleName().concat(" is not supported for fast scroll"));
        }
    }

    public ku e() {
        ku kuVar = (ku) this.Z;
        if (kuVar != null) {
            return kuVar;
        }
        ku kuVar2 = ku.n;
        ku kuVarI = uf2.I((lr1) this.A);
        this.Z = kuVarI;
        return kuVarI;
    }

    public void f(dh2 dh2Var, Map map) {
        y(dh2Var);
        for (hs2 hs2Var : dh2Var.e) {
            ds2 ds2Var = hs2Var.a;
            ds2 ds2Var2 = hs2Var.b;
            Object objH = h(ds2Var);
            if (objH != null) {
                try {
                    objH.hashCode();
                } catch (Exception e) {
                    throw new v90("while constructing a mapping", dh2Var.a, "found unacceptable key " + objH, hs2Var.a.a, e);
                }
            }
            Object objH2 = h(ds2Var2);
            if (ds2Var.c) {
                ((uf4) this.Z).getClass();
                throw new hy4("Recursive key for mapping is detected but it is not configured to be allowed.");
            }
            map.put(objH, objH2);
        }
    }

    public Object h(ds2 ds2Var) {
        Objects.requireNonNull(ds2Var, "Node cannot be null");
        HashMap map = (HashMap) this.z;
        if (map.containsKey(ds2Var)) {
            return map.get(ds2Var);
        }
        HashSet hashSet = (HashSet) this.A;
        if (hashSet.contains(ds2Var)) {
            throw new v90(null, Optional.empty(), "found unconstructable recursive node", ds2Var.a, null);
        }
        hashSet.add(ds2Var);
        HashMap map2 = (HashMap) this.f;
        oa4 oa4Var = ds2Var.b;
        uf4 uf4Var = (uf4) this.Z;
        rc0 rc0Var = (rc0) (((HashMap) uf4Var.b).containsKey(oa4Var) ? Optional.of((rc0) ((HashMap) uf4Var.b).get(oa4Var)) : map2.containsKey(oa4Var) ? Optional.of((rc0) map2.get(oa4Var)) : Optional.empty()).orElseThrow(new ik(0, ds2Var));
        Object objB = map.containsKey(ds2Var) ? map.get(ds2Var) : rc0Var.b(ds2Var);
        map.put(ds2Var, objB);
        hashSet.remove(ds2Var);
        if (ds2Var.c) {
            rc0Var.a(ds2Var, objB);
        }
        return objB;
    }

    public void i(dh2 dh2Var, Set set) {
        y(dh2Var);
        for (hs2 hs2Var : dh2Var.e) {
            ds2 ds2Var = hs2Var.a;
            Object objH = h(ds2Var);
            if (objH != null) {
                try {
                    objH.hashCode();
                } catch (Exception e) {
                    throw new v90("while constructing a Set", dh2Var.a, "found unacceptable key " + objH, hs2Var.a.a, e);
                }
            }
            if (ds2Var.c) {
                ((uf4) this.Z).getClass();
                throw new hy4("Recursive key for mapping is detected but it is not configured to be allowed.");
            }
            set.add(objH);
        }
    }

    public void j(cm2 cm2Var) {
        hm2 hm2Var = (hm2) this.f;
        hm2 hm2Var2 = (hm2) cm2Var.f;
        hm2Var.b = hm2Var2.b;
        hm2Var.c = hm2Var2.c;
        hm2 hm2Var3 = (hm2) this.z;
        hm2 hm2Var4 = (hm2) cm2Var.z;
        hm2Var3.b = hm2Var4.b;
        hm2Var3.c = hm2Var4.c;
        ((pf1) this.A).f((pf1) cm2Var.A);
        ((pf1) this.X).f((pf1) cm2Var.X);
        ((pf1) this.Y).f((pf1) cm2Var.Y);
        ((lw2) this.Z).d((lw2) cm2Var.Z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public tt3 l() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        Size size = (Size) this.X;
        surfaceTexture.setDefaultBufferSize(size.getWidth(), size.getHeight());
        Surface surface = new Surface(surfaceTexture);
        pt3 pt3VarD = pt3.d((bm2) this.A, size);
        int i = 1;
        pt3VarD.b.b = 1;
        az1 az1Var = new az1(surface);
        this.f = az1Var;
        nc2 nc2VarK = n12.K(az1Var.e);
        v62 v62Var = new v62(3, surface, surfaceTexture, false);
        nc2VarK.a(new um1((int) (0 == true ? 1 : 0), (Object) nc2VarK, (Object) v62Var), yu0.a());
        pt3VarD.b((az1) this.f, oz0.d, -1);
        qt3 qt3Var = (qt3) this.Z;
        if (qt3Var != null) {
            qt3Var.b();
        }
        qt3 qt3Var2 = new qt3(new tx1(i, this));
        this.Z = qt3Var2;
        pt3VarD.f = qt3Var2;
        return pt3VarD.c();
    }

    public void m() {
        ArrayList arrayList = (ArrayList) this.Y;
        ArrayList arrayList2 = (ArrayList) this.X;
        if (!arrayList2.isEmpty()) {
            Iterator it = arrayList2.iterator();
            if (it.hasNext()) {
                ((jk) it.next()).getClass();
                throw null;
            }
            arrayList2.clear();
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            ((jk) it2.next()).getClass();
            throw null;
        }
        arrayList.clear();
    }

    public void o() {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.A;
        ArrayList arrayList = new ArrayList(1000);
        do {
            v5 v5Var = (v5) concurrentLinkedQueue.poll();
            if (v5Var != null) {
                arrayList.add(v5Var);
            }
            if (concurrentLinkedQueue.isEmpty()) {
                break;
            }
        } while (arrayList.size() < 1000);
        if (arrayList.isEmpty()) {
            return;
        }
        x8 x8Var = (x8) this.z;
        try {
            x8Var.I(x8Var.u(new w5(arrayList)), null);
        } catch (IOException e) {
            ((SentryAndroidOptions) x8Var.b).getLogger().b(p5.WARNING, e, "Capturing metrics failed.", new Object[0]);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            p pVar = (p) ((n2) this.Z).f;
            int i2 = p.b;
            pVar.releaseShared(1);
        }
    }

    public ArrayList p() {
        ArrayList arrayList;
        synchronized (this.z) {
            arrayList = new ArrayList((LinkedHashSet) this.A);
        }
        return arrayList;
    }

    public ArrayList q() {
        ArrayList arrayList;
        synchronized (this.z) {
            arrayList = new ArrayList((LinkedHashSet) this.Y);
        }
        return arrayList;
    }

    public ArrayList s() {
        ArrayList arrayList;
        synchronized (this.z) {
            arrayList = new ArrayList();
            arrayList.addAll(p());
            arrayList.addAll(q());
        }
        return arrayList;
    }

    public ColorStateList t(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return v9.g(context, R.color.abc_tint_edittext);
        }
        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
            return v9.g(context, R.color.abc_tint_switch_track);
        }
        if (i != R.drawable.abc_switch_thumb_material) {
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return k(context, id4.c(context, R.attr.colorButtonNormal));
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return k(context, 0);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return k(context, id4.c(context, R.attr.colorAccent));
            }
            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                return v9.g(context, R.color.abc_tint_spinner);
            }
            if (c((int[]) this.z, i)) {
                return id4.d(context, R.attr.colorControlNormal);
            }
            if (c((int[]) this.Y, i)) {
                return v9.g(context, R.color.abc_tint_default);
            }
            if (c((int[]) this.Z, i)) {
                return v9.g(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return v9.g(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = id4.d(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = id4.b;
            iArr2[0] = id4.b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = id4.e;
            iArr2[1] = id4.c(context, R.attr.colorControlActivated);
            iArr[2] = id4.f;
            iArr2[2] = id4.c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = id4.b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = id4.e;
            iArr2[1] = id4.c(context, R.attr.colorControlActivated);
            iArr[2] = id4.f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public String toString() {
        switch (this.b) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                p95 p95Var = (p95) this.Y;
                StringBuilder sbB = fw.B(32, "Request{method=");
                sbB.append((String) this.z);
                sbB.append(", url=");
                sbB.append((ev1) this.f);
                lr1 lr1Var = (lr1) this.A;
                if (lr1Var.size() != 0) {
                    sbB.append(", headers=[");
                    Iterator it = lr1Var.iterator();
                    int i = 0;
                    while (true) {
                        w0 w0Var = (w0) it;
                        if (w0Var.hasNext()) {
                            Object next = w0Var.next();
                            int i2 = i + 1;
                            if (i < 0) {
                                e70.P();
                                throw null;
                            }
                            e03 e03Var = (e03) next;
                            String str = (String) e03Var.b;
                            String str2 = (String) e03Var.f;
                            if (i > 0) {
                                sbB.append(", ");
                            }
                            sbB.append(str);
                            sbB.append(':');
                            if (hz4.j(str)) {
                                str2 = "██";
                            }
                            sbB.append(str2);
                            i = i2;
                        } else {
                            sbB.append(']');
                        }
                    }
                }
                if (!n12.c(p95Var, l41.n)) {
                    sbB.append(", tags=");
                    sbB.append(p95Var);
                }
                sbB.append('}');
                return sbB.toString();
            default:
                return super.toString();
        }
    }

    public q02 u() throws IOException {
        k13 k13Var = k13.a;
        Object obj = k13.a;
        be0 be0Var = obj != null ? (be0) obj : null;
        Context contextB = be0Var != null ? be0Var.b() : null;
        AssetManager assets = contextB != null ? contextB.getAssets() : null;
        if (assets != null) {
            InputStream inputStreamOpen = assets.open((String) this.Z);
            inputStreamOpen.getClass();
            return tj4.d0(inputStreamOpen);
        }
        if (Build.FINGERPRINT == null) {
            vp1.i("Platform applicationContext not initialized. Possibly running Android unit test without Robolectric. Android tests should run with Robolectric and call OkHttp.initialize before test");
            return null;
        }
        vp1.i("Platform applicationContext not initialized. Startup Initializer possibly disabled, call OkHttp.initialize before test.");
        return null;
    }

    public void v(boolean z) {
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.Y;
        if (z) {
            atomicBoolean.set(true);
        } else if (!atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        try {
            ((j5) this.X).b(new p2(10, this), z ? 0 : 5000);
        } catch (RejectedExecutionException e) {
            atomicBoolean.set(false);
            ((SentryAndroidOptions) this.f).getLogger().d(p5.WARNING, "Metrics batch processor flush task rejected", e);
        }
    }

    public v92 w() {
        v92 v92Var = new v92();
        v92Var.b = (ev1) this.f;
        v92Var.f = (String) this.z;
        v92Var.A = (ej3) this.X;
        v92Var.X = (p95) this.Y;
        v92Var.z = gb4.A((lr1) this.A);
        return v92Var;
    }

    public void x(m84 m84Var) {
        synchronized (this.z) {
            ((LinkedHashSet) this.Y).add(m84Var);
        }
    }

    public void y(dh2 dh2Var) {
        List<hs2> list = dh2Var.e;
        HashMap map = new HashMap(list.size());
        TreeSet treeSet = new TreeSet();
        int i = 0;
        for (hs2 hs2Var : list) {
            ds2 ds2Var = hs2Var.a;
            Optional optional = dh2Var.a;
            Optional optional2 = ds2Var.a;
            Object objH = h(ds2Var);
            if (objH != null) {
                try {
                    objH.hashCode();
                } catch (Exception e) {
                    throw new v90("while constructing a mapping", optional, "found unacceptable key " + objH, optional2, e);
                }
            }
            if (((Integer) map.put(objH, Integer.valueOf(i))) != null) {
                ((uf4) this.Z).getClass();
                throw new az0("while constructing a mapping", dh2Var.a, ha0.n("found duplicate key ", objH.toString()), hs2Var.a.a, null);
            }
            i++;
        }
        Iterator itDescendingIterator = treeSet.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            list.remove(((Integer) itDescendingIterator.next()).intValue());
        }
    }

    public void z() {
        try {
            he3 he3Var = new he3(u());
            try {
                bu buVarX = he3Var.x(he3Var.C());
                bu buVarX2 = he3Var.x(he3Var.C());
                he3Var.close();
                synchronized (this) {
                    buVarX.getClass();
                    this.A = buVarX;
                    buVarX2.getClass();
                    this.X = buVarX2;
                }
            } finally {
            }
        } finally {
            ((CountDownLatch) this.z).countDown();
        }
    }

    public cm2(Proxy.Type type, InetSocketAddress inetSocketAddress) {
        this.b = 9;
        type.getClass();
        this.f = type;
        this.z = inetSocketAddress;
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        this.A = serverBootstrap;
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(1);
        this.X = nioEventLoopGroup;
        NioEventLoopGroup nioEventLoopGroup2 = new NioEventLoopGroup(3);
        this.Y = nioEventLoopGroup2;
        this.Z = DesugarCollections.synchronizedMap(new HashMap());
        ServerBootstrap serverBootstrapOption = serverBootstrap.group(nioEventLoopGroup, nioEventLoopGroup2).channelFactory((ChannelFactory) new vp1(18)).childHandler(new ga3(this, type)).option(ChannelOption.SO_BACKLOG, 256);
        ChannelOption<Boolean> channelOption = ChannelOption.SO_REUSEADDR;
        Boolean bool = Boolean.TRUE;
        serverBootstrapOption.option(channelOption, bool).childOption(ChannelOption.SO_KEEPALIVE, bool).childOption(ChannelOption.TCP_NODELAY, bool);
    }

    public cm2(ws0 ws0Var, ig2 ig2Var, aw4 aw4Var, aw4 aw4Var2) {
        this.b = 10;
        Object obj = ig2Var.z;
        Object obj2 = ig2Var.A;
        this.f = aw4Var;
        this.z = obj;
        this.A = aw4Var2;
        this.X = obj2;
        this.Y = ws0Var;
        this.Z = new hg2(this);
    }

    public cm2(v92 v92Var) {
        this.b = 12;
        ev1 ev1Var = (ev1) v92Var.b;
        if (ev1Var != null) {
            this.f = ev1Var;
            this.z = (String) v92Var.f;
            m20 m20Var = (m20) v92Var.z;
            m20Var.getClass();
            this.A = gb4.y(m20Var);
            this.X = (ej3) v92Var.A;
            this.Y = (p95) v92Var.X;
            return;
        }
        xe.q("url == null");
        throw null;
    }

    public cm2(SentryAndroidOptions sentryAndroidOptions, x8 x8Var) {
        this.b = 15;
        this.Y = new AtomicBoolean(false);
        this.Z = new n2(8);
        this.f = sentryAndroidOptions;
        this.z = x8Var;
        this.A = new ConcurrentLinkedQueue();
        this.X = new j5(sentryAndroidOptions);
    }

    public cm2(at3 at3Var) {
        this.b = 4;
        this.z = new Object();
        this.A = new LinkedHashSet();
        this.X = new LinkedHashSet();
        this.Y = new LinkedHashSet();
        this.Z = new ez(this);
        this.f = at3Var;
    }

    public cm2(uf4 uf4Var) {
        this.b = 13;
        this.Z = uf4Var;
        HashMap map = new HashMap();
        this.f = map;
        this.z = new HashMap();
        this.A = new HashSet();
        this.X = new ArrayList();
        this.Y = new ArrayList();
        map.put(oa4.c, new c24(this, 2));
        map.put(oa4.i, new d24());
        map.put(oa4.j, new c24(this, 1));
        map.put(oa4.k, new c24(this, 0));
        map.put(oa4.m, new b24(this));
        map.putAll((HashMap) ((v62) uf4Var.g).f);
        map.putAll((HashMap) uf4Var.b);
    }

    public cm2(ViewGroup viewGroup) {
        this.b = 5;
        this.f = viewGroup;
        Context context = viewGroup.getContext();
        this.A = vo.r(context, R.drawable.afs_track);
        this.X = vo.r(context, R.drawable.afs_thumb);
        this.Y = ke0.c;
    }

    public cm2(int i) {
        this.b = i;
        int i2 = 0;
        switch (i) {
            case 3:
                this.f = new AtomicBoolean(false);
                this.z = new CountDownLatch(1);
                this.Z = "PublicSuffixDatabase.list";
                break;
            case 11:
                this.f = new hm2(i2);
                this.z = new hm2(5);
                this.A = new pf1(1);
                this.X = new pf1(1);
                this.Y = new pf1(1);
                this.Z = new lw2((byte) 0, 0);
                break;
            default:
                this.f = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                this.z = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                this.A = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
                this.X = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                this.Y = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                this.Z = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                break;
        }
    }

    public /* synthetic */ cm2(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
        this.X = obj4;
        this.Y = obj5;
        this.Z = obj6;
    }
}
