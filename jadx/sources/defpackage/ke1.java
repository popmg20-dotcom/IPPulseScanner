package defpackage;

import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ke1 {
    public static final String[] a = new String[0];

    static {
        Character.toString('.');
        char c = File.separatorChar;
        if (c != '/' && c != '\\') {
            xe.k(String.valueOf(c));
        } else {
            Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
            Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9-]*$");
        }
    }
}
