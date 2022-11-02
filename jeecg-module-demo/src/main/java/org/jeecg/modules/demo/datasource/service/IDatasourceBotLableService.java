package org.jeecg.modules.demo.datasource.service;

import org.jeecg.modules.demo.datasource.entity.DatasourceBotLable;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 机器人标签结果
 * @Author: jeecg-boot
 * @Date:   2022-11-01
 * @Version: V1.0
 */
public interface IDatasourceBotLableService extends IService<DatasourceBotLable> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<DatasourceBotLable>
	 */
	public List<DatasourceBotLable> selectByMainId(String mainId);
}
