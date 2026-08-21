package defpackage;

import android.view.View;
import io.netty.channel.internal.ChannelUtils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cb2 {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public List k;
    public boolean l;

    public final void a(View view) {
        int iD;
        int size = this.k.size();
        View view2 = null;
        int i = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        for (int i2 = 0; i2 < size; i2++) {
            View view3 = ((rg3) this.k.get(i2)).a;
            bg3 bg3Var = (bg3) view3.getLayoutParams();
            if (view3 != view && !bg3Var.a.j() && (iD = (bg3Var.a.d() - this.d) * this.e) >= 0 && iD < i) {
                view2 = view3;
                if (iD == 0) {
                    break;
                } else {
                    i = iD;
                }
            }
        }
        if (view2 == null) {
            this.d = -1;
        } else {
            this.d = ((bg3) view2.getLayoutParams()).a.d();
        }
    }

    public final View b(ig3 ig3Var) {
        List list = this.k;
        if (list == null) {
            View viewD = ig3Var.d(this.d);
            this.d += this.e;
            return viewD;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view = ((rg3) this.k.get(i)).a;
            bg3 bg3Var = (bg3) view.getLayoutParams();
            if (!bg3Var.a.j() && this.d == bg3Var.a.d()) {
                a(view);
                return view;
            }
        }
        return null;
    }
}
