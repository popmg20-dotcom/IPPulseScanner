package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gg4 extends vf2 {
    public final String A0;
    public final boolean B0;
    public final boolean C0;
    public final boolean D0;
    public final boolean E0;
    public final boolean F0;
    public final boolean G0;
    public final boolean H0;
    public final boolean I0;
    public final boolean J0;
    public final String K0;
    public final String L0;
    public final String M0;
    public final Integer N0;
    public final Double O0;
    public final Integer Z;
    public final String y0;
    public final int z0;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @fj2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public gg4(@gj2(name = "autonomous_system_number") Long l, @gj2(name = "autonomous_system_organization") String str, @gj2(name = "connection_type") String str2, @gj2(name = "domain") String str3, @gj2(name = "ip_address") String str4, @gj2(name = "is_anonymous") Boolean bool, @gj2(name = "is_anonymous_proxy") Boolean bool2, @gj2(name = "is_anonymous_vpn") Boolean bool3, @gj2(name = "is_hosting_provider") Boolean bool4, @gj2(name = "is_legitimate_proxy") Boolean bool5, @gj2(name = "is_public_proxy") Boolean bool6, @gj2(name = "is_residential_proxy") Boolean bool7, @gj2(name = "is_satellite_provider") Boolean bool8, @gj2(name = "is_tor_exit_node") Boolean bool9, @gj2(name = "isp") String str5, @gj2(name = "network") ar2 ar2Var, @gj2(name = "organization") String str6, @gj2(name = "user_type") String str7, @gj2(name = "user_count") Integer num, @gj2(name = "static_ip_score") Double d) {
        int i;
        int i2;
        Integer numValueOf = l != null ? Integer.valueOf(l.intValue()) : null;
        if (str2 != null) {
            i = 3;
            i2 = 2;
            switch (str2) {
                case "Cellular":
                    i = 4;
                    i2 = i;
                    break;
                case "Corporate":
                    i2 = i;
                    break;
                case "Dialup":
                    i2 = 1;
                    break;
            }
        } else {
            i2 = 0;
        }
        this(numValueOf, str, i2, str3, bool != null ? bool.booleanValue() : false, bool2 != null ? bool2.booleanValue() : false, bool3 != null ? bool3.booleanValue() : false, bool4 != null ? bool4.booleanValue() : false, bool5 != null ? bool5.booleanValue() : false, bool6 != null ? bool6.booleanValue() : false, bool7 != null ? bool7.booleanValue() : false, bool8 != null ? bool8.booleanValue() : false, bool9 != null ? bool9.booleanValue() : false, str5, str6, str7, num, d);
    }

    public gg4(Integer num, String str, int i, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String str3, String str4, String str5, Integer num2, Double d) {
        super(4);
        this.Z = num;
        this.y0 = str;
        this.z0 = i;
        this.A0 = str2;
        this.B0 = z;
        this.C0 = z2;
        this.D0 = z3;
        this.E0 = z4;
        this.F0 = z5;
        this.G0 = z6;
        this.H0 = z7;
        this.I0 = z8;
        this.J0 = z9;
        this.K0 = str3;
        this.L0 = str4;
        this.M0 = str5;
        this.N0 = num2;
        this.O0 = d;
    }
}
