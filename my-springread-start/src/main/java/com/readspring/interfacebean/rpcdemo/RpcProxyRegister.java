package com.readspring.interfacebean.rpcdemo;

import com.readspring.interfacebean.rpcdemo.annotation.RpcScan;
import com.readspring.interfacebean.rpcdemo.annotation.RpcService;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RpcProxyRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware, ResourceLoaderAware {
    private Environment environment;

    private ResourceLoader resourceLoader;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // class scanner：扫描指定路径，指定注解的 bean，注意重写 isCandidateComponent(AnnotatedBeanDefinition beanDefinition)，默认的规则不行
        ClassPathScanningCandidateComponentProvider classPathScanner =
            new ClassPathScanningCandidateComponentProvider(false, this.environment) {
                // isCandidateComponent(MetadataReader metadataReader) 已经根据注解筛选了 bean，这里需要根据 bean 定义筛选是否是我们需要的 bean
                @Override
                protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                    boolean isCandidate = false;
                    // 独立 + 接口类才行
                    if (beanDefinition.getMetadata().isIndependent()) {
                        if (beanDefinition.getMetadata().isInterface()) {
                            isCandidate = true;
                        }
                    }
                    return isCandidate;
                }
            };
        // class scanner：扫描的规则，基于注解类型扫描 --> isCandidateComponent(MetadataReader metadataReader) 这里根据主键筛选
        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(RpcService.class);
        classPathScanner.addIncludeFilter(annotationTypeFilter);

        // 获取注解信息 --> 找出扫描的包路径
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(RpcScan.class.getCanonicalName());
        Set<String> basePackages = new HashSet<>();

        for (String pkg : (String[]) attributes.get("value")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }
        for (String pkg : (String[]) attributes.get("basePackages")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }

        for (String pk : basePackages) {
            // 扫描
            Set<BeanDefinition> beanDefinitionSet = classPathScanner.findCandidateComponents(pk);
            for (BeanDefinition beanDefinition : beanDefinitionSet) {
                if (beanDefinition instanceof AnnotatedBeanDefinition) {
                    // 使用 FactoryBean#getObject 完成代理
                    BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(RpcFactoryBean.class);
                    definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

                    String interfaceType = ((AnnotatedBeanDefinition) beanDefinition).getMetadata().getClassName();

                    // 属性赋值
                    definition.addPropertyValue("type", interfaceType);

                    // 单例
                    definition.setScope("singleton");
                    AbstractBeanDefinition abstractBeanDefinition = definition.getBeanDefinition();

                    String beanName = interfaceType;
                    BeanDefinitionHolder holder = new BeanDefinitionHolder(abstractBeanDefinition, beanName, new String[]{beanName});
                    BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
                }
            }
        }
    }
}
