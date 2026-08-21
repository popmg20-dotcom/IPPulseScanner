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
    */
    public pk0 k0(ue1 ue1Var) throws d40, qi1 {
        int iC;
        lm2 lm2Var;
        int i;
        boolean z2;
        String str;
        int iC2;
        wo4 wo4VarV = ue1Var.v();
        int i2 = ue1Var.t().a;
        ri1 ri1VarT = ue1Var.t();
        wo4 wo4VarV2 = ue1Var.v();
        int i3 = fw.L(8)[ri1VarT.b];
        cn cnVar = (cn) ue1Var.b;
        int i4 = cnVar.f;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                if (ha0.b(i3, i6, i7)) {
                    cnVar.a(i7, i6);
                }
            }
        }
        int i8 = wo4VarV2.a * 4;
        int i9 = i8 + 17;
        int i10 = wo4VarV2.d;
        cn cnVar2 = new cn(i9, i9);
        cnVar2.g(0, 0, 9, 9);
        int i11 = i8 + 9;
        cnVar2.g(i11, 0, 8, 9);
        cnVar2.g(0, i11, 9, 8);
        int[] iArr = wo4VarV2.b;
        int length = iArr.length;
        int i12 = 0;
        while (i12 < length) {
            int i13 = iArr[i12] - 2;
            for (int i14 = i5; i14 < length; i14++) {
                if ((i12 != 0 || (i14 != 0 && i14 != length - 1)) && (i12 != length - 1 || i14 != 0)) {
                    cnVar2.g(iArr[i14] - 2, i13, 5, 5);
                }
            }
            i12++;
            i5 = 0;
        }
        int i15 = 2;
        int i16 = 6;
        int i17 = 1;
        cnVar2.g(6, 9, 1, i8);
        cnVar2.g(9, 6, i8, 1);
        if (wo4VarV2.a > 6) {
            int i18 = i8 + 6;
            cnVar2.g(i18, 0, 3, 6);
            cnVar2.g(0, i18, 6, 3);
        }
        byte[] bArr = new byte[i10];
        int i19 = i4 - 1;
        int i20 = i19;
        boolean z3 = true;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        while (i20 > 0) {
            if (i20 == i16) {
                i20--;
            }
            int i24 = 0;
            while (i24 < i4) {
                int i25 = z3 ? i19 - i24 : i24;
                int i26 = i17;
                int i27 = 0;
                for (int i28 = i15; i27 < i28; i28 = 2) {
                    int i29 = i20 - i27;
                    if (!cnVar2.b(i29, i25)) {
                        i22++;
                        i23 <<= 1;
                        if (cnVar.b(i29, i25)) {
                            i23 |= 1;
                        }
                        if (i22 == 8) {
                            bArr[i21] = (byte) i23;
                            i21++;
                            i22 = 0;
                            i23 = 0;
                        }
                    }
                    i27++;
                }
                i24++;
                i17 = i26;
                i15 = 2;
            }
            z3 = !z3;
            i20 -= 2;
            i16 = 6;
            i15 = 2;
        }
        int i30 = i17;
        if (i21 != i10) {
            throw qi1.a();
        }
        if (i10 != wo4VarV.d) {
            s53.d();
            return null;
        }
        t6 t6Var = wo4VarV.c[fw.G(i2)];
        hm2[] hm2VarArr = (hm2[]) t6Var.z;
        int i31 = t6Var.f;
        int i32 = 0;
        for (hm2 hm2Var : hm2VarArr) {
            i32 += hm2Var.b;
        }
        gi0[] gi0VarArr = new gi0[i32];
        int length2 = hm2VarArr.length;
        int i33 = 0;
        int i34 = 0;
        while (i34 < length2) {
            hm2 hm2Var2 = hm2VarArr[i34];
            int i35 = 0;
            while (i35 < hm2Var2.b) {
                int i36 = hm2Var2.c;
                gi0VarArr[i33] = new gi0(i36, 0, new byte[i31 + i36]);
                i35++;
                i33++;
                bArr = bArr;
            }
            i34++;
            bArr = bArr;
        }
        byte[] bArr2 = bArr;
        int length3 = gi0VarArr[0].c.length;
        int i37 = i32 - 1;
        while (i37 >= 0 && gi0VarArr[i37].c.length != length3) {
            i37--;
        }
        int i38 = i37 + 1;
        int i39 = length3 - i31;
        int i40 = 0;
        for (int i41 = 0; i41 < i39; i41++) {
            int i42 = 0;
            while (i42 < i33) {
                gi0VarArr[i42].c[i41] = bArr2[i40];
                i42++;
                i40++;
            }
        }
        int i43 = i38;
        while (i43 < i33) {
            gi0VarArr[i43].c[i39] = bArr2[i40];
            i43++;
            i40++;
        }
        int length4 = gi0VarArr[0].c.length;
        while (i39 < length4) {
            int i44 = i40;
            int i45 = 0;
            while (i45 < i33) {
                gi0VarArr[i45].c[i45 < i38 ? i39 : i39 + 1] = bArr2[i44];
                i45++;
                i44++;
            }
            i39++;
            i40 = i44;
        }
        int i46 = 0;
        for (int i47 = 0; i47 < i32; i47++) {
            i46 += gi0VarArr[i47].b;
        }
        byte[] bArr3 = new byte[i46];
        int i48 = 0;
        int i49 = 0;
        int i50 = 0;
        while (i49 < i32) {
            gi0 gi0Var = gi0VarArr[i49];
            byte[] bArr4 = gi0Var.c;
            int i51 = gi0Var.b;
            int length5 = bArr4.length;
            int[] iArr2 = new int[length5];
            for (int i52 = 0; i52 < length5; i52++) {
                iArr2[i52] = bArr4[i52] & 255;
            }
            try {
                int iW = ((ha1) this.f).w(iArr2, bArr4.length - i51);
                for (int i53 = 0; i53 < i51; i53++) {
                    bArr4[i53] = (byte) iArr2[i53];
                }
                i48 += iW;
                int i54 = i50;
                int i55 = 0;
                while (i55 < i51) {
                    bArr3[i54] = bArr4[i55];
                    i55++;
                    i54++;
                }
                i49++;
                i50 = i54;
            } catch (wg3 unused) {
                throw d40.a();
            }
        }
        boolean z4 = false;
        en enVar = new en(bArr3, 0);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(i30);
        boolean z5 = false;
        int iC3 = -1;
        int iC4 = -1;
        x30 x30VarA = null;
        boolean z6 = false;
        while (true) {
            try {
                int iA = enVar.a();
                lm2 lm2Var2 = lm2.TERMINATOR;
                if (iA < 4 || (iC = enVar.c(4)) == 0) {
                    lm2Var = lm2Var2;
                } else if (iC == 1) {
                    lm2Var = lm2.NUMERIC;
                } else if (iC == 2) {
                    lm2Var = lm2.ALPHANUMERIC;
                } else if (iC == 3) {
                    lm2Var = lm2.STRUCTURED_APPEND;
                } else if (iC == 4) {
                    lm2Var = lm2.BYTE;
                } else if (iC == 5) {
                    lm2Var = lm2.FNC1_FIRST_POSITION;
                } else if (iC == 7) {
                    lm2Var = lm2.ECI;
                } else if (iC == 8) {
                    lm2Var = lm2.KANJI;
                } else if (iC == 9) {
                    lm2Var = lm2.FNC1_SECOND_POSITION;
                } else {
                    if (iC != 13) {
                        throw new IllegalArgumentException();
                    }
                    lm2Var = lm2.HANZI;
                }
                int iOrdinal = lm2Var.ordinal();
                if (iOrdinal != 0) {
                    i = i48;
                    if (iOrdinal != 3) {
                        if (iOrdinal == 5) {
                            boolean z7 = z4;
                            int iC5 = enVar.c(8);
                            if ((iC5 & 128) == 0) {
                                iC2 = iC5 & 127;
                            } else if ((iC5 & 192) == 128) {
                                iC2 = ((iC5 & 63) << 8) | enVar.c(8);
                            } else {
                                if ((iC5 & 224) != 192) {
                                    throw qi1.a();
                                }
                                iC2 = ((iC5 & 31) << 16) | enVar.c(16);
                            }
                            x30VarA = x30.a(iC2);
                            if (x30VarA == null) {
                                throw qi1.a();
                            }
                            z4 = z7;
                        } else if (iOrdinal == 7) {
                            z4 = true;
                            z6 = true;
                        } else if (iOrdinal == 8) {
                            z6 = true;
                            z5 = true;
                            if (lm2Var != lm2Var2) {
                                int i56 = x30VarA != null ? z4 ? 4 : z5 ? 6 : 2 : z4 ? 3 : z5 ? 5 : 1;
                                int i57 = iC3;
                                String string = sb.toString();
                                if (arrayList.isEmpty()) {
                                    arrayList = null;
                                }
                                if (i2 == 1) {
                                    str = "L";
                                } else if (i2 == 2) {
                                    str = "M";
                                } else if (i2 == 3) {
                                    str = "Q";
                                } else {
                                    if (i2 != 4) {
                                        throw null;
                                    }
                                    str = "H";
                                }
                                pk0 pk0Var = new pk0(bArr3, string, arrayList, str, i57, iC4, i56);
                                pk0Var.e = Integer.valueOf(i);
                                return pk0Var;
                            }
                            i48 = i;
                        } else if (iOrdinal != 9) {
                            int iC6 = enVar.c(lm2Var.a(wo4VarV));
                            int iOrdinal2 = lm2Var.ordinal();
                            z2 = z4;
                            if (iOrdinal2 == 1) {
                                r25.q(enVar, sb, iC6);
                            } else if (iOrdinal2 == 2) {
                                r25.m(enVar, sb, iC6, z6);
                            } else if (iOrdinal2 == 4) {
                                r25.n(enVar, sb, iC6, x30VarA, arrayList);
                            } else {
                                if (iOrdinal2 != 6) {
                                    throw qi1.a();
                                }
                                r25.p(enVar, sb, iC6);
                            }
                        } else {
                            z2 = z4;
                            int iC7 = enVar.c(4);
                            int iC8 = enVar.c(lm2Var.a(wo4VarV));
                            if (iC7 == 1) {
                                r25.o(enVar, sb, iC8);
                            }
                        }
                        if (lm2Var != lm2Var2) {
                        }
                    } else {
                        z2 = z4;
                        if (enVar.a() < 16) {
                            throw qi1.a();
                        }
                        iC3 = enVar.c(8);
                        iC4 = enVar.c(8);
                        z4 = z2;
                        if (lm2Var != lm2Var2) {
                        }
                    }
                } else {
                    i = i48;
                    z2 = z4;
                }
                z4 = z2;
                if (lm2Var != lm2Var2) {
                }
            } catch (IllegalArgumentException unused2) {
                throw qi1.a();
            }
        }
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
