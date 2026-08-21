package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h71 extends d71 {
    public h71(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.b.mark(ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
        } else {
            xe.k("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            throw null;
        }
    }

    public final void n(long j) throws IOException {
        int i = this.f;
        if (i > j) {
            this.f = 0;
            this.b.reset();
        } else {
            j -= (long) i;
        }
        g((int) j);
    }

    public h71(byte[] bArr) {
        super(bArr);
        this.b.mark(ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
    }
}
