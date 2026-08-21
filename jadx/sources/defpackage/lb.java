package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import android.os.Looper;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Choreographer;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentContainerView;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class lb implements sz3, ho3, nw0, fy {
    public static final int[] A = {R.attr.indeterminateDrawable, R.attr.progressDrawable};
    public static final lb X;
    public static final int[] Y;
    public final /* synthetic */ int b;
    public Object f;
    public Object z;

    static {
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        X = new lb(1, new f03(fValueOf2, fValueOf2), new f03(fValueOf, fValueOf));
        Y = new int[]{1, 1, 2};
    }

    public lb(int i) {
        this.b = i;
        int i2 = 1;
        switch (i) {
            case 4:
                this.f = Choreographer.getInstance();
                this.z = Looper.myLooper();
                break;
            case 6:
                this.f = new Rect();
                this.z = new Rect();
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                this.z = new ArrayList(128);
                this.f = new ReentrantLock();
                break;
            case 27:
                m24 m24VarA = n24.a(new e03(Integer.MIN_VALUE, null));
                this.f = m24VarA;
                this.z = new av(i2, m24VarA);
                break;
            default:
                this.f = new mk4(1);
                this.z = new mk4(0);
                break;
        }
    }

    public static ArrayList Q(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ax2) it.next()).a.e());
        }
        return arrayList;
    }

    public static String p(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("r8-abstract-class");
    }

    public static void q(CameraDevice cameraDevice, xt3 xt3Var) {
        cameraDevice.getClass();
        wt3 wt3Var = xt3Var.a;
        wt3Var.f().getClass();
        List listG = wt3Var.g();
        if (listG == null) {
            xe.k("Invalid output configurations");
            return;
        }
        if (wt3Var.e() == null) {
            xe.k("Invalid executor");
            return;
        }
        String id = cameraDevice.getId();
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            String strD = ((ax2) it.next()).a.d();
            if (strD != null && !strD.isEmpty()) {
                ez4.a0("CameraDeviceCompat", fw.v("Camera ", id, ": Camera doesn't support physicalCameraId ", strD, ". Ignoring."));
            }
        }
    }

    public void A(AttributeSet attributeSet, int i) {
        boolean z = true;
        switch (this.b) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f;
                n02 n02VarY = n02.y(absSeekBar.getContext(), attributeSet, A, i);
                Drawable drawableP = n02VarY.p(0);
                if (drawableP != null) {
                    if (drawableP instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableP;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i2 = 0; i2 < numberOfFrames; i2++) {
                            Drawable drawableO = O(animationDrawable.getFrame(i2), true);
                            drawableO.setLevel(10000);
                            animationDrawable2.addFrame(drawableO, animationDrawable.getDuration(i2));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableP = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(drawableP);
                }
                Drawable drawableP2 = n02VarY.p(1);
                if (drawableP2 != null) {
                    absSeekBar.setProgressDrawable(O(drawableP2, false));
                }
                n02VarY.K();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) this.f).getContext().obtainStyledAttributes(attributeSet, cd3.i, i, 0);
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(14)) {
                        z = typedArrayObtainStyledAttributes.getBoolean(14, true);
                        break;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                    K(z);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public p31 B(InputConnection inputConnection, EditorInfo editorInfo) {
        InputConnection inputConnection2;
        w7 w7Var = (w7) this.z;
        if (inputConnection == null) {
            inputConnection2 = null;
        } else {
            eg0 eg0Var = (eg0) w7Var.f;
            if (!(inputConnection instanceof p31)) {
                inputConnection = new p31((EditText) eg0Var.f, inputConnection, editorInfo);
            }
            inputConnection2 = inputConnection;
        }
        return (p31) inputConnection2;
    }

    public void C(u3 u3Var) {
        iv1 iv1Var = (iv1) this.f;
        ((ActionMode.Callback) iv1Var.f).onDestroyActionMode(iv1Var.n(u3Var));
        za zaVar = (za) this.z;
        if (zaVar.M0 != null) {
            zaVar.C0.getDecorView().removeCallbacks(zaVar.N0);
        }
        if (zaVar.L0 != null) {
            cr4 cr4Var = zaVar.O0;
            if (cr4Var != null) {
                cr4Var.b();
            }
            cr4 cr4VarA = wp4.a(zaVar.L0);
            cr4VarA.a(0.0f);
            zaVar.O0 = cr4VarA;
            cr4VarA.d(new pa(2, this));
        }
        zaVar.K0 = null;
        ViewGroup viewGroup = zaVar.Q0;
        WeakHashMap weakHashMap = wp4.a;
        viewGroup.requestApplyInsets();
        zaVar.M();
    }

    public boolean D(u3 u3Var, Menu menu) {
        ViewGroup viewGroup = ((za) this.z).Q0;
        WeakHashMap weakHashMap = wp4.a;
        viewGroup.requestApplyInsets();
        iv1 iv1Var = (iv1) this.f;
        ActionMode.Callback callback = (ActionMode.Callback) iv1Var.f;
        w54 w54VarN = iv1Var.n(u3Var);
        xw3 xw3Var = (xw3) iv1Var.X;
        Menu jl2Var = (Menu) xw3Var.get(menu);
        if (jl2Var == null) {
            jl2Var = new jl2((Context) iv1Var.z, (nk2) menu);
            xw3Var.put(menu, jl2Var);
        }
        return callback.onPrepareActionMode(w54VarN, jl2Var);
    }

    public void E(ei1 ei1Var) {
        x61 x61Var = (x61) this.z;
        ub4 ub4Var = (ub4) this.f;
        int i = ei1Var.b;
        if (i != 0) {
            x61Var.execute(new zv(i, 0, ub4Var));
        } else {
            x61Var.execute(new um1(4, ub4Var, ei1Var.a));
        }
    }

    public void F(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws xx {
        executor.getClass();
        stateCallback.getClass();
        try {
            ((CameraManager) this.f).openCamera(str, new xw(executor, stateCallback), ((tz) this.z).b);
        } catch (CameraAccessException e) {
            throw new xx(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x0209, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0109 A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TryCatch #2 {IOException -> 0x0091, XmlPullParserException -> 0x0094, blocks: (B:20:0x0062, B:97:0x0209, B:28:0x0074, B:29:0x0082, B:31:0x0087, B:38:0x0097, B:46:0x00b1, B:41:0x00a0, B:44:0x00a9, B:47:0x00bf, B:51:0x00ce, B:53:0x00d6, B:54:0x00e0, B:63:0x0109, B:64:0x0110, B:65:0x0128, B:57:0x00e9, B:59:0x00f1, B:60:0x00ff, B:66:0x0129, B:68:0x0131, B:69:0x013f, B:72:0x0149, B:73:0x0154, B:74:0x016c, B:75:0x016d, B:78:0x0177, B:79:0x0182, B:80:0x019a, B:81:0x019b, B:83:0x01a3, B:84:0x01ac, B:87:0x01b6, B:88:0x01c0, B:89:0x01d8, B:90:0x01d9, B:93:0x01e3, B:94:0x01ed, B:95:0x0205, B:96:0x0206), top: B:105:0x0062 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G(android.content.Context r12, android.content.res.XmlResourceParser r13) {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lb.G(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0193 A[LOOP:0: B:3:0x000a->B:95:0x0193, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.jr2 H(defpackage.aj3 r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lb.H(aj3):jr2");
    }

    public void I(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        oz ozVar;
        if (executor == null) {
            xe.k("executor was null");
            return;
        }
        tz tzVar = (tz) this.z;
        synchronized (tzVar.a) {
            try {
                ozVar = (oz) tzVar.a.get(availabilityCallback);
                if (ozVar == null) {
                    ozVar = new oz(executor, availabilityCallback);
                    tzVar.a.put(availabilityCallback, ozVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ((CameraManager) this.f).registerAvailabilityCallback(ozVar, tzVar.b);
    }

    public void J(Object obj) {
        m24 m24Var = (m24) this.f;
        m24Var.j(null, new e03(Integer.valueOf(((Number) ((e03) m24Var.i()).b).intValue() + 1), obj));
    }

    public void K(boolean z) {
        y31 y31Var = (y31) ((eg0) ((w7) this.z).f).z;
        if (y31Var.z != z) {
            if (y31Var.f != null) {
                k31 k31VarA = k31.a();
                x31 x31Var = y31Var.f;
                k31VarA.getClass();
                r25.i(x31Var, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = k31VarA.a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    k31VarA.b.remove(x31Var);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            y31Var.z = z;
            if (z) {
                y31.a(y31Var.b, k31.a().b());
            }
        }
    }

    public int L(List list, at3 at3Var, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.f).setRepeatingBurst(list, new lw(at3Var, captureCallback), ((oy) this.z).a);
    }

    public void M(int i, int i2, int i3, int i4) {
        q10 q10Var = (q10) this.z;
        q10Var.A.set(i, i2, i3, i4);
        Rect rect = q10Var.z;
        super/*android.widget.FrameLayout*/.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    public int N(CaptureRequest captureRequest, at3 at3Var, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.f).setRepeatingRequest(captureRequest, new lw(at3Var, captureCallback), ((oy) this.z).a);
    }

    public Drawable O(Drawable drawable, boolean z) {
        if (!(drawable instanceof LayerDrawable)) {
            if (!(drawable instanceof BitmapDrawable)) {
                return drawable;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (((Bitmap) this.z) == null) {
                this.z = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i = 0; i < numberOfLayers; i++) {
            int id = layerDrawable.getId(i);
            drawableArr[i] = O(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable2.setId(i2, layerDrawable.getId(i2));
            layerDrawable2.setLayerGravity(i2, layerDrawable.getLayerGravity(i2));
            layerDrawable2.setLayerWidth(i2, layerDrawable.getLayerWidth(i2));
            layerDrawable2.setLayerHeight(i2, layerDrawable.getLayerHeight(i2));
            layerDrawable2.setLayerInsetLeft(i2, layerDrawable.getLayerInsetLeft(i2));
            layerDrawable2.setLayerInsetRight(i2, layerDrawable.getLayerInsetRight(i2));
            layerDrawable2.setLayerInsetTop(i2, layerDrawable.getLayerInsetTop(i2));
            layerDrawable2.setLayerInsetBottom(i2, layerDrawable.getLayerInsetBottom(i2));
            layerDrawable2.setLayerInsetStart(i2, layerDrawable.getLayerInsetStart(i2));
            layerDrawable2.setLayerInsetEnd(i2, layerDrawable.getLayerInsetEnd(i2));
        }
        return layerDrawable2;
    }

    public void P() {
        synchronized (this) {
            ((AtomicInteger) this.f).decrementAndGet();
            if (((AtomicInteger) this.f).get() < 0) {
                throw new IllegalStateException("Unbalanced call to unblock() detected.");
            }
        }
    }

    public void R(CameraManager.AvailabilityCallback availabilityCallback) {
        oz ozVar;
        if (availabilityCallback != null) {
            tz tzVar = (tz) this.z;
            synchronized (tzVar.a) {
                ozVar = (oz) tzVar.a.remove(availabilityCallback);
            }
        } else {
            ozVar = null;
        }
        if (ozVar != null) {
            ozVar.a();
        }
        ((CameraManager) this.f).unregisterAvailabilityCallback(ozVar);
    }

    public void S(lz lzVar, mg mgVar) {
        lg lgVar;
        lg lgVar2;
        if (mgVar == null || mgVar.a != 8) {
            switch (lzVar.ordinal()) {
                case 0:
                case 2:
                    lgVar = new lg(5, mgVar);
                    break;
                case 1:
                case 4:
                    lgVar = new lg(4, mgVar);
                    break;
                case 3:
                    d00 d00Var = (d00) this.f;
                    synchronized (d00Var.b) {
                        Iterator it = d00Var.e.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                lgVar2 = new lg(1, null);
                            } else if (((c00) ((Map.Entry) it.next()).getValue()).a == lz.CLOSING) {
                                lgVar2 = new lg(2, null);
                            }
                        }
                    }
                    lgVar = lgVar2;
                    break;
                case 5:
                    lgVar = new lg(2, mgVar);
                    break;
                case 6:
                case 7:
                    lgVar = new lg(3, mgVar);
                    break;
                default:
                    s53.j(lzVar, "Unknown internal camera state: ");
                    return;
            }
        } else {
            lgVar = new lg(5, mgVar);
        }
        ez4.o("CameraStateMachine", "New public camera state " + lgVar + " from " + lzVar + " and " + mgVar);
        if (Objects.equals((lg) ((on2) this.z).d(), lgVar)) {
            return;
        }
        ez4.o("CameraStateMachine", "Publishing new public camera state " + lgVar);
        ((on2) this.z).i(lgVar);
    }

    @Override // defpackage.fy
    public pa4 a() {
        return (pa4) this.f;
    }

    @Override // defpackage.fy
    public int b() {
        Integer num = (Integer) ((CaptureResult) this.z).get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return 1;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0 || iIntValue == 1) {
            return 2;
        }
        if (iIntValue == 2) {
            return 3;
        }
        if (iIntValue == 3 || iIntValue == 4) {
            return 4;
        }
        ez4.q("C2CameraCaptureResult", "Undefined flash state: " + num);
        return 1;
    }

    @Override // defpackage.fy
    public long c() {
        Long l = (Long) ((CaptureResult) this.z).get(CaptureResult.SENSOR_TIMESTAMP);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    @Override // defpackage.sz3
    public void d(int i) {
        boolean zTryLock;
        lb lbVar = (lb) this.z;
        ArrayList arrayList = (ArrayList) lbVar.z;
        ReentrantLock reentrantLock = (ReentrantLock) lbVar.f;
        if (i < 0 || i >= arrayList.size()) {
            hf hfVar = (hf) this.f;
            if (hfVar != null) {
                hfVar.a.unlock();
            }
            this.f = null;
            return;
        }
        hf hfVar2 = (hf) this.f;
        if (hfVar2 != null) {
            hfVar2.a.unlock();
        }
        try {
            zTryLock = reentrantLock.tryLock(100L, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            a1.o("LockedSpans", "failed to acquire the lock", e);
            Thread.currentThread().interrupt();
            zTryLock = false;
        }
        if (!zTryLock) {
            this.f = null;
            return;
        }
        try {
            hf hfVar3 = (hf) arrayList.get(i);
            if (hfVar3.a.tryLock()) {
                this.f = hfVar3;
            } else {
                this.f = null;
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // defpackage.nw0
    public List e(String str) throws UnknownHostException {
        str.getClass();
        String str2 = (String) this.f;
        if (n12.c(str2, str)) {
            return (List) this.z;
        }
        throw new UnknownHostException(fw.u("BootstrapDns called for ", str, " instead of ", str2));
    }

    @Override // defpackage.fy
    public ey f() {
        Integer num = (Integer) ((CaptureResult) this.z).get(CaptureResult.CONTROL_AWB_STATE);
        ey eyVar = ey.b;
        if (num == null) {
            return eyVar;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return ey.f;
        }
        if (iIntValue == 1) {
            return ey.z;
        }
        if (iIntValue == 2) {
            return ey.A;
        }
        if (iIntValue == 3) {
            return ey.X;
        }
        ez4.q("C2CameraCaptureResult", "Undefined awb state: " + num);
        return eyVar;
    }

    @Override // defpackage.sz3
    public List g(int i) {
        boolean zTryLock;
        lb lbVar = (lb) this.z;
        ArrayList arrayList = (ArrayList) lbVar.z;
        ReentrantLock reentrantLock = (ReentrantLock) lbVar.f;
        ArrayList arrayList2 = new ArrayList();
        try {
            zTryLock = reentrantLock.tryLock(1L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            a1.o("LockedSpans", "failed to acquire the lock", e);
            zTryLock = false;
        }
        if (zTryLock) {
            try {
                hf hfVar = i < arrayList.size() ? (hf) arrayList.get(i) : null;
                if (hfVar != null) {
                    ReentrantLock reentrantLock2 = hfVar.a;
                    if (reentrantLock2.tryLock()) {
                        try {
                            return DesugarCollections.unmodifiableList(hfVar.b);
                        } finally {
                            reentrantLock2.unlock();
                        }
                    }
                }
                arrayList2.add(z(0));
            } finally {
                reentrantLock.unlock();
            }
        } else {
            arrayList2.add(z(0));
        }
        return arrayList2;
    }

    @Override // defpackage.fy
    public cy h() {
        Integer num = (Integer) ((CaptureResult) this.z).get(CaptureResult.CONTROL_AE_STATE);
        cy cyVar = cy.b;
        if (num == null) {
            return cyVar;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return cy.f;
        }
        if (iIntValue != 1) {
            if (iIntValue == 2) {
                return cy.X;
            }
            if (iIntValue == 3) {
                return cy.Y;
            }
            if (iIntValue == 4) {
                return cy.A;
            }
            if (iIntValue != 5) {
                ez4.q("C2CameraCaptureResult", "Undefined ae state: " + num);
                return cyVar;
            }
        }
        return cy.z;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #3 {all -> 0x00a4, blocks: (B:20:0x004a, B:22:0x004e, B:25:0x005f, B:29:0x0066, B:31:0x0070, B:33:0x007b, B:32:0x0076, B:27:0x0063, B:28:0x0065, B:45:0x009c, B:46:0x00a3, B:24:0x005a), top: B:73:0x004a, outer: #5, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009c A[Catch: all -> 0x00a4, TRY_ENTER, TryCatch #3 {all -> 0x00a4, blocks: (B:20:0x004a, B:22:0x004e, B:25:0x005f, B:29:0x0066, B:31:0x0070, B:33:0x007b, B:32:0x0076, B:27:0x0063, B:28:0x0065, B:45:0x009c, B:46:0x00a3, B:24:0x005a), top: B:73:0x004a, outer: #5, inners: #0 }] */
    @Override // defpackage.ho3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.go3 i(java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lb.i(java.lang.String):go3");
    }

    @Override // defpackage.fy
    public CaptureResult j() {
        return (CaptureResult) this.z;
    }

    @Override // defpackage.fy
    public dy k() {
        Integer num = (Integer) ((CaptureResult) this.z).get(CaptureResult.CONTROL_AF_STATE);
        dy dyVar = dy.b;
        if (num == null) {
            return dyVar;
        }
        switch (num.intValue()) {
            case 0:
                break;
            case 1:
            case 3:
                break;
            case 2:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                ez4.q("C2CameraCaptureResult", "Undefined af state: " + num);
                break;
        }
        return dyVar;
    }

    @Override // defpackage.sz3
    public int l() {
        hf hfVar = (hf) this.f;
        if (hfVar == null) {
            return 1;
        }
        return hfVar.b.size();
    }

    public boolean m() {
        synchronized (this) {
            if (((AtomicBoolean) this.z).get()) {
                return false;
            }
            ((AtomicInteger) this.f).incrementAndGet();
            return true;
        }
    }

    public void n() {
        ed4 ed4Var = (ed4) this.f;
        if (ed4Var != null) {
            ((AtomicBoolean) ed4Var.z).set(true);
            ((ScheduledFuture) ed4Var.f).cancel(true);
        }
        this.f = null;
    }

    public int o(List list, at3 at3Var, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.f).captureBurst(list, new lw(at3Var, captureCallback), ((oy) this.z).a);
    }

    public void r(xt3 xt3Var) throws xx {
        CameraDevice cameraDevice = (CameraDevice) this.f;
        q(cameraDevice, xt3Var);
        wt3 wt3Var = xt3Var.a;
        my myVar = new my(wt3Var.e(), wt3Var.f());
        ArrayList arrayListQ = Q(wt3Var.g());
        cz czVar = (cz) this.z;
        czVar.getClass();
        Handler handler = czVar.a;
        j02 j02VarD = wt3Var.d();
        try {
            if (j02VarD != null) {
                InputConfiguration inputConfiguration = j02VarD.a.a;
                inputConfiguration.getClass();
                cameraDevice.createReprocessableCaptureSession(inputConfiguration, arrayListQ, myVar, handler);
            } else {
                if (wt3Var.b() == 1) {
                    cameraDevice.createConstrainedHighSpeedCaptureSession(arrayListQ, myVar, handler);
                    return;
                }
                try {
                    cameraDevice.createCaptureSession(arrayListQ, myVar, handler);
                } catch (CameraAccessException e) {
                    throw new xx(e);
                }
            }
        } catch (CameraAccessException e2) {
            throw new xx(e2);
        }
    }

    public vk3 s(int i, int i2, bn bnVar) throws qs2 {
        EnumMap enumMap;
        int[] iArrK = nk4.k(bnVar, i2, false, Y, new int[3]);
        try {
            return ((mk4) this.z).a(i, bnVar, iArrK);
        } catch (de3 unused) {
            mk4 mk4Var = (mk4) this.f;
            StringBuilder sb = mk4Var.b;
            sb.setLength(0);
            int[] iArr = mk4Var.a;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            int i3 = bnVar.f;
            int iF = iArrK[1];
            int i4 = 0;
            for (int i5 = 0; i5 < 2 && iF < i3; i5++) {
                int iG = nk4.g(bnVar, iArr, iF, nk4.g);
                sb.append((char) ((iG % 10) + 48));
                for (int i6 : iArr) {
                    iF += i6;
                }
                if (iG >= 10) {
                    i4 |= 1 << (1 - i5);
                }
                if (i5 != 1) {
                    iF = bnVar.f(bnVar.e(iF));
                }
            }
            if (sb.length() != 2) {
                throw qs2.a();
            }
            if (Integer.parseInt(sb.toString()) % 4 != i4) {
                throw qs2.a();
            }
            String string = sb.toString();
            if (string.length() != 2) {
                enumMap = null;
            } else {
                enumMap = new EnumMap(wk3.class);
                enumMap.put(wk3.Y, Integer.valueOf(string));
            }
            float f = i;
            vk3 vk3Var = new vk3(string, null, new xk3[]{new xk3((iArrK[0] + iArrK[1]) / 2.0f, f), new xk3(iF, f)}, sj.H0);
            if (enumMap != null) {
                vk3Var.a(enumMap);
            }
            return vk3Var;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.st2 t(defpackage.bk4 r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lb.t(bk4, boolean):st2");
    }

    public String toString() {
        switch (this.b) {
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                try {
                    return u().toString();
                } catch (qs2 unused) {
                    return "";
                }
            case 29:
                return ((Map) this.f).toString();
            default:
                return super.toString();
        }
    }

    public cn u() throws qs2 {
        int[] iArr;
        cn cnVar = (cn) this.z;
        if (cnVar != null) {
            return cnVar;
        }
        iv1 iv1Var = (iv1) this.f;
        cn cnVar2 = (cn) iv1Var.X;
        if (cnVar2 == null) {
            kf2 kf2Var = (kf2) iv1Var.f;
            int i = kf2Var.a;
            int i2 = kf2Var.b;
            boolean z = true;
            int i3 = 0;
            if (i < 40 || i2 < 40) {
                cn cnVar3 = new cn(i, i2);
                if (((byte[]) iv1Var.z).length < i) {
                    iv1Var.z = new byte[i];
                }
                int i4 = 0;
                while (true) {
                    iArr = (int[]) iv1Var.A;
                    if (i4 >= 32) {
                        break;
                    }
                    iArr[i4] = 0;
                    i4++;
                }
                for (int i5 = 1; i5 < 5; i5++) {
                    byte[] bArrB = kf2Var.b((i2 * i5) / 5, (byte[]) iv1Var.z);
                    int i6 = (i * 4) / 5;
                    for (int i7 = i / 5; i7 < i6; i7++) {
                        int i8 = (bArrB[i7] & 255) >> 3;
                        iArr[i8] = iArr[i8] + 1;
                    }
                }
                int iK = iv1.k(iArr);
                byte[] bArrA = kf2Var.a();
                for (int i9 = 0; i9 < i2; i9++) {
                    int i10 = i9 * i;
                    for (int i11 = 0; i11 < i; i11++) {
                        if ((bArrA[i10 + i11] & 255) < iK) {
                            cnVar3.f(i11, i9);
                        }
                    }
                }
                iv1Var.X = cnVar3;
                cnVar2 = cnVar3;
            } else {
                byte[] bArrA2 = kf2Var.a();
                int i12 = i >> 3;
                if ((i & 7) != 0) {
                    i12++;
                }
                int i13 = i2 >> 3;
                if ((i2 & 7) != 0) {
                    i13++;
                }
                int i14 = i2 - 8;
                int i15 = i - 8;
                int i16 = 2;
                int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i13, i12);
                int i17 = 0;
                while (true) {
                    int i18 = 8;
                    if (i17 >= i13) {
                        break;
                    }
                    boolean z2 = z;
                    int i19 = i17 << 3;
                    if (i19 > i14) {
                        i19 = i14;
                    }
                    int i20 = i3;
                    while (i3 < i12) {
                        int i21 = i16;
                        int i22 = i3 << 3;
                        if (i22 > i15) {
                            i22 = i15;
                        }
                        int i23 = (i19 * i) + i22;
                        int i24 = i20;
                        int i25 = i24;
                        int i26 = i25;
                        int i27 = DnsRecord.CLASS_ANY;
                        while (i24 < i18) {
                            byte[] bArr = bArrA2;
                            int i28 = i19;
                            int i29 = i20;
                            int i30 = i26;
                            int i31 = i27;
                            while (i29 < i18) {
                                int i32 = i29;
                                int i33 = bArr[i23 + i29] & 255;
                                i25 += i33;
                                if (i33 < i31) {
                                    i31 = i33;
                                }
                                if (i33 > i30) {
                                    i30 = i33;
                                }
                                i29 = i32 + 1;
                                i18 = 8;
                            }
                            if (i30 - i31 > 24) {
                                while (true) {
                                    i24++;
                                    i23 += i;
                                    if (i24 < 8) {
                                        int i34 = i20;
                                        for (int i35 = 8; i34 < i35; i35 = 8) {
                                            i25 += bArr[i23 + i34] & 255;
                                            i34++;
                                            i31 = i31;
                                        }
                                    }
                                }
                            }
                            i24++;
                            i23 += i;
                            i27 = i31;
                            bArrA2 = bArr;
                            i19 = i28;
                            i18 = 8;
                            i26 = i30;
                        }
                        byte[] bArr2 = bArrA2;
                        int i36 = i19;
                        int i37 = i25 >> 6;
                        int i38 = i27;
                        if (i26 - i38 <= 24) {
                            i37 = i38 / 2;
                            if (i17 > 0 && i3 > 0) {
                                int[] iArr3 = iArr2[i17 - 1];
                                int i39 = i3 - 1;
                                int i40 = (((iArr2[i17][i39] * 2) + iArr3[i3]) + iArr3[i39]) / 4;
                                if (i38 < i40) {
                                    i37 = i40;
                                }
                            }
                        }
                        iArr2[i17][i3] = i37;
                        i3++;
                        i16 = i21;
                        bArrA2 = bArr2;
                        i19 = i36;
                        i18 = 8;
                    }
                    i17++;
                    z = z2;
                    i3 = i20;
                }
                byte[] bArr3 = bArrA2;
                int i41 = i3;
                int i42 = i16;
                cnVar2 = new cn(i, i2);
                int i43 = i41;
                while (i43 < i13) {
                    int i44 = i43 << 3;
                    if (i44 > i14) {
                        i44 = i14;
                    }
                    int iMin = i43 < i42 ? 2 : Math.min(i43, i13 - 3);
                    int i45 = i41;
                    while (i45 < i12) {
                        int i46 = i45 << 3;
                        if (i46 > i15) {
                            i46 = i15;
                        }
                        int iMin2 = i45 < 2 ? 2 : Math.min(i45, i12 - 3);
                        int i47 = i43;
                        int i48 = -2;
                        int i49 = i41;
                        for (int i50 = 2; i48 <= i50; i50 = 2) {
                            int[] iArr4 = iArr2[iMin + i48];
                            i49 = iArr4[iMin2 - 2] + iArr4[iMin2 - 1] + iArr4[iMin2] + iArr4[iMin2 + 1] + iArr4[iMin2 + 2] + i49;
                            i48++;
                        }
                        int i51 = i49 / 25;
                        int i52 = (i44 * i) + i46;
                        int i53 = i44;
                        int i54 = i41;
                        while (true) {
                            if (i54 < 8) {
                                int i55 = i45;
                                int i56 = i41;
                                for (int i57 = 8; i56 < i57; i57 = 8) {
                                    int i58 = i56;
                                    if ((bArr3[i52 + i56] & 255) <= i51) {
                                        cnVar2.f(i46 + i58, i53 + i54);
                                    }
                                    i56 = i58 + 1;
                                }
                                i54++;
                                i52 += i;
                                i45 = i55;
                            }
                        }
                        i45++;
                        i44 = i53;
                        i43 = i47;
                    }
                    i42 = 2;
                    i43++;
                }
                iv1Var.X = cnVar2;
            }
        }
        this.z = cnVar2;
        return cnVar2;
    }

    public bn v(bn bnVar, int i) throws qs2 {
        iv1 iv1Var = (iv1) this.f;
        int[] iArr = (int[]) iv1Var.A;
        kf2 kf2Var = (kf2) iv1Var.f;
        int i2 = kf2Var.a;
        if (bnVar.f < i2) {
            bnVar = new bn(i2);
        } else {
            int length = bnVar.b.length;
            for (int i3 = 0; i3 < length; i3++) {
                bnVar.b[i3] = 0;
            }
        }
        if (((byte[]) iv1Var.z).length < i2) {
            iv1Var.z = new byte[i2];
        }
        for (int i4 = 0; i4 < 32; i4++) {
            iArr[i4] = 0;
        }
        byte[] bArrB = kf2Var.b(i, (byte[]) iv1Var.z);
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = (bArrB[i5] & 255) >> 3;
            iArr[i6] = iArr[i6] + 1;
        }
        int iK = iv1.k(iArr);
        if (i2 < 3) {
            for (int i7 = 0; i7 < i2; i7++) {
                if ((bArrB[i7] & 255) < iK) {
                    bnVar.j(i7);
                }
            }
        } else {
            int i8 = bArrB[0] & 255;
            int i9 = bArrB[1] & 255;
            int i10 = 1;
            while (i10 < i2 - 1) {
                int i11 = i10 + 1;
                int i12 = bArrB[i11] & 255;
                if ((((i9 * 4) - i8) - i12) / 2 < iK) {
                    bnVar.j(i10);
                }
                i8 = i9;
                i10 = i11;
                i9 = i12;
            }
        }
        return bnVar;
    }

    public CameraCharacteristics w(String str) throws xx {
        try {
            return ((CameraManager) this.f).getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw new xx(e);
        }
    }

    public Set x() {
        return Collections.EMPTY_SET;
    }

    public KeyListener y(KeyListener keyListener) {
        if ((keyListener instanceof NumberKeyListener) || (keyListener instanceof s31)) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new s31(keyListener);
    }

    public as2 z(int i) {
        hf hfVar = (hf) this.f;
        return hfVar == null ? as2.a(0, 5L) : (as2) hfVar.b.get(i);
    }

    public /* synthetic */ lb(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    public /* synthetic */ lb(int i, Object obj, boolean z) {
        this.b = i;
        this.z = obj;
    }

    public /* synthetic */ lb(int i, boolean z) {
        this.b = i;
    }

    public /* synthetic */ lb(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    public lb(String str, List list) {
        this.b = 16;
        str.getClass();
        this.f = str;
        this.z = list;
    }

    public lb(ly2 ly2Var) {
        this.b = 26;
        this.f = new AtomicInteger(0);
        this.z = new AtomicBoolean(false);
    }

    public lb(CameraCaptureSession cameraCaptureSession, oy oyVar) {
        this.b = 21;
        cameraCaptureSession.getClass();
        this.f = cameraCaptureSession;
        this.z = oyVar;
    }

    public lb(d00 d00Var) {
        this.b = 24;
        this.f = d00Var;
        on2 on2Var = new on2();
        this.z = on2Var;
        on2Var.i(new lg(5, null));
    }

    public lb(CameraDevice cameraDevice, cz czVar) {
        this.b = 22;
        cameraDevice.getClass();
        this.f = cameraDevice;
        this.z = czVar;
    }

    public lb(Context context, tz tzVar) {
        this.b = 23;
        this.f = (CameraManager) context.getSystemService("camera");
        this.z = tzVar;
    }

    public lb(EditText editText) {
        this.b = 8;
        this.f = editText;
        this.z = new w7(editText);
    }

    public lb(CoordinatorLayout coordinatorLayout, FragmentContainerView fragmentContainerView, NestedScrollView nestedScrollView, Toolbar toolbar) {
        this.b = 3;
        this.f = coordinatorLayout;
        this.z = nestedScrollView;
    }

    public lb(ew ewVar, ho3 ho3Var) {
        this.b = 13;
        ho3Var.getClass();
        this.z = ewVar;
        this.f = ho3Var;
    }

    public lb(v62 v62Var) {
        this.b = 14;
        qt qtVar = new qt((byte) 0, 0);
        this.f = v62Var;
        this.z = qtVar;
    }

    public lb(ex exVar) {
        this.b = 20;
        this.z = exVar;
        this.f = null;
    }

    public lb(za zaVar, iv1 iv1Var) {
        this.b = 7;
        this.z = zaVar;
        this.f = iv1Var;
    }
}
