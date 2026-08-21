package defpackage;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public interface cq extends lz3, ReadableByteChannel {
    byte[] B();

    int D(qw2 qw2Var);

    InputStream E0();

    String W(Charset charset);

    bu f0();

    hp h();

    he3 peek();

    boolean request(long j);

    long u0(ge3 ge3Var);
}
