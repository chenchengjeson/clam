package com.dwfs.clam.service.impl;

import com.dwfs.clam.entity.User;
import com.dwfs.clam.mapper.UserMapper;
import com.dwfs.clam.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
