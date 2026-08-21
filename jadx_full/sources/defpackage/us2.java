package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class us2 {
    public final Context a;
    public CharSequence e;
    public CharSequence f;
    public PendingIntent g;
    public int h;
    public boolean j;
    public v62 k;
    public CharSequence l;
    public String n;
    public Bundle o;
    public String q;
    public final boolean r;
    public final Notification s;
    public boolean t;
    public final ArrayList u;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public final boolean i = true;
    public boolean m = false;
    public int p = 0;

    public us2(Context context, String str) {
        Notification notification = new Notification();
        this.s = notification;
        this.a = context;
        this.q = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.h = 0;
        this.u = new ArrayList();
        this.r = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        Notification notificationBuild;
        Bundle bundle;
        lw2 lw2Var = new lw2(this);
        Notification.Builder builder = (Notification.Builder) lw2Var.c;
        us2 us2Var = (us2) lw2Var.d;
        v62 v62Var = us2Var.k;
        if (v62Var != null) {
            new Notification.BigTextStyle(builder).setBigContentTitle(null).bigText((CharSequence) v62Var.z);
        }
        int i = lw2Var.b;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            notificationBuild = builder.build();
        } else if (i2 >= 24) {
            notificationBuild = builder.build();
            if (i != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && i == 2) {
                    lw2.j(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && i == 1) {
                    lw2.j(notificationBuild);
                }
            }
        } else {
            builder.setExtras((Bundle) lw2Var.e);
            notificationBuild = builder.build();
            if (i != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && i == 2) {
                    lw2.j(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && i == 1) {
                    lw2.j(notificationBuild);
                }
            }
        }
        if (v62Var != null) {
            us2Var.k.getClass();
        }
        if (v62Var != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        return notificationBuild;
    }

    public final void c(String str) {
        this.f = b(str);
    }

    public final void d(v62 v62Var) {
        if (this.k != v62Var) {
            this.k = v62Var;
            if (((us2) v62Var.f) != this) {
                v62Var.f = this;
                d(v62Var);
            }
        }
    }
}
