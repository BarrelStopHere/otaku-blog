package top.kairuiyang.web.restapi;

import top.kairuiyang.utils.ResultUtil;
import top.kairuiyang.utils.StringUtils;
import top.kairuiyang.web.annotion.log.BussinessLog;
import top.kairuiyang.web.global.MessageConf;
import top.kairuiyang.web.global.SysConf;
import top.kairuiyang.xo.service.BlogService;
import top.kairuiyang.xo.service.SystemConfigService;
import top.kairuiyang.base.enums.EBehavior;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/search")
@Api(value = "SQL搜索相关接口", tags = {"SQL搜索相关接口"})
@Slf4j
public class SearchRestApi {
    @Autowired
    private BlogService blogService;
    @Autowired
    private SystemConfigService systemConfigService;

    /**
     * 使用SQL语句搜索博客，如需使用Solr或者ElasticSearch 需要启动 mogu-search
     *
     * @param keywords
     * @param currentPage
     * @param pageSize
     * @return
     */
    @BussinessLog(value = "搜索Blog", behavior = EBehavior.BLOG_SEARCH)
    @ApiOperation(value = "搜索Blog", notes = "搜索Blog")
    @GetMapping("/sqlSearchBlog")
    public String sqlSearchBlog(@ApiParam(name = "keywords", value = "关键字", required = true) @RequestParam(required = true) String keywords,
                                @ApiParam(name = "currentPage", value = "当前页数", required = false) @RequestParam(name = "currentPage", required = false, defaultValue = "1") Long currentPage,
                                @ApiParam(name = "pageSize", value = "每页显示数目", required = false) @RequestParam(name = "pageSize", required = false, defaultValue = "10") Long pageSize) {

        if (StringUtils.isEmpty(keywords) || StringUtils.isEmpty(keywords.trim())) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.KEYWORD_IS_NOT_EMPTY);
        }
        return ResultUtil.result(SysConf.SUCCESS, blogService.getBlogByKeyword(keywords, currentPage, pageSize));

    }

    @BussinessLog(value = "根据标签获取相关的博客", behavior = EBehavior.BLOG_TAG)
    @ApiOperation(value = "根据标签获取相关的博客", notes = "根据标签获取相关的博客")
    @GetMapping("/searchBlogByTag")
    public String searchBlogByTag(HttpServletRequest request,
                                  @ApiParam(name = "tagUid", value = "博客标签UID", required = true) @RequestParam(name = "tagUid", required = true) String tagUid,
                                  @ApiParam(name = "currentPage", value = "当前页数", required = false) @RequestParam(name = "currentPage", required = false, defaultValue = "1") Long currentPage,
                                  @ApiParam(name = "pageSize", value = "每页显示数目", required = false) @RequestParam(name = "pageSize", required = false, defaultValue = "10") Long pageSize) {
        if (StringUtils.isEmpty(tagUid)) {
            return ResultUtil.result(SysConf.ERROR, "标签不能为空");
        }
        return ResultUtil.result(SysConf.SUCCESS, blogService.searchBlogByTag(tagUid, currentPage, pageSize));
    }

    @BussinessLog(value = "根据分类获取相关的博客", behavior = EBehavior.BLOG_SORT)
    @ApiOperation(value = "根据分类获取相关的博客", notes = "根据标签获取相关的博客")
    @GetMapping("/searchBlogBySort")
    public String searchBlogBySort(HttpServletRequest request,
                                   @ApiParam(name = "blogSortUid", value = "博客分类UID", required = true) @RequestParam(name = "blogSortUid", required = true) String blogSortUid,
                                   @ApiParam(name = "currentPage", value = "当前页数", required = false) @RequestParam(name = "currentPage", required = false, defaultValue = "1") Long currentPage,
                                   @ApiParam(name = "pageSize", value = "每页显示数目", required = false) @RequestParam(name = "pageSize", required = false, defaultValue = "10") Long pageSize) {
        if (StringUtils.isEmpty(blogSortUid)) {
            return ResultUtil.result(SysConf.ERROR, "uid不能为空");
        }
        return ResultUtil.result(SysConf.SUCCESS, blogService.searchBlogByBlogSort(blogSortUid, currentPage, pageSize));
    }

    @BussinessLog(value = "根据作者获取相关的博客", behavior = EBehavior.BLOG_AUTHOR)
    @ApiOperation(value = "根据作者获取相关的博客", notes = "根据作者获取相关的博客")
    @GetMapping("/searchBlogByAuthor")
    public String searchBlogByAuthor(HttpServletRequest request,
                                     @ApiParam(name = "author", value = "作者名称", required = true) @RequestParam(name = "author", required = true) String author,
                                     @ApiParam(name = "currentPage", value = "当前页数", required = false) @RequestParam(name = "currentPage", required = false, defaultValue = "1") Long currentPage,
                                     @ApiParam(name = "pageSize", value = "每页显示数目", required = false) @RequestParam(name = "pageSize", required = false, defaultValue = "10") Long pageSize) {
        if (StringUtils.isEmpty(author)) {
            return ResultUtil.result(SysConf.ERROR, "作者不能为空");
        }
        return ResultUtil.result(SysConf.SUCCESS, blogService.searchBlogByAuthor(author, currentPage, pageSize));
    }

    @ApiOperation(value = "获取搜索模式", notes = "获取搜索模式", response = String.class)
    @GetMapping(value = "/getSearchModel")
    public String getSearchModel() {
        return ResultUtil.successWithData(systemConfigService.getSearchModel());
    }

}