package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class KmpSearchProcessorFactory extends AbstractSearchProcessorFactory {
    private final int[] jumpTable;
    private final byte[] needle;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class Processor implements SearchProcessor {
        private long currentPosition;
        private final int[] jumpTable;
        private final byte[] needle;

        public Processor(byte[] bArr, int[] iArr) {
            this.needle = bArr;
            this.jumpTable = iArr;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            while (true) {
                long j = this.currentPosition;
                if (j <= 0 || PlatformDependent.getByte(this.needle, j) == b) {
                    break;
                }
                this.currentPosition = PlatformDependent.getInt(this.jumpTable, this.currentPosition);
            }
            if (PlatformDependent.getByte(this.needle, this.currentPosition) == b) {
                this.currentPosition++;
            }
            if (this.currentPosition != this.needle.length) {
                return true;
            }
            this.currentPosition = PlatformDependent.getInt(this.jumpTable, r0);
            return false;
        }

        @Override // io.netty.buffer.search.SearchProcessor
        public void reset() {
            this.currentPosition = 0L;
        }
    }

    public KmpSearchProcessorFactory(byte[] bArr) {
        this.needle = (byte[]) bArr.clone();
        int i = 1;
        this.jumpTable = new int[bArr.length + 1];
        int i2 = 0;
        while (i < bArr.length) {
            while (i2 > 0 && bArr[i2] != bArr[i]) {
                i2 = this.jumpTable[i2];
            }
            if (bArr[i2] == bArr[i]) {
                i2++;
            }
            i++;
            this.jumpTable[i] = i2;
        }
    }

    @Override // io.netty.buffer.search.SearchProcessorFactory
    public Processor newSearchProcessor() {
        return new Processor(this.needle, this.jumpTable);
    }
}
