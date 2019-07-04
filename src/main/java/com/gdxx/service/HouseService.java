package com.gdxx.service;

import com.gdxx.base.HouseSubscribeStatus;
import com.gdxx.service.result.ServiceMultiResult;
import com.gdxx.service.result.ServiceResult;
import com.gdxx.web.dto.HouseDTO;
import com.gdxx.web.dto.HouseSubscribeDTO;
import com.gdxx.web.form.DatatableSearch;
import com.gdxx.web.form.HouseForm;
import com.gdxx.web.form.MapSearch;
import com.gdxx.web.form.RentSearch;
import org.springframework.data.util.Pair;

import java.util.Date;

public interface HouseService {
    ServiceResult<HouseDTO> save(HouseForm houseForm);

    ServiceMultiResult<HouseDTO> adminQuery(DatatableSearch searchBody);

    ServiceResult<HouseDTO> findCompleteOne(Long id);

    ServiceResult<HouseDTO> update(HouseForm houseForm);

    ServiceResult<?> updateStatus(Long id, int value);

    ServiceMultiResult<HouseDTO> query(RentSearch rentSearch);

    ServiceMultiResult<HouseDTO> wholeMapQuery(MapSearch mapSearch);

    ServiceMultiResult<HouseDTO> boundMapQuery(MapSearch mapSearch);

    ServiceResult addSubscribeOrder(Long houseId);

    ServiceMultiResult<Pair<HouseDTO, HouseSubscribeDTO>> querySubscribeList(HouseSubscribeStatus of, int start, int size);

    ServiceResult subscribe(Long houseId, Date orderTime, String telephone, String desc);

    ServiceResult cancelSubscribe(Long houseId);

    ServiceMultiResult<Pair<HouseDTO, HouseSubscribeDTO>> findSubscribeList(int start, int size);

    ServiceResult finishSubscribe(Long houseId);

    ServiceResult updateCover(Long coverId, Long targetId);

    ServiceResult addTag(Long houseId, String tag);

    ServiceResult removePhoto(Long id);

    ServiceResult removeTag(Long houseId, String tag);

}
