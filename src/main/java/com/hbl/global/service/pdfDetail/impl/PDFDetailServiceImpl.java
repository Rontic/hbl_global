package com.hbl.global.service.pdfDetail.impl;

import com.hbl.global.dao.commonDao.CommonDao;
import com.hbl.global.entity.module.PDFDetail;
import com.hbl.global.service.base.impl.BaseServiceImpl;
import com.hbl.global.service.pdfDetail.PDFDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class PDFDetailServiceImpl extends BaseServiceImpl implements PDFDetailService {

    @Autowired
    private CommonDao commonDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int savePdfs(List<PDFDetail> pdfDetails) {
        HashMap<String,List<PDFDetail>> map = new HashMap<>();
        map.put("pdfDetails",pdfDetails);
        return commonDao.save("PDFDetail.savePDFDetail",map);
    }

    @Override
    public List<PDFDetail> getPDFlist(String moduleId) {
        return commonDao.selectList("PDFDetail.getPDFlist",moduleId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int insertList(List<PDFDetail> fileList) {
        return commonDao.save("PDFDetail.insertList",fileList);
    }
}
