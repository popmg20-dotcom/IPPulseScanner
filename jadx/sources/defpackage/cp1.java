package defpackage;

import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class cp1 implements ly1, o9, sk, lp, zd3, rk2, xh1, jm1 {
    public static volatile cp1 z;
    public final /* synthetic */ int b;
    public Object f;

    public cp1(int i) {
        this.b = i;
        switch (i) {
            case 2:
                if (Build.VERSION.SDK_INT < 26) {
                    this.f = new q2(this);
                } else {
                    this.f = new r2(this);
                }
                break;
            case 7:
                this.f = new AtomicInteger(0);
                break;
            case 19:
                this.f = new LinkedHashMap();
                break;
            case 20:
                this.f = new ha1(21, ho1.m);
                break;
            case 26:
                this.f = new Object();
                break;
            default:
                this.f = new HashSet();
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.vc1 V(defpackage.eq1 r5, java.util.List r6) {
        /*
            r0 = 1
            r1 = 0
            if (r6 == 0) goto Lc
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto Lc
        La:
            r2 = r1
            goto L21
        Lc:
            java.util.Iterator r2 = r6.iterator()
        L10:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto La
            java.lang.Object r3 = r2.next()
            in4 r3 = (defpackage.in4) r3
            boolean r3 = r3 instanceof defpackage.xx1
            if (r3 == 0) goto L10
            r2 = r0
        L21:
            if (r6 == 0) goto L2a
            boolean r3 = r6.isEmpty()
            if (r3 == 0) goto L2a
            goto L45
        L2a:
            java.util.Iterator r6 = r6.iterator()
        L2e:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L45
            java.lang.Object r3 = r6.next()
            in4 r3 = (defpackage.in4) r3
            boolean r4 = r3 instanceof defpackage.j43
            if (r4 != 0) goto L44
            boolean r3 = defpackage.j00.F(r3)
            if (r3 == 0) goto L2e
        L44:
            r1 = r0
        L45:
            xc1 r6 = r5.a()
            int r6 = r6.ordinal()
            r3 = 0
            if (r6 == 0) goto L67
            if (r6 == r0) goto L67
            r0 = 2
            if (r6 == r0) goto L67
            r0 = 3
            if (r6 != r0) goto L63
            qn4 r6 = defpackage.qn4.A
            java.lang.String r6 = r6.toString()
            if (r2 != 0) goto L61
            goto L81
        L61:
            r6 = r3
            goto L81
        L63:
            defpackage.g.d()
            return r3
        L67:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            qn4 r0 = defpackage.qn4.z
            r6.append(r0)
            java.lang.String r0 = " or "
            r6.append(r0)
            qn4 r0 = defpackage.qn4.X
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            if (r1 != 0) goto L61
        L81:
            if (r6 == 0) goto L89
            vc1 r0 = new vc1
            r0.<init>(r6, r5)
            return r0
        L89:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cp1.V(eq1, java.util.List):vc1");
    }

    public static cp1 Z(cp1 cp1Var, cp1 cp1Var2) {
        HashMap map;
        HashMap map2;
        if (cp1Var == null || (map = (HashMap) cp1Var.f) == null || map.isEmpty()) {
            return cp1Var2;
        }
        if (cp1Var2 == null || (map2 = (HashMap) cp1Var2.f) == null || map2.isEmpty()) {
            return cp1Var;
        }
        HashMap map3 = new HashMap();
        for (Annotation annotation : ((HashMap) cp1Var2.f).values()) {
            map3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : ((HashMap) cp1Var.f).values()) {
            map3.put(annotation2.annotationType(), annotation2);
        }
        return new cp1(5, map3);
    }

    @Override // defpackage.ka0
    public /* synthetic */ Object C(pg pgVar, ia0 ia0Var) {
        return dw2.o(this, pgVar, ia0Var);
    }

    @Override // defpackage.sk
    public void D(ab0 ab0Var) {
        boolean z2 = ab0Var.f == 0;
        tk tkVar = (tk) this.f;
        if (z2) {
            tkVar.k(null, tkVar.r());
            return;
        }
        rk rkVar = tkVar.G0;
        if (rkVar != null) {
            rkVar.a(ab0Var);
        }
    }

    @Override // defpackage.rk2
    public void G(nk2 nk2Var, sk2 sk2Var) {
        f20 f20Var = (f20) this.f;
        Handler handler = f20Var.Y;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = f20Var.y0;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (nk2Var == ((e20) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        handler.postAtTime(new d20(this, i2 < arrayList.size() ? (e20) arrayList.get(i2) : null, sk2Var, nk2Var, 0), nk2Var, SystemClock.uptimeMillis() + 200);
    }

    public void I(int i) {
        lb lbVar = (lb) this.f;
        ReentrantLock reentrantLock = (ReentrantLock) lbVar.f;
        ReentrantLock reentrantLock2 = (ReentrantLock) lbVar.f;
        ArrayList arrayList = (ArrayList) lbVar.z;
        reentrantLock.lock();
        try {
            hf hfVar = (hf) arrayList.get(i);
            hfVar.a.lock();
            try {
                arrayList.remove(i);
            } finally {
                hfVar.a.unlock();
            }
        } finally {
            reentrantLock2.unlock();
        }
    }

    @Override // defpackage.ka0
    public /* synthetic */ boolean K(pg pgVar) {
        return dw2.a(this, pgVar);
    }

    public p2 P(int i) {
        return null;
    }

    @Override // defpackage.ka0
    public /* synthetic */ ia0 S(pg pgVar) {
        return dw2.c(this, pgVar);
    }

    public wc1 U(r90 r90Var, ArrayList arrayList, int i, List list) {
        if (i < arrayList.size()) {
            int i2 = i + 1;
            wc1 wc1VarU = U(r90Var, arrayList, i2, d70.n0(list, arrayList.get(i)));
            return wc1VarU instanceof sc1 ? wc1VarU : U(r90Var, arrayList, i2, list);
        }
        LinkedHashSet linkedHashSetB0 = yr2.b0((Set) r90Var.c, list);
        ez4.o("DefaultFeatureGroupResolver", "getFeatureListResolvedByPriority: features = " + linkedHashSetB0 + ", useCases = " + ((List) r90Var.e));
        int i3 = 1;
        return ((kz) this.f).f(new cp1(i3, linkedHashSetB0), r90Var) ? new sc1(new cp1(i3, linkedHashSetB0)) : tc1.a;
    }

    public Set Y() {
        Set setUnmodifiableSet;
        synchronized (((HashSet) this.f)) {
            setUnmodifiableSet = DesugarCollections.unmodifiableSet((HashSet) this.f);
        }
        return setUnmodifiableSet;
    }

    @Override // defpackage.ly1
    public int a() {
        return ((Image.Plane) this.f).getRowStride();
    }

    public boolean a0(int i, int i2, Bundle bundle) {
        return false;
    }

    @Override // defpackage.jm1
    public Object apply(Object obj) {
        return (x4) this.f;
    }

    @Override // defpackage.ly1
    public int c() {
        return ((Image.Plane) this.f).getPixelStride();
    }

    @Override // defpackage.xh1
    public void close() {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.f;
        if (contentProviderClient != null) {
            contentProviderClient.release();
        }
    }

    @Override // defpackage.rk2
    public void d(nk2 nk2Var, MenuItem menuItem) {
        ((f20) this.f).Y.removeCallbacksAndMessages(nk2Var);
    }

    public void d0(Object obj, String str) {
        Object[] objArr;
        str.getClass();
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f;
        if (obj == null) {
            obj = null;
        } else {
            j50 j50VarA = dh3.a(obj.getClass());
            if (!j50VarA.equals(dh3.a(Boolean.TYPE)) && !j50VarA.equals(dh3.a(Byte.TYPE)) && !j50VarA.equals(dh3.a(Integer.TYPE)) && !j50VarA.equals(dh3.a(Long.TYPE)) && !j50VarA.equals(dh3.a(Float.TYPE)) && !j50VarA.equals(dh3.a(Double.TYPE)) && !j50VarA.equals(dh3.a(String.class)) && !j50VarA.equals(dh3.a(Boolean[].class)) && !j50VarA.equals(dh3.a(Byte[].class)) && !j50VarA.equals(dh3.a(Integer[].class)) && !j50VarA.equals(dh3.a(Long[].class)) && !j50VarA.equals(dh3.a(Float[].class)) && !j50VarA.equals(dh3.a(Double[].class)) && !j50VarA.equals(dh3.a(String[].class))) {
                int i = 0;
                if (j50VarA.equals(dh3.a(boolean[].class))) {
                    boolean[] zArr = (boolean[]) obj;
                    String str2 = mj0.a;
                    int length = zArr.length;
                    objArr = new Boolean[length];
                    while (i < length) {
                        objArr[i] = Boolean.valueOf(zArr[i]);
                        i++;
                    }
                } else if (j50VarA.equals(dh3.a(byte[].class))) {
                    byte[] bArr = (byte[]) obj;
                    String str3 = mj0.a;
                    int length2 = bArr.length;
                    objArr = new Byte[length2];
                    while (i < length2) {
                        objArr[i] = Byte.valueOf(bArr[i]);
                        i++;
                    }
                } else if (j50VarA.equals(dh3.a(int[].class))) {
                    int[] iArr = (int[]) obj;
                    String str4 = mj0.a;
                    int length3 = iArr.length;
                    objArr = new Integer[length3];
                    while (i < length3) {
                        objArr[i] = Integer.valueOf(iArr[i]);
                        i++;
                    }
                } else if (j50VarA.equals(dh3.a(long[].class))) {
                    long[] jArr = (long[]) obj;
                    String str5 = mj0.a;
                    int length4 = jArr.length;
                    objArr = new Long[length4];
                    while (i < length4) {
                        objArr[i] = Long.valueOf(jArr[i]);
                        i++;
                    }
                } else if (j50VarA.equals(dh3.a(float[].class))) {
                    float[] fArr = (float[]) obj;
                    String str6 = mj0.a;
                    int length5 = fArr.length;
                    objArr = new Float[length5];
                    while (i < length5) {
                        objArr[i] = Float.valueOf(fArr[i]);
                        i++;
                    }
                } else {
                    if (!j50VarA.equals(dh3.a(double[].class))) {
                        ad0.k("Key ", str, " has invalid type ", j50VarA);
                        return;
                    }
                    double[] dArr = (double[]) obj;
                    String str7 = mj0.a;
                    int length6 = dArr.length;
                    objArr = new Double[length6];
                    while (i < length6) {
                        objArr[i] = Double.valueOf(dArr[i]);
                        i++;
                    }
                }
                obj = objArr;
            }
        }
        linkedHashMap.put(str, obj);
    }

    public di0 f() {
        di0 di0Var = new di0((LinkedHashMap) this.f);
        ek0.F(di0Var);
        return di0Var;
    }

    public p2 g(int i) {
        return null;
    }

    public void g0(HashMap map) {
        for (Map.Entry entry : map.entrySet()) {
            d0(entry.getValue(), (String) entry.getKey());
        }
    }

    @Override // defpackage.o9
    public Annotation get(Class cls) {
        HashMap map = (HashMap) this.f;
        if (map == null) {
            return null;
        }
        return (Annotation) map.get(cls);
    }

    @Override // defpackage.ly1
    public ByteBuffer h() {
        return ((Image.Plane) this.f).getBuffer();
    }

    public fd0 i(Object obj, j50 j50Var, Activity activity, t91 t91Var) throws IllegalAccessException, InvocationTargetException {
        Object objNewProxyInstance = Proxy.newProxyInstance((ClassLoader) this.f, new Class[]{j0()}, new ed0(j50Var, t91Var));
        objNewProxyInstance.getClass();
        obj.getClass().getMethod("addWindowLayoutInfoListener", Activity.class, j0()).invoke(obj, activity, objNewProxyInstance);
        return new fd0(obj.getClass().getMethod("removeWindowLayoutInfoListener", j0()), obj, objNewProxyInstance);
    }

    public void i0(int i, List list) {
        lb lbVar = (lb) this.f;
        ReentrantLock reentrantLock = (ReentrantLock) lbVar.f;
        ReentrantLock reentrantLock2 = (ReentrantLock) lbVar.f;
        ArrayList arrayList = (ArrayList) lbVar.z;
        reentrantLock.lock();
        while (arrayList.size() <= i) {
            try {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(as2.a(0, 5L));
                arrayList.add(new hf(arrayList2));
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
        }
        hf hfVar = (hf) arrayList.get(i);
        hfVar.a.lock();
        try {
            hfVar.b = list;
            reentrantLock2.unlock();
        } finally {
            hfVar.a.unlock();
        }
    }

    public Class j0() throws ClassNotFoundException {
        Class<?> clsLoadClass = ((ClassLoader) this.f).loadClass("java.util.function.Consumer");
        clsLoadClass.getClass();
        return clsLoadClass;
    }

    @Override // defpackage.ka0
    public void l(ed edVar) {
        m().l(edVar);
    }

    @Override // defpackage.zd3
    public ka0 m() {
        return (ka0) this.f;
    }

    @Override // defpackage.xh1
    public Cursor o(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.f;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException e) {
            a1.o("FontsProvider", "Unable to query the content provider", e);
            return null;
        }
    }

    @Override // defpackage.ka0
    public /* synthetic */ Object p(pg pgVar, Object obj) {
        return dw2.n(this, pgVar, obj);
    }

    @Override // defpackage.o9
    public int size() {
        HashMap map = (HashMap) this.f;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    @Override // defpackage.ka0
    public /* synthetic */ Set t() {
        return dw2.i(this);
    }

    public String toString() {
        switch (this.b) {
            case 1:
                return "ResolvedFeatureGroup(features=" + ((LinkedHashSet) this.f) + ')';
            case 5:
                HashMap map = (HashMap) this.f;
                return map == null ? "[null]" : map.toString();
            case 10:
                return String.valueOf((Collection) this.f);
            default:
                return super.toString();
        }
    }

    @Override // defpackage.ka0
    public /* synthetic */ Object u(pg pgVar) {
        return dw2.m(this, pgVar);
    }

    @Override // defpackage.ka0
    public /* synthetic */ Set y(pg pgVar) {
        return dw2.d(this, pgVar);
    }

    public /* synthetic */ cp1(int i, boolean z2) {
        this.b = i;
    }

    public cp1(tk tkVar) {
        this.b = 8;
        Objects.requireNonNull(tkVar);
        this.f = tkVar;
    }

    public cp1(FrameLayout frameLayout, TextInputLayout textInputLayout) {
        this.b = 23;
        this.f = textInputLayout;
    }

    public /* synthetic */ cp1(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    public cp1(ClassLoader classLoader) {
        this.b = 18;
        classLoader.getClass();
        this.f = classLoader;
    }

    public cp1(CameraCaptureSession cameraCaptureSession, Handler handler) {
        this.b = 12;
        if (Build.VERSION.SDK_INT >= 28) {
            this.f = new ny(cameraCaptureSession, null);
        } else {
            this.f = new lb(cameraCaptureSession, new oy(handler));
        }
    }

    public cp1(CameraDevice cameraDevice, Handler handler) {
        this.b = 13;
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            cameraDevice.getClass();
            this.f = new bz(cameraDevice, null);
        } else if (i >= 24) {
            this.f = new az(cameraDevice, new cz(handler));
        } else {
            this.f = new lb(cameraDevice, new cz(handler));
        }
    }

    public cp1(TextView textView) {
        this.b = 25;
        this.f = new w31(textView);
    }

    public cp1(Context context, Uri uri) {
        this.b = 28;
        this.f = context.getContentResolver().acquireUnstableContentProviderClient(uri);
    }
}
