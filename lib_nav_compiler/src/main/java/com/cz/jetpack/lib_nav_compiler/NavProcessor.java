package com.cz.jetpack.lib_nav_compiler;

import com.alibaba.fastjson.JSONObject;
import com.cz.jetpack.lib_nav_annotation.ActivityDestination;
import com.cz.jetpack.lib_nav_annotation.FragmentDestination;
import com.google.auto.service.AutoService;

import org.graalvm.compiler.serviceprovider.ServiceProvider;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;


@AutoService(Process.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"com.cz.jetpack.lib_nav_annotation.ActivityDestination",
        "com.cz.jetpack.lib_nav_annotation.FragmentDestination"})
public class NavProcessor extends AbstractProcessor {
    Messager messager;
    Filer filer;
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
        filer = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<? extends Element> fragmentElements = roundEnvironment.getElementsAnnotatedWith(FragmentDestination.class);
        Set<? extends Element> activityElements = roundEnvironment.getElementsAnnotatedWith(ActivityDestination.class);

        if(!fragmentElements.isEmpty() || !activityElements.isEmpty()) {

            HashMap<String, JSONObject> destMap = new HashMap<>();
            handleDestination(fragmentElements,FragmentDestination.class,destMap);
        }
        return true;
    }

    private void handleDestination(Set<? extends Element> fragmentElements, Class<? extends Annotation> AnnotationClass, HashMap<String, JSONObject> destMap) {
    }
}
