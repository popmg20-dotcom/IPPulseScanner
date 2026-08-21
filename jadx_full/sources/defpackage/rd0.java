package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rd0 implements qd0, sd0 {
    public final /* synthetic */ int a = 0;
    public ClipData b;
    public int c;
    public int d;
    public Uri e;
    public Bundle f;

    public rd0(rd0 rd0Var) {
        ClipData clipData = rd0Var.b;
        clipData.getClass();
        this.b = clipData;
        int i = rd0Var.c;
        r25.g(i, 0, 5, "source");
        this.c = i;
        int i2 = rd0Var.d;
        if ((i2 & 1) == i2) {
            this.d = i2;
            this.e = rd0Var.e;
            this.f = rd0Var.f;
            return;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
    }

    @Override // defpackage.sd0
    public int a() {
        return this.c;
    }

    @Override // defpackage.sd0
    public Uri b() {
        return this.e;
    }

    @Override // defpackage.qd0
    public td0 build() {
        return new td0(new rd0(this));
    }

    @Override // defpackage.sd0
    public ClipData c() {
        return this.b;
    }

    @Override // defpackage.qd0
    public void d(Uri uri) {
        this.e = uri;
    }

    @Override // defpackage.qd0
    public void e(int i) {
        this.d = i;
    }

    @Override // defpackage.qd0
    public void f(ClipData clipData) {
        this.b = clipData;
    }

    @Override // defpackage.sd0
    public int g() {
        return this.d;
    }

    @Override // defpackage.sd0
    public Bundle getExtras() {
        return this.f;
    }

    @Override // defpackage.sd0
    public ContentInfo h() {
        return null;
    }

    @Override // defpackage.qd0
    public void setExtras(Bundle bundle) {
        this.f = bundle;
    }

    public String toString() {
        String str;
        switch (this.a) {
            case 1:
                Uri uri = this.e;
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.b.getDescription());
                sb.append(", source=");
                int i = this.c;
                sb.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i2 = this.d;
                sb.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return fw.y(sb, this.f != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public /* synthetic */ rd0() {
    }
}
