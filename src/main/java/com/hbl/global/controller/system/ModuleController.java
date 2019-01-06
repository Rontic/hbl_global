package com.hbl.global.controller.system;

import com.hbl.global.controller.BaseController;
import com.hbl.global.entity.RequestResultModel;
import com.hbl.global.entity.system.SysModule;
import com.hbl.global.entity.system.SysPermiss;
import com.hbl.global.entity.system.SysRole;
import com.hbl.global.entity.system.SysUser;
import com.hbl.global.service.system.LoginService;
import com.hbl.global.service.system.ModuleService;
import com.hbl.global.service.system.RoleService;
import com.hbl.global.service.system.UserService;
import com.hbl.global.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 李文武 on 2018/3/4.
 */
@Controller
@RequestMapping("/module/")
public class ModuleController extends BaseController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ModuleService moduleService;

    /**
     * 获取菜单树
     *
     * @throws Exception
     */
    @RequestMapping("/getNavigation.do")
    @ResponseBody
    public RequestResultModel getNavigation(HttpServletRequest request) throws Exception {
        String userId = (String) request.getSession().getAttribute("userId");

        SysUser sysUserParam = new SysUser();
        sysUserParam.setUserId(userId);
        List<SysRole> roleList = userService.getRoleListByUserId(sysUserParam);

        List<SysPermiss> permissList = new ArrayList<SysPermiss>();
        //获得角色所具有的的权限
        for (int i = 0; roleList != null && i < roleList.size(); i++) {
            SysRole role = roleList.get(i);

            List<SysPermiss> pmTmpList = roleService.getPermissListByRoleId(role);

            if (pmTmpList != null && pmTmpList.size() > 0)
                permissList.addAll(pmTmpList);
        }
        if (permissList == null || permissList.size() == 0) return null;
        String[] permissionIds = new String[permissList.size()];
        for (int i = 0; permissList != null && i < permissList.size(); i++) {
            SysPermiss sysPermiss = permissList.get(i);
            permissionIds[i] = sysPermiss.getPermissionId();
        }
        SysPermiss sysPermissParam = new SysPermiss();
        sysPermissParam.setPermissionIds(permissionIds);
        List<SysModule> modulList = loginService.getModuleListByPermissIds(sysPermissParam);

        List<SysModule> topModuleList = new ArrayList<SysModule>();
        List<SysModule> subModuleList = new ArrayList<SysModule>();
        for (int i = 0; modulList != null && i < modulList.size(); i++) {
            SysModule sysModule = modulList.get(i);
            if (sysModule.getModuleLevel() == 0) {
                topModuleList.add(sysModule);
            }
            if (sysModule.getModuleLevel() == 1) {
                subModuleList.add(sysModule);
            }
        }
        Map<String, Object> resMap = new HashMap<String, Object>();
        List<Object> topMenus = new ArrayList<Object>();
        for (int i = 0; topModuleList != null && i < topModuleList.size(); i++) {
            SysModule topModule = topModuleList.get(i);
            Map<String, Object> topMap = new HashMap<String, Object>();
            topMap.put("menuid", topModule.getModuleId());
            topMap.put("menuname", topModule.getModuleName());
            topMap.put("icon", topModule.getModuleIcon());
            topMap.put("uri", topModule.getModuleUrl());
            topMenus.add(topMap);
            List<Object> subMenus = new ArrayList<Object>();
            for (int j = 0; subModuleList != null && j < subModuleList.size(); j++) {
                SysModule subModule = subModuleList.get(j);
                if (subModule.getParentId() != null && subModule.getParentId().equals(topModule.getModuleId())) {
                    Map<String, Object> subMap = new HashMap<String, Object>();
                    subMap.put("menuid", subModule.getModuleId());
                    subMap.put("menuname", subModule.getModuleName());
                    subMap.put("icon", subModule.getModuleIcon());
                    subMap.put("url", subModule.getModuleUrl());
                    subMenus.add(subMap);
                }
            }
            topMap.put("menus", subMenus);
        }
        setSuccessResult(topMenus, "");
        return result;
    }

    @RequestMapping("/main.do")
    @ResponseBody
    public HashMap<String, Object> getIndexData() {
        HashMap<String, Object> resultData = new HashMap<>();
        return resultData;
    }

    @RequestMapping("/getThreeYearPoint.do")
    @ResponseBody
    public RequestResultModel getThreeYearPoint() {
        try {
            int toYear = Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()));
            List<String> dateArray = new LinkedList<>();
            List<String> numArray = new LinkedList<>();
            Properties point = PropertiesUtil.loadProperties("property/historyDo.properties");
            dateArray.add(toYear - 2 + "");
            numArray.add(point.getProperty(toYear - 2 + ""));
            dateArray.add(toYear - 1 + "");
            numArray.add(point.getProperty(toYear - 1 + ""));
            dateArray.add(toYear + "");
            numArray.add(moduleService.getRealPoint());
            HashMap<String, List> dateMap = new HashMap<>();
            dateMap.put("dateArray", dateArray);
            dateMap.put("numArray", numArray);
            setSuccessResult(dateMap, "查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            setErrorResult("查询失败");
        }
        return result;
    }
}
