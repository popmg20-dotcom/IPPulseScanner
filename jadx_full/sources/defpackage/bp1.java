package defpackage;

import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bp1 {

    @x81
    @et3("html_url")
    private final String a;

    @x81
    @et3("tag_name")
    private final String b;

    @x81
    @et3("published_at")
    private final String c;

    public final String a() {
        return this.a;
    }

    public final Date b() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.getDefault());
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        Date date = simpleDateFormat.parse(this.c);
        date.getClass();
        return date;
    }

    public final String c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bp1)) {
            return false;
        }
        bp1 bp1Var = (bp1) obj;
        return n12.c(this.a, bp1Var.a) && n12.c(this.b, bp1Var.b) && n12.c(this.c, bp1Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + dw2.w(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.b;
        return fw.y(fw.E("GithubLatestReleaseResponse(htmlUrl=", str, ", tagName=", str2, ", publishedAt="), this.c, ")");
    }
}
