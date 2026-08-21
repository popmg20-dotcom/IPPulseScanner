package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class r41 extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r41(int i, int i2, byte[] bArr) {
        super("invalid character property name <%n>".replaceAll("%n", new String(bArr, i, i2 - i)));
        du duVar = q41.f;
    }
}
