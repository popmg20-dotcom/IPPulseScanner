package defpackage;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c05 extends h05 {
    public final /* synthetic */ Intent b;
    public final /* synthetic */ GoogleApiActivity f;

    public c05(Intent intent, GoogleApiActivity googleApiActivity) {
        this.b = intent;
        this.f = googleApiActivity;
    }

    @Override // defpackage.h05
    public final void a() {
        Intent intent = this.b;
        if (intent != null) {
            this.f.startActivityForResult(intent, 2);
        }
    }
}
