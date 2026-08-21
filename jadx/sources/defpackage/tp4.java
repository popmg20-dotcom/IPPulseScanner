package defpackage;

import android.view.ContentInfo;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class tp4 {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static td0 b(View view, td0 td0Var) {
        ContentInfo contentInfoB = td0Var.b();
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoB);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoB ? td0Var : new td0(new pd0(contentInfoPerformReceiveContent));
    }

    public static void c(View view, String[] strArr, hv2 hv2Var) {
        if (hv2Var == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new up4(hv2Var));
        }
    }
}
