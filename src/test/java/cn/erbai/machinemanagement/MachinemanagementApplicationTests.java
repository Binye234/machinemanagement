package cn.erbai.machinemanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class MachinemanagementApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 测试时间戳
     */
    @Test
    public void timeTest(){
        long l= new Date().getTime();
        System.out.println(l);
        Date date = new Date(l);
        System.out.println(date.toString());
    }

}
