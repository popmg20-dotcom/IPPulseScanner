package defpackage;

import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sq4 extends vq4 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ViewPager2 b;

    public /* synthetic */ sq4(ViewPager2 viewPager2, int i) {
        this.a = i;
        this.b = viewPager2;
    }

    @Override // defpackage.vq4
    public void a(int i) {
        switch (this.a) {
            case 0:
                if (i == 0) {
                    this.b.e();
                }
                break;
        }
    }

    @Override // defpackage.vq4
    public final void c(int i) {
        int i2 = this.a;
        ViewPager2 viewPager2 = this.b;
        switch (i2) {
            case 0:
                if (viewPager2.A != i) {
                    viewPager2.A = i;
                    viewPager2.N0.e();
                }
                break;
            default:
                viewPager2.clearFocus();
                if (viewPager2.hasFocus()) {
                    viewPager2.D0.requestFocus(2);
                }
                break;
        }
    }
}
