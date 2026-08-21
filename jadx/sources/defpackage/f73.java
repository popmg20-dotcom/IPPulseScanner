package defpackage;

import android.os.FileObserver;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f73 extends FileObserver {
    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) throws InterruptedException, IOException {
        d73.h(i, str);
    }
}
