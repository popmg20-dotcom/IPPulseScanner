package defpackage;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.sentry.android.core.a1;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class g95 extends oz4 implements IInterface {
    public final int d;

    public g95(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        tj4.d(bArr.length == 25);
        this.d = Arrays.hashCode(bArr);
    }

    public static byte[] H(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            xe.i(e);
            return null;
        }
    }

    @Override // defpackage.oz4
    public final boolean E(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            wv1 wv1VarG = G();
            parcel2.writeNoException();
            k35.b(parcel2, wv1VarG);
            return true;
        }
        if (i != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(this.d);
        return true;
    }

    public abstract byte[] F();

    public final wv1 G() {
        return new bu2(F());
    }

    public final boolean equals(Object obj) {
        wv1 wv1VarG;
        if (obj instanceof g95) {
            try {
                g95 g95Var = (g95) obj;
                if (g95Var.d == this.d && (wv1VarG = g95Var.G()) != null) {
                    return Arrays.equals(F(), (byte[]) bu2.G(wv1VarG));
                }
            } catch (RemoteException e) {
                a1.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.d;
    }
}
