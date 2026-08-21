package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class eg0 implements om1, t31, wy3, f91, mn1, on1 {
    public final /* synthetic */ int b;
    public Object f;
    public Object z;

    public eg0(int i) {
        this.b = i;
        switch (i) {
            case 8:
                this.f = new ArrayList();
                this.z = new ArrayList();
                break;
            case 14:
                this.f = new me(0);
                this.z = new HashMap();
                break;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                break;
            case 27:
                this.z = iv3.a((2 & 1) != 0 ? 0 : 1, 0, (2 & 4) != 0 ? jp.b : jp.f);
                break;
            default:
                this.f = new Intent("android.intent.action.VIEW");
                break;
        }
    }

    public static xk3 P(xk3 xk3Var, float f, float f2) {
        float f3 = xk3Var.a;
        float f4 = xk3Var.b;
        return new xk3(f3 < f ? f3 - 1.0f : f3 + 1.0f, f4 < f2 ? f4 - 1.0f : f4 + 1.0f);
    }

    public static xk3 V(xk3 xk3Var, xk3 xk3Var2, int i) {
        float f = xk3Var2.a;
        float f2 = xk3Var.a;
        float f3 = i + 1;
        float f4 = xk3Var2.b;
        float f5 = xk3Var.b;
        return new xk3(f2 + ((f - f2) / f3), f5 + ((f4 - f5) / f3));
    }

    public static boolean W(CodeEditor codeEditor, lg0 lg0Var, ld0 ld0Var, i11 i11Var, g82 g82Var) {
        int i = lg0Var.d.a().b;
        codeEditor.i0(i, ld0Var.o(i).f);
        codeEditor.e(codeEditor.getLineSeparator().b, true);
        codeEditor.r();
        return g82Var.A(true) || i11Var.A(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.eg0 s(android.content.Context r5) {
        /*
            java.lang.String r0 = "generatefid.lock"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            java.io.File r5 = r5.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            java.lang.String r0 = "rw"
            r5.<init>(r2, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L33 java.io.IOException -> L35
            java.nio.channels.FileLock r0 = r5.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L28 java.lang.Error -> L2b java.io.IOException -> L2d
            eg0 r2 = new eg0     // Catch: java.nio.channels.OverlappingFileLockException -> L22 java.lang.Error -> L24 java.io.IOException -> L26
            r3 = 0
            r2.<init>(r3, r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L22 java.lang.Error -> L24 java.io.IOException -> L26
            return r2
        L22:
            r2 = move-exception
            goto L37
        L24:
            r2 = move-exception
            goto L37
        L26:
            r2 = move-exception
            goto L37
        L28:
            r2 = move-exception
        L29:
            r0 = r1
            goto L37
        L2b:
            r2 = move-exception
            goto L29
        L2d:
            r2 = move-exception
            goto L29
        L2f:
            r2 = move-exception
        L30:
            r5 = r1
            r0 = r5
            goto L37
        L33:
            r2 = move-exception
            goto L30
        L35:
            r2 = move-exception
            goto L30
        L37:
            java.lang.String r3 = "CrossProcessLock"
            java.lang.String r4 = "encountered error while creating and acquiring the lock, ignoring"
            io.sentry.android.core.a1.e(r3, r4, r2)
            if (r0 == 0) goto L43
            r0.release()     // Catch: java.io.IOException -> L43
        L43:
            if (r5 == 0) goto L48
            r5.close()     // Catch: java.io.IOException -> L48
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.eg0.s(android.content.Context):eg0");
    }

    public void A(o oVar, boolean z) {
        u uVar = (u) this.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.A(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.e(uVar, oVar);
            }
        }
    }

    public void B(o oVar, boolean z) {
        u uVar = (u) this.f;
        ca caVar = uVar.x.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.B(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                FragmentManager$FragmentLifecycleCallbacks fragmentManager$FragmentLifecycleCallbacks = qj1Var.a;
            }
        }
    }

    public void C(o oVar, boolean z) {
        o oVar2 = ((u) this.f).z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.C(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                FragmentManager$FragmentLifecycleCallbacks fragmentManager$FragmentLifecycleCallbacks = qj1Var.a;
            }
        }
    }

    public void D(o oVar, boolean z) {
        u uVar = (u) this.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.D(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.f(uVar, oVar);
            }
        }
    }

    public void E(o oVar, Bundle bundle, boolean z) {
        u uVar = (u) this.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.E(oVar, bundle, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.g(uVar, oVar, bundle);
            }
        }
    }

    public void F(o oVar, boolean z) {
        u uVar = (u) this.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.F(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.h(uVar, oVar);
            }
        }
    }

    public void G(o oVar, boolean z) {
        u uVar = (u) this.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.G(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.i(uVar, oVar);
            }
        }
    }

    public void H(o oVar, View view, Bundle bundle, boolean z) {
        view.getClass();
        u uVar = (u) this.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.H(oVar, view, bundle, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.j(uVar, oVar, view);
            }
        }
    }

    @Override // defpackage.f91
    public ViewGroup.LayoutParams I() {
        int i = ((ExtendedFloatingActionButton) this.z).t1;
        if (i == 0) {
            i = -2;
        }
        return new ViewGroup.LayoutParams(-1, i);
    }

    public void J(o oVar, boolean z) {
        u uVar = (u) this.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.J(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.k(uVar, oVar);
            }
        }
    }

    public tj K(int i) {
        tj tjVar;
        tj tjVar2;
        tj[] tjVarArr = (tj[]) this.z;
        tj tjVar3 = tjVarArr[L(i)];
        if (tjVar3 != null) {
            return tjVar3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iL = L(i) - i2;
            if (iL >= 0 && (tjVar2 = tjVarArr[iL]) != null) {
                return tjVar2;
            }
            int iL2 = L(i) + i2;
            if (iL2 < tjVarArr.length && (tjVar = tjVarArr[iL2]) != null) {
                return tjVar;
            }
        }
        return null;
    }

    public int L(int i) {
        return i - ((xo) this.f).h;
    }

    public boolean M(int i, KeyEvent keyEvent) {
        j82 j82Var = (j82) this.z;
        if (j82Var.b() || j82Var.a() || keyEvent.isCtrlPressed()) {
            return (i >= 29 && i <= 54) || i == 66 || i == 19 || i == 20 || i == 21 || i == 22 || i == 122 || i == 123;
        }
        return false;
    }

    public boolean N(xk3 xk3Var) {
        float f = xk3Var.a;
        if (f < 0.0f) {
            return false;
        }
        cn cnVar = (cn) this.f;
        if (f > cnVar.b - 1) {
            return false;
        }
        float f2 = xk3Var.b;
        return f2 > 0.0f && f2 <= ((float) (cnVar.f - 1));
    }

    public void O() throws IOException {
        String str = (String) this.z;
        if (((FileChannel) this.f) != null) {
            return;
        }
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileChannel channel = new FileOutputStream(file).getChannel();
            this.f = channel;
            if (channel != null) {
                channel.lock();
            }
        } catch (Throwable th) {
            FileChannel fileChannel = (FileChannel) this.f;
            if (fileChannel != null) {
                fileChannel.close();
            }
            this.f = null;
            e04.l(ha0.o("Unable to lock file: '", str, "'."), th);
        }
    }

    public void Q(boolean z) {
        po1 po1Var = (po1) this.f;
        ji0.B(uf2.t(po1Var), null, null, new no1(po1Var, z, null), 3);
    }

    public void R() {
        try {
            ((FileLock) this.z).release();
            ((FileChannel) this.f).close();
        } catch (IOException e) {
            a1.e("CrossProcessLock", "encountered error while releasing, ignoring", e);
        }
    }

    public void S(Set set) {
        me meVar = (me) this.f;
        meVar.clear();
        HashMap map = (HashMap) this.z;
        map.clear();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            d31 d31Var = (d31) it.next();
            d31Var.getClass();
            if (!meVar.contains(d31Var)) {
                String strA = d31Var.a();
                if (strA == null) {
                    meVar.add(d31Var);
                } else if (map.containsKey(strA)) {
                    xe.k(ha0.o("Duplicated tag: ", strA, ". Tag must be unique among all registered rules"));
                    return;
                } else {
                    map.put(strA, d31Var);
                    meVar.add(d31Var);
                }
            }
        }
    }

    public void T(as4 as4Var) {
        this.f = as4Var;
        if (as4Var != null) {
            ((hv3) this.z).p(as4Var);
        }
    }

    @Override // defpackage.f91
    public int U() {
        return ((ExtendedFloatingActionButton) this.z).l1;
    }

    public int X(xk3 xk3Var, xk3 xk3Var2) {
        int i = (int) xk3Var.a;
        int i2 = (int) xk3Var.b;
        int i3 = (int) xk3Var2.a;
        cn cnVar = (cn) this.f;
        int iMin = Math.min(cnVar.f - 1, (int) xk3Var2.b);
        int i4 = 0;
        boolean z = Math.abs(iMin - i2) > Math.abs(i3 - i);
        if (z) {
            i = i2;
            i2 = i;
            i3 = iMin;
            iMin = i3;
        }
        int iAbs = Math.abs(i3 - i);
        int iAbs2 = Math.abs(iMin - i2);
        int i5 = (-iAbs) / 2;
        int i6 = i2 < iMin ? 1 : -1;
        int i7 = i >= i3 ? -1 : 1;
        boolean zB = cnVar.b(z ? i2 : i, z ? i : i2);
        while (i != i3) {
            boolean zB2 = cnVar.b(z ? i2 : i, z ? i : i2);
            if (zB2 != zB) {
                i4++;
                zB = zB2;
            }
            i5 += iAbs2;
            if (i5 > 0) {
                if (i2 == iMin) {
                    return i4;
                }
                i2 += i6;
                i5 -= iAbs;
            }
            i += i7;
        }
        return i4;
    }

    @Override // defpackage.wy3
    public lz3 a() {
        return (p61) this.z;
    }

    @Override // defpackage.on1
    public boolean b(kn1 kn1Var) {
        switch (this.b) {
            case 23:
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            default:
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
        }
    }

    @Override // defpackage.f91
    public int c() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) ((zf2) this.f).f;
        ExtendedFloatingActionButton extendedFloatingActionButton2 = (ExtendedFloatingActionButton) this.z;
        int i = extendedFloatingActionButton2.t1;
        if (i != -1) {
            return (i == 0 || i == -2) ? extendedFloatingActionButton.getMeasuredHeight() : i;
        }
        if (!(extendedFloatingActionButton2.getParent() instanceof View)) {
            return extendedFloatingActionButton.getMeasuredHeight();
        }
        View view = (View) extendedFloatingActionButton2.getParent();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.height != -2) {
            return (view.getHeight() - ((!(extendedFloatingActionButton2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) extendedFloatingActionButton2.getLayoutParams()) == null) ? 0 : marginLayoutParams.topMargin + marginLayoutParams.bottomMargin)) - (view.getPaddingBottom() + view.getPaddingTop());
        }
        return extendedFloatingActionButton.getMeasuredHeight();
    }

    @Override // defpackage.on1
    public Object d(kn1 kn1Var) {
        switch (this.b) {
            case 23:
                ft0 ft0Var = (ft0) this.f;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < kn1Var.N(ft0Var.z.Z).v().size(); i++) {
                    arrayList.add(kn1Var.N(ft0Var.z.Z).v().get(i));
                }
                return DesugarCollections.unmodifiableList(arrayList);
            default:
                return yn1.B(kn1Var, (Method) ((j80) this.z).b, new Object[0]);
        }
    }

    @Override // defpackage.on1
    public Object e(yn1 yn1Var) {
        switch (this.b) {
            case 23:
                ft0 ft0Var = (ft0) this.f;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < yn1Var.A(ft0Var.z.Z).v().size(); i++) {
                    arrayList.add(yn1Var.A(ft0Var.z.Z).v().get(i));
                }
                return DesugarCollections.unmodifiableList(arrayList);
            default:
                return yn1.B(yn1Var, (Method) ((j80) this.z).a, new Object[0]);
        }
    }

    @Override // defpackage.f91
    public int f() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        zf2 zf2Var = (zf2) this.f;
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this.z;
        if (!(extendedFloatingActionButton.getParent() instanceof View)) {
            return zf2Var.f();
        }
        View view = (View) extendedFloatingActionButton.getParent();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.width != -2) {
            return (view.getWidth() - ((!(extendedFloatingActionButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) extendedFloatingActionButton.getLayoutParams()) == null) ? 0 : marginLayoutParams.leftMargin + marginLayoutParams.rightMargin)) - (view.getPaddingRight() + view.getPaddingLeft());
        }
        return zf2Var.f();
    }

    @Override // defpackage.on1
    public boolean g(yn1 yn1Var) {
        switch (this.b) {
            case 23:
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            default:
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
        }
    }

    @Override // defpackage.on1
    public a1 h() {
        switch (this.b) {
            case 23:
                return ((c1) this.z).r();
            default:
                throw new UnsupportedOperationException("newBuilderForField() called on a repeated field.");
        }
    }

    @Override // defpackage.f91
    public int i() {
        return ((ExtendedFloatingActionButton) this.z).m1;
    }

    @Override // defpackage.on1
    public void j(kn1 kn1Var, Object obj) {
        switch (this.b) {
            case 23:
                kn1Var.O(((ft0) this.f).z.Z).y().clear();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    l(kn1Var, it.next());
                }
                break;
            default:
                yn1.B(kn1Var, (Method) ((j80) this.z).h, new Object[0]);
                Iterator it2 = ((List) obj).iterator();
                while (it2.hasNext()) {
                    l(kn1Var, it2.next());
                }
                break;
        }
    }

    @Override // defpackage.mn1
    public void k(int i, q60 q60Var) {
        Iterator it = (Iterator) this.f;
        while (true) {
            Map.Entry entry = (Map.Entry) this.z;
            if (entry == null || ((ft0) entry.getKey()).z.Z >= i) {
                return;
            }
            kd1.r((ft0) ((Map.Entry) this.z).getKey(), ((Map.Entry) this.z).getValue(), q60Var);
            if (it.hasNext()) {
                this.z = (Map.Entry) it.next();
            } else {
                this.z = null;
            }
        }
    }

    @Override // defpackage.on1
    public void l(kn1 kn1Var, Object obj) {
        switch (this.b) {
            case 23:
                List listY = kn1Var.O(((ft0) this.f).z.Z).y();
                c1 c1VarP = (c1) obj;
                c1 c1Var = (c1) this.z;
                if (c1VarP == null) {
                    c1VarP = null;
                } else if (!c1Var.getClass().isInstance(c1VarP)) {
                    c1VarP = c1Var.u().x(c1VarP).p();
                }
                listY.add(c1VarP);
                break;
            default:
                yn1.B(kn1Var, (Method) ((j80) this.z).e, obj);
                break;
        }
    }

    @Override // defpackage.om1
    public void m(Object obj) {
        d74 d74Var = (d74) obj;
        d74Var.getClass();
        yy0 yy0Var = (yy0) ((v92) this.z).b;
        if (yy0Var.g.get()) {
            d74Var.close();
        } else {
            yy0Var.b(new xy0(0, yy0Var, d74Var), new d4(19, d74Var));
        }
    }

    @Override // defpackage.t31
    public Object n() {
        return (jm4) this.f;
    }

    @Override // defpackage.on1
    public a1 o(kn1 kn1Var) {
        switch (this.b) {
            case 23:
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            default:
                throw new UnsupportedOperationException("getFieldBuilder() called on a repeated field.");
        }
    }

    @Override // defpackage.wy3
    public vx3 p() {
        return (o61) this.f;
    }

    @Override // defpackage.om1
    public void q(Throwable th) {
        int i = ((c74) this.f).f;
        if (i == 2 && (th instanceof CancellationException)) {
            ez4.o("DualSurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
        } else {
            ez4.b0("DualSurfaceProcessorNode", "Downstream node failed to provide Surface. Target: ".concat(xb5.o(i)), th);
        }
    }

    @Override // defpackage.t31
    public boolean r(CharSequence charSequence, int i, int i2, kk4 kk4Var) {
        if ((kk4Var.c & 4) > 0) {
            return true;
        }
        if (((jm4) this.f) == null) {
            this.f = new jm4(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((d7) this.z).getClass();
        ((jm4) this.f).setSpan(new lk4(kk4Var), i, i2, 33);
        return true;
    }

    public void t(int[] iArr, String str) {
        ((ArrayList) this.f).add(iArr);
        ((ArrayList) this.z).add(str);
    }

    public String toString() {
        switch (this.b) {
            case 4:
                Formatter formatter = new Formatter();
                try {
                    int i = 0;
                    for (tj tjVar : (tj[]) this.z) {
                        if (tjVar == null) {
                            formatter.format("%3d:    |   %n", Integer.valueOf(i));
                            i++;
                        } else {
                            formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(tjVar.f), Integer.valueOf(tjVar.e));
                            i++;
                        }
                    }
                    String string = formatter.toString();
                    formatter.close();
                    return string;
                } catch (Throwable th) {
                    try {
                        formatter.close();
                        break;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            default:
                return super.toString();
        }
    }

    public eg0 u() {
        Intent intent = (Intent) this.f;
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
        intent.putExtras(new Bundle());
        intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            String strI = ga5.i();
            if (!TextUtils.isEmpty(strI)) {
                Bundle bundleExtra = intent.hasExtra("com.android.browser.headers") ? intent.getBundleExtra("com.android.browser.headers") : new Bundle();
                if (!bundleExtra.containsKey("Accept-Language")) {
                    bundleExtra.putString("Accept-Language", strI);
                    intent.putExtra("com.android.browser.headers", bundleExtra);
                }
            }
        }
        if (i >= 34) {
            ActivityOptions activityOptionsMakeBasic = (ActivityOptions) this.z;
            if (activityOptionsMakeBasic == null) {
                activityOptionsMakeBasic = ActivityOptions.makeBasic();
                this.z = activityOptionsMakeBasic;
            }
            l2.o(activityOptionsMakeBasic);
        }
        if (i >= 36) {
            if (((ActivityOptions) this.z) == null) {
                this.z = ActivityOptions.makeBasic();
            }
            m2.f((ActivityOptions) this.z, !intent.getBooleanExtra("androidx.browser.customtabs.extra.DISABLE_BACKGROUND_INTERACTION", false));
        }
        ActivityOptions activityOptions = (ActivityOptions) this.z;
        return new eg0(2, intent, activityOptions != null ? activityOptions.toBundle() : null);
    }

    public void v(o oVar, boolean z) {
        o oVar2 = ((u) this.f).z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.v(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                FragmentManager$FragmentLifecycleCallbacks fragmentManager$FragmentLifecycleCallbacks = qj1Var.a;
            }
        }
    }

    public void w(o oVar, boolean z) {
        u uVar = (u) this.f;
        ca caVar = uVar.x.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.w(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.a(uVar, oVar, caVar);
            }
        }
    }

    public void x(o oVar, Bundle bundle, boolean z) {
        u uVar = (u) this.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.x(oVar, bundle, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.b(uVar, oVar);
            }
        }
    }

    public void y(o oVar, boolean z) {
        u uVar = (u) this.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.y(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.c(uVar, oVar);
            }
        }
    }

    public void z(o oVar, boolean z) {
        u uVar = (u) this.f;
        o oVar2 = uVar.z;
        if (oVar2 != null) {
            u parentFragmentManager = oVar2.getParentFragmentManager();
            parentFragmentManager.getClass();
            parentFragmentManager.p.z(oVar, true);
        }
        for (qj1 qj1Var : (CopyOnWriteArrayList) this.z) {
            if (!z || qj1Var.b) {
                qj1Var.a.d(uVar, oVar);
            }
        }
    }

    public /* synthetic */ eg0(int i, Object obj, Object obj2, boolean z) {
        this.b = i;
        this.z = obj;
        this.f = obj2;
    }

    public /* synthetic */ eg0(ViewGroup viewGroup, View view, View view2, int i) {
        this.b = i;
        this.f = view;
        this.z = view2;
    }

    public eg0(u uVar) {
        this.b = 19;
        this.f = uVar;
        this.z = new CopyOnWriteArrayList();
    }

    public eg0(xo xoVar) {
        this.b = 4;
        this.f = new xo(xoVar);
        this.z = new tj[(xoVar.i - xoVar.h) + 1];
    }

    public eg0(pl3 pl3Var) {
        this.b = 28;
        this.f = pl3Var;
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.getClass();
        this.z = setNewSetFromMap;
    }

    public eg0(String str) {
        this.b = 16;
        this.z = str.concat(".lck");
    }

    public eg0(cn cnVar) {
        this.b = 5;
        this.f = cnVar;
        this.z = new lt4(cnVar);
    }

    public eg0(CodeEditor codeEditor) {
        this.b = 9;
        this.f = codeEditor;
        this.z = new j82(codeEditor);
    }

    public eg0(ue1 ue1Var) {
        this.b = 12;
        r61 r61Var = (r61) ue1Var.A;
        this.f = new o61(ue1Var, r61Var.i().p(), -1L, true);
        this.z = new p61(ue1Var, r61Var.i().a(), -1L, true);
    }

    public eg0(File file) {
        this.b = 3;
        this.z = Collections.singletonList("en");
        this.f = file;
    }

    public eg0(Animation animation) {
        this.b = 17;
        this.f = animation;
        this.z = null;
    }

    public eg0(Animator animator) {
        this.b = 17;
        this.f = null;
        AnimatorSet animatorSet = new AnimatorSet();
        this.z = animatorSet;
        animatorSet.play(animator);
    }

    public eg0(ArrayList arrayList, ArrayList arrayList2) {
        this.b = 26;
        int size = arrayList.size();
        this.f = new int[size];
        this.z = new float[size];
        for (int i = 0; i < size; i++) {
            ((int[]) this.f)[i] = ((Integer) arrayList.get(i)).intValue();
            ((float[]) this.z)[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    public eg0(int i, int i2) {
        this.b = 26;
        this.f = new int[]{i, i2};
        this.z = new float[]{0.0f, 1.0f};
    }

    public eg0(int i, int i2, int i3) {
        this.b = 26;
        this.f = new int[]{i, i2, i3};
        this.z = new float[]{0.0f, 0.5f, 1.0f};
    }

    public eg0(EditText editText) {
        this.b = 10;
        this.f = editText;
        y31 y31Var = new y31(editText);
        this.z = y31Var;
        editText.addTextChangedListener(y31Var);
        if (n31.b == null) {
            synchronized (n31.a) {
                try {
                    if (n31.b == null) {
                        n31 n31Var = new n31();
                        try {
                            n31.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, n31.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        n31.b = n31Var;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(n31.b);
    }

    public /* synthetic */ eg0(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    public eg0(nn1 nn1Var) {
        Iterator it;
        this.b = 22;
        kd1 kd1Var = nn1Var.X;
        jy3 jy3Var = kd1Var.a;
        if (jy3Var.isEmpty()) {
            it = Collections.emptyIterator();
        } else if (kd1Var.c) {
            Iterator it2 = ((de) jy3Var.entrySet()).iterator();
            c92 c92Var = new c92();
            c92Var.f = it2;
            it = c92Var;
        } else {
            it = ((de) jy3Var.entrySet()).iterator();
        }
        this.f = it;
        if (it.hasNext()) {
            this.z = (Map.Entry) it.next();
        }
    }

    public eg0(Class cls, Class cls2, String str) {
        this.b = 24;
        j80 j80Var = new j80(cls, cls2, str);
        this.f = ((Method) j80Var.c).getReturnType();
        this.z = j80Var;
    }

    public eg0(ft0 ft0Var, Class cls) {
        this.b = 23;
        this.f = ft0Var;
        this.z = ((yn1) yn1.B(null, yn1.y(cls, "getDefaultInstance", new Class[0]), new Object[0])).A(ft0Var.z.Z).x();
    }
}
