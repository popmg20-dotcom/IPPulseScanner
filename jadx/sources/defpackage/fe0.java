package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fe0 extends h1 {
    public final String z0;

    @fj2
    public fe0(@gj2(name = "locales") List<String> list, @gj2(name = "code") String str, @gj2(name = "geoname_id") Long l, @gj2(name = "names") Map<String, String> map) {
        this(list, str, l != null ? Integer.valueOf(l.intValue()) : null, map);
    }

    public fe0(List list, String str, Integer num, Map map) {
        super(list, num, map);
        this.z0 = str;
    }
}
