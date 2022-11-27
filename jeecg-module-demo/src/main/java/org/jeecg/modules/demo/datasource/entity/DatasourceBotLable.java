package org.jeecg.modules.demo.datasource.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 机器人标签结果
 * @Author: jeecg-boot
 * @Date:   2022-11-25
 * @Version: V1.0
 */
@ApiModel(value="datasource_bot_lable对象", description="机器人标签结果")
@Data
@TableName("datasource_bot_lable")
public class DatasourceBotLable implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**是否是机器人*/
	@Excel(name = "是否是机器人", width = 15, dicCode = "bot_lable_bot")
    @ApiModelProperty(value = "是否是机器人")
    private java.lang.String botLableBot;
	/**机器人类别*/
	@Excel(name = "机器人类别", width = 15, dicCode = "bot_lable_class")
    @ApiModelProperty(value = "机器人类别")
    private java.lang.String botLableClass;
	/**是否难打*/
	@Excel(name = "是否难打", width = 15, dicCode = "bot_lable_difficulty")
    @ApiModelProperty(value = "是否难打")
    private java.lang.String botLableDifficult;
	/**标签对象*/
    @ApiModelProperty(value = "标签对象")
    private java.lang.String actorId;
}
