package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f25 implements Iterator {
    public final /* synthetic */ int b;
    public int f = 0;
    public final /* synthetic */ i25 z;

    public /* synthetic */ f25(i25 i25Var, int i) {
        this.b = i;
        this.z = i25Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.b;
        i25 i25Var = this.z;
        switch (i) {
            case 0:
                if (this.f < i25Var.b.length()) {
                }
                break;
            default:
                if (this.f < i25Var.b.length()) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        int i = this.b;
        i25 i25Var = this.z;
        switch (i) {
            case 0:
                String str = i25Var.b;
                int i2 = this.f;
                if (i2 >= str.length()) {
                    vp1.g();
                } else {
                    this.f = i2 + 1;
                }
                break;
            default:
                String str2 = i25Var.b;
                int i3 = this.f;
                if (i3 >= str2.length()) {
                    vp1.g();
                } else {
                    this.f = i3 + 1;
                }
                break;
        }
        return null;
    }
}
