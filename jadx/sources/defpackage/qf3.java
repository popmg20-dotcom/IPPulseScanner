package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qf3 implements ou0 {
    public final /* synthetic */ RecyclerView b;

    public /* synthetic */ qf3(RecyclerView recyclerView) {
        this.b = recyclerView;
    }

    @Override // defpackage.ou0
    public boolean g(float f) {
        int i;
        int i2;
        RecyclerView recyclerView = this.b;
        if (recyclerView.H0.e()) {
            i2 = (int) f;
            i = 0;
        } else if (recyclerView.H0.d()) {
            i = (int) f;
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        recyclerView.t0();
        return recyclerView.K(i, i2, 0, ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
    }

    @Override // defpackage.ou0
    public float i() {
        float f;
        RecyclerView recyclerView = this.b;
        if (recyclerView.H0.e()) {
            f = recyclerView.t1;
        } else {
            if (!recyclerView.H0.d()) {
                return 0.0f;
            }
            f = recyclerView.s1;
        }
        return -f;
    }

    @Override // defpackage.ou0
    public void r() {
        this.b.t0();
    }
}
