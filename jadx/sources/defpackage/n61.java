package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.ExecutionException;
import javax.management.MBeanException;
import javax.management.ReflectionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n61 {
    public static Throwable a(Throwable th) {
        Exception targetException;
        if (th == null) {
            return th;
        }
        if (th instanceof UndeclaredThrowableException) {
            Throwable undeclaredThrowable = ((UndeclaredThrowableException) th).getUndeclaredThrowable();
            if (undeclaredThrowable != null) {
                return a(undeclaredThrowable);
            }
            Throwable cause = th.getCause();
            if (cause != th) {
                return a(cause);
            }
        } else if (th instanceof InvocationTargetException) {
            Throwable targetException2 = ((InvocationTargetException) th).getTargetException();
            if (targetException2 != null) {
                return a(targetException2);
            }
        } else if (th instanceof ExecutionException) {
            Throwable cause2 = th.getCause();
            if (cause2 != null) {
                th = cause2;
            }
            return a(th);
        }
        if (!uw2.b()) {
            if (th instanceof ReflectionException) {
                Exception targetException3 = ((ReflectionException) th).getTargetException();
                if (targetException3 != null) {
                    return a(targetException3);
                }
            } else if ((th instanceof MBeanException) && (targetException = ((MBeanException) th).getTargetException()) != null) {
                return a(targetException);
            }
        }
        return th;
    }
}
