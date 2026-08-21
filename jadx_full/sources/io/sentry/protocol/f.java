package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import io.sentry.p6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f implements k2 {
    public t b;
    public List f;
    public HashMap z;

    public static f a(f fVar, p6 p6Var) {
        ArrayList<DebugImage> arrayList = new ArrayList();
        if (p6Var.getProguardUuid() != null) {
            DebugImage debugImage = new DebugImage();
            debugImage.setType(DebugImage.PROGUARD);
            debugImage.setUuid(p6Var.getProguardUuid());
            arrayList.add(debugImage);
        }
        for (String str : p6Var.getBundleIds()) {
            DebugImage debugImage2 = new DebugImage();
            debugImage2.setType(DebugImage.JVM);
            debugImage2.setDebugId(str);
            arrayList.add(debugImage2);
        }
        if (fVar == null && arrayList.isEmpty()) {
            return null;
        }
        if (fVar == null) {
            fVar = new f();
        }
        if (!arrayList.isEmpty()) {
            if (fVar.f == null) {
                fVar.b(new ArrayList());
            }
            List list = fVar.f;
            if (list != null) {
                for (DebugImage debugImage3 : arrayList) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            list.add(debugImage3);
                            break;
                        }
                        DebugImage debugImage4 = (DebugImage) it.next();
                        if (DebugImage.PROGUARD.equals(debugImage3.getType()) ? DebugImage.PROGUARD.equals(debugImage4.getType()) : DebugImage.JVM.equals(debugImage3.getType()) && DebugImage.JVM.equals(debugImage4.getType()) && debugImage3.getDebugId() != null && debugImage3.getDebugId().equals(debugImage4.getDebugId())) {
                            break;
                        }
                    }
                }
            }
        }
        return fVar;
    }

    public final void b(List list) {
        this.f = list != null ? new ArrayList(list) : null;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("sdk_info");
            cVar.v(iLogger, this.b);
        }
        if (this.f != null) {
            cVar.p("images");
            cVar.v(iLogger, this.f);
        }
        HashMap map = this.z;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.z, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
