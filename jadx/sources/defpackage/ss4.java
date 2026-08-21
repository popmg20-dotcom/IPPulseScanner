package defpackage;

import android.content.Intent;
import android.net.VpnService;
import androidx.fragment.app.p;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ss4 extends m4 {
    public Intent a;

    @Override // defpackage.m4
    public final Intent a(p pVar, Object obj) {
        ((xl4) obj).getClass();
        Intent intent = this.a;
        intent.getClass();
        return intent;
    }

    @Override // defpackage.m4
    public final w7 b(p pVar, Object obj) {
        ((xl4) obj).getClass();
        try {
            Intent intentPrepare = VpnService.prepare(pVar);
            if (intentPrepare == null) {
                return new w7(4, new uk3(Boolean.TRUE));
            }
            this.a = intentPrepare;
            return null;
        } catch (Exception e) {
            return new w7(4, new uk3(new tk3(e)));
        }
    }

    @Override // defpackage.m4
    public final Object c(Intent intent, int i) {
        return new uk3(Boolean.valueOf(i == -1));
    }
}
