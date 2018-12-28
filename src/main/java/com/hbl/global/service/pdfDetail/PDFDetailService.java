package com.hbl.global.service.pdfDetail;


import com.hbl.global.entity.module.PDFDetail;
import com.hbl.global.service.base.BaseService;
import java.util.List;

public interface PDFDetailService extends BaseService {
    public int savePdfs(List<PDFDetail> pdfDetails);

    public List<PDFDetail> getPDFlist(String moduleId);

    public int insertList(List<PDFDetail> fileList);
}
