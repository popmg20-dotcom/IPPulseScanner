package defpackage;

import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum zo0 implements ca3 {
    EDITION_UNKNOWN(0),
    EDITION_LEGACY(900),
    EDITION_PROTO2(998),
    EDITION_PROTO3(999),
    EDITION_2023(1000),
    EDITION_2024(1001),
    EDITION_UNSTABLE(9999),
    EDITION_1_TEST_ONLY(1),
    EDITION_2_TEST_ONLY(2),
    EDITION_99997_TEST_ONLY(99997),
    EDITION_99998_TEST_ONLY(99998),
    EDITION_99999_TEST_ONLY(99999),
    EDITION_MAX(ChannelUtils.WRITE_STATUS_SNDBUF_FULL);

    public final int b;

    static {
        ao3.a(5, "Edition");
        values();
    }

    zo0(int i) {
        this.b = i;
    }

    public static zo0 b(int i) {
        if (i == 0) {
            return EDITION_UNKNOWN;
        }
        if (i == 1) {
            return EDITION_1_TEST_ONLY;
        }
        if (i == 2) {
            return EDITION_2_TEST_ONLY;
        }
        if (i == 900) {
            return EDITION_LEGACY;
        }
        if (i == 9999) {
            return EDITION_UNSTABLE;
        }
        if (i == Integer.MAX_VALUE) {
            return EDITION_MAX;
        }
        switch (i) {
            case 998:
                return EDITION_PROTO2;
            case 999:
                return EDITION_PROTO3;
            case 1000:
                return EDITION_2023;
            case 1001:
                return EDITION_2024;
            default:
                switch (i) {
                    case 99997:
                        return EDITION_99997_TEST_ONLY;
                    case 99998:
                        return EDITION_99998_TEST_ONLY;
                    case 99999:
                        return EDITION_99999_TEST_ONLY;
                    default:
                        return null;
                }
        }
    }

    @Override // defpackage.g12
    public final int a() {
        return this.b;
    }
}
