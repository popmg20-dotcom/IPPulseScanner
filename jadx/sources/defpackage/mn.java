package defpackage;

import com.tencent.mars.xlog.Xlog;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class mn extends re4 {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mn(Optional optional, Optional optional2, int i) {
        super(optional, optional2);
        this.c = i;
    }

    @Override // defpackage.re4
    public final int a() {
        switch (this.c) {
            case 0:
                return 3;
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 8;
            case 4:
                return 9;
            case 5:
                return 10;
            case 6:
                return 11;
            case 7:
                return 12;
            case 8:
                return 13;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return 14;
            case 10:
                return 15;
            default:
                return 21;
        }
    }
}
