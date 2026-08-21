package defpackage;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import j$.util.Objects;
import j$.util.Optional;
import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class w7 implements qv1, fl2, od0, kc, mu2, om1, s40, x44, f91 {
    public final /* synthetic */ int b;
    public Object f;
    public static final int[] z = {R.attr.colorError, R.attr.colorOnError, R.attr.colorErrorContainer, R.attr.colorOnErrorContainer};
    public static final d84 A = new d84(26);

    public w7(int i) {
        this.b = i;
        switch (i) {
            case 2:
                od5 od5Var = od5.c;
                jf4 jf4Var = new jf4(8, new cd5[]{k01.A0, A});
                Charset charset = nc5.a;
                this.f = jf4Var;
                break;
            case 10:
                this.f = new AtomicReference(null);
                break;
            case 14:
                break;
            case 20:
                this.f = n24.a(yk4.b);
                break;
            case 21:
                this.f = new ha1(21, ho1.o);
                break;
            case 22:
                this.f = tj4.s(Looper.getMainLooper());
                break;
            case 25:
                this.f = (SmallDisplaySizeQuirk) xt0.a.z(SmallDisplaySizeQuirk.class);
                break;
            default:
                this.f = new ConcurrentHashMap();
                break;
        }
    }

    public static e24 p(List list, HashSet hashSet) {
        int size = list.size();
        HashSet hashSet2 = new HashSet(size);
        ArrayList arrayList = new ArrayList(size);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hs2 hs2Var = (hs2) it.next();
            ds2 ds2Var = hs2Var.a;
            if (ds2Var instanceof pp3) {
                String str = ((pp3) ds2Var).e;
                if (!hashSet.contains(str)) {
                    arrayList.add(hs2Var);
                    hashSet2.add(str);
                }
            } else {
                arrayList.add(hs2Var);
            }
        }
        return new e24(11, arrayList, hashSet2, false);
    }

    public static String t(String str) {
        int length = str.length();
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            int i = iLastIndexOf + 1;
            if (length - i <= 23) {
                return str.substring(i);
            }
        }
        return WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD.concat(str.substring(length - 22));
    }

    @Override // defpackage.f91
    public ViewGroup.LayoutParams I() {
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this.f;
        return new ViewGroup.LayoutParams(extendedFloatingActionButton.getCollapsedSize(), extendedFloatingActionButton.getCollapsedSize());
    }

    @Override // defpackage.f91
    public int U() {
        return ((ExtendedFloatingActionButton) this.f).getCollapsedPadding();
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        switch (this.b) {
            case 11:
                sl slVar = (sl) this.f;
                slVar.m = bv4Var.a();
                slVar.n = bv4Var.b();
                slVar.o = bv4Var.c();
                slVar.f();
                break;
            default:
                yu4 yu4Var = bv4Var.a;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f;
                if (!Objects.equals(coordinatorLayout.H0, bv4Var)) {
                    coordinatorLayout.H0 = bv4Var;
                    boolean z2 = bv4Var.d() > 0;
                    coordinatorLayout.I0 = z2;
                    coordinatorLayout.setWillNotDraw(!z2 && coordinatorLayout.getBackground() == null);
                    if (!yu4Var.r()) {
                        int childCount = coordinatorLayout.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = coordinatorLayout.getChildAt(i);
                            WeakHashMap weakHashMap = wp4.a;
                            if (!childAt.getFitsSystemWindows() || ((te0) childAt.getLayoutParams()).a == null || !yu4Var.r()) {
                            }
                        }
                    }
                    coordinatorLayout.requestLayout();
                }
                break;
        }
        return bv4Var;
    }

    @Override // defpackage.fl2
    public void a(nk2 nk2Var, boolean z2) {
        if (nk2Var instanceof b54) {
            ((b54) nk2Var).A.m().c(false);
        }
        fl2 fl2Var = ((q3) this.f).X;
        if (fl2Var != null) {
            fl2Var.a(nk2Var, z2);
        }
    }

    @Override // defpackage.qv1
    public we2 b(String str) {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f;
        if (str == null) {
            str = "null";
        } else {
            int length = str.length();
            if (length > 23) {
                StringBuilder sb = new StringBuilder(26);
                int i = 0;
                int length2 = 0;
                while (true) {
                    int iIndexOf = str.indexOf(46, i);
                    if (iIndexOf != -1) {
                        sb.append(str.charAt(i));
                        if (iIndexOf - i > 1) {
                            sb.append('*');
                        }
                        sb.append('.');
                        i = iIndexOf + 1;
                        length2 = sb.length();
                        if (length2 > 23) {
                            str = t(str);
                            break;
                        }
                    } else {
                        int i2 = length - i;
                        if (length2 == 0 || length2 + i2 > 23) {
                            str = t(str);
                        } else {
                            sb.append((CharSequence) str, i, length);
                            str = sb.toString();
                        }
                    }
                }
            }
        }
        we2 we2Var = (we2) concurrentHashMap.get(str);
        if (we2Var != null) {
            return we2Var;
        }
        v7 v7Var = new v7();
        v7Var.b = str;
        we2 we2Var2 = (we2) concurrentHashMap.putIfAbsent(str, v7Var);
        return we2Var2 == null ? v7Var : we2Var2;
    }

    @Override // defpackage.f91
    public int c() {
        return ((ExtendedFloatingActionButton) this.f).getCollapsedSize();
    }

    @Override // defpackage.x44
    public void d(tj2 tj2Var, Bitmap bitmap, Map map) {
        ((t6) this.f).p(tj2Var, bitmap, map, v02.g(bitmap));
    }

    @Override // defpackage.f91
    public int f() {
        return ((ExtendedFloatingActionButton) this.f).getCollapsedSize();
    }

    @Override // defpackage.x44
    public uj2 h(tj2 tj2Var) {
        return null;
    }

    @Override // defpackage.f91
    public int i() {
        return ((ExtendedFloatingActionButton) this.f).getCollapsedPadding();
    }

    @Override // defpackage.fl2
    public boolean i0(nk2 nk2Var) {
        q3 q3Var = (q3) this.f;
        if (nk2Var == q3Var.z) {
            return false;
        }
        q3Var.P0 = ((b54) nk2Var).B.a;
        fl2 fl2Var = q3Var.X;
        if (fl2Var != null) {
            return fl2Var.i0(nk2Var);
        }
        return false;
    }

    public dh2 l(ds2 ds2Var) {
        u90 u90Var = (u90) this.f;
        if (ds2Var instanceof dh2) {
            return (dh2) ds2Var;
        }
        Optional optional = ds2Var.d;
        if (optional.isPresent()) {
            ds2 ds2Var2 = (ds2) u90Var.z.get(optional.get());
            if (ds2Var2 instanceof dh2) {
                return (dh2) ds2Var2;
            }
        }
        throw new v90(0, "Expected mapping node or an anchor referencing mapping", u90Var.b.e().a);
    }

    @Override // defpackage.om1
    public void m(Object obj) {
    }

    public float n(re1 re1Var, re1 re1Var2) {
        int i = (int) re1Var.a;
        int i2 = (int) re1Var.b;
        int i3 = (int) re1Var2.a;
        int i4 = (int) re1Var2.b;
        float fW = w(i, i2, i3, i4);
        float fW2 = w((int) re1Var2.a, i4, (int) re1Var.a, i2);
        return Float.isNaN(fW) ? fW2 / 7.0f : Float.isNaN(fW2) ? fW / 7.0f : (fW + fW2) / 14.0f;
    }

    public int o(int i, int i2, int i3, int i4, byte[] bArr) throws d40 {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[i5 / i6];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & 255;
            }
        }
        try {
            int iW = ((ha1) this.f).w(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
            return iW;
        } catch (wg3 unused) {
            throw d40.a();
        }
    }

    @Override // defpackage.om1
    public void q(Throwable th) {
        synchronized (((o10) this.f).a) {
            try {
                ((o10) this.f).d.t();
                int iG = fw.G(((o10) this.f).j);
                if ((iG == 4 || iG == 5 || iG == 6) && !(th instanceof CancellationException)) {
                    ez4.b0("CaptureSession", "Opening session with fail ".concat(fw.J(((o10) this.f).j)), th);
                    ((o10) this.f).e();
                }
            } finally {
            }
        }
    }

    public y6 r(float f, float f2, int i, int i2) throws qs2 {
        y6 y6VarB;
        y6 y6VarB2;
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        cn cnVar = (cn) this.f;
        int iMin = Math.min(cnVar.b - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw qs2.a();
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(cnVar.f - 1, i2 + i3) - iMax2;
        if (iMin2 < f3) {
            throw qs2.a();
        }
        cn cnVar2 = (cn) this.f;
        z6 z6Var = new z6(cnVar2, iMax, iMax2, iMin, iMin2, f);
        int i4 = z6Var.e;
        int i5 = z6Var.c;
        int i6 = i4 + i5;
        int i7 = z6Var.f;
        int i8 = (i7 / 2) + z6Var.d;
        int[] iArr = new int[3];
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = ((i9 & 1) == 0 ? (i9 + 1) / 2 : -((i9 + 1) / 2)) + i8;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i11 = i5;
            while (i11 < i6 && !cnVar2.b(i11, i10)) {
                i11++;
            }
            int i12 = 0;
            while (i11 < i6) {
                if (!cnVar2.b(i11, i10)) {
                    if (i12 == 1) {
                        i12++;
                    }
                    iArr[i12] = iArr[i12] + 1;
                } else if (i12 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i12 != 2) {
                    i12++;
                    iArr[i12] = iArr[i12] + 1;
                } else {
                    if (z6Var.a(iArr) && (y6VarB2 = z6Var.b(i10, i11, iArr)) != null) {
                        return y6VarB2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i12 = 1;
                }
                i11++;
            }
            if (z6Var.a(iArr) && (y6VarB = z6Var.b(i10, i6, iArr)) != null) {
                return y6VarB;
            }
        }
        ArrayList arrayList = z6Var.b;
        if (arrayList.isEmpty()) {
            throw qs2.a();
        }
        return (y6) arrayList.get(0);
    }

    public j24 s() {
        return (j24) ((m24) this.f).i();
    }

    public void u(aj3 aj3Var, ue1 ue1Var, tm1 tm1Var) {
        synchronized (aj3Var.A) {
            aj3Var.z0 = true;
        }
        aj3Var.a("post-response");
        ((nf) this.f).execute(new g33(aj3Var, ue1Var, tm1Var, 2, false));
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0083, code lost:
    
        if (r15 != r0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0089, code lost:
    
        return defpackage.gb4.G(r5, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008a, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float v(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        w7 w7Var;
        int i11;
        int i12 = 1;
        boolean z2 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z2) {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        int iAbs = Math.abs(i7 - i5);
        int iAbs2 = Math.abs(i8 - i6);
        int i13 = 2;
        int i14 = (-iAbs) / 2;
        int i15 = i5 < i7 ? 1 : -1;
        int i16 = i6 < i8 ? 1 : -1;
        int i17 = i7 + i15;
        int i18 = i5;
        int i19 = i6;
        int i20 = 0;
        while (true) {
            if (i18 == i17) {
                i9 = i13;
                break;
            }
            int i21 = z2 ? i19 : i18;
            int i22 = z2 ? i18 : i19;
            boolean z3 = z2;
            if (i20 == i12) {
                i10 = i12;
                i11 = iAbs;
                w7Var = this;
            } else {
                i10 = 0;
                w7Var = this;
                i11 = iAbs;
            }
            if (i10 == ((cn) w7Var.f).b(i21, i22)) {
                if (i20 == 2) {
                    return gb4.G(i18, i19, i5, i6);
                }
                i20++;
            }
            i14 += iAbs2;
            if (i14 > 0) {
                if (i19 == i8) {
                    i9 = 2;
                    break;
                }
                i19 += i16;
                i14 -= i11;
            }
            i18 += i15;
            iAbs = i11;
            z2 = z3;
            i12 = 1;
            i13 = 2;
        }
    }

    public float w(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        cn cnVar = (cn) this.f;
        float fV = v(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = i / (i - i5);
            i5 = 0;
        } else {
            int i7 = cnVar.b;
            if (i5 >= i7) {
                float f3 = ((i7 - 1) - i) / (i5 - i);
                int i8 = i7 - 1;
                f = f3;
                i5 = i8;
            } else {
                f = 1.0f;
            }
        }
        float f4 = i2;
        int i9 = (int) (f4 - ((i4 - i2) * f));
        if (i9 < 0) {
            f2 = f4 / (i2 - i9);
        } else {
            int i10 = cnVar.f;
            if (i9 >= i10) {
                f2 = ((i10 - 1) - i2) / (i9 - i2);
                i6 = i10 - 1;
            } else {
                i6 = i9;
                f2 = 1.0f;
            }
        }
        return (v(i, i2, (int) (((i5 - i) * f2) + i), i6) + fV) - 1.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(j24 j24Var) {
        Object objI;
        j24 j24Var2;
        j24Var.getClass();
        m24 m24Var = (m24) this.f;
        do {
            objI = m24Var.i();
            j24Var2 = (j24) objI;
            if (!(j24Var2 instanceof wd3 ? true : n12.c(j24Var2, yk4.b))) {
                if (j24Var2 instanceof fi0) {
                    if (j24Var.a > j24Var2.a) {
                        j24Var2 = j24Var;
                    }
                } else if (!(j24Var2 instanceof qe1)) {
                    g.d();
                    return;
                }
            }
        } while (!m24Var.g(objI, j24Var2));
    }

    public void e(int i) {
    }

    public void g(int i) {
    }

    @Override // defpackage.x44
    public void j(int i) {
    }

    public void k(int i, float f) {
    }

    public w7(kz4 kz4Var, wl3 wl3Var) {
        this.b = 6;
        this.f = kz4Var;
    }

    public w7(RelativeLayout relativeLayout, TextInputLayout textInputLayout) {
        this.b = 24;
        this.f = textInputLayout;
    }

    public w7(Handler handler) {
        this.b = 28;
        this.f = new nf(handler);
    }

    public /* synthetic */ w7(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    public w7(int[] iArr) {
        this.b = 1;
        if (iArr.length != 0) {
            this.f = iArr;
        } else {
            xe.k("Theme overlay should be used with the accompanying int[] attributes.");
            throw null;
        }
    }

    public w7(EditText editText) {
        this.b = 26;
        this.f = new eg0(editText);
    }
}
