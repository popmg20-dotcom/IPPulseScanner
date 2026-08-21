package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tm1 implements Runnable {
    public final /* synthetic */ int b;
    public Object f;
    public final Object z;

    public /* synthetic */ tm1(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    private final void a() {
        gx4 gx4VarC = ((y84) this.z).b.f.c((String) this.f);
        if (gx4VarC == null || n12.c(mc0.j, gx4VarC.j)) {
            return;
        }
        synchronized (((y84) this.z).z) {
            ((y84) this.z).Y.put(l72.m(gx4VarC), gx4VarC);
            y84 y84Var = (y84) this.z;
            ((y84) this.z).Z.put(l72.m(gx4VarC), mw4.a(y84Var.y0, gx4VarC, (ef0) y84Var.f.b, y84Var));
        }
    }

    private final void b() {
        yc5 yc5Var = (yc5) this.z;
        synchronized (yc5Var) {
            try {
                yc5Var.b = false;
                dd5 dd5Var = yc5Var.z;
                if (!dd5Var.m1()) {
                    t65 t65Var = ((k85) dd5Var.f).Y;
                    k85.h(t65Var);
                    t65Var.H0.a("Connected to service");
                    v55 v55Var = (v55) this.f;
                    dd5Var.V0();
                    dd5Var.Z = v55Var;
                    dd5Var.i1();
                    dd5Var.k1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r1 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        ((java.lang.Runnable) r10.f).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        defpackage.zs3.Y.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.f), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
    
        r10.f = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003c A[SYNTHETIC] */
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
            java.lang.Object r2 = r10.z     // Catch: java.lang.Throwable -> L58
            zs3 r2 = (defpackage.zs3) r2     // Catch: java.lang.Throwable -> L58
            java.util.ArrayDeque r2 = r2.f     // Catch: java.lang.Throwable -> L58
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L58
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.z     // Catch: java.lang.Throwable -> L20
            zs3 r0 = (defpackage.zs3) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.z     // Catch: java.lang.Throwable -> L20
            r5 = 4
            if (r4 != r5) goto L22
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L46
        L18:
            java.lang.Thread r10 = java.lang.Thread.currentThread()
            r10.interrupt()
            goto L46
        L20:
            r10 = move-exception
            goto L7d
        L22:
            long r6 = r0.A     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.A = r6     // Catch: java.lang.Throwable -> L20
            r0.z = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.z     // Catch: java.lang.Throwable -> L20
            zs3 r4 = (defpackage.zs3) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.f     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            r10.f = r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L47
            java.lang.Object r10 = r10.z     // Catch: java.lang.Throwable -> L20
            zs3 r10 = (defpackage.zs3) r10     // Catch: java.lang.Throwable -> L20
            r10.z = r3     // Catch: java.lang.Throwable -> L20
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L46
            goto L18
        L46:
            return
        L47:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L58
            r1 = r1 | r2
            r2 = 0
            java.lang.Object r3 = r10.f     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            r3.run()     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
        L55:
            r10.f = r2     // Catch: java.lang.Throwable -> L58
            goto L2
        L58:
            r10 = move-exception
            goto L7f
        L5a:
            r0 = move-exception
            goto L7a
        L5c:
            r3 = move-exception
            java.util.logging.Logger r4 = defpackage.zs3.Y     // Catch: java.lang.Throwable -> L5a
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r6.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r7 = "Exception while executing runnable "
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r7 = r10.f     // Catch: java.lang.Throwable -> L5a
            java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch: java.lang.Throwable -> L5a
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5a
            r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5a
            goto L55
        L7a:
            r10.f = r2     // Catch: java.lang.Throwable -> L58
            throw r0     // Catch: java.lang.Throwable -> L58
        L7d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r10     // Catch: java.lang.Throwable -> L58
        L7f:
            if (r1 == 0) goto L88
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L88:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tm1.c():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0640  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x067b  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x074b  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0865  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x08b9  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x091d  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x035a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:487:0x064f A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v112, types: [gb5] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 3228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tm1.run():void");
    }

    public String toString() {
        int i = this.b;
        Object obj = this.z;
        switch (i) {
            case 0:
                n02 n02Var = new n02(tm1.class.getSimpleName());
                v62 v62Var = new v62(5, false);
                ((v62) n02Var.A).z = v62Var;
                n02Var.A = v62Var;
                v62Var.f = (ca5) obj;
                return n02Var.toString();
            case 11:
                Runnable runnable = (Runnable) this.f;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                StringBuilder sb = new StringBuilder("SequentialExecutorWorker{state=");
                int i2 = ((zs3) obj).z;
                sb.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "null" : "RUNNING" : "QUEUED" : "QUEUING" : "IDLE");
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ tm1(int i, Object obj, Object obj2, boolean z) {
        this.b = i;
        this.z = obj;
        this.f = obj2;
    }

    public tm1(zs3 zs3Var) {
        this.b = 11;
        this.z = zs3Var;
    }
}
