package defpackage;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y95 {
    public final Context a;
    public final Boolean b;
    public final long c;
    public final j45 d;
    public final boolean e;
    public final Long f;
    public final String g;

    public y95(Context context, j45 j45Var, Long l) {
        this.e = true;
        tj4.i(context);
        Context applicationContext = context.getApplicationContext();
        tj4.i(applicationContext);
        this.a = applicationContext;
        this.f = l;
        if (j45Var != null) {
            this.d = j45Var;
            this.e = j45Var.z;
            this.c = j45Var.f;
            this.g = j45Var.X;
            Bundle bundle = j45Var.A;
            if (bundle != null) {
                this.b = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
