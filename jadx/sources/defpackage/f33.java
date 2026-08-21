package defpackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f33 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ f33(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    private final void a() {
        try {
            c();
        } catch (Error e) {
            synchronized (((at3) this.f).b) {
                ((at3) this.f).A = 1;
                throw e;
            }
        }
    }

    private final void b() {
        ua4 ua4VarB;
        long jNanoTime;
        ua4 ua4VarB2;
        ab4 ab4Var = (ab4) this.f;
        synchronized (ab4Var) {
            ab4Var.g++;
            ua4VarB = ab4Var.b();
        }
        if (ua4VarB == null) {
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        while (true) {
            try {
                threadCurrentThread.setName(ua4VarB.a);
                Logger logger = ((ab4) this.f).b;
                za4 za4Var = ua4VarB.c;
                za4Var.getClass();
                boolean zIsLoggable = logger.isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jNanoTime = System.nanoTime();
                    ye.D(logger, ua4VarB, za4Var, "starting");
                } else {
                    jNanoTime = -1;
                }
                try {
                    long jA = ua4VarB.a();
                    if (zIsLoggable) {
                        ye.D(logger, ua4VarB, za4Var, "finished run in " + ye.s(System.nanoTime() - jNanoTime));
                    }
                    ab4 ab4Var2 = (ab4) this.f;
                    synchronized (ab4Var2) {
                        ab4Var2.a(ua4VarB, jA, true);
                        ua4VarB2 = ab4Var2.b();
                    }
                    if (ua4VarB2 == null) {
                        return;
                    } else {
                        ua4VarB = ua4VarB2;
                    }
                } catch (Throwable th) {
                    if (zIsLoggable) {
                        ye.D(logger, ua4VarB, za4Var, "failed a run in " + ye.s(System.nanoTime() - jNanoTime));
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    ab4 ab4Var3 = (ab4) this.f;
                    synchronized (ab4Var3) {
                        ab4Var3.a(ua4VarB, -1L, false);
                        if (!(th2 instanceof InterruptedException)) {
                            throw th2;
                        }
                        Thread.currentThread().interrupt();
                        return;
                    }
                } finally {
                    threadCurrentThread.setName(name);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r1 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
    
        r4.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        defpackage.ez4.r("SequentialExecutor", "Exception while executing runnable " + r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x003a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r10.f     // Catch: java.lang.Throwable -> L4f
            at3 r2 = (defpackage.at3) r2     // Catch: java.lang.Throwable -> L4f
            java.util.ArrayDeque r2 = r2.b     // Catch: java.lang.Throwable -> L4f
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L4f
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.f     // Catch: java.lang.Throwable -> L20
            at3 r0 = (defpackage.at3) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.A     // Catch: java.lang.Throwable -> L20
            r5 = 4
            if (r4 != r5) goto L22
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L44
        L18:
            java.lang.Thread r10 = java.lang.Thread.currentThread()
            r10.interrupt()
            goto L44
        L20:
            r10 = move-exception
            goto L69
        L22:
            long r6 = r0.X     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.X = r6     // Catch: java.lang.Throwable -> L20
            r0.A = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.f     // Catch: java.lang.Throwable -> L20
            at3 r4 = (defpackage.at3) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.b     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L45
            java.lang.Object r10 = r10.f     // Catch: java.lang.Throwable -> L20
            at3 r10 = (defpackage.at3) r10     // Catch: java.lang.Throwable -> L20
            r10.A = r3     // Catch: java.lang.Throwable -> L20
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L44
            goto L18
        L44:
            return
        L45:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L4f
            r1 = r1 | r2
            r4.run()     // Catch: java.lang.Throwable -> L4f java.lang.RuntimeException -> L51
            goto L2
        L4f:
            r10 = move-exception
            goto L6b
        L51:
            r2 = move-exception
            java.lang.String r3 = "SequentialExecutor"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r5.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r6 = "Exception while executing runnable "
            r5.append(r6)     // Catch: java.lang.Throwable -> L4f
            r5.append(r4)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L4f
            defpackage.ez4.r(r3, r4, r2)     // Catch: java.lang.Throwable -> L4f
            goto L2
        L69:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r10     // Catch: java.lang.Throwable -> L4f
        L6b:
            if (r1 == 0) goto L74
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L74:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f33.c():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010e A[PHI: r12
      0x010e: PHI (r12v8 long) = (r12v6 long), (r12v11 long) binds: [B:70:0x011c, B:63:0x0109] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f33.run():void");
    }
}
