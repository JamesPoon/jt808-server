package org.yzh.protocol.t808;

import org.yzh.framework.orm.annotation.Field;
import org.yzh.framework.orm.annotation.Fs;
import org.yzh.framework.orm.annotation.Message;
import org.yzh.framework.orm.model.AbstractMessage;
import org.yzh.framework.orm.model.DataType;
import org.yzh.protocol.basics.Header;
import org.yzh.protocol.commons.JT808;

/**
 * @author zhihao.ye (1527621790@qq.com)
 * @home http://gitee.com/yezhihao/jt-server
 */
@Message(JT808.终端注册)
public class T0100 extends AbstractMessage<Header> {

    private int provinceId;
    private int cityId;
    private String manufacturerId;
    private String deviceType;
    private String deviceId;
    private int licensePlateColor;
    private String licensePlate;

    /** 设备安装车辆所在的省域,省域ID采用GB/T2260中规定的行政区划代码6位中前两位 */
    @Field(index = 0, type = DataType.WORD, desc = "省域ID", version = {0, 1})
    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    /** 设备安装车辆所在的市域或县域,市县域ID采用GB/T2260中规定的行政区划代码6位中后四位 */
    @Field(index = 2, type = DataType.WORD, desc = "市县域ID", version = {0, 1})
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    /** 终端制造商编码 */
    @Fs({@Field(index = 4, type = DataType.BYTES, length = 5, desc = "制造商ID", version = 0),
            @Field(index = 4, type = DataType.BYTES, length = 11, desc = "制造商ID", version = 1)})
    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    /** 由制造商自行定义,位数不足八位补空格 */
    @Fs({@Field(index = 9, type = DataType.BYTES, length = 20, desc = "终端型号", version = 0),
            @Field(index = 15, type = DataType.BYTES, length = 30, desc = "终端型号", version = 1)})
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /** 由大写字母和数字组成,此终端ID由制造商自行定义 */
    @Fs({@Field(index = 29, type = DataType.BYTES, length = 7, desc = "终端ID", version = 0),
            @Field(index = 45, type = DataType.BYTES, length = 30, desc = "终端ID", version = 1)})
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /** 按照JT/T415-2006的5.4.12（0:未上车牌,1:蓝色,2:黄色,3:黑色,4:白色,9:其他） */
    @Fs({@Field(index = 36, type = DataType.BYTE, desc = "车牌颜色", version = 0),
            @Field(index = 75, type = DataType.BYTE, desc = "车牌颜色", version = 1)})
    public int getLicensePlateColor() {
        return licensePlateColor;
    }

    public void setLicensePlateColor(int licensePlate) {
        this.licensePlateColor = licensePlate;
    }

    /** 车牌颜色为0时,表示车辆VIN；否则,表示公安交通管理部门颁发的机动车号牌 */
    @Fs({@Field(index = 37, type = DataType.STRING, desc = "车辆标识", version = 0),
            @Field(index = 76, type = DataType.STRING, desc = "车辆标识", version = 1)})
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}