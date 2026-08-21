package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bf implements Parcelable {
    public static final Parcelable.Creator<bf> CREATOR = new o3(4);

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f1 A[Catch: all -> 0x0058, TryCatch #2 {all -> 0x0058, blocks: (B:4:0x0007, B:42:0x00f1, B:44:0x0123, B:46:0x012b, B:48:0x0136, B:49:0x0139, B:53:0x0155, B:67:0x0168, B:68:0x016b, B:7:0x001a, B:9:0x0022, B:11:0x002c, B:13:0x003e, B:17:0x005d, B:19:0x006b, B:21:0x006f, B:23:0x0074, B:25:0x007a, B:28:0x0086, B:30:0x0090, B:32:0x009c, B:34:0x00a6, B:36:0x00c1, B:38:0x00cf, B:40:0x00d3, B:41:0x00d6, B:65:0x0166, B:50:0x0147, B:52:0x0152, B:63:0x0162, B:64:0x0165), top: B:75:0x0007, inners: #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File a() {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bf.a():java.io.File");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return bf.class.equals(obj != null ? obj.getClass() : null);
    }

    public final int hashCode() {
        return bf.class.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(1);
    }
}
