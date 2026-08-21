package defpackage;

import android.content.SharedPreferences;
import com.getsurfboard.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.io.IOException;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ue1 implements pk3, b1 {
    public static final te1 X = new te1();
    public Object A;
    public Object b;
    public boolean f;
    public Object z;

    public ue1(cn cnVar, int i) throws qi1 {
        switch (i) {
            case 1:
                int i2 = cnVar.f;
                if (i2 < 21 || (i2 & 3) != 1) {
                    throw qi1.a();
                }
                this.b = cnVar;
                return;
            default:
                this.b = cnVar;
                this.z = new ArrayList();
                this.A = new int[5];
                return;
        }
    }

    public static IOException a(ue1 ue1Var, boolean z, IOException iOException, int i) {
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 8) == 0;
        if (iOException != null) {
            ue1Var.z(iOException);
        }
        return ((le3) ue1Var.b).h(ue1Var, z3 && !z, z2 && !z, z2 && z, z3 && z, iOException);
    }

    public static float c(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static boolean i(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i < 5) {
                int i3 = iArr[i];
                if (i3 == 0) {
                    break;
                }
                i2 += i3;
                i++;
            } else if (i2 >= 7) {
                float f = i2 / 7.0f;
                float f2 = f / 2.0f;
                if (Math.abs(f - iArr[0]) >= f2 || Math.abs(f - iArr[1]) >= f2 || Math.abs((f * 3.0f) - iArr[2]) >= 3.0f * f2 || Math.abs(f - iArr[3]) >= f2 || Math.abs(f - iArr[4]) >= f2) {
                    break;
                }
                return true;
            }
        }
        return false;
    }

    public static double y(re1 re1Var, re1 re1Var2) {
        double d = re1Var.a - re1Var2.a;
        double d2 = re1Var.b - re1Var2.b;
        return (d2 * d2) + (d * d);
    }

    public eg0 A() throws SocketException {
        le3 le3Var = (le3) this.b;
        if (le3Var.z0) {
            xe.q("Check failed.");
            return null;
        }
        le3Var.z0 = true;
        le3Var.A.i();
        synchronized (le3Var) {
            if (le3Var.H0 == null) {
                throw new IllegalStateException("Check failed.");
            }
            if (le3Var.D0 || le3Var.E0) {
                throw new IllegalStateException("Check failed.");
            }
            if (le3Var.B0) {
                throw new IllegalStateException("Check failed.");
            }
            if (!le3Var.C0) {
                throw new IllegalStateException("Check failed.");
            }
            le3Var.C0 = false;
            le3Var.D0 = true;
            le3Var.E0 = true;
        }
        q61 q61VarJ = ((r61) this.A).j();
        q61VarJ.getClass();
        me3 me3Var = (me3) q61VarJ;
        me3Var.e.setSoTimeout(0);
        me3Var.d();
        return new eg0(this);
    }

    public String B() {
        if (!this.f) {
            this.f = true;
            l75 l75Var = (l75) this.A;
            this.z = l75Var.Z0().getString((String) this.b, null);
        }
        return (String) this.z;
    }

    public void C(String str) {
        SharedPreferences.Editor editorEdit = ((l75) this.A).Z0().edit();
        editorEdit.putString((String) this.b, str);
        editorEdit.apply();
        this.z = str;
    }

    public yn1 b() {
        this.f = true;
        return l();
    }

    @Override // defpackage.b1
    public void d() {
        q();
    }

    public void e(boolean z) {
        jv0 jv0Var = (jv0) this.A;
        synchronized (jv0Var) {
            try {
                if (this.f) {
                    throw new IllegalStateException("editor is closed");
                }
                if (n12.c(((gv0) this.b).g, this)) {
                    jv0Var.g(this, z);
                }
                this.f = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.pk3
    public void f(ns4 ns4Var) {
        boolean z = this.f;
        ma1 ma1Var = (ma1) this.b;
        ns4Var.getClass();
        if (ns4Var instanceof mt3) {
            Map map = (Map) ns4Var.b.d;
            String str = map != null ? (String) map.get("location") : null;
            if (str != null) {
                ma1Var.k((String) this.A, str, (aa1) this.z, z);
                return;
            }
        }
        if (ma1Var.getContext() == null || ma1Var.b == null) {
            return;
        }
        CharSequence text = ma1Var.getText(R.string.unknown_error);
        text.getClass();
        CharSequence charSequenceU = ji0.u(ns4Var, text);
        wh2 wh2Var = new wh2(ma1Var.requireContext());
        p6 p6Var = (p6) wh2Var.z;
        wh2Var.x(R.string.update_failed);
        p6Var.g = charSequenceU;
        int i = 1;
        wh2Var.w(R.string.i_got_it, new ph0(i));
        wh2Var.v(R.string.copy_message, new li(4, charSequenceU, ma1Var));
        int i2 = 0;
        p6Var.p = new ja1(i2);
        p6Var.o = new ka1(i2);
        u6 u6VarH = wh2Var.h();
        u6VarH.setOnShowListener(new ai0(i));
        u6VarH.show();
        if (z) {
            return;
        }
        cm2 cm2Var = ma1Var.b;
        cm2Var.getClass();
        ((LinearProgressIndicator) cm2Var.X).b();
    }

    public int g(int i, int i2, int i3) {
        boolean z = this.f;
        cn cnVar = (cn) this.b;
        return z ? cnVar.b(i2, i) : cnVar.b(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public u03 h(int i) {
        u03 u03Var;
        jv0 jv0Var = (jv0) this.A;
        synchronized (jv0Var) {
            if (this.f) {
                throw new IllegalStateException("editor is closed");
            }
            ((boolean[]) this.z)[i] = true;
            Object obj = ((gv0) this.b).d.get(i);
            iv0 iv0Var = jv0Var.G0;
            u03 u03Var2 = (u03) obj;
            if (!iv0Var.F(u03Var2)) {
                j.a(iv0Var.U(u03Var2));
            }
            u03Var = (u03) obj;
        }
        return u03Var;
    }

    public kn1 j() {
        kn1 kn1Var = (kn1) this.z;
        if (kn1Var != null) {
            return kn1Var;
        }
        kn1 kn1Var2 = (kn1) ((yn1) this.A).t(this);
        this.z = kn1Var2;
        kn1Var2.v((yn1) this.A);
        kn1Var2.z = true;
        return kn1Var2;
    }

    public me3 k() {
        q61 q61VarJ = ((r61) this.A).j();
        me3 me3Var = q61VarJ instanceof me3 ? (me3) q61VarJ : null;
        if (me3Var != null) {
            return me3Var;
        }
        xe.q("no connection for CONNECT tunnels");
        return null;
    }

    public yn1 l() {
        yn1 yn1Var = (yn1) this.A;
        if (yn1Var != null) {
            return yn1Var;
        }
        yn1 yn1Var2 = (yn1) ((kn1) this.z).q();
        this.A = yn1Var2;
        return yn1Var2;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m(int r20, int r21, int[] r22) {
        /*
            Method dump skipped, instruction units count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ue1.m(int, int, int[]):boolean");
    }

    public boolean n() {
        ArrayList<re1> arrayList = (ArrayList) this.z;
        int size = arrayList.size();
        float fAbs = 0.0f;
        int i = 0;
        float f = 0.0f;
        for (re1 re1Var : arrayList) {
            if (re1Var.d >= 2) {
                i++;
                f += re1Var.c;
            }
        }
        if (i >= 3) {
            float f2 = f / size;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                fAbs += Math.abs(((re1) it.next()).c - f2);
            }
            if (fAbs <= f * 0.05f) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(defpackage.yn1 r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.z
            kn1 r0 = (defpackage.kn1) r0
            if (r0 != 0) goto L13
            java.lang.Object r0 = r2.A
            yn1 r0 = (defpackage.yn1) r0
            c1 r1 = r0.a()
            if (r0 != r1) goto L13
            r2.A = r3
            goto L1a
        L13:
            kn1 r0 = r2.j()
            r0.v(r3)
        L1a:
            r2.q()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ue1.o(yn1):void");
    }

    @Override // defpackage.pk3
    public void p(Object obj) {
        String str = (String) obj;
        str.getClass();
        ma1 ma1Var = (ma1) this.b;
        ji0.B(uf2.t(ma1Var), null, null, new kj0(ma1Var, (aa1) this.z, this.f, str, (String) this.A, (ge0) null), 3);
    }

    public void q() {
        b1 b1Var;
        if (((kn1) this.z) != null) {
            this.A = null;
        }
        if (!this.f || (b1Var = (b1) this.b) == null) {
            return;
        }
        b1Var.d();
        this.f = false;
    }

    public boolean r(int[] iArr) {
        ReentrantLock reentrantLock = (ReentrantLock) this.b;
        reentrantLock.lock();
        try {
            boolean z = false;
            for (int i : iArr) {
                long[] jArr = (long[]) this.z;
                long j = jArr[i];
                jArr[i] = 1 + j;
                if (j == 0) {
                    z = true;
                    this.f = true;
                }
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean s(int[] iArr) {
        iArr.getClass();
        ReentrantLock reentrantLock = (ReentrantLock) this.b;
        reentrantLock.lock();
        try {
            boolean z = false;
            for (int i : iArr) {
                long[] jArr = (long[]) this.z;
                long j = jArr[i];
                jArr[i] = j - 1;
                if (j == 1) {
                    z = true;
                    this.f = true;
                }
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public ri1 t() throws qi1 {
        ri1 ri1Var = (ri1) this.A;
        if (ri1Var != null) {
            return ri1Var;
        }
        int iG = 0;
        int iG2 = 0;
        for (int i = 0; i < 6; i++) {
            iG2 = g(i, 8, iG2);
        }
        int iG3 = g(8, 7, g(8, 8, g(7, 8, iG2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iG3 = g(8, i2, iG3);
        }
        int i3 = ((cn) this.b).f;
        int i4 = i3 - 7;
        for (int i5 = i3 - 1; i5 >= i4; i5--) {
            iG = g(8, i5, iG);
        }
        for (int i6 = i3 - 8; i6 < i3; i6++) {
            iG = g(i6, 8, iG);
        }
        ri1 ri1VarA = ri1.a(iG3, iG);
        if (ri1VarA == null) {
            ri1VarA = ri1.a(iG3 ^ 21522, iG ^ 21522);
        }
        this.A = ri1VarA;
        if (ri1VarA != null) {
            return ri1VarA;
        }
        throw qi1.a();
    }

    public jk3 u(boolean z) throws IOException {
        try {
            jk3 jk3VarD = ((r61) this.A).d(z);
            if (jk3VarD == null) {
                return jk3VarD;
            }
            jk3VarD.n = this;
            return jk3VarD;
        } catch (IOException e) {
            z(e);
            throw e;
        }
    }

    public wo4 v() throws qi1 {
        wo4 wo4Var = (wo4) this.z;
        if (wo4Var != null) {
            return wo4Var;
        }
        int i = ((cn) this.b).f;
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return wo4.c(i2);
        }
        int i3 = i - 11;
        int iG = 0;
        int iG2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = i - 9; i5 >= i3; i5--) {
                iG2 = g(i5, i4, iG2);
            }
        }
        wo4 wo4VarB = wo4.b(iG2);
        if (wo4VarB != null && (wo4VarB.a * 4) + 17 == i) {
            this.z = wo4VarB;
            return wo4VarB;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                iG = g(i6, i7, iG);
            }
        }
        wo4 wo4VarB2 = wo4.b(iG);
        if (wo4VarB2 == null || (wo4VarB2.a * 4) + 17 != i) {
            throw qi1.a();
        }
        this.z = wo4VarB2;
        return wo4VarB2;
    }

    public void w() {
        if (((ri1) this.A) == null) {
            return;
        }
        int i = fw.L(8)[((ri1) this.A).b];
        cn cnVar = (cn) this.b;
        int i2 = cnVar.f;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (ha0.b(i, i3, i4)) {
                    cnVar.a(i4, i3);
                }
            }
        }
    }

    public void x(yn1 yn1Var) {
        Charset charset = i12.a;
        yn1Var.getClass();
        this.A = yn1Var;
        kn1 kn1Var = (kn1) this.z;
        if (kn1Var != null) {
            kn1Var.b = null;
            this.z = null;
        }
        q();
    }

    public void z(IOException iOException) {
        this.f = true;
        ((r61) this.A).j().e((le3) this.b, iOException);
    }

    public ue1(yn1 yn1Var, oj1 oj1Var, boolean z) {
        Charset charset = i12.a;
        yn1Var.getClass();
        this.A = yn1Var;
        this.b = oj1Var;
        this.f = z;
    }

    public ue1(l75 l75Var, String str) {
        this.A = l75Var;
        tj4.f(str);
        this.b = str;
    }

    public ue1(Object obj, ju juVar) {
        this.f = false;
        this.b = obj;
        this.z = juVar;
        this.A = null;
    }

    public ue1(ns4 ns4Var) {
        this.f = false;
        this.b = null;
        this.z = null;
        this.A = ns4Var;
    }

    public ue1(jv0 jv0Var, gv0 gv0Var) {
        this.A = jv0Var;
        this.b = gv0Var;
        this.z = new boolean[2];
    }
}
