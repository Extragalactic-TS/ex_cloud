package com.extragalactic.ex_cloud.ex_service_ms.base.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.extragalactic.ex_cloud.ex_service_ms.base.cloud.entity.MsUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.extragalactic.ex_cloud.ex_service_ms.base.cloud.vo.MsUserQueryVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Extragalactic
 * @since 2020-06-02
 */
public interface MsUserService extends IService<MsUser> {
    IPage<MsUser> selectPage(Long page, Long limit, MsUserQueryVo msUserQueryVo);
}
