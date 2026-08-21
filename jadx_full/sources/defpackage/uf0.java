package defpackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class uf0 extends h1 {
    public final boolean A0;
    public final String B0;
    public final Integer z0;

    @fj2
    public uf0(@gj2(name = "locales") List<String> list, @gj2(name = "confidence") Integer num, @gj2(name = "geoname_id") Long l, @gj2(name = "is_in_european_union") Boolean bool, @gj2(name = "iso_code") String str, @gj2(name = "names") Map<String, String> map) {
        this(list, num, l != null ? Integer.valueOf(l.intValue()) : null, bool != null ? bool.booleanValue() : false, str, map);
    }

    public uf0(List list, Integer num, Integer num2, boolean z, String str, Map map) {
        super(list, num2, map);
        this.z0 = num;
        this.A0 = z;
        this.B0 = str;
    }

    public uf0() {
        this((List) null, (Integer) null, (Integer) null, false, (String) null, (Map) null);
    }

    public uf0(uf0 uf0Var, List list) {
        this(list, uf0Var.z0, uf0Var.y0, uf0Var.A0, uf0Var.B0, new HashMap(uf0Var.Z));
    }
}
