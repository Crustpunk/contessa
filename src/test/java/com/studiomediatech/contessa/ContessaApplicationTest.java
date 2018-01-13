package com.studiomediatech.contessa;

import com.studiomediatech.contessa.app.ContessaApplication;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class ContessaApplicationTest {

    @Test
    public void contextLoads() {

        // Should just not err!
        ContessaApplication.main(new String[] { "--contessa.base-dir=some-dir" });
    }
}
