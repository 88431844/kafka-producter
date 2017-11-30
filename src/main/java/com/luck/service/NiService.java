package com.luck.service;
import com.luck.dto.FaultCodeDto;
import com.luck.dto.OvertimeParkDto;
import com.luck.dto.StayInAreaDto;
import com.luck.entity.FaultCode;
import com.luck.entity.OvertimePark;
import com.luck.entity.StayingInArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
/**
 * @Author miracle
 * @Date 2017/11/30 0030 9:51
 */
@Service
public class NiService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 添加停留时长 到mongodb
     * @param startInAreaDto
     */
    public void addStartInArea(StayInAreaDto startInAreaDto) throws Exception{
        String tableSuffix = startInAreaDto.getTableSuffix();
        int insertSum = startInAreaDto.getInsertSum();
        if (insertSum > 0){
            for (int i = 0; i < insertSum; i++) {
                StayingInArea stayingInArea = new StayingInArea();
                stayingInArea.setVid(i);
                stayingInArea.setaId(i);
                stayingInArea.setBegin(System.currentTimeMillis() / 1000);
                stayingInArea.setEnd(System.currentTimeMillis() / 1000);
                stayingInArea.setCon(i);
                stayingInArea.setLat(i);
                stayingInArea.setLng(i);

                mongoTemplate.save(stayingInArea, "StayingInArea_"+tableSuffix+"");
            }
        }
    }

    /**
     * 添加滞留超时 到mongodb
     * @param overtimeParkDto
     */
    public void addOvertimePark(OvertimeParkDto overtimeParkDto) throws Exception{
        String tableSuffix = overtimeParkDto.getTableSuffix();
        int insertSum = overtimeParkDto.getInsertSum();
        if (insertSum > 0){
            for (int i = 0; i < insertSum; i++) {
                OvertimePark overtimePark = new OvertimePark();
                overtimePark.setVid(i);
                overtimePark.setaId(i);
                overtimePark.setBegin(System.currentTimeMillis() / 1000);
                overtimePark.setEnd(System.currentTimeMillis() / 1000);
                overtimePark.setCon(i);
                overtimePark.setLimit(i);
                overtimePark.setbLat(i);
                overtimePark.setbLng(i);
                overtimePark.seteLat(i);
                overtimePark.seteLng(i);
                overtimePark.setIsDel(0);
                mongoTemplate.save(overtimePark, "OvertimePark_"+tableSuffix+"");
            }
        }
    }

    /**
     * 添加故障码 到mongodb
     * @param faultCodeDto
     */
    public void addFaultCode(FaultCodeDto faultCodeDto) throws Exception{
        String tableSuffix = faultCodeDto.getTableSuffix();
        int insertSum = faultCodeDto.getInsertSum();
        if (insertSum > 0){
            for (int i = 0; i < insertSum; i++) {
                FaultCode faultCode = new FaultCode();
                faultCode.setVid(i);
                faultCode.setSpn(i);
                faultCode.setFmi(i);
                faultCode.setBegin(System.currentTimeMillis() / 1000);
                faultCode.setEnd(System.currentTimeMillis() / 1000);
                faultCode.setCon(i);
                faultCode.setbLat(i);
                faultCode.setbLng(i);
                faultCode.seteLat(i);
                faultCode.seteLng(i);
                mongoTemplate.save(faultCode, "FaultCode_"+tableSuffix+"");
            }
        }
    }
}
