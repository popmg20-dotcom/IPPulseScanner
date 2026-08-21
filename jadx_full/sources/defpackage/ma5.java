package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ma5 {
    public static final ie a = new ie(0);

    public static synchronized Uri a() {
        ie ieVar = a;
        Uri uri = (Uri) ieVar.get("com.google.android.gms.measurement");
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
        ieVar.put("com.google.android.gms.measurement", uri2);
        return uri2;
    }
}
