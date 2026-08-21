package defpackage;

import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class fk {
    public final /* synthetic */ int a;
    public final int b;
    public final int c;
    public final int d;
    public final Object e;
    public final Object f;
    public Object g;

    public fk(View view) {
        this.a = 1;
        this.e = new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
        this.f = view;
        Context context = view.getContext();
        this.b = ek0.C(context, R.attr.motionDurationMedium2, 300);
        this.c = ek0.C(context, R.attr.motionDurationShort3, 150);
        this.d = ek0.C(context, R.attr.motionDurationShort2, 100);
    }

    public String toString() {
        String str;
        switch (this.a) {
            case 0:
                synchronized (this) {
                    try {
                        str = (String) this.g;
                        if (str == null) {
                            str = getClass().getSimpleName() + "[" + ((String) this.e) + ", ivSize=" + this.b + ", kdfSize=" + this.c + "," + ((String) this.f) + ", blkSize=" + this.d + "]";
                            this.g = str;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return str;
            default:
                return super.toString();
        }
    }

    public fk(String str, int i, int i2, int i3, String str2) {
        this.a = 0;
        this.b = i;
        this.c = i2;
        this.e = n12.g(str, "No algorithm");
        this.f = n12.g(str2, "No transformation");
        this.d = i3;
    }
}
