package defpackage;

import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t10 extends i22 {
    public final /* synthetic */ int d;
    public final /* synthetic */ CarouselLayoutManager e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t10(CarouselLayoutManager carouselLayoutManager, int i) {
        super(1);
        this.d = i;
        switch (i) {
            case 1:
                this.e = carouselLayoutManager;
                super(0);
                break;
            default:
                this.e = carouselLayoutManager;
                break;
        }
    }

    @Override // defpackage.i22
    public final int e() {
        int i = this.d;
        CarouselLayoutManager carouselLayoutManager = this.e;
        switch (i) {
            case 0:
                return carouselLayoutManager.o;
            default:
                return carouselLayoutManager.o - carouselLayoutManager.G();
        }
    }

    @Override // defpackage.i22
    public final int f() {
        switch (this.d) {
            case 0:
                return this.e.H();
            default:
                return 0;
        }
    }

    @Override // defpackage.i22
    public final int g() {
        int i = this.d;
        CarouselLayoutManager carouselLayoutManager = this.e;
        switch (i) {
            case 0:
                return carouselLayoutManager.n - carouselLayoutManager.I();
            default:
                return carouselLayoutManager.n;
        }
    }

    @Override // defpackage.i22
    public final int h() {
        switch (this.d) {
            case 0:
                return 0;
            default:
                CarouselLayoutManager carouselLayoutManager = this.e;
                if (carouselLayoutManager.L0()) {
                    return carouselLayoutManager.n;
                }
                return 0;
        }
    }

    @Override // defpackage.i22
    public final int i() {
        switch (this.d) {
            case 0:
                return 0;
            default:
                return this.e.J();
        }
    }
}
