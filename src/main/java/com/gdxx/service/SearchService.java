package com.gdxx.service;

import com.gdxx.service.result.ServiceMultiResult;
import com.gdxx.service.result.ServiceResult;
import com.gdxx.service.search.HouseBucketDTO;
import com.gdxx.web.form.MapSearch;
import com.gdxx.web.form.RentSearch;

import java.util.List;

public interface SearchService {

    //索引(动词)目标房源：1.对已上架的房源更新操作要在ES上简历索引 2.对未上架的房源做上架操作要构建索引
    // 先从mysql里查出目标数据再去ES里构建
    void index(Long houseId);

    //移除房源索引:对房源的操作时 不是上架操作(下架，已出租) 做删除索引操作
    void remove(Long houseId);

    //查询房源
    ServiceMultiResult<Long> query(RentSearch rentSearch);

    //获取补全建议关键字
    ServiceResult<List<String>> suggest(String prefix);

    //聚合特定小区的房间数
    ServiceResult<Long> aggregateDistrictHouse(String cityEnName, String regionEnName, String district);

    //聚合城市数据
    ServiceMultiResult<HouseBucketDTO> mapAggregate(String cityEnName);

    //城市级别查询
    ServiceMultiResult<Long> mapQuery(String cityEnName, String orderBy, String orderDirection, int start, int size);

    //精确范围数据查询
    ServiceMultiResult<Long> mapQuery(MapSearch mapSearch);
}
