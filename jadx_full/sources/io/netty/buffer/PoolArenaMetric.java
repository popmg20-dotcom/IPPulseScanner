package io.netty.buffer;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface PoolArenaMetric extends SizeClassesMetric {
    List<PoolChunkListMetric> chunkLists();

    long numActiveAllocations();

    long numActiveBytes();

    long numActiveHugeAllocations();

    long numActiveNormalAllocations();

    long numActiveSmallAllocations();

    @Deprecated
    long numActiveTinyAllocations();

    long numAllocations();

    int numChunkLists();

    long numDeallocations();

    long numHugeAllocations();

    long numHugeDeallocations();

    long numNormalAllocations();

    long numNormalDeallocations();

    long numSmallAllocations();

    long numSmallDeallocations();

    int numSmallSubpages();

    int numThreadCaches();

    @Deprecated
    long numTinyAllocations();

    @Deprecated
    long numTinyDeallocations();

    @Deprecated
    int numTinySubpages();

    List<PoolSubpageMetric> smallSubpages();

    @Deprecated
    List<PoolSubpageMetric> tinySubpages();
}
