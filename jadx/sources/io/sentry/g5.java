package io.sentry;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g5 {
    public final w a;

    public static io.sentry.protocol.v c(Throwable th, io.sentry.protocol.o oVar, Long l, List list, boolean z) {
        Package r0 = th.getClass().getPackage();
        String name = th.getClass().getName();
        io.sentry.protocol.v vVar = new io.sentry.protocol.v();
        String message = th.getMessage();
        if (r0 != null) {
            name = name.replace(r0.getName() + ".", "");
        }
        String name2 = r0 != null ? r0.getName() : null;
        if (list != null && !list.isEmpty()) {
            io.sentry.protocol.c0 c0Var = new io.sentry.protocol.c0(list);
            if (z) {
                c0Var.z = Boolean.TRUE;
            }
            vVar.X = c0Var;
        }
        vVar.A = l;
        vVar.b = name;
        vVar.Y = oVar;
        vVar.z = name2;
        vVar.f = message;
        return vVar;
    }

    public void a(Throwable th, AtomicInteger atomicInteger, HashSet hashSet, ArrayDeque arrayDeque, String str) {
        Thread threadCurrentThread;
        io.sentry.protocol.o oVar;
        boolean z;
        int iIncrementAndGet = atomicInteger.get();
        String str2 = str;
        while (th != null && hashSet.add(th)) {
            if (str2 == null) {
                str2 = "chained";
            }
            if (th instanceof io.sentry.exception.a) {
                io.sentry.exception.a aVar = (io.sentry.exception.a) th;
                io.sentry.protocol.o oVar2 = aVar.b;
                Throwable th2 = aVar.f;
                threadCurrentThread = aVar.z;
                z = aVar.A;
                th = th2;
                oVar = oVar2;
            } else {
                io.sentry.protocol.o oVar3 = new io.sentry.protocol.o();
                threadCurrentThread = Thread.currentThread();
                oVar = oVar3;
                z = false;
            }
            io.sentry.protocol.v vVarC = c(th, oVar, threadCurrentThread != null ? Long.valueOf(threadCurrentThread.getId()) : null, this.a.b(th.getStackTrace(), Boolean.FALSE.equals(oVar.A)), z);
            ArrayDeque arrayDeque2 = arrayDeque;
            arrayDeque2.addFirst(vVarC);
            if (oVar.b == null) {
                oVar.b = str2;
            }
            if (atomicInteger.get() >= 0) {
                oVar.z0 = Integer.valueOf(iIncrementAndGet);
            }
            iIncrementAndGet = atomicInteger.incrementAndGet();
            oVar.y0 = Integer.valueOf(iIncrementAndGet);
            Throwable[] suppressed = th.getSuppressed();
            if (suppressed != null && suppressed.length > 0) {
                int length = suppressed.length;
                int i = 0;
                while (i < length) {
                    a(suppressed[i], atomicInteger, hashSet, arrayDeque2, "suppressed");
                    i++;
                    arrayDeque2 = arrayDeque;
                }
            }
            th = th.getCause();
            str2 = null;
        }
    }

    public ArrayList b(Map map, ArrayList arrayList, boolean z, boolean z2) {
        ArrayList arrayListB;
        Thread threadCurrentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!map.containsKey(threadCurrentThread)) {
            map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        }
        for (Map.Entry entry : map.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            boolean z3 = (thread == threadCurrentThread && !z) || !(arrayList == null || !arrayList.contains(Long.valueOf(thread.getId())) || z);
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
            Thread thread2 = (Thread) entry.getKey();
            io.sentry.protocol.e0 e0Var = new io.sentry.protocol.e0();
            e0Var.z = thread2.getName();
            e0Var.f = Integer.valueOf(thread2.getPriority());
            e0Var.b = Long.valueOf(thread2.getId());
            e0Var.Z = Boolean.valueOf(thread2.isDaemon());
            e0Var.A = thread2.getState().name();
            e0Var.X = Boolean.valueOf(z3);
            if (z2 && (arrayListB = this.a.b(stackTraceElementArr, false)) != null && !arrayListB.isEmpty()) {
                io.sentry.protocol.c0 c0Var = new io.sentry.protocol.c0(arrayListB);
                c0Var.z = Boolean.TRUE;
                e0Var.z0 = c0Var;
            }
            arrayList2.add(e0Var);
        }
        return arrayList2;
    }
}
