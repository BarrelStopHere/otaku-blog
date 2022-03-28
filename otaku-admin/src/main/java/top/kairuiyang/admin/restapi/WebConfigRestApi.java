package top.kairuiyang.admin.restapi;


import org.springframework.web.bind.annotation.*;
import top.kairuiyang.admin.annotion.AuthorityVerify.AuthorityVerify;
import top.kairuiyang.admin.annotion.OperationLogger.OperationLogger;
import top.kairuiyang.utils.ResultUtil;
import top.kairuiyang.xo.service.WebConfigService;
import top.kairuiyang.xo.vo.WebConfigVO;
import top.kairuiyang.base.validator.group.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

/**
 * 网站配置表 RestApi
 *
 * @author 陌溪
 * @date 2018年11月11日15:19:28
 */
@Api(value = "网站配置相关接口", tags = {"网站配置相关接口"})
@RestController
@RequestMapping("/webConfig")
@Slf4j
public class WebConfigRestApi {

    @Autowired
    WebConfigService webConfigService;

    @AuthorityVerify
    @ApiOperation(value = "获取网站配置", notes = "获取网站配置")
    @GetMapping("/getWebConfig")
    public String getWebConfig() {
        return ResultUtil.successWithData(webConfigService.getWebConfig());
    }

    @AuthorityVerify
    @OperationLogger(value = "修改网站配置")
    @ApiOperation(value = "修改网站配置", notes = "修改网站配置")
    @PostMapping("/editWebConfig")
    public String editWebConfig(@Validated({Update.class}) @RequestBody WebConfigVO webConfigVO, BindingResult result) {
        return webConfigService.editWebConfig(webConfigVO);
    }
}

