package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class s12 extends IOException {
    public static s12 a() {
        return new s12("Protocol message had invalid UTF-8.");
    }

    public static s12 b() {
        return new s12("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final IOException c() {
        return getCause() instanceof IOException ? (IOException) getCause() : this;
    }
}
