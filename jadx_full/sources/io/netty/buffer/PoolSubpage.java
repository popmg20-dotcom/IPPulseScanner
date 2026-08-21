package io.netty.buffer;

import defpackage.dw2;
import defpackage.fw;
import defpackage.ha0;
import defpackage.xe;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class PoolSubpage<T> implements PoolSubpageMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long[] bitmap;
    private int bitmapLength;
    final PoolChunk<T> chunk;
    boolean doNotDestroy;
    final int elemSize;
    private final ReentrantLock lock;
    private int maxNumElems;
    PoolSubpage<T> next;
    private int nextAvail;
    private int numAvail;
    private final int pageShifts;
    PoolSubpage<T> prev;
    private final int runOffset;
    private final int runSize;

    public PoolSubpage(PoolSubpage<T> poolSubpage, PoolChunk<T> poolChunk, int i, int i2, int i3, int i4) {
        this.lock = new ReentrantLock();
        this.chunk = poolChunk;
        this.pageShifts = i;
        this.runOffset = i2;
        this.runSize = i3;
        this.elemSize = i4;
        this.bitmap = new long[i3 >>> 10];
        this.doNotDestroy = true;
        if (i4 != 0) {
            int i5 = i3 / i4;
            this.numAvail = i5;
            this.maxNumElems = i5;
            this.nextAvail = 0;
            int i6 = i5 >>> 6;
            this.bitmapLength = i6;
            if ((i5 & 63) != 0) {
                this.bitmapLength = i6 + 1;
            }
        }
        addToPool(poolSubpage);
    }

    private void addToPool(PoolSubpage<T> poolSubpage) {
        this.prev = poolSubpage;
        PoolSubpage<T> poolSubpage2 = poolSubpage.next;
        this.next = poolSubpage2;
        poolSubpage2.prev = this;
        poolSubpage.next = this;
    }

    private int findNextAvail() {
        long[] jArr = this.bitmap;
        int i = this.bitmapLength;
        for (int i2 = 0; i2 < i; i2++) {
            long j = jArr[i2];
            if ((~j) != 0) {
                return findNextAvail0(i2, j);
            }
        }
        return -1;
    }

    private int findNextAvail0(int i, long j) {
        int i2 = this.maxNumElems;
        int i3 = i << 6;
        for (int i4 = 0; i4 < 64; i4++) {
            if ((1 & j) == 0) {
                int i5 = i3 | i4;
                if (i5 < i2) {
                    return i5;
                }
                return -1;
            }
            j >>>= 1;
        }
        return -1;
    }

    private int getNextAvail() {
        int i = this.nextAvail;
        if (i < 0) {
            return findNextAvail();
        }
        this.nextAvail = -1;
        return i;
    }

    private void removeFromPool() {
        PoolSubpage<T> poolSubpage = this.prev;
        poolSubpage.next = this.next;
        this.next.prev = poolSubpage;
        this.next = null;
        this.prev = null;
    }

    private void setNextAvail(int i) {
        this.nextAvail = i;
    }

    private long toHandle(int i) {
        return ((long) i) | (((long) this.runOffset) << 49) | (((long) (this.runSize >> this.pageShifts)) << 34) | 12884901888L;
    }

    public long allocate() {
        if (this.numAvail == 0 || !this.doNotDestroy) {
            return -1L;
        }
        int nextAvail = getNextAvail();
        if (nextAvail < 0) {
            removeFromPool();
            StringBuilder sbD = dw2.D("No next available bitmap index found (bitmapIdx = ", nextAvail, "), even though there are supposed to be (numAvail = ");
            sbD.append(this.numAvail);
            sbD.append(") out of (maxNumElems = ");
            xe.i(fw.w(") available indexes.", sbD, this.maxNumElems));
            return 0L;
        }
        int i = nextAvail >>> 6;
        long[] jArr = this.bitmap;
        jArr[i] = jArr[i] | (1 << (nextAvail & 63));
        int i2 = this.numAvail - 1;
        this.numAvail = i2;
        if (i2 == 0) {
            removeFromPool();
        }
        return toHandle(nextAvail);
    }

    public void destroy() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk != null) {
            poolChunk.destroy();
        }
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int elementSize() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return -1;
        }
        poolChunk.arena.lock();
        try {
            return this.elemSize;
        } finally {
            this.chunk.arena.unlock();
        }
    }

    public boolean free(PoolSubpage<T> poolSubpage, int i) {
        if (this.elemSize == 0) {
            return true;
        }
        int i2 = i >>> 6;
        long[] jArr = this.bitmap;
        jArr[i2] = jArr[i2] ^ (1 << (i & 63));
        setNextAvail(i);
        int i3 = this.numAvail;
        this.numAvail = i3 + 1;
        if (i3 == 0) {
            addToPool(poolSubpage);
            if (this.maxNumElems > 1) {
                return true;
            }
        }
        if (this.numAvail != this.maxNumElems || this.prev == this.next) {
            return true;
        }
        this.doNotDestroy = false;
        removeFromPool();
        return false;
    }

    public void lock() {
        this.lock.lock();
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int maxNumElements() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return 0;
        }
        poolChunk.arena.lock();
        try {
            return this.maxNumElems;
        } finally {
            this.chunk.arena.unlock();
        }
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int numAvailable() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return 0;
        }
        poolChunk.arena.lock();
        try {
            return this.numAvail;
        } finally {
            this.chunk.arena.unlock();
        }
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int pageSize() {
        return 1 << this.pageShifts;
    }

    public String toString() {
        int i;
        int i2;
        PoolChunk<T> poolChunk = this.chunk;
        int i3 = -1;
        boolean z = true;
        int i4 = 0;
        if (poolChunk == null) {
            i = 0;
        } else {
            poolChunk.arena.lock();
            try {
                if (this.doNotDestroy) {
                    i3 = this.maxNumElems;
                    i = this.numAvail;
                    i2 = this.elemSize;
                } else {
                    i = -1;
                    z = false;
                    i2 = -1;
                }
                this.chunk.arena.unlock();
                int i5 = i2;
                i4 = i3;
                i3 = i5;
            } catch (Throwable th) {
                this.chunk.arena.unlock();
                throw th;
            }
        }
        int i6 = this.runOffset;
        if (!z) {
            return ha0.k("(", i6, ": not in use)");
        }
        StringBuilder sbD = dw2.D("(", i6, ": ");
        sbD.append(i4 - i);
        sbD.append('/');
        sbD.append(i4);
        sbD.append(", offset: ");
        sbD.append(this.runOffset);
        sbD.append(", length: ");
        sbD.append(this.runSize);
        sbD.append(", elemSize: ");
        sbD.append(i3);
        sbD.append(')');
        return sbD.toString();
    }

    public void unlock() {
        this.lock.unlock();
    }

    public PoolSubpage() {
        this.lock = new ReentrantLock();
        this.chunk = null;
        this.pageShifts = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.runSize = -1;
        this.bitmap = null;
    }
}
