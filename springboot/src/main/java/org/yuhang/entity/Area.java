package org.yuhang.entity;

import java.util.Date;

/**
 * Created by chinalife on 2018/5/20.
 */
public class Area {

    /*
     *areaId
     */
    private int areaId;
    /*
     * areaName
     */
    private String areaName;
    /*
     *priority
     */
    private int priority;

    private Date createTime;

    private Date lastEditTime;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
