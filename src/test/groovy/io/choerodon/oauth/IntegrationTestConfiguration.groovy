package io.choerodon.oauth

import io.choerodon.oauth.api.service.SystemSettingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.core.StringRedisTemplate
import spock.mock.DetachedMockFactory

@TestConfiguration
class IntegrationTestConfiguration {

    private final detachedMockFactory = new DetachedMockFactory()

    @Autowired
    TestRestTemplate testRestTemplate

    @Bean
    StringRedisTemplate stringRedisTemplate() {
        return detachedMockFactory.Mock(StringRedisTemplate)
    }

    @Bean
    @Primary
    SystemSettingService systemSettingService() {
        return detachedMockFactory.Mock(SystemSettingService)
    }
}
