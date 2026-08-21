package io.sentry.android.core.internal.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final e c = new e();
    public final io.sentry.util.a a = new io.sentry.util.a();
    public final ArrayList b = new ArrayList();

    public final ArrayList a() {
        ArrayList arrayList = this.b;
        io.sentry.util.a aVar = this.a;
        aVar.g();
        try {
            if (!arrayList.isEmpty()) {
                aVar.close();
                return arrayList;
            }
            File[] fileArrListFiles = new File("/sys/devices/system/cpu").listFiles();
            if (fileArrListFiles == null) {
                ArrayList arrayList2 = new ArrayList();
                aVar.close();
                return arrayList2;
            }
            for (File file : fileArrListFiles) {
                if (file.getName().matches("cpu[0-9]+")) {
                    try {
                        String strQ = io.sentry.util.b.q(new File(file, "cpufreq/cpuinfo_max_freq"));
                        if (strQ != null) {
                            arrayList.add(Integer.valueOf((int) (Long.parseLong(strQ.trim()) / 1000)));
                        }
                    } catch (IOException | NumberFormatException unused) {
                    }
                }
            }
            aVar.close();
            return arrayList;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
