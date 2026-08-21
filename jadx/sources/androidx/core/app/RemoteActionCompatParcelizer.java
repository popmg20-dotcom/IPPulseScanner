package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import defpackage.ap4;
import defpackage.bp4;
import defpackage.cp4;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(ap4 ap4Var) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        cp4 cp4VarG = remoteActionCompat.a;
        boolean z = true;
        if (ap4Var.e(1)) {
            cp4VarG = ap4Var.g();
        }
        remoteActionCompat.a = (IconCompat) cp4VarG;
        CharSequence charSequence = remoteActionCompat.b;
        if (ap4Var.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((bp4) ap4Var).e);
        }
        remoteActionCompat.b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.c;
        if (ap4Var.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((bp4) ap4Var).e);
        }
        remoteActionCompat.c = charSequence2;
        remoteActionCompat.d = (PendingIntent) ap4Var.f(remoteActionCompat.d, 4);
        boolean z2 = remoteActionCompat.e;
        if (ap4Var.e(5)) {
            z2 = ((bp4) ap4Var).e.readInt() != 0;
        }
        remoteActionCompat.e = z2;
        boolean z3 = remoteActionCompat.f;
        if (!ap4Var.e(6)) {
            z = z3;
        } else if (((bp4) ap4Var).e.readInt() == 0) {
            z = false;
        }
        remoteActionCompat.f = z;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, ap4 ap4Var) {
        ap4Var.getClass();
        IconCompat iconCompat = remoteActionCompat.a;
        ap4Var.h(1);
        ap4Var.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.b;
        ap4Var.h(2);
        Parcel parcel = ((bp4) ap4Var).e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.c;
        ap4Var.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.d;
        ap4Var.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z = remoteActionCompat.e;
        ap4Var.h(5);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = remoteActionCompat.f;
        ap4Var.h(6);
        parcel.writeInt(z2 ? 1 : 0);
    }
}
