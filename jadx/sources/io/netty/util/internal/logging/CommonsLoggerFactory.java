package io.netty.util.internal.logging;

import defpackage.be2;
import defpackage.do3;
import defpackage.eo3;
import defpackage.we2;
import defpackage.xe2;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class CommonsLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE = new CommonsLoggerFactory();

    @Deprecated
    public CommonsLoggerFactory() {
    }

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        ConcurrentHashMap concurrentHashMap = eo3.b.a;
        be2 be2Var = (be2) concurrentHashMap.get(str);
        if (be2Var == null) {
            we2 we2VarD = xe2.d(str);
            do3 do3Var = new do3();
            do3Var.b = we2VarD;
            be2Var = (be2) concurrentHashMap.putIfAbsent(str, do3Var);
            if (be2Var == null) {
                be2Var = do3Var;
            }
        }
        return new CommonsLogger(be2Var, str);
    }
}
