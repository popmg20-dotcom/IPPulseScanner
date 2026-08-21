package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import io.netty.channel.internal.ChannelUtils;
import io.sentry.android.core.a1;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wp1 {
    public static wp1 c;
    public final Context a;
    public volatile String b;

    public wp1(Context context) {
        this.a = context.getApplicationContext();
    }

    public static wp1 a(Context context) {
        wp1 wp1Var;
        tj4.i(context);
        synchronized (wp1.class) {
            try {
                wp1Var = c;
                if (wp1Var == null) {
                    wd5.a(context);
                    wp1Var = new wp1(context);
                    c = wp1Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return wp1Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f4, code lost:
    
        r5 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean c(PackageInfo packageInfo, boolean z) {
        u15 u15Var;
        u15 u15Var2;
        int i;
        if (packageInfo != null) {
            if (z && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            try {
                u15Var = z ? vc5.c : vc5.b;
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 28) {
                    Signature[] signatureArr = packageInfo.signatures;
                    byte[] byteArray = null;
                    if (signatureArr != null && signatureArr.length == 1) {
                        byteArray = signatureArr[0].toByteArray();
                    }
                    if (byteArray != null) {
                        g15 g15Var = o15.A;
                        Object[] objArr = {byteArray};
                        tj4.o0(1, objArr);
                        u15Var2 = new u15(1, objArr);
                    } else {
                        g15 g15Var2 = o15.A;
                        u15Var2 = u15.Z;
                    }
                } else {
                    if (i2 < 28) {
                        throw new IllegalStateException();
                    }
                    SigningInfo signingInfo = packageInfo.signingInfo;
                    if (signingInfo == null || signingInfo.hasMultipleSigners() || signingInfo.getSigningCertificateHistory() == null) {
                        g15 g15Var3 = o15.A;
                        u15Var2 = u15.Z;
                    } else {
                        g15 g15Var4 = o15.A;
                        Object[] objArrCopyOf = new Object[4];
                        Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                        int length = signingCertificateHistory.length;
                        int i3 = 0;
                        int i4 = 0;
                        while (i3 < length) {
                            byte[] byteArray2 = signingCertificateHistory[i3].toByteArray();
                            byteArray2.getClass();
                            int length2 = objArrCopyOf.length;
                            int i5 = i4 + 1;
                            if (i5 < 0) {
                                throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
                            }
                            if (i5 <= length2) {
                                i = length2;
                            } else {
                                i = (length2 >> 1) + length2 + 1;
                                if (i < i5) {
                                    int iHighestOneBit = Integer.highestOneBit(i4);
                                    i = iHighestOneBit + iHighestOneBit;
                                }
                                if (i < 0) {
                                    i = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                                }
                            }
                            if (i > length2) {
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i);
                            }
                            objArrCopyOf[i4] = byteArray2;
                            i3++;
                            i4 = i5;
                        }
                        u15Var2 = i4 == 0 ? u15.Z : new u15(i4, objArrCopyOf);
                    }
                }
            } catch (IllegalArgumentException unused) {
                Log.i("GoogleSignatureVerifier", "package info is not set correctly");
                if ((z ? d(packageInfo, vc5.a) : d(packageInfo, vc5.a[0])) == null) {
                    return false;
                }
            }
            if (u15Var2.isEmpty()) {
                throw new IllegalArgumentException("Unable to obtain package certificate history.");
            }
            o15 o15VarI = u15Var2.i();
            int size = o15VarI.size();
            int i6 = 0;
            while (i6 < size) {
                byte[] bArr = (byte[]) o15VarI.get(i6);
                g15 g15VarListIterator = u15Var.listIterator(0);
                do {
                    int i7 = i6 + 1;
                    if (g15VarListIterator.hasNext()) {
                    }
                } while (!Arrays.equals(bArr, (byte[]) g15VarListIterator.next()));
                return true;
            }
        }
        return false;
    }

    public static g95 d(PackageInfo packageInfo, g95... g95VarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                a1.n("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            ja5 ja5Var = new ja5(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < g95VarArr.length; i++) {
                if (g95VarArr[i].equals(ja5Var)) {
                    return g95VarArr[i];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(int i) {
        fa5 fa5VarZ;
        int length;
        ApplicationInfo applicationInfo;
        boolean zG;
        String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null || (length = packagesForUid.length) == 0) {
            fa5VarZ = fa5.z("no pkgs");
        } else {
            fa5VarZ = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    tj4.i(fa5VarZ);
                    break;
                }
                String str = packagesForUid[i2];
                if (str == null) {
                    fa5VarZ = fa5.z("null pkg");
                } else if (str.equals(this.b)) {
                    fa5VarZ = fa5.X;
                } else {
                    f45 f45Var = wd5.a;
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            wd5.b();
                            zG = ((b15) wd5.c).G();
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        } finally {
                        }
                    } catch (RemoteException | vz0 e) {
                        a1.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    }
                    if (zG) {
                        boolean zA = up1.a(this.a);
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads2 = StrictMode.allowThreadDiskReads();
                        try {
                            tj4.i(wd5.e);
                            try {
                                wd5.b();
                                tj4.i(wd5.e);
                                Context context = (Context) bu2.G(bu2.F(new bu2(wd5.e)));
                                try {
                                    b15 b15Var = (b15) wd5.c;
                                    Parcel parcelC = b15Var.c();
                                    int i3 = k35.a;
                                    parcelC.writeInt(1);
                                    int iV = ye.V(parcelC, 20293);
                                    ye.Q(parcelC, 1, str);
                                    ye.U(parcelC, 2, 4);
                                    parcelC.writeInt(zA ? 1 : 0);
                                    ye.U(parcelC, 3, 4);
                                    parcelC.writeInt(0);
                                    ye.O(parcelC, 4, new bu2(context));
                                    ye.U(parcelC, 5, 4);
                                    parcelC.writeInt(0);
                                    ye.U(parcelC, 6, 4);
                                    parcelC.writeInt(1);
                                    ye.U(parcelC, 8, 4);
                                    parcelC.writeInt(0);
                                    ye.W(parcelC, iV);
                                    Parcel parcelA = b15Var.a(parcelC, 6);
                                    ug5 ug5Var = (ug5) k35.a(parcelA, ug5.CREATOR);
                                    parcelA.recycle();
                                    if (ug5Var.b) {
                                        r25.Z(ug5Var.A);
                                        fa5VarZ = new fa5(true, (String) null, (Exception) null);
                                    } else {
                                        String str2 = ug5Var.f;
                                        PackageManager.NameNotFoundException nameNotFoundException = fx3.R(ug5Var.z) == 4 ? new PackageManager.NameNotFoundException() : null;
                                        if (str2 == null) {
                                            str2 = "error checking package certificate";
                                        }
                                        r25.Z(ug5Var.A);
                                        fx3.R(ug5Var.z);
                                        fa5VarZ = new fa5(false, str2, (Exception) nameNotFoundException);
                                    }
                                } catch (RemoteException e2) {
                                    a1.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                                    fa5VarZ = fa5.B("module call", e2);
                                }
                            } catch (vz0 e3) {
                                a1.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                                fa5VarZ = fa5.B("module init: ".concat(String.valueOf(e3.getMessage())), e3);
                            }
                            if (fa5VarZ.b) {
                                this.b = str;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else {
                        try {
                            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(str, Build.VERSION.SDK_INT >= 28 ? 134217792 : 64);
                            boolean zA2 = up1.a(this.a);
                            if (packageInfo == null) {
                                fa5VarZ = fa5.z("null pkg");
                                if (fa5VarZ.b) {
                                }
                            } else {
                                Signature[] signatureArr = packageInfo.signatures;
                                if (signatureArr == null || signatureArr.length != 1) {
                                    fa5VarZ = fa5.z("single cert required");
                                } else {
                                    ja5 ja5Var = new ja5(packageInfo.signatures[0].toByteArray());
                                    String str3 = packageInfo.packageName;
                                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads3 = StrictMode.allowThreadDiskReads();
                                    try {
                                        fa5 fa5VarC = wd5.c(str3, ja5Var, zA2, false);
                                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads3);
                                        if (fa5VarC.b && (applicationInfo = packageInfo.applicationInfo) != null && (applicationInfo.flags & 2) != 0) {
                                            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads4 = StrictMode.allowThreadDiskReads();
                                            try {
                                                fa5 fa5VarC2 = wd5.c(str3, ja5Var, false, true);
                                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads4);
                                                if (fa5VarC2.b) {
                                                    fa5VarZ = fa5.z("debuggable release cert app rejected");
                                                }
                                            } finally {
                                            }
                                        }
                                        fa5VarZ = fa5VarC;
                                    } finally {
                                    }
                                }
                                if (fa5VarZ.b) {
                                }
                            }
                        } catch (PackageManager.NameNotFoundException e4) {
                            fa5VarZ = fa5.B("no pkg ".concat(str), e4);
                        }
                    }
                }
                if (fa5VarZ.b) {
                    break;
                }
                i2++;
            }
        }
        if (!fa5VarZ.b && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            Throwable th2 = (Throwable) fa5VarZ.z;
            if (th2 != null) {
                Log.d("GoogleCertificatesRslt", fa5VarZ.u(), th2);
            } else {
                Log.d("GoogleCertificatesRslt", fa5VarZ.u());
            }
        }
        return fa5VarZ.b;
    }
}
