package defpackage;

import android.content.ClipData;
import android.content.ClipDescription;
import android.view.ContentInfo;
import j$.util.Objects;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class td0 {
    public final sd0 a;

    public td0(sd0 sd0Var) {
        this.a = sd0Var;
    }

    public static ClipData a(ClipDescription clipDescription, ArrayList arrayList) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), (ClipData.Item) arrayList.get(0));
        for (int i = 1; i < arrayList.size(); i++) {
            clipData.addItem((ClipData.Item) arrayList.get(i));
        }
        return clipData;
    }

    public final ContentInfo b() {
        ContentInfo contentInfoH = this.a.h();
        Objects.requireNonNull(contentInfoH);
        return contentInfoH;
    }

    public final String toString() {
        return this.a.toString();
    }
}
