package defpackage;

import io.netty.handler.codec.http.cookie.CookieHeaderNames;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class u93 extends uf2 {
    public static final ws0 A0;
    public static final vn1 B0;
    public static final ws0 C0;
    public static final vn1 D0;
    public static final ws0 E0;
    public static final vn1 F0;
    public static final ws0 G0;
    public static final vn1 H0;

    static {
        ao3.a(4, "Protobuf");
        gt0 gt0VarL = gt0.l(new String[]{"\n\u000eprotobuf.proto\"\u008e\u0001\n\fDnsQueryInfo\u0012\u0012\n\nsession_id\u0018\u0001 \u0001(\u0005\u0012\u0011\n\tdns_query\u0018\u0002 \u0001(\f\u0012\u000b\n\u0003uid\u0018\u0003 \u0001(\u0005\u0012\u0011\n\tsource_ip\u0018\u0004 \u0001(\t\u0012\u0013\n\u000bsource_port\u0018\u0005 \u0001(\u0005\u0012\u000f\n\u0007dest_ip\u0018\u0006 \u0001(\t\u0012\u0011\n\tdest_port\u0018\u0007 \u0001(\u0005\"t\n\u0010DnsQueryStrategy\u0012\f\n\u0004type\u0018\u0001 \u0001(\u0005\u0012\u0014\n\fdns_response\u0018\u0002 \u0001(\f\u0012\u0011\n\tdns_query\u0018\u0003 \u0001(\f\u0012\u000e\n\u0006server\u0018\u0004 \u0001(\t\u0012\f\n\u0004port\u0018\u0005 \u0001(\u0005\u0012\u000b\n\u0003uid\u0018\u0006 \u0001(\u0005\"ï\u0001\n\u000bTrafficInfo\u0012\u0012\n\nsession_id\u0018\u0001 \u0001(\u0005\u0012\r\n\u0005proto\u0018\u0002 \u0001(\u0005\u0012\u000b\n\u0003uid\u0018\u0003 \u0001(\u0005\u0012\f\n\u0004host\u0018\u0004 \u0001(\t\u0012\u0011\n\tsource_ip\u0018\u0005 \u0001(\t\u0012\u0013\n\u000bsource_port\u0018\u0006 \u0001(\u0005\u0012\u000f\n\u0007dest_ip\u0018\u0007 \u0001(\t\u0012\u0011\n\tdest_port\u0018\b \u0001(\u0005\u0012\u000e\n\u0006length\u0018\t \u0001(\u0005\u0012\u0012\n\nproxy_name\u0018\n \u0001(\t\u0012\u0010\n\bprotocol\u0018\u000b \u0001(\t\u0012\f\n\u0004path\u0018\f \u0001(\t\u0012\u0012\n\nuser_agent\u0018\r \u0001(\t\"Z\n\rProxyStrategy\u0012\f\n\u0004type\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003uid\u0018\u0002 \u0001(\u0005\u0012\f\n\u0004host\u0018\u0003 \u0001(\t\u0012\u0012\n\nproxy_name\u0018\u0004 \u0001(\t\u0012\f\n\u0004port\u0018\u0005 \u0001(\u0005B\u001c\n\u001acom.getsurfboard.vpn.protob\u0006proto3"}, new gt0[0]);
        ws0[] ws0VarArr = gt0VarL.z;
        ws0 ws0Var = ws0VarArr[0];
        A0 = ws0Var;
        B0 = new vn1(ws0Var, new String[]{"SessionId", "DnsQuery", "Uid", "SourceIp", "SourcePort", "DestIp", "DestPort"});
        ws0 ws0Var2 = ws0VarArr[1];
        C0 = ws0Var2;
        D0 = new vn1(ws0Var2, new String[]{"Type", "DnsResponse", "DnsQuery", "Server", "Port", "Uid"});
        ws0 ws0Var3 = ws0VarArr[2];
        E0 = ws0Var3;
        F0 = new vn1(ws0Var3, new String[]{"SessionId", "Proto", "Uid", "Host", "SourceIp", "SourcePort", "DestIp", "DestPort", "Length", "ProxyName", "Protocol", CookieHeaderNames.PATH, "UserAgent"});
        ws0 ws0Var4 = ws0VarArr[3];
        G0 = ws0Var4;
        H0 = new vn1(ws0Var4, new String[]{"Type", "Uid", "Host", "ProxyName", "Port"});
        gt0VarL.m();
    }
}
