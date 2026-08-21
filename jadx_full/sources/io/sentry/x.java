package io.sentry;

import defpackage.p44;
import defpackage.w44;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements FilenameFilter {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ x(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((z) obj).a(str);
            default:
                io.sentry.android.replay.j jVar = (io.sentry.android.replay.j) obj;
                str.getClass();
                if (w44.d0(str, ".jpg", false)) {
                    File file2 = new File(file, str);
                    String name = file2.getName();
                    name.getClass();
                    Long lN0 = w44.n0(p44.S0(name, "."));
                    if (lN0 != null) {
                        jVar.g(file2, lN0.longValue(), null);
                    }
                }
                return false;
        }
    }
}
