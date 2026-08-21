package defpackage;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class w9 extends Exception {
    public w9(Status status) {
        int i = status.b;
        String str = status.f;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 2 + str.length());
        sb.append(i);
        sb.append(": ");
        sb.append(str);
        super(sb.toString());
    }
}
