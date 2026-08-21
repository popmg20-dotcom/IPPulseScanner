package defpackage;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import io.sentry.android.core.a1;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ts2 {
    public final Bundle a;
    public IconCompat b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final CharSequence f;
    public final PendingIntent g;

    public ts2(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        IconCompat iconCompatA = i == 0 ? null : IconCompat.a(i);
        Bundle bundle = new Bundle();
        this.d = true;
        this.b = iconCompatA;
        if (iconCompatA != null) {
            int iIntValue = iconCompatA.a;
            if (iIntValue == -1) {
                Object obj = iconCompatA.b;
                if (Build.VERSION.SDK_INT >= 28) {
                    iIntValue = u9.t(obj);
                } else {
                    try {
                        iIntValue = ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
                    } catch (IllegalAccessException e) {
                        a1.e("IconCompat", "Unable to get icon type " + obj, e);
                        iIntValue = -1;
                    } catch (NoSuchMethodException e2) {
                        a1.e("IconCompat", "Unable to get icon type " + obj, e2);
                        iIntValue = -1;
                    } catch (InvocationTargetException e3) {
                        a1.e("IconCompat", "Unable to get icon type " + obj, e3);
                        iIntValue = -1;
                    }
                }
            }
            if (iIntValue == 2) {
                this.e = iconCompatA.b();
            }
        }
        this.f = us2.b(charSequence);
        this.g = pendingIntent;
        this.a = bundle;
        this.c = true;
        this.d = true;
    }
}
