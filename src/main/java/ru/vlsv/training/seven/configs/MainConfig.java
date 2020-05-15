package ru.vlsv.training.seven.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * GeekBrains Java, training.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 14.05.2020
 * @link https://github.com/Centnerman
 */

@Configuration
@PropertySource("classpath:private.properties")
@ComponentScan("ru.vlsv.training.seven")
public class MainConfig implements WebMvcConfigurer {
}
