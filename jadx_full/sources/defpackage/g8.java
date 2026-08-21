package defpackage;

import android.graphics.drawable.Animatable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g8 extends ez4 {
    public final /* synthetic */ int k;
    public final Animatable l;

    public /* synthetic */ g8(Animatable animatable, int i) {
        this.k = i;
        this.l = animatable;
    }

    @Override // defpackage.ez4
    public final void V() {
        switch (this.k) {
            case 0:
                this.l.start();
                break;
            default:
                ((o8) this.l).start();
                break;
        }
    }

    @Override // defpackage.ez4
    public final void W() {
        switch (this.k) {
            case 0:
                this.l.stop();
                break;
            default:
                ((o8) this.l).stop();
                break;
        }
    }
}
