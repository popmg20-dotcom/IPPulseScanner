package defpackage;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yo1 extends y1 {
    public static final Parcelable.Creator<yo1> CREATOR = new gl4(28);
    public static final Scope[] F0 = new Scope[0];
    public static final ic1[] G0 = new ic1[0];
    public String A;
    public ic1[] A0;
    public final boolean B0;
    public final int C0;
    public final boolean D0;
    public final String E0;
    public IBinder X;
    public Scope[] Y;
    public Bundle Z;
    public final int b;
    public final int f;
    public Account y0;
    public final int z;
    public ic1[] z0;

    public yo1(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, ic1[] ic1VarArr, ic1[] ic1VarArr2, boolean z, int i4, boolean z2, String str2) {
        Account account2;
        Scope[] scopeArr2 = scopeArr == null ? F0 : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        ic1[] ic1VarArr3 = G0;
        ic1[] ic1VarArr4 = ic1VarArr == null ? ic1VarArr3 : ic1VarArr;
        ic1VarArr3 = ic1VarArr2 != null ? ic1VarArr2 : ic1VarArr3;
        this.b = i;
        this.f = i2;
        this.z = i3;
        if ("com.google.android.gms".equals(str)) {
            this.A = "com.google.android.gms";
        } else {
            this.A = str;
        }
        if (i < 2) {
            account2 = null;
            if (iBinder != null) {
                int i5 = a3.d;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface jh5Var = iInterfaceQueryLocalInterface instanceof lv1 ? (lv1) iInterfaceQueryLocalInterface : new jh5(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    try {
                        jh5 jh5Var2 = (jh5) jh5Var;
                        Parcel parcelA = jh5Var2.a(jh5Var2.c(), 2);
                        Account account3 = (Account) k35.a(parcelA, Account.CREATOR);
                        parcelA.recycle();
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        account2 = account3;
                    } catch (RemoteException unused) {
                        a1.n("AccountAccessor", "Remote account accessor probably died");
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    }
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                    throw th;
                }
            }
        } else {
            this.X = iBinder;
            account2 = account;
        }
        this.y0 = account2;
        this.Y = scopeArr2;
        this.Z = bundle2;
        this.z0 = ic1VarArr4;
        this.A0 = ic1VarArr3;
        this.B0 = z;
        this.C0 = i4;
        this.D0 = z2;
        this.E0 = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        gl4.a(this, parcel, i);
    }
}
