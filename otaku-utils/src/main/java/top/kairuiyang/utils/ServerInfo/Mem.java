package top.kairuiyang.utils.ServerInfo;

import lombok.Data;

/**
 * 内存相关信息
 *
 * @author ykr
 * @date 2022/3/28
 */
@Data
public class Mem {
    /**
     * 内存总量
     */
    private double total;

    /**
     * 已用内存
     */
    private double used;

    /**
     * 剩余内存
     */
    private double free;

    /**
     * 使用率
     */
    private double usage;
}
