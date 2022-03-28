package top.kairuiyang.xo.service.impl;

import top.kairuiyang.commons.entity.CommentReport;
import top.kairuiyang.xo.mapper.CommentReportMapper;
import top.kairuiyang.xo.service.CommentReportService;
import top.kairuiyang.base.serviceImpl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 评论举报表 服务实现类
 *
 * @author 陌溪
 * @date 2020年1月12日15:47:47
 */
@Service
public class CommentReportServiceImpl extends SuperServiceImpl<CommentReportMapper, CommentReport> implements CommentReportService {

}
