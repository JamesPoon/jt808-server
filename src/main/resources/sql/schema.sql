DROP TABLE location;
CREATE TABLE location (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `device_id` CHAR(16) NOT NULL COMMENT '设备号',
  `plate_no` CHAR(8) NOT NULL DEFAULT '' COMMENT '车牌号',
  `alarm_flag` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '报警标志',
  `status` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `latitude` DOUBLE NOT NULL COMMENT 'GPS地图纬度',
  `longitude` DOUBLE NOT NULL COMMENT 'GPS地图经度',
  `altitude` SMALLINT NOT NULL COMMENT '海拔(单位米)',
  `speed` TINYINT UNSIGNED NOT NULL COMMENT '速度',
  `direction` SMALLINT NOT NULL  COMMENT '方向',
  `device_time` DATETIME NOT NULL COMMENT '设备时间',
  -- `device_date` DATE GENERATED ALWAYS AS (DATE(DATE_TIME)) VIRTUAL NOT NULL,-- MySQL支持虚拟列
  `device_date` DATE NOT NULL COMMENT '设备日期',
  `map_fence_id` SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '围栏ID',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  INDEX idx_devicedate (`device_date`),
  INDEX idx_plateno (`plate_no`),
  INDEX idx_deviceid (`device_id`),
PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT '位置数据';