package com.hbl.global.controller.system;

import com.hbl.global.controller.BaseController;
import com.hbl.global.entity.RequestResultModel;
import com.hbl.global.entity.system.LoginInfo;
import com.hbl.global.entity.system.SysUser;
import com.hbl.global.service.system.LoginService;
import com.hbl.global.service.system.RoleService;
import com.hbl.global.service.system.UserService;
import com.hbl.global.utils.KeywordImg;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 系统管理
 * 
 * @author founder
 * 
 */
@Controller
@RequestMapping("/login/")
public class LoginController extends BaseController {

    protected final Log logger = LogFactory.getLog(LoginController.class);

	@Autowired
	private LoginService loginService;

	/**
	 * 用户登录认证
	 * 
	 * @throws Exception
	 */
	/**
	 * @throws Exception
	 */
	@RequestMapping("/checkAuth.do")
    @ResponseBody
	public RequestResultModel checkAuth(HttpServletRequest request, @ModelAttribute LoginInfo loginInfo) throws Exception {
        String userId = loginInfo.getUserId();
        String password = loginInfo.getPassword();
        String keyword = loginInfo.getKeyword();
		if (null == userId) {
			setErrorResult("请输入用户名");
			return result;
		}
		userId = userId.trim();

		if (null == password) {
			setErrorResult("请输入密码");
			return result;
		}

		password = password.trim();

		if (null == keyword) {
			setErrorResult("请输入验证码");
			return result;
		}
		keyword = keyword.trim();
		if (!keyword.equalsIgnoreCase(request.getSession().getAttribute("keyword").toString())) {
			setErrorResult("您输入的验证码不正确");
			return result;
		}

		SysUser sysUserParam = new SysUser();
		sysUserParam.setPassword(password);
		sysUserParam.setUserId(userId);
		sysUserParam.setDelFlg("0");

		SysUser user = loginService.checkAuth(sysUserParam);
		if (null != user) {
			/*List<SysRole> roleList=userService.getRoleListByUserId(user);

			List<SysPermiss> permissList=new ArrayList<SysPermiss>();
			//获得角色所具有的的权限
			for(int i=0;roleList!=null&&i<roleList.size();i++){
				SysRole role = roleList.get(i);

				List<SysPermiss> pmTmpList=roleService.getPermissListByRoleId(role);

				if(pmTmpList!=null&&pmTmpList.size()>0)
					permissList.addAll(pmTmpList);
			}
			//获得用户所特有的权限
			sysUserParam = new SysUser();
			sysUserParam.setUserId(userId);
			List<SysPermiss> sysPermissList= userService.getPermissListByUserId(sysUserParam);
			if(!permissList.containsAll(sysPermissList)){
				permissList.addAll(sysPermissList);
			}*/

            request.getSession().setAttribute("userId", user.getUserId());
            request.getSession().setAttribute("userName", user.getUserName());
			request.getSession().setAttribute("cityId", user.getCityId());
            //request.getSession().setAttribute("roleList", roleList);
		} else{
			setErrorResult("您输入的用户名或密码不正确");
			return result;
		}
		setSuccessResult(null,"登录成功!");
		return result;
	}

	/**
	 * 注销登录
	 *
	 * @return
	 */
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		//logger.info("logout ....");
		request.getSession().removeAttribute("userId");
		request.getSession().removeAttribute("userName");
		request.getSession().removeAttribute("roleList");
		request.getSession().removeAttribute("permissList");
		request.getSession().invalidate();
		return "page/login.html";
	}

	@RequestMapping("/index.do")
	public String goIndex(){
		return "page/index.html";
	}

    @RequestMapping("/indexTab.do")
    public String goIndexTab(){
        return "page/index.html";
    }
	/**
	 * 生成验证码
	 *
	 * @throws IOException
	 */
	@RequestMapping("/keyword.do")
	public void keyword(HttpServletResponse response,HttpServletRequest request) throws IOException {
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 在内存中创建图象
		int width = 114, height = 42;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		// g.setColor(getRandColor(200,250));
		g.setColor(new Color(250, 250, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		// 画边框
		// g.setColor(new Color());
		// g.drawRect(0,0,width-1,height-1);
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		// g.setColor(getRandColor(160,200));
		g.setColor(new Color(250, 250, 250));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = KeywordImg.getRandomString();// 韩剑锋 注释于 2008-01-26--
			sRand += rand;
			// 将认证码显示到图象中
			// g.setColor(new
			// Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			g.setColor(new Color(0, 0, 0));
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 20 * i + 20, 29);
		}
		// 将认证码存入SESSION
		request.getSession().setAttribute("keyword", sRand);
		// 图象生效
		g.dispose();
		// 输出图象到页面
		//ImageIO.write(image, "JPEG", response.getOutputStream());
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
		encoder.encode(image);
	}
}