package io.sentry.internal.modules;

import android.content.Context;
import com.getsurfboard.ui.SurfboardApp;
import io.sentry.ILogger;
import io.sentry.android.core.g;
import io.sentry.p5;
import io.sentry.p6;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f extends d {
    public final /* synthetic */ int e = 1;
    public final Object f;

    public f(SurfboardApp surfboardApp, p6 p6Var) {
        super(p6Var.getLogger());
        Context applicationContext = surfboardApp.getApplicationContext();
        this.f = applicationContext != null ? applicationContext : surfboardApp;
        try {
            p6Var.getExecutorService().submit(new g(9, this));
        } catch (Throwable th) {
            p6Var.getLogger().d(p5.ERROR, "AssetsModulesLoader submit failed", th);
        }
    }

    @Override // io.sentry.internal.modules.d
    public final Map b() {
        int i = this.e;
        ILogger iLogger = this.a;
        Object obj = this.f;
        switch (i) {
            case 0:
                TreeMap treeMap = new TreeMap();
                try {
                    InputStream resourceAsStream = ((ClassLoader) obj).getResourceAsStream("sentry-external-modules.txt");
                    try {
                        if (resourceAsStream == null) {
                            iLogger.h(p5.INFO, "%s file was not found.", "sentry-external-modules.txt");
                            if (resourceAsStream != null) {
                                resourceAsStream.close();
                            }
                        } else {
                            TreeMap treeMapC = c(resourceAsStream);
                            resourceAsStream.close();
                            treeMap = treeMapC;
                        }
                    } catch (Throwable th) {
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            break;
                        }
                        throw th;
                    }
                    break;
                } catch (IOException e) {
                    iLogger.d(p5.INFO, "Access to resources failed.", e);
                } catch (SecurityException e2) {
                    iLogger.d(p5.INFO, "Access to resources denied.", e2);
                }
                return treeMap;
            case 1:
                TreeMap treeMap2 = new TreeMap();
                try {
                    InputStream inputStreamOpen = ((Context) obj).getAssets().open("sentry-external-modules.txt");
                    try {
                        TreeMap treeMapC2 = c(inputStreamOpen);
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        return treeMapC2;
                    } catch (Throwable th3) {
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                            break;
                        }
                        throw th3;
                    }
                } catch (FileNotFoundException unused) {
                    iLogger.h(p5.INFO, "%s file was not found.", "sentry-external-modules.txt");
                    return treeMap2;
                } catch (IOException e3) {
                    iLogger.d(p5.ERROR, "Error extracting modules.", e3);
                    return treeMap2;
                }
            default:
                TreeMap treeMap3 = new TreeMap();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    Map mapA = ((a) it.next()).a();
                    if (mapA != null) {
                        treeMap3.putAll(mapA);
                    }
                }
                return treeMap3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ILogger iLogger) {
        super(iLogger);
        ClassLoader classLoader = f.class.getClassLoader();
        this.f = io.sentry.util.b.d(classLoader);
    }

    public f(List list, ILogger iLogger) {
        super(iLogger);
        this.f = list;
    }
}
