package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class k71 {
    public static final /* synthetic */ k71[] b = {new k71("IGNORE", 0), new k71("RESPECT_PERFORMANCE", 1), new k71("RESPECT_ALL", 2)};

    /* JADX INFO: Fake field, exist only in values array */
    k71 EF5;

    public static k71 valueOf(String str) {
        return (k71) Enum.valueOf(k71.class, str);
    }

    public static k71[] values() {
        return (k71[]) b.clone();
    }
}
