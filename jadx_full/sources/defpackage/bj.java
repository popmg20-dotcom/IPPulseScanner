package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bj implements em1 {
    public final /* synthetic */ jj b;
    public final /* synthetic */ Uri f;
    public final /* synthetic */ z00 z;

    public bj(jj jjVar, Uri uri, z00 z00Var) {
        this.b = jjVar;
        this.f = uri;
        this.z = z00Var;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        char[] cArr = (char[]) obj;
        u6 u6Var = (u6) obj2;
        pl1 pl1Var = (pl1) obj3;
        cArr.getClass();
        u6Var.getClass();
        pl1Var.getClass();
        jj jjVar = this.b;
        da2 viewLifecycleOwner = jjVar.a.getViewLifecycleOwner();
        viewLifecycleOwner.getClass();
        ji0.B(uf2.t(viewLifecycleOwner), null, null, new aj(jjVar, this.f, cArr, u6Var, this.z, pl1Var, null), 3);
        return xl4.a;
    }
}
