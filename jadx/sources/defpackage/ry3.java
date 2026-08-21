package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ry3 extends fg3 {
    public boolean a = false;
    public final /* synthetic */ xq4 b;

    public ry3(xq4 xq4Var) {
        this.b = xq4Var;
    }

    @Override // defpackage.fg3
    public final void a(RecyclerView recyclerView, int i) {
        if (i == 0 && this.a) {
            this.a = false;
            this.b.g();
        }
    }

    @Override // defpackage.fg3
    public final void b(RecyclerView recyclerView, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.a = true;
    }
}
