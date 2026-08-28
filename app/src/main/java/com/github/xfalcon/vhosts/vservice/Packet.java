package com.github.xfalcon.vhosts.vservice;

import com.github.xfalcon.vhosts.util.LogUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import org.xbill.DNS.Message;

/* JADX INFO: loaded from: classes5.dex */
public class Packet {
    private static final int IP4_HEADER_SIZE = 20;
    private static final int IP6_HEADER_SIZE = 40;
    private static final int TCP = 6;
    private static final int TCP_HEADER_SIZE = 20;
    private static final int UDP = 17;
    private static final int UDP_HEADER_SIZE = 8;
    private int IP_HEADER_SIZE;
    public int IP_TRAN_SIZE;
    public ByteBuffer backingBuffer;
    public IPHeader ipHeader;
    private boolean isTCP;
    private boolean isUDP;
    public TCPHeader tcpHeader;
    public UDPHeader udpHeader;

    public Packet(ByteBuffer buffer) throws UnknownHostException {
        byte versionAndIHL = buffer.get();
        byte version = (byte) (versionAndIHL >> 4);
        if (version == 4) {
            this.IP_HEADER_SIZE = 20;
            byte IHL = (byte) (versionAndIHL & 15);
            int headerLength = IHL << 2;
            this.ipHeader = new IP4Header(buffer, version, IHL, headerLength);
        } else if (version == 6) {
            this.IP_HEADER_SIZE = 40;
            this.ipHeader = new IP6Header(buffer, version);
        } else {
            LogUtils.d("Un Know Packet", ((int) version) + "");
            this.isTCP = false;
            this.isUDP = false;
            return;
        }
        if (this.ipHeader.protocol == 6) {
            this.tcpHeader = new TCPHeader(buffer);
            this.isTCP = true;
            this.IP_TRAN_SIZE = this.IP_HEADER_SIZE + 20;
        } else if (this.ipHeader.protocol == 17) {
            this.udpHeader = new UDPHeader(buffer);
            this.isUDP = true;
            this.IP_TRAN_SIZE = this.IP_HEADER_SIZE + 8;
        }
        this.backingBuffer = buffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Packet{");
        sb.append("IpHeader=").append(this.ipHeader);
        if (this.isTCP) {
            sb.append(", tcpHeader=").append(this.tcpHeader);
        } else if (this.isUDP) {
            sb.append(", udpHeader=").append(this.udpHeader);
        }
        sb.append(", payloadSize=").append(this.backingBuffer.limit() - this.backingBuffer.position());
        sb.append('}');
        return sb.toString();
    }

    public boolean isTCP() {
        return this.isTCP;
    }

    public boolean isUDP() {
        return this.isUDP;
    }

    public void swapSourceAndDestination() {
        InetAddress newSourceAddress = this.ipHeader.destinationAddress;
        this.ipHeader.destinationAddress = this.ipHeader.sourceAddress;
        this.ipHeader.sourceAddress = newSourceAddress;
        if (this.isUDP) {
            int newSourcePort = this.udpHeader.destinationPort;
            this.udpHeader.destinationPort = this.udpHeader.sourcePort;
            this.udpHeader.sourcePort = newSourcePort;
            return;
        }
        if (this.isTCP) {
            int newSourcePort2 = this.tcpHeader.destinationPort;
            this.tcpHeader.destinationPort = this.tcpHeader.sourcePort;
            this.tcpHeader.sourcePort = newSourcePort2;
        }
    }

    public void updateTCPBuffer(ByteBuffer buffer, byte flags, long sequenceNum, long ackNum, int payloadSize) {
        buffer.position(0);
        fillHeader(buffer);
        this.backingBuffer = buffer;
        this.tcpHeader.flags = flags;
        this.backingBuffer.put(this.IP_HEADER_SIZE + 13, flags);
        this.tcpHeader.sequenceNumber = sequenceNum;
        this.backingBuffer.putInt(this.IP_HEADER_SIZE + 4, (int) sequenceNum);
        this.tcpHeader.acknowledgementNumber = ackNum;
        this.backingBuffer.putInt(this.IP_HEADER_SIZE + 8, (int) ackNum);
        this.tcpHeader.dataOffsetAndReserved = (byte) 80;
        this.backingBuffer.put(this.IP_HEADER_SIZE + 12, (byte) 80);
        checksum(payloadSize);
        int totalLength = payloadSize + 20;
        this.ipHeader.updateIpHeader(this, totalLength);
    }

    public void updateUDPBuffer(ByteBuffer buffer, int payloadSize) {
        buffer.position(0);
        fillHeader(buffer);
        this.backingBuffer = buffer;
        int udpTotalLength = payloadSize + 8;
        this.backingBuffer.putShort(this.IP_HEADER_SIZE + 4, (short) udpTotalLength);
        this.udpHeader.length = udpTotalLength;
        checksum(payloadSize);
        this.ipHeader.updateIpHeader(this, udpTotalLength);
    }

    private void fillHeader(ByteBuffer buffer) {
        this.ipHeader.fillHeader(buffer);
        if (!this.isUDP) {
            if (!this.isTCP) {
                return;
            }
            this.tcpHeader.fillHeader(buffer);
            return;
        }
        this.udpHeader.fillHeader(buffer);
    }

    private void checksum(int payloadSize) {
        int length;
        int pos;
        int sum = 0;
        if (isTCP()) {
            length = payloadSize + 20;
            pos = 16;
        } else {
            length = payloadSize + 8;
            pos = 6;
        }
        if (this.ipHeader.version == 4) {
            if (isUDP()) {
                this.backingBuffer.putShort(this.IP_HEADER_SIZE + 6, (short) 0);
                this.udpHeader.checksum = 0;
                return;
            } else {
                ByteBuffer buffer = ByteBuffer.wrap(this.ipHeader.sourceAddress.getAddress());
                int sum2 = BitUtils.getUnsignedShort(buffer.getShort()) + BitUtils.getUnsignedShort(buffer.getShort());
                ByteBuffer buffer2 = ByteBuffer.wrap(this.ipHeader.destinationAddress.getAddress());
                sum = this.ipHeader.protocol + length + sum2 + BitUtils.getUnsignedShort(buffer2.getShort()) + BitUtils.getUnsignedShort(buffer2.getShort());
            }
        } else if (this.ipHeader.version == 6) {
            ByteBuffer buffer3 = ByteBufferPool.acquire();
            buffer3.put(this.ipHeader.sourceAddress.getAddress());
            buffer3.put(this.ipHeader.destinationAddress.getAddress());
            buffer3.put((byte) 0);
            buffer3.put(this.ipHeader.protocol);
            buffer3.putInt(length);
            buffer3.rewind();
            for (int i = 0; i < 19; i++) {
                sum += buffer3.getShort() & 65535;
            }
            ByteBufferPool.release(buffer3);
        }
        ByteBuffer buffer4 = this.backingBuffer.duplicate();
        buffer4.putShort(this.IP_HEADER_SIZE + pos, (short) 0);
        buffer4.position(this.IP_HEADER_SIZE);
        while (length > 1) {
            sum += BitUtils.getUnsignedShort(buffer4.getShort());
            length -= 2;
        }
        if (length > 0) {
            sum += BitUtils.getUnsignedByte(buffer4.get()) << 8;
        }
        while ((sum >> 16) > 0) {
            sum = (sum & Message.MAXLENGTH) + (sum >> 16);
        }
        int sum3 = ~sum;
        if (!isUDP()) {
            this.tcpHeader.checksum = sum3;
        } else {
            this.udpHeader.checksum = sum3;
        }
        this.backingBuffer.putShort(this.IP_HEADER_SIZE + pos, (short) sum3);
    }

    public static class IPHeader {
        public InetAddress destinationAddress;
        public byte protocol;
        public InetAddress sourceAddress;
        public int totalLength;
        public byte version;

        public void fillHeader(ByteBuffer buffer) {
        }

        public void updateIpHeader(Packet packet, int totalLength) {
        }
    }

    public static class IP4Header extends IPHeader {
        private static byte[] addressBytes = new byte[4];
        private byte IHL;
        private short TTL;
        private int headerChecksum;
        private int headerLength;
        private int identificationAndFlagsAndFragmentOffset;
        public int optionsAndPadding;
        private short typeOfService;

        private IP4Header(ByteBuffer buffer, byte version, byte IHL, int headerLength) throws UnknownHostException {
            this.version = version;
            this.IHL = IHL;
            this.headerLength = headerLength;
            this.typeOfService = BitUtils.getUnsignedByte(buffer.get());
            this.totalLength = BitUtils.getUnsignedShort(buffer.getShort());
            this.identificationAndFlagsAndFragmentOffset = buffer.getInt();
            this.TTL = BitUtils.getUnsignedByte(buffer.get());
            this.protocol = buffer.get();
            this.headerChecksum = BitUtils.getUnsignedShort(buffer.getShort());
            buffer.get(addressBytes);
            this.sourceAddress = InetAddress.getByAddress(addressBytes);
            buffer.get(addressBytes);
            this.destinationAddress = InetAddress.getByAddress(addressBytes);
        }

        @Override // com.github.xfalcon.vhosts.vservice.Packet.IPHeader
        public void fillHeader(ByteBuffer buffer) {
            buffer.put((byte) ((this.version << 4) | this.IHL));
            buffer.put((byte) this.typeOfService);
            buffer.putShort((short) this.totalLength);
            buffer.putInt(this.identificationAndFlagsAndFragmentOffset);
            buffer.put((byte) this.TTL);
            buffer.put(this.protocol);
            buffer.putShort((short) this.headerChecksum);
            buffer.put(this.sourceAddress.getAddress());
            buffer.put(this.destinationAddress.getAddress());
        }

        @Override // com.github.xfalcon.vhosts.vservice.Packet.IPHeader
        public void updateIpHeader(Packet packet, int tcpPayLength) {
            this.totalLength = packet.IP_HEADER_SIZE + tcpPayLength;
            packet.backingBuffer.putShort(2, (short) this.totalLength);
            ByteBuffer buffer = packet.backingBuffer.duplicate();
            buffer.position(0);
            buffer.putShort(10, (short) 0);
            int sum = 0;
            for (int ipLength = this.headerLength; ipLength > 0; ipLength -= 2) {
                sum += BitUtils.getUnsignedShort(buffer.getShort());
            }
            while ((sum >> 16) > 0) {
                sum = (65535 & sum) + (sum >> 16);
            }
            int sum2 = ~sum;
            this.headerChecksum = sum2;
            packet.backingBuffer.putShort(10, (short) sum2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("IP4Header{");
            sb.append("version=").append((int) this.version);
            sb.append(", IHL=").append((int) this.IHL);
            sb.append(", typeOfService=").append((int) this.typeOfService);
            sb.append(", totalLength=").append(this.totalLength);
            sb.append(", identificationAndFlagsAndFragmentOffset=").append(this.identificationAndFlagsAndFragmentOffset);
            sb.append(", TTL=").append((int) this.TTL);
            sb.append(", protocol=").append((int) this.protocol);
            sb.append(", headerChecksum=").append(this.headerChecksum);
            sb.append(", sourceAddress=").append(this.sourceAddress.getHostAddress());
            sb.append(", destinationAddress=").append(this.destinationAddress.getHostAddress());
            sb.append('}');
            return sb.toString();
        }
    }

    public static class IP6Header extends IPHeader {
        private static byte[] addressBytes = new byte[16];
        private byte hotLimit;
        private long versionTrafficFlowLabel;

        private IP6Header(ByteBuffer buffer, byte version) throws UnknownHostException {
            this.version = version;
            buffer.position(0);
            this.versionTrafficFlowLabel = BitUtils.getUnsignedInt(buffer.getInt());
            this.totalLength = BitUtils.getUnsignedShort(buffer.getShort());
            this.protocol = buffer.get();
            this.hotLimit = buffer.get();
            buffer.get(addressBytes);
            this.sourceAddress = InetAddress.getByAddress(addressBytes);
            buffer.get(addressBytes);
            this.destinationAddress = InetAddress.getByAddress(addressBytes);
        }

        @Override // com.github.xfalcon.vhosts.vservice.Packet.IPHeader
        public void updateIpHeader(Packet packet, int totalLength) {
            packet.backingBuffer.putShort(4, (short) totalLength);
            this.totalLength = totalLength;
        }

        @Override // com.github.xfalcon.vhosts.vservice.Packet.IPHeader
        public void fillHeader(ByteBuffer buffer) {
            buffer.putInt((int) this.versionTrafficFlowLabel);
            buffer.putShort((short) this.totalLength);
            buffer.put(this.protocol);
            buffer.put(this.hotLimit);
            buffer.put(this.sourceAddress.getAddress());
            buffer.put(this.destinationAddress.getAddress());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("IP6Header{");
            sb.append("version=").append((int) this.version);
            sb.append(", trafficClassFlowLable=").append(this.versionTrafficFlowLabel);
            sb.append(", payload=").append(this.totalLength);
            sb.append(", protocol=").append((int) this.protocol);
            sb.append(", hotLimit=").append((int) this.hotLimit);
            sb.append(", sourceAddress=").append(this.sourceAddress.getHostAddress());
            sb.append(", destinationAddress=").append(this.destinationAddress.getHostAddress());
            sb.append('}');
            return sb.toString();
        }
    }

    public static class TCPHeader {
        public static final int ACK = 16;
        public static final int FIN = 1;
        public static final int PSH = 8;
        public static final int RST = 4;
        public static final int SYN = 2;
        public static final int URG = 32;
        public long acknowledgementNumber;
        private int checksum;
        private byte dataOffsetAndReserved;
        public int destinationPort;
        private byte flags;
        private int headerLength;
        private byte[] optionsAndPadding;
        public long sequenceNumber;
        public int sourcePort;
        private int urgentPointer;
        private int window;

        private TCPHeader(ByteBuffer buffer) {
            this.sourcePort = BitUtils.getUnsignedShort(buffer.getShort());
            this.destinationPort = BitUtils.getUnsignedShort(buffer.getShort());
            this.sequenceNumber = BitUtils.getUnsignedInt(buffer.getInt());
            this.acknowledgementNumber = BitUtils.getUnsignedInt(buffer.getInt());
            this.dataOffsetAndReserved = buffer.get();
            this.headerLength = (this.dataOffsetAndReserved & 240) >> 2;
            this.flags = buffer.get();
            this.window = BitUtils.getUnsignedShort(buffer.getShort());
            this.checksum = BitUtils.getUnsignedShort(buffer.getShort());
            this.urgentPointer = BitUtils.getUnsignedShort(buffer.getShort());
            int optionsLength = this.headerLength - 20;
            if (optionsLength > 0) {
                this.optionsAndPadding = new byte[optionsLength];
                buffer.get(this.optionsAndPadding, 0, optionsLength);
            }
        }

        public boolean isFIN() {
            return (this.flags & 1) == 1;
        }

        public boolean isSYN() {
            return (this.flags & 2) == 2;
        }

        public boolean isRST() {
            return (this.flags & 4) == 4;
        }

        public boolean isPSH() {
            return (this.flags & 8) == 8;
        }

        public boolean isACK() {
            return (this.flags & 16) == 16;
        }

        public boolean isURG() {
            return (this.flags & 32) == 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillHeader(ByteBuffer buffer) {
            buffer.putShort((short) this.sourcePort);
            buffer.putShort((short) this.destinationPort);
            buffer.putInt((int) this.sequenceNumber);
            buffer.putInt((int) this.acknowledgementNumber);
            buffer.put(this.dataOffsetAndReserved);
            buffer.put(this.flags);
            buffer.putShort((short) this.window);
            buffer.putShort((short) this.checksum);
            buffer.putShort((short) this.urgentPointer);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("TCPHeader{");
            sb.append("sourcePort=").append(this.sourcePort);
            sb.append(", destinationPort=").append(this.destinationPort);
            sb.append(", sequenceNumber=").append(this.sequenceNumber);
            sb.append(", acknowledgementNumber=").append(this.acknowledgementNumber);
            sb.append(", headerLength=").append(this.headerLength);
            sb.append(", window=").append(this.window);
            sb.append(", checksum=").append(this.checksum);
            sb.append(", flags=");
            if (isFIN()) {
                sb.append(" FIN");
            }
            if (isSYN()) {
                sb.append(" SYN");
            }
            if (isRST()) {
                sb.append(" RST");
            }
            if (isPSH()) {
                sb.append(" PSH");
            }
            if (isACK()) {
                sb.append(" ACK");
            }
            if (isURG()) {
                sb.append(" URG");
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static class UDPHeader {
        private int checksum;
        public int destinationPort;
        private int length;
        public int sourcePort;

        private UDPHeader(ByteBuffer buffer) {
            this.sourcePort = BitUtils.getUnsignedShort(buffer.getShort());
            this.destinationPort = BitUtils.getUnsignedShort(buffer.getShort());
            this.length = BitUtils.getUnsignedShort(buffer.getShort());
            this.checksum = BitUtils.getUnsignedShort(buffer.getShort());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillHeader(ByteBuffer buffer) {
            buffer.putShort((short) this.sourcePort);
            buffer.putShort((short) this.destinationPort);
            buffer.putShort((short) this.length);
            buffer.putShort((short) this.checksum);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("UDPHeader{");
            sb.append("sourcePort=").append(this.sourcePort);
            sb.append(", destinationPort=").append(this.destinationPort);
            sb.append(", length=").append(this.length);
            sb.append(", checksum=").append(this.checksum);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class BitUtils {
        private BitUtils() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static short getUnsignedByte(byte value) {
            return (short) (value & 255);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getUnsignedShort(short value) {
            return 65535 & value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long getUnsignedInt(int value) {
            return ((long) value) & 4294967295L;
        }
    }
}
