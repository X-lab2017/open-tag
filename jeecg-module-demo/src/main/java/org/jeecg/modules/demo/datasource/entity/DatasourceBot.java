package org.jeecg.modules.demo.datasource.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 开源机器人标签表
 * @Author: jeecg-boot
 * @Date:   2022-11-25
 * @Version: V1.0
 */
@ApiModel(value="datasource_bot对象", description="开源机器人标签表")
@Data
@TableName("datasource_bot")
public class DatasourceBot implements Serializable {
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
	/**标签对象id*/
	@Excel(name = "标签对象id", width = 15)
    @ApiModelProperty(value = "标签对象id")
    private java.lang.String actorId;
	/**标签对象姓名*/
	@Excel(name = "标签对象姓名", width = 15)
    @ApiModelProperty(value = "标签对象姓名")
    private java.lang.String actorName;
	/**标签对象类别标签*/
	@Excel(name = "标签对象类别标签", width = 15, dicCode = "bot_lable_class")
    @Dict(dicCode = "bot_lable_class")
    @ApiModelProperty(value = "标签对象类别标签")
    private java.lang.String actorClass;
	/**标签对象标签是否难打*/
	@Excel(name = "标签对象标签是否难打", width = 15, dicCode = "bot_lable_difficulty")
    @Dict(dicCode = "bot_lable_difficulty")
    @ApiModelProperty(value = "标签对象标签是否难打")
    private java.lang.String actorDifficult;
	/**标签对象是否是机器人*/
	@Excel(name = "标签对象是否是机器人", width = 15, dicCode = "bot_lable_bot")
    @Dict(dicCode = "bot_lable_bot")
    @ApiModelProperty(value = "标签对象是否是机器人")
    private java.lang.String actorBot;
}
