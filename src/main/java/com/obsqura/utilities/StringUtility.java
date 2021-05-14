package com.obsqura.utilities;

import java.io.File;

import static com.google.common.base.Strings.isNullOrEmpty;

public class StringUtility {

    public static String extractFileName(String absoluteFileName) {

        if (!isNullOrEmpty(absoluteFileName)) {

            absoluteFileName = absoluteFileName.substring(absoluteFileName
                    .lastIndexOf(File.separatorChar) + 1, absoluteFileName.lastIndexOf("."));
        }
        return absoluteFileName;
    }

    public static String unquote(String s) {

        if (s != null
                && ((s.startsWith("\"") && s.endsWith("\""))
                || (s.startsWith("'") && s.endsWith("'")))) {

            s = s.substring(1, s.length() - 1);
        }
        return s;
    }


}
