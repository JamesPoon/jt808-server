package org.yzh.protocol.t808;

import org.yzh.framework.orm.annotation.Field;
import org.yzh.framework.orm.annotation.Message;
import org.yzh.framework.orm.model.AbstractMessage;
import org.yzh.framework.orm.model.DataType;
import org.yzh.protocol.basics.Header;
import org.yzh.protocol.commons.JT808;
import org.yzh.protocol.commons.ResultCode;

/**
 * @author zhihao.ye (1527621790@qq.com)
 * @home http://gitee.com/yezhihao/jt-server
 */
@Message({JT808.终端通用应答, JT808.平台通用应答})
public class T0001 extends AbstractMessage<Header> {

    private int serialNo;
    private int replyId;
    /** @see ResultCode */
    private int resultCode;

    public T0001() {
    }

    public T0001(int replyId, int serialNo, int resultCode) {
        this.replyId = replyId;
        this.serialNo = serialNo;
        this.resultCode = resultCode;
    }

    @Field(index = 0, type = DataType.WORD, desc = "应答流水号")
    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    @Field(index = 2, type = DataType.WORD, desc = "应答ID")
    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    @Field(index = 4, type = DataType.BYTE, desc = "结果（响应码）")
    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

}