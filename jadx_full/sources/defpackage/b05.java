package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import io.sentry.android.core.a1;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b05 extends oz4 implements rp1, sp1 {
    public static final kz4 k = d05.a;
    public final Context d;
    public final Handler e;
    public final kz4 f;
    public final Set g;
    public final uf4 h;
    public kw3 i;
    public x8 j;

    public b05(Context context, s05 s05Var, uf4 uf4Var) {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
        this.d = context;
        this.e = s05Var;
        this.h = uf4Var;
        this.g = (Set) uf4Var.b;
        this.f = k;
    }

    @Override // defpackage.sp1
    public final void a(ab0 ab0Var) {
        this.j.L(ab0Var);
    }

    @Override // defpackage.rp1
    public final void b(int i) {
        x8 x8Var = this.j;
        sz4 sz4Var = (sz4) ((tp1) x8Var.Y).j.get((x9) x8Var.z);
        if (sz4Var != null) {
            if (sz4Var.k) {
                sz4Var.p(new ab0(17));
            } else {
                sz4Var.b(i);
            }
        }
    }

    @Override // defpackage.rp1
    public final void c() {
        GoogleSignInAccount googleSignInAccountA;
        kw3 kw3Var = this.i;
        kw3Var.getClass();
        try {
            kw3Var.R0.getClass();
            Account account = new Account("<<default account>>", "com.google");
            if ("<<default account>>".equals(account.name)) {
                Context context = kw3Var.z;
                ReentrantLock reentrantLock = p34.c;
                tj4.i(context);
                ReentrantLock reentrantLock2 = p34.c;
                reentrantLock2.lock();
                try {
                    p34 p34Var = p34.d;
                    if (p34Var == null) {
                        p34Var = new p34(context.getApplicationContext());
                        p34.d = p34Var;
                    }
                    reentrantLock2.unlock();
                    String strA = p34Var.a("defaultGoogleSignInAccount");
                    if (!TextUtils.isEmpty(strA)) {
                        String strA2 = p34Var.a("googleSignInAccount:" + strA);
                        if (strA2 != null) {
                            try {
                                googleSignInAccountA = GoogleSignInAccount.a(strA2);
                            } catch (JSONException unused) {
                                googleSignInAccountA = null;
                            }
                        }
                    }
                    googleSignInAccountA = null;
                } catch (Throwable th) {
                    reentrantLock2.unlock();
                    throw th;
                }
            } else {
                googleSignInAccountA = null;
            }
            Integer num = kw3Var.T0;
            tj4.i(num);
            r05 r05Var = new r05(2, account, num.intValue(), googleSignInAccountA);
            f05 f05Var = (f05) kw3Var.s();
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeInterfaceToken(f05Var.e);
            int i = xz4.a;
            parcelObtain.writeInt(1);
            int iV = ye.V(parcelObtain, 20293);
            ye.U(parcelObtain, 1, 4);
            parcelObtain.writeInt(1);
            ye.P(parcelObtain, 2, r05Var, 0);
            ye.W(parcelObtain, iV);
            parcelObtain.writeStrongBinder(this);
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                f05Var.d.transact(12, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain.recycle();
                parcelObtain2.recycle();
            } catch (Throwable th2) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                throw th2;
            }
        } catch (RemoteException e) {
            a1.n("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                this.e.post(new um1(13, (Object) this, (Object) new m05(1, new ab0(8, null), null), false));
            } catch (RemoteException unused2) {
                a1.p("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }
}
