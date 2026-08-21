package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xi3 extends uf0 {
    public final String C0;

    @fj2
    public xi3(@gj2(name = "locales") List<String> list, @gj2(name = "confidence") Integer num, @gj2(name = "geoname_id") Long l, @gj2(name = "is_in_european_union") Boolean bool, @gj2(name = "iso_code") String str, @gj2(name = "names") Map<String, String> map, @gj2(name = "type") String str2) {
        this(list, num, l != null ? Integer.valueOf(l.intValue()) : null, bool != null ? bool.booleanValue() : false, str, map, str2);
    }

    public xi3(List list, Integer num, Integer num2, boolean z, String str, Map map, String str2) {
        super(list, num, num2, z, str, map);
        this.C0 = str2;
    }
}
