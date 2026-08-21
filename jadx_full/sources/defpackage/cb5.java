package defpackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cb5 implements Callable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ja5 c;

    public /* synthetic */ cb5(boolean z, String str, ja5 ja5Var) {
        this.a = z;
        this.b = str;
        this.c = ja5Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        MessageDigest messageDigest;
        boolean z = this.a;
        String str = this.b;
        ja5 ja5Var = this.c;
        String str2 = (z || !wd5.c(str, ja5Var, true, false).b) ? "not allowed" : "debug cert rejected";
        int i = 0;
        while (true) {
            if (i >= 2) {
                messageDigest = null;
                break;
            }
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                break;
            }
            i++;
        }
        tj4.i(messageDigest);
        byte[] bArrDigest = messageDigest.digest(ja5Var.e);
        int length = bArrDigest.length;
        char[] cArr = new char[length + length];
        int i2 = 0;
        for (byte b : bArrDigest) {
            char[] cArr2 = vf2.X;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
            i2 += 2;
        }
        StringBuilder sbE = fw.E(str2, ": pkg=", str, ", sha256=", new String(cArr));
        sbE.append(", atk=");
        sbE.append(z);
        sbE.append(", ver=12451000.false");
        return sbE.toString();
    }
}
