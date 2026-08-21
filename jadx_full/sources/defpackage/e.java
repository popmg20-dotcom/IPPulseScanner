package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.DefaultLifecycleObserver;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e implements DefaultLifecycleObserver {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ Object f;

    public e(z00 z00Var) {
        this.f = z00Var;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(da2 da2Var) {
        switch (this.b) {
            case 0:
                da2Var.getClass();
                break;
            default:
                da2Var.getClass();
                break;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(da2 da2Var) {
        switch (this.b) {
            case 0:
                da2Var.getClass();
                break;
            default:
                da2Var.getClass();
                break;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(da2 da2Var) {
        switch (this.b) {
            case 0:
                da2Var.getClass();
                break;
            default:
                da2Var.getClass();
                break;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(da2 da2Var) {
        switch (this.b) {
            case 0:
                da2Var.getClass();
                break;
            default:
                (Build.VERSION.SDK_INT >= 28 ? da0.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new pp1(1), 500L);
                ((r92) this.f).c(this);
                break;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(da2 da2Var) {
        switch (this.b) {
            case 0:
                ((z00) this.f).d(xl4.a);
                break;
            default:
                da2Var.getClass();
                break;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(da2 da2Var) {
        switch (this.b) {
            case 0:
                da2Var.getClass();
                break;
            default:
                da2Var.getClass();
                break;
        }
    }

    public e(EmojiCompatInitializer emojiCompatInitializer, r92 r92Var) {
        this.f = r92Var;
    }
}
