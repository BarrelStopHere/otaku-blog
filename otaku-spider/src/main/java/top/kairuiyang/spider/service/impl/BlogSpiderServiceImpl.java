package top.kairuiyang.spider.service.impl;


import top.kairuiyang.spider.entity.BlogSpider;
import top.kairuiyang.spider.mapper.BlogSpiderMapper;
import top.kairuiyang.spider.service.BlogSpiderService;
import top.kairuiyang.base.serviceImpl.SuperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客爬取服务实现类
 * </p>
 *
 * @author 陌溪
 * @since 2020年2月7日21:29:42
 */
@Slf4j
@Service
public class BlogSpiderServiceImpl extends SuperServiceImpl<BlogSpiderMapper, BlogSpider> implements BlogSpiderService {

}
