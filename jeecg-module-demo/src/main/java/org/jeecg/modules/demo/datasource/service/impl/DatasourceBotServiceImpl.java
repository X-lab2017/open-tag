package org.jeecg.modules.demo.datasource.service.impl;

import org.jeecg.modules.demo.datasource.entity.DatasourceBot;
import org.jeecg.modules.demo.datasource.entity.DatasourceBotLable;
import org.jeecg.modules.demo.datasource.mapper.DatasourceBotLableMapper;
import org.jeecg.modules.demo.datasource.mapper.DatasourceBotMapper;
import org.jeecg.modules.demo.datasource.service.IDatasourceBotService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 开源机器人标签表
 * @Author: jeecg-boot
 * @Date:   2022-11-25
 * @Version: V1.0
 */
@Service
public class DatasourceBotServiceImpl extends ServiceImpl<DatasourceBotMapper, DatasourceBot> implements IDatasourceBotService {

	@Autowired
	private DatasourceBotMapper datasourceBotMapper;
	@Autowired
	private DatasourceBotLableMapper datasourceBotLableMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(DatasourceBot datasourceBot, List<DatasourceBotLable> datasourceBotLableList) {
		datasourceBotMapper.insert(datasourceBot);
		if(datasourceBotLableList!=null && datasourceBotLableList.size()>0) {
			for(DatasourceBotLable entity:datasourceBotLableList) {
				//外键设置
				entity.setActorId(datasourceBot.getId());
				datasourceBotLableMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(DatasourceBot datasourceBot,List<DatasourceBotLable> datasourceBotLableList) {
		datasourceBotMapper.updateById(datasourceBot);
		
		//1.先删除子表数据
		datasourceBotLableMapper.deleteByMainId(datasourceBot.getId());
		
		//2.子表数据重新插入
		if(datasourceBotLableList!=null && datasourceBotLableList.size()>0) {
			for(DatasourceBotLable entity:datasourceBotLableList) {
				//外键设置
				entity.setActorId(datasourceBot.getId());
				datasourceBotLableMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		datasourceBotLableMapper.deleteByMainId(id);
		datasourceBotMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			datasourceBotLableMapper.deleteByMainId(id.toString());
			datasourceBotMapper.deleteById(id);
		}
	}
	
}
