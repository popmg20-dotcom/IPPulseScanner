package io.netty.channel;

import defpackage.fw;
import defpackage.xe;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class WriteBufferWaterMark {
    private final int high;
    private final int low;
    private static final int DEFAULT_LOW_WATER_MARK = 32768;
    private static final int DEFAULT_HIGH_WATER_MARK = 65536;
    public static final WriteBufferWaterMark DEFAULT = new WriteBufferWaterMark(DEFAULT_LOW_WATER_MARK, DEFAULT_HIGH_WATER_MARK, false);

    public WriteBufferWaterMark(int i, int i2, boolean z) {
        if (z) {
            ObjectUtil.checkPositiveOrZero(i, "low");
            if (i2 < i) {
                xe.k(fw.s(i, i2, "write buffer's high water mark cannot be less than  low water mark (", "): "));
                throw null;
            }
        }
        this.low = i;
        this.high = i2;
    }

    public int high() {
        return this.high;
    }

    public int low() {
        return this.low;
    }

    public String toString() {
        StringBuilder sbB = fw.B(55, "WriteBufferWaterMark(low: ");
        sbB.append(this.low);
        sbB.append(", high: ");
        return fw.w(")", sbB, this.high);
    }

    public WriteBufferWaterMark(int i, int i2) {
        this(i, i2, true);
    }
}
