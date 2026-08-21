package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cy {
    public static final cy A;
    public static final cy X;
    public static final cy Y;
    public static final /* synthetic */ cy[] Z;
    public static final cy b;
    public static final cy f;
    public static final cy z;

    static {
        cy cyVar = new cy("UNKNOWN", 0);
        b = cyVar;
        cy cyVar2 = new cy("INACTIVE", 1);
        f = cyVar2;
        cy cyVar3 = new cy("SEARCHING", 2);
        z = cyVar3;
        cy cyVar4 = new cy("FLASH_REQUIRED", 3);
        A = cyVar4;
        cy cyVar5 = new cy("CONVERGED", 4);
        X = cyVar5;
        cy cyVar6 = new cy("LOCKED", 5);
        Y = cyVar6;
        Z = new cy[]{cyVar, cyVar2, cyVar3, cyVar4, cyVar5, cyVar6};
    }

    public static cy valueOf(String str) {
        return (cy) Enum.valueOf(cy.class, str);
    }

    public static cy[] values() {
        return (cy[]) Z.clone();
    }
}
