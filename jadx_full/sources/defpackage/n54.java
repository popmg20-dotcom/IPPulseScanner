package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n54 implements Parcelable {
    public static final Parcelable.Creator<n54> CREATOR = new ym3(22);
    public static final m54 z = new m54("");
    public final m54 b;
    public int f;

    public /* synthetic */ n54() {
        this(new m54(""), 0);
    }

    public final void a(String str) {
        int i;
        int i2;
        str.getClass();
        String string = p44.U0(str).toString();
        int i3 = 0;
        if (w44.j0(string, "#", false) || w44.j0(string, ";", false)) {
            return;
        }
        Iterator it = yr2.l(string).iterator();
        m54 m54Var = this.b;
        while (it.hasNext()) {
            String strIntern = ((String) it.next()).intern();
            strIntern.getClass();
            ArrayList arrayList = m54Var.f;
            int size = arrayList.size();
            e70.N(arrayList.size(), size);
            int i4 = size - 1;
            int i5 = 0;
            while (true) {
                if (i5 > i4) {
                    i2 = -(i5 + 1);
                    break;
                }
                i2 = (i5 + i4) >>> 1;
                int iF = ye.f(((m54) arrayList.get(i2)).b, strIntern);
                if (iF >= 0) {
                    if (iF <= 0) {
                        break;
                    } else {
                        i4 = i2 - 1;
                    }
                } else {
                    i5 = i2 + 1;
                }
            }
            if (i2 < 0) {
                m54 m54Var2 = new m54(strIntern);
                arrayList.add(-(i2 + 1), m54Var2);
                m54Var = m54Var2;
            } else {
                m54Var = (m54) arrayList.get(i2);
            }
        }
        ArrayList arrayList2 = m54Var.f;
        int size2 = arrayList2.size();
        e70.N(arrayList2.size(), size2);
        int i6 = size2 - 1;
        while (true) {
            if (i3 > i6) {
                i = -(i3 + 1);
                break;
            }
            i = (i3 + i6) >>> 1;
            int iF2 = ye.f(((m54) arrayList2.get(i)).b, "");
            if (iF2 >= 0) {
                if (iF2 <= 0) {
                    break;
                } else {
                    i6 = i - 1;
                }
            } else {
                i3 = i + 1;
            }
        }
        if (i < 0) {
            m54Var.f.add(-(i + 1), z);
            this.f++;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!n54.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        n54 n54Var = (n54) obj;
        return n12.c(this.b, n54Var.b) && this.f == n54Var.f;
    }

    public final int hashCode() {
        return (this.b.b.hashCode() * 31) + this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        this.b.writeToParcel(parcel, i);
        parcel.writeInt(this.f);
    }

    public n54(m54 m54Var, int i) {
        m54Var.getClass();
        this.b = m54Var;
        this.f = i;
    }
}
