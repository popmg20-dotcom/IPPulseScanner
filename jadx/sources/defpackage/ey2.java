package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ey2 {
    public final Context a;

    public ey2(Context context) {
        this.a = context;
    }

    public final PackageInfo a(int i, String str) {
        return this.a.getPackageManager().getPackageInfo(str, i);
    }

    public final boolean b() {
        String nameForUid;
        int callingUid = Binder.getCallingUid();
        int iMyUid = Process.myUid();
        Context context = this.a;
        if (callingUid == iMyUid) {
            return v02.r(context);
        }
        if (!vf2.v() || (nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return context.getPackageManager().isInstantApp(nameForUid);
    }
}
