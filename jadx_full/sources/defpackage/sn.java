package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sn implements mr4, rl2, f84, fl2 {
    public boolean b;
    public Object f;

    public sn(boolean z) {
        this.f = DesugarCollections.synchronizedList(new ArrayList());
        this.b = z;
    }

    public static boolean g(sy syVar) {
        int[] iArr;
        if (Build.VERSION.SDK_INT > 34 && (iArr = (int[]) syVar.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) != null) {
            for (int i : iArr) {
                if (i == 6) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.fl2
    public void a(nk2 nk2Var, boolean z) {
        q3 q3Var;
        kf4 kf4Var = (kf4) this.f;
        if (this.b) {
            return;
        }
        this.b = true;
        ActionMenuView actionMenuView = kf4Var.l.a.b;
        if (actionMenuView != null && (q3Var = actionMenuView.N0) != null) {
            q3Var.g();
            l3 l3Var = q3Var.L0;
            if (l3Var != null && l3Var.b()) {
                l3Var.i.dismiss();
            }
        }
        kf4Var.m.onPanelClosed(108, nk2Var);
        this.b = false;
    }

    @Override // defpackage.rl2
    public boolean b(ft0 ft0Var) {
        return ((a1) this.f).b(ft0Var);
    }

    @Override // defpackage.f84
    public boolean c(ld0 ld0Var) {
        return this.b && ld0Var.m().a();
    }

    @Override // defpackage.f84
    public boolean d(CodeEditor codeEditor) {
        int[] iArr = (int[]) this.f;
        boolean zA = codeEditor.getCursor().a();
        boolean z = this.b;
        if (zA) {
            return z;
        }
        if (!z) {
            if (iArr != null) {
                q30 q30Var = codeEditor.getCursor().c;
                int i = q30Var.b;
                int i2 = q30Var.c;
                List listC = codeEditor.C(i);
                int size = listC.size() - 1;
                int size2 = listC.size() - 1;
                as2 as2Var = null;
                int i3 = 0;
                while (i3 <= size) {
                    int i4 = (i3 + size) / 2;
                    as2 as2Var2 = (as2) listC.get(i4);
                    int i5 = as2Var2.a;
                    if (i5 != i2) {
                        if (i5 < i2) {
                            if (((as2) listC.get(Math.max(Math.min(i4 + 1, size2), 0))).a <= i2) {
                                i3++;
                                as2Var = as2Var2;
                            }
                        } else if (((as2) listC.get(Math.max(Math.min(i4 - 1, size2), 0))).a >= i2) {
                            size--;
                            as2Var = as2Var2;
                        }
                    }
                    as2Var = as2Var2;
                    break;
                }
                Integer num = as2Var.c;
                if (!ha0.w(num) || Arrays.binarySearch(iArr, num.intValue()) < 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.rl2
    public rl2 e(ft0 ft0Var, Object obj) {
        if (obj instanceof ml2) {
            obj = ((ml2) obj).q();
        }
        ((a1) this.f).o(ft0Var, obj);
        return this;
    }

    @Override // defpackage.rl2
    public int f(ft0 ft0Var) {
        if (ft0Var.B()) {
            return 2;
        }
        return (ft0Var.y() || !(((a1) this.f) instanceof kn1)) ? 1 : 3;
    }

    @Override // defpackage.rl2
    public int h() {
        return 1;
    }

    public CameraCaptureSession.CaptureCallback i(CameraCaptureSession.CaptureCallback captureCallback) {
        if (!this.b) {
            return captureCallback;
        }
        lw lwVar = new lw(3);
        yv yvVar = (yv) lwVar.b;
        ((List) this.f).add(yvVar);
        Log.d("RequestMonitor", "RequestListener " + lwVar + " monitoring " + this);
        yvVar.f.a(new b0(13, this, lwVar, yvVar), yu0.a());
        return new hx(Arrays.asList(lwVar, captureCallback));
    }

    @Override // defpackage.fl2
    public boolean i0(nk2 nk2Var) {
        ((kf4) this.f).m.onMenuOpened(108, nk2Var);
        return true;
    }

    public boolean j() {
        return this.b;
    }

    @Override // defpackage.rl2
    public k91 k(l91 l91Var, ws0 ws0Var, int i) {
        return (k91) l91Var.f.get(new j91(ws0Var, i));
    }

    public a1 l(ft0 ft0Var) {
        if (!this.b) {
            return null;
        }
        try {
            return ((a1) this.f).r(ft0Var);
        } catch (UnsupportedOperationException unused) {
            this.b = false;
            return null;
        }
    }

    public nc2 m() {
        List list = (List) this.f;
        if (list.isEmpty()) {
            return zy1.z;
        }
        yb2 yb2Var = new yb2(new ArrayList(new ArrayList(list)), false, yu0.a());
        s53 s53Var = new s53(17);
        return n12.K(n12.W(yb2Var, new ha1(7, s53Var), yu0.a()));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n(CharSequence charSequence, int i) {
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            s53.d();
            return false;
        }
        if (((pr1) this.f) == null) {
            return j();
        }
        char c = 2;
        for (int i2 = 0; i2 < i && c == 2; i2++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i2));
            sn snVar = mb4.a;
            if (directionality == 0) {
                c = 1;
                continue;
            } else if (directionality != 1 && directionality != 2) {
                switch (directionality) {
                    case 14:
                    case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                        break;
                    case 16:
                    case 17:
                        c = 0;
                        break;
                    default:
                        c = 2;
                        continue;
                }
            } else {
                c = 0;
            }
        }
        if (c == 0) {
            return true;
        }
        if (c != 1) {
            return j();
        }
        return false;
    }

    @Override // defpackage.rl2
    public c1 o(zt ztVar, o91 o91Var, ft0 ft0Var, c1 c1Var) {
        c1 c1Var2;
        a1 a1Var = (a1) this.f;
        a1 a1VarR = c1Var != null ? c1Var.r() : a1Var.B(ft0Var);
        if (!ft0Var.y() && (c1Var2 = (c1) a1Var.n(ft0Var)) != null) {
            a1VarR.x(c1Var2);
        }
        a1VarR.z(ztVar, o91Var);
        return a1VarR.q();
    }

    public a1 p(ft0 ft0Var, c1 c1Var) {
        return c1Var != null ? c1Var.r() : ((a1) this.f).B(ft0Var);
    }

    @Override // defpackage.rl2
    public void q(m60 m60Var, o91 o91Var, ft0 ft0Var, c1 c1Var) {
        a1 a1VarP;
        a1 a1Var = (a1) this.f;
        if (ft0Var.y()) {
            a1 a1VarP2 = p(ft0Var, c1Var);
            m60Var.k(a1VarP2, o91Var);
            e(ft0Var, a1VarP2.q());
            return;
        }
        if (a1Var.b(ft0Var)) {
            a1 a1VarL = l(ft0Var);
            if (a1VarL != null) {
                m60Var.k(a1VarL, o91Var);
                return;
            } else {
                a1VarP = p(ft0Var, c1Var);
                a1VarP.x((c1) a1Var.n(ft0Var));
            }
        } else {
            a1VarP = p(ft0Var, c1Var);
        }
        m60Var.k(a1VarP, o91Var);
        w(ft0Var, a1VarP.q());
    }

    public void r(boolean z) {
        if (z == this.b) {
            return;
        }
        this.b = z;
        if (z) {
            return;
        }
        synchronized (((cp1) this.f).f) {
        }
    }

    public void s() {
        LinkedList linkedList = new LinkedList((List) this.f);
        while (!linkedList.isEmpty()) {
            nc2 nc2Var = (nc2) linkedList.poll();
            Objects.requireNonNull(nc2Var);
            nc2Var.cancel(true);
        }
    }

    public oa5 t(long j, String str) {
        Long lValueOf = Long.valueOf(j);
        Object obj = oa5.g;
        return new oa5(this, str, lValueOf, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    @Override // defpackage.mr4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public bv4 u(View view, bv4 bv4Var, nr4 nr4Var) {
        boolean z;
        yu4 yu4Var = bv4Var.a;
        t02 t02VarH = yu4Var.h(519);
        t02 t02VarH2 = yu4Var.h(32);
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f;
        boolean z2 = bottomSheetBehavior.G0;
        int i = t02VarH.b;
        int i2 = t02VarH.c;
        int i3 = t02VarH.a;
        bottomSheetBehavior.O0 = i;
        boolean z3 = true;
        boolean z4 = view.getLayoutDirection() == 1;
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        if (z2) {
            int iA = bv4Var.a();
            bottomSheetBehavior.N0 = iA;
            paddingBottom = iA + nr4Var.d;
        }
        if (bottomSheetBehavior.H0) {
            paddingLeft = (z4 ? nr4Var.c : nr4Var.a) + i3;
        }
        if (bottomSheetBehavior.I0) {
            paddingRight = (z4 ? nr4Var.a : nr4Var.c) + i2;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (!bottomSheetBehavior.K0 || marginLayoutParams.leftMargin == i3) {
            z = false;
        } else {
            marginLayoutParams.leftMargin = i3;
            z = true;
        }
        if (bottomSheetBehavior.L0 && marginLayoutParams.rightMargin != i2) {
            marginLayoutParams.rightMargin = i2;
            z = true;
        }
        if (bottomSheetBehavior.M0) {
            int i4 = marginLayoutParams.topMargin;
            int i5 = t02VarH.b;
            if (i4 != i5) {
                marginLayoutParams.topMargin = i5;
            } else {
                z3 = z;
            }
        }
        if (z3) {
            view.setLayoutParams(marginLayoutParams);
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        boolean z5 = this.b;
        if (z5) {
            bottomSheetBehavior.E0 = t02VarH2.d;
        }
        if (!z2 && !z5) {
            return bv4Var;
        }
        bottomSheetBehavior.V();
        return bv4Var;
    }

    public oa5 v(String str, boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        Object obj = oa5.g;
        return new oa5(this, str, boolValueOf, 1);
    }

    @Override // defpackage.rl2
    public rl2 w(ft0 ft0Var, Object obj) {
        a1 a1Var = (a1) this.f;
        if (ft0Var.y() || !(obj instanceof ml2)) {
            a1Var.D(ft0Var, obj);
            return this;
        }
        if (obj != l(ft0Var)) {
            a1Var.D(ft0Var, ((ml2) obj).q());
        }
        return this;
    }

    @Override // defpackage.rl2
    public void x(m60 m60Var, o91 o91Var, ft0 ft0Var, c1 c1Var) {
        a1 a1VarP;
        a1 a1Var = (a1) this.f;
        boolean zY = ft0Var.y();
        rq0 rq0Var = ft0Var.z;
        if (zY) {
            a1 a1VarP2 = p(ft0Var, c1Var);
            m60Var.i(rq0Var.Z, a1VarP2, o91Var);
            e(ft0Var, a1VarP2.q());
            return;
        }
        if (a1Var.b(ft0Var)) {
            a1 a1VarL = l(ft0Var);
            if (a1VarL != null) {
                m60Var.i(rq0Var.Z, a1VarL, o91Var);
                return;
            } else {
                a1VarP = p(ft0Var, c1Var);
                a1VarP.x((c1) a1Var.n(ft0Var));
            }
        } else {
            a1VarP = p(ft0Var, c1Var);
        }
        m60Var.i(rq0Var.Z, a1VarP, o91Var);
        w(ft0Var, a1VarP.q());
    }

    public oa5 y(String str, String str2) {
        Object obj = oa5.g;
        return new oa5(this, str, str2, 3);
    }

    public /* synthetic */ sn(Object obj) {
        this.f = obj;
    }

    public /* synthetic */ sn(Object obj, boolean z) {
        this.b = z;
        this.f = obj;
    }

    public sn() {
        this((Object) null, false);
    }

    public sn(Uri uri, boolean z, boolean z2) {
        this.f = uri;
        this.b = z;
    }

    public sn(pr1 pr1Var, boolean z) {
        this(pr1Var);
        this.b = z;
    }
}
