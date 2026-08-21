package defpackage;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wk1 implements tg4 {
    public final /* synthetic */ View a;
    public final /* synthetic */ ArrayList b;

    public wk1(View view, ArrayList arrayList) {
        this.a = view;
        this.b = arrayList;
    }

    @Override // defpackage.tg4
    public final void a(vg4 vg4Var) {
        vg4Var.E(this);
        vg4Var.a(this);
    }

    @Override // defpackage.tg4
    public final void c(vg4 vg4Var) {
        vg4Var.E(this);
        this.a.setVisibility(8);
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((View) arrayList.get(i)).setVisibility(0);
        }
    }

    @Override // defpackage.tg4
    public final void d(vg4 vg4Var) {
        a(vg4Var);
    }

    @Override // defpackage.tg4
    public final void e(vg4 vg4Var) {
        c(vg4Var);
    }

    @Override // defpackage.tg4
    public final void b(vg4 vg4Var) {
    }

    @Override // defpackage.tg4
    public final void f(vg4 vg4Var) {
    }

    @Override // defpackage.tg4
    public final void g(vg4 vg4Var) {
    }
}
