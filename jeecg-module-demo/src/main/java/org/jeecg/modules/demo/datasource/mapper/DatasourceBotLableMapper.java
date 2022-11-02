package org.jeecg.modules.demo.datasource.mapper;

import java.util.List;
import org.jeecg.modules.demo.datasource.entity.DatasourceBotLable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 机器人标签结果
 * @Author: jeecg-boot
 * @Date:   2022-11-01
 * @Version: V1.0
 */
public interface DatasourceBotLableMapper extends BaseMapper<DatasourceBotLable> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<DatasourceBotLable>
   */
	public List<DatasourceBotLable> selectByMainId(@Param("mainId") String mainId);
}
