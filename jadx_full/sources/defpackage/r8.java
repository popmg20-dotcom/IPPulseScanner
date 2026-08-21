package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.getsurfboard.ui.widget.SparklineView;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r8 implements Choreographer.FrameCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ r8(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.a = 1;
        this.b = context;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((d4) obj).run();
                break;
            case 1:
                (Build.VERSION.SDK_INT >= 28 ? u9.c(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new ia((Context) obj, 2), new Random().nextInt(Math.max(1000, 1)) + 5000);
                break;
            default:
                SparklineView sparklineView = (SparklineView) obj;
                if (sparklineView.E0) {
                    sparklineView.Q0 = sparklineView.R0 == 0 ? 16.0f : gb4.t((j - r0) / 1000000.0f, 0.0f, 100.0f);
                    sparklineView.R0 = j;
                    if ((sparklineView.D0 != 0 && SystemClock.elapsedRealtime() - sparklineView.D0 <= 2000) || !sparklineView.P0) {
                        sparklineView.invalidate();
                        Choreographer.getInstance().postFrameCallback(sparklineView.S0);
                    } else {
                        sparklineView.E0 = false;
                    }
                }
                break;
        }
    }

    public /* synthetic */ r8(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
