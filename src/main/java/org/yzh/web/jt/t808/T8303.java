package org.yzh.web.jt.t808;

import org.yzh.framework.orm.model.DataType;
import org.yzh.framework.orm.annotation.Field;
import org.yzh.framework.orm.annotation.Message;
import org.yzh.framework.orm.model.AbstractMessage;
import org.yzh.web.config.Charsets;
import org.yzh.web.jt.basics.Header;
import org.yzh.web.jt.common.JT808;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhihao.ye (1527621790@qq.com)
 * @home http://gitee.com/yezhihao/jt-server
 */
@Message(JT808.信息点播菜单设置)
public class T8303 extends AbstractMessage<Header> {

    //删除终端全部信息项
    public static final int Clean = 0;
    //更新菜单
    public static final int Update = 1;
    //追加菜单
    public static final int Append = 2;
    //修改菜单
    public static final int Modify = 3;

    private Integer type;
    private Integer total;
    private List<Item> list;

    @Field(index = 0, type = DataType.BYTE, desc = "设置类型")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Field(index = 1, type = DataType.BYTE, desc = "设置总数")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Field(index = 2, type = DataType.LIST, desc = "事件项列表")
    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public void addItem(int id, String content) {
        if (this.list == null)
            this.list = new ArrayList();
        this.list.add(new Item(id, content));
        this.total = list.size();
    }

    public static class Item {
        private Integer id;

        private Integer length;

        private String content;

        public Item() {
        }

        public Item(Integer id, String content) {
            this.id = id;
            this.content = content;
            this.length = content.getBytes(Charsets.GBK).length;
        }

        @Field(index = 0, type = DataType.BYTE, desc = "事件ID")
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Field(index = 1, type = DataType.WORD, desc = "长度")
        public Integer getLength() {
            if (length == null)
                this.length = content.getBytes(Charsets.GBK).length;
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }

        @Field(index = 3, type = DataType.STRING, lengthName = "length", desc = "信息名称")
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
            this.length = content.getBytes(Charsets.GBK).length;
        }
    }
}