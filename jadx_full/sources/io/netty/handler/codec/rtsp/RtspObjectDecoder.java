package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectDecoder;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class RtspObjectDecoder extends HttpObjectDecoder {
    public RtspObjectDecoder(int i, int i2, int i3, boolean z) {
        super(i, i2, i3 * 2, false, z);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        boolean zIsContentAlwaysEmpty = super.isContentAlwaysEmpty(httpMessage);
        if (!zIsContentAlwaysEmpty && httpMessage.headers().contains(RtspHeaderNames.CONTENT_LENGTH)) {
            return zIsContentAlwaysEmpty;
        }
        return true;
    }

    public RtspObjectDecoder(int i, int i2, int i3) {
        super(i, i2, i3 * 2, false);
    }

    public RtspObjectDecoder() {
        this(4096, 8192, 8192);
    }
}
