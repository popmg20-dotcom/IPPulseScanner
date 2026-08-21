package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t14 {
    public static final /* synthetic */ int a = 0;

    static {
        Object tk3Var;
        Object tk3Var2;
        Exception exc = new Exception();
        String simpleName = ez4.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            tk3Var = kk.class.getCanonicalName();
        } catch (Throwable th) {
            tk3Var = new tk3(th);
        }
        if (uk3.a(tk3Var) != null) {
            tk3Var = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            tk3Var2 = t14.class.getCanonicalName();
        } catch (Throwable th2) {
            tk3Var2 = new tk3(th2);
        }
        if (uk3.a(tk3Var2) != null) {
            tk3Var2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
