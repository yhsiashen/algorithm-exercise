package org.yuhang.javabase.classloader;

import java.io.*;

public class YourClassLoader extends ClassLoader{
    String path;

    public YourClassLoader(String path){
//        super();
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getFileName(name);
        File file = new File(path,fileName);
        FileInputStream in = null;
        ByteArrayOutputStream ou = null;
        try {
            in = new FileInputStream(file);
            ou = new ByteArrayOutputStream();
            int len;
            while ((len = in.read())!= -1){
                ou.write(len);
            }
            byte[] bytes = ou.toByteArray();
            return defineClass(name,bytes,0,bytes.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(in!=null)
                    in.close();
                if(ou!=null)
                    ou.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return super.findClass(name);
    }

    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if(index == -1){
            return name+".class";
        }else{
            return name.substring(index+1)+".class";
        }
    }
}
