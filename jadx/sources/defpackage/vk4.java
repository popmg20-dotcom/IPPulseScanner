package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vk4 implements Executor {
    public static final vk4 b;
    public static final Handler f;
    public static final /* synthetic */ vk4[] z;

    static {
        vk4 vk4Var = new vk4("INSTANCE", 0);
        b = vk4Var;
        z = new vk4[]{vk4Var};
        f = new Handler(Looper.getMainLooper());
    }

    public static vk4 valueOf(String str) {
        return (vk4) Enum.valueOf(vk4.class, str);
    }

    public static vk4[] values() {
        return (vk4[]) z.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f.post(runnable);
    }
}
