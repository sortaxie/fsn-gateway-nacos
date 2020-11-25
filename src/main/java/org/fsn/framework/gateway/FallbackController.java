package org.fsn.framework.gateway;

import org.fsn.framework.common.exception.error.DefaultError;
import org.fsn.framework.common.pojo.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping(value = "/fallback")
    public BaseResponse fallBack() {
        BaseResponse response = new BaseResponse(DefaultError.LOADBALANCE_ERROR);
        return response;
    }
}
