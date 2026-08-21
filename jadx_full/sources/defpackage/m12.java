package defpackage;

import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class m12 {
    public static final Charset a;
    public static final Charset b;

    static {
        String str = File.separator;
        Charset charsetForName = Charset.forName("UTF-8");
        a = charsetForName;
        b = charsetForName;
    }
}
