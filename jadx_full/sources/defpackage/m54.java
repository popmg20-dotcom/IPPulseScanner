package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m54 implements Parcelable, Comparable {
    public static final Parcelable.Creator<m54> CREATOR = new ym3(23);
    public final String b;
    public final ArrayList f;

    public m54(String str, ArrayList arrayList) {
        str.getClass();
        this.b = str;
        this.f = arrayList;
    }

    public final void a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(this.b);
        sb.append('\n');
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            m54 m54Var = (m54) it.next();
            if (it.hasNext()) {
                m54Var.a(sb, str2.concat("├── "), str2.concat("│   "));
            } else {
                m54Var.a(sb, str2.concat("└── "), str2.concat("    "));
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        m54 m54Var = (m54) obj;
        m54Var.getClass();
        return this.b.compareTo(m54Var.b);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!m54.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        return n12.c(this.b, ((m54) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb, "", "");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        ArrayList arrayList = this.f;
        parcel.writeInt(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((m54) it.next()).writeToParcel(parcel, i);
        }
    }

    public /* synthetic */ m54(String str) {
        this(str, new ArrayList());
    }
}
