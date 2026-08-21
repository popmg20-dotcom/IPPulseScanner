package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jy1 implements ly1 {
    public final /* synthetic */ int b = 0;
    public final ByteBuffer f;
    public final int z;

    public jy1(int i, ByteBuffer byteBuffer) {
        this.z = i;
        this.f = byteBuffer;
    }

    @Override // defpackage.ly1
    public final int a() {
        switch (this.b) {
        }
        return this.z;
    }

    @Override // defpackage.ly1
    public final int c() {
        switch (this.b) {
            case 0:
                return 1;
            default:
                return 2;
        }
    }

    @Override // defpackage.ly1
    public final ByteBuffer h() {
        switch (this.b) {
        }
        return this.f;
    }

    public jy1(ByteBuffer byteBuffer, int i) {
        this.f = byteBuffer;
        this.z = i;
    }
}
