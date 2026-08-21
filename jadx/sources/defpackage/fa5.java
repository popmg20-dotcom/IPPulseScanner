package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.media.Image;
import android.media.ImageReader;
import android.os.Binder;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.Surface;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class fa5 implements oy1, h73, qv1 {
    public static fa5 A;
    public static final fa5 X = new fa5(true, (String) null, (Exception) null);
    public boolean b;
    public final Object f;
    public Object z;

    public fa5(gt0[] gt0VarArr) {
        this.z = new HashMap();
        this.f = Collections.newSetFromMap(new IdentityHashMap(gt0VarArr.length));
        this.b = true;
        for (gt0 gt0Var : gt0VarArr) {
            ((Set) this.f).add(gt0Var);
            o(gt0Var);
        }
        for (gt0 gt0Var2 : (Set) this.f) {
            try {
                a(gt0Var2, gt0Var2.f.K());
            } catch (xs0 e) {
                xe.i(e);
                throw null;
            }
        }
    }

    public static synchronized void A() {
        Context context;
        try {
            fa5 fa5Var = A;
            if (fa5Var != null && (context = (Context) fa5Var.f) != null && ((da5) fa5Var.z) != null && fa5Var.b) {
                context.getContentResolver().unregisterContentObserver((da5) A.z);
            }
            A = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static fa5 B(String str, Exception exc) {
        return new fa5(false, str, exc);
    }

    public static boolean g(oz0 oz0Var, oz0 oz0Var2) {
        boolean zB = oz0Var2.b();
        int i = oz0Var2.a;
        r25.j("Fully specified range is not actually fully specified.", zB);
        int i2 = oz0Var.a;
        if (i2 == 2 && i == 1) {
            return false;
        }
        if (i2 != 2 && i2 != 0 && i2 != i) {
            return false;
        }
        int i3 = oz0Var.b;
        return i3 == 0 || i3 == oz0Var2.b;
    }

    public static boolean h(oz0 oz0Var, oz0 oz0Var2, HashSet hashSet) {
        if (hashSet.contains(oz0Var2)) {
            return g(oz0Var, oz0Var2);
        }
        ez4.o("DynamicRangeResolver", "Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  " + oz0Var + "\nCandidate dynamic range:\n  " + oz0Var2);
        return false;
    }

    public static oz0 m(oz0 oz0Var, LinkedHashSet linkedHashSet, HashSet hashSet) {
        if (oz0Var.a == 1) {
            return null;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            oz0 oz0Var2 = (oz0) it.next();
            r25.i(oz0Var2, "Fully specified DynamicRange cannot be null.");
            int i = oz0Var2.a;
            r25.j("Fully specified DynamicRange must have fully defined encoding.", oz0Var2.b());
            if (i != 1 && h(oz0Var, oz0Var2, hashSet)) {
                return oz0Var2;
            }
        }
        return null;
    }

    public static void r(HashSet hashSet, oz0 oz0Var, sz0 sz0Var) {
        r25.j("Cannot update already-empty constraints.", !hashSet.isEmpty());
        Set setC = ((rz0) sz0Var.a).c(oz0Var);
        if (setC.isEmpty()) {
            return;
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet.retainAll(setC);
        if (hashSet.isEmpty()) {
            a71.i("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  ", oz0Var, "\nConstraints:\n  ", TextUtils.join("\n  ", setC), "\nExisting constraints:\n  ", TextUtils.join("\n  ", hashSet2));
        }
    }

    public static fa5 v(Context context) {
        fa5 fa5Var;
        synchronized (fa5.class) {
            try {
                fa5 fa5Var2 = A;
                if (fa5Var2 == null) {
                    fa5Var2 = uf2.h(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new fa5(context) : new fa5(0);
                    A = fa5Var2;
                }
                if (((da5) fa5Var2.z) != null && !fa5Var2.b) {
                    try {
                        context.getContentResolver().registerContentObserver(n95.a, true, (da5) A.z);
                        fa5 fa5Var3 = A;
                        fa5Var3.getClass();
                        fa5Var3.b = true;
                    } catch (SecurityException e) {
                        a1.e("GservicesLoader", "Unable to register Gservices content observer", e);
                    }
                }
                fa5Var = A;
                fa5Var.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return fa5Var;
    }

    public static fa5 z(String str) {
        return new fa5(false, str, (Exception) null);
    }

    public void a(gt0 gt0Var, String str) throws xs0 {
        String strSubstring;
        HashMap map = (HashMap) this.z;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            strSubstring = str;
        } else {
            a(gt0Var, str.substring(0, iLastIndexOf));
            strSubstring = str.substring(iLastIndexOf + 1);
        }
        it0 it0Var = (it0) map.put(str, new ht0(strSubstring, str, gt0Var));
        if (it0Var != null) {
            map.put(str, it0Var);
            if (it0Var instanceof ht0) {
                return;
            }
            StringBuilder sbD = fw.D("\"", strSubstring, "\" is already defined (as something other than a package) in file \"");
            sbD.append(it0Var.c().f.H());
            sbD.append("\".");
            throw new xs0(gt0Var, sbD.toString());
        }
    }

    @Override // defpackage.qv1
    public synchronized we2 b(String str) {
        j54 j54Var;
        j54Var = (j54) ((HashMap) this.f).get(str);
        if (j54Var == null) {
            j54Var = new j54(str, (LinkedBlockingQueue) this.z, this.b);
            ((HashMap) this.f).put(str, j54Var);
        }
        return j54Var;
    }

    @Override // defpackage.oy1
    public int c() {
        int height;
        synchronized (this.z) {
            height = ((ImageReader) this.f).getHeight();
        }
        return height;
    }

    @Override // defpackage.oy1
    public void close() {
        synchronized (this.z) {
            ((ImageReader) this.f).close();
        }
    }

    @Override // defpackage.h73
    public void d(String str) {
        str.getClass();
        ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) this.f;
        profileEditorActivity.T0 = str;
        profileEditorActivity.A((String) this.z, this.b);
    }

    public void e(it0 it0Var) throws xs0 {
        HashMap map = (HashMap) this.z;
        String name = it0Var.getName();
        if (name.length() == 0) {
            throw new xs0(it0Var, "Missing name.");
        }
        for (int i = 0; i < name.length(); i++) {
            char cCharAt = name.charAt(i);
            if (('a' > cCharAt || cCharAt > 'z') && (('A' > cCharAt || cCharAt > 'Z') && cCharAt != '_' && ('0' > cCharAt || cCharAt > '9' || i <= 0))) {
                throw new xs0(it0Var, ha0.o("\"", name, "\" is not a valid identifier."));
            }
        }
        String strD = it0Var.d();
        it0 it0Var2 = (it0) map.put(strD, it0Var);
        if (it0Var2 != null) {
            map.put(strD, it0Var2);
            if (it0Var.c() != it0Var2.c()) {
                StringBuilder sbD = fw.D("\"", strD, "\" is already defined in file \"");
                sbD.append(it0Var2.c().f.H());
                sbD.append("\".");
                throw new xs0(it0Var, sbD.toString());
            }
            int iLastIndexOf = strD.lastIndexOf(46);
            if (iLastIndexOf == -1) {
                throw new xs0(it0Var, ha0.o("\"", strD, "\" is already defined."));
            }
            throw new xs0(it0Var, "\"" + strD.substring(iLastIndexOf + 1) + "\" is already defined in \"" + strD.substring(0, iLastIndexOf) + "\".");
        }
    }

    @Override // defpackage.oy1
    public int f() {
        int width;
        synchronized (this.z) {
            width = ((ImageReader) this.f).getWidth();
        }
        return width;
    }

    @Override // defpackage.oy1
    public Surface getSurface() {
        Surface surface;
        synchronized (this.z) {
            surface = ((ImageReader) this.f).getSurface();
        }
        return surface;
    }

    @Override // defpackage.oy1
    public my1 i() {
        Image imageAcquireLatestImage;
        synchronized (this.z) {
            try {
                imageAcquireLatestImage = ((ImageReader) this.f).acquireLatestImage();
            } catch (RuntimeException e) {
                if (!"ImageReaderContext is not initialized".equals(e.getMessage())) {
                    throw e;
                }
                imageAcquireLatestImage = null;
            }
            if (imageAcquireLatestImage == null) {
                return null;
            }
            return new q7(imageAcquireLatestImage);
        }
    }

    @Override // defpackage.oy1
    public int j() {
        int imageFormat;
        synchronized (this.z) {
            imageFormat = ((ImageReader) this.f).getImageFormat();
        }
        return imageFormat;
    }

    public void k(t9 t9Var, wa4 wa4Var) {
        ub4 ub4Var = (ub4) ((wn1) this.z).f;
        ub4Var.getClass();
        l05 l05Var = (l05) ((q05) t9Var).s();
        eb4 eb4Var = (eb4) ub4Var.b;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(l05Var.e);
        int i = xz4.a;
        if (eb4Var == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            eb4Var.writeToParcel(parcelObtain, 0);
        }
        try {
            l05Var.d.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            wa4Var.a.g(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // defpackage.oy1
    public void l() {
        synchronized (this.z) {
            this.b = true;
            ((ImageReader) this.f).setOnImageAvailableListener(null, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if ((r0 instanceof defpackage.lt0) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.it0 n(int r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.z
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.lang.Object r0 = r0.get(r7)
            it0 r0 = (defpackage.it0) r0
            r1 = 2
            r2 = 1
            r3 = 3
            if (r0 == 0) goto L2f
            if (r6 == r3) goto L2e
            if (r6 != r2) goto L1c
            boolean r4 = r0 instanceof defpackage.ws0
            if (r4 != 0) goto L1b
            boolean r4 = r0 instanceof defpackage.zs0
            if (r4 == 0) goto L1c
        L1b:
            return r0
        L1c:
            if (r6 != r1) goto L2f
            boolean r4 = r0 instanceof defpackage.ws0
            if (r4 != 0) goto L2e
            boolean r4 = r0 instanceof defpackage.zs0
            if (r4 != 0) goto L2e
            boolean r4 = r0 instanceof defpackage.ht0
            if (r4 != 0) goto L2e
            boolean r4 = r0 instanceof defpackage.lt0
            if (r4 == 0) goto L2f
        L2e:
            return r0
        L2f:
            java.lang.Object r5 = r5.f
            java.util.Set r5 = (java.util.Set) r5
            java.util.Iterator r5 = r5.iterator()
        L37:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L71
            java.lang.Object r0 = r5.next()
            gt0 r0 = (defpackage.gt0) r0
            fa5 r0 = r0.z0
            java.lang.Object r0 = r0.z
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.lang.Object r0 = r0.get(r7)
            it0 r0 = (defpackage.it0) r0
            if (r0 == 0) goto L37
            if (r6 == r3) goto L70
            if (r6 != r2) goto L5e
            boolean r4 = r0 instanceof defpackage.ws0
            if (r4 != 0) goto L5d
            boolean r4 = r0 instanceof defpackage.zs0
            if (r4 == 0) goto L5e
        L5d:
            return r0
        L5e:
            if (r6 != r1) goto L37
            boolean r4 = r0 instanceof defpackage.ws0
            if (r4 != 0) goto L70
            boolean r4 = r0 instanceof defpackage.zs0
            if (r4 != 0) goto L70
            boolean r4 = r0 instanceof defpackage.ht0
            if (r4 != 0) goto L70
            boolean r4 = r0 instanceof defpackage.lt0
            if (r4 == 0) goto L37
        L70:
            return r0
        L71:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fa5.n(int, java.lang.String):it0");
    }

    public void o(gt0 gt0Var) {
        for (gt0 gt0Var2 : DesugarCollections.unmodifiableList(Arrays.asList(gt0Var.y0))) {
            if (((Set) this.f).add(gt0Var2)) {
                o(gt0Var2);
            }
        }
    }

    @Override // defpackage.oy1
    public void p(final ny1 ny1Var, final Executor executor) {
        synchronized (this.z) {
            this.b = false;
            ((ImageReader) this.f).setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: r7
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    fa5 fa5Var = this.a;
                    Executor executor2 = executor;
                    ny1 ny1Var2 = ny1Var;
                    synchronized (fa5Var.z) {
                        try {
                            if (!fa5Var.b) {
                                executor2.execute(new s7(0, fa5Var, ny1Var2));
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }, uf2.s());
        }
    }

    public it0 q(it0 it0Var, String str) throws xs0 {
        it0 it0VarN;
        String string;
        if (str.startsWith(".")) {
            string = str.substring(1);
            it0VarN = n(1, string);
        } else {
            int iIndexOf = str.indexOf(46);
            String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
            StringBuilder sb = new StringBuilder(it0Var.d());
            while (true) {
                int iLastIndexOf = sb.lastIndexOf(".");
                if (iLastIndexOf == -1) {
                    it0VarN = n(1, str);
                    string = str;
                    break;
                }
                int i = iLastIndexOf + 1;
                sb.setLength(i);
                sb.append(strSubstring);
                it0 it0VarN2 = n(2, sb.toString());
                if (it0VarN2 != null) {
                    if (iIndexOf != -1) {
                        sb.setLength(i);
                        sb.append(str);
                        it0VarN = n(1, sb.toString());
                    } else {
                        it0VarN = it0VarN2;
                    }
                    string = sb.toString();
                } else {
                    sb.setLength(iLastIndexOf);
                }
            }
        }
        if (it0VarN != null) {
            return it0VarN;
        }
        if (!this.b) {
            throw new xs0(it0Var, ha0.o("\"", str, "\" is not defined."));
        }
        mt0.a.warning("The descriptor for message type \"" + str + "\" cannot be found and a placeholder is created for it");
        ws0 ws0Var = new ws0(string);
        ((Set) this.f).add(ws0Var.X.c());
        return ws0Var;
    }

    @Override // defpackage.oy1
    public int s() {
        int maxImages;
        synchronized (this.z) {
            maxImages = ((ImageReader) this.f).getMaxImages();
        }
        return maxImages;
    }

    @Override // defpackage.oy1
    public my1 t() {
        Image imageAcquireNextImage;
        synchronized (this.z) {
            try {
                imageAcquireNextImage = ((ImageReader) this.f).acquireNextImage();
            } catch (RuntimeException e) {
                if (!"ImageReaderContext is not initialized".equals(e.getMessage())) {
                    throw e;
                }
                imageAcquireNextImage = null;
            }
            if (imageAcquireNextImage == null) {
                return null;
            }
            return new q7(imageAcquireNextImage);
        }
    }

    public String u() {
        return (String) this.f;
    }

    public void w(ag5 ag5Var) {
        synchronized (this.f) {
            try {
                ArrayDeque arrayDeque = (ArrayDeque) this.z;
                if (arrayDeque == null) {
                    arrayDeque = new ArrayDeque();
                    this.z = arrayDeque;
                }
                arrayDeque.add(ag5Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String x(String str) {
        Object objB;
        Context context = (Context) this.f;
        if (context != null && (!u95.a() || u95.b(context))) {
            try {
                try {
                    ca5 ca5Var = new ca5(this, str, false);
                    try {
                        objB = ca5Var.b();
                    } catch (SecurityException unused) {
                        long jClearCallingIdentity = Binder.clearCallingIdentity();
                        try {
                            objB = ca5Var.b();
                        } finally {
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                        }
                    }
                    return (String) objB;
                } catch (SecurityException e) {
                    e = e;
                    a1.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
                    return null;
                }
            } catch (IllegalStateException e2) {
                e = e2;
                a1.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
                return null;
            } catch (NullPointerException e3) {
                e = e3;
                a1.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
                return null;
            }
        }
        return null;
    }

    public void y(wt2 wt2Var) {
        ag5 ag5Var;
        synchronized (this.f) {
            if (((ArrayDeque) this.z) != null && !this.b) {
                this.b = true;
                while (true) {
                    synchronized (this.f) {
                        try {
                            ag5Var = (ag5) ((ArrayDeque) this.z).poll();
                            if (ag5Var == null) {
                                this.b = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    ag5Var.a(wt2Var);
                }
            }
        }
    }

    public fa5(wn1 wn1Var, ic1[] ic1VarArr, boolean z) {
        this.z = wn1Var;
        this.f = ic1VarArr;
        boolean z2 = false;
        if (ic1VarArr != null && z) {
            z2 = true;
        }
        this.b = z2;
    }

    public fa5(ProfileEditorActivity profileEditorActivity, String str, boolean z) {
        this.f = profileEditorActivity;
        this.z = str;
        this.b = z;
    }

    public fa5(boolean z, String str, Exception exc) {
        this.b = z;
        this.f = str;
        this.z = exc;
    }

    public fa5(Context context) {
        this.b = false;
        this.f = context;
        this.z = new da5(null);
    }

    public fa5(ImageReader imageReader) {
        this.z = new Object();
        this.b = true;
        this.f = imageReader;
    }

    public fa5(Executor executor, CameraCharacteristics cameraCharacteristics) {
        oj1 oj1Var = vt0.a;
        if (vt0.a.z(LowMemoryQuirk.class) != null) {
            this.f = new at3(executor);
        } else {
            this.f = executor;
        }
        this.z = oj1Var;
        this.b = oj1Var.y(IncorrectJpegMetadataQuirk.class);
    }

    public fa5(sy syVar) {
        this.f = syVar;
        this.z = sz0.d(syVar);
        int[] iArr = (int[]) syVar.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        boolean z = false;
        if (iArr != null) {
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (iArr[i] == 18) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.b = z;
    }

    public fa5(int i) {
        switch (i) {
            case 7:
                this.b = false;
                this.f = new HashMap();
                this.z = new LinkedBlockingQueue();
                break;
            case 8:
            default:
                this.b = false;
                this.f = null;
                this.z = null;
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                this.f = new Object();
                break;
        }
    }
}
