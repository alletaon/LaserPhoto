package com.karev.kvantron.util;

import com.karev.kvantron.model.Glass;
import com.karev.kvantron.model.ListPicturesWrapper;
import com.karev.kvantron.model.Picture;
import javafx.scene.image.Image;
import org.apache.logging.log4j.core.util.FileUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileUtil {
    public static void saveGlassToFile(Glass glass, File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(Glass.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(glass, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Glass loadGlassFromFile(File file){
        try {
            JAXBContext context = JAXBContext.newInstance(Glass.class);
            Unmarshaller um = context.createUnmarshaller();
            return (Glass) um.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void savePicturesToFile(ListPicturesWrapper picturesWrapper, File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(ListPicturesWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(picturesWrapper, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static ListPicturesWrapper loadPicturesFromFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(ListPicturesWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            return (ListPicturesWrapper) um.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addFilesToZip(File directory, File zip) {
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip));

            for (File file : directory.listFiles()) {
                System.out.println(file.getName());
                if (file.isDirectory()) {
                    ZipEntry entry = new ZipEntry(file.getName() + "/");
                    out.putNextEntry(entry);
                    out.closeEntry();
                    for (File subFile : file.listFiles()) {
                        ZipEntry subEntry = new ZipEntry(entry.getName() + subFile.getName());
                        out.putNextEntry(subEntry);
                        FileInputStream fis = new FileInputStream(subFile);
                        byte[] buffer = new byte[4092];
                        int byteCount;
                        while ((byteCount = fis.read(buffer)) != -1) {
                            out.write(buffer, 0, byteCount);
                        }
                        fis.close();
                    }
                } else {
                    ZipEntry entry = new ZipEntry(file.getName());
                    out.putNextEntry(entry);
                    FileInputStream fis = new FileInputStream(file);
                    byte[] buffer = new byte[4092];
                    int byteCount;
                    while ((byteCount = fis.read(buffer)) != -1) {
                        out.write(buffer, 0, byteCount);
                    }
                    fis.close();
                }
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unzipToDir(File source, File targetDir) {
        try {
            ZipInputStream inputStream = new ZipInputStream(new FileInputStream(source));
            ZipEntry entry = inputStream.getNextEntry();
            while (entry != null) {
                if (entry.isDirectory()) {
                    File subDir = createSubDir(targetDir, entry.getName());
                } else {
                    FileOutputStream fos = new FileOutputStream(new File(targetDir, entry.getName()));
                    byte[] buffer = new byte[4092];
                    int byteCount;
                    while ((byteCount = inputStream.read(buffer)) != -1) {
                        fos.write(buffer, 0, byteCount);
                    }
                    fos.flush();
                    fos.close();
                }
                inputStream.closeEntry();
                entry = inputStream.getNextEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearDirectory(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                for (File subFile : file.listFiles()){
                    subFile.delete();
                }
            }
            file.delete();
        }
        directory.delete();
    }

    public static void copyFilesToDir(List<File> files, File dir) {
        try {
            for (File file : files) {
                Files.copy(Paths.get(file.toURI()), Paths.get(new File(dir, file.getName()).toURI()),
                        StandardCopyOption.REPLACE_EXISTING);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static File createWorkDirectory() {
        String appData = System.getenv("AppData");
        File result = new File(appData + "\\LaserPhoto\\" + Long.toHexString(System.currentTimeMillis()));
        if (!result.mkdirs()) {
            result = null;
        }
        return result;
    }

    public static File createSubDir(File sorceDir, String subDirName) {
        File result = new File(sorceDir, subDirName);
        if (!result.mkdirs()) {
            result = null;
        }
        return result;
    }


    public static List<Picture> updatePicturesFromDir(File dir) {
        List<Picture> pictures = new ArrayList<>();
        System.out.println(dir.listFiles());
        for (File file : dir.listFiles()) {
            pictures.add(new Picture(new Image(file.toURI().toString()), file.getName(), 0.0, 0.0, 0.0));
        }
        return pictures;
    }


}
