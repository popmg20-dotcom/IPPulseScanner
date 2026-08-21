package io.sentry.cache;

import io.sentry.p5;
import io.sentry.p6;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final Charset a = Charset.forName("UTF-8");

    public static void a(p6 p6Var, String str, String str2) {
        File fileB = b(p6Var, str);
        if (fileB == null) {
            p6Var.getLogger().h(p5.INFO, "Cache dir is not set, cannot delete from scope cache", new Object[0]);
            return;
        }
        File file = new File(fileB, str2);
        p6Var.getLogger().h(p5.DEBUG, "Deleting %s from scope cache", str2);
        if (file.delete()) {
            return;
        }
        p6Var.getLogger().h(p5.INFO, "Failed to delete: %s", file.getAbsolutePath());
    }

    public static File b(p6 p6Var, String str) {
        String cacheDirPath = p6Var.getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        File file = new File(cacheDirPath, str);
        file.mkdirs();
        return file;
    }

    public static Object c(p6 p6Var, String str, String str2, Class cls) {
        File fileB = b(p6Var, str);
        if (fileB == null) {
            p6Var.getLogger().h(p5.INFO, "Cache dir is not set, cannot read from scope cache", new Object[0]);
            return null;
        }
        File file = new File(fileB, str2);
        if (!file.exists()) {
            p6Var.getLogger().h(p5.DEBUG, "No entry stored for %s", str2);
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), a));
            try {
                Object objB = p6Var.getSerializer().b(bufferedReader, cls);
                bufferedReader.close();
                return objB;
            } finally {
            }
        } catch (Throwable th) {
            p6Var.getLogger().b(p5.ERROR, th, "Error reading entity from scope cache: %s", str2);
            return null;
        }
    }

    public static void d(p6 p6Var, Object obj, String str, String str2) {
        File fileB = b(p6Var, str);
        if (fileB == null) {
            p6Var.getLogger().h(p5.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileB, str2));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, a));
                try {
                    p6Var.getSerializer().a(obj, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            p6Var.getLogger().b(p5.ERROR, th, "Error persisting entity: %s", str2);
        }
    }
}
