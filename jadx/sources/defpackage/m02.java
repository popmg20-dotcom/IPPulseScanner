package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m02 implements o02 {
    public final InputContentInfo b;

    public m02(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.b = new InputContentInfo(uri, clipDescription, uri2);
    }

    @Override // defpackage.o02
    public final Uri b() {
        return this.b.getLinkUri();
    }

    @Override // defpackage.o02
    public final Uri c() {
        return this.b.getContentUri();
    }

    @Override // defpackage.o02
    public final void d() {
        this.b.requestPermission();
    }

    @Override // defpackage.o02
    public final Object e() {
        return this.b;
    }

    @Override // defpackage.o02
    public final ClipDescription getDescription() {
        return this.b.getDescription();
    }

    public m02(Object obj) {
        this.b = (InputContentInfo) obj;
    }
}
