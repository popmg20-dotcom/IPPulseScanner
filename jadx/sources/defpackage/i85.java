package defpackage;

import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i85 implements lb5 {
    public final /* synthetic */ k85 b;

    @Override // defpackage.lb5, defpackage.v65
    public /* synthetic */ void a(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.b.d(i, th, bArr);
    }

    public boolean b() {
        t65 t65Var = this.b.Y;
        k85.h(t65Var);
        return Log.isLoggable(t65Var.b1(), 3);
    }

    public i85(y95 y95Var, k85 k85Var) {
        this.b = k85Var;
    }
}
