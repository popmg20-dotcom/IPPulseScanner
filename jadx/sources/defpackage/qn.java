package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qn {
    public int h;
    public on i;
    public int j;
    public int k;
    public final ReentrantLock a = new ReentrantLock();
    public final ArrayList c = new ArrayList();
    public final int b = 1000;
    public int e = 0;
    public int f = 0;
    public on g = new on(this);
    public final ArrayList d = new ArrayList(10);

    public final void a(int i, int i2) {
        int i3;
        int[] iArr;
        on onVar;
        if (i < 0 || i > this.e) {
            StringBuilder sbD = dw2.D("index = ", i, ", length = ");
            sbD.append(this.e);
            throw new ArrayIndexOutOfBoundsException(sbD.toString());
        }
        b(i);
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.d;
            if (i4 >= arrayList.size()) {
                break;
            }
            if (((pn) arrayList.get(i4)).b >= i) {
                arrayList.remove(i4);
                i4--;
            }
            i4++;
        }
        on onVar2 = this.i;
        int i5 = this.h;
        while (true) {
            i3 = onVar2.b;
            iArr = onVar2.a;
            if (i5 <= i3 || (onVar = onVar2.d) == null) {
                break;
            }
            i5 -= i3;
            onVar2 = onVar;
        }
        System.arraycopy(iArr, i5, iArr, i5 + 1, i3 - i5);
        iArr[i5] = i2;
        int i6 = onVar2.b + 1;
        onVar2.b = i6;
        if (i2 > onVar2.c) {
            onVar2.c = i2;
        }
        this.e++;
        if (i6 > this.b) {
            on onVar3 = onVar2.d;
            qn qnVar = onVar2.e;
            ArrayList arrayList2 = qnVar.c;
            on onVar4 = arrayList2.isEmpty() ? new on(qnVar) : (on) arrayList2.remove(arrayList2.size() - 1);
            int i7 = (qnVar.b * 3) / 4;
            System.arraycopy(iArr, i7, onVar4.a, 0, onVar2.b - i7);
            onVar4.b = onVar2.b - i7;
            onVar2.b = i7;
            onVar2.d = onVar4;
            onVar4.d = onVar3;
            onVar2.a();
            onVar4.a();
        }
        this.f++;
    }

    public final void b(int i) {
        ArrayList arrayList;
        on onVar;
        int i2;
        on onVar2 = this.g;
        int i3 = 0;
        int i4 = i;
        int i5 = -1;
        int i6 = 0;
        while (true) {
            arrayList = this.d;
            if (i6 >= arrayList.size()) {
                break;
            }
            pn pnVar = (pn) arrayList.get(i6);
            int i7 = pnVar.b;
            if (i7 < i && (i2 = i - i7) < i4) {
                onVar2 = pnVar.a;
                i5 = i6;
                i4 = i2;
            }
            i6++;
        }
        if (i5 != -1) {
            Collections.swap(arrayList, 0, i5);
        }
        while (true) {
            int i8 = onVar2.b;
            if (i4 < i8 || (onVar = onVar2.d) == null) {
                break;
            }
            i4 -= i8;
            i3++;
            onVar2 = onVar;
        }
        if (i3 >= 30) {
            pn pnVar2 = new pn();
            pnVar2.b = i - i4;
            pnVar2.a = onVar2;
            arrayList.add(pnVar2);
        }
        if (arrayList.size() > 8) {
            arrayList.remove(arrayList.size() - 1);
        }
        this.h = i4;
        this.i = onVar2;
    }

    public final int c(int i) {
        if (i < 0 || i >= this.e) {
            StringBuilder sbD = dw2.D("index = ", i, ", length = ");
            sbD.append(this.e);
            throw new ArrayIndexOutOfBoundsException(sbD.toString());
        }
        b(i);
        on onVar = this.i;
        return onVar.a[this.h];
    }

    public final void d(int i, int i2) {
        if (i2 > this.e || i < 0 || i > i2) {
            throw new IndexOutOfBoundsException();
        }
        on onVar = this.g;
        on onVar2 = null;
        while (true) {
            int i3 = onVar.b;
            if (i < i3) {
                break;
            }
            i -= i3;
            i2 -= i3;
            onVar2 = onVar;
            onVar = onVar.d;
        }
        int i4 = i2 - i;
        int i5 = i4;
        while (i5 > 0) {
            if (i != 0 || i5 < onVar.b) {
                int iMin = Math.min(onVar.b, i5);
                int[] iArr = onVar.a;
                System.arraycopy(iArr, iMin, iArr, 0, onVar.b - iMin);
                onVar.b -= iMin;
                onVar.a();
                i5 -= iMin;
                onVar2 = onVar;
                onVar = onVar.d;
                i = 0;
            } else {
                if (onVar2 != null) {
                    onVar2.d = onVar.d;
                    this.c.add(onVar);
                }
                i5 -= onVar.b;
                onVar.b = 0;
                onVar = onVar.d;
            }
        }
        this.e -= i4;
    }

    public final void e(int i, int i2) {
        if (i < 0 || i >= this.e) {
            StringBuilder sbD = dw2.D("index = ", i, ", length = ");
            sbD.append(this.e);
            throw new ArrayIndexOutOfBoundsException(sbD.toString());
        }
        b(i);
        on onVar = this.i;
        int i3 = this.h;
        int[] iArr = onVar.a;
        int i4 = iArr[i3];
        iArr[i3] = i2;
        int i5 = onVar.c;
        if (i4 == i5) {
            if (i2 >= i4) {
                onVar.c = i2;
            } else {
                onVar.a();
            }
        } else if (i2 > i5) {
            onVar.c = i2;
        }
        this.f++;
    }
}
