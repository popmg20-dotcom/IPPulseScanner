package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.MultiInstanceInvalidationService;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wm2 extends Binder implements tv1 {
    public final /* synthetic */ MultiInstanceInvalidationService c;

    public wm2(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.c = multiInstanceInvalidationService;
        attachInterface(this, tv1.b);
    }

    public final int a(sv1 sv1Var, String str) {
        sv1Var.getClass();
        int i = 0;
        if (str == null) {
            return 0;
        }
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.c;
        synchronized (multiInstanceInvalidationService.z) {
            try {
                int i2 = multiInstanceInvalidationService.b + 1;
                multiInstanceInvalidationService.b = i2;
                if (multiInstanceInvalidationService.z.register(sv1Var, Integer.valueOf(i2))) {
                    multiInstanceInvalidationService.f.put(Integer.valueOf(i2), str);
                    i = i2;
                } else {
                    multiInstanceInvalidationService.b--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public final void b(sv1 sv1Var, int i) {
        sv1Var.getClass();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.c;
        synchronized (multiInstanceInvalidationService.z) {
            multiInstanceInvalidationService.z.unregister(sv1Var);
        }
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        xm2 xm2Var;
        String str = tv1.b;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        sv1 sv1Var = null;
        sv1 sv1Var2 = null;
        if (i == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(sv1.a);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof sv1)) {
                    rv1 rv1Var = new rv1();
                    rv1Var.c = strongBinder;
                    sv1Var = rv1Var;
                } else {
                    sv1Var = (sv1) iInterfaceQueryLocalInterface;
                }
            }
            int iA = a(sv1Var, parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(iA);
            return true;
        }
        if (i == 2) {
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface(sv1.a);
                if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof sv1)) {
                    rv1 rv1Var2 = new rv1();
                    rv1Var2.c = strongBinder2;
                    sv1Var2 = rv1Var2;
                } else {
                    sv1Var2 = (sv1) iInterfaceQueryLocalInterface2;
                }
            }
            b(sv1Var2, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
        if (i != 3) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        int i3 = parcel.readInt();
        String[] strArrCreateStringArray = parcel.createStringArray();
        strArrCreateStringArray.getClass();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.c;
        synchronized (multiInstanceInvalidationService.z) {
            String str2 = (String) multiInstanceInvalidationService.f.get(Integer.valueOf(i3));
            if (str2 == null) {
                a1.n("ROOM", "Remote invalidation client ID not registered");
            } else {
                int iBeginBroadcast = multiInstanceInvalidationService.z.beginBroadcast();
                int i4 = 0;
                while (true) {
                    xm2Var = multiInstanceInvalidationService.z;
                    if (i4 >= iBeginBroadcast) {
                        break;
                    }
                    try {
                        Object broadcastCookie = xm2Var.getBroadcastCookie(i4);
                        broadcastCookie.getClass();
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str3 = (String) multiInstanceInvalidationService.f.get(num);
                        if (i3 != iIntValue && str2.equals(str3)) {
                            try {
                                ((sv1) multiInstanceInvalidationService.z.getBroadcastItem(i4)).g(strArrCreateStringArray);
                            } catch (RemoteException e) {
                                a1.o("ROOM", "Error invoking a remote callback", e);
                            }
                        }
                        i4++;
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.z.finishBroadcast();
                        throw th;
                    }
                }
                xm2Var.finishBroadcast();
            }
        }
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
