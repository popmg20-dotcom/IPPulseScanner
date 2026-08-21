package defpackage;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ff implements zd1 {
    public AssetManager b;

    @Override // defpackage.zd1
    public final InputStream a(String str) {
        try {
            return this.b.open(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
