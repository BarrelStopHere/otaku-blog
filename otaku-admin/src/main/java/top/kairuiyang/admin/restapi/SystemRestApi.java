package top.kairuiyang.admin.restapi;

import org.springframework.web.bind.annotation.*;
import top.kairuiyang.admin.annotion.AuthorityVerify.AuthorityVerify;
import top.kairuiyang.admin.annotion.OperationLogger.OperationLogger;
import top.kairuiyang.utils.ResultUtil;
import top.kairuiyang.xo.service.AdminService;
import top.kairuiyang.xo.vo.AdminVO;
import top.kairuiyang.base.exception.ThrowableUtils;
import top.kairuiyang.base.validator.group.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

/**
 * 系统设置RestApi
 *
 * @author 陌溪
 * @date 2018年11月6日下午8:23:36
 */

@RestController
@RequestMapping("/system")
@Api(value = "系统设置相关接口", tags = {"系统设置相关接口"})
@Slf4j
public class SystemRestApi {

    @Autowired
    private AdminService adminService;

    @AuthorityVerify
    @ApiOperation(value = "获取我的信息", notes = "获取我的信息")
    @GetMapping("/getMe")
    public String getMe() {
        return ResultUtil.successWithData(adminService.getMe());
    }

    @AuthorityVerify
    @OperationLogger(value = "编辑我的信息")
    @ApiOperation(value = "编辑我的信息", notes = "获取我的信息")
    @PostMapping("/editMe")
    public String editMe(@Validated({Update.class}) @RequestBody AdminVO adminVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return adminService.editMe(adminVO);
    }

    @AuthorityVerify
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @PostMapping("/changePwd")
    public String changePwd(@ApiParam(name = "oldPwd", value = "旧密码", required = false) @RequestParam(name = "oldPwd", required = false) String oldPwd,
                            @ApiParam(name = "newPwd", value = "新密码", required = false) @RequestParam(name = "newPwd", required = false) String newPwd) {
        return adminService.changePwd(oldPwd, newPwd);
    }

}
