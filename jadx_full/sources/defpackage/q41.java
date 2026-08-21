package defpackage;

import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public enum q41 {
    /* JADX INFO: Fake field, exist only in values array */
    EF8("ERR_TYPE_BUG", "undefined type (bug)"),
    /* JADX INFO: Fake field, exist only in values array */
    EF20("ERR_TOO_BIG_WIDE_CHAR_VALUE", "too big wide-char value"),
    /* JADX INFO: Fake field, exist only in values array */
    EF32("ERR_TOO_LONG_WIDE_CHAR_VALUE", "too long wide-char value"),
    /* JADX INFO: Fake field, exist only in values array */
    EF44("ERR_INVALID_CHAR_PROPERTY_NAME", "invalid character property name <%n>"),
    /* JADX INFO: Fake field, exist only in values array */
    EF56("ERR_INVALID_CODE_POINT_VALUE", "invalid code point value"),
    /* JADX INFO: Fake field, exist only in values array */
    EF68("ERR_ENCODING_CLASS_DEF_NOT_FOUND", "encoding class <%n> not found"),
    /* JADX INFO: Fake field, exist only in values array */
    EF82("ERR_ENCODING_LOAD_ERROR", "problem loading encoding <%n>"),
    /* JADX INFO: Fake field, exist only in values array */
    EF98("ERR_ENCODING_ALREADY_REGISTERED", "encoding already registerd <%n>"),
    /* JADX INFO: Fake field, exist only in values array */
    EF115("ERR_ENCODING_ALIAS_ALREADY_REGISTERED", "encoding alias already registerd <%n>"),
    /* JADX INFO: Fake field, exist only in values array */
    EF132("ERR_ENCODING_REPLICA_ALREADY_REGISTERED", "encoding replica already registerd <%n>"),
    /* JADX INFO: Fake field, exist only in values array */
    EF149("ERR_NO_SUCH_ENCODNG", "no such encoding <%n>"),
    /* JADX INFO: Fake field, exist only in values array */
    EF166("ERR_COULD_NOT_REPLICATE", "could not replicate <%n> encoding"),
    /* JADX INFO: Fake field, exist only in values array */
    EF183("ERR_TRANSCODER_ALREADY_REGISTERED", "transcoder from <%n> has been already registered"),
    /* JADX INFO: Fake field, exist only in values array */
    EF200("ERR_TRANSCODER_CLASS_DEF_NOT_FOUND", "transcoder class <%n> not found"),
    /* JADX INFO: Fake field, exist only in values array */
    EF217("ERR_TRANSCODER_LOAD_ERROR", "problem loading transcoder <%n>");

    public static final du f = new du(3);
    public final int b;

    static {
        for (q41 q41Var : values()) {
            du duVar = f;
            int i = q41Var.b;
            duVar.a();
            int i2 = i & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
            fr1[] fr1VarArr = duVar.b;
            int length = i2 % fr1VarArr.length;
            fr1 fr1Var = fr1VarArr[length];
            while (true) {
                y02 y02Var = (y02) fr1Var;
                if (y02Var == null) {
                    fr1[] fr1VarArr2 = duVar.b;
                    fr1VarArr2[length] = new y02(i2, fr1VarArr2[length], q41Var, duVar.z);
                    duVar.f++;
                    break;
                } else {
                    if (y02Var.a == i2) {
                        y02Var.e = q41Var;
                        break;
                    }
                    fr1Var = y02Var.b;
                }
            }
        }
    }

    q41(String str, String str2) {
        this.b = i;
    }
}
