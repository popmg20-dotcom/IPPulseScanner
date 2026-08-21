package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.widget.ActionMenuView;
import io.github.rosemoe.sora.widget.CodeEditor;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean n(java.lang.CharSequence r7, int r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L45
            if (r8 < 0) goto L45
            int r1 = r7.length()
            int r1 = r1 - r8
            if (r1 < 0) goto L45
            java.lang.Object r1 = r6.f
            pr1 r1 = (defpackage.pr1) r1
            if (r1 != 0) goto L17
            boolean r6 = r6.j()
            return r6
        L17:
            r1 = 2
            r2 = r0
            r3 = r1
        L1a:
            r4 = 1
            if (r2 >= r8) goto L3a
            if (r3 != r1) goto L3a
            char r3 = r7.charAt(r2)
            byte r3 = java.lang.Character.getDirectionality(r3)
            sn r5 = defpackage.mb4.a
            if (r3 == 0) goto L36
            if (r3 == r4) goto L34
            if (r3 == r1) goto L34
            switch(r3) {
                case 14: goto L36;
                case 15: goto L36;
                case 16: goto L34;
                case 17: goto L34;
                default: goto L32;
            }
        L32:
            r3 = r1
            goto L37
        L34:
            r3 = r0
            goto L37
        L36:
            r3 = r4
        L37:
            int r2 = r2 + 1
            goto L1a
        L3a:
            if (r3 == 0) goto L44
            if (r3 == r4) goto L43
            boolean r6 = r6.j()
            return r6
        L43:
            return r0
        L44:
            return r4
        L45:
            defpackage.s53.d()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sn.n(java.lang.CharSequence, int):boolean");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.bv4 u(android.view.View r17, defpackage.bv4 r18, defpackage.nr4 r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            yu4 r4 = r2.a
            r5 = 519(0x207, float:7.27E-43)
            t02 r5 = r4.h(r5)
            r6 = 32
            t02 r4 = r4.h(r6)
            java.lang.Object r6 = r0.f
            com.google.android.material.bottomsheet.BottomSheetBehavior r6 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r6
            boolean r7 = r6.G0
            int r8 = r5.b
            int r9 = r5.c
            int r10 = r5.a
            r6.O0 = r8
            int r8 = r1.getLayoutDirection()
            r12 = 1
            if (r8 != r12) goto L2d
            r8 = r12
            goto L2e
        L2d:
            r8 = 0
        L2e:
            int r13 = r1.getPaddingBottom()
            int r14 = r1.getPaddingLeft()
            int r15 = r1.getPaddingRight()
            if (r7 == 0) goto L45
            int r13 = r2.a()
            r6.N0 = r13
            int r11 = r3.d
            int r13 = r13 + r11
        L45:
            boolean r11 = r6.H0
            if (r11 == 0) goto L52
            if (r8 == 0) goto L4e
            int r11 = r3.c
            goto L50
        L4e:
            int r11 = r3.a
        L50:
            int r14 = r11 + r10
        L52:
            boolean r11 = r6.I0
            if (r11 == 0) goto L5f
            if (r8 == 0) goto L5b
            int r3 = r3.a
            goto L5d
        L5b:
            int r3 = r3.c
        L5d:
            int r15 = r3 + r9
        L5f:
            android.view.ViewGroup$LayoutParams r3 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
            boolean r8 = r6.K0
            if (r8 == 0) goto L71
            int r8 = r3.leftMargin
            if (r8 == r10) goto L71
            r3.leftMargin = r10
            r11 = r12
            goto L72
        L71:
            r11 = 0
        L72:
            boolean r8 = r6.L0
            if (r8 == 0) goto L7d
            int r8 = r3.rightMargin
            if (r8 == r9) goto L7d
            r3.rightMargin = r9
            r11 = r12
        L7d:
            boolean r8 = r6.M0
            if (r8 == 0) goto L8a
            int r8 = r3.topMargin
            int r5 = r5.b
            if (r8 == r5) goto L8a
            r3.topMargin = r5
            goto L8b
        L8a:
            r12 = r11
        L8b:
            if (r12 == 0) goto L90
            r1.setLayoutParams(r3)
        L90:
            int r3 = r1.getPaddingTop()
            r1.setPadding(r14, r3, r15, r13)
            boolean r0 = r0.b
            if (r0 == 0) goto L9f
            int r1 = r4.d
            r6.E0 = r1
        L9f:
            if (r7 != 0) goto La5
            if (r0 == 0) goto La4
            goto La5
        La4:
            return r2
        La5:
            r6.V()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sn.u(android.view.View, bv4, nr4):bv4");
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
