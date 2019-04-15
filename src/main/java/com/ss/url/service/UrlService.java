package com.ss.url.service;

import com.ss.url.bean.Url;
import org.apache.ibatis.annotations.Param;

public interface UrlService {

    Url saveUrl(Url url);


}
