package defpackage;

import android.app.Dialog;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import com.getsurfboard.R;
import com.getsurfboard.backup.model.BackupSection;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zf2 implements lk2, lc2, mu2, fl2, uy, ni2, az4, f91, l4 {
    public static final zn1 z = new zn1(1);
    public final /* synthetic */ int b;
    public Object f;

    public zf2(int i) {
        this.b = i;
        switch (i) {
            case 11:
                this.f = new vg(new Object());
                break;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                TimeUnit.MINUTES.getClass();
                ab4 ab4Var = ab4.l;
                ab4Var.getClass();
                this.f = new oe3(ab4Var);
                break;
            case 17:
                this.f = new ha1(21, ho1.l);
                break;
            case 21:
                this.f = om2.e;
                break;
            case 24:
                this.f = (ExtraSupportedSurfaceCombinationsQuirk) xt0.a.z(ExtraSupportedSurfaceCombinationsQuirk.class);
                break;
            case 29:
                this.f = null;
                break;
            default:
                ll2 ll2Var = z;
                v93 v93Var = v93.c;
                try {
                    ll2Var = (ll2) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
                } catch (Exception unused) {
                }
                ll2[] ll2VarArr = {zn1.b, ll2Var};
                yf2 yf2Var = new yf2();
                yf2Var.a = ll2VarArr;
                Charset charset = j12.a;
                this.f = yf2Var;
                break;
        }
    }

    public static cu3 j0(r90 r90Var) {
        cu3 cu3Var = new cu3();
        MaterialCheckBox materialCheckBox = (MaterialCheckBox) r90Var.f;
        MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) r90Var.d;
        MaterialCheckBox materialCheckBox3 = (MaterialCheckBox) r90Var.e;
        MaterialCheckBox materialCheckBox4 = (MaterialCheckBox) r90Var.g;
        if (materialCheckBox.getVisibility() == 0 && materialCheckBox.isChecked()) {
            cu3Var.add(BackupSection.PROFILES);
        }
        if (materialCheckBox4.getVisibility() == 0 && materialCheckBox4.isChecked()) {
            cu3Var.add(BackupSection.SETTINGS);
        }
        if (materialCheckBox3.getVisibility() == 0 && materialCheckBox3.isChecked()) {
            cu3Var.add(BackupSection.METADATA);
        }
        if (materialCheckBox2.getVisibility() == 0 && materialCheckBox2.isChecked()) {
            cu3Var.add(BackupSection.HOSTS);
        }
        return yr2.b(cu3Var);
    }

    public static void q0(r90 r90Var, u6 u6Var) {
        u6Var.Z.j.setEnabled(!j0(r90Var).b.isEmpty());
    }

    @Override // defpackage.ka0
    public /* synthetic */ Object C(pg pgVar, ia0 ia0Var) {
        return dw2.o(this, pgVar, ia0Var);
    }

    @Override // defpackage.lc2
    public void D(int i, int i2) {
        ((rf3) this.f).a.e(i, i2);
    }

    @Override // defpackage.az4
    public float G() {
        return 1.0f;
    }

    @Override // defpackage.f91
    public ViewGroup.LayoutParams I() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    @Override // defpackage.ka0
    public /* synthetic */ boolean K(pg pgVar) {
        return dw2.a(this, pgVar);
    }

    @Override // defpackage.lc2
    public void P(int i, int i2) {
        ((rf3) this.f).a.f(i, i2);
    }

    @Override // defpackage.ka0
    public /* synthetic */ ia0 S(pg pgVar) {
        return dw2.c(this, pgVar);
    }

    @Override // defpackage.f91
    public int U() {
        return ((ExtendedFloatingActionButton) this.f).l1;
    }

    @Override // defpackage.lk2
    public boolean V(nk2 nk2Var, sk2 sk2Var) {
        boolean zA;
        t3 t3Var = ((ActionMenuView) this.f).U0;
        if (t3Var != null) {
            Toolbar toolbar = (Toolbar) ((ha1) t3Var).f;
            Iterator it = ((CopyOnWriteArrayList) toolbar.a1.z).iterator();
            while (true) {
                if (!it.hasNext()) {
                    hf4 hf4Var = toolbar.c1;
                    zA = hf4Var != null ? hf4Var.a(sk2Var) : false;
                } else if (((sj1) it.next()).a.p(sk2Var)) {
                    zA = true;
                    break;
                }
            }
            if (zA) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        switch (this.b) {
            case 4:
                AppBarLayout appBarLayout = (AppBarLayout) this.f;
                bv4 bv4Var2 = appBarLayout.getFitsSystemWindows() ? bv4Var : null;
                if (!Objects.equals(appBarLayout.A0, bv4Var2)) {
                    appBarLayout.A0 = bv4Var2;
                    appBarLayout.setWillNotDraw(!(appBarLayout.Q0 != null && appBarLayout.getTopInset() > 0));
                    appBarLayout.requestLayout();
                }
                break;
            default:
                po poVar = (po) this.f;
                oo ooVar = poVar.E0;
                if (ooVar != null) {
                    poVar.Z.s1.remove(ooVar);
                }
                oo ooVar2 = new oo(poVar.A0, bv4Var);
                poVar.E0 = ooVar2;
                ooVar2.e(poVar.getWindow());
                BottomSheetBehavior bottomSheetBehavior = poVar.Z;
                oo ooVar3 = poVar.E0;
                ArrayList arrayList = bottomSheetBehavior.s1;
                if (!arrayList.contains(ooVar3)) {
                    arrayList.add(ooVar3);
                }
                break;
        }
        return bv4Var;
    }

    @Override // defpackage.fl2
    public void a(nk2 nk2Var, boolean z2) {
        ((za) this.f).u(nk2Var);
    }

    @Override // defpackage.lk2
    public void a0(nk2 nk2Var) {
        lk2 lk2Var = ((ActionMenuView) this.f).P0;
        if (lk2Var != null) {
            lk2Var.a0(nk2Var);
        }
    }

    @Override // defpackage.f91
    public int c() {
        return ((ExtendedFloatingActionButton) this.f).getMeasuredHeight();
    }

    @Override // defpackage.lc2
    public void d0(int i, int i2, Object obj) {
        ((rf3) this.f).a.d(i, i2, obj);
    }

    @Override // defpackage.f91
    public int f() {
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this.f;
        return ((extendedFloatingActionButton.getMeasuredWidth() - extendedFloatingActionButton.getPaddingStart()) - extendedFloatingActionButton.getPaddingEnd()) + extendedFloatingActionButton.l1 + extendedFloatingActionButton.m1;
    }

    @Override // defpackage.lc2
    public void g(int i, int i2) {
        ((rf3) this.f).a.c(i, i2);
    }

    @Override // defpackage.l4
    public void h(Object obj) {
        k4 k4Var = (k4) obj;
        u uVar = (u) this.f;
        wj1 wj1Var = (wj1) uVar.G.pollLast();
        if (wj1Var == null) {
            a1.n("FragmentManager", "No Activities were started for result for " + this);
            return;
        }
        String str = wj1Var.b;
        int i = wj1Var.f;
        o oVarC = uVar.c.c(str);
        if (oVarC != null) {
            oVarC.onActivityResult(i, k4Var.b, k4Var.f);
            return;
        }
        a1.n("FragmentManager", "Activity result delivered for unknown Fragment " + str);
    }

    @Override // defpackage.f91
    public int i() {
        return ((ExtendedFloatingActionButton) this.f).m1;
    }

    @Override // defpackage.fl2
    public boolean i0(nk2 nk2Var) {
        Window.Callback callback = ((za) this.f).C0.getCallback();
        if (callback == null) {
            return true;
        }
        callback.onMenuOpened(108, nk2Var);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x039a A[LOOP:21: B:238:0x0229->B:231:0x039a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0350 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.pk0 k0(defpackage.ue1 r24) throws defpackage.d40, defpackage.qi1 {
        /*
            Method dump skipped, instruction units count: 947
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zf2.k0(ue1):pk0");
    }

    @Override // defpackage.ka0
    public /* synthetic */ void l(ed edVar) {
        dw2.b(this, edVar);
    }

    public void l0() {
        Socket socket;
        oe3 oe3Var = (oe3) this.f;
        Iterator it = ((ConcurrentLinkedQueue) oe3Var.e).iterator();
        it.getClass();
        while (it.hasNext()) {
            me3 me3Var = (me3) it.next();
            me3Var.getClass();
            synchronized (me3Var) {
                if (me3Var.p.isEmpty()) {
                    it.remove();
                    me3Var.j = true;
                    socket = me3Var.e;
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                jz4.c(socket);
            }
        }
        if (((ConcurrentLinkedQueue) oe3Var.e).isEmpty()) {
            ((za4) oe3Var.c).a();
        }
    }

    @Override // defpackage.zd3
    public ka0 m() {
        return sw2.z;
    }

    public void m0() {
        int i = ty.a;
        if (((sw2) m()).p(uy.i, null) == null) {
            return;
        }
        st4.n();
    }

    public void n0() {
        ((kj1) this.f).A.S();
    }

    @Override // defpackage.az4
    public float o() {
        Float f = (Float) ((sy) this.f).a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f != null && f.floatValue() >= 1.0f) {
            return f.floatValue();
        }
        return 1.0f;
    }

    public void o0(View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        ((sl) this.f).a(0);
    }

    @Override // defpackage.ka0
    public /* synthetic */ Object p(pg pgVar, Object obj) {
        return dw2.n(this, pgVar, obj);
    }

    public void p0(InetSocketAddress inetSocketAddress) {
        q81 q81Var = (q81) this.f;
        Dialog dialog = q81Var.C0;
        if (dialog instanceof u6) {
            String string = q81Var.getString(R.string.explorer_running_template, inetSocketAddress.getAddress().getHostAddress(), Integer.valueOf(inetSocketAddress.getPort()));
            s6 s6Var = ((u6) dialog).Z;
            s6Var.e = string;
            TextView textView = s6Var.x;
            if (textView != null) {
                textView.setText(string);
            }
        }
    }

    public void r0(int i, Object obj, gq3 gq3Var) {
        r60 r60Var = (r60) this.f;
        r60Var.B(i, 3);
        gq3Var.d((d1) obj, r60Var.a);
        r60Var.B(i, 4);
    }

    @Override // defpackage.ka0
    public /* synthetic */ Set t() {
        return dw2.i(this);
    }

    @Override // defpackage.ka0
    public /* synthetic */ Object u(pg pgVar) {
        return dw2.m(this, pgVar);
    }

    @Override // defpackage.ka0
    public /* synthetic */ Set y(pg pgVar) {
        return dw2.d(this, pgVar);
    }

    @Override // defpackage.az4
    public void g0() {
    }

    @Override // defpackage.az4
    public void Y(qx qxVar) {
    }

    @Override // defpackage.az4
    public void d(TotalCaptureResult totalCaptureResult) {
    }

    public /* synthetic */ zf2(int i, boolean z2) {
        this.b = i;
    }

    public zf2(ConstraintLayout constraintLayout, ImageView imageView) {
        this.b = 19;
        this.f = imageView;
    }

    public zf2(r60 r60Var) {
        this.b = 14;
        Charset charset = j12.a;
        this.f = r60Var;
        r60Var.a = this;
    }

    public zf2(ConstraintLayout constraintLayout, MaterialButton materialButton, TextInputLayout textInputLayout) {
        this.b = 18;
        this.f = textInputLayout;
    }

    public zf2(boolean z2) {
        this.b = 6;
        this.f = new AtomicBoolean(z2);
    }

    public zf2(CodeEditor codeEditor) {
        this.b = 20;
        this.f = codeEditor;
        new k61(codeEditor.C0).e(ag0.class, new jd(10, this));
    }

    public zf2(oj1 oj1Var) {
        this.b = 26;
        this.f = (CaptureSessionOnClosedNotCalledQuirk) oj1Var.z(CaptureSessionOnClosedNotCalledQuirk.class);
    }

    public /* synthetic */ zf2(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }
}
