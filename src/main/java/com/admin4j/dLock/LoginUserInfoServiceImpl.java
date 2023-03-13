package com.admin4j.dLock;

import com.admin4j.common.service.ILoginUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author andanyang
 * @since 2023/3/13 15:11
 */
@Service
public class LoginUserInfoServiceImpl implements ILoginUserInfoService {
    /**
     * 用户Id标识，可以返回用户ID， 或者用户name
     *
     * @return
     */
    @Override
    public String getUserId() {
        return "213";
    }
}
