package j$.time;

import com.tencent.mars.xlog.Xlog;
import j$.util.Objects;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;
    public byte a;
    public Object b;

    public t(byte b, Object obj) {
        this.a = b;
        this.b = obj;
    }

    public static Object a(byte b, ObjectInput objectInput) throws IOException {
        switch (b) {
            case 1:
                Duration duration = Duration.ZERO;
                long j = objectInput.readLong();
                long j2 = objectInput.readInt();
                return Duration.i(a.K(j, a.O(j2, 1000000000L)), (int) a.N(j2, 1000000000L));
            case 2:
                Instant instant = Instant.c;
                return Instant.B(objectInput.readLong(), objectInput.readInt());
            case 3:
                i iVar = i.d;
                return i.K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return l.L(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.c;
                i iVar2 = i.d;
                return LocalDateTime.D(i.K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.L(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.c;
                i iVar3 = i.d;
                LocalDateTime localDateTimeD = LocalDateTime.D(i.K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.L(objectInput));
                ZoneOffset zoneOffsetL = ZoneOffset.L(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(localDateTimeD, "localDateTime");
                Objects.requireNonNull(zoneOffsetL, "offset");
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || zoneOffsetL.equals(zoneId)) {
                    return new ZonedDateTime(localDateTimeD, zoneId, zoneOffsetL);
                }
                h.c("ZoneId must match ZoneOffset");
                return null;
            case 7:
                int i = y.d;
                return ZoneId.D(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.L(objectInput);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                int i2 = r.c;
                return new r(l.L(objectInput), ZoneOffset.L(objectInput));
            case 10:
                int i3 = OffsetDateTime.c;
                i iVar4 = i.d;
                return new OffsetDateTime(LocalDateTime.D(i.K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.L(objectInput)), ZoneOffset.L(objectInput));
            case 11:
                int i4 = v.b;
                return v.A(objectInput.readInt());
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                int i5 = x.c;
                int i6 = objectInput.readInt();
                byte b2 = objectInput.readByte();
                j$.time.temporal.a.YEAR.s(i6);
                j$.time.temporal.a.MONTH_OF_YEAR.s(b2);
                return new x(i6, b2);
            case 13:
                int i7 = p.c;
                byte b3 = objectInput.readByte();
                byte b4 = objectInput.readByte();
                n nVarD = n.D(b3);
                Objects.requireNonNull(nVarD, "month");
                j$.time.temporal.a.DAY_OF_MONTH.s(b4);
                if (b4 <= nVarD.C()) {
                    return new p(nVarD.getValue(), b4);
                }
                throw new c("Illegal value for DayOfMonth field, value " + ((int) b4) + " is not valid for month " + nVarD.name());
            case 14:
                s sVar = s.d;
                return s.a(objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.b;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte b = objectInput.readByte();
        this.a = b;
        this.b = a(b, objectInput);
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.a;
        Object obj = this.b;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                Duration duration = (Duration) obj;
                objectOutput.writeLong(duration.a);
                objectOutput.writeInt(duration.b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.a);
                objectOutput.writeInt(instant.b);
                return;
            case 3:
                i iVar = (i) obj;
                objectOutput.writeInt(iVar.a);
                objectOutput.writeByte(iVar.b);
                objectOutput.writeByte(iVar.c);
                return;
            case 4:
                ((l) obj).Q(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                i iVar2 = localDateTime.a;
                objectOutput.writeInt(iVar2.a);
                objectOutput.writeByte(iVar2.b);
                objectOutput.writeByte(iVar2.c);
                localDateTime.b.Q(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.a;
                i iVar3 = localDateTime2.a;
                objectOutput.writeInt(iVar3.a);
                objectOutput.writeByte(iVar3.b);
                objectOutput.writeByte(iVar3.c);
                localDateTime2.b.Q(objectOutput);
                zonedDateTime.b.M(objectOutput);
                zonedDateTime.c.G(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((y) obj).b);
                return;
            case 8:
                ((ZoneOffset) obj).M(objectOutput);
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                r rVar = (r) obj;
                rVar.a.Q(objectOutput);
                rVar.b.M(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.a;
                i iVar4 = localDateTime3.a;
                objectOutput.writeInt(iVar4.a);
                objectOutput.writeByte(iVar4.b);
                objectOutput.writeByte(iVar4.c);
                localDateTime3.b.Q(objectOutput);
                offsetDateTime.b.M(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((v) obj).a);
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                x xVar = (x) obj;
                objectOutput.writeInt(xVar.a);
                objectOutput.writeByte(xVar.b);
                return;
            case 13:
                p pVar = (p) obj;
                objectOutput.writeByte(pVar.a);
                objectOutput.writeByte(pVar.b);
                return;
            case 14:
                s sVar = (s) obj;
                objectOutput.writeInt(sVar.a);
                objectOutput.writeInt(sVar.b);
                objectOutput.writeInt(sVar.c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public t() {
    }
}
