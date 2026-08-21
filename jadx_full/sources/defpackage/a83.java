package defpackage;

import android.content.ClipData;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a83 implements pl1 {
    public final /* synthetic */ d83 b;
    public final /* synthetic */ ClipData f;
    public final /* synthetic */ int z;

    public a83(d83 d83Var, ClipData clipData, int i) {
        this.b = d83Var;
        this.f = clipData;
        this.z = i;
    }

    @Override // defpackage.pl1
    public final Object a() {
        Uri uri = this.f.getItemAt(this.z).getUri();
        uri.getClass();
        this.b.j(uri);
        return xl4.a;
    }
}
