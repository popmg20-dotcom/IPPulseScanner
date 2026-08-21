package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum sd implements ca3 {
    ARM32(0),
    ARM64(1),
    X86(2),
    X86_64(3),
    RISCV64(4),
    NONE(5),
    UNRECOGNIZED(-1);

    public final int b;

    static {
        ao3.a(4, "Architecture");
        values();
    }

    sd(int i) {
        this.b = i;
    }

    @Override // defpackage.g12
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.b;
        }
        xe.k("Can't get the number of an unknown enum value.");
        return 0;
    }
}
