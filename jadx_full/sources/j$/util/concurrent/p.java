package j$.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public class p {
    public l[] a;
    public l b = null;
    public o c;
    public o d;
    public int e;
    public int f;
    public int g;
    public final int h;

    public p(l[] lVarArr, int i, int i2, int i3) {
        this.a = lVarArr;
        this.h = i;
        this.e = i2;
        this.f = i2;
        this.g = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x005f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final l a() {
        l[] lVarArr;
        int length;
        int i;
        o oVar;
        l lVar = this.b;
        if (lVar != null) {
            lVar = lVar.d;
        }
        while (lVar == null) {
            if (this.f >= this.g || (lVarArr = this.a) == null || (length = lVarArr.length) <= (i = this.e) || i < 0) {
                this.b = null;
                return null;
            }
            l lVarK = ConcurrentHashMap.k(lVarArr, i);
            if (lVarK == null || lVarK.a >= 0) {
                lVar = lVarK;
                if (this.c == null) {
                    while (true) {
                        oVar = this.c;
                        if (oVar == null) {
                            break;
                        }
                        int i2 = this.e;
                        int i3 = oVar.a;
                        int i4 = i2 + i3;
                        this.e = i4;
                        if (i4 < length) {
                            break;
                        }
                        this.e = oVar.b;
                        this.a = oVar.c;
                        oVar.c = null;
                        o oVar2 = oVar.d;
                        oVar.d = this.d;
                        this.c = oVar2;
                        this.d = oVar;
                        length = i3;
                    }
                    if (oVar == null) {
                        int i5 = this.e + this.h;
                        this.e = i5;
                        if (i5 >= length) {
                            int i6 = this.f + 1;
                            this.f = i6;
                            this.e = i6;
                        }
                    }
                } else {
                    int i7 = i + this.h;
                    this.e = i7;
                    if (i7 >= length) {
                        int i8 = this.f + 1;
                        this.f = i8;
                        this.e = i8;
                    }
                }
            } else if (lVarK instanceof g) {
                this.a = ((g) lVarK).e;
                o oVar3 = this.d;
                if (oVar3 != null) {
                    this.d = oVar3.d;
                } else {
                    oVar3 = new o();
                }
                oVar3.c = lVarArr;
                oVar3.a = length;
                oVar3.b = i;
                oVar3.d = this.c;
                this.c = oVar3;
                lVar = null;
            } else {
                lVar = lVarK instanceof q ? ((q) lVarK).f : null;
                if (this.c == null) {
                }
            }
        }
        this.b = lVar;
        return lVar;
    }
}
