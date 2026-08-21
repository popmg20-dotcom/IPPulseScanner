package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.gl4;
import defpackage.tj4;
import defpackage.y1;
import defpackage.ye;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInAccount extends y1 implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new gl4(8);
    public final String A;
    public final List A0;
    public final String B0;
    public final String C0;
    public final HashSet D0 = new HashSet();
    public final String X;
    public final Uri Y;
    public String Z;
    public final int b;
    public final String f;
    public final long y0;
    public final String z;
    public final String z0;

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.b = i;
        this.f = str;
        this.z = str2;
        this.A = str3;
        this.X = str4;
        this.Y = uri;
        this.Z = str5;
        this.y0 = j;
        this.z0 = str6;
        this.A0 = arrayList;
        this.B0 = str7;
        this.C0 = str8;
    }

    public static GoogleSignInAccount a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(1, jSONArray.getString(i)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        tj4.f(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.Z = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.z0.equals(this.z0)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.A0);
        hashSet.addAll(googleSignInAccount.D0);
        HashSet hashSet2 = new HashSet(this.A0);
        hashSet2.addAll(this.D0);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int iHashCode = this.z0.hashCode() + 527;
        HashSet hashSet = new HashSet(this.A0);
        hashSet.addAll(this.D0);
        return (iHashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.Q(parcel, 2, this.f);
        ye.Q(parcel, 3, this.z);
        ye.Q(parcel, 4, this.A);
        ye.Q(parcel, 5, this.X);
        ye.P(parcel, 6, this.Y, i);
        ye.Q(parcel, 7, this.Z);
        ye.U(parcel, 8, 8);
        parcel.writeLong(this.y0);
        ye.Q(parcel, 9, this.z0);
        ye.S(parcel, 10, this.A0);
        ye.Q(parcel, 11, this.B0);
        ye.Q(parcel, 12, this.C0);
        ye.W(parcel, iV);
    }
}
