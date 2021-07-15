package com.techis.starwarsplanets.util;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ResourceUtils {

    public static String getContentFromResource(final String resouceName) {
        try {
            InputStream stream = ResourceUtils.class.getResourceAsStream(resouceName);
            return StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
