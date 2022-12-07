package com.cz.jetpack.study.medel;

public class Destination {

    public Boolean isFragment;
    public Boolean asStarter;
    public Boolean needLogin;
    public String pageUrl;
    public Integer id;
    public String clazzName;

    public Boolean getFragment() {
        return isFragment;
    }

    public void setFragment(Boolean fragment) {
        isFragment = fragment;
    }

    public Boolean getAsStarter() {
        return asStarter;
    }

    public void setAsStarter(Boolean asStarter) {
        this.asStarter = asStarter;
    }

    public Boolean getNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(Boolean needLogin) {
        this.needLogin = needLogin;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
}
