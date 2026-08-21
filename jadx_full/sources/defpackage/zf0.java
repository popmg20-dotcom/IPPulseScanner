package defpackage;

import com.bytedance.tailor.Tailor;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.SurfboardApp;
import io.sentry.a;
import io.sentry.f0;
import io.sentry.f5;
import io.sentry.l0;
import io.sentry.protocol.v;
import io.sentry.r5;
import io.sentry.r6;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zf0 implements f0 {
    public final /* synthetic */ SurfboardApp b;

    public zf0(SurfboardApp surfboardApp) {
        this.b = surfboardApp;
    }

    @Override // io.sentry.f0
    public final f5 n(f5 f5Var, l0 l0Var) throws IOException {
        Object next;
        InputStream inputStream = Runtime.getRuntime().exec("logcat -t 1000 *:V").getInputStream();
        SurfboardApp surfboardApp = this.b;
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = surfboardApp.openFileOutput("logcat.txt", 0);
            try {
                inputStream.getClass();
                fileOutputStreamOpenFileOutput.getClass();
                l72.h(inputStream, fileOutputStreamOpenFileOutput);
                fileOutputStreamOpenFileOutput.close();
                inputStream.close();
                ArrayList arrayListD = f5Var.d();
                if (arrayListD != null) {
                    Iterator it = arrayListD.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (n12.c(((v) next).b, "OutOfMemoryError")) {
                            break;
                        }
                    }
                    if (((v) next) != null) {
                        try {
                            File file = new File(ContextUtilsKt.getContext().getCacheDir().getPath() + "/hprof");
                            if (file.exists() || file.mkdirs()) {
                                File[] fileArrListFiles = file.listFiles();
                                if (fileArrListFiles != null) {
                                    for (File file2 : fileArrListFiles) {
                                        file2.delete();
                                    }
                                }
                                Tailor.dumpHprofData(new File(file, "oom.hprof").getAbsolutePath(), true);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                l0Var.b.add(new a(ha0.x(surfboardApp.getFilesDir().getPath(), "/logcat.txt")));
                return f5Var;
            } finally {
            }
        } finally {
        }
    }

    @Override // io.sentry.f0
    public final r5 x(r5 r5Var) {
        return r5Var;
    }

    @Override // io.sentry.f0
    public final r6 g(r6 r6Var, l0 l0Var) {
        return r6Var;
    }

    @Override // io.sentry.f0
    public final io.sentry.protocol.f0 s(io.sentry.protocol.f0 f0Var, l0 l0Var) {
        return f0Var;
    }
}
