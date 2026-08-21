package defpackage;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x implements Parcelable.ClassLoaderCreator {
    public final /* synthetic */ int a;

    public /* synthetic */ x(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return y.f;
                }
                xe.q("superState must be null");
                return null;
            case 1:
                return new lo(parcel, null);
            case 2:
                return new c40(parcel, null);
            case 3:
                return new ve0(parcel, null);
            case 4:
                return new a91(parcel, null);
            case 5:
                return new ij1(parcel, null);
            case 6:
                return new gi2(parcel, null);
            case 7:
                return new tp2(parcel, null);
            case 8:
                return new rq2(parcel, null);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new j03(parcel, null);
            case 10:
                return new kg3(parcel, null);
            case 11:
                return new er3(parcel, null);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new yv3(parcel, null);
            case 13:
                return new gy3(parcel);
            case 14:
                return new zb4(parcel, null);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new if4(parcel, null);
            default:
                if (Build.VERSION.SDK_INT >= 24) {
                    return new zq4(parcel, null);
                }
                zq4 zq4Var = new zq4(parcel);
                zq4Var.b = parcel.readInt();
                zq4Var.f = parcel.readInt();
                zq4Var.z = parcel.readParcelable(null);
                return zq4Var;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new y[i];
            case 1:
                return new lo[i];
            case 2:
                return new c40[i];
            case 3:
                return new ve0[i];
            case 4:
                return new a91[i];
            case 5:
                return new ij1[i];
            case 6:
                return new gi2[i];
            case 7:
                return new tp2[i];
            case 8:
                return new rq2[i];
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new j03[i];
            case 10:
                return new kg3[i];
            case 11:
                return new er3[i];
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new yv3[i];
            case 13:
                return new gy3[i];
            case 14:
                return new zb4[i];
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new if4[i];
            default:
                return new zq4[i];
        }
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return y.f;
                }
                xe.q("superState must be null");
                return null;
            case 1:
                return new lo(parcel, classLoader);
            case 2:
                return new c40(parcel, classLoader);
            case 3:
                return new ve0(parcel, classLoader);
            case 4:
                return new a91(parcel, classLoader);
            case 5:
                return new ij1(parcel, classLoader);
            case 6:
                return new gi2(parcel, classLoader);
            case 7:
                return new tp2(parcel, classLoader);
            case 8:
                return new rq2(parcel, classLoader);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new j03(parcel, classLoader);
            case 10:
                return new kg3(parcel, classLoader);
            case 11:
                return new er3(parcel, classLoader);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new yv3(parcel, classLoader);
            case 13:
                return new gy3(parcel);
            case 14:
                return new zb4(parcel, classLoader);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new if4(parcel, classLoader);
            default:
                if (Build.VERSION.SDK_INT >= 24) {
                    return new zq4(parcel, classLoader);
                }
                zq4 zq4Var = new zq4(parcel);
                zq4Var.b = parcel.readInt();
                zq4Var.f = parcel.readInt();
                zq4Var.z = parcel.readParcelable(null);
                return zq4Var;
        }
    }
}
