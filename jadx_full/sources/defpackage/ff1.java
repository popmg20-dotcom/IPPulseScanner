package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ff1 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public ff1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = o44.a;
        tj4.k("ApplicationId must be set.", true ^ (str == null || str.trim().isEmpty()));
        this.b = str;
        this.a = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public static ff1 a(Context context) {
        e24 e24Var = new e24(context, 3);
        String strU = e24Var.u("google_app_id");
        if (TextUtils.isEmpty(strU)) {
            return null;
        }
        return new ff1(strU, e24Var.u("google_api_key"), e24Var.u("firebase_database_url"), e24Var.u("ga_trackingId"), e24Var.u("gcm_defaultSenderId"), e24Var.u("google_storage_bucket"), e24Var.u("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ff1)) {
            return false;
        }
        ff1 ff1Var = (ff1) obj;
        return gb4.I(this.b, ff1Var.b) && gb4.I(this.a, ff1Var.a) && gb4.I(this.c, ff1Var.c) && gb4.I(this.d, ff1Var.d) && gb4.I(this.e, ff1Var.e) && gb4.I(this.f, ff1Var.f) && gb4.I(this.g, ff1Var.g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.a, this.c, this.d, this.e, this.f, this.g});
    }

    public final String toString() {
        v62 v62Var = new v62(this);
        v62Var.o(this.b, "applicationId");
        v62Var.o(this.a, "apiKey");
        v62Var.o(this.c, "databaseUrl");
        v62Var.o(this.e, "gcmSenderId");
        v62Var.o(this.f, "storageBucket");
        v62Var.o(this.g, "projectId");
        return v62Var.toString();
    }
}
