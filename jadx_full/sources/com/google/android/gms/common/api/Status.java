package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.tencent.mars.xlog.Xlog;
import defpackage.ab0;
import defpackage.gb4;
import defpackage.gl4;
import defpackage.v62;
import defpackage.y1;
import defpackage.ye;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.Arrays;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Status extends y1 implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new gl4(25);
    public final ab0 A;
    public final int b;
    public final String f;
    public final PendingIntent z;

    public Status(int i, String str, PendingIntent pendingIntent, ab0 ab0Var) {
        this.b = i;
        this.f = str;
        this.z = pendingIntent;
        this.A = ab0Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.b == status.b && gb4.I(this.f, status.f) && gb4.I(this.z, status.z) && gb4.I(this.A, status.A);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.f, this.z, this.A});
    }

    public final String toString() {
        v62 v62Var = new v62(this);
        String string = this.f;
        if (string == null) {
            int i = this.b;
            switch (i) {
                case -1:
                    string = "SUCCESS_CACHE";
                    break;
                case 0:
                    string = "SUCCESS";
                    break;
                case 1:
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                case 11:
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                default:
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
                    sb.append("unknown status code: ");
                    sb.append(i);
                    string = sb.toString();
                    break;
                case 2:
                    string = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    string = "SERVICE_DISABLED";
                    break;
                case 4:
                    string = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    string = "INVALID_ACCOUNT";
                    break;
                case 6:
                    string = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    string = "NETWORK_ERROR";
                    break;
                case 8:
                    string = "INTERNAL_ERROR";
                    break;
                case 10:
                    string = "DEVELOPER_ERROR";
                    break;
                case 13:
                    string = "ERROR";
                    break;
                case 14:
                    string = "INTERRUPTED";
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    string = "TIMEOUT";
                    break;
                case 16:
                    string = "CANCELED";
                    break;
                case 17:
                    string = "API_NOT_CONNECTED";
                    break;
                case 18:
                    string = "DEAD_CLIENT";
                    break;
                case 19:
                    string = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    string = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    string = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    string = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        v62Var.o(string, "statusCode");
        v62Var.o(this.z, "resolution");
        return v62Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.Q(parcel, 2, this.f);
        ye.P(parcel, 3, this.z, i);
        ye.P(parcel, 4, this.A, i);
        ye.W(parcel, iV);
    }
}
