package com.ruoyi.home;


import com.ruoyi.common.Result;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.home.service.IHomeService;
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
 * 首页公告 轮播 系统消息 帮助接口
 * @author xiaoxia
 */
@Api("首页公告 轮播 系统消息 帮助接口")
@RestController
@RequestMapping("/rc-api/home")
public class HomeApi {

    @Autowired
    private IHomeService homeService;

    @ApiOperation("查询公告列表接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "int", name = "pageNum", value = "当前页号", required = true, defaultValue = "1"),
                    @ApiImplicitParam(dataType = "int", name = "pageSize", value = "每页大小", required = true, defaultValue = "100")
            })
    @PostMapping("/getNoticeList")
    public Result getNoticeList(HttpServletRequest request,
                                @RequestParam(defaultValue = "1")Integer pageNum,
                                @RequestParam(defaultValue = "10")Integer pageSize) {
        return homeService.getNoticeList(pageNum, pageSize);
    }

    @ApiOperation("查询公告详情接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "int", name = "id", value = "当前id", required = true)
            })
    @PostMapping("/getNoticeDetail")
    public Result getNoticeDetail(HttpServletRequest request, Integer id) {
        return homeService.getNoticeDetail(id);
    }

    @ApiOperation("查询最新公告接口")
    @ApiImplicitParams(
            {

            })
    @PostMapping("/getNewNotice")
    public Result getNewNotice(HttpServletRequest request) {
        return homeService.getNewNotice();
    }

    @ApiOperation("查询图片轮播接口")
    @ApiImplicitParams(
            {

            })
    @PostMapping("/getLunboList")
    public Result getLunboList(HttpServletRequest request) {
        return homeService.getLunboList();
    }

    @ApiOperation("查询系统消息接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "int", name = "pageNum", value = "当前页号", required = true),
                    @ApiImplicitParam(dataType = "int", name = "pageSize", value = "每页大小", required = true)
            })
    @PostMapping("/getInfoList")
    public Result getInfoList(HttpServletRequest request,
                              @RequestParam(defaultValue = "1")Integer pageNum,
                              @RequestParam(defaultValue = "10")Integer pageSize) {
        return homeService.getInfoList(pageNum,pageSize);
    }

    @ApiOperation("查询帮助列表接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "int", name = "pageNum", value = "当前页号", required = true),
                    @ApiImplicitParam(dataType = "int", name = "pageSize", value = "每页大小", required = true)
            })
    @PostMapping("/getHelpList")
    public Result getHelpList(HttpServletRequest request,
                              @RequestParam(defaultValue = "1")Integer pageNum,
                              @RequestParam(defaultValue = "10")Integer pageSize) {
        return homeService.getHelpList(pageNum, pageSize);
    }

    @ApiOperation("查询帮助详情接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(dataType = "int", name = "id", value = "当前id", required = true)
            })
    @PostMapping("/getHelpDetail")
    public Result getHelpDetail(HttpServletRequest request, Integer id) {
        return homeService.getHelpDetail(id);
    }

}
