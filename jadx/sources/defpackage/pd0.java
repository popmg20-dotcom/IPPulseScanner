package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pd0 implements qd0, sd0 {
    public final /* synthetic */ int a = 0;
    public final Object b;

    public pd0(td0 td0Var) {
        k10.f();
        this.b = k10.c(td0Var.b());
    }

    @Override // defpackage.sd0
    public int a() {
        return ((ContentInfo) this.b).getSource();
    }

    @Override // defpackage.sd0
    public Uri b() {
        return ((ContentInfo) this.b).getLinkUri();
    }

    @Override // defpackage.qd0
    public td0 build() {
        return new td0(new pd0(((ContentInfo.Builder) this.b).build()));
    }

    @Override // defpackage.sd0
    public ClipData c() {
        return ((ContentInfo) this.b).getClip();
    }

    @Override // defpackage.qd0
    public void d(Uri uri) {
        ((ContentInfo.Builder) this.b).setLinkUri(uri);
    }

    @Override // defpackage.qd0
    public void e(int i) {
        ((ContentInfo.Builder) this.b).setFlags(i);
    }

    @Override // defpackage.qd0
    public void f(ClipData clipData) {
        ((ContentInfo.Builder) this.b).setClip(clipData);
    }

    @Override // defpackage.sd0
    public int g() {
        return ((ContentInfo) this.b).getFlags();
    }

    @Override // defpackage.sd0
    public Bundle getExtras() {
        return ((ContentInfo) this.b).getExtras();
    }

    @Override // defpackage.sd0
    public ContentInfo h() {
        return (ContentInfo) this.b;
    }

    @Override // defpackage.qd0
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.b).setExtras(bundle);
    }

    public String toString() {
        switch (this.a) {
            case 1:
                return "ContentInfoCompat{" + ((ContentInfo) this.b) + "}";
            default:
                return super.toString();
        }
    }

    public pd0(ClipData clipData, int i) {
        this.b = k10.b(clipData, i);
    }

    public pd0(ContentInfo contentInfo) {
        contentInfo.getClass();
        this.b = contentInfo;
    }
}
