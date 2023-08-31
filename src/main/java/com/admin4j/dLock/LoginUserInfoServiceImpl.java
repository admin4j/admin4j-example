package com.admin4j.dLock;

import com.admin4j.common.service.ILoginTenantInfoService;
import com.admin4j.common.service.ILoginUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author andanyang
 * @since 2023/3/13 15:11
 */
@Service
public class LoginUserInfoServiceImpl implements ILoginUserInfoService, ILoginTenantInfoService {
    /**
     * 用户Id标识，可以返回用户ID， 或者用户name
     *
     * @return
     */
    @Override
    public Long getUserId() {
        return 213L;
    }

    @Override
    public Long getTenantId() {
        return 1L;
    }
}
