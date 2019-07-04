package com.gdxx.service;


import com.gdxx.entity.SupportAddress.Level;
import com.gdxx.service.result.ServiceMultiResult;
import com.gdxx.service.result.ServiceResult;
import com.gdxx.service.search.BaiduMapLocation;
import com.gdxx.web.dto.SubwayDTO;
import com.gdxx.web.dto.SubwayStationDTO;
import com.gdxx.web.dto.SupportAddressDTO;

import java.util.List;
import java.util.Map;

public interface AddressService {
    ServiceMultiResult<SupportAddressDTO> findAllCities();

    ServiceMultiResult<SupportAddressDTO> findAllRegionsByCityName(String cityEnName);

    List<SubwayDTO> findAllSubwayByCity(String cityEnName);

    List<SubwayStationDTO> findAllStationBySubway(Long subwayId);

    Map<Level, SupportAddressDTO> findCityAndRegion(String cityEnName, String regionEnName);

    ServiceResult<SubwayDTO> findSubway(Long subwayLineId);

    ServiceResult<SubwayStationDTO> findSubwayStation(Long subwayStationId);

    ServiceResult<SupportAddressDTO> findCity(String cityEnName);

    //根据城市具体地址获取百度地图经纬度
    ServiceResult<BaiduMapLocation> getBaiduMapLocation(String city, String address);

    //上传百度LBS数据
    ServiceResult lbsUpload(BaiduMapLocation location, String title, String address, long houseId, int price, int area);

    //移除百度LBS数据
    ServiceResult removeLbs(Long houseId);
}
