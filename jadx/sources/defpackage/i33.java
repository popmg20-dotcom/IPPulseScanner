package defpackage;

import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i33 extends tf3 {
    public final m33 a;
    public final RecyclerView b;
    public final Preference c;
    public final String d;

    public i33(m33 m33Var, RecyclerView recyclerView, Preference preference, String str) {
        this.a = m33Var;
        this.b = recyclerView;
        this.c = preference;
        this.d = str;
    }

    @Override // defpackage.tf3
    public final void a() {
        h();
    }

    @Override // defpackage.tf3
    public final void b() {
        h();
    }

    @Override // defpackage.tf3
    public final void c(int i, int i2, Object obj) {
        h();
    }

    @Override // defpackage.tf3
    public final void d(int i, int i2) {
        h();
    }

    @Override // defpackage.tf3
    public final void e(int i, int i2) {
        h();
    }

    @Override // defpackage.tf3
    public final void f(int i, int i2) {
        h();
    }

    public final void h() {
        m33 m33Var = this.a;
        m33Var.p(this);
        Preference preference = this.c;
        int iT = preference != null ? m33Var.t(preference) : m33Var.u(this.d);
        if (iT != -1) {
            this.b.l0(iT);
        }
    }
}
