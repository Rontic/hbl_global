package com.hbl.global.service.base.impl;

import com.hbl.global.service.base.BaseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 基础逻辑层对象
 * 
 * @author founder
 * 
 */
public abstract class BaseServiceImpl implements BaseService {
	protected final Log logger = LogFactory.getLog(BaseServiceImpl.class);
}
