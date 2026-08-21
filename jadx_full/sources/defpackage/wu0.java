package defpackage;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wu0 implements Executor {
    public static final wu0 b;
    public static final /* synthetic */ wu0[] f;

    static {
        wu0 wu0Var = new wu0("INSTANCE", 0);
        b = wu0Var;
        f = new wu0[]{wu0Var};
    }

    public static wu0 valueOf(String str) {
        return (wu0) Enum.valueOf(wu0.class, str);
    }

    public static wu0[] values() {
        return (wu0[]) f.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "DirectExecutor";
    }
}
