package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class dp extends bc0 {
    public final wa f;

    public dp(Context context, ih4 ih4Var) {
        super(context, ih4Var);
        this.f = new wa(1, this);
    }

    @Override // defpackage.bc0
    public final void c() {
        ue2.g().a(ep.a, getClass().getSimpleName().concat(": registering receiver"));
        this.b.registerReceiver(this.f, e());
    }

    @Override // defpackage.bc0
    public final void d() {
        ue2.g().a(ep.a, getClass().getSimpleName().concat(": unregistering receiver"));
        this.b.unregisterReceiver(this.f);
    }

    public abstract IntentFilter e();

    public abstract void f(Intent intent);
}
