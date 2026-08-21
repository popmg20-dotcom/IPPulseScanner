package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ky1 extends wi1 {
    public final ly1[] A;
    public final int X;
    public final int Y;

    public ky1(my1 my1Var, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2) {
        super(my1Var);
        this.A = new ly1[]{new jy1(i, byteBuffer), new jy1(byteBuffer2, i), new jy1(byteBuffer3, i)};
        this.X = i;
        this.Y = i2;
    }

    @Override // defpackage.wi1, defpackage.my1
    public final int c() {
        return this.Y;
    }

    @Override // defpackage.wi1, defpackage.my1
    public final int f() {
        return this.X;
    }

    @Override // defpackage.wi1, defpackage.my1
    public final ly1[] p() {
        return this.A;
    }
}
