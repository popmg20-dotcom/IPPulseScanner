package io.netty.handler.codec.http.multipart;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class DeleteFileOnExitHook {
    private static final Set<String> FILES = Collections.newSetFromMap(new ConcurrentHashMap());

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: io.netty.handler.codec.http.multipart.DeleteFileOnExitHook.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                DeleteFileOnExitHook.runHook();
            }
        });
    }

    private DeleteFileOnExitHook() {
    }

    public static void add(String str) {
        FILES.add(str);
    }

    public static boolean checkFileExist(String str) {
        return FILES.contains(str);
    }

    public static void remove(String str) {
        FILES.remove(str);
    }

    public static void runHook() {
        Iterator<String> it = FILES.iterator();
        while (it.hasNext()) {
            new File(it.next()).delete();
        }
    }
}
