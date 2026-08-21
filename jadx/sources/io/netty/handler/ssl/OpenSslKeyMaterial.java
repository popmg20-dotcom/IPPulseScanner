package io.netty.handler.ssl;

import io.netty.util.ReferenceCounted;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
interface OpenSslKeyMaterial extends ReferenceCounted {
    X509Certificate[] certificateChain();

    long certificateChainAddress();

    long privateKeyAddress();

    @Override // io.netty.util.ReferenceCounted
    boolean release();

    @Override // io.netty.util.ReferenceCounted
    boolean release(int i);

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial retain();

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial retain(int i);

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial touch();

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial touch(Object obj);
}
