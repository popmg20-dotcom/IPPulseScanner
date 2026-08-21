package defpackage;

import android.view.View;
import android.view.Window;
import androidx.fragment.app.o;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kj1 extends pj1 implements yu2, mv2, fv2, gv2, pq4, xu2, y4, kp3, ek1, qk2 {
    public final /* synthetic */ ca X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kj1(ca caVar) {
        super(caVar);
        this.X = caVar;
    }

    @Override // defpackage.xu2
    public final wu2 b() {
        return this.X.b();
    }

    @Override // defpackage.gv2
    public final void c(dd0 dd0Var) {
        this.X.c(dd0Var);
    }

    @Override // defpackage.fv2
    public final void d(dd0 dd0Var) {
        this.X.d(dd0Var);
    }

    @Override // defpackage.mj1
    public final View e(int i) {
        return this.X.findViewById(i);
    }

    @Override // defpackage.mv2
    public final void f(dd0 dd0Var) {
        this.X.f(dd0Var);
    }

    @Override // defpackage.y4
    public final x4 g() {
        return this.X.z0;
    }

    @Override // defpackage.da2
    public final r92 getLifecycle() {
        return this.X.N0;
    }

    @Override // defpackage.kp3
    public final hp3 getSavedStateRegistry() {
        return this.X.A.b;
    }

    @Override // defpackage.pq4
    public final oq4 getViewModelStore() {
        return this.X.getViewModelStore();
    }

    @Override // defpackage.mv2
    public final void h(dd0 dd0Var) {
        this.X.h(dd0Var);
    }

    @Override // defpackage.mj1
    public final boolean i() {
        Window window = this.X.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // defpackage.qk2
    public final void j(sj1 sj1Var) {
        this.X.j(sj1Var);
    }

    @Override // defpackage.yu2
    public final void l(dd0 dd0Var) {
        this.X.l(dd0Var);
    }

    @Override // defpackage.yu2
    public final void m(dd0 dd0Var) {
        this.X.m(dd0Var);
    }

    @Override // defpackage.qk2
    public final void n(sj1 sj1Var) {
        this.X.n(sj1Var);
    }

    @Override // defpackage.gv2
    public final void o(dd0 dd0Var) {
        this.X.o(dd0Var);
    }

    @Override // defpackage.fv2
    public final void p(dd0 dd0Var) {
        this.X.p(dd0Var);
    }

    @Override // defpackage.ek1
    public final void a(o oVar) {
    }
}
