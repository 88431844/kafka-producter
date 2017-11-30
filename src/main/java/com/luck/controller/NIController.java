package com.luck.controller;

import com.luck.dto.CommonRespondDto;
import com.luck.dto.FaultCodeDto;
import com.luck.dto.OvertimeParkDto;
import com.luck.dto.StayInAreaDto;
import com.luck.service.NiService;
import com.luck.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 为NI造数据controller
 * @Author miracle
 * @Date 2017/11/30 0030 9:50
 */
@Controller
@RequestMapping("/ni")
public class NIController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NiService niService;

    /**
     * 添加停留时长
     * @param stayInAreaDto
     * @return
     */
    @RequestMapping("/addStayInArea")
    @ResponseBody
    public CommonRespondDto addStayInArea(@RequestBody StayInAreaDto stayInAreaDto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("NIController addStayInArea request parm :{}", stayInAreaDto.toString());
        try {
            niService.addStartInArea(stayInAreaDto);
            commonRespondDto.setCode(Const.SUCCESS_CODE);
            commonRespondDto.setMsg(Const.SUCCESS_MSG);
        }catch (Exception e){
            logger.error("NIController addStayInArea error");
            commonRespondDto.setCode(Const.FAIL_CODE);
            commonRespondDto.setMsg(Const.FAIL_MSG);
            e.printStackTrace();
            return commonRespondDto;
        }
        return commonRespondDto;
    }

    /**
     * 添加滞留超时
     * @param overtimeParkDto
     * @return
     */
    @RequestMapping("/addOvertimePark")
    @ResponseBody
    public CommonRespondDto addOvertimePark(@RequestBody OvertimeParkDto overtimeParkDto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("NIController addOvertimePark request parm :{}", overtimeParkDto.toString());
        try {
            niService.addOvertimePark(overtimeParkDto);
            commonRespondDto.setCode(Const.SUCCESS_CODE);
            commonRespondDto.setMsg(Const.SUCCESS_MSG);
        }catch (Exception e){
            logger.error("NIController addOvertimePark error");
            commonRespondDto.setCode(Const.FAIL_CODE);
            commonRespondDto.setMsg(Const.FAIL_MSG);
            e.printStackTrace();
            return commonRespondDto;
        }
        return commonRespondDto;
    }

    /**
     * 添加故障码
     * @param faultCodeDto
     * @return
     */
    @RequestMapping("/addFaultCode")
    @ResponseBody
    public CommonRespondDto addFaultCode(@RequestBody FaultCodeDto faultCodeDto){
        CommonRespondDto commonRespondDto = new CommonRespondDto();
        logger.info("NIController addFaultCode request parm :{}", faultCodeDto.toString());
        try {
            niService.addFaultCode(faultCodeDto);
            commonRespondDto.setCode(Const.SUCCESS_CODE);
            commonRespondDto.setMsg(Const.SUCCESS_MSG);
        }catch (Exception e){
            logger.error("NIController addFaultCode error");
            commonRespondDto.setCode(Const.FAIL_CODE);
            commonRespondDto.setMsg(Const.FAIL_MSG);
            e.printStackTrace();
            return commonRespondDto;
        }
        return commonRespondDto;
    }
}
