package defpackage;

import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class j44 extends es2 {
    public static final j44 e = new j44(ChannelUtils.WRITE_STATUS_SNDBUF_FULL, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, null);
    public byte[] a;
    public int b;
    public int c;
    public int d;

    public j44(int i, int i2, byte[] bArr) {
        super(0);
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d |= 8;
    }

    public final void a(int i, int i2, byte[] bArr) {
        int i3 = i2 - i;
        f(i3);
        System.arraycopy(bArr, i, this.a, this.c, i3);
        this.c += i3;
    }

    public final void b(int i, k0 k0Var) {
        f(7);
        int i2 = this.c;
        this.c = k0Var.f(i, i2, this.a) + i2;
    }

    public final boolean c() {
        return (this.d & 2) != 0;
    }

    public final boolean d() {
        return (this.d & 1) != 0;
    }

    public final int e() {
        return this.c - this.b;
    }

    public final void f(int i) {
        boolean z = (this.d & 8) != 0;
        int i2 = this.c;
        int i3 = this.b;
        if (z) {
            int i4 = i2 - i3;
            byte[] bArr = new byte[i + i4 + 16];
            System.arraycopy(this.a, i3, bArr, 0, i4);
            this.a = bArr;
            this.c -= this.b;
            this.b = 0;
            this.d &= -9;
            return;
        }
        int i5 = i2 - i3;
        int i6 = i + i5;
        byte[] bArr2 = this.a;
        if (i6 >= bArr2.length) {
            byte[] bArr3 = new byte[i6 + 16];
            System.arraycopy(bArr2, i3, bArr3, 0, i5);
            this.a = bArr3;
        }
    }

    @Override // defpackage.es2
    public final String getName() {
        return "String";
    }

    @Override // defpackage.es2
    public final String toString(int i) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("\n  flags: ");
        StringBuilder sb3 = new StringBuilder();
        if (d()) {
            sb3.append("RAW ");
        }
        if (c()) {
            sb3.append("AMBIG ");
        }
        if ((this.d & 4) != 0) {
            sb3.append("DONT_GET_OPT_INFO ");
        }
        if ((this.d & 8) != 0) {
            sb3.append("SHARED ");
        }
        sb2.append(sb3.toString());
        sb.append(sb2.toString());
        sb.append("\n  bytes: '");
        for (int i2 = this.b; i2 < this.c; i2++) {
            byte b = this.a[i2];
            int i3 = b & 255;
            if (i3 < 32 || i3 >= 127) {
                sb.append(String.format("[0x%02x]", Byte.valueOf(b)));
            } else {
                sb.append((char) b);
            }
        }
        sb.append("'");
        return sb.toString();
    }

    public j44() {
        this(24);
    }

    public j44(int i) {
        super(0);
        this.a = new byte[i];
    }
}
