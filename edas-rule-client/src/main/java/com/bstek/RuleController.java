package com.bstek;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.response.RuleExecutionResponse;
import com.bstek.urule.runtime.service.KnowledgeService;

@RestController
@RequestMapping("rule")
public class RuleController {
	
	@RequestMapping("/ageRule")
    public RuleExecutionResponse rule(@RequestParam String age) throws IOException {
    	//创建一个KnowledgeSession对象
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("edas/user_package");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Map<String, Object> param = new HashMap<>();
        param.put("age", age);
        RuleExecutionResponse result = session.fireRules(param);

        System.out.println("年龄：" + session.getParameter("age"));
        return result;
    }
}
