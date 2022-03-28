package top.kairuiyang.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.kairuiyang.commons.entity.StudyVideo;
import top.kairuiyang.xo.vo.StudyVideoVO;
import top.kairuiyang.base.service.SuperService;

import java.util.List;

/**
 * 学习视频表 服务类
 *
 * @author 陌溪
 * @date 2018年10月19日21:26:25
 */
public interface StudyVideoService extends SuperService<StudyVideo> {
    /**
     * 获取学习视频列表
     *
     * @param studyVideoVO
     * @return
     */
    public IPage<StudyVideo> getPageList(StudyVideoVO studyVideoVO);

    /**
     * 新增学习视频
     *
     * @param studyVideoVO
     */
    public String addStudyVideo(StudyVideoVO studyVideoVO);

    /**
     * 编辑学习视频
     *
     * @param studyVideoVO
     */
    public String editStudyVideo(StudyVideoVO studyVideoVO);

    /**
     * 批量删除学习视频
     *
     * @param studyVideoVOList
     */
    public String deleteBatchStudyVideo(List<StudyVideoVO> studyVideoVOList);
}
