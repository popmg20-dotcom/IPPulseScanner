package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x45 extends u05 {
    public final IBinder g;
    public final /* synthetic */ tk h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x45(tk tkVar, int i, IBinder iBinder, Bundle bundle) {
        super(tkVar, i, bundle);
        this.h = tkVar;
        this.g = iBinder;
    }

    @Override // defpackage.u05
    public final boolean a() {
        IBinder iBinder = this.g;
        try {
            tj4.i(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            tk tkVar = this.h;
            if (!tkVar.t().equals(interfaceDescriptor)) {
                String strT = tkVar.t();
                StringBuilder sb = new StringBuilder(strT.length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append("service descriptor mismatch: ");
                sb.append(strT);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                a1.n("GmsClient", sb.toString());
                return false;
            }
            IInterface iInterfaceM = tkVar.m(iBinder);
            if (iInterfaceM == null || !(tkVar.w(2, 4, iInterfaceM) || tkVar.w(3, 4, iInterfaceM))) {
                return false;
            }
            tkVar.K0 = null;
            qk qkVar = tkVar.F0;
            if (qkVar == null) {
                return true;
            }
            qkVar.c();
            return true;
        } catch (RemoteException unused) {
            a1.n("GmsClient", "service probably died");
            return false;
        }
    }

    @Override // defpackage.u05
    public final void b(ab0 ab0Var) {
        rk rkVar = this.h.G0;
        if (rkVar != null) {
            rkVar.a(ab0Var);
        }
        System.currentTimeMillis();
    }
}
