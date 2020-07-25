package org.yzh.jt808.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.yzh.framework.orm.FieldSpec;
import org.yzh.framework.orm.annotation.Field;
import org.yzh.web.jt.codec.JTMessageDecoder;

/**
 * 阐释者
 *
 * @author zhihao.ye (1527621790@qq.com)
 */
public class Elucidator extends JTMessageDecoder {

    private static final Elucidator elucidator = new Elucidator("org.yzh.web.jt");

    public Elucidator(String basePackage) {
        super(basePackage);
    }

    public static void main(String[] args) {
        String hex = "12052118017299841738430d001200120120071714113520071714302500000000000000010001010ccb54b70220071714113520071714302500000000000000010001010cbe7d02560320071714113520071714302500000000000000010001010cb9b1850420071714113520071714302500000000000000010001010cc29cfe0520071714113520071714302500000000000000010001010cb9bafd0120071714302520071714491500000000000000010001010ccc264b0220071714302520071714491500000000000000010001010cbd15d90320071714302520071714491500000000000000010001010cb72b740420071714302520071714491500000000000000010001010cc38f710520071714302520071714491500000000000000010001010cbbe0fc96";

        System.out.println(hex);
        System.out.println();
        elucidator.decode(Unpooled.wrappedBuffer(ByteBufUtil.decodeHexDump(hex)));
    }

    @Override
    public Object read(ByteBuf buf, FieldSpec fieldSpec, int length, int version) {
        Field field = fieldSpec.field;
        int i = buf.readerIndex();
        String hex = ByteBufUtil.hexDump(buf.readSlice(length));
        buf.readerIndex(i);

        Object value = super.read(buf, fieldSpec, length, version);
        System.out.println(field.index() + "\t" + hex + "\t" + field.desc() + "\t" + value);
        return value;
    }
}