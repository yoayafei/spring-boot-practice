package top.yyf.springboot.redis.utils;

import java.util.concurrent.ThreadLocalRandom;

public class CommonUtils {
    public static int generateCode(){
        return ThreadLocalRandom.current().nextInt(1000,9999);
    }
}
