package com.sectong.domain.mongomodle;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by xueyong on 16/7/11.
 * demo.
 */
public class VersionFactory {

    static final Logger LOGGER = LoggerFactory.getLogger(VersionFactory.class);

    static final String basePath = "/alidata/server/version/";

    public static UpdateModle versionV1_0() {
        UpdateModle updateModle = new UpdateModle("", "", "", "V1.0", 11, 522 * 11, "");
        return updateModle;
    }

    public static String versionSegment(String vPath, Integer num) throws IOException {
        String binCode;
        File file = new File(basePath + vPath + "/" + num + ".bin");
        try {
            binCode = IOUtils.toString(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            binCode = e.getMessage();
            LOGGER.error("file not found: {}", new Object[]{file == null ? "" : file.getPath()});
        }
        return binCode;
    }

}
