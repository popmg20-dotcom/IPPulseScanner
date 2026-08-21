package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rw3 extends k70 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rw3(int i) {
        super("SHA256withECDSA", b01.nistp256.z);
        switch (i) {
            case 1:
                super("SHA384withECDSA", b01.nistp384.z);
                break;
            case 2:
                super("SHA512withECDSA", b01.nistp521.z);
                break;
            default:
                break;
        }
    }
}
