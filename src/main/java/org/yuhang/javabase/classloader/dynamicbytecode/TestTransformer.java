package org.yuhang.javabase.classloader.dynamicbytecode;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;


/**
 * TestTransformer实现ClassFileTransformer接口，重写transform方法实现动态替换class
 */
public class TestTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("Transforming "+className);
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.get("org.yuhang.javabase.classloader.dynamicbytecode.Base");
            CtMethod ctMethod = ctClass.getDeclaredMethod("process");
            ctMethod.insertBefore("{System.out.println(\"start\"); }");
            ctMethod.insertAfter("{System.out.println(\"end\"); }");
            return ctClass.toBytecode();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new byte[0];
    }
}
