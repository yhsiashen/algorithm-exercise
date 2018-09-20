package org.yuhang.dao;

import org.yuhang.entity.Area;

import java.util.List;

/**
 * Created by chinalife on 2018/5/20.
 */
public interface AreaDao {
    List<Area> queryAreaList();
    Area queryAreaById(int areaID);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(Area area);

}
