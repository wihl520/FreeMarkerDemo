package com.example.freemarkerdemo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FreemarkerdemoApplicationTests {

    @Test
    public void contextLoads() {
        try {
            // 1. 创建配置类, 这个configuration是freemarker提供的, 不要导错包了
            Configuration configuration = new Configuration(Configuration.getVersion());
            //2.设置模板所在的目录,这里定义的就是刚刚test.ftl所存放的真实目录
            //注意这里是文件夹路径,不是文件路径
            String file = "E:/ProjectDemo/freemarkerdemo/src/main/resources/static/";
            configuration.setDirectoryForTemplateLoading(new File(file));
            //3.设置字符集
            configuration.setDefaultEncoding("utf-8");
            //4.加载模板
            Template template = configuration.getTemplate("index.html");
            //5.创建数据模型,就是用来填充模板那些插值的,可以用map,也可以定义对象,一般都是map,注意的是key需要跟插值中的对应上
            // 创建模板的数据Map
            Map map = getTemplateDataMap();

            //6.创建 Writer 对象,代表生成的源代码会存放到哪里
            Writer out = new FileWriter(new File("C:/Users/Administrator/Desktop/test.html"));
            //7.输出
            template.process(map, out);
            //8.关闭 Writer 对象,切记不要忘记关流,不然以上的数据都还是在内存中,需要refresh才可以持久化到磁盘,这是IO流的知识点.
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建模板数据Map
     * @return Map
     */
    private Map getTemplateDataMap() {
        Map map = new HashMap();
        map.put("name", "张三 ");
        map.put("message", "欢迎来到Freemarker！ ");
        List goodsList=new ArrayList();
        Map goods1=new HashMap();
        goods1.put("name", "苹果");
        goods1.put("price", 5.8);
        Map goods2=new HashMap();
        goods2.put("name", "香蕉");
        goods2.put("price", 2.5);
        Map goods3=new HashMap();
        goods3.put("name", "橘子");
        goods3.put("price", 3.2);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        map.put("goodsList", goodsList);
        return map;
    }

}
