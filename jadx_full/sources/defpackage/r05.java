package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r05 extends y1 {
    public static final Parcelable.Creator<r05> CREATOR = new gl4(12);
    public final GoogleSignInAccount A;
    public final int b;
    public final Account f;
    public final int z;

    public r05(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.b = i;
        this.f = account;
        this.z = i2;
        this.A = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.P(parcel, 2, this.f, i);
        ye.U(parcel, 3, 4);
        parcel.writeInt(this.z);
        ye.P(parcel, 4, this.A, i);
        ye.W(parcel, iV);
    }
}
