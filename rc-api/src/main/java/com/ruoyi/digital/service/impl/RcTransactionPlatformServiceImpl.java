package com.ruoyi.digital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.digital.mapper.RcTransactionPlatformMapper;
import com.ruoyi.digital.domain.RcTransactionPlatform;
import com.ruoyi.digital.service.IRcTransactionPlatformService;
import com.ruoyi.common.core.text.Convert;

/**
 * 交易所信息Service业务层处理
 * 
 * @author xiaoyu
 * @date 2020-10-22
 */
@Service
public class RcTransactionPlatformServiceImpl implements IRcTransactionPlatformService 
{
    @Autowired
    private RcTransactionPlatformMapper rcTransactionPlatformMapper;

    /**
     * 查询交易所信息
     * 
     * @param id 交易所信息ID
     * @return 交易所信息
     */
    @Override
    public RcTransactionPlatform selectRcTransactionPlatformById(Long id)
    {
        return rcTransactionPlatformMapper.selectRcTransactionPlatformById(id);
    }

    /**
     * 查询交易所信息列表
     * 
     * @param rcTransactionPlatform 交易所信息
     * @return 交易所信息
     */
    @Override
    public List<RcTransactionPlatform> selectRcTransactionPlatformList(RcTransactionPlatform rcTransactionPlatform)
    {
        return rcTransactionPlatformMapper.selectRcTransactionPlatformList(rcTransactionPlatform);
    }

    /**
     * 新增交易所信息
     * 
     * @param rcTransactionPlatform 交易所信息
     * @return 结果
     */
    @Override
    public int insertRcTransactionPlatform(RcTransactionPlatform rcTransactionPlatform)
    {
        rcTransactionPlatform.setCreateTime(DateUtils.getNowDate());
        return rcTransactionPlatformMapper.insertRcTransactionPlatform(rcTransactionPlatform);
    }

    /**
     * 修改交易所信息
     * 
     * @param rcTransactionPlatform 交易所信息
     * @return 结果
     */
    @Override
    public int updateRcTransactionPlatform(RcTransactionPlatform rcTransactionPlatform)
    {
        return rcTransactionPlatformMapper.updateRcTransactionPlatform(rcTransactionPlatform);
    }

    /**
     * 删除交易所信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRcTransactionPlatformByIds(String ids)
    {
        return rcTransactionPlatformMapper.deleteRcTransactionPlatformByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除交易所信息信息
     * 
     * @param id 交易所信息ID
     * @return 结果
     */
    @Override
    public int deleteRcTransactionPlatformById(Long id)
    {
        return rcTransactionPlatformMapper.deleteRcTransactionPlatformById(id);
    }
}
