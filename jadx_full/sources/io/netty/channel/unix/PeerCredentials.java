package io.netty.channel.unix;

import defpackage.fw;
import io.netty.util.internal.EmptyArrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class PeerCredentials {
    private final int[] gids;
    private final int pid;
    private final int uid;

    public PeerCredentials(int i, int i2, int... iArr) {
        this.pid = i;
        this.uid = i2;
        this.gids = iArr == null ? EmptyArrays.EMPTY_INTS : iArr;
    }

    public int[] gids() {
        return (int[]) this.gids.clone();
    }

    public int pid() {
        return this.pid;
    }

    public String toString() {
        StringBuilder sbB = fw.B(128, "UserCredentials[pid=");
        sbB.append(this.pid);
        sbB.append("; uid=");
        sbB.append(this.uid);
        sbB.append("; gids=[");
        int[] iArr = this.gids;
        if (iArr.length > 0) {
            sbB.append(iArr[0]);
            for (int i = 1; i < this.gids.length; i++) {
                sbB.append(", ");
                sbB.append(this.gids[i]);
            }
        }
        sbB.append(']');
        return sbB.toString();
    }

    public int uid() {
        return this.uid;
    }
}
