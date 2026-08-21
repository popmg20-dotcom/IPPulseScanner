package defpackage;

import android.webkit.MimeTypeMap;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pd1 implements gd1 {
    public final File a;

    public pd1(File file) {
        this.a = file;
    }

    @Override // defpackage.gd1
    public final Object a(ge0 ge0Var) {
        String str = u03.f;
        File file = this.a;
        return new pz3(new sd1(pr1.r(file), ge1.b, null, null), MimeTypeMap.getSingleton().getMimeTypeFromExtension(le1.S(file)), pi0.z);
    }
}
