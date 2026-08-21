package defpackage;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class gq {
    public static final Properties a;

    static {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            a = properties;
        } finally {
        }
    }
}
