package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertiesV1;
import hello.datasource.MyDataSourcePropertiesV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableConfigurationProperties(MyDataSourcePropertiesV2.class)
public class MyDataSourceConfigV2 {
    private final MyDataSourcePropertiesV2 propertiesV2;

    public MyDataSourceConfigV2(MyDataSourcePropertiesV2 propertiesV2) {
        this.propertiesV2 = propertiesV2;
    }

    @Bean
    public MyDataSource myDataSource(){
        return new MyDataSource(propertiesV2.getUrl(), propertiesV2.getUsername(), propertiesV2.getPassword(),
                propertiesV2.getEtc().getMaxConnection(), propertiesV2.getEtc().getTimeout(), propertiesV2.getEtc().getOptions());
    }
}
