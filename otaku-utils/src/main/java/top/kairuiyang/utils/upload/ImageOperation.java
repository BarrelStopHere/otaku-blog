package top.kairuiyang.utils.upload;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

/**
 * 图片操作
 *
 * @author ykr
 * @date 2022/3/28
 */
public class ImageOperation {

    /**
     * 左旋
     *
     * @param inFile  源文件
     * @param outFile 目的文件
     * @param angle   角度
     * @throws IOException io异常
     */
    public static void leftTotation(File inFile, File outFile, int angle) throws IOException {
        Thumbnails.of(inFile).scale(1).outputQuality(1).rotate(-angle).toFile(outFile);
    }

    /**
     * 右旋
     *
     * @param inFile  源文件
     * @param outFile 目的文件
     * @param angle   角度
     * @throws IOException io异常
     */
    public static void rightTotation(File inFile, File outFile, int angle) throws IOException {
        Thumbnails.of(inFile).scale(1).outputQuality(1).rotate(angle).toFile(outFile);
    }

    /**
     * 压缩
     *
     * @param inFile  源文件
     * @param outFile 目的文件
     * @throws IOException io异常
     */
    public static void thumbnailsImage(File inFile, File outFile, int imageSize) throws IOException {

        Thumbnails.of(inFile).size(imageSize, imageSize)
                .toFile(outFile);

    }
}
