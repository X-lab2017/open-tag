package org.jeecg.modules.demo.datasource.service.impl;

import org.jeecg.modules.demo.datasource.entity.DatasourceBotLable;
import org.jeecg.modules.demo.datasource.mapper.DatasourceBotLableMapper;
import org.jeecg.modules.demo.datasource.service.IDatasourceBotLableService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 机器人标签结果
 * @Author: jeecg-boot
 * @Date:   2022-11-25
 * @Version: V1.0
 */
@Service
public class DatasourceBotLableServiceImpl extends ServiceImpl<DatasourceBotLableMapper, DatasourceBotLable> implements IDatasourceBotLableService {
	
	@Autowired
	private DatasourceBotLableMapper datasourceBotLableMapper;
	
	@Override
	public List<DatasourceBotLable> selectByMainId(String mainId) {
		return datasourceBotLableMapper.selectByMainId(mainId);
	}
}
