package defpackage;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xu0 implements Executor {
    public static final xu0 b;
    public static final /* synthetic */ xu0[] f;

    static {
        xu0 xu0Var = new xu0("INSTANCE", 0);
        b = xu0Var;
        f = new xu0[]{xu0Var};
    }

    public static xu0 valueOf(String str) {
        return (xu0) Enum.valueOf(xu0.class, str);
    }

    public static xu0[] values() {
        return (xu0[]) f.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "DirectExecutor";
    }
}
