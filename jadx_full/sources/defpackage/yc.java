package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yc implements gd1 {
    public final rw2 a;
    public final qt b;
    public final ApplicationInfo c;

    public yc(rw2 rw2Var, qt qtVar, ApplicationInfo applicationInfo) {
        this.a = rw2Var;
        this.b = qtVar;
        this.c = applicationInfo;
    }

    @Override // defpackage.gd1
    public final Object a(ge0 ge0Var) {
        qt qtVar = this.b;
        Context context = (Context) qtVar.c;
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = this.c;
        Drawable drawableLoadUnbadgedIcon = applicationInfo.loadUnbadgedIcon(packageManager);
        UserHandle userHandleP = ga5.p(applicationInfo.uid);
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) qtVar.d;
        ad adVar = (ad) concurrentLinkedQueue.poll();
        if (adVar == null) {
            adVar = new ad(context, qtVar.b);
        }
        try {
            Bitmap bitmap = (Bitmap) adVar.g(drawableLoadUnbadgedIcon, userHandleP, adVar.D0).f;
            concurrentLinkedQueue.offer(adVar);
            return new ox0(new BitmapDrawable(this.a.a.getResources(), bitmap), true, pi0.z);
        } catch (Throwable th) {
            concurrentLinkedQueue.offer(adVar);
            throw th;
        }
    }
}
