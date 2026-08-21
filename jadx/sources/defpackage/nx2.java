package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class nx2 extends fg3 {
    @Override // defpackage.fg3
    public final void b(RecyclerView recyclerView, int i, int i2) {
        if (i2 == 0 && i == 0) {
            recyclerView.setOverScrollMode(recyclerView.computeVerticalScrollRange() > recyclerView.getHeight() ? 0 : 2);
        }
    }

    @Override // defpackage.fg3
    public final void a(RecyclerView recyclerView, int i) {
    }
}
