package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.view.Choreographer;
import defpackage.d02;
import defpackage.r8;
import defpackage.wl3;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements d02 {
    @Override // defpackage.d02
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // defpackage.d02
    public final Object b(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new wl3(26);
        }
        Choreographer.getInstance().postFrameCallback(new r8(this, context.getApplicationContext()));
        return new wl3(26);
    }
}
