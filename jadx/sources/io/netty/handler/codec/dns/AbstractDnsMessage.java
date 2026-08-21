package io.netty.handler.codec.dns;

import defpackage.ha0;
import defpackage.s53;
import defpackage.zo2;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDnsMessage extends AbstractReferenceCounted implements DnsMessage {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int SECTION_COUNT = 4;
    private Object additionals;
    private Object answers;
    private Object authorities;
    private short id;
    private final ResourceLeakTracker<DnsMessage> leak;
    private DnsOpCode opCode;
    private Object questions;
    private boolean recursionDesired;
    private byte z;
    private static final ResourceLeakDetector<DnsMessage> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DnsMessage.class);
    private static final int SECTION_QUESTION = DnsSection.QUESTION.ordinal();

    public AbstractDnsMessage(int i, DnsOpCode dnsOpCode) {
        this.leak = leakDetector.track(this);
        setId(i);
        setOpCode(dnsOpCode);
    }

    private void addRecord(int i, int i2, DnsRecord dnsRecord) {
        ArrayList<DnsRecord> arrayListNewRecordList;
        checkQuestion(i, dnsRecord);
        Object objSectionAt = sectionAt(i);
        if (objSectionAt == null) {
            if (i2 == 0) {
                setSection(i, dnsRecord);
                return;
            } else {
                s53.k(ha0.k("index: ", i2, " (expected: 0)"));
                return;
            }
        }
        if (!(objSectionAt instanceof DnsRecord)) {
            ((List) objSectionAt).add(i2, dnsRecord);
            return;
        }
        if (i2 == 0) {
            arrayListNewRecordList = newRecordList();
            arrayListNewRecordList.add(dnsRecord);
            arrayListNewRecordList.add(castRecord(objSectionAt));
        } else if (i2 != 1) {
            s53.k(ha0.k("index: ", i2, " (expected: 0 or 1)"));
            return;
        } else {
            arrayListNewRecordList = newRecordList();
            arrayListNewRecordList.add(castRecord(objSectionAt));
            arrayListNewRecordList.add(dnsRecord);
        }
        setSection(i, arrayListNewRecordList);
    }

    private static <T extends DnsRecord> T castRecord(Object obj) {
        return (T) obj;
    }

    private static DnsRecord checkQuestion(int i, DnsRecord dnsRecord) {
        if (i != SECTION_QUESTION || (ObjectUtil.checkNotNull(dnsRecord, "record") instanceof DnsQuestion)) {
            return dnsRecord;
        }
        StringBuilder sb = new StringBuilder("record: ");
        sb.append(dnsRecord);
        String strSimpleClassName = StringUtil.simpleClassName((Class<?>) DnsQuestion.class);
        sb.append(" (expected: ");
        sb.append(strSimpleClassName);
        sb.append(')');
        throw new IllegalArgumentException(sb.toString());
    }

    private void clear(int i) {
        Object objSectionAt = sectionAt(i);
        setSection(i, null);
        if (objSectionAt instanceof ReferenceCounted) {
            ((ReferenceCounted) objSectionAt).release();
            return;
        }
        if (objSectionAt instanceof List) {
            List list = (List) objSectionAt;
            if (list.isEmpty()) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ReferenceCountUtil.release(it.next());
            }
        }
    }

    private int count(int i) {
        Object objSectionAt = sectionAt(i);
        if (objSectionAt == null) {
            return 0;
        }
        if (objSectionAt instanceof DnsRecord) {
            return 1;
        }
        return ((List) objSectionAt).size();
    }

    private static ArrayList<DnsRecord> newRecordList() {
        return new ArrayList<>(2);
    }

    private <T extends DnsRecord> T recordAt(int i, int i2) {
        Object objSectionAt = sectionAt(i);
        if (objSectionAt == null) {
            s53.k(ha0.k("index: ", i2, " (expected: none)"));
            return null;
        }
        if (!(objSectionAt instanceof DnsRecord)) {
            return (T) castRecord(((List) objSectionAt).get(i2));
        }
        if (i2 == 0) {
            return (T) castRecord(objSectionAt);
        }
        s53.k(ha0.k("index: ", i2, "' (expected: 0)"));
        return null;
    }

    private <T extends DnsRecord> T removeRecord(int i, int i2) {
        Object objSectionAt = sectionAt(i);
        if (objSectionAt == null) {
            s53.k(ha0.k("index: ", i2, " (expected: none)"));
            return null;
        }
        if (!(objSectionAt instanceof DnsRecord)) {
            return (T) castRecord(((List) objSectionAt).remove(i2));
        }
        if (i2 != 0) {
            s53.k(ha0.k("index: ", i2, " (expected: 0)"));
            return null;
        }
        T t = (T) castRecord(objSectionAt);
        setSection(i, null);
        return t;
    }

    private Object sectionAt(int i) {
        if (i == 0) {
            return this.questions;
        }
        if (i == 1) {
            return this.answers;
        }
        if (i == 2) {
            return this.authorities;
        }
        if (i == 3) {
            return this.additionals;
        }
        zo2.g();
        return null;
    }

    private static int sectionOrdinal(DnsSection dnsSection) {
        return ((DnsSection) ObjectUtil.checkNotNull(dnsSection, "section")).ordinal();
    }

    private <T extends DnsRecord> T setRecord(int i, int i2, DnsRecord dnsRecord) {
        checkQuestion(i, dnsRecord);
        Object objSectionAt = sectionAt(i);
        if (objSectionAt == null) {
            s53.k(ha0.k("index: ", i2, " (expected: none)"));
            return null;
        }
        if (!(objSectionAt instanceof DnsRecord)) {
            return (T) castRecord(((List) objSectionAt).set(i2, dnsRecord));
        }
        if (i2 == 0) {
            setSection(i, dnsRecord);
            return (T) castRecord(objSectionAt);
        }
        s53.k(ha0.k("index: ", i2, " (expected: 0)"));
        return null;
    }

    private void setSection(int i, Object obj) {
        if (i == 0) {
            this.questions = obj;
            return;
        }
        if (i == 1) {
            this.answers = obj;
            return;
        }
        if (i == 2) {
            this.authorities = obj;
        } else if (i == 3) {
            this.additionals = obj;
        } else {
            zo2.g();
        }
    }

    @Override // io.netty.util.AbstractReferenceCounted
    public void deallocate() {
        clear();
        ResourceLeakTracker<DnsMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.close(this);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DnsMessage)) {
            return false;
        }
        DnsMessage dnsMessage = (DnsMessage) obj;
        if (id() != dnsMessage.id()) {
            return false;
        }
        if (this instanceof DnsQuery) {
            if (!(dnsMessage instanceof DnsQuery)) {
                return false;
            }
        } else if (dnsMessage instanceof DnsQuery) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (id() * 31) + (!(this instanceof DnsQuery) ? 1 : 0);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int id() {
        return this.id & 65535;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public boolean isRecursionDesired() {
        return this.recursionDesired;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsOpCode opCode() {
        return this.opCode;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsMessage retain() {
        return (DnsMessage) super.retain();
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setId(int i) {
        this.id = (short) i;
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setOpCode(DnsOpCode dnsOpCode) {
        this.opCode = (DnsOpCode) ObjectUtil.checkNotNull(dnsOpCode, "opCode");
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setRecursionDesired(boolean z) {
        this.recursionDesired = z;
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setZ(int i) {
        this.z = (byte) (i & 7);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsMessage touch(Object obj) {
        ResourceLeakTracker<DnsMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record(obj);
        }
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int z() {
        return this.z;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsMessage retain(int i) {
        return (DnsMessage) super.retain(i);
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsMessage touch() {
        return (DnsMessage) super.touch();
    }

    public AbstractDnsMessage(int i) {
        this(i, DnsOpCode.QUERY);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int count(DnsSection dnsSection) {
        return count(sectionOrdinal(dnsSection));
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int count() {
        int iCount = 0;
        for (int i = 0; i < 4; i++) {
            iCount += count(i);
        }
        return iCount;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage clear() {
        for (int i = 0; i < 4; i++) {
            clear(i);
        }
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage clear(DnsSection dnsSection) {
        clear(sectionOrdinal(dnsSection));
        return this;
    }

    private <T extends DnsRecord> T recordAt(int i) {
        Object objSectionAt = sectionAt(i);
        if (objSectionAt == null) {
            return null;
        }
        if (objSectionAt instanceof DnsRecord) {
            return (T) castRecord(objSectionAt);
        }
        List list = (List) objSectionAt;
        if (list.isEmpty()) {
            return null;
        }
        return (T) castRecord(list.get(0));
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T removeRecord(DnsSection dnsSection, int i) {
        return (T) removeRecord(sectionOrdinal(dnsSection), i);
    }

    private void setRecord(int i, DnsRecord dnsRecord) {
        clear(i);
        setSection(i, checkQuestion(i, dnsRecord));
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T recordAt(DnsSection dnsSection, int i) {
        return (T) recordAt(sectionOrdinal(dnsSection), i);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T recordAt(DnsSection dnsSection) {
        return (T) recordAt(sectionOrdinal(dnsSection));
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T setRecord(DnsSection dnsSection, int i, DnsRecord dnsRecord) {
        return (T) setRecord(sectionOrdinal(dnsSection), i, dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        setRecord(sectionOrdinal(dnsSection), dnsRecord);
        return this;
    }

    private void addRecord(int i, DnsRecord dnsRecord) {
        checkQuestion(i, dnsRecord);
        Object objSectionAt = sectionAt(i);
        if (objSectionAt == null) {
            setSection(i, dnsRecord);
            return;
        }
        if (objSectionAt instanceof DnsRecord) {
            ArrayList<DnsRecord> arrayListNewRecordList = newRecordList();
            arrayListNewRecordList.add(castRecord(objSectionAt));
            arrayListNewRecordList.add(dnsRecord);
            setSection(i, arrayListNewRecordList);
            return;
        }
        ((List) objSectionAt).add(dnsRecord);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage addRecord(DnsSection dnsSection, int i, DnsRecord dnsRecord) {
        addRecord(sectionOrdinal(dnsSection), i, dnsRecord);
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        addRecord(sectionOrdinal(dnsSection), dnsRecord);
        return this;
    }
}
