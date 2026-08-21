package defpackage;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import com.tencent.mars.xlog.Xlog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hk2 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public /* synthetic */ Object Y;
    public final /* synthetic */ Context Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hk2(Context context, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = context;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((hk2) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Context context = this.Z;
        switch (i) {
            case 0:
                hk2 hk2Var = new hk2(context, ge0Var, 0);
                hk2Var.Y = obj;
                return hk2Var;
            default:
                hk2 hk2Var2 = new hk2(context, ge0Var, 1);
                hk2Var2.Y = obj;
                return hk2Var2;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) throws IOException {
        switch (this.X) {
            case 0:
                n12.S(obj);
                Context context = this.Z;
                SystemClock.elapsedRealtime();
                File fileN = xb5.n(context);
                if (fileN == null) {
                    return null;
                }
                File file = new File(fileN, "surfboard.hprof");
                file.createNewFile();
                Debug.dumpHprofData(file.getAbsolutePath());
                return file;
            default:
                n12.S(obj);
                Context context2 = this.Z;
                SystemClock.elapsedRealtime();
                File file2 = new File(context2.getExternalCacheDir(), "logs");
                file2.mkdirs();
                File file3 = new File(file2, "surfboard_logs.zip");
                file3.createNewFile();
                File file4 = new File(file3.getParentFile(), "logcat.log");
                FileOutputStream fileOutputStream = new FileOutputStream(file4);
                try {
                    co4.o(fileOutputStream);
                    fileOutputStream.close();
                    try {
                        if (fy4.b) {
                            new Xlog().appenderFlush(0L, true);
                        }
                        break;
                    } catch (Throwable unused) {
                    }
                    ry4 ry4Var = new ry4();
                    ry4Var.A = new ed4((byte) 0, 28);
                    ry4Var.X = 4096;
                    ry4Var.Y = new ArrayList();
                    ry4Var.Z = true;
                    ry4Var.b = file3;
                    ry4Var.z = new r51();
                    ry4Var.g(file4);
                    File[] fileArrListFiles = new File(context2.getFilesDir(), "logs").listFiles();
                    if (fileArrListFiles != null) {
                        ArrayList arrayList = new ArrayList();
                        for (File file5 : fileArrListFiles) {
                            if (file5.isFile() && le1.S(file5).equals("xlog")) {
                                arrayList.add(file5);
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ry4Var.g((File) it.next());
                        }
                    }
                    file4.delete();
                    return file3;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        ez4.l(fileOutputStream, th);
                        throw th2;
                    }
                }
        }
    }
}
