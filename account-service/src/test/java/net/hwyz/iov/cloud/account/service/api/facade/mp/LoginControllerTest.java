package net.hwyz.iov.cloud.account.service.api.facade.mp;

import cn.hutool.core.collection.ListUtil;
import net.hwyz.iov.cloud.account.service.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 登录相关接口测试类
 */
@AutoConfigureMockMvc
public class LoginControllerTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    private final String path = "/mp/login";

    @Test
    @DisplayName("发送登录验证码")
    public void testSendVerifyCode() throws Exception {
        MultiValueMap<String, String> content = new LinkedMultiValueMap<>();
        content.put("countryRegionCode", ListUtil.of("+86"));
        content.put("mobile", ListUtil.of("13000000000"));
        mockMvc.perform(MockMvcRequestBuilders
                        .post(path + "/sendVerifyCode")
                        .params(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("验证码登录")
    public void testVerifyCodeLogin() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("deviceId", "device");
        MultiValueMap<String, String> content = new LinkedMultiValueMap<>();
        content.put("countryRegionCode", ListUtil.of("+86"));
        content.put("mobile", ListUtil.of("13000000000"));
        content.put("verifyCode", ListUtil.of("111111"));
        mockMvc.perform(MockMvcRequestBuilders
                        .post(path + "/verifyCodeLogin")
                        .headers(headers)
                        .params(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
