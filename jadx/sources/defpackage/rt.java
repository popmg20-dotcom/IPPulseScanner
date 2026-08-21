package defpackage;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rt extends ue4 {
    public final /* synthetic */ int A;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt(int i) {
        super(ByteBuffer.class);
        this.A = i;
        switch (i) {
            case 1:
                super(InetSocketAddress.class);
                break;
            case 2:
                super(String.class);
                break;
            case 3:
                super(TimeZone.class);
                break;
            default:
                break;
        }
    }

    public static void p(InetSocketAddress inetSocketAddress, i52 i52Var) {
        String strSubstring;
        InetAddress address = inetSocketAddress.getAddress();
        String hostName = address == null ? inetSocketAddress.getHostName() : address.toString().trim();
        int iIndexOf = hostName.indexOf(47);
        if (iIndexOf >= 0) {
            if (iIndexOf == 0) {
                if (address instanceof Inet6Address) {
                    strSubstring = "[" + hostName.substring(1) + "]";
                } else {
                    strSubstring = hostName.substring(1);
                }
                hostName = strSubstring;
            } else {
                hostName = hostName.substring(0, iIndexOf);
            }
        }
        StringBuilder sbQ = ha0.q(hostName, ":");
        sbQ.append(inetSocketAddress.getPort());
        i52Var.G0(sbQ.toString());
    }

    @Override // defpackage.ue4, defpackage.b72
    public boolean c(gt3 gt3Var, Object obj) {
        switch (this.A) {
            case 2:
                return ((String) obj).isEmpty();
            default:
                return super.c(gt3Var, obj);
        }
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) throws IOException {
        switch (this.A) {
            case 0:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                if (byteBuffer.hasArray()) {
                    int iPosition = byteBuffer.position();
                    byte[] bArrArray = byteBuffer.array();
                    int iArrayOffset = byteBuffer.arrayOffset() + iPosition;
                    int iLimit = byteBuffer.limit() - iPosition;
                    i52Var.getClass();
                    i52Var.C(zj.a, bArrArray, iArrayOffset, iLimit);
                    return;
                }
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                gp gpVar = new gp(byteBufferAsReadOnlyBuffer);
                int iRemaining = byteBufferAsReadOnlyBuffer.remaining();
                i52Var.getClass();
                yj yjVar = zj.a;
                dy4 dy4Var = (dy4) i52Var;
                char c = dy4Var.G0;
                vv1 vv1Var = dy4Var.z;
                dy4Var.L0("write a binary value");
                int i = dy4Var.J0;
                int i2 = dy4Var.K0;
                if (i >= i2) {
                    dy4Var.Q0();
                }
                char[] cArr = dy4Var.H0;
                int i3 = dy4Var.J0;
                dy4Var.J0 = i3 + 1;
                cArr[i3] = c;
                if (vv1Var.X != null) {
                    xe.q("Trying to call same allocXxx() method second time");
                    return;
                }
                mp mpVar = vv1Var.f;
                mpVar.getClass();
                int i4 = mp.c[3];
                if (i4 <= 0) {
                    i4 = 0;
                }
                byte[] bArr = (byte[]) mpVar.a.getAndSet(3, null);
                if (bArr == null || bArr.length < i4) {
                    bArr = new byte[i4];
                }
                vv1Var.X = bArr;
                try {
                    if (iRemaining < 0) {
                        dy4Var.U0(yjVar, gpVar, bArr);
                    } else {
                        int iV0 = dy4Var.V0(yjVar, gpVar, bArr, iRemaining);
                        if (iV0 > 0) {
                            dy4Var.g("Too few bytes available: missing " + iV0 + " bytes (out of " + iRemaining + ")");
                            throw null;
                        }
                    }
                    vv1Var.g(bArr);
                    if (dy4Var.J0 >= i2) {
                        dy4Var.Q0();
                    }
                    char[] cArr2 = dy4Var.H0;
                    int i5 = dy4Var.J0;
                    dy4Var.J0 = i5 + 1;
                    cArr2[i5] = c;
                    gpVar.close();
                    return;
                } catch (Throwable th) {
                    vv1Var.g(bArr);
                    throw th;
                }
            case 1:
                p((InetSocketAddress) obj, i52Var);
                return;
            case 2:
                i52Var.G0((String) obj);
                return;
            default:
                i52Var.G0(((TimeZone) obj).getID());
                return;
        }
    }

    @Override // defpackage.ue4, defpackage.b72
    public void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        switch (this.A) {
            case 1:
                InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
                e10 e10VarD = zj4Var.d(inetSocketAddress, g72.Z);
                e10VarD.A = InetSocketAddress.class;
                e10 e10VarE = zj4Var.e(i52Var, e10VarD);
                p(inetSocketAddress, i52Var);
                zj4Var.f(i52Var, e10VarE);
                break;
            case 2:
                i52Var.G0((String) obj);
                break;
            case 3:
                TimeZone timeZone = (TimeZone) obj;
                e10 e10VarD2 = zj4Var.d(timeZone, g72.Z);
                e10VarD2.A = TimeZone.class;
                e10 e10VarE2 = zj4Var.e(i52Var, e10VarD2);
                i52Var.G0(timeZone.getID());
                zj4Var.f(i52Var, e10VarE2);
                break;
            default:
                super.f(obj, i52Var, gt3Var, zj4Var);
                break;
        }
    }
}
