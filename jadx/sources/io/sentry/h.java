package io.sentry;

import defpackage.st4;
import defpackage.vp1;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Iterator {
    public final /* synthetic */ i A;
    public int b;
    public int f = -1;
    public boolean z;

    public h(i iVar) {
        this.A = iVar;
        this.b = iVar.f;
        this.z = iVar.A;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.z || this.b != this.A.z;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            vp1.g();
            return null;
        }
        this.z = false;
        int i = this.b;
        this.f = i;
        int i2 = i + 1;
        i iVar = this.A;
        this.b = i2 < iVar.X ? i2 : 0;
        return iVar.b[i];
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        i iVar = this.A;
        int i2 = iVar.X;
        Object[] objArr = iVar.b;
        int i3 = this.f;
        if (i3 == -1) {
            st4.g();
            return;
        }
        int i4 = iVar.f;
        if (i3 == i4) {
            iVar.remove();
            this.f = -1;
            return;
        }
        int i5 = i3 + 1;
        if (i4 >= i3 || i5 >= (i = iVar.z)) {
            while (i5 != iVar.z) {
                if (i5 >= i2) {
                    objArr[i5 - 1] = objArr[0];
                } else {
                    int i6 = i5 - 1;
                    if (i6 < 0) {
                        i6 = i2 - 1;
                    }
                    objArr[i6] = objArr[i5];
                    i5++;
                    if (i5 >= i2) {
                    }
                }
                i5 = 0;
            }
        } else {
            System.arraycopy(objArr, i5, objArr, i3, i - i5);
        }
        this.f = -1;
        int i7 = iVar.z - 1;
        if (i7 < 0) {
            i7 = i2 - 1;
        }
        iVar.z = i7;
        objArr[i7] = null;
        iVar.A = false;
        int i8 = this.b - 1;
        if (i8 < 0) {
            i8 = i2 - 1;
        }
        this.b = i8;
    }
}
