package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kz4 extends je {
    public final /* synthetic */ int z0;

    @Override // defpackage.je
    public t9 j(Context context, Looper looper, uf4 uf4Var, Object obj, rp1 rp1Var, sp1 sp1Var) {
        switch (this.z0) {
            case 0:
                Object obj2 = uf4Var.f;
                Integer num = (Integer) uf4Var.g;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new kw3(context, looper, uf4Var, bundle, rp1Var, sp1Var);
            case 1:
                obj.getClass();
                throw new ClassCastException();
            default:
                return super.j(context, looper, uf4Var, obj, rp1Var, sp1Var);
        }
    }

    @Override // defpackage.je
    public /* synthetic */ t9 k(Context context, Looper looper, uf4 uf4Var, Object obj, sz4 sz4Var, sz4 sz4Var2) {
        switch (this.z0) {
            case 2:
                return new q05(context, looper, uf4Var, (fb4) obj, sz4Var, sz4Var2);
            default:
                return super.k(context, looper, uf4Var, obj, sz4Var, sz4Var2);
        }
    }
}
