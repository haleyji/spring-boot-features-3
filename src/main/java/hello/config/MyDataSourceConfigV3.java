package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertiesV2;
import hello.datasource.MyDataSourcePropertiesV3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableConfigurationProperties(MyDataSourcePropertiesV3.class)
public class MyDataSourceConfigV3 {
    private final MyDataSourcePropertiesV3 propertiesV3;

    public MyDataSourceConfigV3(MyDataSourcePropertiesV3 propertiesV3) {
        this.propertiesV3 = propertiesV3;
    }

    @Bean
    public MyDataSource myDataSource(){
        return new MyDataSource(propertiesV3.getUrl(), propertiesV3.getUsername(), propertiesV3.getPassword(),
                propertiesV3.getEtc().getMaxConnection(), propertiesV3.getEtc().getTimeout(), propertiesV3.getEtc().getOptions());
    }
}
