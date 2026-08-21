package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xn implements ServiceConnection {
    public boolean b = false;
    public final LinkedBlockingQueue f = new LinkedBlockingQueue();

    public final IBinder a() throws TimeoutException {
        tj4.h("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.b) {
            xe.q("Cannot call get on this connection more than once");
            return null;
        }
        this.b = true;
        IBinder iBinder = (IBinder) this.f.poll(10000L, TimeUnit.MILLISECONDS);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
