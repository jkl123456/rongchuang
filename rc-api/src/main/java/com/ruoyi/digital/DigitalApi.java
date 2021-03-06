package com.ruoyi.digital;


import com.ruoyi.common.Result;
import com.ruoyi.common.utils.redis.RedisService;
import com.ruoyi.digital.service.IRcDigitalService;
import com.ruoyi.digital.service.IRcExchangeRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * 首页货币信息接口
 * @author xiaoxia
 */
@Api("首页货币信息接口")
@RestController
@RequestMapping("/rc-api/digital")
public class DigitalApi {

    @Autowired
    private IRcDigitalService rcService;

    @Autowired
    private RedisService redisService;
    @Autowired
    private IRcExchangeRateService rcExchangeRateService;

    @ApiOperation("获取货币信息接口")
    @ApiImplicitParams(
            {

            })
    @PostMapping("/getRateList")
    public Result getRateList(HttpServletRequest request) {
        return rcService.getRateList();
    }

    @ApiOperation("查询首页最新上市列表接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "int", name = "pageNum", value = "当前页号", required = true),
                    @ApiImplicitParam(dataType = "int", name = "pageSize", value = "每页大小", required = true),
                    @ApiImplicitParam(dataType = "int", name = "byName", value = "1-全球指数 2-24H涨幅 默认传0", required = true),
                    @ApiImplicitParam(dataType = "int", name = "byType", value = "1-升序 2-降序 默认传0", required = true)
            })
    @PostMapping("/getMarketList")
    public Result getMarketList(HttpServletRequest request,
                                @RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10")Integer pageSize,
                                @RequestParam(defaultValue = "0")Integer byName,
                                @RequestParam(defaultValue = "0")Integer byType) {
        return rcService.getMarketList(pageNum,pageSize,byName,byType);
    }

    @ApiOperation("查询首页成交榜额列表接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "int", name = "pageNum", value = "当前页号", required = true),
                    @ApiImplicitParam(dataType = "int", name = "pageSize", value = "每页大小", required = true),
                    @ApiImplicitParam(dataType = "int", name = "byName", value = "1-24H涨幅 默认传0", required = true),
                    @ApiImplicitParam(dataType = "int", name = "byType", value = "1-升序 2-降序 默认传0", required = true)
            })
    @PostMapping("/getClinchList")
    public Result getClinchList(HttpServletRequest request,
                                @RequestParam(defaultValue = "1")Integer pageNum,
                                @RequestParam(defaultValue = "10")Integer pageSize,
                                @RequestParam(defaultValue = "0")Integer byName,
                                @RequestParam(defaultValue = "0")Integer byType) {
        return rcService.getClinchList(pageNum,pageSize,byName,byType);
    }

    @ApiOperation("查询首页市值行情列表接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "int", name = "pageNum", value = "当前页号", required = true),
                    @ApiImplicitParam(dataType = "int", name = "pageSize", value = "每页大小", required = true),
                    @ApiImplicitParam(dataType = "int", name = "byName", value = "1-市值 2-最新价 3-24H涨幅 默认0可不传", required = true),
                    @ApiImplicitParam(dataType = "int", name = "byType", value = "1-升序 2-降序 默认0可不传", required = true)
            })
    @PostMapping("/getDataList")
    public Result getDataList(HttpServletRequest request,
                              @RequestParam(defaultValue = "1")Integer pageNum,
                              @RequestParam(defaultValue = "10")Integer pageSize,
                              @RequestParam(defaultValue = "0")Integer byName,
                              @RequestParam(defaultValue = "0")Integer byType) {
        return rcService.getDataList(pageNum,pageSize,byName,byType);
    }

    @ApiOperation("查询首页交易所列表接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "int", name = "pageNum", value = "当前页号", required = true),
                    @ApiImplicitParam(dataType = "int", name = "pageSize", value = "每页大小", required = true),
                    @ApiImplicitParam(dataType = "int", name = "byName", value = "1-持有资产 2-24H涨幅 默认0可不传", required = true),
                    @ApiImplicitParam(dataType = "int", name = "byType", value = "1-升序 2-降序 默认0可不传", required = true)
            })
    @PostMapping("/getPlatformList")
    public Result getPlatformList(HttpServletRequest request,
                                  @RequestParam(defaultValue = "1")Integer pageNum,
                                  @RequestParam(defaultValue = "10")Integer pageSize,
                                  @RequestParam(defaultValue = "0")Integer byName,
                                  @RequestParam(defaultValue = "0")Integer byType) {
        return rcService.getPlatformList(pageNum,pageSize,byName,byType);
    }

    @ApiOperation("查询币种详情接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "String", name = "code", value = "code", required = true)
            })
    @PostMapping("/getInfoByCode")
    public Result getInfoByCode(HttpServletRequest request, String code) {
        return rcService.getInfoByCode(code);
    }

    @ApiOperation("查询币种详情折线图接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "String", name = "code", value = "code", required = true),
                    @ApiImplicitParam(dataType = "String", name = "type", value = "所有=all 24H=d 一周=w 3月=3m 今年=ydt 1年=y", required = true),
            })
    @PostMapping("/getInfoByCodeData")
    public Result getInfoByCodeData(HttpServletRequest request, String code, String type) {
        return rcService.getInfoByCodeData(code,type);
    }

}
