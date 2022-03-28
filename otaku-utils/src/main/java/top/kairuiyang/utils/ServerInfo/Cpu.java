package top.kairuiyang.utils.ServerInfo;

import lombok.Data;

/**
 * cpu相关信息
 *
 * @author ykr
 * @date 2022/3/28
 */
@Data
public class Cpu {
    /**
     * 核心数
     */
    private int cpuNum;

    /**
     * CPU总的使用率
     */
    private double total;

    /**
     * CPU系统使用率
     */
    private double sys;

    /**
     * CPU用户使用率
     */
    private double used;

    /**
     * CPU当前等待率
     */
    private double wait;

    /**
     * CPU当前空闲率
     */
    private double free;
}
