package defpackage;

import android.os.Parcel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w55 extends mz4 implements y55 {
    @Override // defpackage.y55
    public final void x(List list) {
        Parcel parcelC = c();
        parcelC.writeTypedList(list);
        F(parcelC);
    }
}
