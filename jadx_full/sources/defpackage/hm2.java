package defpackage;

import android.view.View;
import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class hm2 {
    public static final short[] d = {1000, 500, 333, 250, 200, 167, 143, 125, 111, 100, 91, 83, 77, 71, 67, 63, 59, 56, 53, 50, 48, 45, 43, 42, 40, 38, 37, 36, 34, 33, 32, 31, 30, 29, 29, 28, 27, 26, 26, 25, 24, 24, 23, 23, 22, 22, 21, 21, 20, 20, 20, 19, 19, 19, 18, 18, 18, 17, 17, 17, 16, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10, 10, 10, 10};
    public final /* synthetic */ int a;
    public int b;
    public int c;

    public /* synthetic */ hm2(int i, int i2, int i3) {
        this.a = i3;
        this.b = i;
        this.c = i2;
    }

    public static String c(int i) {
        StringBuilder sb = new StringBuilder("[");
        if ((i & 1) != 0) {
            sb.append("begin-buf ");
        }
        if ((i & 2) != 0) {
            sb.append("begin-line ");
        }
        if ((i & 4) != 0) {
            sb.append("begin-pos ");
        }
        if ((i & 8) != 0) {
            sb.append("end-buf ");
        }
        if ((i & 16) != 0) {
            sb.append("semi-end-buf ");
        }
        if ((i & 32) != 0) {
            sb.append("end-line ");
        }
        if ((i & 16384) != 0) {
            sb.append("anychar-star ");
        }
        if ((i & 32768) != 0) {
            sb.append("anychar-star-pl ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static int e(int i, int i2) {
        return (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE || i > ChannelUtils.WRITE_STATUS_SNDBUF_FULL - i2) ? ChannelUtils.WRITE_STATUS_SNDBUF_FULL : i + i2;
    }

    public static int f(int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        return i < ChannelUtils.WRITE_STATUS_SNDBUF_FULL / i2 ? i * i2 : ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
    }

    public void a(int i) {
        if (i == 8 || i == 16 || i == 32 || i == 1024 || i == 2048) {
            this.c = i | this.c;
        } else {
            this.b = i | this.b;
        }
    }

    public void b(hm2 hm2Var) {
        this.b &= hm2Var.b;
        this.c = hm2Var.c & this.c;
    }

    public int d(hm2 hm2Var, int i, int i2) {
        short s;
        if (i2 <= 0) {
            return -1;
        }
        if (i > 0) {
            int i3 = this.c;
            short[] sArr = d;
            short s2 = 0;
            if (i3 == Integer.MAX_VALUE) {
                s = 0;
            } else {
                int i4 = i3 - this.b;
                s = i4 < 100 ? sArr[i4] : (short) 1;
            }
            int i5 = s * i;
            int i6 = hm2Var.c;
            if (i6 != Integer.MAX_VALUE) {
                int i7 = i6 - hm2Var.b;
                s2 = i7 < 100 ? sArr[i7] : (short) 1;
            }
            int i8 = s2 * i2;
            if (i8 <= i5) {
                if (i8 < i5) {
                    return -1;
                }
                return Integer.compare(this.b, hm2Var.b);
            }
        }
        return 1;
    }

    public void g(rg3 rg3Var) {
        View view = rg3Var.a;
        this.b = view.getLeft();
        this.c = view.getTop();
        view.getRight();
        view.getBottom();
    }

    public xk3 h() {
        return new xk3(this.b, this.c);
    }

    public String toString() {
        switch (this.a) {
            case 3:
                StringBuilder sb = new StringBuilder("<");
                sb.append(this.b);
                sb.append(' ');
                return ha0.p(sb, this.c, '>');
            default:
                return super.toString();
        }
    }

    public /* synthetic */ hm2(int i) {
        this.a = i;
    }
}
