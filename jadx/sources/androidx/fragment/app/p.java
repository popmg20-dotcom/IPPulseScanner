package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import defpackage.ak1;
import defpackage.bl1;
import defpackage.c90;
import defpackage.ca;
import defpackage.d90;
import defpackage.dd0;
import defpackage.fa2;
import defpackage.i90;
import defpackage.kj1;
import defpackage.p92;
import defpackage.q92;
import defpackage.zf2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class p extends i90 {
    public final zf2 M0;
    public boolean O0;
    public boolean P0;
    public final fa2 N0 = new fa2(this);
    public boolean Q0 = true;

    public p() {
        final ca caVar = (ca) this;
        this.M0 = new zf2(27, new kj1(caVar));
        final int i = 1;
        this.A.b.c("android:support:lifecycle", new c90(i, caVar));
        final int i2 = 0;
        this.A0.add(new dd0() { // from class: jj1
            @Override // defpackage.dd0
            public final void accept(Object obj) {
                int i3 = i2;
                ca caVar2 = caVar;
                switch (i3) {
                    case 0:
                        caVar2.M0.n0();
                        break;
                    default:
                        caVar2.M0.n0();
                        break;
                }
            }
        });
        this.C0.add(new dd0() { // from class: jj1
            @Override // defpackage.dd0
            public final void accept(Object obj) {
                int i3 = i;
                ca caVar2 = caVar;
                switch (i3) {
                    case 0:
                        caVar2.M0.n0();
                        break;
                    default:
                        caVar2.M0.n0();
                        break;
                }
            }
        });
        r(new d90(caVar, i));
    }

    public static boolean v(u uVar) {
        boolean zV = false;
        for (o oVar : uVar.c.f()) {
            if (oVar != null) {
                if (oVar.getHost() != null) {
                    zV |= v(oVar.getChildFragmentManager());
                }
                bl1 bl1Var = oVar.mViewLifecycleOwner;
                q92 q92Var = q92.z;
                q92 q92Var2 = q92.A;
                if (bl1Var != null) {
                    bl1Var.c();
                    if (bl1Var.A.c.compareTo(q92Var2) >= 0) {
                        fa2 fa2Var = oVar.mViewLifecycleOwner.A;
                        fa2Var.e("setCurrentState");
                        fa2Var.g(q92Var);
                        zV = true;
                    }
                }
                if (oVar.mLifecycleRegistry.c.compareTo(q92Var2) >= 0) {
                    fa2 fa2Var2 = oVar.mLifecycleRegistry;
                    fa2Var2.e("setCurrentState");
                    fa2Var2.g(q92Var);
                    zV = true;
                }
            }
        }
        return zV;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dump(java.lang.String r7, java.io.FileDescriptor r8, java.io.PrintWriter r9, java.lang.String[] r10) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.p.dump(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    @Override // defpackage.i90, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        this.M0.n0();
        super.onActivityResult(i, i2, intent);
    }

    @Override // defpackage.i90, defpackage.h90, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.N0.f(p92.ON_CREATE);
        ak1 ak1Var = ((kj1) this.M0.f).A;
        ak1Var.I = false;
        ak1Var.J = false;
        ak1Var.P.g = false;
        ak1Var.u(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((kj1) this.M0.f).A.f.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((kj1) this.M0.f).A.l();
        this.N0.f(p92.ON_DESTROY);
    }

    @Override // defpackage.i90, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return ((kj1) this.M0.f).A.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        this.P0 = false;
        ((kj1) this.M0.f).A.u(5);
        this.N0.f(p92.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.N0.f(p92.ON_RESUME);
        ak1 ak1Var = ((kj1) this.M0.f).A;
        ak1Var.I = false;
        ak1Var.J = false;
        ak1Var.P.g = false;
        ak1Var.u(7);
    }

    @Override // defpackage.i90, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.M0.n0();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final void onResume() {
        zf2 zf2Var = this.M0;
        zf2Var.n0();
        super.onResume();
        this.P0 = true;
        ((kj1) zf2Var.f).A.z(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        zf2 zf2Var = this.M0;
        zf2Var.n0();
        kj1 kj1Var = (kj1) zf2Var.f;
        super.onStart();
        this.Q0 = false;
        if (!this.O0) {
            this.O0 = true;
            ak1 ak1Var = kj1Var.A;
            ak1Var.I = false;
            ak1Var.J = false;
            ak1Var.P.g = false;
            ak1Var.u(4);
        }
        kj1Var.A.z(true);
        this.N0.f(p92.ON_START);
        ak1 ak1Var2 = kj1Var.A;
        ak1Var2.I = false;
        ak1Var2.J = false;
        ak1Var2.P.g = false;
        ak1Var2.u(5);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.M0.n0();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.Q0 = true;
        while (v(u())) {
        }
        ak1 ak1Var = ((kj1) this.M0.f).A;
        ak1Var.J = true;
        ak1Var.P.g = true;
        ak1Var.u(4);
        this.N0.f(p92.ON_STOP);
    }

    public final ak1 u() {
        return ((kj1) this.M0.f).A;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((kj1) this.M0.f).A.f.onCreateView(view, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewOnCreateView;
    }
}
