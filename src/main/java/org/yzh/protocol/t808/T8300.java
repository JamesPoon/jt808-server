package org.yzh.protocol.t808;

import org.yzh.framework.commons.transform.Bin;
import org.yzh.framework.orm.annotation.Field;
import org.yzh.framework.orm.annotation.Message;
import org.yzh.framework.orm.model.AbstractMessage;
import org.yzh.framework.orm.model.DataType;
import org.yzh.protocol.basics.Header;
import org.yzh.protocol.commons.JT808;

/**
 * @author zhihao.ye (1527621790@qq.com)
 * @home http://gitee.com/yezhihao/jt-server
 */
@Message(JT808.文本信息下发)
public class T8300 extends AbstractMessage<Header> {
    /**
     * 0 1.紧急
     * 1    保留
     * 2 1.终端显示器显示
     * 3 1.终端 TTS 播读
     * 4 1.广告屏显示
     * 5 0.中心导航信息，1.CAN 故障码信息
     * 6-7  保留
     */
    private int sign;
    private String content;

    public T8300() {
    }

    public T8300(String mobileNo) {
        super(new Header(mobileNo, JT808.文本信息下发));
    }

    @Field(index = 0, type = DataType.BYTE, desc = "标志")
    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public void setSign(int... sign) {
        this.sign = Bin.writeInt(sign);
    }

    @Field(index = 1, type = DataType.STRING, desc = "文本信息")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}