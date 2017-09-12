package com.navinfo.opentsp.gateway.tcp.proto.electrocar;

//import com.aerozh.common.entity.*;
//import com.aerozh.common.entity.topic.VehicleRTTopic;
import com.navinfo.opentsp.gateway.tcp.proto.electrocar.util.Convert;
import com.navinfo.opentsp.gateway.tcp.proto.electrocar.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangyd
 * @date 2017-05-23
 */
@Component
public class SendData2Kafka {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    private String vin = "test_by_gzh_888";

    @PostConstruct
    public void sendData2Kafka() {
        String value = "123";
        for (int i = 0; i< 1000 ;i ++){
            kafkaTemplate.send(topic, value + i);
        }
    }

}
//        VehicleRTTopic.VehicleRTTopicInfo.Builder vehicleRTTopicBean = null;
//        long startTime = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000L).getTime();
//        long endTime = new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000L).getTime();
//
//        for (long i = 0; i < 10; i ++) {
//            vehicleRTTopicBean = VehicleRTTopic.VehicleRTTopicInfo.newBuilder();
//            vehicleRTTopicBean.setVehicleData(gb01Data())
//                    .setAdmData(gb02Data())
//                    .setLocationData(gb05Data())
//                    .setExtremumData(gb06Data())
//                    .setVehicleAlarmData(gb07Data())
//                    .setPbData(gb08Data())
//                    .setDbptData(gb09Data())
//                    .setVehicleId(0)
//                    .setVin(vin)
//                    .setDataDate(DateUtil.format(new Date()));
//
//            kafkaTemplate.send(topic, vehicleRTTopicBean.build().toByteArray());
//            System.out.println("i.........................:"+i);
//            vehicleRTTopicBean.clear();
//        }
//        for (long i = startTime; i < endTime; i = i + 10 * 1000) {
//            vehicleRTTopicBean = VehicleRTTopic.VehicleRTTopicInfo.newBuilder();
//            vehicleRTTopicBean.setVehicleData(gb01Data())
//                    .setAdmData(gb02Data())
//                    .setLocationData(gb05Data())
//                    .setExtremumData(gb06Data())
//                    .setVehicleAlarmData(gb07Data())
//                    .setPbData(gb08Data())
//                    .setDbptData(gb09Data())
//                    .setVehicleId(0)
//                    .setVin(vin)
//                    .setDataDate(DateUtil.format(new Date(i)));
//
//            kafkaTemplate.send(topic, vehicleRTTopicBean.build().toByteArray());
//            vehicleRTTopicBean.clear();
//        }
//    }


//    /**
//     * 01整车数据
//     *
//     * @return
//     */
//    private VehicleData.VehicleDataInfo.Builder gb01Data() {
//        VehicleData.VehicleDataInfo.Builder data = VehicleData.VehicleDataInfo.newBuilder();
//        int vehstatus = 1; //车辆状态
//        if (Convert.InRegion(1, 3, vehstatus) || Convert.isExceptionOrInvalid(1, vehstatus)) {
//            data.setVehstatus(vehstatus);
//        }
//
//        int chstatus = 2; //充电状态
//        if (Convert.InRegion(1, 4, chstatus) || Convert.isExceptionOrInvalid(1, chstatus)) {
//            data.setChstatus(chstatus);
//        }
//
//        int opermode = 2; //运行模式
//        if (Convert.InRegion(1, 3, opermode) || Convert.isExceptionOrInvalid(1, opermode)) {
//            data.setOpermode(opermode);
//        }
//
//        int speed = 2000; //车速
//        if (Convert.InRegion(0, 2200, speed) || Convert.isExceptionOrInvalid(2, speed)) {
//            data.setSpeed(speed);
//        }
//
//        long mileage = 6000; //累计里程
//        if (Convert.InRegion(0, 9999999, mileage) || Convert.isExceptionOrInvalid(4, mileage)) {
//            data.setMileage(mileage);
//        }
//
//        int tolvoltage = 600; //总电压
//        if (Convert.InRegion(0, 10000, tolvoltage) || Convert.isExceptionOrInvalid(2, tolvoltage)) {
//            data.setTolvoltage(tolvoltage);
//        }
//
//        int tolcur = 100; //总电流
//        if (Convert.InRegion(0, 20000, tolcur)) {
//            data.setTolcur(tolcur - 10000);
//        } else if (Convert.isExceptionOrInvalid(2, tolcur)) {
//            data.setTolcur(tolcur);
//        }
//
//        int SOC = 3; //SOC
//        if (Convert.InRegion(0, 100, SOC) || Convert.isExceptionOrInvalid(1, SOC)) {
//            data.setSoc(SOC);
//        }
//
//        int dcstatus = 2; //DC-DC状态
//        if (Convert.InRegion(1, 2, dcstatus) || Convert.isExceptionOrInvalid(1, dcstatus)) {
//            data.setDcstatus(dcstatus);
//        }
//
//        int stall = 2; //挡位
//        data.setStall(stall);
//
//        int instance = 200; //绝缘电阻
//        if (Convert.InRegion(0, 60000, instance)) {
//            data.setInstance(instance);
//        }
//
//        int aptv = 50; //加速踏板行程值
//        if (Convert.InRegion(0, 100, aptv)) {
//            data.setAptv(aptv);
//        }
//        int brakestatus = 55; //制动踏板状态
//        if (Convert.InRegion(0, 100, brakestatus)) {
//            data.setBrakestatus(brakestatus);
//        }
//
//        return data;
//    }
//
//    /**
//     * 02汽车驱动电机数据
//     *
//     * @return
//     */
//    private AdmData.AdmDataInfo.Builder gb02Data() {
//        AdmData.AdmDataInfo.Builder admData = AdmData.AdmDataInfo.newBuilder();
//        int dmnum = 2; //数量
//        if (Convert.InRegion(1, 253, dmnum)) {
//            admData.setDmnum(dmnum);
//            for (int i = 0; i < dmnum; i++) {
//                AdmPojo.AdmPojoInfo.Builder admPojo = AdmPojo.AdmPojoInfo.newBuilder();
//
//                int dmserialno = i + 1;//驱动电机序号
//                if (Convert.InRegion(1, 253, dmserialno)) {
//                    admPojo.setDmserialno(dmserialno);
//                } else {
//                    System.out.println("驱动电机序号" + dmserialno);
//                }
//
//                int dmstatus = 1;//驱动电机状态
//                if (Convert.InRegion(1, 4, dmstatus) || Convert.isExceptionOrInvalid(1, dmstatus)) {
//                    admPojo.setDmstatus(dmstatus);
//                } else {
//                    System.out.println("驱动电机状态" + dmstatus);
//                }
//                int dmcontem = 32;//驱动电机控制器温度
//                if (Convert.InRegion(0, 250, dmcontem)) {
//                    admPojo.setDmcontem(dmcontem - 40);
//                } else if (Convert.isExceptionOrInvalid(1, dmcontem)) {
//                    admPojo.setDmcontem(dmcontem);
//                } else {
//                    System.out.println("驱动电机控制器温度" + dmcontem);
//                }
//
//                int dmspeed = 30055;//电机转速
//                if (Convert.InRegion(0, 65531, dmspeed)) {
//                    admPojo.setDmspeed(dmspeed - 20000);
//                } else if (Convert.isExceptionOrInvalid(2, dmspeed)) {
//                    admPojo.setDmspeed(dmspeed);
//                } else {
//                    System.out.println("电机转速" + dmspeed);
//                }
//
//                int dmtorque = 20;//电机转矩
//                if (Convert.InRegion(0, 65531, dmtorque)) {
//                    admPojo.setDmtorque(dmtorque - 20000);
//                } else if (Convert.isExceptionOrInvalid(2, dmtorque)) {
//                    admPojo.setDmtorque(dmtorque);
//                } else {
//                    System.out.println("电机转矩" + dmtorque);
//                }
//
//                int dmtem = 200;//驱动电机温度
//                if (Convert.InRegion(0, 250, dmtem)) {
//                    admPojo.setDmtem(dmtem - 40);
//                } else if (Convert.isExceptionOrInvalid(1, dmtem)) {
//                    admPojo.setDmtem(dmtem);
//                } else {
//                    System.out.println("驱动电机温度" + dmtem);
//                }
//
//                int mcinvol = 50;//电机控制器输入电压
//                if (Convert.InRegion(0, 60000, mcinvol) || Convert.isExceptionOrInvalid(2, mcinvol)) {
//                    admPojo.setMcinvol(mcinvol);
//                } else {
//                    System.out.println("电机控制器输入电压" + mcinvol);
//                }
//
//                int dbcomc = 40;//电机控制器直流母线电流
//                if (Convert.InRegion(0, 20000, dbcomc)) {
//                    admPojo.setDbcomc(dbcomc - 10000);
//                } else if (Convert.isExceptionOrInvalid(2, dbcomc)) {
//                    admPojo.setDbcomc(dbcomc);
//                } else {
//                    System.out.println("电机控制器直流母线电流" + dbcomc);
//                }
//                admData.addList(admPojo);
//            }
//        }
//        return admData;
//    }
//
//    /**
//     * 05位置数据
//     *
//     * @return
//     */
//    private LocationData.LocationDataInfo.Builder gb05Data() {
//        LocationData.LocationDataInfo.Builder data = LocationData.LocationDataInfo.newBuilder();
//        data.setStatus(1);
//        data.setLongitude(111232723);
//        data.setLatitude(34829461);
//        return data;
//    }
//
//    /**
//     * 06温度数据
//     *
//     * @return
//     */
//    private ExtremumData.ExtremumDataInfo.Builder gb06Data() {
//        ExtremumData.ExtremumDataInfo.Builder data = ExtremumData.ExtremumDataInfo.newBuilder();
//
//        int topVolSno = 1; // 最高电压电池子系统号  有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效
//        // 需要对比原 data.getTopVolSno是否是有效值，如果无效则将topVolSno进行赋值；如果之前是有效，则不进行更新
//        if (Convert.InRegion(1, 250, topVolSno) || Convert.isExceptionOrInvalid(1, topVolSno)) {
//            data.setTopVolSno(topVolSno);
//        } else {
//            System.out.println("最高电压电池子系统号值超出范围" + topVolSno);
//        }
//
//        int topVolSCode = 2;
//        if (Convert.InRegion(1, 250, topVolSCode) || Convert.isExceptionOrInvalid(1, topVolSCode)) {
//            data.setTopVolSCode(topVolSCode);
//        } else {
//            System.out.println("最高电压电池单体代号值超出范围" + topVolSCode);
//        }
//
//        int topsVol = 1000;
//        if (Convert.InRegion(0, 15000, topsVol) || Convert.isExceptionOrInvalid(2, topsVol)) {
//            data.setTopsVol(topsVol);
//        } else {
//            System.out.println("最高电压电池单体代号值超出范围" + topsVol);
//        }
//
//        int lowVolSno = 22;
//        if (Convert.InRegion(1, 250, lowVolSno) || Convert.isExceptionOrInvalid(1, lowVolSno)) {
//            data.setLowVolSno(lowVolSno);
//        } else {
//            System.out.println("最低电压电池子系统号值超出范围" + lowVolSno);
//        }
//
//        int lowVolSCode = 33;
//        if (Convert.InRegion(1, 250, lowVolSCode) || Convert.isExceptionOrInvalid(1, lowVolSCode)) {
//            data.setLowVolSCode(lowVolSCode);
//        } else {
//            System.out.println("最低电压电池单体代号值超出范围" + lowVolSCode);
//        }
//
//        int lowsVol = 44;
//        if (Convert.InRegion(0, 15000, lowsVol) || Convert.isExceptionOrInvalid(2, lowsVol)) {
//            data.setLowsVol(lowsVol);
//        } else {
//            System.out.println("电池单体电压最低值超出范围" + lowsVol);
//        }
//
//        int tpsbTemNo = 55;
//        if (Convert.InRegion(1, 250, tpsbTemNo) || Convert.isExceptionOrInvalid(1, tpsbTemNo)) {
//            data.setTpsbTemNo(tpsbTemNo);
//        } else {
//            System.out.println("最高温度子系统号值超出范围" + tpsbTemNo);
//        }
//
//        int tpsbTemCode = 55;
//        if (Convert.InRegion(1, 250, tpsbTemCode) || Convert.isExceptionOrInvalid(1, tpsbTemCode)) {
//            data.setTpsbTemCode(tpsbTemCode);
//        } else {
//            System.out.println("最高温度探针序号值超出范围" + tpsbTemCode);
//        }
//
//        int tpsbTem = 55;
//        if (Convert.InRegion(0, 250, tpsbTem)) {
//            data.setTpsbTem(tpsbTem - 40);
//        } else if (Convert.isExceptionOrInvalid(1, tpsbTem)) {
//            data.setTpsbTem(tpsbTem);
//        } else {
//            System.out.println("最高温度值超出范围" + tpsbTem);
//        }
//
//        int lpsbTemNo = 55;
//        if (Convert.InRegion(1, 250, lpsbTemNo) || Convert.isExceptionOrInvalid(1, lpsbTemNo)) {
//            data.setLpsbTemNo(lpsbTemNo);
//        } else {
//            System.out.println("最低温度子系统号值超出范围" + lpsbTemNo);
//        }
//
//        int lpsbTemCode = 55;
//        if (Convert.InRegion(1, 250, lpsbTemCode) || Convert.isExceptionOrInvalid(1, lpsbTemCode)) {
//            data.setLpsbTemCode(lpsbTemCode);
//        } else {
//            System.out.println("最低温度探针值超出范围" + lpsbTemCode);
//        }
//
//        int lpsbTem = 55;
//        if (Convert.InRegion(0, 250, lpsbTem)) {
//            data.setLpsbTem(lpsbTem - 40);
//        } else if (Convert.isExceptionOrInvalid(1, lpsbTem)) {
//            data.setLpsbTem(lpsbTem);
//        } else {
//            System.out.println("最低温度值超出范围" + lpsbTem);
//        }
//
//        return data;
//    }
//
//    /**
//     * 07报警数据
//     *
//     * @return
//     */
//    private VehicleAlarmData.VehicleAlarmDataInfo.Builder gb07Data() {
//        int num = 0;
//        VehicleAlarmData.VehicleAlarmDataInfo.Builder data = VehicleAlarmData.VehicleAlarmDataInfo.newBuilder();
//        int topAlarmLevel = 2; //最高报警等级
//        if (Convert.InRegion(0, 3, topAlarmLevel) || Convert.isExceptionOrInvalid(1, topAlarmLevel)) {
//            data.setTopAlarmLevel(topAlarmLevel);
//        } else {
//            System.out.println("最高电压电池子系统号值超出范围" + topAlarmLevel);
//        }
//
//        long alarmSign = 1; //通用报警标志
//        data.setAlarmSign(alarmSign);
//        int psbFaultCount = 250; //可充电储能装置故障总数
//        if (Convert.InRegion(0, 252, psbFaultCount) || Convert.isExceptionOrInvalid(1, psbFaultCount)) {
//            data.setPsbFaultCount(psbFaultCount);
//        } else {
//            System.out.println("可充电储能装置故障总数超出有效值范围" + psbFaultCount);
//        }
//
//        num = 6;
//        if (psbFaultCount > 0) {
//            for (int i = 0; i < psbFaultCount; i++) {
//                long psbFault = 3;
//                data.addPsbFaultList(psbFault);
//            }
//        }
//
//        int dmFaultCount = 1; //驱动机故障总数
//        if (Convert.InRegion(0, 252, dmFaultCount) || Convert.isExceptionOrInvalid(1, dmFaultCount)) {
//            data.setDmFaultCount(dmFaultCount);
//        } else {
//            System.out.println("驱动机故障总数超出有效值范围" + dmFaultCount);
//        }
//
//        if (dmFaultCount > 0) {
//            List<Long> listTwo = new ArrayList<Long>();
//            for (int i = 0; i < dmFaultCount; i++) {
//                long dmFault = 33;
//                data.addDmFaultList(dmFault);
//            }
//        }
//
//        int eFaultCount2 = 0;//发动机故障总数
//        if (Convert.InRegion(0, 252, eFaultCount2) || Convert.isExceptionOrInvalid(1, eFaultCount2)) {
//            data.setEFaultCount2(eFaultCount2);
//        } else {
//            System.out.println("发动机故障总数超出有效值范围" + eFaultCount2);
//        }
//
//        if (eFaultCount2 > 0) {
//            for (int i = 0; i < eFaultCount2; i++) {
//                long eFault = 666;
//                data.addEFaultList2(eFault);
//            }
//        }
//
//        int eFaultCount4 = 1;//其它故障总数
//        if (Convert.InRegion(0, 252, eFaultCount4) || Convert.isExceptionOrInvalid(1, eFaultCount4)) {
//            data.setEFaultCount4(eFaultCount4);
//        } else {
//            System.out.println("其它故障总数超出有效值范围" + eFaultCount4);
//        }
//
//        if (eFaultCount4 > 0) {
//            for (int i = 0; i < eFaultCount4; i++) {
//                long eFault1 = 3;
//                data.addEFaultList4(eFault1);
//            }
//        }
//        return data;
//    }
//
//    /**
//     * 08动力蓄电池数据
//     *
//     * @return
//     */
//    private PbData.PbDataInfo.Builder gb08Data() {
//        PbData.PbDataInfo.Builder pbData = PbData.PbDataInfo.newBuilder();
//
//        int nopbs = 3; //数量
//        List<PbPojo.PbPojoInfo.Builder> list = new ArrayList<>();
//        if (Convert.InRegion(0, 200, nopbs)) {
//            pbData.setNopbs(nopbs);
//
//            int defaultIndex = 0;//默认的起始点
//            for (int i = 0; i < nopbs; i++) {
//                int batterysNo = i + 1;//电池子系统号
//
//                PbPojo.PbPojoInfo.Builder pbPojo = PbPojo.PbPojoInfo.newBuilder();
//                //判断缓存中是否有电池数据，如果有，则更新到电池单体电压列表中
//                for (PbPojo.PbPojoInfo.Builder pbItem : list) {
//                    if (pbItem.getBatterysNo() == batterysNo) {
//                        pbPojo = pbItem;
//                        break;
//                    }
//                }
//
//                if (Convert.InRegion(1, 250, batterysNo)) {
//                    pbPojo.setBatterysNo(batterysNo);
//                } else {
//                    System.out.println("可充电储能子系统号" + batterysNo);
//                }
//
//                int pbVoltage = 300;//动力蓄电池电压
//                if (Convert.InRegion(0, 10000, pbVoltage) || Convert.isExceptionOrInvalid(2, pbVoltage)) {
//                    pbPojo.setPbVoltage(pbVoltage);
//                } else {
//                    System.out.println("可充电储能装置电压" + pbVoltage);
//                }
//
//                int pbCurrent = 300;//动力蓄电池电流
//                if (Convert.InRegion(0, 20000, pbCurrent)) {
//                    pbPojo.setPbCurrent(pbCurrent - 10000);
//                } else if (Convert.isExceptionOrInvalid(2, pbCurrent)) {
//                    pbPojo.setPbCurrent(pbCurrent);
//                } else {
//                    System.out.println("可充电储能装置电流" + pbCurrent);
//                }
//
//                int tnosb = 300;//单体蓄电池总数
//                if (Convert.InRegion(0, 65531, tnosb) || Convert.isExceptionOrInvalid(2, tnosb)) {
//                    pbPojo.setTnosb(tnosb);
//                } else {
//                    System.out.println("单体电池总数" + tnosb);
//                }
//
//                int snotfsb = 30;//本帧起始电池序号
//                if (Convert.InRegion(1, 65531, snotfsb)) {
//                    pbPojo.setSnotfsb(snotfsb);
//                } else {
//                    System.out.println("本帧起始电池序号" + snotfsb);
//                }
//
//                int tnofscb = 10;//本帧单体电池总数
//                if (Convert.InRegion(1, 200, tnofscb)) {
//                    pbPojo.setSnotfsb(tnofscb);
//                } else {
//                    System.out.println("本帧单体电池总数" + tnofscb);
//                }
//
//                //判断是否要分包。按照本帧起始电池序号+本帧单体电池总数<单体蓄电池总数为依据，
////                if ((tnofscb + snotfsb) < tnosb) {
////                    vehicleRTTopicBean.setIsMultiPacket(true);
////                } else {
////                    vehicleRTTopicBean.setIsMultiPacket(false);
////                }
//
//                for (int h = 0; h < tnofscb; h++) {
//                    int sbVoltage = 50000;//单体蓄电池电压
//                    if (Convert.InRegion(0, 60000, tnofscb) || Convert.isExceptionOrInvalid(2, sbVoltage)) {
//                        pbPojo.addSbVoltage(sbVoltage);
//                    } else {
//                        System.out.println("单体蓄电池电压" + tnofscb);
//                    }
//                }
//                defaultIndex += 10 + tnofscb * 2;//遍历每个充电储能子系统电压数据包的长度为固定10+tnofscb*2个字节。
//                list.add(pbPojo);
//                pbData.addList(pbPojo);
//            }
//        }
//
//        return pbData;
//    }
//
//    /**
//     * 09可充电储能装置温度数据
//     *
//     * @return
//     */
//    private DbptData.DbptDataInfo.Builder gb09Data() {
//        DbptData.DbptDataInfo.Builder dbptData = DbptData.DbptDataInfo.newBuilder();
//        int nopbs = 3; //电池子系统个数
//        if (Convert.InRegion(1, 250, nopbs) || Convert.isExceptionOrInvalid(1, nopbs)) {
//            dbptData.setNopbs(nopbs);
//
//            for (int i = 0; i < nopbs; i++) {
//                DbptPojo.DbptPojoInfo.Builder dbptPojo = DbptPojo.DbptPojoInfo.newBuilder();
//                int batterysNo = i + 1;//电池子系统号
//                if (Convert.InRegion(1, 250, batterysNo)) {
//                    dbptPojo.setBatterysNo(batterysNo);
//                } else {
//                    System.out.println("可充电子系统个数超出范围" + batterysNo);
//                }
//
//                int batterytp = 2;//温度探针个数
//                if (Convert.InRegion(1, 65531, batterytp) || Convert.isExceptionOrInvalid(2, batterytp)) {
//                    dbptPojo.setBatterytp(batterytp);
//                    for (int h = 0; h < batterytp; h++) {
//                        int ttbatterytp = 100;//单体蓄电池电压
//                        if (Convert.InRegion(1, 250, ttbatterytp)) {
//                            dbptPojo.addTtBatteryList(ttbatterytp - 40);
//                        } else if (Convert.isExceptionOrInvalid(1, ttbatterytp)) {
//                            dbptPojo.addTtBatteryList(ttbatterytp);
//                        }
//                    }
//                } else {
//                    System.out.println("温度探针个数" + batterysNo);
//                }
//                dbptData.addList(dbptPojo);
//            }
//        }
//
//        return dbptData;
//    }
//}















//package com.navinfo.opentsp.gateway.tcp.proto.electrocar;
//
//import com.aerozh.common.entity.*;
//import com.aerozh.common.entity.topic.VehicleRTTopic;
//import com.navinfo.opentsp.gateway.tcp.proto.electrocar.util.Convert;
//import com.navinfo.opentsp.gateway.tcp.proto.electrocar.util.DateUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author wangyd
// * @date 2017-05-23
// */
//@Component
//public class SendData2Kafka {
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    @Value("${kafka.topic}")
//    private String topic;
//
//    private String vin = "ZHDDZ666666645678";
//
//    @PostConstruct
//    public void sendData2Kafka() {
//        VehicleRTTopic.VehicleRTTopicInfo.Builder vehicleRTTopicBean = null;
//        long startTime = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000L).getTime();
//        long endTime = new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000L).getTime();
//        long sum = 0L;
//        for (long i = 0; i < 10; i ++) {
//            vehicleRTTopicBean = VehicleRTTopic.VehicleRTTopicInfo.newBuilder();
//            vehicleRTTopicBean.setVehicleData(gb01Data())
//                    .setAdmData(gb02Data())
//                    .setLocationData(gb05Data())
//                    .setExtremumData(gb06Data())
//                    .setVehicleAlarmData(gb07Data())
//                    .setPbData(gb08Data())
//                    .setDbptData(gb09Data())
//                    .setVehicleId(0)
//                    .setVin(vin)
//                    .setDataDate(DateUtil.format(new Date(i)));
//
//            kafkaTemplate.send(topic, vin,vehicleRTTopicBean.build().toByteArray());
//            vehicleRTTopicBean.clear();
//            sum ++;
//        }
//        System.out.println("写入kakfa条数：" + sum + "...............................................................");
//    }
//
//
//    /**
//     * 01整车数据
//     *
//     * @return
//     */
//    private VehicleData.VehicleDataInfo.Builder gb01Data() {
//        VehicleData.VehicleDataInfo.Builder data = VehicleData.VehicleDataInfo.newBuilder();
//        int vehstatus = 1; //车辆状态
//        if (Convert.InRegion(1, 3, vehstatus) || Convert.isExceptionOrInvalid(1, vehstatus)) {
//            data.setVehstatus(vehstatus);
//        }
//
//        int chstatus = 2; //充电状态
//        if (Convert.InRegion(1, 4, chstatus) || Convert.isExceptionOrInvalid(1, chstatus)) {
//            data.setChstatus(chstatus);
//        }
//
//        int opermode = 2; //运行模式
//        if (Convert.InRegion(1, 3, opermode) || Convert.isExceptionOrInvalid(1, opermode)) {
//            data.setOpermode(opermode);
//        }
//
//        int speed = 2000; //车速
//        if (Convert.InRegion(0, 2200, speed) || Convert.isExceptionOrInvalid(2, speed)) {
//            data.setSpeed(speed);
//        }
//
//        long mileage = 6000; //累计里程
//        if (Convert.InRegion(0, 9999999, mileage) || Convert.isExceptionOrInvalid(4, mileage)) {
//            data.setMileage(mileage);
//        }
//
//        int tolvoltage = 600; //总电压
//        if (Convert.InRegion(0, 10000, tolvoltage) || Convert.isExceptionOrInvalid(2, tolvoltage)) {
//            data.setTolvoltage(tolvoltage);
//        }
//
//        int tolcur = 100; //总电流
//        if (Convert.InRegion(0, 20000, tolcur)) {
//            data.setTolcur(tolcur - 10000);
//        } else if (Convert.isExceptionOrInvalid(2, tolcur)) {
//            data.setTolcur(tolcur);
//        }
//
//        int SOC = 3; //SOC
//        if (Convert.InRegion(0, 100, SOC) || Convert.isExceptionOrInvalid(1, SOC)) {
//            data.setSoc(SOC);
//        }
//
//        int dcstatus = 2; //DC-DC状态
//        if (Convert.InRegion(1, 2, dcstatus) || Convert.isExceptionOrInvalid(1, dcstatus)) {
//            data.setDcstatus(dcstatus);
//        }
//
//        int stall = 2; //挡位
//        data.setStall(stall);
//
//        int instance = 200; //绝缘电阻
//        if (Convert.InRegion(0, 60000, instance)) {
//            data.setInstance(instance);
//        }
//
//        int aptv = 50; //加速踏板行程值
//        if (Convert.InRegion(0, 100, aptv)) {
//            data.setAptv(aptv);
//        }
//        int brakestatus = 55; //制动踏板状态
//        if (Convert.InRegion(0, 100, brakestatus)) {
//            data.setBrakestatus(brakestatus);
//        }
//
//        return data;
//    }
//
//    /**
//     * 02汽车驱动电机数据
//     *
//     * @return
//     */
//    private AdmData.AdmDataInfo.Builder gb02Data() {
//        AdmData.AdmDataInfo.Builder admData = AdmData.AdmDataInfo.newBuilder();
//        int dmnum = 2; //数量
//        if (Convert.InRegion(1, 253, dmnum)) {
//            admData.setDmnum(dmnum);
//            for (int i = 0; i < dmnum; i++) {
//                AdmPojo.AdmPojoInfo.Builder admPojo = AdmPojo.AdmPojoInfo.newBuilder();
//
//                int dmserialno = i + 1;//驱动电机序号
//                if (Convert.InRegion(1, 253, dmserialno)) {
//                    admPojo.setDmserialno(dmserialno);
//                } else {
//                    System.out.println("驱动电机序号" + dmserialno);
//                }
//
//                int dmstatus = 1;//驱动电机状态
//                if (Convert.InRegion(1, 4, dmstatus) || Convert.isExceptionOrInvalid(1, dmstatus)) {
//                    admPojo.setDmstatus(dmstatus);
//                } else {
//                    System.out.println("驱动电机状态" + dmstatus);
//                }
//                int dmcontem = 32;//驱动电机控制器温度
//                if (Convert.InRegion(0, 250, dmcontem)) {
//                    admPojo.setDmcontem(dmcontem - 40);
//                } else if (Convert.isExceptionOrInvalid(1, dmcontem)) {
//                    admPojo.setDmcontem(dmcontem);
//                } else {
//                    System.out.println("驱动电机控制器温度" + dmcontem);
//                }
//
//                int dmspeed = 30055;//电机转速
//                if (Convert.InRegion(0, 65531, dmspeed)) {
//                    admPojo.setDmspeed(dmspeed - 20000);
//                } else if (Convert.isExceptionOrInvalid(2, dmspeed)) {
//                    admPojo.setDmspeed(dmspeed);
//                } else {
//                    System.out.println("电机转速" + dmspeed);
//                }
//
//                int dmtorque = 20;//电机转矩
//                if (Convert.InRegion(0, 65531, dmtorque)) {
//                    admPojo.setDmtorque(dmtorque - 20000);
//                } else if (Convert.isExceptionOrInvalid(2, dmtorque)) {
//                    admPojo.setDmtorque(dmtorque);
//                } else {
//                    System.out.println("电机转矩" + dmtorque);
//                }
//
//                int dmtem = 200;//驱动电机温度
//                if (Convert.InRegion(0, 250, dmtem)) {
//                    admPojo.setDmtem(dmtem - 40);
//                } else if (Convert.isExceptionOrInvalid(1, dmtem)) {
//                    admPojo.setDmtem(dmtem);
//                } else {
//                    System.out.println("驱动电机温度" + dmtem);
//                }
//
//                int mcinvol = 50;//电机控制器输入电压
//                if (Convert.InRegion(0, 60000, mcinvol) || Convert.isExceptionOrInvalid(2, mcinvol)) {
//                    admPojo.setMcinvol(mcinvol);
//                } else {
//                    System.out.println("电机控制器输入电压" + mcinvol);
//                }
//
//                int dbcomc = 40;//电机控制器直流母线电流
//                if (Convert.InRegion(0, 20000, dbcomc)) {
//                    admPojo.setDbcomc(dbcomc - 10000);
//                } else if (Convert.isExceptionOrInvalid(2, dbcomc)) {
//                    admPojo.setDbcomc(dbcomc);
//                } else {
//                    System.out.println("电机控制器直流母线电流" + dbcomc);
//                }
//                admData.addList(admPojo);
//            }
//        }
//        return admData;
//    }
//
//    /**
//     * 05位置数据
//     *
//     * @return
//     */
//    private LocationData.LocationDataInfo.Builder gb05Data() {
//        LocationData.LocationDataInfo.Builder data = LocationData.LocationDataInfo.newBuilder();
//        data.setStatus(1);
//        data.setLongitude(111232723);
//        data.setLatitude(34829461);
//        return data;
//    }
//
//    /**
//     * 06温度数据
//     *
//     * @return
//     */
//    private ExtremumData.ExtremumDataInfo.Builder gb06Data() {
//        ExtremumData.ExtremumDataInfo.Builder data = ExtremumData.ExtremumDataInfo.newBuilder();
//
//        int topVolSno = 1; // 最高电压电池子系统号  有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效
//        // 需要对比原 data.getTopVolSno是否是有效值，如果无效则将topVolSno进行赋值；如果之前是有效，则不进行更新
//        if (Convert.InRegion(1, 250, topVolSno) || Convert.isExceptionOrInvalid(1, topVolSno)) {
//            data.setTopVolSno(topVolSno);
//        } else {
//            System.out.println("最高电压电池子系统号值超出范围" + topVolSno);
//        }
//
//        int topVolSCode = 2;
//        if (Convert.InRegion(1, 250, topVolSCode) || Convert.isExceptionOrInvalid(1, topVolSCode)) {
//            data.setTopVolSCode(topVolSCode);
//        } else {
//            System.out.println("最高电压电池单体代号值超出范围" + topVolSCode);
//        }
//
//        int topsVol = 1000;
//        if (Convert.InRegion(0, 15000, topsVol) || Convert.isExceptionOrInvalid(2, topsVol)) {
//            data.setTopsVol(topsVol);
//        } else {
//            System.out.println("最高电压电池单体代号值超出范围" + topsVol);
//        }
//
//        int lowVolSno = 22;
//        if (Convert.InRegion(1, 250, lowVolSno) || Convert.isExceptionOrInvalid(1, lowVolSno)) {
//            data.setLowVolSno(lowVolSno);
//        } else {
//            System.out.println("最低电压电池子系统号值超出范围" + lowVolSno);
//        }
//
//        int lowVolSCode = 33;
//        if (Convert.InRegion(1, 250, lowVolSCode) || Convert.isExceptionOrInvalid(1, lowVolSCode)) {
//            data.setLowVolSCode(lowVolSCode);
//        } else {
//            System.out.println("最低电压电池单体代号值超出范围" + lowVolSCode);
//        }
//
//        int lowsVol = 44;
//        if (Convert.InRegion(0, 15000, lowsVol) || Convert.isExceptionOrInvalid(2, lowsVol)) {
//            data.setLowsVol(lowsVol);
//        } else {
//            System.out.println("电池单体电压最低值超出范围" + lowsVol);
//        }
//
//        int tpsbTemNo = 55;
//        if (Convert.InRegion(1, 250, tpsbTemNo) || Convert.isExceptionOrInvalid(1, tpsbTemNo)) {
//            data.setTpsbTemNo(tpsbTemNo);
//        } else {
//            System.out.println("最高温度子系统号值超出范围" + tpsbTemNo);
//        }
//
//        int tpsbTemCode = 55;
//        if (Convert.InRegion(1, 250, tpsbTemCode) || Convert.isExceptionOrInvalid(1, tpsbTemCode)) {
//            data.setTpsbTemCode(tpsbTemCode);
//        } else {
//            System.out.println("最高温度探针序号值超出范围" + tpsbTemCode);
//        }
//
//        int tpsbTem = 55;
//        if (Convert.InRegion(0, 250, tpsbTem)) {
//            data.setTpsbTem(tpsbTem - 40);
//        } else if (Convert.isExceptionOrInvalid(1, tpsbTem)) {
//            data.setTpsbTem(tpsbTem);
//        } else {
//            System.out.println("最高温度值超出范围" + tpsbTem);
//        }
//
//        int lpsbTemNo = 55;
//        if (Convert.InRegion(1, 250, lpsbTemNo) || Convert.isExceptionOrInvalid(1, lpsbTemNo)) {
//            data.setLpsbTemNo(lpsbTemNo);
//        } else {
//            System.out.println("最低温度子系统号值超出范围" + lpsbTemNo);
//        }
//
//        int lpsbTemCode = 55;
//        if (Convert.InRegion(1, 250, lpsbTemCode) || Convert.isExceptionOrInvalid(1, lpsbTemCode)) {
//            data.setLpsbTemCode(lpsbTemCode);
//        } else {
//            System.out.println("最低温度探针值超出范围" + lpsbTemCode);
//        }
//
//        int lpsbTem = 55;
//        if (Convert.InRegion(0, 250, lpsbTem)) {
//            data.setLpsbTem(lpsbTem - 40);
//        } else if (Convert.isExceptionOrInvalid(1, lpsbTem)) {
//            data.setLpsbTem(lpsbTem);
//        } else {
//            System.out.println("最低温度值超出范围" + lpsbTem);
//        }
//
//        return data;
//    }
//
//    /**
//     * 07报警数据
//     *
//     * @return
//     */
//    private VehicleAlarmData.VehicleAlarmDataInfo.Builder gb07Data() {
//        int num = 0;
//        VehicleAlarmData.VehicleAlarmDataInfo.Builder data = VehicleAlarmData.VehicleAlarmDataInfo.newBuilder();
//        int topAlarmLevel = 2; //最高报警等级
//        if (Convert.InRegion(0, 3, topAlarmLevel) || Convert.isExceptionOrInvalid(1, topAlarmLevel)) {
//            data.setTopAlarmLevel(topAlarmLevel);
//        } else {
//            System.out.println("最高电压电池子系统号值超出范围" + topAlarmLevel);
//        }
//
//        long alarmSign = 1; //通用报警标志
//        data.setAlarmSign(alarmSign);
//        int psbFaultCount = 250; //可充电储能装置故障总数
//        if (Convert.InRegion(0, 252, psbFaultCount) || Convert.isExceptionOrInvalid(1, psbFaultCount)) {
//            data.setPsbFaultCount(psbFaultCount);
//        } else {
//            System.out.println("可充电储能装置故障总数超出有效值范围" + psbFaultCount);
//        }
//
//        num = 6;
//        if (psbFaultCount > 0) {
//            for (int i = 0; i < psbFaultCount; i++) {
//                long psbFault = 3;
//                data.addPsbFaultList(psbFault);
//            }
//        }
//
//        int dmFaultCount = 1; //驱动机故障总数
//        if (Convert.InRegion(0, 252, dmFaultCount) || Convert.isExceptionOrInvalid(1, dmFaultCount)) {
//            data.setDmFaultCount(dmFaultCount);
//        } else {
//            System.out.println("驱动机故障总数超出有效值范围" + dmFaultCount);
//        }
//
//        if (dmFaultCount > 0) {
//            List<Long> listTwo = new ArrayList<Long>();
//            for (int i = 0; i < dmFaultCount; i++) {
//                long dmFault = 33;
//                data.addDmFaultList(dmFault);
//            }
//        }
//
//        int eFaultCount2 = 0;//发动机故障总数
//        if (Convert.InRegion(0, 252, eFaultCount2) || Convert.isExceptionOrInvalid(1, eFaultCount2)) {
//            data.setEFaultCount2(eFaultCount2);
//        } else {
//            System.out.println("发动机故障总数超出有效值范围" + eFaultCount2);
//        }
//
//        if (eFaultCount2 > 0) {
//            for (int i = 0; i < eFaultCount2; i++) {
//                long eFault = 666;
//                data.addEFaultList2(eFault);
//            }
//        }
//
//        int eFaultCount4 = 1;//其它故障总数
//        if (Convert.InRegion(0, 252, eFaultCount4) || Convert.isExceptionOrInvalid(1, eFaultCount4)) {
//            data.setEFaultCount4(eFaultCount4);
//        } else {
//            System.out.println("其它故障总数超出有效值范围" + eFaultCount4);
//        }
//
//        if (eFaultCount4 > 0) {
//            for (int i = 0; i < eFaultCount4; i++) {
//                long eFault1 = 3;
//                data.addEFaultList4(eFault1);
//            }
//        }
//        return data;
//    }
//
//    /**
//     * 08动力蓄电池数据
//     *
//     * @return
//     */
//    private PbData.PbDataInfo.Builder gb08Data() {
//        PbData.PbDataInfo.Builder pbData = PbData.PbDataInfo.newBuilder();
//
//        int nopbs = 3; //数量
//        List<PbPojo.PbPojoInfo.Builder> list = new ArrayList<>();
//        if (Convert.InRegion(0, 200, nopbs)) {
//            pbData.setNopbs(nopbs);
//
//            int defaultIndex = 0;//默认的起始点
//            for (int i = 0; i < nopbs; i++) {
//                int batterysNo = i + 1;//电池子系统号
//
//                PbPojo.PbPojoInfo.Builder pbPojo = PbPojo.PbPojoInfo.newBuilder();
//                //判断缓存中是否有电池数据，如果有，则更新到电池单体电压列表中
//                for (PbPojo.PbPojoInfo.Builder pbItem : list) {
//                    if (pbItem.getBatterysNo() == batterysNo) {
//                        pbPojo = pbItem;
//                        break;
//                    }
//                }
//
//                if (Convert.InRegion(1, 250, batterysNo)) {
//                    pbPojo.setBatterysNo(batterysNo);
//                } else {
//                    System.out.println("可充电储能子系统号" + batterysNo);
//                }
//
//                int pbVoltage = 300;//动力蓄电池电压
//                if (Convert.InRegion(0, 10000, pbVoltage) || Convert.isExceptionOrInvalid(2, pbVoltage)) {
//                    pbPojo.setPbVoltage(pbVoltage);
//                } else {
//                    System.out.println("可充电储能装置电压" + pbVoltage);
//                }
//
//                int pbCurrent = 300;//动力蓄电池电流
//                if (Convert.InRegion(0, 20000, pbCurrent)) {
//                    pbPojo.setPbCurrent(pbCurrent - 10000);
//                } else if (Convert.isExceptionOrInvalid(2, pbCurrent)) {
//                    pbPojo.setPbCurrent(pbCurrent);
//                } else {
//                    System.out.println("可充电储能装置电流" + pbCurrent);
//                }
//
//                int tnosb = 300;//单体蓄电池总数
//                if (Convert.InRegion(0, 65531, tnosb) || Convert.isExceptionOrInvalid(2, tnosb)) {
//                    pbPojo.setTnosb(tnosb);
//                } else {
//                    System.out.println("单体电池总数" + tnosb);
//                }
//
//                int snotfsb = 30;//本帧起始电池序号
//                if (Convert.InRegion(1, 65531, snotfsb)) {
//                    pbPojo.setSnotfsb(snotfsb);
//                } else {
//                    System.out.println("本帧起始电池序号" + snotfsb);
//                }
//
//                int tnofscb = 10;//本帧单体电池总数
//                if (Convert.InRegion(1, 200, tnofscb)) {
//                    pbPojo.setSnotfsb(tnofscb);
//                } else {
//                    System.out.println("本帧单体电池总数" + tnofscb);
//                }
//
//                //判断是否要分包。按照本帧起始电池序号+本帧单体电池总数<单体蓄电池总数为依据，
////                if ((tnofscb + snotfsb) < tnosb) {
////                    vehicleRTTopicBean.setIsMultiPacket(true);
////                } else {
////                    vehicleRTTopicBean.setIsMultiPacket(false);
////                }
//
//                for (int h = 0; h < tnofscb; h++) {
//                    int sbVoltage = 50000;//单体蓄电池电压
//                    if (Convert.InRegion(0, 60000, tnofscb) || Convert.isExceptionOrInvalid(2, sbVoltage)) {
//                        pbPojo.addSbVoltage(sbVoltage);
//                    } else {
//                        System.out.println("单体蓄电池电压" + tnofscb);
//                    }
//                }
//                defaultIndex += 10 + tnofscb * 2;//遍历每个充电储能子系统电压数据包的长度为固定10+tnofscb*2个字节。
//                list.add(pbPojo);
//                pbData.addList(pbPojo);
//            }
//        }
//
//        return pbData;
//    }
//
//    /**
//     * 09可充电储能装置温度数据
//     *
//     * @return
//     */
//    private DbptData.DbptDataInfo.Builder gb09Data() {
//        DbptData.DbptDataInfo.Builder dbptData = DbptData.DbptDataInfo.newBuilder();
//        int nopbs = 3; //电池子系统个数
//        if (Convert.InRegion(1, 250, nopbs) || Convert.isExceptionOrInvalid(1, nopbs)) {
//            dbptData.setNopbs(nopbs);
//
//            for (int i = 0; i < nopbs; i++) {
//                DbptPojo.DbptPojoInfo.Builder dbptPojo = DbptPojo.DbptPojoInfo.newBuilder();
//                int batterysNo = i + 1;//电池子系统号
//                if (Convert.InRegion(1, 250, batterysNo)) {
//                    dbptPojo.setBatterysNo(batterysNo);
//                } else {
//                    System.out.println("可充电子系统个数超出范围" + batterysNo);
//                }
//
//                int batterytp = 2;//温度探针个数
//                if (Convert.InRegion(1, 65531, batterytp) || Convert.isExceptionOrInvalid(2, batterytp)) {
//                    dbptPojo.setBatterytp(batterytp);
//                    for (int h = 0; h < batterytp; h++) {
//                        int ttbatterytp = 100;//单体蓄电池电压
//                        if (Convert.InRegion(1, 250, ttbatterytp)) {
//                            dbptPojo.addTtBatteryList(ttbatterytp - 40);
//                        } else if (Convert.isExceptionOrInvalid(1, ttbatterytp)) {
//                            dbptPojo.addTtBatteryList(ttbatterytp);
//                        }
//                    }
//                } else {
//                    System.out.println("温度探针个数" + batterysNo);
//                }
//                dbptData.addList(dbptPojo);
//            }
//        }
//
//        return dbptData;
//    }
//}
