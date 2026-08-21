package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class wd4 implements Iterator {
    public final /* synthetic */ int b;
    public int f;
    public final Object z;

    public wd4(Class cls) {
        this.b = 0;
        this.z = new Supplier[]{new v6(6), new ik(4, cls), new v6(7)};
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.b;
        Object obj = this.z;
        switch (i) {
            case 0:
                break;
            default:
                return this.f < ((h15) obj).l();
        }
        while (true) {
            int i2 = this.f;
            Supplier[] supplierArr = (Supplier[]) obj;
            if (i2 >= supplierArr.length) {
                return false;
            }
            if (((ClassLoader) supplierArr[i2].get()) != null) {
                return true;
            }
            this.f++;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        Object obj = this.z;
        switch (i) {
            case 0:
                int i2 = this.f;
                Supplier[] supplierArr = (Supplier[]) obj;
                if (i2 >= supplierArr.length) {
                    e04.h("All elements exhausted");
                    return null;
                }
                Supplier supplier = supplierArr[i2];
                this.f = i2 + 1;
                return (ClassLoader) supplier.get();
            default:
                h15 h15Var = (h15) obj;
                int i3 = this.f;
                int iL = h15Var.l();
                int i4 = this.f;
                if (i3 < iL) {
                    this.f = i4 + 1;
                    return h15Var.m(i4);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 21);
                sb.append("Out of bounds index: ");
                sb.append(i4);
                throw new NoSuchElementException(sb.toString());
        }
    }

    public wd4(h15 h15Var) {
        this.b = 1;
        this.z = h15Var;
        this.f = 0;
    }
}
