package com.irdaislakhuafa.simplesendemailmjml.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ditsche.mailo.config.MailoConfig;
import dev.ditsche.mailo.config.SmtpConfig;
import dev.ditsche.mailo.provider.MailProvider;
import dev.ditsche.mailo.provider.SmtpMailProvider;

@Configuration
public class MailConfiguration {
    @Value(value = "${mjml.mail.host}")
    private String HOST;

    @Value(value = "${mjml.mail.username}")
    private String USERNAME;

    @Value(value = "${mjml.mail.password}")
    private String PASSWORD;

    @Value(value = "${mjml.mail.port}")
    private int PORT;

    @Value(value = "${mjml.io.app.id}")
    private String APP_ID;

    @Value(value = "${mjml.io.app.secret}")
    private String APP_SECRET;

    public MailConfiguration() {
    }

    @Bean
    public MailProvider mailProvider() {
        var mail = MailoConfig.get();
        mail.setMjmlAppId(APP_ID);
        mail.setMjmlAppSecret(APP_SECRET);

        var smtpConfig = new SmtpConfig() {
            {
                setHost(HOST);
                setPort(PORT);
                setUsername(USERNAME);
                setPassword(PASSWORD);
            }
        };
        return new SmtpMailProvider(smtpConfig);
    }
}
