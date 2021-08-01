package com.company.mapper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MapperMediator implements ApplicationContextAware, InitializingBean {

    private CardMapper cardMapper;

    private AccountMapper accountMapper;

    private ApplicationContext applicationContext;

    @PostConstruct
    protected void init(){
        cardMapper = applicationContext.getBean(CardMapper.class);
        accountMapper = applicationContext.getBean(AccountMapper.class);
    }

    public CardMapper getCardMapper() {
        return cardMapper;
    }

    public AccountMapper getAccountMapper() {
        return accountMapper;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        cardMapper = applicationContext.getBean(CardMapper.class);
//        accountMapper = applicationContext.getBean(AccountMapper.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
