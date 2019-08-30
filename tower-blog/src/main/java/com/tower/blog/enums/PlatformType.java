package com.tower.blog.enums;

public enum PlatformType {

    /** 华为私有云 */
    FS(1, "FusionSphere"),

    /** aliyun */
    ALI(2, "Ali");

    private Integer platformId;
    private String platformName;

    private PlatformType(Integer platformId, String platformName){
        this.platformId = platformId;
        this.platformName = platformName;
    }

    public Integer val() {
        return platformId;
    }

    public String msg() {
        return platformName;
    }

}
