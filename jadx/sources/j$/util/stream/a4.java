package j$.util.stream;

import j$.util.Spliterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class a4 extends t3 {
    public final /* synthetic */ int h;

    public /* synthetic */ a4(int i) {
        this.h = i;
    }

    @Override // j$.util.stream.t3
    public final o4 Y() {
        switch (this.h) {
            case 0:
                return new s4();
            case 1:
                return new q4();
            case 2:
                return new t4();
            default:
                return new r4();
        }
    }

    @Override // j$.util.stream.t3, j$.util.stream.c8
    public final Object a(a aVar, Spliterator spliterator) {
        switch (this.h) {
            case 0:
                if (!w6.SIZED.k(aVar.f)) {
                }
                break;
            case 1:
                if (!w6.SIZED.k(aVar.f)) {
                }
                break;
            case 2:
                if (!w6.SIZED.k(aVar.f)) {
                }
                break;
            default:
                if (!w6.SIZED.k(aVar.f)) {
                }
                break;
        }
        return (Long) super.a(aVar, spliterator);
    }

    @Override // j$.util.stream.t3, j$.util.stream.c8
    public final Object b(a aVar, Spliterator spliterator) {
        switch (this.h) {
            case 0:
                if (!w6.SIZED.k(aVar.f)) {
                }
                break;
            case 1:
                if (!w6.SIZED.k(aVar.f)) {
                }
                break;
            case 2:
                if (!w6.SIZED.k(aVar.f)) {
                }
                break;
            default:
                if (!w6.SIZED.k(aVar.f)) {
                }
                break;
        }
        return (Long) super.b(aVar, spliterator);
    }

    @Override // j$.util.stream.t3, j$.util.stream.c8
    public final int f() {
        switch (this.h) {
        }
        return w6.r;
    }
}
