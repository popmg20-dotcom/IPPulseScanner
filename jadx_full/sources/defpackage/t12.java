package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class t12 extends IOException {
    public boolean b;

    public static t12 a() {
        return new t12("Protocol message had invalid UTF-8.");
    }

    public static r12 b() {
        return new r12("Protocol message tag had invalid wire type.");
    }

    public static t12 c() {
        return new t12("CodedInputStream encountered a malformed varint.");
    }

    public static t12 d() {
        return new t12("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static t12 e() {
        return new t12("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
