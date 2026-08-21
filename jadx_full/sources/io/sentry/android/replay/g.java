package io.sentry.android.replay;

import defpackage.pl1;
import defpackage.r82;
import io.sentry.p5;
import io.sentry.p6;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g extends r82 implements pl1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ j z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(j jVar, int i) {
        super(0);
        this.f = i;
        this.z = jVar;
    }

    @Override // defpackage.pl1
    public final Object a() throws IOException {
        int i = this.f;
        File file = null;
        j jVar = this.z;
        switch (i) {
            case 0:
                if (jVar.s() != null) {
                    file = new File(jVar.s(), ".ongoing_segment");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                }
                return file;
            default:
                p6 p6Var = jVar.b;
                io.sentry.protocol.w wVar = jVar.f;
                p6Var.getClass();
                wVar.getClass();
                String cacheDirPath = p6Var.getCacheDirPath();
                if (cacheDirPath == null || cacheDirPath.length() == 0) {
                    p6Var.getLogger().h(p5.WARNING, "SentryOptions.cacheDirPath is not set, session replay is no-op", new Object[0]);
                    return null;
                }
                String cacheDirPath2 = p6Var.getCacheDirPath();
                cacheDirPath2.getClass();
                File file2 = new File(cacheDirPath2, "replay_" + wVar);
                file2.mkdirs();
                return file2;
        }
    }
}
