package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mars.xlog.Xlog;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class oz4 extends Binder implements IInterface {
    public final /* synthetic */ int c = 0;

    public oz4(String str) {
        attachInterface(this, str);
    }

    public boolean E(int i, Parcel parcel, Parcel parcel2) {
        return false;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i = this.c;
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (this.c) {
            case 0:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i2)) {
                    return true;
                }
                b05 b05Var = (b05) this;
                boolean z = false;
                switch (i) {
                    case 3:
                        xz4.b(parcel);
                        break;
                    case 4:
                        xz4.b(parcel);
                        break;
                    case 5:
                    default:
                        return false;
                    case 6:
                        xz4.b(parcel);
                        break;
                    case 7:
                        xz4.b(parcel);
                        break;
                    case 8:
                        m05 m05Var = (m05) xz4.a(parcel, m05.CREATOR);
                        xz4.b(parcel);
                        b05Var.e.post(new um1(13, b05Var, m05Var, z));
                        break;
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        xz4.b(parcel);
                        break;
                }
                parcel2.writeNoException();
                return true;
            default:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i2)) {
                    return true;
                }
                return E(i, parcel, parcel2);
        }
    }

    public /* synthetic */ oz4() {
    }
}
