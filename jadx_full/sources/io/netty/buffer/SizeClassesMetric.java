package io.netty.buffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface SizeClassesMetric {
    int normalizeSize(int i);

    long pageIdx2size(int i);

    long pageIdx2sizeCompute(int i);

    int pages2pageIdx(int i);

    int pages2pageIdxFloor(int i);

    int size2SizeIdx(int i);

    int sizeIdx2size(int i);

    int sizeIdx2sizeCompute(int i);
}
