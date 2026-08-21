package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Bundle;
import android.os.Looper;
import android.os.Trace;
import android.text.Editable;
import android.text.Selection;
import android.util.Size;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.R;
import com.getsurfboard.ui.widget.NestedScrollWebView;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import io.github.rosemoe.sora.langs.textmate.registry.model.ThemeModel;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.util.internal.StringUtil;
import j$.util.Objects;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ed4 implements wy3, f91, pn1, wv {
    public static ed4 X;
    public static volatile ed4 Y;
    public static final Object Z = new Object();
    public Object A;
    public final /* synthetic */ int b;
    public Object f;
    public Object z;

    /* JADX WARN: Multi-variable type inference failed */
    public ed4(yx1 yx1Var, Size size, CameraCharacteristics cameraCharacteristics, boolean z) {
        int iIntValue;
        int i;
        oy1 ha1Var;
        g10 g10Var;
        wl2 wl2Var;
        int i2;
        char c;
        wl2 wl2Var2;
        this.b = 29;
        co4.h();
        this.f = yx1Var;
        jx jxVar = (jx) yx1Var.p(mn4.d0, null);
        if (jxVar == null) {
            zo2.v(dw2.f(yx1Var, yx1Var.toString()), "Implementation is missing option unpacker for ");
            throw null;
        }
        e10 e10Var = new e10();
        jxVar.a(yx1Var, e10Var);
        e10Var.e();
        char c2 = 0;
        ed4 ed4Var = new ed4(c2, 9);
        this.z = ed4Var;
        Executor executor = (Executor) ((sw2) yx1Var.m()).p(c22.H, d22.a());
        Objects.requireNonNull(executor);
        fa5 fa5Var = new fa5(executor, cameraCharacteristics);
        ArrayList arrayList = new ArrayList();
        if (((Integer) dw2.n(yx1Var, dy1.t, 0)).intValue() != 0) {
            arrayList.add(32);
            arrayList.add(256);
        } else {
            Integer num = (Integer) ((sw2) yx1Var.m()).p(yx1.A, null);
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                Integer num2 = (Integer) ((sw2) yx1Var.m()).p(dy1.s, null);
                iIntValue = (num2 == null || num2.intValue() != 4101) ? (num2 == null || num2.intValue() != 32) ? 256 : 32 : 4101;
            }
            arrayList.add(Integer.valueOf(iIntValue));
        }
        int iN = yx1Var.n();
        if (((sw2) yx1Var.m()).p(yx1.Y, null) != null) {
            st4.n();
            throw null;
        }
        i01 i01Var = new i01();
        i01 i01Var2 = new i01();
        og ogVar = new og(size, iN, arrayList, z, i01Var, i01Var2);
        this.A = ogVar;
        r25.j("CaptureNode does not support recreation yet.", ((og) ed4Var.A) == null && ((e10) ed4Var.f) == null);
        ed4Var.A = ogVar;
        i10 i10Var = new i10();
        boolean z2 = arrayList.size() > 1;
        int i3 = 2;
        if (z) {
            i = 1;
            ha1Var = new ha1(15, yr2.p(size.getWidth(), size.getHeight(), iN, 4));
            g10Var = new g10(ed4Var, i);
            wl2Var = null;
        } else {
            if (z2) {
                i2 = 1;
                c = 0;
                wl2 wl2Var3 = new wl2(size.getWidth(), size.getHeight(), 256, 4);
                tj4.t(i10Var, wl2Var3.f);
                wl2Var = new wl2(size.getWidth(), size.getHeight(), 32, 4);
                tj4.t(i10Var, wl2Var.f);
                wl2Var2 = wl2Var3;
            } else {
                i2 = 1;
                c = 0;
                wl2 wl2Var4 = new wl2(size.getWidth(), size.getHeight(), iN, 4);
                tj4.t(i10Var, wl2Var4.f);
                wl2Var2 = wl2Var4;
                wl2Var = null;
            }
            c2 = c;
            g10Var = new g10(ed4Var, c2);
            i = i2;
            ha1Var = wl2Var2;
        }
        Surface surface = ha1Var.getSurface();
        Objects.requireNonNull(surface);
        r25.j("The surface is already set.", ogVar.a == null ? i : c2);
        ogVar.a = new az1(surface, size, iN);
        ed4Var.f = new e10(ha1Var);
        ha1Var.p(new xe(ed4Var), vf2.q());
        if (z2 && wl2Var != null) {
            Surface surface2 = wl2Var.getSurface();
            r25.j("The secondary surface is already set.", ogVar.b == null ? i : 0);
            ogVar.b = new az1(surface2, size, iN);
            ed4Var.z = new e10(wl2Var);
            wl2Var.p(new xe(ed4Var), vf2.q());
        }
        i01Var.b = g10Var;
        i01Var2.b = new g10(ed4Var, i3);
    }

    public static synchronized ed4 B() {
        ed4 ed4Var;
        ed4Var = X;
        if (ed4Var == null) {
            ed4Var = new ed4((byte) 0, 0);
            X = ed4Var;
        }
        return ed4Var;
    }

    public static ed4 C(Context context) {
        if (Y == null) {
            synchronized (Z) {
                try {
                    if (Y == null) {
                        Y = new ed4(context);
                    }
                } finally {
                }
            }
        }
        return Y;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[EDGE_INSN: B:92:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085], EDGE_INSN: B:93:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085, LOOP_LABEL: LOOP:2: B:47:0x006e->B:58:0x0085]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean D(p31 p31Var, Editable editable, int i, int i2, boolean z) {
        int iMin;
        if (editable != null && i >= 0 && i2 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd) {
                if (z) {
                    int iMax = Math.max(i, 0);
                    int length = editable.length();
                    if (selectionStart < 0 || length < selectionStart || iMax < 0) {
                        selectionStart = -1;
                        int iMax2 = Math.max(i2, 0);
                        iMin = editable.length();
                        if (selectionEnd >= 0 || iMin < selectionEnd || iMax2 < 0) {
                            iMin = -1;
                            if (selectionStart != -1 && iMin != -1) {
                            }
                        } else {
                            loop2: while (true) {
                                boolean z2 = false;
                                while (true) {
                                    if (iMax2 == 0) {
                                        iMin = selectionEnd;
                                        break loop2;
                                    }
                                    if (selectionEnd >= iMin) {
                                        if (z2) {
                                            break;
                                        }
                                    } else {
                                        char cCharAt = editable.charAt(selectionEnd);
                                        if (z2) {
                                            break;
                                        }
                                        if (!Character.isSurrogate(cCharAt)) {
                                            iMax2--;
                                            selectionEnd++;
                                        } else {
                                            if (Character.isLowSurrogate(cCharAt)) {
                                                break loop2;
                                            }
                                            selectionEnd++;
                                            z2 = true;
                                        }
                                    }
                                }
                                iMax2--;
                                selectionEnd++;
                            }
                            iMin = -1;
                            if (selectionStart != -1) {
                            }
                        }
                    } else {
                        loop0: while (true) {
                            boolean z3 = false;
                            while (true) {
                                if (iMax == 0) {
                                    break loop0;
                                }
                                selectionStart--;
                                if (selectionStart >= 0) {
                                    char cCharAt2 = editable.charAt(selectionStart);
                                    if (z3) {
                                        break;
                                    }
                                    if (!Character.isSurrogate(cCharAt2)) {
                                        iMax--;
                                    } else {
                                        if (Character.isHighSurrogate(cCharAt2)) {
                                            break loop0;
                                        }
                                        z3 = true;
                                    }
                                } else {
                                    if (z3) {
                                        break loop0;
                                    }
                                    selectionStart = 0;
                                }
                            }
                            iMax--;
                        }
                        selectionStart = -1;
                        int iMax22 = Math.max(i2, 0);
                        iMin = editable.length();
                        if (selectionEnd >= 0) {
                            iMin = -1;
                            if (selectionStart != -1) {
                            }
                        }
                    }
                } else {
                    selectionStart = Math.max(selectionStart - i, 0);
                    iMin = Math.min(selectionEnd + i2, editable.length());
                }
                lk4[] lk4VarArr = (lk4[]) editable.getSpans(selectionStart, iMin, lk4.class);
                if (lk4VarArr != null && lk4VarArr.length > 0) {
                    for (lk4 lk4Var : lk4VarArr) {
                        int spanStart = editable.getSpanStart(lk4Var);
                        int spanEnd = editable.getSpanEnd(lk4Var);
                        selectionStart = Math.min(spanStart, selectionStart);
                        iMin = Math.max(spanEnd, iMin);
                    }
                    int iMax3 = Math.max(selectionStart, 0);
                    int iMin2 = Math.min(iMin, editable.length());
                    p31Var.beginBatchEdit();
                    editable.delete(iMax3, iMin2);
                    p31Var.endBatchEdit();
                    return true;
                }
            }
        }
        return false;
    }

    public static ed4 F(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_webdav_operation, (ViewGroup) null, false);
        int i = R.id.checkbox;
        MaterialCheckBox materialCheckBox = (MaterialCheckBox) vf2.l(viewInflate, R.id.checkbox);
        if (materialCheckBox != null) {
            i = R.id.last_time;
            MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.last_time);
            if (materialTextView != null) {
                return new ed4(14, (ConstraintLayout) viewInflate, materialCheckBox, materialTextView);
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    public static ed4 G(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_url_dialog, viewGroup, false);
        int i = R.id.drag_handle;
        if (((BottomSheetDragHandleView) vf2.l(viewInflate, R.id.drag_handle)) != null) {
            i = R.id.loading;
            LoadingIndicator loadingIndicator = (LoadingIndicator) vf2.l(viewInflate, R.id.loading);
            if (loadingIndicator != null) {
                i = R.id.webView;
                NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) vf2.l(viewInflate, R.id.webView);
                if (nestedScrollWebView != null) {
                    return new ed4(22, (RelativeLayout) viewInflate, loadingIndicator, nestedScrollWebView);
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void N(wy4 wy4Var, OutputStream outputStream) {
        int iG;
        if (outputStream instanceof lx2) {
            lx2 lx2Var = (lx2) outputStream;
            wy4Var.z.h = lx2Var.n();
            iG = lx2Var.g();
        } else {
            iG = 0;
        }
        if (wy4Var.z0) {
            ky4 ky4Var = wy4Var.X;
            jy4 jy4Var = wy4Var.A;
            if (jy4Var == null) {
                jy4Var = new jy4();
                wy4Var.A = jy4Var;
            }
            ky4Var.l = wy4Var.z.h;
            jy4Var.d = iG;
            jy4Var.f = iG + 1;
        }
        z41 z41Var = wy4Var.z;
        z41Var.d = iG;
        z41Var.e = iG;
    }

    public static void O(o0 o0Var, n02 n02Var) throws qy4 {
        List list = o0Var.t;
        if (list == null || list.size() <= 0) {
            return;
        }
        List list2 = o0Var.t;
        n nVar = null;
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                pa1 pa1Var = (pa1) it.next();
                if (pa1Var != null && pa1Var.d == 39169) {
                    byte[] bArr = pa1Var.f;
                    if (bArr == null || bArr.length != 7) {
                        st4.j("corrupt AES extra data records");
                        return;
                    }
                    nVar = new n();
                    nVar.a = 12;
                    nVar.d = pa1Var.e;
                    int i = 0;
                    int iJ = n02.J(0, bArr);
                    for (int i2 : fw.L(2)) {
                        if (fw.o(i2) == iJ) {
                            nVar.e = i2;
                            byte[] bArr2 = new byte[2];
                            System.arraycopy(bArr, 2, bArr2, 0, 2);
                            nVar.f = new String(bArr2);
                            int i3 = bArr[4] & 255;
                            int[] iArrL = fw.L(3);
                            int length = iArrL.length;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= length) {
                                    break;
                                }
                                int i5 = iArrL[i4];
                                if (fw.l(i5) == i3) {
                                    i = i5;
                                    break;
                                }
                                i4++;
                            }
                            nVar.g = i;
                            nVar.h = fw.c(n02.J(5, bArr));
                        }
                    }
                    st4.j("Unsupported Aes version");
                    return;
                }
            }
        }
        if (nVar != null) {
            o0Var.r = nVar;
            o0Var.o = 4;
        }
    }

    public static ly4 T(List list, n02 n02Var, long j, long j2, long j3, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            pa1 pa1Var = (pa1) it.next();
            if (pa1Var != null && 1 == pa1Var.d) {
                ly4 ly4Var = new ly4();
                ly4Var.d = -1L;
                ly4Var.e = -1L;
                ly4Var.f = -1L;
                ly4Var.g = -1;
                byte[] bArr = pa1Var.f;
                int i2 = pa1Var.e;
                if (i2 <= 0) {
                    return null;
                }
                int i3 = 0;
                if (i2 > 0 && j == 4294967295L) {
                    ly4Var.e = n02Var.I(0, bArr);
                    i3 = 8;
                }
                if (i3 < pa1Var.e && j2 == 4294967295L) {
                    ly4Var.d = n02Var.I(i3, bArr);
                    i3 += 8;
                }
                if (i3 < pa1Var.e && j3 == 4294967295L) {
                    ly4Var.f = n02Var.I(i3, bArr);
                    i3 += 8;
                }
                if (i3 < pa1Var.e && i == 65535) {
                    ly4Var.g = n02.G(i3, bArr);
                }
                return ly4Var;
            }
        }
        return null;
    }

    public static void W(RandomAccessFile randomAccessFile, long j) throws IOException {
        if (randomAccessFile instanceof kt2) {
            ((kt2) randomAccessFile).z.seek(j);
        } else {
            randomAccessFile.seek(j);
        }
    }

    public static void c0(wy4 wy4Var, int i, long j, ByteArrayOutputStream byteArrayOutputStream, n02 n02Var) throws IOException {
        byte[] bArr = new byte[8];
        n02Var.S(byteArrayOutputStream, 101010256);
        n02Var.V(byteArrayOutputStream, wy4Var.z.d);
        n02Var.V(byteArrayOutputStream, wy4Var.z.e);
        long size = wy4Var.f.a.size();
        long jR = wy4Var.Y ? r(wy4Var.f.a, wy4Var.z.d) : size;
        if (jR > 65535) {
            jR = 65535;
        }
        n02Var.V(byteArrayOutputStream, (int) jR);
        if (size > 65535) {
            size = 65535;
        }
        n02Var.V(byteArrayOutputStream, (int) size);
        n02Var.S(byteArrayOutputStream, i);
        if (j > 4294967295L) {
            n02.U(bArr, 4294967295L);
            byteArrayOutputStream.write(bArr, 0, 4);
        } else {
            n02.U(bArr, j);
            byteArrayOutputStream.write(bArr, 0, 4);
        }
        String str = wy4Var.z.j;
        if (!yr2.N(str)) {
            n02Var.V(byteArrayOutputStream, 0);
            return;
        }
        byte[] bArrO = p95.o(str, null);
        n02Var.V(byteArrayOutputStream, bArrO.length);
        byteArrayOutputStream.write(bArrO);
    }

    public static void e0(ky4 ky4Var, ByteArrayOutputStream byteArrayOutputStream, n02 n02Var) {
        n02Var.S(byteArrayOutputStream, (int) ha0.g(ky4Var.a));
        n02Var.T(byteArrayOutputStream, ky4Var.d);
        n02Var.V(byteArrayOutputStream, ky4Var.e);
        n02Var.V(byteArrayOutputStream, ky4Var.f);
        n02Var.S(byteArrayOutputStream, ky4Var.g);
        n02Var.S(byteArrayOutputStream, ky4Var.h);
        n02Var.T(byteArrayOutputStream, ky4Var.i);
        n02Var.T(byteArrayOutputStream, ky4Var.j);
        n02Var.T(byteArrayOutputStream, ky4Var.k);
        n02Var.T(byteArrayOutputStream, ky4Var.l);
    }

    public static ky4 l(wy4 wy4Var, int i, long j) {
        ky4 ky4Var = new ky4();
        ky4Var.a = 10;
        ky4Var.d = 44L;
        if (wy4Var.f.a.size() > 0) {
            rd1 rd1Var = (rd1) wy4Var.f.a.get(0);
            ky4Var.e = rd1Var.u;
            ky4Var.f = rd1Var.d;
        }
        z41 z41Var = wy4Var.z;
        ky4Var.g = z41Var.d;
        ky4Var.h = z41Var.e;
        long size = wy4Var.f.a.size();
        ky4Var.i = wy4Var.Y ? r(wy4Var.f.a, wy4Var.z.d) : size;
        ky4Var.j = size;
        ky4Var.k = i;
        ky4Var.l = j;
        return ky4Var;
    }

    public static long r(ArrayList arrayList, int i) {
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (((rd1) it.next()).v == i) {
                i2++;
            }
        }
        return i2;
    }

    public static boolean u(Editable editable, KeyEvent keyEvent, boolean z) {
        lk4[] lk4VarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (lk4VarArr = (lk4[]) editable.getSpans(selectionStart, selectionEnd, lk4.class)) != null && lk4VarArr.length > 0) {
                for (lk4 lk4Var : lk4VarArr) {
                    int spanStart = editable.getSpanStart(lk4Var);
                    int spanEnd = editable.getSpanEnd(lk4Var);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int y(int i, int i2, bn bnVar) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bnVar.d(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public ThemeModel A(String str) {
        for (ThemeModel themeModel : (ArrayList) this.z) {
            yv1 rawTheme = themeModel.getRawTheme();
            if (rawTheme != null && str.equals((String) ((td3) rawTheme).get("name"))) {
                return themeModel;
            }
        }
        return null;
    }

    public boolean E(CharSequence charSequence, int i, int i2, kk4 kk4Var) {
        if ((kk4Var.c & 3) == 0) {
            ll0 ll0Var = (ll0) this.A;
            xl2 xl2VarB = kk4Var.b();
            int iA = xl2VarB.a(8);
            if (iA != 0) {
                ((ByteBuffer) xl2VarB.A).getShort(iA + xl2VarB.b);
            }
            ll0Var.getClass();
            ThreadLocal threadLocal = ll0.b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            boolean zHasGlyph = ll0Var.a.hasGlyph(sb.toString());
            int i3 = kk4Var.c & 4;
            kk4Var.c = zHasGlyph ? i3 | 2 : i3 | 1;
        }
        return (kk4Var.c & 3) == 2;
    }

    public boolean H(int i) {
        int i2;
        int i3 = i + 1;
        bn bnVar = (bn) this.f;
        if (i3 <= bnVar.f) {
            for (int i4 = 0; i4 < 5 && (i2 = i4 + i) < bnVar.f; i4++) {
                if (i4 == 2) {
                    if (bnVar.d(i + 2)) {
                    }
                } else if (!bnVar.d(i2)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.f91
    public ViewGroup.LayoutParams I() {
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this.A;
        int i = extendedFloatingActionButton.s1;
        if (i == 0) {
            i = -2;
        }
        int i2 = extendedFloatingActionButton.t1;
        return new ViewGroup.LayoutParams(i, i2 != 0 ? i2 : -2);
    }

    public void J(ThemeModel themeModel) {
        synchronized (this) {
            try {
                if (!themeModel.isLoaded()) {
                    themeModel.load();
                }
                ThemeModel themeModelA = A(themeModel.getName());
                if (themeModelA != null) {
                    X(themeModelA);
                } else {
                    ((ArrayList) this.z).add(themeModel);
                    X(themeModel);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean K(int i, rb0 rb0Var, jc0 jc0Var) {
        zl zlVar = (zl) this.z;
        int[] iArr = jc0Var.o0;
        int[] iArr2 = jc0Var.t;
        zlVar.a = iArr[0];
        zlVar.b = iArr[1];
        zlVar.c = jc0Var.o();
        zlVar.d = jc0Var.i();
        zlVar.i = false;
        zlVar.j = i;
        boolean z = zlVar.a == 3;
        boolean z2 = zlVar.b == 3;
        boolean z3 = z && jc0Var.V > 0.0f;
        boolean z4 = z2 && jc0Var.V > 0.0f;
        if (z3 && iArr2[0] == 4) {
            zlVar.a = 1;
        }
        if (z4 && iArr2[1] == 4) {
            zlVar.b = 1;
        }
        rb0Var.b(jc0Var, zlVar);
        jc0Var.K(zlVar.e);
        jc0Var.H(zlVar.f);
        jc0Var.E = zlVar.h;
        int i2 = zlVar.g;
        jc0Var.Z = i2;
        jc0Var.E = i2 > 0;
        zlVar.j = 0;
        return zlVar.i;
    }

    public ArrayList L(int i, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            pa1 pa1Var = new pa1();
            pa1Var.d = n02.J(i2, bArr);
            int iJ = n02.J(i2 + 2, bArr);
            pa1Var.e = iJ;
            int i3 = i2 + 4;
            if (iJ > 0) {
                byte[] bArr2 = new byte[iJ];
                System.arraycopy(bArr, i3, bArr2, 0, iJ);
                pa1Var.f = bArr2;
            }
            i2 = i3 + iJ;
            arrayList.add(pa1Var);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public Object M(CharSequence charSequence, int i, int i2, int i3, boolean z, t31 t31Var) {
        int i4;
        char c;
        u31 u31Var = new u31((zl2) ((iv1) this.z).A);
        int iCodePointAt = Character.codePointAt(charSequence, i);
        int i5 = 0;
        boolean zR = true;
        int iCharCount = i;
        loop0: while (true) {
            i4 = iCharCount;
            while (iCharCount < i2 && i5 < i3 && zR) {
                zl2 zl2Var = (zl2) u31Var.c.a.get(iCodePointAt);
                if (u31Var.a == 2) {
                    if (zl2Var != null) {
                        u31Var.c = zl2Var;
                        u31Var.f++;
                    } else {
                        if (iCodePointAt == 65038) {
                            u31Var.a();
                        } else if (iCodePointAt != 65039) {
                            zl2 zl2Var2 = u31Var.c;
                            if (zl2Var2.b != null) {
                                if (u31Var.f != 1) {
                                    u31Var.d = zl2Var2;
                                    u31Var.a();
                                } else if (u31Var.b()) {
                                    u31Var.d = u31Var.c;
                                    u31Var.a();
                                } else {
                                    u31Var.a();
                                }
                                c = 3;
                            } else {
                                u31Var.a();
                            }
                        }
                        c = 1;
                    }
                    c = 2;
                } else if (zl2Var == null) {
                    u31Var.a();
                    c = 1;
                } else {
                    u31Var.a = 2;
                    u31Var.c = zl2Var;
                    u31Var.f = 1;
                    c = 2;
                }
                u31Var.e = iCodePointAt;
                if (c == 1) {
                    iCharCount = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                    if (iCharCount < i2) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                } else if (c == 2) {
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    if (iCharCount2 < i2) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                    }
                    iCharCount = iCharCount2;
                } else if (c == 3) {
                    if (z || !E(charSequence, i4, iCharCount, u31Var.d.b)) {
                        zR = t31Var.r(charSequence, i4, iCharCount, u31Var.d.b);
                        i5++;
                    }
                }
            }
            break loop0;
        }
        if (u31Var.a == 2 && u31Var.c.b != null && ((u31Var.f > 1 || u31Var.b()) && i5 < i3 && zR && (z || !E(charSequence, i4, iCharCount, u31Var.c.b)))) {
            t31Var.r(charSequence, i4, iCharCount, u31Var.c.b);
        }
        return t31Var.n();
    }

    public wy4 P(RandomAccessFile randomAccessFile, b71 b71Var) throws IOException {
        char c;
        long j;
        byte b;
        int i;
        List listL;
        byte[] bArr;
        m20 m20Var;
        char c2;
        byte[] bArr2;
        int i2;
        rd1 rd1Var;
        int i3;
        int i4;
        byte[] bArr3;
        ArrayList arrayList;
        wy4 wy4Var;
        char c3;
        ed4 ed4Var = this;
        n02 n02Var = (n02) ed4Var.z;
        byte[] bArr4 = (byte[]) n02Var.f;
        byte[] bArr5 = (byte[]) n02Var.A;
        byte[] bArr6 = (byte[]) n02Var.z;
        if (randomAccessFile.length() == 0) {
            return new wy4();
        }
        if (randomAccessFile.length() < 22) {
            st4.j("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
            return null;
        }
        wy4 wy4Var2 = new wy4();
        ed4Var.f = wy4Var2;
        try {
            wy4Var2.z = ed4Var.Q(randomAccessFile, n02Var, b71Var);
            wy4 wy4Var3 = (wy4) ed4Var.f;
            z41 z41Var = wy4Var3.z;
            if (z41Var.g == 0) {
                return wy4Var3;
            }
            long j2 = z41Var.i;
            jy4 jy4Var = new jy4();
            W(randomAccessFile, j2 - 20);
            randomAccessFile.readFully(bArr6);
            byte b2 = 0;
            long jG = n02.G(0, bArr6);
            wy4 wy4Var4 = (wy4) ed4Var.f;
            if (jG == 117853008) {
                wy4Var4.z0 = true;
                jy4Var.a = 9;
                randomAccessFile.readFully(bArr6);
                jy4Var.d = n02.G(0, bArr6);
                randomAccessFile.readFully(bArr5);
                jy4Var.e = n02Var.I(0, bArr5);
                randomAccessFile.readFully(bArr6);
                jy4Var.f = n02.G(0, bArr6);
            } else {
                wy4Var4.z0 = false;
                jy4Var = null;
            }
            wy4Var3.A = jy4Var;
            wy4 wy4Var5 = (wy4) ed4Var.f;
            if (wy4Var5.z0) {
                jy4 jy4Var2 = wy4Var5.A;
                if (jy4Var2 == null) {
                    st4.j("invalid zip64 end of central directory locator");
                    return null;
                }
                long j3 = jy4Var2.e;
                if (j3 < 0) {
                    st4.j("invalid offset for start of end of central directory record");
                    return null;
                }
                randomAccessFile.seek(j3);
                ky4 ky4Var = new ky4();
                randomAccessFile.readFully(bArr6);
                if (n02.G(0, bArr6) != 101075792) {
                    st4.j("invalid signature for zip64 end of central directory record");
                    return null;
                }
                ky4Var.a = 10;
                randomAccessFile.readFully(bArr5);
                ky4Var.d = n02Var.I(0, bArr5);
                randomAccessFile.readFully(bArr4);
                ky4Var.e = n02.J(0, bArr4);
                randomAccessFile.readFully(bArr4);
                ky4Var.f = n02.J(0, bArr4);
                randomAccessFile.readFully(bArr6);
                ky4Var.g = n02.G(0, bArr6);
                randomAccessFile.readFully(bArr6);
                ky4Var.h = n02.G(0, bArr6);
                randomAccessFile.readFully(bArr5);
                ky4Var.i = n02Var.I(0, bArr5);
                randomAccessFile.readFully(bArr5);
                ky4Var.j = n02Var.I(0, bArr5);
                randomAccessFile.readFully(bArr5);
                ky4Var.k = n02Var.I(0, bArr5);
                randomAccessFile.readFully(bArr5);
                ky4Var.l = n02Var.I(0, bArr5);
                long j4 = ky4Var.d - 44;
                if (j4 > 0) {
                    randomAccessFile.readFully(new byte[(int) j4]);
                }
                wy4Var5.X = ky4Var;
                wy4Var5 = (wy4) ed4Var.f;
                if (wy4Var5.X.g > 0) {
                    wy4Var5.Y = true;
                } else {
                    wy4Var5.Y = false;
                }
            }
            m20 m20Var2 = new m20(0);
            ArrayList arrayList2 = new ArrayList();
            wy4 wy4Var6 = (wy4) ed4Var.f;
            boolean z = wy4Var6.z0;
            if (z) {
                c = 1;
                j = wy4Var6.X.l;
            } else {
                c = 1;
                j = wy4Var6.z.h;
            }
            long j5 = z ? wy4Var6.X.j : wy4Var6.z.g;
            randomAccessFile.seek(j);
            byte[] bArr7 = new byte[2];
            byte[] bArr8 = new byte[4];
            int i5 = 0;
            while (i5 < j5) {
                rd1 rd1Var2 = new rd1();
                randomAccessFile.readFully(bArr6);
                byte[] bArr9 = bArr7;
                if (n02.G(b2, bArr6) != 33639248) {
                    throw new qy4("Expected central directory entry not found (#" + (i5 + 1) + ")");
                }
                rd1Var2.a = 3;
                randomAccessFile.readFully(bArr4);
                rd1Var2.u = n02.J(b2, bArr4);
                randomAccessFile.readFully(bArr4);
                rd1Var2.d = n02.J(b2, bArr4);
                byte[] bArr10 = new byte[2];
                randomAccessFile.readFully(bArr10);
                rd1Var2.n = r25.F(bArr10[b2], b2);
                rd1Var2.p = r25.F(bArr10[b2], 3);
                rd1Var2.s = r25.F(bArr10[c], 3);
                rd1Var2.e = (byte[]) bArr10.clone();
                randomAccessFile.readFully(bArr4);
                rd1Var2.f = fw.c(n02.J(b2, bArr4));
                randomAccessFile.readFully(bArr6);
                rd1Var2.g = n02.G(b2, bArr6);
                byte[] bArr11 = bArr8;
                randomAccessFile.readFully(bArr11);
                int i6 = i5;
                rd1Var2.h = n02Var.I(b2, bArr11);
                Arrays.fill(bArr5, b2);
                randomAccessFile.readFully(bArr5, b2, 4);
                rd1Var2.i = n02Var.I(b2, bArr5);
                Arrays.fill(bArr5, b2);
                randomAccessFile.readFully(bArr5, b2, 4);
                rd1Var2.j = n02Var.I(b2, bArr5);
                randomAccessFile.readFully(bArr4);
                int iJ = n02.J(b2, bArr4);
                rd1Var2.k = iJ;
                randomAccessFile.readFully(bArr4);
                rd1Var2.l = n02.J(b2, bArr4);
                randomAccessFile.readFully(bArr4);
                int iJ2 = n02.J(b2, bArr4);
                randomAccessFile.readFully(bArr4);
                rd1Var2.v = n02.J(b2, bArr4);
                randomAccessFile.readFully(bArr9);
                randomAccessFile.readFully(bArr11);
                rd1Var2.w = (byte[]) bArr11.clone();
                randomAccessFile.readFully(bArr11);
                m20 m20Var3 = m20Var2;
                ArrayList arrayList3 = arrayList2;
                rd1Var2.x = n02Var.I(0, bArr11);
                if (iJ <= 0) {
                    st4.j("Invalid entry name in file header");
                    return null;
                }
                byte[] bArr12 = new byte[iJ];
                randomAccessFile.readFully(bArr12);
                String strJ = p95.j(bArr12, rd1Var2.s, null);
                rd1Var2.m = strJ;
                byte[] bArr13 = rd1Var2.w;
                byte b3 = bArr13[0];
                if ((b3 == 0 || !r25.F(b3, 4)) && (((b = bArr13[3]) == 0 || !r25.F(b, 6)) && !strJ.endsWith("/"))) {
                    strJ.endsWith("\\");
                }
                int i7 = rd1Var2.l;
                if (i7 <= 0) {
                    i = 4;
                } else {
                    i = 4;
                    if (i7 < 4) {
                        if (i7 > 0) {
                            randomAccessFile.skipBytes(i7);
                        }
                        listL = null;
                    } else {
                        byte[] bArr14 = new byte[i7];
                        randomAccessFile.read(bArr14);
                        try {
                            listL = ed4Var.L(i7, bArr14);
                        } catch (Exception unused) {
                            listL = Collections.EMPTY_LIST;
                        }
                    }
                    rd1Var2.t = listL;
                }
                List list = rd1Var2.t;
                if (list == null || list.size() <= 0) {
                    bArr = bArr9;
                    m20Var = m20Var3;
                    c2 = c;
                    bArr2 = bArr4;
                    bArr8 = bArr11;
                    i2 = i6;
                    rd1Var = rd1Var2;
                    i3 = i;
                    i4 = iJ2;
                    bArr3 = bArr5;
                    arrayList = arrayList3;
                    wy4Var = wy4Var5;
                } else {
                    bArr8 = bArr11;
                    bArr = bArr9;
                    m20Var = m20Var3;
                    rd1Var = rd1Var2;
                    i2 = i6;
                    c2 = c;
                    bArr3 = bArr5;
                    arrayList = arrayList3;
                    wy4Var = wy4Var5;
                    i4 = iJ2;
                    bArr2 = bArr4;
                    i3 = 4;
                    ly4 ly4VarT = T(rd1Var2.t, n02Var, rd1Var2.j, rd1Var2.i, rd1Var2.x, rd1Var2.v);
                    if (ly4VarT != null) {
                        rd1Var.q = ly4VarT;
                        long j6 = ly4VarT.e;
                        if (j6 != -1) {
                            rd1Var.j = j6;
                        }
                        long j7 = ly4VarT.d;
                        if (j7 != -1) {
                            rd1Var.i = j7;
                        }
                        long j8 = ly4VarT.f;
                        if (j8 != -1) {
                            rd1Var.x = j8;
                        }
                        int i8 = ly4VarT.g;
                        if (i8 != -1) {
                            rd1Var.v = i8;
                        }
                    }
                }
                O(rd1Var, n02Var);
                if (i4 > 0) {
                    byte[] bArr15 = new byte[i4];
                    randomAccessFile.readFully(bArr15);
                    rd1Var.y = p95.j(bArr15, rd1Var.s, null);
                }
                if (!rd1Var.n) {
                    c3 = 2;
                } else if (rd1Var.r != null) {
                    rd1Var.o = i3;
                    c3 = 2;
                } else {
                    c3 = 2;
                    rd1Var.o = 2;
                }
                arrayList.add(rd1Var);
                i5 = i2 + 1;
                ed4Var = this;
                arrayList2 = arrayList;
                m20Var2 = m20Var;
                bArr5 = bArr3;
                bArr7 = bArr;
                wy4Var5 = wy4Var;
                bArr4 = bArr2;
                c = c2;
                b2 = 0;
            }
            byte[] bArr16 = bArr4;
            wy4 wy4Var7 = wy4Var5;
            m20 m20Var4 = m20Var2;
            m20Var4.a = arrayList2;
            randomAccessFile.readFully(bArr6);
            if (n02.G(0, bArr6) == 84233040) {
                randomAccessFile.readFully(bArr16);
                int iJ3 = n02.J(0, bArr16);
                if (iJ3 > 0) {
                    byte[] bArr17 = new byte[iJ3];
                    randomAccessFile.readFully(bArr17);
                    new String(bArr17);
                }
            }
            wy4Var7.f = m20Var4;
            return (wy4) this.f;
        } catch (qy4 e) {
            throw e;
        } catch (IOException e2) {
            e2.printStackTrace();
            qy4 qy4Var = new qy4("Zip headers not found. Probably not a zip file or a corrupted zip file", e2);
            qy4Var.b = 7;
            throw qy4Var;
        }
    }

    public z41 Q(RandomAccessFile randomAccessFile, n02 n02Var, b71 b71Var) throws IOException {
        byte[] bArr = (byte[]) this.A;
        byte[] bArr2 = (byte[]) ((n02) this.z).z;
        long length = randomAccessFile.length();
        String strJ = null;
        if (length < 22) {
            st4.j("Zip file size less than size of zip headers. Probably not a zip file.");
            return null;
        }
        long length2 = length - 22;
        W(randomAccessFile, length2);
        randomAccessFile.readFully(bArr2);
        if (n02.G(0, bArr2) != 101010256) {
            length2 = randomAccessFile.length() - 22;
            for (long length3 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length3 > 0 && length2 > 0; length3--) {
                length2--;
                W(randomAccessFile, length2);
                randomAccessFile.readFully(bArr2);
                if (n02.G(0, bArr2) != 101010256) {
                }
            }
            st4.j("Zip headers not found. Probably not a zip file");
            return null;
        }
        W(randomAccessFile, 4 + length2);
        z41 z41Var = new z41();
        z41Var.a = 4;
        byte[] bArr3 = (byte[]) n02Var.f;
        randomAccessFile.readFully(bArr3);
        z41Var.d = n02.J(0, bArr3);
        randomAccessFile.readFully(bArr3);
        z41Var.e = n02.J(0, bArr3);
        randomAccessFile.readFully(bArr3);
        z41Var.f = n02.J(0, bArr3);
        randomAccessFile.readFully(bArr3);
        z41Var.g = n02.J(0, bArr3);
        byte[] bArr4 = (byte[]) n02Var.z;
        randomAccessFile.readFully(bArr4);
        n02.G(0, bArr4);
        z41Var.i = length2;
        randomAccessFile.readFully(bArr);
        z41Var.h = n02Var.I(0, bArr);
        randomAccessFile.readFully(bArr3);
        int iJ = n02.J(0, bArr3);
        if (iJ > 0) {
            try {
                byte[] bArr5 = new byte[iJ];
                randomAccessFile.readFully(bArr5);
                strJ = p95.j(bArr5, false, m12.b);
            } catch (IOException unused) {
            }
        }
        if (strJ != null) {
            z41Var.j = strJ;
        }
        ((wy4) this.f).Y = z41Var.d > 0;
        return z41Var;
    }

    public boolean R(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        if (i >= i3) {
            i -= i3;
        }
        ((cn) this.z).f(i2, i);
        return ((cn) this.f).b(i2, i);
    }

    public int S(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (R(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (R(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (R(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (R(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (R(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (R(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (R(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return R(i, i2, i3, i4) ? i15 | 1 : i15;
    }

    @Override // defpackage.f91
    public int U() {
        return ((ExtendedFloatingActionButton) this.A).l1;
    }

    public void V(Runnable runnable) {
        CodeEditor codeEditor = (CodeEditor) ((WeakReference) this.f).get();
        if (codeEditor == null) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            codeEditor.b0(runnable);
        }
    }

    public void X(ThemeModel themeModel) {
        this.A = themeModel;
        ArrayList arrayList = (ArrayList) this.z;
        if (!arrayList.contains(themeModel)) {
            arrayList.add(themeModel);
        }
        if (!themeModel.isLoaded()) {
            try {
                themeModel.load();
            } catch (Exception e) {
                vp1.p(e);
                return;
            }
        }
        ThemeModel themeModel2 = (ThemeModel) this.A;
        Iterator it = ((ArrayList) this.f).iterator();
        while (it.hasNext()) {
            ((dd4) it.next()).b(themeModel2);
        }
    }

    public synchronized void Y(String str) {
        ThemeModel themeModel;
        Iterator it = ((ArrayList) this.z).iterator();
        while (true) {
            if (!it.hasNext()) {
                themeModel = null;
                break;
            } else {
                themeModel = (ThemeModel) it.next();
                if (themeModel.getName().equals(str)) {
                    break;
                }
            }
        }
        if (themeModel != null) {
            X(themeModel);
            return;
        }
        ThemeModel themeModelA = A(str);
        if (themeModelA != null) {
            X(themeModelA);
        }
    }

    public void Z(kc0 kc0Var, int i, int i2, int i3) {
        kc0Var.getClass();
        int i4 = kc0Var.a0;
        int i5 = kc0Var.b0;
        kc0Var.a0 = 0;
        kc0Var.b0 = 0;
        kc0Var.K(i2);
        kc0Var.H(i3);
        if (i4 < 0) {
            kc0Var.a0 = 0;
        } else {
            kc0Var.a0 = i4;
        }
        if (i5 < 0) {
            kc0Var.b0 = 0;
        } else {
            kc0Var.b0 = i5;
        }
        kc0 kc0Var2 = (kc0) this.A;
        kc0Var2.s0 = i;
        kc0Var2.Q();
    }

    @Override // defpackage.wy3
    public lz3 a() {
        return (he3) this.z;
    }

    public void a0(kc0 kc0Var) {
        ArrayList arrayList = (ArrayList) this.f;
        arrayList.clear();
        int size = kc0Var.p0.size();
        for (int i = 0; i < size; i++) {
            jc0 jc0Var = (jc0) kc0Var.p0.get(i);
            int[] iArr = jc0Var.o0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(jc0Var);
            }
        }
        kc0Var.r0.b = true;
    }

    @Override // defpackage.pn1
    public boolean b(kn1 kn1Var) {
        return ((g12) yn1.B(kn1Var, (Method) this.A, new Object[0])).a() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0094 A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1 A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ca A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1 A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e3 A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e9 A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0121 A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012c A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0139 A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014d A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0152 A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0175 A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:11:0x0033, B:13:0x0047, B:15:0x004f, B:17:0x0055, B:23:0x005f, B:25:0x0094, B:27:0x00b1, B:29:0x00bc, B:30:0x00c2, B:32:0x00ca, B:37:0x00df, B:39:0x00e3, B:40:0x00e5, B:42:0x00e9, B:43:0x00ed, B:45:0x00f3, B:50:0x010b, B:52:0x0114, B:54:0x0121, B:55:0x0126, B:57:0x012c, B:60:0x013f, B:62:0x014d, B:64:0x0152, B:65:0x0171, B:67:0x0175, B:68:0x01af, B:70:0x01b5, B:59:0x0139, B:33:0x00d1, B:26:0x00a1), top: B:77:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x001c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b0(wy4 wy4Var, ByteArrayOutputStream byteArrayOutputStream, n02 n02Var) throws qy4 {
        byte[] bArr;
        boolean z;
        byte[] bArrO;
        List<pa1> list;
        String str;
        byte[] bArrO2;
        n nVar;
        if (wy4Var.f.a.size() <= 0) {
            return;
        }
        for (rd1 rd1Var : wy4Var.f.a) {
            byte[] bArr2 = (byte[]) this.A;
            byte[] bArr3 = (byte[]) this.z;
            if (rd1Var == null) {
                st4.j("input parameters is null, cannot write local file header");
                return;
            }
            try {
                byte[] bArr4 = {0, 0};
                if (rd1Var.i < 4294967295L) {
                    bArr = bArr4;
                    if (rd1Var.j < 4294967295L && rd1Var.x < 4294967295L && rd1Var.v < 65535) {
                        z = false;
                    }
                    n02Var.S(byteArrayOutputStream, (int) ha0.g(rd1Var.a));
                    n02Var.V(byteArrayOutputStream, rd1Var.u);
                    n02Var.V(byteArrayOutputStream, rd1Var.d);
                    byteArrayOutputStream.write(rd1Var.e);
                    n02Var.V(byteArrayOutputStream, fw.h(rd1Var.f));
                    n02.U(bArr3, rd1Var.g);
                    char c = 4;
                    byteArrayOutputStream.write(bArr3, 0, 4);
                    n02.U(bArr3, rd1Var.h);
                    byteArrayOutputStream.write(bArr3, 0, 4);
                    if (z) {
                        n02.U(bArr3, rd1Var.i);
                        byteArrayOutputStream.write(bArr3, 0, 4);
                        n02.U(bArr3, rd1Var.j);
                        byteArrayOutputStream.write(bArr3, 0, 4);
                    } else {
                        n02.U(bArr3, 4294967295L);
                        byteArrayOutputStream.write(bArr3, 0, 4);
                        byteArrayOutputStream.write(bArr3, 0, 4);
                        wy4Var.z0 = true;
                    }
                    bArrO = new byte[0];
                    if (yr2.N(rd1Var.m)) {
                        bArrO = p95.o(rd1Var.m, null);
                    }
                    n02Var.V(byteArrayOutputStream, bArrO.length);
                    byte[] bArr5 = new byte[4];
                    if (z) {
                        n02.U(bArr3, rd1Var.x);
                        System.arraycopy(bArr3, 0, bArr5, 0, 4);
                    } else {
                        n02.U(bArr3, 4294967295L);
                        System.arraycopy(bArr3, 0, bArr5, 0, 4);
                    }
                    int i = !z ? 32 : 0;
                    if (rd1Var.r != null) {
                        i += 11;
                    }
                    list = rd1Var.t;
                    if (list != null) {
                        for (pa1 pa1Var : list) {
                            char c2 = c;
                            long j = pa1Var.d;
                            if (j != 39169 && j != 1) {
                                i += pa1Var.e + 4;
                            }
                            c = c2;
                        }
                    }
                    n02Var.V(byteArrayOutputStream, i);
                    str = rd1Var.y;
                    bArrO2 = new byte[0];
                    if (yr2.N(str)) {
                        bArrO2 = p95.o(str, null);
                    }
                    n02Var.V(byteArrayOutputStream, bArrO2.length);
                    if (z) {
                        n02Var.V(byteArrayOutputStream, rd1Var.v);
                    } else {
                        n02.R(65535, bArr2);
                        byteArrayOutputStream.write(bArr2, 0, 2);
                    }
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(rd1Var.w);
                    byteArrayOutputStream.write(bArr5);
                    if (bArrO.length > 0) {
                        byteArrayOutputStream.write(bArrO);
                    }
                    if (z) {
                        wy4Var.z0 = true;
                        n02Var.V(byteArrayOutputStream, 1);
                        n02Var.V(byteArrayOutputStream, 28);
                        n02Var.T(byteArrayOutputStream, rd1Var.j);
                        n02Var.T(byteArrayOutputStream, rd1Var.i);
                        n02Var.T(byteArrayOutputStream, rd1Var.x);
                        n02Var.S(byteArrayOutputStream, rd1Var.v);
                    }
                    nVar = rd1Var.r;
                    if (nVar != null) {
                        n02Var.V(byteArrayOutputStream, (int) ha0.g(nVar.a));
                        n02Var.V(byteArrayOutputStream, nVar.d);
                        n02Var.V(byteArrayOutputStream, fw.o(nVar.e));
                        byteArrayOutputStream.write(p95.o(nVar.f, null));
                        byteArrayOutputStream.write(new byte[]{(byte) fw.l(nVar.g)});
                        n02Var.V(byteArrayOutputStream, fw.h(nVar.h));
                    }
                    d0(rd1Var, byteArrayOutputStream);
                    if (bArrO2.length <= 0) {
                        byteArrayOutputStream.write(bArrO2);
                    }
                } else {
                    bArr = bArr4;
                }
                z = true;
                n02Var.S(byteArrayOutputStream, (int) ha0.g(rd1Var.a));
                n02Var.V(byteArrayOutputStream, rd1Var.u);
                n02Var.V(byteArrayOutputStream, rd1Var.d);
                byteArrayOutputStream.write(rd1Var.e);
                n02Var.V(byteArrayOutputStream, fw.h(rd1Var.f));
                n02.U(bArr3, rd1Var.g);
                char c3 = 4;
                byteArrayOutputStream.write(bArr3, 0, 4);
                n02.U(bArr3, rd1Var.h);
                byteArrayOutputStream.write(bArr3, 0, 4);
                if (z) {
                }
                bArrO = new byte[0];
                if (yr2.N(rd1Var.m)) {
                }
                n02Var.V(byteArrayOutputStream, bArrO.length);
                byte[] bArr52 = new byte[4];
                if (z) {
                }
                if (!z) {
                }
                if (rd1Var.r != null) {
                }
                list = rd1Var.t;
                if (list != null) {
                }
                n02Var.V(byteArrayOutputStream, i);
                str = rd1Var.y;
                bArrO2 = new byte[0];
                if (yr2.N(str)) {
                }
                n02Var.V(byteArrayOutputStream, bArrO2.length);
                if (z) {
                }
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(rd1Var.w);
                byteArrayOutputStream.write(bArr52);
                if (bArrO.length > 0) {
                }
                if (z) {
                }
                nVar = rd1Var.r;
                if (nVar != null) {
                }
                d0(rd1Var, byteArrayOutputStream);
                if (bArrO2.length <= 0) {
                }
            } catch (Exception e) {
                throw new qy4(e);
            }
        }
    }

    @Override // defpackage.f91
    public int c() {
        int i = ((ExtendedFloatingActionButton) this.A).t1;
        return i == -1 ? ((eg0) this.f).c() : (i == 0 || i == -2) ? ((ExtendedFloatingActionButton) ((zf2) this.z).f).getMeasuredHeight() : i;
    }

    @Override // defpackage.pn1
    public ft0 d(kn1 kn1Var) {
        int iA = ((g12) yn1.B(kn1Var, (Method) this.A, new Object[0])).a();
        if (iA > 0) {
            return ((ws0) this.f).l(iA);
        }
        return null;
    }

    public void d0(rd1 rd1Var, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        byte[] bArr;
        n02 n02Var = (n02) this.f;
        List list = rd1Var.t;
        if (list == null || list.size() == 0) {
            return;
        }
        for (pa1 pa1Var : rd1Var.t) {
            long j = pa1Var.d;
            if (j != 39169 && j != 1) {
                n02Var.V(byteArrayOutputStream, (int) j);
                n02Var.V(byteArrayOutputStream, pa1Var.e);
                if (pa1Var.e > 0 && (bArr = pa1Var.f) != null) {
                    byteArrayOutputStream.write(bArr);
                }
            }
        }
    }

    @Override // defpackage.pn1
    public ft0 e(yn1 yn1Var) {
        int iA = ((g12) yn1.B(yn1Var, (Method) this.z, new Object[0])).a();
        if (iA > 0) {
            return ((ws0) this.f).l(iA);
        }
        return null;
    }

    @Override // defpackage.f91
    public int f() {
        int i = ((ExtendedFloatingActionButton) this.A).s1;
        return i == -1 ? ((eg0) this.f).f() : (i == 0 || i == -2) ? ((zf2) this.z).f() : i;
    }

    public void f0(wy4 wy4Var, OutputStream outputStream, byte[] bArr) throws IOException {
        if (bArr == null) {
            st4.j("invalid buff to write as zip headers");
            return;
        }
        if (outputStream instanceof tf0) {
            tf0 tf0Var = (tf0) outputStream;
            int length = bArr.length;
            if (tf0Var.s()) {
                q04 q04Var = (q04) tf0Var.b;
                if (length < 0) {
                    q04Var.getClass();
                    st4.j("negative buffersize for checkBufferSizeAndStartNextSplitFile");
                    return;
                }
                long j = q04Var.f;
                if (j >= 65536 && q04Var.X + ((long) length) > j) {
                    try {
                        q04Var.s();
                        q04Var.X = 0L;
                        z(wy4Var, outputStream);
                        return;
                    } catch (IOException e) {
                        throw new qy4(e);
                    }
                }
            }
        }
        outputStream.write(bArr);
    }

    @Override // defpackage.pn1
    public boolean g(yn1 yn1Var) {
        return ((g12) yn1.B(yn1Var, (Method) this.z, new Object[0])).a() != 0;
    }

    public synchronized void h(dd4 dd4Var) {
        ((ArrayList) this.f).add(dd4Var);
    }

    @Override // defpackage.f91
    public int i() {
        return ((ExtendedFloatingActionButton) this.A).m1;
    }

    public void j(char c) {
        ((StringBuilder) this.f).append((char) (c & 255));
    }

    public void k(int i) throws qi1 {
        x();
        x30 x30VarA = x30.a(i);
        if (x30VarA == null) {
            throw qi1.a();
        }
        this.A = Charset.forName(x30VarA.name());
    }

    public void m() {
        az1 az1Var;
        co4.h();
        ed4 ed4Var = (ed4) this.z;
        co4.h();
        og ogVar = (og) ed4Var.A;
        Objects.requireNonNull(ogVar);
        final e10 e10Var = (e10) ed4Var.f;
        Objects.requireNonNull(e10Var);
        final e10 e10Var2 = (e10) ed4Var.z;
        az1 az1Var2 = ogVar.a;
        Objects.requireNonNull(az1Var2);
        az1Var2.a();
        az1 az1Var3 = ogVar.a;
        Objects.requireNonNull(az1Var3);
        final int i = 0;
        n12.K(az1Var3.e).a(new Runnable() { // from class: h10
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = i;
                e10 e10Var3 = e10Var;
                switch (i2) {
                    case 0:
                        e10Var3.m();
                        break;
                    case 1:
                        if (e10Var3 != null) {
                            e10Var3.m();
                        }
                        break;
                    default:
                        if (e10Var3 != null) {
                            e10Var3.m();
                        }
                        break;
                }
            }
        }, vf2.q());
        az1 az1Var4 = ogVar.c;
        final int i2 = 1;
        if (az1Var4 != null) {
            az1Var4.a();
            final e10 e10Var3 = null;
            n12.K(ogVar.c.e).a(new Runnable() { // from class: h10
                @Override // java.lang.Runnable
                public final void run() {
                    int i22 = i2;
                    e10 e10Var32 = e10Var3;
                    switch (i22) {
                        case 0:
                            e10Var32.m();
                            break;
                        case 1:
                            if (e10Var32 != null) {
                                e10Var32.m();
                            }
                            break;
                        default:
                            if (e10Var32 != null) {
                                e10Var32.m();
                            }
                            break;
                    }
                }
            }, vf2.q());
        }
        if (ogVar.f.size() <= 1 || (az1Var = ogVar.b) == null) {
            return;
        }
        az1Var.a();
        final int i3 = 2;
        n12.K(ogVar.b.e).a(new Runnable() { // from class: h10
            @Override // java.lang.Runnable
            public final void run() {
                int i22 = i3;
                e10 e10Var32 = e10Var2;
                switch (i22) {
                    case 0:
                        e10Var32.m();
                        break;
                    case 1:
                        if (e10Var32 != null) {
                            e10Var32.m();
                        }
                        break;
                    default:
                        if (e10Var32 != null) {
                            e10Var32.m();
                        }
                        break;
                }
            }
        }, vf2.q());
    }

    @Override // defpackage.wv
    public Object n(vv vvVar) {
        vvVar.a(new f33(14, this), yu0.a());
        ((wq1) this.A).b.set(vvVar);
        return "HandlerScheduledFuture-" + ((Callable) this.z).toString();
    }

    public void o() {
        d80 d80Var = (d80) this.z;
        while (true) {
            x51 x51VarE = d80Var.b.e();
            if (x51VarE == null || x51VarE.a() != 2) {
                return;
            }
            c80 c80Var = (c80) x51VarE;
            for (int i : (int[]) this.A) {
                if (c80Var.c == i) {
                    break;
                }
            }
            return;
            ((ArrayList) this.f).add(new e80((c80) d80Var.b.next()));
        }
    }

    @Override // defpackage.wy3
    public vx3 p() {
        return (ge3) this.A;
    }

    public List q() {
        try {
            return (ArrayList) this.f;
        } finally {
            this.f = new ArrayList();
        }
    }

    public String s(int i, StringBuilder sb) throws qi1 {
        String str = null;
        while (true) {
            jk0 jk0VarT = t(i, str);
            String strA = id1.a(jk0VarT.d);
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = jk0VarT.f ? String.valueOf(jk0VarT.e) : null;
            int i2 = jk0VarT.a;
            if (i == i2) {
                return sb.toString();
            }
            i = i2;
            str = strValueOf;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:0x0209, code lost:
    
        r5 = r3.b;
        r6 = r5 + 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x020f, code lost:
    
        if (r6 <= r2.f) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0212, code lost:
    
        if (r5 >= r6) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0218, code lost:
    
        if (r2.d(r5) == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0220, code lost:
    
        if (H(r3.b) == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0222, code lost:
    
        r5 = r3.b;
        r6 = r5 + 5;
        r7 = r2.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0228, code lost:
    
        if (r6 >= r7) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x022a, code lost:
    
        r3.b = r5 + 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x022f, code lost:
    
        r3.b = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0231, code lost:
    
        r3.c = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0234, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0237, code lost:
    
        r3.b += 3;
        r3.c = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0242, code lost:
    
        r6 = new defpackage.sn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c9, code lost:
    
        r5 = r3.b;
        r6 = r5 + 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cf, code lost:
    
        if (r6 <= r2.f) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d2, code lost:
    
        if (r5 >= r6) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
    
        if (r2.d(r5) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e0, code lost:
    
        if (H(r3.b) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e2, code lost:
    
        r5 = r3.b;
        r6 = r5 + 5;
        r7 = r2.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e8, code lost:
    
        if (r6 >= r7) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ea, code lost:
    
        r3.b = r5 + 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f0, code lost:
    
        r3.b = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f3, code lost:
    
        r3.c = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f6, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fa, code lost:
    
        r3.b += 3;
        r3.c = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0103, code lost:
    
        r6 = new defpackage.sn();
     */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public jk0 t(int i, String str) throws qi1 {
        boolean zD;
        sn snVar;
        boolean z;
        kk0 kk0Var;
        int iY;
        int iY2;
        int iY3;
        char c;
        ik0 ik0Var;
        ik0 ik0Var2;
        int iY4;
        int iY5;
        char c2;
        ik0 ik0Var3;
        ik0 ik0Var4;
        bn bnVar = (bn) this.f;
        hm2 hm2Var = (hm2) this.z;
        StringBuilder sb = (StringBuilder) this.A;
        sb.setLength(0);
        if (str != null) {
            sb.append(str);
        }
        hm2Var.b = i;
        do {
            int i2 = hm2Var.b;
            int i3 = hm2Var.c;
            int i4 = 16;
            if (i3 == 2) {
                while (true) {
                    int i5 = hm2Var.b;
                    if (i5 + 5 <= bnVar.f && (((iY4 = y(i5, 5, bnVar)) >= 5 && iY4 < 16) || (i5 + 6 <= bnVar.f && (iY5 = y(i5, 6, bnVar)) >= 16 && iY5 < 63))) {
                        int i6 = hm2Var.b;
                        int iY6 = y(i6, 5, bnVar);
                        if (iY6 == 15) {
                            ik0Var4 = new ik0('$', i6 + 5);
                        } else {
                            if (iY6 < 5 || iY6 >= 15) {
                                int iY7 = y(i6, 6, bnVar);
                                if (iY7 < 32 || iY7 >= 58) {
                                    switch (iY7) {
                                        case 58:
                                            c2 = '*';
                                            break;
                                        case 59:
                                            c2 = StringUtil.COMMA;
                                            break;
                                        case 60:
                                            c2 = '-';
                                            break;
                                        case 61:
                                            c2 = '.';
                                            break;
                                        case 62:
                                            c2 = '/';
                                            break;
                                        default:
                                            xe.q(dw2.A(iY7, "Decoding invalid alphanumeric value: "));
                                            return null;
                                    }
                                    ik0Var3 = new ik0(c2, i6 + 6);
                                } else {
                                    ik0Var3 = new ik0((char) (iY7 + 33), i6 + 6);
                                }
                            } else {
                                ik0Var3 = new ik0((char) (iY6 + 43), i6 + 5);
                            }
                            ik0Var4 = ik0Var3;
                        }
                        int i7 = ik0Var4.a;
                        hm2Var.b = i7;
                        char c3 = ik0Var4.d;
                        if (c3 == '$') {
                            snVar = new sn((Object) new jk0(i7, sb.toString()), true);
                        } else {
                            sb.append(c3);
                        }
                    }
                }
                z = snVar.b;
            } else if (i3 == 3) {
                while (true) {
                    int i8 = hm2Var.b;
                    if (i8 + 5 <= bnVar.f && (((iY = y(i8, 5, bnVar)) >= 5 && iY < i4) || (i8 + 7 <= bnVar.f && (((iY2 = y(i8, 7, bnVar)) >= 64 && iY2 < 116) || (i8 + 8 <= bnVar.f && (iY3 = y(i8, 8, bnVar)) >= 232 && iY3 < 253))))) {
                        int i9 = hm2Var.b;
                        int iY8 = y(i9, 5, bnVar);
                        if (iY8 == 15) {
                            ik0Var2 = new ik0('$', i9 + 5);
                        } else {
                            if (iY8 < 5 || iY8 >= 15) {
                                int iY9 = y(i9, 7, bnVar);
                                if (iY9 >= 64 && iY9 < 90) {
                                    ik0Var = new ik0((char) (iY9 + 1), i9 + 7);
                                } else if (iY9 < 90 || iY9 >= 116) {
                                    switch (y(i9, 8, bnVar)) {
                                        case 232:
                                            c = '!';
                                            break;
                                        case 233:
                                            c = StringUtil.DOUBLE_QUOTE;
                                            break;
                                        case 234:
                                            c = '%';
                                            break;
                                        case 235:
                                            c = '&';
                                            break;
                                        case 236:
                                            c = '\'';
                                            break;
                                        case 237:
                                            c = '(';
                                            break;
                                        case 238:
                                            c = ')';
                                            break;
                                        case 239:
                                            c = '*';
                                            break;
                                        case 240:
                                            c = '+';
                                            break;
                                        case 241:
                                            c = StringUtil.COMMA;
                                            break;
                                        case 242:
                                            c = '-';
                                            break;
                                        case 243:
                                            c = '.';
                                            break;
                                        case 244:
                                            c = '/';
                                            break;
                                        case 245:
                                            c = ':';
                                            break;
                                        case 246:
                                            c = ';';
                                            break;
                                        case 247:
                                            c = '<';
                                            break;
                                        case 248:
                                            c = '=';
                                            break;
                                        case 249:
                                            c = '>';
                                            break;
                                        case 250:
                                            c = '?';
                                            break;
                                        case 251:
                                            c = '_';
                                            break;
                                        case 252:
                                            c = ' ';
                                            break;
                                        default:
                                            throw qi1.a();
                                    }
                                    ik0Var = new ik0(c, i9 + 8);
                                } else {
                                    ik0Var = new ik0((char) (iY9 + 7), i9 + 7);
                                }
                            } else {
                                ik0Var = new ik0((char) (iY8 + 43), i9 + 5);
                            }
                            ik0Var2 = ik0Var;
                        }
                        int i10 = ik0Var2.a;
                        hm2Var.b = i10;
                        char c4 = ik0Var2.d;
                        if (c4 == '$') {
                            snVar = new sn((Object) new jk0(i10, sb.toString()), true);
                        } else {
                            sb.append(c4);
                            i4 = 16;
                        }
                    }
                }
                z = snVar.b;
            } else {
                while (true) {
                    int i11 = hm2Var.b;
                    int i12 = i11 + 7;
                    int i13 = bnVar.f;
                    if (i12 > i13) {
                        zD = i11 + 4 <= i13;
                        int i14 = hm2Var.b;
                        int i15 = bnVar.f;
                        if (zD) {
                            if (i14 + 1 <= i15) {
                                for (int i16 = 0; i16 < 4; i16++) {
                                    int i17 = i16 + i14;
                                    if (i17 >= bnVar.f) {
                                        hm2Var.c = 2;
                                        hm2Var.b += 4;
                                    } else if (!bnVar.d(i17)) {
                                    }
                                }
                                hm2Var.c = 2;
                                hm2Var.b += 4;
                            }
                            snVar = new sn();
                        } else {
                            int i18 = i14 + 7;
                            if (i18 > i15) {
                                int iY10 = y(i14, 4, bnVar);
                                int i19 = bnVar.f;
                                kk0Var = iY10 == 0 ? new kk0(i19, 10, 10) : new kk0(i19, iY10 - 1, 10);
                            } else {
                                int iY11 = y(i14, 7, bnVar) - 8;
                                kk0Var = new kk0(i18, iY11 / 11, iY11 % 11);
                            }
                            int i20 = kk0Var.a;
                            hm2Var.b = i20;
                            int i21 = kk0Var.e;
                            int i22 = kk0Var.d;
                            if (i22 == 10) {
                                snVar = new sn((Object) (i21 == 10 ? new jk0(i20, sb.toString()) : new jk0(i20, i21, sb.toString())), true);
                            } else {
                                boolean z2 = true;
                                sb.append(i22);
                                if (i21 == 10) {
                                    snVar = new sn(new jk0(hm2Var.b, sb.toString()), z2);
                                } else {
                                    sb.append(i21);
                                }
                            }
                        }
                    } else {
                        int i23 = i11;
                        while (true) {
                            int i24 = i11 + 3;
                            if (i23 >= i24) {
                                zD = bnVar.d(i24);
                            } else if (!bnVar.d(i23)) {
                                i23++;
                            }
                        }
                        int i142 = hm2Var.b;
                        int i152 = bnVar.f;
                        if (zD) {
                        }
                    }
                }
                z = snVar.b;
            }
            int i25 = hm2Var.b;
            if (i2 == i25 && !z) {
            }
            jk0 jk0Var = (jk0) snVar.f;
            return (jk0Var == null && jk0Var.f) ? new jk0(i25, jk0Var.e, sb.toString()) : new jk0(i25, sb.toString());
        } while (!z);
        jk0 jk0Var2 = (jk0) snVar.f;
        if (jk0Var2 == null) {
        }
    }

    public String toString() {
        switch (this.b) {
            case 10:
                StringBuilder sb = new StringBuilder("[ClassStack (self-refs: ");
                ArrayList arrayList = (ArrayList) this.f;
                sb.append(arrayList == null ? "0" : String.valueOf(arrayList.size()));
                sb.append(')');
                while (this != null) {
                    sb.append(' ');
                    sb.append(((Class) this.A).getName());
                    this = (ed4) this.z;
                }
                sb.append(']');
                return sb.toString();
            case 16:
                x();
                StringBuilder sb2 = (StringBuilder) this.z;
                return sb2 == null ? "" : sb2.toString();
            default:
                return super.toString();
        }
    }

    public void v(Bundle bundle) {
        HashSet hashSet = (HashSet) this.z;
        String string = ((Context) this.A).getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (d02.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    w((Class) it.next(), hashSet2);
                }
            } catch (ClassNotFoundException e) {
                throw new t80(e);
            }
        }
    }

    public Object w(Class cls, HashSet hashSet) {
        Object objB;
        HashMap map = (HashMap) this.f;
        if (vo.A()) {
            try {
                Trace.beginSection(vo.O(cls.getSimpleName()));
            } finally {
                Trace.endSection();
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                d02 d02Var = (d02) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = d02Var.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            w(cls2, hashSet);
                        }
                    }
                }
                objB = d02Var.b((Context) this.A);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th) {
                throw new t80(th);
            }
        }
        return objB;
    }

    public void x() {
        Charset charset = (Charset) this.A;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        boolean zEquals = charset.equals(charset2);
        StringBuilder sb = (StringBuilder) this.f;
        if (zEquals) {
            if (sb.length() > 0) {
                StringBuilder sb2 = (StringBuilder) this.z;
                StringBuilder sb3 = (StringBuilder) this.f;
                if (sb2 == null) {
                    this.z = sb3;
                    this.f = new StringBuilder();
                    return;
                } else {
                    sb2.append((CharSequence) sb3);
                    this.f = new StringBuilder();
                    return;
                }
            }
            return;
        }
        if (sb.length() > 0) {
            byte[] bytes = ((StringBuilder) this.f).toString().getBytes(charset2);
            this.f = new StringBuilder();
            StringBuilder sb4 = (StringBuilder) this.z;
            Charset charset3 = (Charset) this.A;
            if (sb4 == null) {
                this.z = new StringBuilder(new String(bytes, charset3));
            } else {
                sb4.append(new String(bytes, charset3));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:6:0x000e, B:8:0x0017, B:12:0x0024, B:16:0x0039, B:42:0x00bd, B:22:0x004e, B:24:0x0052, B:25:0x0059, B:27:0x0063, B:35:0x007d, B:37:0x0081, B:39:0x008e, B:41:0x009c, B:38:0x0087, B:40:0x0096, B:30:0x006e, B:32:0x0072, B:11:0x0020), top: B:52:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:6:0x000e, B:8:0x0017, B:12:0x0024, B:16:0x0039, B:42:0x00bd, B:22:0x004e, B:24:0x0052, B:25:0x0059, B:27:0x0063, B:35:0x007d, B:37:0x0081, B:39:0x008e, B:41:0x009c, B:38:0x0087, B:40:0x0096, B:30:0x006e, B:32:0x0072, B:11:0x0020), top: B:52:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0096 A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:6:0x000e, B:8:0x0017, B:12:0x0024, B:16:0x0039, B:42:0x00bd, B:22:0x004e, B:24:0x0052, B:25:0x0059, B:27:0x0063, B:35:0x007d, B:37:0x0081, B:39:0x008e, B:41:0x009c, B:38:0x0087, B:40:0x0096, B:30:0x006e, B:32:0x0072, B:11:0x0020), top: B:52:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void z(wy4 wy4Var, OutputStream outputStream) throws IOException {
        long j;
        boolean zS;
        n02 n02Var = (n02) this.f;
        if (wy4Var == null || outputStream == null) {
            st4.j("input parameters is null, cannot finalize zip file");
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            N(wy4Var, outputStream);
            if (wy4Var.z0) {
                j = wy4Var.X.l;
                if (j == -1) {
                    j = wy4Var.z.h;
                }
            }
            b0(wy4Var, byteArrayOutputStream, n02Var);
            int size = byteArrayOutputStream.size();
            if (wy4Var.z0 || j >= 4294967295L || wy4Var.f.a.size() >= 65535) {
                jy4 jy4Var = wy4Var.A;
                if (jy4Var == null) {
                    jy4Var = new jy4();
                    wy4Var.A = jy4Var;
                }
                jy4Var.e = ((long) size) + j;
                if (outputStream instanceof q04) {
                    zS = ((q04) outputStream).f != -1;
                    if (zS) {
                        jy4 jy4Var2 = wy4Var.A;
                        jy4Var2.d = 0;
                        jy4Var2.f = 1;
                    } else {
                        int iG = outputStream instanceof q04 ? ((q04) outputStream).A : ((tf0) outputStream).g();
                        jy4 jy4Var3 = wy4Var.A;
                        jy4Var3.d = iG;
                        jy4Var3.f = iG + 1;
                    }
                    ky4 ky4VarL = l(wy4Var, size, j);
                    wy4Var.X = ky4VarL;
                    e0(ky4VarL, byteArrayOutputStream, n02Var);
                    jy4 jy4Var4 = wy4Var.A;
                    n02Var.S(byteArrayOutputStream, 117853008);
                    n02Var.S(byteArrayOutputStream, jy4Var4.d);
                    n02Var.T(byteArrayOutputStream, jy4Var4.e);
                    n02Var.S(byteArrayOutputStream, jy4Var4.f);
                } else {
                    if (outputStream instanceof tf0) {
                        zS = ((tf0) outputStream).s();
                    }
                    if (zS) {
                    }
                    ky4 ky4VarL2 = l(wy4Var, size, j);
                    wy4Var.X = ky4VarL2;
                    e0(ky4VarL2, byteArrayOutputStream, n02Var);
                    jy4 jy4Var42 = wy4Var.A;
                    n02Var.S(byteArrayOutputStream, 117853008);
                    n02Var.S(byteArrayOutputStream, jy4Var42.d);
                    n02Var.T(byteArrayOutputStream, jy4Var42.e);
                    n02Var.S(byteArrayOutputStream, jy4Var42.f);
                }
            }
            c0(wy4Var, size, j, byteArrayOutputStream, n02Var);
            f0(wy4Var, outputStream, byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } finally {
        }
    }

    public /* synthetic */ ed4(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }

    public /* synthetic */ ed4(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.b = i;
        this.A = obj;
        this.f = obj2;
        this.z = obj3;
    }

    public ed4(ed4 ed4Var, Class cls) {
        this.b = 10;
        this.z = ed4Var;
        this.A = cls;
    }

    public ed4(iv1 iv1Var) {
        this.b = 6;
        this.f = iv1Var;
        km0 km0Var = (km0) iv1Var.A;
        km0Var.getClass();
        this.z = new he3(km0Var);
        this.A = co4.d((jm0) iv1Var.X);
    }

    public ed4(ConstraintLayout constraintLayout, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3) {
        this.b = 15;
        this.f = textInputLayout;
        this.z = textInputLayout2;
        this.A = textInputLayout3;
    }

    public ed4(cn cnVar) throws qi1 {
        int i;
        int i2;
        this.b = 5;
        int i3 = cnVar.f;
        if (i3 >= 8 && i3 <= 144 && (i = i3 & 1) == 0) {
            int i4 = cnVar.b;
            vo4[] vo4VarArr = vo4.h;
            if (i == 0 && (i4 & 1) == 0) {
                vo4[] vo4VarArr2 = vo4.h;
                for (int i5 = 0; i5 < 48; i5++) {
                    vo4 vo4Var = vo4VarArr2[i5];
                    int i6 = vo4Var.b;
                    if (i6 == i3 && (i2 = vo4Var.c) == i4) {
                        this.A = vo4Var;
                        if (cnVar.f == i6) {
                            int i7 = vo4Var.d;
                            int i8 = vo4Var.e;
                            int i9 = i6 / i7;
                            int i10 = i2 / i8;
                            cn cnVar2 = new cn(i10 * i8, i9 * i7);
                            for (int i11 = 0; i11 < i9; i11++) {
                                int i12 = i11 * i7;
                                for (int i13 = 0; i13 < i10; i13++) {
                                    int i14 = i13 * i8;
                                    for (int i15 = 0; i15 < i7; i15++) {
                                        int i16 = ((i7 + 2) * i11) + 1 + i15;
                                        int i17 = i12 + i15;
                                        for (int i18 = 0; i18 < i8; i18++) {
                                            if (cnVar.b(((i8 + 2) * i13) + 1 + i18, i16)) {
                                                cnVar2.f(i14 + i18, i17);
                                            }
                                        }
                                    }
                                }
                            }
                            this.f = cnVar2;
                            this.z = new cn(cnVar2.b, cnVar2.f);
                            return;
                        }
                        xe.k("Dimension of bitMatrix must match the version size");
                        throw null;
                    }
                }
                throw qi1.a();
            }
            throw qi1.a();
        }
        throw qi1.a();
    }

    public ed4(int i) {
        this.b = 16;
        this.A = StandardCharsets.ISO_8859_1;
        this.f = new StringBuilder(i);
    }

    public ed4(s03 s03Var, int[] iArr) {
        this.b = 12;
        this.z = new d80(s03Var);
        this.A = iArr;
        this.f = new ArrayList();
    }

    public ed4(bn bnVar) {
        this.b = 23;
        hm2 hm2Var = new hm2(2);
        hm2Var.b = 0;
        hm2Var.c = 1;
        this.z = hm2Var;
        this.A = new StringBuilder();
        this.f = bnVar;
    }

    public ed4(CodeEditor codeEditor) {
        this.b = 17;
        this.f = new WeakReference(codeEditor);
        codeEditor.n0(fs3.class, new g11(3, this));
    }

    public ed4(byte b, int i) {
        this.b = i;
        switch (i) {
            case 16:
                this.A = StandardCharsets.ISO_8859_1;
                this.f = new StringBuilder();
                break;
            case 27:
                this.z = new n02(14);
                this.A = new byte[4];
                break;
            case 28:
                this.f = new n02(14);
                this.z = new byte[8];
                this.A = new byte[4];
                break;
            default:
                this.f = new ArrayList();
                this.z = new ArrayList();
                this.A = ThemeModel.EMPTY;
                break;
        }
    }

    public ed4(Context context) {
        this.b = 1;
        this.A = context.getApplicationContext();
        this.z = new HashSet();
        this.f = new HashMap();
    }

    public ed4(kc0 kc0Var) {
        this.b = 4;
        this.f = new ArrayList();
        this.z = new zl();
        this.A = kc0Var;
    }

    public /* synthetic */ ed4(char c, int i) {
        this.b = i;
    }

    public ed4(iv1 iv1Var, d7 d7Var, ll0 ll0Var, Set set) {
        this.b = 18;
        this.f = d7Var;
        this.z = iv1Var;
        this.A = ll0Var;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            M(str, 0, str.length(), 1, true, new th1(str, 1));
        }
    }

    public ed4(lb lbVar) {
        this.b = 8;
        this.A = lbVar;
        this.z = new AtomicBoolean(false);
        this.f = ((ex) lbVar.z).A.schedule(new ax(this, 0), 2000L, TimeUnit.MILLISECONDS);
    }

    public ed4(ws0 ws0Var, String str, Class cls, Class cls2) {
        this.b = 24;
        this.f = ws0Var;
        this.z = yn1.y(cls, ha0.o("get", str, "Case"), new Class[0]);
        this.A = yn1.y(cls2, ha0.o("get", str, "Case"), new Class[0]);
        yn1.y(cls2, ha0.n("clear", str), new Class[0]);
    }
}
