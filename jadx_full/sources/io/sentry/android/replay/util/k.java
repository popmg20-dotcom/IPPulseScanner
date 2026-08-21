package io.sentry.android.replay.util;

import defpackage.i51;
import defpackage.ye;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    private static final /* synthetic */ i51 $ENTRIES;
    private static final /* synthetic */ k[] $VALUES;
    public static final k SOC_MODEL = new k("SOC_MODEL", 0);
    public static final k SOC_MANUFACTURER = new k("SOC_MANUFACTURER", 1);

    private static final /* synthetic */ k[] $values() {
        return new k[]{SOC_MODEL, SOC_MANUFACTURER};
    }

    static {
        k[] kVarArr$values = $values();
        $VALUES = kVarArr$values;
        $ENTRIES = ye.m(kVarArr$values);
    }

    private k(String str, int i) {
    }

    public static i51 getEntries() {
        return $ENTRIES;
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) $VALUES.clone();
    }
}
