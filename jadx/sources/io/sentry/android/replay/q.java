package io.sentry.android.replay;

import defpackage.i51;
import defpackage.ye;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    private static final /* synthetic */ i51 $ENTRIES;
    private static final /* synthetic */ q[] $VALUES;
    public static final q INITIAL = new q("INITIAL", 0);
    public static final q STARTED = new q("STARTED", 1);
    public static final q RESUMED = new q("RESUMED", 2);
    public static final q PAUSED = new q("PAUSED", 3);
    public static final q STOPPED = new q("STOPPED", 4);
    public static final q CLOSED = new q("CLOSED", 5);

    private static final /* synthetic */ q[] $values() {
        return new q[]{INITIAL, STARTED, RESUMED, PAUSED, STOPPED, CLOSED};
    }

    static {
        q[] qVarArr$values = $values();
        $VALUES = qVarArr$values;
        $ENTRIES = ye.m(qVarArr$values);
    }

    private q(String str, int i) {
    }

    public static i51 getEntries() {
        return $ENTRIES;
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) $VALUES.clone();
    }
}
