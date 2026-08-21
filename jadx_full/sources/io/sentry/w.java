package io.sentry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w implements s1 {
    public final p6 b;

    public static Boolean c(String str, List list, List list2) {
        if (str == null || str.isEmpty()) {
            return Boolean.TRUE;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (str.startsWith((String) it.next())) {
                return Boolean.TRUE;
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            if (str.startsWith((String) it2.next())) {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    @Override // io.sentry.s1
    public boolean a() {
        return n5.d().c(this.b.getFatalLogger());
    }

    public ArrayList b(StackTraceElement[] stackTraceElementArr, boolean z) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if (z || !className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.") || className.startsWith("io.sentry.mobile.")) {
                    io.sentry.protocol.a0 a0Var = new io.sentry.protocol.a0();
                    p6 p6Var = this.b;
                    a0Var.B0 = c(className, p6Var.getInAppIncludes(), p6Var.getInAppExcludes());
                    a0Var.Y = className;
                    a0Var.X = stackTraceElement.getMethodName();
                    a0Var.A = stackTraceElement.getFileName();
                    if (stackTraceElement.getLineNumber() >= 0) {
                        a0Var.Z = Integer.valueOf(stackTraceElement.getLineNumber());
                    }
                    a0Var.D0 = Boolean.valueOf(stackTraceElement.isNativeMethod());
                    arrayList.add(a0Var);
                    if (arrayList.size() >= 100) {
                        break;
                    }
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }
}
