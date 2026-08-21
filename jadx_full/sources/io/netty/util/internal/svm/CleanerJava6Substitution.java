package io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@TargetClass(className = "io.netty.util.internal.CleanerJava6")
final class CleanerJava6Substitution {

    @RecomputeFieldValue(declClassName = "java.nio.DirectByteBuffer", kind = RecomputeFieldValue.Kind.FieldOffset, name = "cleaner")
    @Alias
    private static long CLEANER_FIELD_OFFSET;

    private CleanerJava6Substitution() {
    }
}
