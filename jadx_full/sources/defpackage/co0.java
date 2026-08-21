package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class co0 implements Iterator, z72 {
    public b12 A;
    public int X;
    public final /* synthetic */ do0 Y;
    public int b = -1;
    public int f;
    public int z;

    public co0(do0 do0Var) {
        this.Y = do0Var;
        int iU = gb4.u(0, 0, do0Var.a.length());
        this.f = iU;
        this.z = iU;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        do0 do0Var = this.Y;
        CharSequence charSequence = do0Var.a;
        int i = this.z;
        if (i < 0) {
            this.b = 0;
            this.A = null;
            return;
        }
        int i2 = do0Var.b;
        if (i2 > 0) {
            int i3 = this.X + 1;
            this.X = i3;
            if (i3 < i2) {
                if (i > charSequence.length()) {
                    int i4 = this.f;
                    charSequence.getClass();
                    this.A = new b12(i4, charSequence.length() - 1, 1);
                    this.z = -1;
                } else {
                    e03 e03Var = (e03) do0Var.c.k(charSequence, Integer.valueOf(this.z));
                    if (e03Var == null) {
                        int i5 = this.f;
                        charSequence.getClass();
                        this.A = new b12(i5, charSequence.length() - 1, 1);
                        this.z = -1;
                    } else {
                        int iIntValue = ((Number) e03Var.b).intValue();
                        int iIntValue2 = ((Number) e03Var.f).intValue();
                        this.A = gb4.d0(this.f, iIntValue);
                        int i6 = iIntValue + iIntValue2;
                        this.f = i6;
                        this.z = i6 + (iIntValue2 == 0 ? 1 : 0);
                    }
                }
            }
        }
        this.b = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b == -1) {
            a();
        }
        return this.b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b == -1) {
            a();
        }
        if (this.b == 0) {
            vp1.g();
            return null;
        }
        b12 b12Var = this.A;
        b12Var.getClass();
        this.A = null;
        this.b = -1;
        return b12Var;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
