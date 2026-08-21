package j$.io;

import j$.util.Objects;
import j$.util.p1;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.io.BufferedReader;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class BufferedReaderRetargetClass {
    public static Stream lines(BufferedReader bufferedReader) {
        return StreamSupport.stream(new p1((Iterator) Objects.requireNonNull(new a(bufferedReader)), 272), false);
    }
}
