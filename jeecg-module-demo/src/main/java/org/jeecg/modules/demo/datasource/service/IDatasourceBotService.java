package org.jeecg.modules.demo.datasource.service;

import org.jeecg.modules.demo.datasource.entity.DatasourceBotLable;
import org.jeecg.modules.demo.datasource.entity.DatasourceBot;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 开源机器人标签表
 * @Author: jeecg-boot
 * @Date:   2022-11-25
 * @Version: V1.0
 */
public interface IDatasourceBotService extends IService<DatasourceBot> {

	/**
	 * 添加一对多
	 *
	 * @param datasourceBot
	 * @param datasourceBotLableList
	 */
	public void saveMain(DatasourceBot datasourceBot,List<DatasourceBotLable> datasourceBotLableList) ;
	
	/**
	 * 修改一对多
	 *
   * @param datasourceBot
   * @param datasourceBotLableList
	 */
	public void updateMain(DatasourceBot datasourceBot,List<DatasourceBotLable> datasourceBotLableList);
	
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
