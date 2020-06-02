package com.extragalactic.ex_cloud.ex_service_ms.base.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.extragalactic.ex_cloud.ex_service_ms.base.cloud.entity.MsUser;
import com.extragalactic.ex_cloud.ex_service_ms.base.cloud.mapper.MsUserMapper;
import com.extragalactic.ex_cloud.ex_service_ms.base.cloud.service.MsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.extragalactic.ex_cloud.ex_service_ms.base.cloud.vo.MsUserQueryVo;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Extragalactic
 * @since 2020-06-02
 */
@Service
public class MsUserServiceImpl extends ServiceImpl<MsUserMapper, MsUser> implements MsUserService {

    @Override
    public IPage<MsUser> selectPage(Long page, Long limit, MsUserQueryVo msUserQueryVo) {

        Page<MsUser> pageParam = new Page<>(page,limit);

        /*显示分页查询列表
         *1.排序： 按照sort字段排序
         */
        QueryWrapper<MsUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        //2.查询
        if (msUserQueryVo == null){
            return baseMapper.selectPage(pageParam,queryWrapper);
        }

        //3.条件查询
        String username = msUserQueryVo.getUsername();
        Integer RoleType = msUserQueryVo.getRoleType();
        String begin = msUserQueryVo.getJoinDateBegin();
        String end = msUserQueryVo.getJoinDateEnd();

        if (!StringUtils.isEmpty(username)){
            //左%会使索引失效
            queryWrapper.likeRight("username",username);
        }

        if (RoleType != null){
            queryWrapper.eq("RoleType",RoleType);
        }

        if (!StringUtils.isEmpty(begin)){
            queryWrapper.ge("join_date", begin);

        }

        if (!StringUtils.isEmpty(end)){
            queryWrapper.le("join_date", end);
        }

        return baseMapper.selectPage(pageParam,queryWrapper);
    }
}
