package com.lomo.controller;

import com.lomo.entity.UserEntity;
import com.lomo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录及首页控制器
 * @author lomo
 * @create 2017-03-29 16:03
 **/
@Controller
public class IndexController {
  private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

  @Resource
  private UserService userService;

  @GetMapping("/login")
  public String loginGet(Model model) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUserName("tom");
    userEntity.setHideInfo("隐藏？");
    model.addAttribute("userEntity", userEntity);
    return "/login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute UserEntity userEntity, RedirectAttributes redirectAttributes) {
    Subject currentUser = SecurityUtils.getSubject();
    try {
      currentUser.login(new UsernamePasswordToken(userEntity.getUserName(), userEntity.getPassword()));
      return "redirect:/userList";
    } catch (AuthenticationException e) {
      String message = StringUtils.isBlank(e.getMessage()) ? "用户名或密码错误！" : e.getMessage();
      redirectAttributes.addFlashAttribute("message", message);
      return "redirect:/login";
    }
  }

  @GetMapping("/logout")
  public String logout(RedirectAttributes redirectAttributes) {
    SecurityUtils.getSubject().logout();
    redirectAttributes.addFlashAttribute("message", "您已安全退出系统！");
    return "redirect:/login";
  }

  @RequestMapping(value = "/403")
  public String unauthorizedRole() {
    return "/403";
  }

  @RequestMapping("/userList")
  public String userList(Model model) {
    logger.info("------------展示userList------------");
    List<UserEntity> userEntityList = userService.searchAllData();
    model.addAttribute("userEntityList", userEntityList);
    return "/user";
  }
}
